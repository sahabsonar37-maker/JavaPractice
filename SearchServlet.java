

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import java.sql.*;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		PrintWriter pw = res.getWriter();
		
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			String url = "jdbc:mysql://localhost:3306/demodb";
			String username = "root";
			String password = "1234";
			
			Connection con = DriverManager.getConnection(url,username,password);
			
			String query = "select * from student where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				pw.println("Data found");
				pw.println("Your name is "+rs.getString("name"));
				pw.println("Your marks are "+rs.getString("marks"));
			}
			else
			{
				pw.println("Not found");
			}
			
			
			pst.close();
			rs.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

