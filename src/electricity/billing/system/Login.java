package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton bLogin, bCancel, bSignup;
    JTextField passIP, userIP;
    Choice loginin;
    Login(){
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        userIP = new JTextField();
        userIP.setBounds(400, 20, 150, 20);
        add(userIP);
        
        passIP = new JTextField();
        passIP.setBounds(400, 60, 150, 20);
        add(passIP);
        
        JLabel username = new JLabel("Username");
        username.setBounds(300, 20, 100, 20);
        add(username);
        
        JLabel password = new JLabel("Password");
        password.setBounds(300, 60, 100, 20);
        add(password);
        
        JLabel login = new JLabel("Login as");
        login.setBounds(300, 100, 100, 20);
        add(login);
        
        loginin = new Choice();
        loginin.add("Admin");
        loginin.add("Customer");
        loginin.setBounds(400, 100, 150, 20);
        add(loginin);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i2 = i1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        bLogin = new JButton("Login", new ImageIcon(i2));
        bLogin.setBounds(330, 160, 100, 20);
        bLogin.addActionListener(this);
        add(bLogin);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i4 = i3.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        bCancel = new JButton("Cancel", new ImageIcon(i4));
        bCancel.setBounds(450, 160, 100, 20);
        bCancel.addActionListener(this);
        add(bCancel);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i6 = i5.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        bSignup = new JButton("Sign-up", new ImageIcon(i6));
        bSignup.setBounds(380, 200, 100, 20);
        bSignup.addActionListener(this);
        add(bSignup);
        
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        Image i8 = i7.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel img = new JLabel(i9);
        img.setBounds(0, 0, 250, 250);
        add(img);
        
        setSize(640, 300);
        setLocation(400, 200);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == bLogin){
            String Susername = userIP.getText();
            String Spass = passIP.getText();
            String Schoice = loginin.getSelectedItem();
            try{
                Conn c = new Conn();
                String query = "select * from login where username = '" + Susername + "' and pass = '" + Spass + "' and user_type = '" + Schoice + "'";
                ResultSet rs = c.s.executeQuery(query); // ddl
                if(rs.next()){
                    String meter_no = rs.getString("meter_no");
                    setVisible(false);
                    new Project(Schoice, meter_no);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                    userIP.setText("");
                    passIP.setText("");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == bCancel){
            setVisible(false);
        } else if (ae.getSource() == bSignup){
            setVisible(false);
            new Signup();
        }
    }
}
