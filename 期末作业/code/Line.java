package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Line{
	Point u=new Point(),v=new Point();
	double len;
	double jiaodu;
	int type=0;
	Line(){}
	Line(Point _u,Point _v){
		u=new Point();
		v=new Point();
		u=_u;v=_v;
		len=u.jian(v).len();
		jiaodu=v.jian(u).jiaodu();
	}
	Line(Point _u,double _len,double _jiaodu){
		u=new Point();
		u=_u;len=_len;jiaodu=_jiaodu;
		v=new Point(u.x+len*Math.cos(jiaodu),u.y+len*Math.sin(jiaodu));
	}
	Line(Random r,double _len,double minx,double miny,double maxx,double maxy){
		len=_len;
		u=new Point(r,minx,miny,maxx,maxy);
		//u.show();
		jiaodu=r.nextDouble()*2*Math.PI;
		v=new Point(u.x+len*Math.cos(jiaodu),u.y+len*Math.sin(jiaodu));
		//v.show();
		//System.out.println('\n');
		type=0;
	}
	int sgn(double x) {
		if(Math.abs(x)<1e-8)
			return 0;
		if(x>0)
			return 1;
		return -1;
	}
	boolean iscross(double y) {
		return 
				Math.max(u.y, v.y)>=y && Math.min(u.y, v.y)<=y;
	}
	void Paint(Graphics g) {
		if(type==1) {	//划线
			g.setColor(Color.yellow);
		}
		else if(type==2) {	//针相交
			g.setColor(Color.red);
		}
		else if(type==3) {	//针不相交
			g.setColor(Color.green);
		}
		if(type!=0)
		g.drawLine((int)u.x, (int)u.y, (int)v.x, (int)v.y);
	}
	void show() {
		this.u.show();
		this.v.show();
		System.out.print('\n');
	}
}

class Circle{
	Point c;
	double r;
	Circle(){}
	Circle(Point _c,double _r){
		c=_c;r=_r;
	}
	boolean isin(Point x) {
		if( r> x.jian(c).len() )
			return false;
		return true;
	}
}