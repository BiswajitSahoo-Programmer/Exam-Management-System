
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Conn
{
       Connection c;
        Statement s;
    Conn()
    {
       
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///studentexamapplication", "root","2002");
            s = c.createStatement();


        }
        catch(Exception e)
        {
            e.printStackTrace();

        }


    }
    public PreparedStatement PreparedStatement(String string) {
        return null;
    }
    
}
