package test8;

import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;

public class Clock extends ShowTimeSample {

	Date timenow;
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
		super.xx=75;
		super.yy=75*4;
		super.paint(g);
		timenow = new Date();
		
		double a1=1.0*((-3+timenow.getHours())%12)/12.0*2*3.14159;
		double a2=1.0*((-15+timenow.getMinutes()))/60.0*2*3.14159;
		double a3=1.0*((-15+timenow.getSeconds()))/60.0*2*3.14159;
		int cx=150;
		int cy=150;
		int r=140;

		
		g.drawOval(cx-r, cy-r, r*2, r*2);
		g.drawLine(cx, cy, cx+(int)(0.5*r*Math.cos(a1)), cy+(int)(0.5*r*Math.sin(a1)));
		g.drawLine(cx, cy, cx+(int)(0.8*r*Math.cos(a2)), cy+(int)(0.8*r*Math.sin(a2)));
		g.drawLine(cx, cy, cx+(int)(r*Math.cos(a3)), cy+(int)(r*Math.sin(a3)));
	}
	public static void main(String[] args) {
		
		JFrame jf = new JFrame(); 
		jf.setDefaultCloseOperation(3);
		jf.setTitle(" ±÷”œ‘ æ2");
		jf.setSize(400,400);
		jf.setVisible(true);
		Clock sts = new Clock(); 
		sts.setVisible(true);
		sts.setBounds(0, 0, 300, 300); jf.add(sts);
		new Thread(sts).start();
	} 
}
