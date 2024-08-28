package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateInfo extends JFrame implements ActionListener{
    JTextField Taddress, Tcity, Temail, Tstate, Tphone;
    JButton update, cancel;
    String meter_num;
    JLabel name, meter_no;
    UpdateInfo(String meter_num){
        this.meter_num = meter_num;
        setBounds(300, 150, 1050, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110, 0, 400, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);
        
        JLabel Lname = new JLabel("Name");
        Lname.setBounds(30, 70, 100, 20);
        add(Lname);
        name = new JLabel("");
        name.setBounds(230, 80, 200, 20);
        add(name);
        
        JLabel Lmeter_no = new JLabel("Meter Number");
        Lmeter_no.setBounds(30, 110, 100, 20);
        add(Lmeter_no); 
        meter_no = new JLabel();
        meter_no.setBounds(230, 110, 200, 20);
        add(meter_no);
        
        JLabel Laddress = new JLabel("Address");
        Laddress.setBounds(30, 150, 100, 20);
        add(Laddress); 
        Taddress = new JTextField();
        Taddress.setBounds(230, 150, 200, 20);
        add(Taddress);
        
        JLabel Lcity = new JLabel("City");
        Lcity.setBounds(30, 190, 100, 20);
        add(Lcity); 
        Tcity = new JTextField();
        Tcity.setBounds(230, 190, 200, 20);
        add(Tcity);
        
        JLabel Lstate = new JLabel("State");
        Lstate.setBounds(30, 230, 100, 20);
        add(Lstate); 
        Tstate = new JTextField();
        Tstate.setBounds(230, 230, 200, 20);
        add(Tstate);
        
        JLabel Lemail = new JLabel("Email");
        Lemail.setBounds(30, 270, 100, 20);
        add(Lemail); 
        Temail = new JTextField();
        Temail.setBounds(230, 270, 200, 20);
        add(Temail);
        
        JLabel Lphone = new JLabel("Phone Number");
        Lphone.setBounds(30, 310, 100, 20);
        add(Lphone); 
        Tphone = new JTextField();
        Tphone.setBounds(230, 310, 200, 20);
        add(Tphone);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '" + meter_num +"'");
            while(rs.next()){
                name.setText(rs.getString("name"));
                Taddress.setText(rs.getString("address"));
                Tcity.setText(rs.getString("city"));
                Tstate.setText(rs.getString("state"));
                Temail.setText(rs.getString("email"));
                Tphone.setText(rs.getString("phone"));
                meter_no.setText(rs.getString("meter_no"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(70, 360, 100, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(230, 360, 100, 25);
        update.addActionListener(this);
        add(update);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(550, 50, 400, 300);
        add(img);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String Saddress = Taddress.getText();
            String Scity = Tcity.getText();
            String Semail = Temail.getText();
            String Sphone = Tphone.getText();
            String Sstate = Tstate .getText();
            try{
                Conn c = new Conn();
                String query = "update customer set address = '"+Saddress+"', city = '"+Scity+"', state = '"+Sstate+"', email = '"+Semail+"', phone = '"+Sphone+"' where meter_no = '"+meter_num+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "User Information Updated Sucessfully");
                setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
}
