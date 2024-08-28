package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*; // need to import subpackages differently
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
    JButton create, back;
    JTextField nameIP, userIP, meterIP, passIP;
    Choice accountTyp;
    Signup(){
        setSize(700, 400);
        setLocation(450, 150); // we can also use setbounds instead
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 650, 300);
        panel.setBorder(new TitledBorder(new LineBorder(Color.BLUE), "Create-New-Account", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(Color.DARK_GRAY); // font
        add(panel);
        
        JLabel heading = new JLabel("Create Account");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(Color.gray);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(heading);
        
        accountTyp = new Choice();
        accountTyp.add("Admin");
        accountTyp.add("Customer");
        accountTyp.setBounds(260, 50, 150, 20);
        panel.add(accountTyp);
        
        JLabel meter = new JLabel("Meter Number");
        meter.setBounds(100, 90, 140, 20);
        meter.setForeground(Color.gray);
        meter.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(meter);
        
        meterIP = new JTextField();
        meterIP.setBounds(260, 90, 150, 20);
        panel.add(meterIP);  
        
        meter.setVisible(false);
        meterIP.setVisible(false);
                   
        JLabel username = new JLabel("Username");
        username.setBounds(100, 130, 140, 20);
        username.setForeground(Color.gray);
        username.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(username);
        
        userIP = new JTextField();
        userIP.setBounds(260, 130, 150, 20);
        panel.add(userIP);
        
        JLabel name = new JLabel("Name");
        name.setBounds(100, 170, 140, 20);
        name.setForeground(Color.gray);
        name.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(name);
        
        nameIP = new JTextField();
        nameIP.setBounds(260, 170, 150, 20);
        panel.add(nameIP);
        
        meterIP.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){}
            
            @Override
            public void focusLost(FocusEvent fe) {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from login where meter_no = '" + meterIP.getText() + "'");
                    while(rs.next()){
                        nameIP.setText(rs.getString("name"));
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(100, 210, 140, 20);
        pass.setForeground(Color.gray);
        pass.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(pass);
        
        passIP = new JTextField();
        passIP.setBounds(260, 210, 150, 20);
        panel.add(passIP);
        
        accountTyp.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ie){
               String user = accountTyp.getSelectedItem();
               if(user.equals("Customer")){
                   meter.setVisible(true);
                   meterIP.setVisible(true);
                   nameIP.setEditable(false);
               } else {
                   meter.setVisible(false);
                   meterIP.setVisible(false);
                   nameIP.setEditable(true);
               }
           } 
        });
        
        create = new JButton("Create");
        create.setBounds(120, 260, 120, 25);
        create.setBackground(Color.DARK_GRAY);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        panel.add(create);
        
        back = new JButton("Back");
        back.setBounds(260, 260, 120, 25);
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(415, 30, 250, 250);
        panel.add(img);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Login();
        } else if (ae.getSource() == create){
            String Sacctype = accountTyp.getSelectedItem();
            String Susername = userIP.getText();
            String Spass = passIP.getText();
            String Sname = nameIP.getText();
            String Smeter = meterIP.getText();
            
            try{
                Conn c = new Conn();
                String query = null;
                if(Sacctype.equals("Admin"))
                    query = "insert into login values('"+ Smeter +"', '"+ Susername +"', '"+ Sname +"', '"+ Spass +"', '"+ Sacctype +"')";
                else 
                    query = "update login set username = '" + Susername + "', pass = '" + Spass + "', user_type = '" + Sacctype + "' where meter_no = '" + Smeter + "'";
                c.s.executeUpdate(query); // dml
                JOptionPane.showMessageDialog(null, "Account Created Sucessfully");
                
                setVisible(false);
                new Login();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
