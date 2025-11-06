import java.sql.*;
import java.util.*;

public class InsertDataJDBC
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        
        String url = "jdbc:mysql://localhost:3306/demodb";
        String username = "root";
        String password = "1234";
        
        System.out.println("Enter Student id : ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Student Name :");
        String name = sc.nextLine();
        
        System.out.println("Student marks :");
        String marks = sc.nextLine();
        
        
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url,username,password);
            
            
            String query = "insert into student(id,name,marks) values(?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.setString(2,name);
            pstmt.setString(3,marks);
            
            int row = pstmt.executeUpdate();
            
            if(row>0)
                System.out.println("Data Inserted");
            else 
                System.out.println("Failed to Insert");
            
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
