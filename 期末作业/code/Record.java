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

public class Record extends JPanel{
	Font myfont=new Font("楷体",Font.PLAIN,Math.min(40, 14));
	Font myfont2=new Font("黑体",Font.PLAIN,Math.min(40, 16));
	Peo ps[]=new Peo[20];
	int N=6;
	int th=6;
	public Record( ) {
		ps=new Peo[20];
		//myfont=new Font("楷体",Font.BOLD,Math.min(40, 14));
		ps[0]=new Peo("Wolf",1850,5000,"3.1596");
		ps[1]=new Peo("Smith",1855,3204,"3.1554");
		ps[2]=new Peo("C.De",1860,600,"3.137");
		ps[3]=new Peo("Fox",1884,1030,"3.1595");
		ps[4]=new Peo("Lazzer",1901,3408,"3.1415929");
		ps[5]=new Peo("Reina",1925,2520,"3.1795");
	}
	void add(Peo x) {
		ps[th]=new Peo();
		ps[th]=x;
		th++;
		if(N<20)
			N++;
		if(th>=20)
			th=6;
	}
	public void paint(Graphics g){
		g.setFont(myfont);
		String head=new String("实验者 时间 投掷次数 圆周率估计值");
		g.drawString(head, 0, 20);
		g.setFont(myfont2);
		for(int i=0;i<=N-1;i++)
			ps[i].draw(g,i);
	}
	
}
