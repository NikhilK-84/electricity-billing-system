/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class GenerateBill extends JFrame implements ActionListener{
    Choice Cmonth;
    JTextArea area;
    String meter_no;
    GenerateBill(String meter_no){
        this.meter_no = meter_no;
        //this.meter_no = "607847"; // for testing
        setSize(500, 700);
        setLocation(550, 30);
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        JLabel heading = new JLabel("Generate Bill");
        JLabel Lmeter_num = new JLabel(meter_no);
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
        add(Cmonth);
        
        area = new JTextArea(50, 15); // 50 rows, 15 col
        area.setText("\n\n\t--------Click on the--------\n\t Generate Bill Button to get \n\t the bill of the selected month. ");
        area.setFont(new Font("Senserif", Font.ITALIC, 18));
        JScrollPane jp = new JScrollPane(area);
        
        JButton bill = new JButton("Generate Bill");
        bill.addActionListener(this);
        p.add(heading);
        p.add(Lmeter_num);
        p.add(Cmonth);
        add(p, "North");
        add(jp, "Center");
        add(bill, "South");
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            
            String month = Cmonth.getSelectedItem();
            area.setText("\tReliance Power Limited\n  ELECTRICITY BILL GENERATED FOR "+ month + ", 2024\n\n\n");
            
            String query1 = "select * from customer where meter_no = '" + meter_no +"'";
            ResultSet rs = c.s.executeQuery(query1);
            
            if(rs.next()){
                area.append("\n    Customer Name: " + rs.getString("name"));
                area.append("\n    Meter Number : " + rs.getString("meter_no"));
                area.append("\n    Address      : " + rs.getString("address"));
                area.append("\n    City         : " + rs.getString("city"));
                area.append("\n    State        : " + rs.getString("state"));
                area.append("\n    Email Address: " + rs.getString("email"));
                area.append("\n    Phone Number : " + rs.getString("phone"));
                area.append("\n\n");
            }
            
            
            String query2 = "select * from meter_info where meter_no = '" + meter_no +"'";
            rs = c.s.executeQuery(query2);
            
            if(rs.next()){
                area.append("\n    Meter Location: " + rs.getString("meter_location"));
                area.append("\n    Meter Type    : " + rs.getString("meter_type"));
                area.append("\n    Phase Code    : " + rs.getString("phase_code"));
                area.append("\n    Bill Type     : " + rs.getString("bill_type"));
                area.append("\n    Days          : " + rs.getString("days"));
                area.append("\n\n");
            }
            
            String query3 = "select * from tax";
            rs = c.s.executeQuery(query3);
            
            if(rs.next()){
                area.append("\n    Cost Per Unit: " + rs.getString("cost_per_unit"));
                area.append("\n    Meter Rent: " + rs.getString("meter_rent"));
                area.append("\n    Service Charge: " + rs.getString("service_charge"));
                area.append("\n    Service Tax: " + rs.getString("service_tax"));
                area.append("\n    Swacch Bharat Cess: " + rs.getString("swacch_bharat_cess"));
                area.append("\n    Fixed Tax: " + rs.getString("fixed_tax"));
                area.append("\n\n");
            }
            
            String query4 ="select * from bill where meter_no = '" + meter_no +"' and month = '" +month+"'";
            rs = c.s.executeQuery(query4);
            
            if(rs.next()){
                area.append("\n    Current Month: " + rs.getString("month"));
                area.append("\n    Units Consumed: " + rs.getString("units"));
                area.append("\n    Total Charges: " + rs.getString("total_bill"));
                area.append("\n--------------------------------------------------");
                area.append("\n    Total Payable: " + rs.getString("total_bill"));
                area.append("\n\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new GenerateBill("");
    }
}
