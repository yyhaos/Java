package test8;
import java.awt.*; 
import java.util.*; 
import javax.swing.*;
import java.text.*;
public class ShowTimeSample extends JPanel implements Runnable {
	Date timenow;
	int yy=50,xx=50;
	public void run(){ 
		while(true) {
			repaint();
			try{
				Thread.sleep(1000); 
			}
			catch(InterruptedException e){
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		timenow = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy 年 MM 月 dd 日hh:mm:ssa");
		String s_time_msg = sdf.format(timenow);
		g.drawString(s_time_msg, xx, yy); 
	}
	public static void main(String[] args) {
		JFrame jf = new JFrame(); 
		jf.setDefaultCloseOperation(3);
		jf.setTitle("时钟显示");
		jf.setSize(300,300);
		jf.setVisible(true);
		ShowTimeSample sts = new ShowTimeSample(); 
		sts.setVisible(true);
		sts.setBounds(0, 0, 300, 300); jf.add(sts);
		new Thread(sts).start();
	} 
}
