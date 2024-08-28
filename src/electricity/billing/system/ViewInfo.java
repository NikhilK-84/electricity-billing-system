package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class ViewInfo extends JFrame implements ActionListener{
    JButton cancel;
    ViewInfo(String meter_num){
        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);
        
        JLabel Lname = new JLabel("Name");
        Lname.setBounds(70, 80, 100, 20);
        add(Lname);
        JLabel name = new JLabel("");
        name.setBounds(250, 80, 100, 20);
        add(name);
        
        JLabel Lmeter_no = new JLabel("Meter Number");
        Lmeter_no.setBounds(70, 140, 100, 20);
        add(Lmeter_no); 
        JLabel meter_no = new JLabel("");
        meter_no.setBounds(250, 140, 100, 20);
        add(meter_no);
        
        JLabel Laddress = new JLabel("Address");
        Laddress.setBounds(70, 200, 100, 20);
        add(Laddress); 
        JLabel address = new JLabel("");
        address.setBounds(250, 200, 100, 20);
        add(address);
        
        JLabel Lcity = new JLabel("City");
        Lcity.setBounds(70, 260, 100, 20);
        add(Lcity); 
        JLabel city = new JLabel("");
        city.setBounds(250, 260, 100, 20);
        add(city);
        
        JLabel Lstate = new JLabel("State");
        Lstate.setBounds(500, 80, 100, 20);
        add(Lstate); 
        JLabel state = new JLabel("");
        state.setBounds(650, 80, 100, 20);
        add(state);
        
        JLabel Lemail = new JLabel("Email");
        Lemail.setBounds(500, 140, 100, 20);
        add(Lemail); 
        JLabel email = new JLabel("");
        email.setBounds(650, 140, 100, 20);
        add(email);
        
        JLabel Lphone = new JLabel("Phone Number");
        Lphone.setBounds(500, 200, 100, 20);
        add(Lphone); 
        JLabel phone = new JLabel("");
        phone.setBounds(650, 200, 100, 20);
        add(phone);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter_num +"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                state.setText(rs.getString("state"));
                email.setText(rs.getString("email"));
                phone.setText(rs.getString("phone"));
                meter_no.setText(rs.getString("meter_no"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350, 340, 100, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(20, 350, 600, 300);
        add(img);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
}
