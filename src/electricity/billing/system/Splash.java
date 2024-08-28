package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);
        
        setVisible(true);
        
 
        for(int i = 2; i < 640; i += 4){
            int width = i;
            int height = i;
            setSize(width, height);
            setLocation(760 - width/2, 460 - height/2);
            try{
                Thread.sleep(5); // 10 ms
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        t = new Thread(this);
        t.start(); // multithreading (calls run() from runnable)
        
    }
    
    @Override
    public void run(){
        try{
            Thread.sleep(2000);
            setVisible(false);
            new Login();
            
            // login frame
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new Splash();
        //new Project("", "");
        //new NewCustomer();
        //new MeterInfo("");
        //new CalculateBill();
        //new CustomerDetails();
        //new Signup();
        //new Login();
        //new ViewInfo();
        //new UpdateInfo("");
        //new PayBill();
    }
}
