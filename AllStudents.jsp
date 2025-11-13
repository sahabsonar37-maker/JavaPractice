<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>
<body>

<!--  Directive -->
<%@ page import = "java.sql.*" %>



<h1>All Students</h1>
<ul>


<!--  Declaration -->
<!--  
	// Connection con;
	Statement stmt;
	ResultSet rs;


-->



<!-- Scriptlet -->
<%



try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	String url="jdbc:mysql://localhost:3306/demodb";
	String user= "root";
	String password = "1234";
	
	Connection con = DriverManager.getConnection(url,user,password);
	
	String query = "select name from student";
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(query);
	
	while(rs.next())
	{
		
	%>

		<li>
		<!-- Expression -->
		<%= rs.getString("name") %>
		</li>
		
	<% 
	}
	
	con.close();
	stmt.close();
	rs.close();
}
catch(Exception e)
{
	e.getMessage();
}
%>	








	<li></li>
	

</ul>

</body>
</html>
