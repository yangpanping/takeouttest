package frame;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.crypto.spec.GCMParameterSpec;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import database.dbase;

/**
 * �û���¼����
 * @author ypp
 *
 */

public class userlogin extends JFrame{
	String a = null;
	String b = null;
	static JTextField textField = null;

	public userlogin() {
		super();
		// TODO Auto-generated constructor stub
		setTitle("�û����¼");
		setLayout(null);
		Container panel = getContentPane();
		
		 final JLabel label1 = new JLabel("�û�");
		label1.setBounds(200, 10, 80, 80);
		panel.add(label1);
		
		 JLabel label2 = new JLabel("�˻�:");
		label2.setBounds(130, 90, 80, 80);
		panel.add(label2);
		
		 JLabel label3 = new JLabel("����:");
		label3.setBounds(130, 160, 80, 80);
		panel.add(label3);
		
		  textField = new JTextField("152",15);
		textField.setBounds(170, 120, 140, 30);
		panel.add(textField);
		
		final JPasswordField password = new JPasswordField(15);
		password.setBounds(170, 180, 140, 30);
		panel.add(password);
		
		final JButton button1 = new JButton("��¼");
		button1.setBounds(130, 220, 90, 30);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 a = textField.getText().trim();
				 b = password.getText().trim();
				try {
					if(dbase.checkLogin(a, b)) {
						dbase.userinfo(a);
					new userframe();
					
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		panel.add(button1);
		
		final JButton button2 = new JButton("�˳�");
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
public static String getuserphone() {
	return textField.getText().trim();
}
//public static void main(String[] args) {
//	System.out.println(getuserphone());
//}
}
