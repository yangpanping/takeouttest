package frame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.dbase;

public class shangjialogin extends JFrame{
	static JTextField textField = null;
	JPasswordField password = null;
	
	public shangjialogin() {
		super();
		// TODO Auto-generated constructor stub
		setTitle("商家请登录");
		setLayout(null);
		Container panel = getContentPane();
		
		 final JLabel label1 = new JLabel("商家");
		label1.setBounds(200, 10, 80, 80);
		panel.add(label1);
		
		 JLabel label2 = new JLabel("账户:");
		label2.setBounds(130, 90, 80, 80);
		panel.add(label2);
		
		 JLabel label3 = new JLabel("密码:");
		label3.setBounds(130, 160, 80, 80); 
		panel.add(label3);
		
		  textField = new JTextField(15);
		textField.setBounds(170, 120, 140, 30);
		panel.add(textField);
		
		 password = new JPasswordField(15);
		password.setBounds(170, 180, 140, 30);
		panel.add(password);
		
		final JButton button1 = new JButton("登录");
		button1.setBounds(130, 220, 90, 30);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a = textField.getText().trim();
				String b = password.getText().trim();
				try {
					if(dbase.shangjiacheckLogin(a, b)) {
						dbase.shangjiainfo(a);
					new shangjiaframe(); 
					}else {
						
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);  
			}
		});
		
		panel.add(button1);
		
		final JButton button2 = new JButton("退出");
		button2.setBounds(250, 220, 90, 30);
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		panel.add(button2);
		
		setBounds(800,400,0,0);
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true); 
		setVisible(true);
	}
	public static String getshangjiainfo() {
		return textField.getText().trim();
	}


}
