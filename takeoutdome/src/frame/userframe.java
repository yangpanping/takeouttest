package frame;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import database.dbase;

public class userframe extends JFrame{
	public static String shangdanname;
	private JTable table;
	private JTable table2;
	private DefaultTableModel tablemodel;
	private DefaultTableModel tablemodel2;
	public JTextField textField;
	String[][] dingdannumbers=null;
	
	String name = dbase.getname();
	String phone = dbase.getphone();
	String adress = dbase.getaddress();
	public userframe() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		setTitle("外卖服务");
		setBounds(new Rectangle(400, 400, 700, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTabbedPane tbpanel = new JTabbedPane();
		
	    getContentPane().add(tbpanel,BorderLayout.CENTER);
	    String[] colums = {"商店","状态"};  
		String[][] values = dbase.getinfo();
		
		table = new JTable(values,colums);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		final JScrollPane panel = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectionRow = table.getSelectedRow();
				shangdanname = (String)table.getValueAt(selectionRow, 0);
				dbase.oneshangjia(shangdanname);
				new usershangjiaframe();
			}
		});
		tbpanel.addTab("外卖店",panel);
		
			
			dingdannumbers =dbase.dingdan1();
			
		
		
		
		String[] colums2= {"订单号","状态"}; 
		String[][] values2 =dingdannumbers;
		
		table2 = new JTable(values2,colums2);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		final JScrollPane panel2 = new JScrollPane(table2);
		table2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectionRow = table2.getSelectedRow();
				String a = (String)table2.getValueAt(selectionRow, 0);
				dbase.dingdan2(a);
				new dingdanframe();
			}
		});
		tbpanel.addTab("订单",panel2);
		
		 final JPanel panel3= new JPanel();
		    panel3.setLayout(null);
		    final JLabel label1 = new JLabel("用户：");
		    label1.setBounds(10,50,120,50);
		    final JLabel label2 = new JLabel("手机号码:");
		    label2.setBounds(10, 120, 100, 20);
		    final JLabel label3 = new JLabel("地址:");
		    label3.setBounds(10, 150, 100, 20);
		    final JTextField text1 = new JTextField(name);
		    text1.setBounds(50, 60, 200, 30);
		    final JTextField text2 = new JTextField(phone);
		    text2.setBounds(80, 110, 200, 30);
		    final JTextField text3 = new JTextField(adress);
		    text3.setBounds(50, 150, 250, 30);
		    panel3.add(label1);
		    panel3.add(label2);
		    panel3.add(label3);
		    panel3.add(text1);
		    panel3.add(text2);
		    panel3.add(text3);
		tbpanel.addTab("个人信息",panel3);
		setVisible(true);
	}
//public static void main(String[] args) {
//	new userframe();
//}
	public static String getShangdanname() {
		return shangdanname;
	}
	
}
