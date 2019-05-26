package q3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainClass implements ActionListener{
	JFrame jf;
	JPanel p1,p2;
	JLabel l1,l2,l3,l11,l12,l13,l14,l15;
	JButton b1,b2;
	JTextField t1,t2,t11,t12,t13,t14;
	
	public static void main(String[] args) {
		MainClass mc=new MainClass();
		mc.setComponents();

	}
	public void setComponents() {
		jf= new JFrame("Form");
		
		p1=new JPanel();
		p2=new JPanel();
		
		l1=new JLabel("Insert into Representative Table-->");
		l2=new JLabel("RepNo.");
		l3=new JLabel("RepName");
		b1=new JButton("Insert");
		t1=new JTextField(5);
		t2=new JTextField(5);
		b1.setActionCommand("rep");
		b1.addActionListener(this);
		
		p1.setLayout(new FlowLayout());
		p1.add(l1);
		p1.add(l2);
		p1.add(t1);
		p1.add(l3);
		p1.add(t2);
		p1.add(b1);
		
		l11=new JLabel("Insert into Customer Table-->");
		l12=new JLabel("CustNo.");
		l13=new JLabel("CustomerName");
		l14=new JLabel("Credit_Limit");
		l15=new JLabel("RepNo.");
		b2=new JButton("Insert");
		t11=new JTextField(5);
		t12=new JTextField(5);
		t13=new JTextField(5);
		t14=new JTextField(5);
		b2.setActionCommand("cust");
		b2.addActionListener(this);
		
		p2.setLayout(new FlowLayout());
		p2.add(l11);
		p2.add(l12);
		p2.add(t11);
		p2.add(l13);
		p2.add(t12);
		p2.add(l14);
		p2.add(t13);
		p2.add(l15);
		p2.add(t14);
		p2.add(b2);
		
		
		jf.setLayout(new GridLayout(2,1));
		jf.add(p1);
		jf.add(p2);
		jf.setSize(800,250);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/examprac";
			Connection con=DriverManager.getConnection(url,"root","");
			if(e.getActionCommand().equals("rep")) {
				String q1="insert into Representative values(?,?)";
				PreparedStatement ps=con.prepareStatement(q1);
				ps.setString(1,t1.getText());
				ps.setString(2,t2.getText());
				ps.executeUpdate();
			}
			if(e.getActionCommand().equals("cust")) {
				String q2="insert into Customer values(?,?,?,?)";
				PreparedStatement ps=con.prepareStatement(q2);
				ps.setString(1,t11.getText());
				ps.setString(2,t12.getText());
				ps.setInt(3,Integer.parseInt(t13.getText()));
				ps.setString(4,t14.getText());
				ps.executeUpdate();
			}
			con.close();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
