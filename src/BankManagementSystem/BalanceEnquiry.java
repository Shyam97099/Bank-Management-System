package BankManagementSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class BalanceEnquiry extends JFrame implements ActionListener {
JButton back;
String pinnumber;
BalanceEnquiry(String pinnumber){
setLayout(null);
this.pinnumber = pinnumber;
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
ImageIcon i3 =new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(0, 0, 900, 900);
add(image);
back = new JButton("Back");
back.setBounds(355,520,150,20);
image.add(back);
back.addActionListener(this);

Conn c = new Conn();
int balance = 0;
try {
ResultSet rs = c.s.executeQuery("select * from bank where Pin_No = '"+pinnumber+"'");

while(rs.next()) {
if(rs.getString("type").equals("Deposit")) {
balance += Integer.parseInt(rs.getString("amount"));
} else {
balance -= Integer.parseInt(rs.getString("amount"));
}}
} catch(Exception e) {
System.out.println(e);
}
JLabel text = new JLabel("Your Current Account balance is Rs " + balance);
text.setForeground(Color.WHITE);
text.setBounds(170, 300, 400, 30);
image.add(text);
setLocation(300, 0);
setSize(900, 900);
setVisible(true);

}
public void actionPerformed(ActionEvent ae) {
setVisible(false);
new Transaction(pinnumber).setVisible(true);
}
public static void main(String[] args) {
new BalanceEnquiry("");
}
}
