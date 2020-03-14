package frame;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 这是选择用户和商家登录界面
 * @author ypp
 *
 */

public class changelogin extends JFrame{
       public changelogin() {
		super();
		// TODO Auto-generated constructor stub
		setTitle("欢迎使用超级外卖系统");
		setBounds(800, 500, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
		
		final JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1,5,5));
		getContentPane().add(panel);
		final JButton button1 = new JButton("用户");
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new userlogin();
				setVisible(false);
			}
		});
		panel.add(button1,CENTER_ALIGNMENT);
		 final JButton button2 = new JButton("商家");
		 button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new shangjialogin();
				setVisible(false);
			}
		});
		 panel.add(button2,CENTER_ALIGNMENT); 
	}
       

	public static void main(String[] args) {
	changelogin frame=	new changelogin();
	frame.setVisible(true);
	}
       
}
