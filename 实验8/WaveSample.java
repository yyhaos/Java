package test8;
import java.awt.*;
import javax.swing.*;
public class WaveSample extends JPanel implements Runnable{
	Image imgf,imgv;
	Graphics gv;
	int gw,gh,n,k,d[];
	final int w = 4,b = 5;
	Color c1;
	public void init() {
		gw = getSize().width; 
		gh = getSize().height; 
		n = gw/w;
		k = n-1;
		d = new int[n];
		for(int i = 1;i < n;i++){
			d[i] = (int)(Math.sin(Math.PI*2/n*i)*b);
		 }
		imgf = getToolkit().getImage("Image.gif"); 
		imgv = createImage(gw,gh*2-b*2);
		gv = imgv.getGraphics();
		c1 = new Color(0xe8, 0xff, 0xff);
		gv.setColor(c1); 
	}
	public void paint(Graphics g){
		super.paint(g);
		gv.fillRect(0,0,gw,gh); 
		gv.drawImage(imgf,0,gh,this); 
		for(int i = 0;i < n;i++){
			gv.copyArea(i*w,gh,w,gh-2*b,0,-gh+b+d[(i+k)%n]);
		}
		g.drawImage(imgv,0,0,this); 
	}
	public void run(){
		while (true){
			try{
				Thread.sleep(50);
				k--;
				if(k<0) k = n-1;
				repaint();
			}
			catch (InterruptedException ie){
			}
		}
	}
	public static void main(String args[]) {
		JFrame jf = new JFrame("¶¯Ì¬Í¼Ïñ");
		WaveSample ws = new WaveSample(); 
		jf.add("Center", ws); 
		jf.setSize(400,300);
		jf.setVisible(true); 
		ws.setSize(400,300); 
		ws.init();
		new Thread(ws).start();
	}
}
