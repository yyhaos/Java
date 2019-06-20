package test8;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Color;

public class TextFlow extends JFrame implements Runnable {

	private JPanel contentPane;
	private JTextField textField;
	static int x=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TextFlow frame = new TextFlow();
		frame.setTitle("文字滚动");
		frame.setSize(600,500);
		frame.setVisible(true);
		new Thread(frame).start();
	}
	public void run() {
		//frame.s
		
		while(true)
		{
			repaint();
			try {
				Thread.sleep(50);
				x=(x+5)%450;
				//TextFlow frame = new TextFlow();
				//frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Create the frame.
	 */
	public TextFlow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		g=contentPane.getGraphics();
		g.setFont(new Font("幼圆",Font.PLAIN,30));
		g.drawString("师姐好！师姐好！", 450-x,450-x);
	}
}
