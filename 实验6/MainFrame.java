package test6;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
public class MainFrame extends JFrame {
 private JPanel contentPane;
 private JTextField textField;
 private JTextField textField_1;
 private JTextField textField_2;
 private JTextField textField_3;
 private JButton btnNewButton ;
 private JTextField textField_4;
 private JButton button_1;
 private JRadioButton radioButton_heiti;
 private final ButtonGroup buttonGroup = new ButtonGroup();
 private JTextField textField_5;
 private JButton button_2;
 private JComboBox comboBox;
 private JTextField textField_6;
 private JLabel label;
 private JLabel label_xuanzhong;
 private JLabel lblNewLabel;
 private JLabel lblNewLabel_shuangji;
 private JTextField textField_7;
 private JLabel label_shubiao;
 private JTextField textField_8;
 private JButton button_3;
 private JButton btnYyh;
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
 	addMouseMotionListener(new MouseMotionAdapter() {
 		@Override
 		public void mouseMoved(MouseEvent e) {//实验6-9显示鼠标位置
 			String str="鼠标位置：(";
 			str=str+Integer.toString(e.getX())+",";
 			str=str+Integer.toString(e.getY())+")";
 			label_shubiao.setText(str);
 		}
 	});
  setTitle("\u5B9E\u9A8C6\u5927\u5408\u96C6");//设置窗体标题
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setBounds(100, 100, 409, 406);
  contentPane = new JPanel();
  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  contentPane.setLayout(new BorderLayout(0, 0));
  setContentPane(contentPane);
  
  JButton button = new JButton("\u9000\u51FA\u7A0B\u5E8F");//实验6-3退出程序按钮
  button.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
	   dispose();
   }
  });
  contentPane.add(button, BorderLayout.SOUTH);
  
  JLayeredPane layeredPane = new JLayeredPane();
  layeredPane.setBackground(Color.LIGHT_GRAY);
  contentPane.add(layeredPane, BorderLayout.CENTER);
  
  textField = new JTextField();
  textField.setHorizontalAlignment(SwingConstants.CENTER);
  textField.setEditable(false);
  textField.setText("\u5B9E\u9A8C6-4");
  textField.setBounds(10, 10, 52, 21);
  layeredPane.add(textField);
  textField.setColumns(10);
  
  textField_1 = new JTextField();
  textField_1.addKeyListener(new KeyAdapter() {//实验6-4双文本框配合
   @Override
   public void keyPressed(KeyEvent e) {
    if(e.getKeyChar()!='\n') {
     textField_2.setText(textField_1.getText()+e.getKeyChar());
    }
    else {
     textField_1.setText("");
     textField_2.setText("");
    }
    repaint() ;
   }
  });
  textField_1.setBounds(10, 32, 66, 21);
  layeredPane.add(textField_1);
  textField_1.setColumns(10);
  
  textField_2 = new JTextField();
  textField_2.setBounds(10, 57, 66, 21);
  layeredPane.add(textField_2);
  textField_2.setColumns(10);
  
  textField_3 = new JTextField();
  textField_3.setText("\u5B9E\u9A8C6-5");
  textField_3.setHorizontalAlignment(SwingConstants.CENTER);
  textField_3.setEditable(false);
  textField_3.setColumns(10);
  textField_3.setBounds(10, 98, 52, 21);
  layeredPane.add(textField_3);
  
  btnNewButton = new JButton("\u5355\u9009\u6309\u94AE");
  btnNewButton.setBackground(Color.LIGHT_GRAY);
  btnNewButton.setFont(new Font("宋体", Font.PLAIN, 12));
  btnNewButton.setBounds(10, 154, 90, 23);
  layeredPane.add(btnNewButton);
  
  textField_4 = new JTextField();
  textField_4.setText("\u5B9E\u9A8C6-6");
  textField_4.setHorizontalAlignment(SwingConstants.CENTER);
  textField_4.setEditable(false);
  textField_4.setColumns(10);
  textField_4.setBounds(10, 191, 52, 21);
  layeredPane.add(textField_4);
  
  JCheckBox checkBox = new JCheckBox("\u590D\u9009\u6309\u94AE");
  checkBox.addChangeListener(new ChangeListener() {//实验6-5双按钮配合
  	public void stateChanged(ChangeEvent e) {
  		if(checkBox.isSelected()){
	     btnNewButton.setBackground(Color.CYAN);
	    }
	    else{
	     btnNewButton.setBackground(Color.LIGHT_GRAY);
	    }
  	}
  });
  checkBox.setBounds(10, 125, 109, 23);
  layeredPane.add(checkBox);
  
  JRadioButton radioButton_putong = new JRadioButton("\u666E\u901A");
  radioButton_putong.addChangeListener(new ChangeListener() {//实验6-6选字体格式1
  	public void stateChanged(ChangeEvent e) {
  		if(radioButton_putong.isSelected()) {
  			button_1.setFont(new Font("等线", Font.PLAIN, 12));
  		}
  	}
  });
  buttonGroup.add(radioButton_putong);
  radioButton_putong.setBounds(10, 211, 60, 23);
  layeredPane.add(radioButton_putong);
  
  radioButton_heiti = new JRadioButton("\u9ED1\u4F53");
  radioButton_heiti.addChangeListener(new ChangeListener() {//实验6-6选字体格式2
  	public void stateChanged(ChangeEvent e) {
  		if(radioButton_heiti.isSelected()) {
  			button_1.setFont(new Font("黑体", Font.PLAIN, 12));
  		}
  	}
  });
  buttonGroup.add(radioButton_heiti);
  radioButton_heiti.setBounds(10, 231, 66, 23);
  layeredPane.add(radioButton_heiti);
  
  JRadioButton radioButton_xieti = new JRadioButton("\u659C\u4F53");
  radioButton_xieti.addChangeListener(new ChangeListener() {//实验6-6选字体格式3
  	public void stateChanged(ChangeEvent e) {
  		if (radioButton_xieti.isSelected()) {
  			button_1.setFont(new Font("等线", Font.ITALIC, 12));
  		}
  	}
  });
  buttonGroup.add(radioButton_xieti);
  radioButton_xieti.setBounds(10, 252, 73, 23);
  layeredPane.add(radioButton_xieti);
  
  button_1 = new JButton("\u666E\u901A\u6309\u94AE");
  button_1.setFont(new Font("等线", Font.PLAIN, 12));
  button_1.setBounds(10, 281, 90, 23);
  layeredPane.add(button_1);
  
  textField_5 = new JTextField();
  textField_5.setText("\u5B9E\u9A8C6-7");
  textField_5.setHorizontalAlignment(SwingConstants.CENTER);
  textField_5.setEditable(false);
  textField_5.setColumns(10);
  textField_5.setBounds(124, 10, 52, 21);
  layeredPane.add(textField_5);
  
  button_2 = new JButton("\u666E\u901A\u6309\u94AE");
  button_2.setFont(new Font("宋体", Font.PLAIN, 12));
  button_2.setBounds(236, 19, 117, 46);
  layeredPane.add(button_2);
  
  comboBox = new JComboBox();
  comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "14", "18"}));
  comboBox.addItemListener(new ItemListener() {//实验6-7选字体大小
  	public void itemStateChanged(ItemEvent e) {
  		button_2.setFont(new Font("宋体", Font.PLAIN, Integer.parseInt(comboBox.getSelectedItem().toString())));
  	}
  });
  comboBox.setBounds(124, 41, 102, 23);
  layeredPane.add(comboBox);
  
  textField_6 = new JTextField();
  textField_6.setText("\u5B9E\u9A8C6-8");
  textField_6.setHorizontalAlignment(SwingConstants.CENTER);
  textField_6.setEditable(false);
  textField_6.setColumns(10);
  textField_6.setBounds(124, 98, 52, 21);
  layeredPane.add(textField_6);
  
  JList list = new JList();
  list.addMouseListener(new MouseAdapter() {
  	@Override
  	public void mouseReleased(MouseEvent e) {//实验6-8选列表2 选中的
  		String str="";
  		for(int i=0;i<list.getSelectedIndices().length;i++) {
  			str=str+list.getModel().getElementAt(list.getSelectedIndices()[i])+" ";
  		}
  		label_xuanzhong.setText(str);
  	}
  	@Override
  	public void mouseClicked(MouseEvent e) {//实验6-8选列表1 双击选中的
  		if(e.getClickCount()==2) {
  			lblNewLabel_shuangji.setText(list.getSelectedValue().toString());
  		}
  	}
  });
  list.setModel(new AbstractListModel() {
  	String[] values = new String[] {"item1", "item2", "item3", "item4", "item5"};
  	public int getSize() {
  		return values.length;
  	}
  	public Object getElementAt(int index) {
  		return values[index];
  	}
  });
  list.setBounds(124, 128, 40, 100);
  layeredPane.add(list);
  
  lblNewLabel = new JLabel("\u53CC\u51FB\u5185\u5BB9\uFF1A");
  lblNewLabel.setBounds(181, 129, 73, 15);
  layeredPane.add(lblNewLabel);
  
  lblNewLabel_shuangji = new JLabel(" ");
  lblNewLabel_shuangji.setBounds(236, 129, 117, 19);
  layeredPane.add(lblNewLabel_shuangji);
  
  label = new JLabel("\u9009\u4E2D\u5185\u5BB9\uFF1A");
  label.setBounds(181, 158, 73, 15);
  layeredPane.add(label);
  
  label_xuanzhong = new JLabel(" ");
  label_xuanzhong.setBounds(181, 169, 172, 32);
  layeredPane.add(label_xuanzhong);
  
  textField_7 = new JTextField();
  textField_7.setText("\u5B9E\u9A8C6-9");
  textField_7.setHorizontalAlignment(SwingConstants.CENTER);
  textField_7.setEditable(false);
  textField_7.setColumns(10);
  textField_7.setBounds(124, 232, 52, 21);
  layeredPane.add(textField_7);
  
  label_shubiao = new JLabel(" ");
  label_shubiao.setBounds(124, 256, 130, 19);
  layeredPane.add(label_shubiao);
  
  textField_8 = new JTextField();
  textField_8.setText("\u5B9E\u9A8C6-10");
  textField_8.setHorizontalAlignment(SwingConstants.CENTER);
  textField_8.setEditable(false);
  textField_8.setColumns(10);
  textField_8.setBounds(124, 282, 60, 21);
  layeredPane.add(textField_8);
  
  button_3 = new JButton("\u65B0\u7A97\u53E3");
  button_3.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {//实验6-10 创建新窗口
  		MainFrame frame = new MainFrame();
  		frame.setTitle("新"+getTitle());
  	    frame.setVisible(true);
  	}
  });
  button_3.setBounds(187, 281, 90, 23);
  layeredPane.add(button_3);
  
  btnYyh = new JButton("yyh");
  btnYyh.addActionListener(new ActionListener() {
  	public void actionPerformed(ActionEvent e) {
  		textField_1.setText("那真的nb");//如果不是用tab键点击的话
  	}
  });
  layeredPane.setLayer(btnYyh, 3);
  btnYyh.addMouseListener(new MouseAdapter() {
  	@Override
  	public void mouseEntered(MouseEvent e) {
  		int x= (int) (getWidth()/1.5+Math.random() * (getWidth()/3-74));
  		int y= (int) (50+Math.random() * (getHeight()-203));
  		btnYyh.setBounds(x, y, 74, 23);
  	}
  });
  btnYyh.setBounds(284, 231, 74, 23);
  layeredPane.add(btnYyh);
 }
}