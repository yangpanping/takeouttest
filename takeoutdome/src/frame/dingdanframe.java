package frame;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.dbase;

public class dingdanframe extends JFrame{
	static String time ;
	
	//String user =userlogin.getuserphone();

	public dingdanframe() {
		super();
		// TODO Auto-generated constructor stub
		setTitle("订单详细信息");
		setBounds(800, 500, 300, 500);
		final JPanel panel = new JPanel();
		panel.setLayout(null);
		final JLabel label1 = new JLabel("订单号");
		label1.setBounds(5, 10, 50, 20);
		final JLabel label2 = new JLabel("用户名");
		label2.setBounds(5, 30, 50, 20);
		final JLabel label3 = new JLabel("商店名");
		label3.setBounds(5, 70, 50, 20);
		final JLabel label4 = new JLabel("菜品");
		label4.setBounds(5, 90, 50, 20);
		final JLabel label5 = new JLabel("总价"); 
		label5.setBounds(5, 110, 50, 20);
		final JLabel label6 = new JLabel("状态");
		label6.setBounds(5, 130, 50, 20);
		final JLabel label7 = new JLabel("用户电话");
		label7.setBounds(5, 150, 50, 20);
		final JLabel label8 = new JLabel("商户电话");
		label8.setBounds(5, 170, 50, 20);
		final JLabel label9 = new JLabel("配送地址");
		label9.setBounds(5, 190, 50, 20);
		
		final JTextField text1 = new JTextField(dbase.getDingdannumber());
		text1.setBounds(50, 10, 100, 20);
		final JTextField text2 = new JTextField(dbase.getDingdanusername());
		text2.setBounds(50, 30, 100, 20);
		final JTextField text3 = new JTextField(dbase.getDingdanshangjianame());
		text3.setBounds(50, 70, 100, 20);
		final JTextField text4 = new JTextField(dbase.getDingdancaidanname());
		text4.setBounds(50, 90, 100, 20);
		final JTextField text5 = new JTextField(dbase.getDingdantallprice());
		text5.setBounds(50, 110, 100, 20);
		final JTextField text6 = new JTextField(dbase.getDingdanstatues());
		text6.setBounds(50, 130, 100, 20);
		final JTextField text7 = new JTextField(dbase.getDingdanuserphone());
		text7.setBounds(50, 150, 100, 20);
		final JTextField text8 = new JTextField(dbase.getDingdanshangjiaphone());
		text8.setBounds(50, 170, 100, 20);
		final JTextField text9 = new JTextField(dbase.getDingdanuseraddress());
		text9.setBounds(50, 190, 100, 20);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);
		panel.add(label8);
		panel.add(label9);
		
		panel.add(text1);
		panel.add(text2);
		panel.add(text3);
		panel.add(text4);
		panel.add(text5);
		panel.add(text6);
		panel.add(text7);
		panel.add(text8);
		panel.add(text9);
		getContentPane().add(panel);
		setVisible(true);
	}
//	public static String dingdanhao() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:sssss");
//		Date now = new Date();
//		String str = sdf.format(now);
//		String str1 = str;
//		
//		return str1;
//	}
//public static void main(String[] args) {
//	new dingdanframe();
//	//System.out.println(dingdanhao());
//}
}
