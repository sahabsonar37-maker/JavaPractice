import java.sql.*;
import java.util.*;

public class DeleteDataJDBC
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        
        String url = "jdbc:mysql://localhost:3306/demodb";
        String username = "root";
        String password = "1234";
        
        System.out.println("Enter Student id to delete : ");
        int id = sc.nextInt();
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url,username,password);
            
            
            String query = "delete from student where id = ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            
            int row = pstmt.executeUpdate();
            
            if(row>0)
                System.out.println("Data Deleted");
            else 
                System.out.println("Failed to Delete");
            
            pstmt.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        // CRUD
        //Create
        //Read
        //Update
        //Delete
        
        
        
    }
}
