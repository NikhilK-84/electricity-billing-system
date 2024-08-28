package electricity.billing.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class Paytm extends JFrame implements ActionListener {
    String meter_no;
    JButton back;

    Paytm(String meter_no) {
        this.meter_no = meter_no;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);
        try {
            j.setPage("https://paytm.com/online-payments");
        } catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        }

        JScrollPane pane = new JScrollPane(j);
        add(pane, BorderLayout.CENTER);

        back = new JButton("Back");
        back.setBounds(640, 20, 80, 30);
        back.addActionListener(this);
        add(back, BorderLayout.NORTH); 

        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new PayBill(meter_no);
        }
    }
}
