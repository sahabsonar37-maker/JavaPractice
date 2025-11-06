import java.sql.*;

public class ShowDataJDBC 
{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://localhost:3306/demodb";
        String username = "root";
        String password = "1234";
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url,username,password);
            
            
            String query = "select * from student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                System.out.println(rs.getInt("id")+" | "+rs.getString("name")+" | "+rs.getString("marks"));
            }
            
            rs.close();
            stmt.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
    }
}
