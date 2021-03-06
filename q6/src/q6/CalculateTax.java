package q6;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculateTax")
public class CalculateTax extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String name=req.getParameter("name");
		Double salary=Double.parseDouble(req.getParameter("salary"));
		Double tax=Double.parseDouble(req.getParameter("tax"));
		BufferedWriter wr=new BufferedWriter(new FileWriter("C:\\Users\\SACHIN\\Desktop\\JavaExternal\\q6\\salary.txt"));
		wr.write("Name: "+name);
		wr.write("Original Salary: "+salary);
		wr.write("Tax Deducted"+tax);
		wr.write("Final Amount:"+(salary-tax));
		PrintWriter pw=res.getWriter();
		pw.println("Name: "+name+"<br>");
		pw.println("Original Salary: "+salary+"<br>");
		pw.println("Tax Deducted:"+tax+"<br>");
		pw.println("Final Amount:"+(salary-tax)+"<br>");
		pw.close();
		wr.close();
	}

}
