package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
public class NewCustomer extends JFrame implements ActionListener{
    JTextField Tname, Taddress, Tcity, Tstate, Temail, Tphone;
    JButton create, cancel; JLabel L_Tmeterno;
    
    NewCustomer(){
        setSize(700, 500);
        setLocation(400, 200);
         
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel Lname = new JLabel("Customer Name");
        Lname.setBounds(100, 80, 100, 20);
        p.add(Lname);
        
        Tname = new JTextField();
        Tname.setBounds(240, 80, 200, 20);
        p.add(Tname);
        
        JLabel Lmeterno = new JLabel("Meter Number");
        Lmeterno.setBounds(100, 120, 100, 20);
        p.add(Lmeterno);
        
        L_Tmeterno = new JLabel("");
        L_Tmeterno.setBounds(240, 120, 100, 20);
        p.add(L_Tmeterno);
        
        Random r = new Random();
        long number = r.nextLong() % 1000000; // 6 digits
        L_Tmeterno.setText(("" + Math.abs(number))); // if no. are -ve
        
        JLabel Laddress = new JLabel("Address");
        Laddress.setBounds(100, 160, 100, 20);
        p.add(Laddress);
        
        Taddress = new JTextField();
        Taddress.setBounds(240, 160, 200, 20);
        p.add(Taddress);
        
        JLabel Lcity = new JLabel("City");
        Lcity.setBounds(100, 200, 100, 20);
        p.add(Lcity);
        
        Tcity = new JTextField();
        Tcity.setBounds(240, 200, 200, 20);
        p.add(Tcity);
        
        JLabel Lstate = new JLabel("State");
        Lstate.setBounds(100, 240, 100, 20);
        p.add(Lstate);
        
        Tstate = new JTextField();
        Tstate.setBounds(240, 240, 200, 20);
        p.add(Tstate);
        
        JLabel Lemail = new JLabel("Email Address");
        Lemail.setBounds(100, 280, 100, 20);
        p.add(Lemail);
        
        Temail = new JTextField();
        Temail.setBounds(240, 280, 200, 20);
        p.add(Temail);
        
        JLabel Lphone = new JLabel("Phone Number");
        Lphone.setBounds(100, 320, 100, 20);
        p.add(Lphone);
        
        Tphone = new JTextField();
        Tphone.setBounds(240, 320, 200, 20);
        p.add(Tphone);
        
        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setBounds(120, 390, 100, 25);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        p.add(create);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(250, 390, 100, 25);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        
        setLayout(new BorderLayout()); // default, but still
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
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
        String name = Tname.getText();
        String meter = L_Tmeterno.getText();
        String address = Taddress.getText();
        String city = Tcity.getText();
        String state = Tstate.getText();
        String email = Temail.getText();
        String phone = Tphone.getText();
        
        String query1 = "insert into customer values('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
        String query2 = "insert into login values ('"+meter+"', '', '"+name+"', '', '')";
        
        try{
            Conn c = new Conn();
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null, "Customer Details Added Sucessfully");
            setVisible(false);
            
            new MeterInfo(meter);
        } catch (Exception e){
            e.printStackTrace();
        }
     } else {
        setVisible(false); // cancel button
     }
    }
}
