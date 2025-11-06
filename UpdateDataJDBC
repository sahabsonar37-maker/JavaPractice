import java.sql.*;
import java.util.*;

public class UpdateDataJDBC
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        
        String url = "jdbc:mysql://localhost:3306/demodb";
        String username = "root";
        String password = "1234";
        
        System.out.println("Enter Student id to update : ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Student New Name :");
        String name = sc.nextLine();
        
        System.out.println("Student New marks :");
        String marks = sc.nextLine();
        
        
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url,username,password);
            
            
            String query = "update student set name=?,marks=? where id = ?";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1,name);
            pstmt.setString(2,marks);
            pstmt.setInt(3,id);
            
            int row = pstmt.executeUpdate();
            
            if(row>0)
                System.out.println("Data Updated");
            else 
                System.out.println("Failed to Update Data");
            
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
