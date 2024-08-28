package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class CalculateBill extends JFrame implements ActionListener{
    JTextField Tunit;
    JLabel Ladd;
    JButton create, cancel; JLabel L_name;
    Choice meter_num, Cmonth;
    CalculateBill(){
        setSize(700, 500);
        setLocation(400, 200);
         
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel Lmeterno = new JLabel("Meter Number");
        Lmeterno.setBounds(100, 80, 100, 20);
        p.add(Lmeterno);
        
        meter_num = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                meter_num.add(rs.getString("meter_no"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        meter_num.setBounds(240, 80, 200, 20);
        p.add(meter_num);
        
        JLabel Lname = new JLabel("Name");
        Lname.setBounds(100, 120, 100, 20);
        p.add(Lname);
        
        L_name = new JLabel();
        L_name.setBounds(240, 120, 100, 20);
        p.add(L_name);
        
        JLabel Laddress = new JLabel("Address");
        Laddress.setBounds(100, 160, 100, 20);
        p.add(Laddress);
        
        Ladd = new JLabel();
        Ladd.setBounds(240, 160, 200, 20);
        p.add(Ladd);
        
        meter_num.addItemListener(new ItemListener() { // item - event for dynamic change
           public void itemStateChanged(ItemEvent ie){
               try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" +meter_num.getSelectedItem()+ "'");
                    while(rs.next()){
                        L_name.setText(rs.getString("name"));
                        Ladd.setText(rs.getString("address"));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
           } 
        });
         
        JLabel Lunit = new JLabel("Unit Consumed");
        Lunit.setBounds(100, 200, 100, 20);
        p.add(Lunit);
        
        Tunit = new JTextField();
        Tunit.setBounds(240, 200, 200, 20);
        p.add(Tunit);
        
        JLabel Lstate = new JLabel("Month");
        Lstate.setBounds(100, 240, 100, 20);
        p.add(Lstate);
        
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
        Cmonth.setBounds(240, 240, 200, 20);
        p.add(Cmonth);
        
        
        create = new JButton("Calculate");
        create.setBackground(Color.BLACK);
        create.setBounds(120, 320, 100, 25);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        p.add(create);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(250, 320, 100, 25);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout()); // default, but still
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img, "West");
        
        getContentPane().setBackground(Color.white);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource() == create){
        String meter = meter_num.getSelectedItem();
        String units = Tunit.getText();
        String months = Cmonth.getSelectedItem();
        
        int totalbill = 0;
        int unit_int = Integer.parseInt(units);
        
        String query = "select * from tax";
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                totalbill += unit_int * Integer.parseInt(rs.getString("cost_per_unit"));
                totalbill += Integer.parseInt(rs.getString("meter_rent"));
                totalbill += Integer.parseInt(rs.getString("service_charge"));
                totalbill += Integer.parseInt(rs.getString("service_tax"));
                totalbill += Integer.parseInt(rs.getString("swacch_bharat_cess"));
                totalbill += Integer.parseInt(rs.getString("fixed_tax"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        
        String query1 = "insert into bill values('"+meter+"', '"+months+"', '"+units+"', '"+totalbill+"', 'Not Paid')";
        try{
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            JOptionPane.showMessageDialog(null, "Customer Bill Updated Sucessfully");
        } catch (Exception e){
         e.printStackTrace();
        }
     } else {
        setVisible(false); // cancel button
     }
    }
}
