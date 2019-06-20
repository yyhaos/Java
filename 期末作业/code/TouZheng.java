package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TouZheng extends JPanel implements Runnable {
	double PI=0;
	double Pjiao=0;
	String message=new String("即将开始"),message2=new String("0");
	int Ncnt=0,Njiao=0;
	long randomseed=System.currentTimeMillis();
	Random rd=new Random(randomseed);
	int Lx,Ly,offy=100;
	int Nzheng,Nxian,Nsudu;
	double Llen;
	Line Ls[];
	Line Lz[];
	/**
	 * Create the Panel.
	 */
	public TouZheng( MainFrame x ) {
		Ncnt=0;
		Ls=new Line[1005];
		Lz=new Line[1000005];
		randomseed=x.randomseed;
		rd=x.rd;Lx=x.Lx;Ly=x.Ly;
		Nzheng=x.Nzheng;Nxian=x.Nxian;Nsudu=x.Nsudu;
		Llen=x.Llen;
		int jian=Ly/(Nxian);
		Point t1,t2;
		System.out.println(Nxian);
		for(int i=0;i<=Nxian;i++) {
			Ls[i]=new Line();
		//	System.out.println(Ls[i].u.x);
		}
		for(int i=0;i<=Nzheng;i++) {
			Lz[i]=new Line();
		}
		for(int i=1;i<=Nxian;i++) {
			//System.out.println(Ly);
			t1=new Point(0,offy-jian/2+jian*i);
			t2=new Point(Lx,offy-jian/2+jian*i);
			Ls[i]=new Line();
			Ls[i]=new Line(t1,t2);
			Ls[i].type=1;
		//	System.out.print(Ls[i].u.x);
		}
		for(int i=1;i<=Nzheng;i++) {
		//	System.out.println(i);
			Lz[i]=(new Line(rd,Llen,0,offy,Lx,Ly+offy));
			if(Lz[i].u.y<offy)
				Lz[i].u.y=offy;
			if(Lz[i].v.y<offy)
				Lz[i].v.y=offy;
			Lz[i].type=3;
		//	Lz[i].show();
		//	System.out.println(Lz[i].u.x);
			for(int i1=1;i1<=Nxian;i1++) {
				if(Lz[i].iscross(Ls[i1].u.y)) {
					//System.out.println(i1+"===="+Ls[i1].u.y);
					
					Lz[i].type=2;
					break;
				}
			}
		}
	}
	
	public void paint(Graphics g){
		Font myfont=new Font("楷体",Font.BOLD,Math.min(40, Lx/13));
		super.paint(g);
		g.setColor(Color.white);
		g.setFont(myfont);
		g.drawString(message, 10, 90);
		g.drawString(message2, 7*Math.min(40, Lx/13), 90);
		g.drawString("3.1415926535 PI=2*l/p/a", 10, 50);
		//System.out.print("第"+Ncnt+"次画图：");
		for(int i=1;i<=Nxian;i++) {
			Ls[i].Paint(g);
		}
		
		for(int i=1;i<=Ncnt;i++) {
			Lz[i].Paint(g);
		}
		//System.out.print("第"+Ncnt+"次画图结束");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true && Ncnt<=Nzheng) {
			repaint();
			Ncnt++;
			if(Ncnt>Nzheng) {
				Ncnt=Nzheng;
				break;
			}
			if(Lz[Ncnt].type==2)
				Njiao+=1;
			Pjiao=1.0*Njiao/(1.0*Ncnt);
			if(Pjiao!=0)
				PI=2.0*Llen/Pjiao/(1.0*Ly/(1.0*Nxian));
			else
				PI=0;
			if(String.valueOf(PI).length()>12)
				message=String.valueOf(PI).substring(0,12);
			else
				message=String.valueOf(PI);
			
			message2=" "+String.valueOf(Ncnt);
			try {
				Thread.sleep(1000/Nsudu);
			//	System.out.println(Ncnt);
			//	System.out.println(Ncnt);
			//	Lz[Ncnt].show();
			//	Lz[Ncnt].type=3;
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

}
