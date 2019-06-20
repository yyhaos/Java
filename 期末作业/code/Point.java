package Main;

import java.util.Random;

public class Point {
	double x,y;
	Point(){
		x=y=0;
	}
	Point (double _x,double _y){
		x=_x;y=_y;
	}
	Point (Random r,double minx,double miny,double maxx,double maxy){
		x=r.nextDouble()*(maxx-minx)+minx;
		y=r.nextDouble()*(maxy-miny)+miny;
	}
	Point jian(Point b) {
		return new Point(x-b.x,y-b.y);
	}
	Point jia(Point b) {
		return new Point(x+b.x,y+b.y);
	}
	double diancheng(Point b) {
		return x*b.x+y*b.y;
	}
	double chacheng(Point b) {
		return x*b.y-b.x*y;
	}
	double len() {
		return Math.sqrt(x*x+y*y);
	}
	double jiaodu() {
		double tmp=Math.atan(y/x);
		if(x<0)
			tmp+=Math.PI;
		if(tmp<0)
			tmp+=Math.PI*2.0;
		return tmp;
	}
	void show() {
		System.out.print(x);
		System.out.print('-');
		System.out.print(y);
		System.out.print(' ');
		
	}
}
