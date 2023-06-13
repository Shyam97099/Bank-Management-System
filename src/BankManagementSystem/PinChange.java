package BankManagementSystem;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PinChange extends JFrame implements ActionListener {

JButton back, change;
JPasswordField pin_no, repin;
String pinnumber;
PinChange(String pinnumber) {
this.pinnumber = pinnumber;
setLayout(null);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(0,0,900, 900);
add(image);

JLabel text = new JLabel("CHANGE YOUR PIN");
text.setFont(new Font("system",Font.BOLD, 16));
text.setBounds(270,290,500,35);
text.setForeground(Color.WHITE);
image.add(text);

JLabel pintext = new JLabel("NEW PIN");
pintext.setFont(new Font("system",Font.BOLD, 16));
pintext.setBounds(160,330,180,25);
pintext.setForeground(Color.WHITE);
image.add(pintext);

pin_no = new JPasswordField();
pin_no.setFont(new Font("system", Font.BOLD, 16));
pin_no.setBounds(270,330,150,25);
pin_no.setForeground(Color.BLACK);
image.add(pin_no);

JLabel repintext = new JLabel("Re-enter PIN");
repintext.setFont(new Font("system",Font.BOLD, 16));
repintext.setBounds(160,360,180,25);
repintext.setForeground(Color.WHITE);
image.add(repintext);

repin = new JPasswordField();
repin.setFont(new Font("system", Font.BOLD, 16));
repin.setBounds(270,360,150,25);
repin.setForeground(Color.BLACK);
image.add(repin);

change  = new JButton("Change");
change.setBounds(370,485,150,30);
change.setFont(new Font("Releway",Font.BOLD, 20));
image.add(change);
change.addActionListener(this);

back = new JButton("Back");
back.setBounds(370,520,150,30);
back.setFont(new Font("Releway",Font.BOLD, 20));
image.add(back);
back.addActionListener(this);

setSize(900, 900);
setLocation(300, 0);
setVisible(true);
}

public void actionPerformed(ActionEvent ae) {
if(ae.getSource() == change) {
try {
String npin = pin_no.getText();
String rpin = repin.getText();
if(!npin.equals(rpin)) {
JOptionPane.showMessageDialog(null,"Enter PIN does not match");
return;
}
if(npin.equals("")) {
JOptionPane.showMessageDialog(null,"Please enter the pin");
return;
}
if(rpin.equals("")) {
JOptionPane.showMessageDialog(null,"Please Re-enter the pin");
return;
}
Conn conn = new Conn();
String query1 ="update bank set Pin_No = '"+rpin+"' where Pin_No ='"+pinnumber+"'";
String query2 ="update loginpg set Pin_No = '"+rpin+"' where Pin_No ='"+pinnumber+"'";
String query3 ="update signupthree set Pin_No = '"+rpin+"' where Pin_No ='"+pinnumber+"'";

conn.s.executeUpdate(query1);
conn.s.executeUpdate(query2);
conn.s.executeUpdate(query3);
JOptionPane.showMessageDialog(null,"Pin changed successfully!");
setVisible(false);
new Transaction(rpin).setVisible(true);
}
catch(Exception e){
System.out.println(e);
}

} else {
setVisible(false);
new Transaction(pinnumber).setVisible(true);
}
}

public static void main(String[] args) {
new PinChange("").setVisible(true);
}
}
