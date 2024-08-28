package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class CustomerDetails extends JFrame implements ActionListener{
    JTable table;
    JButton print;
    CustomerDetails(){
        super("Customer Details");
        
        setSize(1200, 650);
        setLocation(200, 150);
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table); // add scroll bar
        add(sp);
       
        print = new JButton("Print");
        add(print, "South");
        print.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            table.print(); // opens printer if supported by system
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
