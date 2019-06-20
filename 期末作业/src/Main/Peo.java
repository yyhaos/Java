package Main;

import java.awt.Graphics;

public class Peo{
	Peo(){}
	String name=new String()
			,time=new String()
			,Ncnt=new String()
			,Pi=new String();
	Peo(String _n,int t,int Nc,String P){
		name=new String(_n);
		time=String.valueOf(t);
		Ncnt=String.valueOf(Nc);
		Pi=String.valueOf(P);
	}
	
	void draw(Graphics g,int i) {
		//String tp=new String(name+" "+time+" "+Ncnt+' '+Pi);
		g.drawString(name, 0, 34+i*14);
		g.drawString(time, 50, 34+i*14);
		g.drawString(Ncnt, 88, 34+i*14);
		g.drawString(Pi, 154, 34+i*14);
	}
}