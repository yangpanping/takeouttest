package frame;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TabExpander;

import database.dbase;

public class shangjiaframe extends JFrame{
	

	public shangjiaframe() {
		super();
		// TODO Auto-generated constructor stub
		setTitle("商家");
		setBounds(new Rectangle(400, 400, 700, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final JTabbedPane tbpanel = new JTabbedPane();
		tbpanel.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	    getContentPane().add(tbpanel,BorderLayout.CENTER);
	    
	    String[] column = {"菜品","价格"};
	    String[][] values = dbase.oneshangjia(dbase.getname());
	    DefaultTableModel tbpael = new DefaultTableModel(values, column);
	    JTable table = new JTable(tbpael);
	    final JScrollPane scrollpanel = new JScrollPane(table);
	    tbpanel.addTab("菜品", scrollpanel);
	    
	    String[] column1 = {"订单","状态"};
	    String[][] values1= dbase.shangjiadingdan1();
	    DefaultTableModel tbpanel1 = new DefaultTableModel(values1,column1);
	    JTable table1 = new JTable(tbpanel1);
	    table1.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
				int selectionRow = table1.getSelectedRow();
				String a = (String)table1.getValueAt(selectionRow, 0);
				dbase.dingdan2(a);
				new dingdanframe();
			}
		});
	    final JScrollPane scrollpanel2 = new JScrollPane(table1);
	    tbpanel.addTab("订单", scrollpanel2);
	     
	    final JPanel panel3= new JPanel();
	    panel3.setLayout(null);
	    final JLabel label1 = new JLabel("店名:");
	    label1.setBounds(10,50,120,50);
	    final JLabel label2 = new JLabel("手机号码:");
	    label2.setBounds(10, 120, 100, 20);
	    final JLabel label3 = new JLabel("地址:");
	    label3.setBounds(10, 150, 100, 20);
	    final JTextField text1 = new JTextField(dbase.getname());
	    text1.setBounds(50, 60, 200, 30);
	    final JTextField text2 = new JTextField(dbase.getphone());
	    text2.setBounds(80, 110, 200, 30);
	    final JTextField text3 = new JTextField(dbase.getaddress());
	    text3.setBounds(50, 150, 250, 30);
	    panel3.add(label1);
	    panel3.add(label2);
	    panel3.add(label3);
	    panel3.add(text1);
	    panel3.add(text2);
	    panel3.add(text3);
	    tbpanel.addTab("个人信息", panel3);
	    
	    setVisible(true);
	}

	
	
//	public static void main(String[] args) {
//		new shangjiaframe();
//	}

}
