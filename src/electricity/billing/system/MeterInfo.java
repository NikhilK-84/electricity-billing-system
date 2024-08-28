package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;
public class MeterInfo extends JFrame implements ActionListener{
    JButton create, cancel; JLabel L_Tmeterno;
    Choice Clocation, Ctype, Ccode, Cbilltype;
    String meter_no;
    MeterInfo(String meter_no){
        this.meter_no = meter_no;
        setSize(700, 500);
        setLocation(400, 200);
         
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(180, 10, 200, 20);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel Lnum = new JLabel("Meter Number");
        Lnum.setBounds(100, 80, 100, 20);
        p.add(Lnum);
        
        JLabel L_Tnum = new JLabel(meter_no);
        L_Tnum.setBounds(240, 80, 100, 20);
        p.add(L_Tnum);
        
        JLabel Llocation = new JLabel("Meter Location");
        Llocation.setBounds(100, 120, 100, 20);
        p.add(Llocation);
        
        Clocation = new Choice();
        Clocation.add("Outside");
        Clocation.add("Inside");
        Clocation.setBounds(240, 120, 200, 20);
        p.add(Clocation);
        
        JLabel Ltype = new JLabel("Meter Type");
        Ltype.setBounds(100, 160, 100, 20);
        p.add(Ltype);
        
        Ctype = new Choice();
        Ctype.add("Electric Meter");
        Ctype.add("Solar Meter");
        Ctype.add("Smart Meter");
        Ctype.setBounds(240, 160, 200, 20);
        p.add(Ctype);
        
        JLabel Lcode = new JLabel("Phase Code");
        Lcode.setBounds(100, 200, 100, 20);
        p.add(Lcode);
        
        Ccode = new Choice();
        Ccode.add("011");
        Ccode.add("022");
        Ccode.add("033");
        Ccode.add("044");
        Ccode.add("055");
        Ccode.add("066");
        Ccode.add("077");
        Ccode.add("088");
        Ccode.add("099");
        Ccode.setBounds(240, 200, 200, 20);
        p.add(Ccode);
        
        JLabel Lbilltype = new JLabel("Bill Type");
        Lbilltype.setBounds(100, 240, 100, 20);
        p.add(Lbilltype);
        
        Cbilltype = new Choice();
        Cbilltype.add("Normal");
        Cbilltype.add("Industrial");
        Cbilltype.setBounds(240, 240, 200, 20);
        p.add(Cbilltype);
        
        JLabel Ldays = new JLabel("Days");
        Ldays.setBounds(100, 280, 100, 20);
        p.add(Ldays);
        
        
        JLabel L30days = new JLabel("30 Days");
        L30days.setBounds(240, 280, 100, 20);
        p.add(L30days);
        
        JLabel Lnote = new JLabel("Note");
        Lnote.setBounds(100, 320, 100, 20);
        p.add(Lnote);
        
        String note = "By default bill is calculated for 30 days only";
        JLabel Lnoteval = new JLabel(note);
        Lnoteval.setBounds(240, 320, 500, 20);
        p.add(Lnoteval);
        
        
        create = new JButton("Submit");
        create.setBackground(Color.BLACK);
        create.setBounds(220, 390, 100, 25);
        create.setForeground(Color.WHITE);
        create.addActionListener(this);
        p.add(create);
        
       
        
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
        String meter = meter_no;
        String code = Ccode.getSelectedItem();
        String location = Clocation.getSelectedItem();
        String type = Ctype.getSelectedItem();
        String bill_type = Cbilltype.getSelectedItem();
        String days = "30";
        
        String query = "insert into meter_info values('"+meter+"','"+location+"','"+type+"','"+code+"','"+bill_type+"','"+days+"')";
        
        
        try{
            Conn c = new Conn();
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Meter Information Added Sucessfully");
            setVisible(false);
            
        } catch (Exception e){
            e.printStackTrace();
        }
     } else {
        setVisible(false); // cancel button
     }
    }
}
