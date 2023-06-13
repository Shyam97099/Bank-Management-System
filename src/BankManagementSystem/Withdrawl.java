package BankManagementSystem;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;
public class Withdrawl extends JFrame implements ActionListener {
JButton withdraw, back;
JTextField amount;
String pinnumber;

Withdrawl(String pinnumber) {
this.pinnumber = pinnumber;
setLayout(null);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT); 
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

JLabel text = new JLabel("Enter the Amount you want to withdraw..");
text.setForeground(Color.WHITE);
text.setFont( new Font( "system", Font.BOLD, 16));
text.setBounds(185, 300, 400,20);
image.add(text);

amount = new JTextField();
amount.setFont(new Font("raleway", Font.BOLD, 20));
amount.setBounds(255,330,150,25);
add(amount);

withdraw = new JButton("Withdraw");
withdraw.setFont(new Font("raleway", Font.BOLD, 22));
withdraw.setBounds(375,485, 150,30);
image.add(withdraw);
withdraw.addActionListener(this);

back = new JButton("Back");
back.setFont(new Font("raleway", Font.BOLD, 22));
back.setBounds(375,520, 150,30);
image.add(back);
back.addActionListener(this);

setSize(900,900);
setLocation(350,0);
//setUndecorated(true);
setVisible(true);
    
}
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == withdraw) {
String  number = amount.getText();
Date date = new Date();
if(number.equals("")) {
    JOptionPane.showMessageDialog(null, "Plese enter the amount you want to withdrow ");
} else { 
    try {
    Conn conn = new Conn();
    String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"') ";
   conn.s.executeUpdate(query);
   JOptionPane.showMessageDialog(null, " Rs " +number+ " Withdraw Successfully!");



   
    setVisible(false);
    new Transaction(number).setVisible(true);
} catch (Exception e) {
        System.out.println(e);
    }
}
} else if(ae.getSource() == back) {
setVisible(false);
new Transaction(pinnumber).setVisible(true);
    }
    }
    public static void main(String[] args) { 
        new Withdrawl("");
    }
}