package frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.dbase;

/**
 * 这是用户查看每个商家的菜品
 * @author ypp
 *
 */
public class usershangjiaframe extends JFrame{
	static JTextField atext = new JTextField(10);
	static JTextField btext = new JTextField(5);
	static String caipin;
	static String jiage;
	DefaultTableModel tablemodel;

	public usershangjiaframe() {
		super();
		// TODO Auto-generated constructor stub
		setTitle("态");
		setBounds(800, 500, 400, 500);
		JScrollPane spane = new JScrollPane();
		getContentPane().add(spane,BorderLayout.CENTER);
		String[] column = {"菜单","价格"};
		String[][] values = dbase.oneshangjia(userframe.shangdanname);
		tablemodel = new DefaultTableModel(values,column);
		
		JTable table = new JTable(tablemodel);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selected = table.getSelectedRow();
				Object oa = table.getValueAt(selected, 0);
				Object ob = table.getValueAt(selected, 1);
				caipin = oa.toString();
				jiage = ob.toString();
				atext.setText(caipin);
				btext.setText(jiage);
			}
		});
		spane.setViewportView(table);
		
		JPanel panel = new JPanel();
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new creatdingdanframe();
			}
		});
		panel.add(atext);
		panel.add(btext);
		panel.add(button);
		getContentPane().add(panel,BorderLayout.SOUTH);
		
		
		setVisible(true);
	}

	public static String getCaipin() {
		return caipin;
	}

	

	public static String getJiage() {
		return jiage;
	}

	




}
