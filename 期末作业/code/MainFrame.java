package Main;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Button;
import java.awt.Color;

public class MainFrame extends JFrame{
	long randomseed=System.currentTimeMillis();
	Random rd=new Random(randomseed);
	int Lx,Ly;
	int Nzheng,Nxian,Nsudu;
	double Llen;
	TouZheng tz;
	Record rc=new Record();
	Thread t;
	
	private JPanel Main;
	private JTextField SeedText;
	private JTextField LyText;
	private JTextArea textArea_2;
	private JTextField LxText;
	private JTextField NzhengText;
	private JTextArea textArea_3;
	private JTextArea textArea_4;
	private JTextField LlenText;
	private JTextArea textArea_5;
	private JTextField NxianText;
	private JTextArea textArea_6;
	private JTextField NsuduText;
	Button StartButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setFont(new Font("楷体", Font.PLAIN, 17));
		setTitle("蒲丰投针问题 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		Main = new JPanel();
		Main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Main);
		Main.setLayout(null);
		
		rc=new Record();
		rc.setBounds(10, 300, 250, 500);
		rc.setVisible(true);
		Main.add(rc);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("楷体", Font.PLAIN, 16));
		textArea.setBackground(SystemColor.menu);
		textArea.setEditable(false);
		textArea.setText("\u968F\u673A\u6570\u79CD\u5B50");
		textArea.setBounds(25, 30, 101, 23);
		Main.add(textArea);
		
		SeedText = new JTextField();//投针随机数种子
		SeedText.setBounds(135, 31, 100, 21);
		Main.add(SeedText);
		SeedText.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("\u6295\u9488\u533A\u57DF\u9AD8\u5EA6");
		textArea_1.setFont(new Font("楷体", Font.PLAIN, 16));
		textArea_1.setEditable(false);
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(25, 63, 101, 23);
		Main.add(textArea_1);
		
		LyText = new JTextField();//投针区域高度
		LyText.setText("500");
		LyText.setColumns(10);
		LyText.setBounds(135, 64, 66, 21);
		Main.add(LyText);
		
		textArea_2 = new JTextArea();
		textArea_2.setText("\u6295\u9488\u533A\u57DF\u5BBD\u5EA6");
		textArea_2.setFont(new Font("楷体", Font.PLAIN, 16));
		textArea_2.setEditable(false);
		textArea_2.setBackground(SystemColor.menu);
		textArea_2.setBounds(25, 92, 101, 23);
		Main.add(textArea_2);
		
		LxText = new JTextField();//投针区域宽度
		LxText.setText("500");
		LxText.setColumns(10);
		LxText.setBounds(135, 93, 66, 21);
		Main.add(LxText);
		
		NzhengText = new JTextField();//投针数
		NzhengText.setText("1000");
		NzhengText.setColumns(10);
		NzhengText.setBounds(135, 126, 66, 21);
		Main.add(NzhengText);
		
		textArea_3 = new JTextArea();
		textArea_3.setText("\u6295\u9488\u6570");
		textArea_3.setFont(new Font("楷体", Font.PLAIN, 16));
		textArea_3.setEditable(false);
		textArea_3.setBackground(SystemColor.menu);
		textArea_3.setBounds(25, 125, 101, 23);
		Main.add(textArea_3);
		
		textArea_4 = new JTextArea();
		textArea_4.setText("\u9488\u957F\u5EA6");
		textArea_4.setFont(new Font("楷体", Font.PLAIN, 16));
		textArea_4.setEditable(false);
		textArea_4.setBackground(SystemColor.menu);
		textArea_4.setBounds(25, 156, 101, 23);
		Main.add(textArea_4);
		
		LlenText = new JTextField();//针长
		LlenText.setText("30");
		LlenText.setColumns(10);
		LlenText.setBounds(135, 157, 66, 21);
		Main.add(LlenText);
		
		textArea_5 = new JTextArea();
		textArea_5.setText("\u5212\u7EBF\u6570\u91CF");
		textArea_5.setFont(new Font("楷体", Font.PLAIN, 16));
		textArea_5.setEditable(false);
		textArea_5.setBackground(SystemColor.menu);
		textArea_5.setBounds(25, 189, 101, 23);
		Main.add(textArea_5);
		
		NxianText = new JTextField();//标记线个数
		NxianText.setText("5");
		NxianText.setColumns(10);
		NxianText.setBounds(135, 190, 66, 21);
		Main.add(NxianText);
		
		textArea_6 = new JTextArea();
		textArea_6.setText("\u6295\u9488\u901F\u5EA6");
		textArea_6.setFont(new Font("楷体", Font.PLAIN, 16));
		textArea_6.setEditable(false);
		textArea_6.setBackground(SystemColor.menu);
		textArea_6.setBounds(25, 220, 101, 23);
		Main.add(textArea_6);
		
		NsuduText = new JTextField();//投针速度
		NsuduText.setText("10");
		NsuduText.setColumns(10);
		NsuduText.setBounds(135, 221, 66, 21);
		Main.add(NsuduText);
		
		StartButton = new Button("\u6295\u9488\u5B9E\u9A8C\u5F00\u59CB");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tz!=null){
					tz.setVisible(false);
				}
				if(t!=null) {
					t.stop();
				}
				if(t!=null && tz!=null)
				{
					if(tz.Ncnt==tz.Nzheng) {
						Peo tmp=new Peo("yyhaos",2019,tz.Nzheng,String.valueOf(tz.PI));
						rc.add(tmp);
					}
				}
				int fa=1;
				
				String str=new String(NsuduText.getText());//投针速度
				try {
					int tmp=Integer.parseInt(str);
					if(tmp<=0) {
						NsuduText.setText("输入太小");
						fa=0;
					}
					else {
						Nsudu=tmp;
						NsuduText.setText(String.valueOf(tmp));
					}
				}
				catch (Exception x) {
					if(str!="")
						NsuduText.setText("输入错误");
					fa=0;
				}
				
				str=new String(NzhengText.getText());//投针数
				try {
					int tmp=Integer.parseInt(str);
					if(tmp<=0) {
						NzhengText.setText("输入太小");
						fa=0;
					}
					else if(tmp>1000000) {
						NzhengText.setText("输入太大");
						fa=0;
					}
					else {
						Nzheng=tmp;
						NzhengText.setText(String.valueOf(tmp));
					}
				}
				catch (Exception x) {
					if(str!="")
						NzhengText.setText("输入错误");
					fa=0;
				}
				
				str=new String(NxianText.getText());//标记线的个数
				try {
					int tmp=Integer.parseInt(str);
					if(tmp<=0) {
						NxianText.setText("输入太小");
						fa=0;
					}
					else if(tmp>=1000) {
						NxianText.setText("输入太大");
						fa=0;
					}
					else {
						Nxian=tmp;
						NxianText.setText(String.valueOf(tmp));
					}
				}
				catch (Exception x) {
					if(str!="")
						NxianText.setText("输入错误");
					fa=0;
				}
				
				str=new String(LlenText.getText());//针长
				try {
					Double tmp=Double.parseDouble(str);
					if(tmp<=0) {
						LlenText.setText("输入太小");
						fa=0;
					}
					else if(tmp>=1000) {
						LlenText.setText("输入太大");
						fa=0;
					}
					else {
						Llen=tmp;
						LlenText.setText(String.valueOf(tmp));
					}
				}
				catch (Exception x) {
					if(str!="")
						LlenText.setText("输入错误");
					fa=0;
				}
				
				str=new String(LxText.getText());//投针区域宽度
				try {
					int tmp=Integer.parseInt(str);
					if(tmp<50) {
						LxText.setText("输入太小");
						fa=0;
					}
					else if(tmp>10000000) {
						LxText.setText("输入太大");
						fa=0;
					}
					else {
						Lx=tmp;
						LxText.setText(String.valueOf(tmp));
					}
				}
				catch (Exception x) {
					if(str!="")
						LxText.setText("输入错误");
					fa=0;
				}
				
				str=new String(LyText.getText());//投针区域高度
				try {
					int tmp=Integer.parseInt(str);
					if(tmp<50) {
						LyText.setText("输入太小");
						fa=0;
					}
					else if(tmp>10000000) {
						LyText.setText("输入太大");
						fa=0;
					}
					else {
						Ly=tmp;
						LyText.setText(String.valueOf(tmp));
					}
				}
				catch (Exception x) {
					if(str!="")
						LyText.setText("输入错误");
					fa=0;
				}
				
				str=new String(SeedText.getText());//随机数种子
				try {
					long seed=Long.parseLong(str);
					randomseed=seed;
					SeedText.setText(String.valueOf(seed));
				}
				catch (Exception x) {
					//System.out.println(" '"+str+"' ");
					if(str.length() > 0) {
						SeedText.setText("输入错误");fa=0;
					}
					randomseed=System.currentTimeMillis();
					rd=new Random((long) randomseed);
				}
				
				if(fa==0)
					return ;
				
				repaint();
				LxText.setText(String.valueOf(Lx));
				LyText.setText(String.valueOf(Ly));
				NzhengText.setText(String.valueOf(Nzheng));
				NxianText.setText(String.valueOf(Nxian));
				NsuduText.setText(String.valueOf(Nsudu));
				LlenText.setText(String.valueOf(Llen));
				SeedText.setText(String.valueOf(randomseed));
				MainFrame tmp=new MainFrame();
				tmp.Llen=Llen;
				tmp.Lx=Lx;
				tmp.Ly=Ly;
				tmp.Nsudu=Nsudu;
				tmp.Nxian=Nxian;
				tmp.Nzheng=Nzheng;
				tmp.rd=rd;
				tmp.randomseed=randomseed;
				tz=new TouZheng( tmp );
				//ShowTimeSample sts = new ShowTimeSample(); 
				tz.setVisible(true);
				tz.setBounds(250, 10, Lx, Ly+100);
				//tz.offy=-200;
				tz.setBackground(Color.black);
				//tz.setBorder(BorderFactory.createLineBorder(Color.black, 3));
				Main.add(tz);

				repaint();
				t = new Thread(tz);//.start();
				t.start();
				//tz.setVisible(false);
			}
		});
		StartButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		StartButton.setBackground(SystemColor.textHighlightText);
		StartButton.setBounds(59, 249, 101, 23);
		Main.add(StartButton);
		
		Lx=Integer.parseInt(LxText.getText());
		Ly=Integer.parseInt(LyText.getText());
		Nzheng=Integer.parseInt(NzhengText.getText());
		Nxian=Integer.parseInt(NxianText.getText());
		Nsudu=Integer.parseInt(NsuduText.getText());
		Llen=Double.parseDouble(LlenText.getText());
	}
}
