
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class PayBill extends JFrame implements ActionListener{
    Choice Cmonth;
    JButton pay, back;
    String meter_no;
    PayBill(String meter_no){
        this.meter_no = meter_no;
        setLayout(null);
        setBounds(300, 150, 900, 600);
        
        JLabel heading = new JLabel("Electricity Bill");
        heading.setBounds(120, 5, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        add(heading);
        
        JLabel Lmeter_no = new JLabel("Meter Number");
        Lmeter_no.setBounds(35, 80, 200, 20);
        add(Lmeter_no);
        
        JLabel meter_num = new JLabel("");
        meter_num.setBounds(300, 80, 200, 20);
        add(meter_num);
        
        JLabel Lname = new JLabel("Name");
        Lname.setBounds(35, 140, 200, 20);
        add(Lname);
        
        JLabel name = new JLabel("");
        name.setBounds(300, 140, 200, 20);
        add(name);
        
        JLabel Lmonth = new JLabel("Month");
        Lmonth.setBounds(35, 200, 200, 20);
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
        Cmonth.setBounds(300, 200, 200, 20);
        add(Cmonth);
        
        JLabel Lunit = new JLabel("Units");
        Lunit.setBounds(35, 260, 200, 20);
        add(Lunit);
        
        JLabel unit = new JLabel("");
        unit.setBounds(300, 260, 200, 20);
        add(unit);
        
        JLabel Ltotalbill = new JLabel("Total Bill");
        Ltotalbill.setBounds(35, 320, 200, 20);
        add(Ltotalbill);
        
        JLabel totalbill = new JLabel("");
        totalbill.setBounds(300, 320, 200, 20);
        add(totalbill);
        
        JLabel Lstatus = new JLabel("Status");
        Lstatus.setBounds(35, 380, 200, 20);
        add(Lstatus);
        
        JLabel status = new JLabel("");
        status.setBounds(300, 380, 200, 20);
        status.setForeground(Color.RED);
        add(status);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter_no + "'");
            while(rs.next()){
                meter_num.setText(meter_no);
                name.setText(rs.getString("name"));
            }
            
            rs = c.s.executeQuery("select * from bill where meter_no = '" + meter_no +"' AND month = 'January'"); // initially its jan
            while(rs.next()){
                unit.setText(rs.getString("units"));
                totalbill.setText(rs.getString("total_bill"));
                status.setText(rs.getString("status"));
                
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        Cmonth.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter_no = '" + meter_no +"' AND month = '"+Cmonth.getSelectedItem()+"'");
                    if (rs.next()) {
                        unit.setText(rs.getString("units"));
                        totalbill.setText(rs.getString("total_bill"));
                        status.setText(rs.getString("status"));
                    } else {
                        // Clear fields if no record is found
                        unit.setText("");
                        totalbill.setText("");
                        status.setText("");
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(100, 460, 100, 25);
        pay.addActionListener(this);
        add(pay);
        
        back = new JButton("Go Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230, 460, 100, 25);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(400, 120, 600, 300);
        add(img);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == pay){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter_no+"' AND month = '" + Cmonth.getSelectedItem() + "'");
            } catch(Exception e){
                e.printStackTrace();
            }
            setVisible(false);
            new Paytm(meter_no);
        } else {
            setVisible(false);
        }
    }
}
