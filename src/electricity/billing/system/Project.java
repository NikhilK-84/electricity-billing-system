
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
    String a_type, meter_no;
    Project(String a_type, String meter_no){
        this.a_type = a_type;
        this.meter_no = meter_no;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // max len-width
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);
        
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        
        JMenu menu = new JMenu("Master");
        menu.setForeground(Color.BLUE);
        
        
        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced", Font.PLAIN, 12));
        newCustomer.setBackground(Color.WHITE);
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image img1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(img1));
        newCustomer.setMnemonic('D');
        newCustomer.addActionListener(this);
        newCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        menu.add(newCustomer);
        
        JMenuItem customerDetails = new JMenuItem("Customer Details");
        customerDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        customerDetails.setBackground(Color.WHITE);
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        Image img2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerDetails.setIcon(new ImageIcon(img2));
        customerDetails.setMnemonic('M');
        customerDetails.addActionListener(this);
        customerDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        menu.add(customerDetails);
        
        JMenuItem depositDetails = new JMenuItem("Deposit Details");
        depositDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        depositDetails.setBackground(Color.WHITE);
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("icon/icon3.png"));
        Image img3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositDetails.setIcon(new ImageIcon(img3));
        depositDetails.setMnemonic('D');
        depositDetails.addActionListener(this);
        depositDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        menu.add(depositDetails);
        
        JMenuItem calculateBill = new JMenuItem("Calculate Bill");
        calculateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        calculateBill.setBackground(Color.WHITE);
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image img4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculateBill.setIcon(new ImageIcon(img4));
        calculateBill.setMnemonic('B');
        calculateBill.addActionListener(this);
        calculateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        menu.add(calculateBill);
        
        JMenu info = new JMenu("Information"); // customer
        info.setForeground(Color.RED);
        
        JMenuItem updateInfo = new JMenuItem("Update Information");
        updateInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        updateInfo.setBackground(Color.WHITE);
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image img5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateInfo.setIcon(new ImageIcon(img5));
        updateInfo.setMnemonic('I');
        updateInfo.addActionListener(this);
        updateInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        info.add(updateInfo);
        
        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced", Font.PLAIN, 12));
        viewInfo.setBackground(Color.WHITE);
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image img6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(img6));
        viewInfo.setMnemonic('U');
        viewInfo.addActionListener(this);
        viewInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
        info.add(viewInfo);
        
        JMenu user = new JMenu("User"); // customer
        user.setForeground(Color.BLUE);
        
        
        JMenuItem payBill = new JMenuItem("Pay Bill");
        payBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        payBill.setBackground(Color.WHITE);
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        Image img7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        payBill.setIcon(new ImageIcon(img7));
        payBill.setMnemonic('P');
        payBill.addActionListener(this);
        payBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        user.add(payBill);
        
        JMenuItem billDetails = new JMenuItem("Bill Details");
        billDetails.setFont(new Font("monospaced", Font.PLAIN, 12));
        billDetails.setBackground(Color.WHITE);
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        Image img8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billDetails.setIcon(new ImageIcon(img8));
        billDetails.setMnemonic('S');
        billDetails.addActionListener(this);
        billDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        user.add(billDetails);
        
        JMenu report = new JMenu("Report"); // customer
        report.setForeground(Color.RED);
       
        
        JMenuItem generateBill = new JMenuItem("Generate Bill");
        generateBill.setFont(new Font("monospaced", Font.PLAIN, 12));
        generateBill.setBackground(Color.WHITE);
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        Image img9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generateBill.setIcon(new ImageIcon(img9));
        generateBill.setMnemonic('G');
        generateBill.addActionListener(this);
        generateBill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        report.add(generateBill);
        
        JMenu util = new JMenu("Utility"); // customer
        util.setForeground(Color.BLUE);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced", Font.PLAIN, 12));
        notepad.setBackground(Color.WHITE);
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("icon/icon12.png"));
        Image img10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(img10));
        notepad.setMnemonic('N');
        notepad.addActionListener(this);
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        util.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setFont(new Font("monospaced", Font.PLAIN, 12));
        calc.setBackground(Color.WHITE);
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("icon/icon9.png"));
        Image img11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calc.setIcon(new ImageIcon(img11));
        calc.setMnemonic('C');
        calc.addActionListener(this);
        calc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        util.add(calc);
        
        JMenu exit = new JMenu("Exit"); // customer
        exit.setForeground(Color.RED);
       
        
        JMenuItem exitOpt = new JMenuItem("Exit");
        exitOpt.setFont(new Font("monospaced", Font.PLAIN, 12));
        exitOpt.setBackground(Color.WHITE);
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        Image img12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        exitOpt.setIcon(new ImageIcon(img12));
        exitOpt.setMnemonic('W');
        exitOpt.addActionListener(this);
        exitOpt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        exit.add(exitOpt);
        
        if(a_type.equals("Admin")){
            mb.add(menu);
        } else{
            mb.add(info);
            mb.add(user);
            mb.add(report);
        }
        mb.add(util);
        mb.add(exit);
        setLayout(new FlowLayout());
        setVisible(true); 
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Customer")){
            new NewCustomer();
        } else if (msg.equals("Customer Details")){
            new CustomerDetails();
        } else if (msg.equals("Deposit Details")){
            new DepositDetails();
        } else if (msg.equals("Calculate Bill")){
            new CalculateBill();
        } else if (msg.equals("View Information")){
            new ViewInfo(meter_no);
        } else if (msg.equals("Update Information")){
            new UpdateInfo(meter_no);
        } else if (msg.equals("Bill Details")){
            new BillDetails(meter_no);
        } else if (msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (msg.equals("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e){
                e.printStackTrace();
            }
        } else if (msg.equals("Exit")){
            setVisible(false);
            new Login();
        } else if(msg.equals("Pay Bill")){
            new PayBill(meter_no);
        } else if (msg.equals("Generate Bill")){
            new GenerateBill(meter_no);
        }
    }
}
