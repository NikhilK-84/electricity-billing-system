package electricity.billing.system;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn(){
        // Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "jupiterspc");
            s = c.createStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
