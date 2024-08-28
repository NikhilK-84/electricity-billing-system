package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class DepositDetails extends JFrame implements ActionListener{
    Choice Cmeter, Cmonth;
    JTable table;
    JButton search, print;
    DepositDetails(){
        super("Deposit Details");
        
        setSize(700, 700);
        setLocation(400, 100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel Lmeter = new JLabel("Search By Meter Number");
        Lmeter.setBounds(20, 20, 150, 20);
        add(Lmeter);
        
        Cmeter = new Choice();
        Cmeter.setBounds(180, 20, 150, 20);
        add(Cmeter);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                Cmeter.add(rs.getString("meter_no"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        JLabel Lmonth = new JLabel("Search By Month");
        Lmonth.setBounds(400, 20, 100, 20);
        add(Lmonth);
       
        Cmonth = new Choice();
        Cmonth.add("January");
        Cmonth.add("February");
        Cmonth.add("March");
        Cmonth.add("April");
        Cmonth.add("May");
        Cmonth.add("June");
        Cmonth.add("July");
        Cmonth.add("August");
        Cmonth.add("September");
        Cmonth.add("October");
        Cmonth.add("November");
        Cmonth.add("December");
        Cmonth.setBounds(520, 20, 150, 20);
        add(Cmonth);
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bill");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(table); // add scroll bar
        sp.setBounds(0, 100, 700, 600);
        add(sp);
        
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        add(print);
        print.addActionListener(this);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            String query = "select * from bill where meter_no = '" + Cmeter.getSelectedItem() + "' and month = '" + Cmonth.getSelectedItem() + "'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            try{
                table.print(); // opens printer if supported by system
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
