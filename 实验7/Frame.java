package test7;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Frame extends JFrame {

	private static final int SCALE_SMOOTH = 0;
	private JPanel contentPane;
	JPanel panel1;
	JPanel panel2;
	Image img,img1,img2,img3;
	JLabel lblNewLabel;
	int frontsize=20;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel1 = new JPanel();
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JButton button = new JButton("\u653E\u5927");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontsize++;
				if(frontsize>=25)
					frontsize=25;

				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, frontsize));
			}
		});
		button.setBounds(10, 344, 97, 23);
		panel1.add(button);
		
		JButton button_1 = new JButton("\u7F29\u5C0F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontsize--;
				if(frontsize<=5)
					frontsize=5;

				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, frontsize));
			}
		});
		button_1.setBounds(117, 344, 97, 23);
		panel1.add(button_1);
		
		lblNewLabel = new JLabel("\u6D4B\u8BD5\u5B57\u4F53");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, frontsize));
		lblNewLabel.setBounds(10, 313, 204, 28);
		panel1.add(lblNewLabel);
		
		panel2 = new JPanel();
		contentPane.add(panel2);
		panel2.setLayout(new GridLayout(1, 0, 0, 0));
		
		img=getToolkit().getImage("test.jpg");
		int size=200;
		img=img.getScaledInstance(size, size, SCALE_SMOOTH);
		img2=img.getScaledInstance(size/2, size, SCALE_SMOOTH);
		img3=img.getScaledInstance(size, size/2, SCALE_SMOOTH);
		img1=img.getScaledInstance(size/2, size/2, SCALE_SMOOTH);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g=panel1.getGraphics();
		int of=1;
		int offset=80;
		int st,ed;
		int lon=offset+of;
		int geshu=4;
		for(st=1;st<=lon;st+=lon/geshu)
		{
			for(ed=1;ed<=lon;ed+=lon/geshu)
			{
				g.drawLine(of, st, ed, of);
				g.drawLine(lon, st, ed, lon);
				g.drawLine(of, st,lon, ed);
				g.drawLine(of, st, ed, lon);
				g.drawLine(st, of, ed, lon);
				g.drawLine(st, of, lon, ed);
			}
		}
		
		int dx=offset+10;
		int len=8;
		int ge=10;
		for(int i=1;i<=ge;i++)
		{
			g.drawRect(of, dx, i*len, i*len);
			g.drawRect(of+i*len, dx+i*len, ge*len-i*len, ge*len-i*len);
		}
		
		int x[]=new int [40];
		int y[]=new int [40];
		int r=offset/2;
		int ofx=lon+2*of+r;
		int ofy=r/2+of;
		int ge2=7;
		for(int i=0;i<=ge2;i++)
		{
			double hu=i*2*3.1415926/ge2;
			x[i]=(int) (r*Math.cos(hu))+ofx;
			y[i]=(int) (r*Math.sin(hu))/2+ofy ;
		}
		g.drawPolygon(x,y,ge2);
		g.drawOval(ofx-r+of, ofy+r/2+of*2, 2*r, r);
		int ofx2=lon+4*of;
		int ofy2=lon+6*of ;
		g.drawOval(ofx2, ofy2, 2*r, 2*r);
		
		int wofx=of;
		int wofy=lon*2+20*of;
		g.drawString("老师好！",wofx,wofy);
		Font fsib30=new Font("宋体",Font.ITALIC+Font.BOLD,30);
		g.setFont( fsib30 );
		g.drawString("老师好！",wofx,wofy+30*of);
		Font t2=new Font("楷体",Font.ITALIC+Font.BOLD,30);
		g.setFont( t2 );
		g.drawString("老师好！",wofx,wofy+60*of);
		
		int ofx4=2*offset + 6*of;
		int ofy4= of;
		
		int lenx4=50;
		int leny4=100;
		int cntx4=10;
		int cnty4=20;
		int ddx=lenx4/cntx4;
		int ddy=leny4/cnty4;
		for(int i=0;i<cntx4;i++)
		{
			for(int j=0;j<cnty4;j++)
			{
				int sx=i*ddx+ofx4;
				int sy=j*ddy+ofy4;
				Color c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
				g.setColor(c);
				g.fillRect(sx, sy, ddx, ddy);
			}
		}

		int size=200;
		g=panel2.getGraphics();
		g.drawImage(img,0,0,this);
		g.drawImage(img3,size,0,this);
		g.drawImage(img2,0,size,this);
		g.drawImage(img1,size,size,this);
	}
}