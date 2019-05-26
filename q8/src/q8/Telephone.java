package q8;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Telephone")
public class Telephone extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		String name=req.getParameter("name");
		String ph=req.getParameter("phone");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/examprac";
			Connection con=DriverManager.getConnection(url,"root","");
			PreparedStatement ps=null;
			PrintWriter out=res.getWriter();
			if(name.isEmpty()) {
				Integer phone=Integer.parseInt(ph);
				ps=con.prepareStatement("select * from teldir where phone=?");
				ps.setInt(1,phone);
			}
			else if(ph.isEmpty()) {
				ps=con.prepareStatement("select * from teldir where name=?");
				ps.setString(1,name);
			}
			if(ps.equals(null)) {
				out.println("<script>");
				out.println("alert('Empty Arguments');</script>");
			}
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				out.println("<script>");
				out.println("alert('Phone->"+rs.getInt("phone")
						+ "Name->"+rs.getString("name")
						+"City->"+rs.getString("city")+"');</script>");
			}else {
				out.println("<script>");
				out.println("alert('No such contact Found!');</script>");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("in last catch");
			e.printStackTrace();
		}
		
	}
}