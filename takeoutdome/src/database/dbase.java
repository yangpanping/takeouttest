package database;
/**
 * �������ݿ⽻������
 */

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import frame.shangjiaframe;
import frame.shangjialogin;
import frame.userframe;
import frame.userlogin;

public class dbase {
	static Connection cn = null;
	static Statement  sm = null;
	static ResultSet rs = null;
	static ResultSet rs1 = null;
	
	static StringBuffer sb = new StringBuffer();
	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2= new StringBuffer();
	static StringBuffer sb3= new StringBuffer();
	static StringBuffer sb4= new StringBuffer();
	static String[][] userframe1 = null;
	static String[][] dingdan1 = null;
	static String[][] dingdan2 = null;
	static String[][] dingdan3 = null;
	static String[][] shangjiainfo = null;
	static String[][] shangjiadingdan = null;
	
	
	static String name ;
	static String phone;
	static String adress;
	
	static String dingdanusername;
	static String dingdanshangjianame;
	static String dingdancaidanname;
	static String dingdantallprice;
	static String dingdanuseraddress;
	static String dingdannumber;
	static String dingdanuserphone;
	static String dingdanshangjiaphone;
	static String dingdanstatues;
	
	static String url = "jdbc:mysql://127.0.0.1:3306/takeoutserve?serverTimezone=UTC";
	static String user="root";
	static String pass ="ypp6217";
	static String forname ="com.mysql.cj.jdbc.Driver";
	static {
	if(cn == null) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    cn = DriverManager.getConnection(url, user, pass);
		    sm = cn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
private dbase() {//��չ��췽������ֹ����dbbase���ʾ�ж���
		
	}
//�ַ����ָ��һ����ά����
public static String[][] toArray(String str){
	String[] split = str.split("%");
	String[][] array = new String[split.length][];
	for(int i =0;i<split.length;i++) {
		array[i]=split[i].split(";");
	}
	return array;
}
//�û������̼���Ϣ
	public static String[][] getinfo() throws SQLException{
		try {
			rs = sm.executeQuery("select * from shangjia");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(rs.next()) {
			sb.append(rs.getString(2));
			sb.append(";");
			sb.append(rs.getString(6));
			sb.append("%");
		}
		String str = sb.toString();
		userframe1 = toArray(str);
		return userframe1;
		
	}
//�û���¼����
public static boolean checkLogin(String userStr, String passStr)
		throws SQLException {
	 rs = sm.executeQuery("select * from user where user_phone='"
			+ userStr + "' and user_password='" + passStr + "'");
	if (rs == null)
		return false;
	return rs.next();
}
//�̼ҵ�¼����
public static boolean shangjiacheckLogin(String userStr, String passStr)
		throws SQLException {
	 rs = sm.executeQuery("select * from shangjia where shangjia_phone='"
			+ userStr + "' and shangjia_password='" + passStr + "'");
	if (rs == null)
		return false;
	return rs.next();
} 
//�û���Ϣ
public static void userinfo(String a) {
	try {
		rs = sm.executeQuery("select * from user where user_phone = '"+a+"' limit 1");
		while(rs.next()){
			 name = rs.getString(2);
			phone = rs.getString(3);
			adress = rs.getString(5);
			
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//�̼���Ϣ
public static void shangjiainfo(String a) {
	try {
		rs = sm.executeQuery("select * from shangjia where shangjia_phone ='"+a+"' limit 1");
		while(rs.next()) {
			name = rs.getString(2);
			phone = rs.getString(3);
			adress = rs.getString(5);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//����������Ϣ-�û�
public static String[][] dingdan1() {
	try {
		rs1 = sm.executeQuery("select * from dingdan where user_phone = '"+userlogin.getuserphone()+"'");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		while(rs1.next()) {
			sb1.append(rs1.getString(8));
			sb1.append(";");
			sb1.append(rs1.getString(7));
			sb1.append("%");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String str = sb1.toString();
	shangjiainfo = toArray(str);
	
	return shangjiainfo;
}
//����������Ϣ-�̼�
public static String[][] shangjiadingdan1() {
	try {
		rs1 = sm.executeQuery("select * from dingdan where shangjia_phone = '17754925973'");
	    
		while(rs1.next()) {
			sb3.append(rs1.getString(8));
			sb3.append(";");
			sb3.append(rs1.getString(7));
			sb3.append("%");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String str = sb3.toString();
	shangjiadingdan = toArray(str);
	
	return shangjiadingdan;
}
//������ϸ��Ϣ-�û�
public static void dingdan2(String a){
	try {
		rs = sm.executeQuery("select * from dingdan where dingdan_number = '"+ a+"'");
		while(rs.next()) {
			dingdanusername = rs.getString(2);
			dingdanshangjianame=rs.getString(3);
			dingdancaidanname=rs.getString(4);
			dingdantallprice=rs.getString(5);
			dingdanuseraddress=rs.getString(6);
			dingdanstatues=rs.getString(7);
			dingdannumber = rs.getString(8);
			dingdanuserphone=rs.getString(9);
			dingdanshangjiaphone=rs.getString(10);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
//һ���̵�Ĳ˵���Ϣ
public static String[][] oneshangjia(String a) {
	try {
		rs = sm.executeQuery("select * from caidan where caidab_shangjia  = '"+a+"'");
		while(rs.next()) {
		sb2.append(rs.getString(2).trim());
		sb2.append(";");
		sb2.append(rs.getString(3).trim());
		sb2.append("%");
		}
		String str = sb2.toString();
		dingdan3 = toArray(str);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return dingdan3;
}
//����̵꣬�û���ȡ�̵�ĵ绰{
public static String shangjiaphone(String a) {
	try {
		rs = sm.executeQuery("select * from shangjia where shangjia_name = '"+a+"'");
		while(rs.next()) {
		phone = rs.getString(3);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return phone;
}
//����һ������
public static void insertdingdan(String a,String b,String c,String d,String e,String f,String g,String h,String i) throws SQLException {
	rs = sm.executeQuery("select id from dingdan");
	rs.last();
	int idadd = rs.getRow()+1;
	String sql = "insert into dingdan values ('"+idadd+"','"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+i+"')";
	PreparedStatement pr = cn.prepareStatement(sql);
	pr.executeUpdate();
}


public static String getDingdanusername() {

	return dingdanusername;
}
public static void setDingdanusername(String dingdanusername) {
	dbase.dingdanusername = dingdanusername;
}
public static String getDingdanshangjianame() {

	return dingdanshangjianame;
}
public static void setDingdanshangjianame(String dingdanshangjianame) {
	dbase.dingdanshangjianame = dingdanshangjianame;
}
public static String getDingdancaidanname() {

	return dingdancaidanname;
}
public static void setDingdancaidanname(String dingdancaidanname) {
	dbase.dingdancaidanname = dingdancaidanname;
}
public static String getDingdantallprice() {

	return dingdantallprice;
}
public static void setDingdantallprice(String dingdantallprice) {
	dbase.dingdantallprice = dingdantallprice;
}
public static String getDingdanuseraddress() {

	return dingdanuseraddress;
}
public static void setDingdanuseraddress(String dingdanuseraddress) {
	dbase.dingdanuseraddress = dingdanuseraddress;
}
public static String getDingdannumber() {

	return dingdannumber;
}
public static void setDingdannumber(String dingdannumber) {
	dbase.dingdannumber = dingdannumber;
}
public static String getDingdanuserphone() {

	return dingdanuserphone;
}
public static void setDingdanuserphone(String dingdanuserphone) {
	dbase.dingdanuserphone = dingdanuserphone;
}
public static String getDingdanshangjiaphone() {

	return dingdanshangjiaphone;
}
public static void setDingdanshangjiaphone(String dingdanshangjiaphone) {
	dbase.dingdanshangjiaphone = dingdanshangjiaphone;
}
public static String getDingdanstatues() {

	return dingdanstatues;
}
public static void setDingdanstatues(String dingdanstatues) {
	dbase.dingdanstatues = dingdanstatues;
}
public static String getname() {

	return name;
}
public static String getphone() {

	return phone;
}
public static String getaddress() {

		return adress;
	}
//	public static void main(String[] args) {
//	dbase b =	new dbase();
//	//b.ypp();
//	String[][] a = shangjiadingdan1();
//	for(int i =0;i<a.length;i++) {
//		for(int j = 0;j<a.length;j++) {
//			System.out.println(a[i][j]);
//		}
//	}
//	}
}
