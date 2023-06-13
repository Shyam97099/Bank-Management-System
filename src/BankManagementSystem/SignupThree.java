package BankManagementSystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener  {
JButton submit, cancel;
JRadioButton r1, r2, r3, r4;
JCheckBox c1, c2, c3, c4, c5, c6, c7;
String formno;
SignupThree(String formno) {
this.formno = formno;
setLayout(null);
JLabel l1 = new JLabel("Page 3: Account Details");
l1.setFont(new Font("Releway",Font.BOLD, 22));
l1.setBounds(280, 40, 400, 40);
add(l1);

JLabel type= new JLabel("Account Type");
type.setFont(new Font("Releway",Font.BOLD, 22));
type.setBounds(100, 140, 200, 30);
add(type);

r1 = new JRadioButton("Current Account:");
r1.setFont(new Font("Releway",Font.BOLD, 14));
r1.setBounds(100, 180, 220, 30);
r1.setBackground(Color.WHITE);
add(r1);
r2 = new JRadioButton("Saving Account:");
r2.setFont(new Font("Releway",Font.BOLD, 14));
r2.setBounds(350, 180, 220, 30);
r2.setBackground(Color.WHITE);
add(r2);
r3 = new JRadioButton("Fixed Deposit Account:");
r3.setFont(new Font("Releway",Font.BOLD, 14));
r3.setBounds(100, 220, 220, 30);
r3.setBackground(Color.WHITE);
add(r3);
r4 = new JRadioButton("Recurring Deposit Account:");
r4.setFont(new Font("Releway",Font.BOLD, 14));
r4.setBounds(350, 220, 220, 30);
r4.setBackground(Color.WHITE);
add(r4);

ButtonGroup buttonGroup = new ButtonGroup();
buttonGroup.add(r1);
buttonGroup.add(r2);
buttonGroup.add(r3);
buttonGroup.add(r4);

JLabel card = new JLabel("Card Number:");
card.setFont(new Font("Releway",Font.BOLD, 22));
card.setBounds(100, 300, 200, 30);
add(card);

JLabel carddetails = new JLabel("Your 16 Digits Card Number:");
carddetails.setFont(new Font("Releway",Font.BOLD, 10));
carddetails.setBounds(100, 320, 200, 30);
add(carddetails);

JLabel number = new JLabel("xxxx-xxx-xxxx-4041");
number.setFont(new Font("Releway",Font.BOLD, 22));
number.setBounds(330, 300, 300, 30);
add(number);

JLabel pin = new JLabel("PIN:");
pin.setFont(new Font("Releway",Font.BOLD, 22));
pin.setBounds(100, 370, 200, 30);
add(pin);
JLabel pindetails = new JLabel("Your 4 Digits Pin:");
pindetails.setFont(new Font("Releway",Font.BOLD, 10));
pindetails.setBounds(100, 390, 200, 30);
add(pindetails);

JLabel pnumber = new JLabel("xxxx");
pnumber.setFont(new Font("Releway",Font.BOLD, 22));
pnumber.setBounds(330, 370, 300, 30);
add(pnumber);
JLabel services = new JLabel("Services Required:");
services.setFont(new Font("Releway",Font.BOLD, 22));
services.setBounds(100, 440, 250, 30);
add(services);

c1 = new JCheckBox("ATM CARD");
c1.setBackground(Color.white);
c1.setFont(new Font("Releway", Font.BOLD, 14));
c1.setBounds(100, 490, 200, 30);
add(c1);

c2 = new JCheckBox("Net Banking");
c2.setBackground(Color.white);
c2.setFont(new Font("Releway", Font.BOLD, 14));
c2.setBounds(400, 490, 200, 30);
add(c2);
c3 = new JCheckBox("Mobile Banking");
c3.setBackground(Color.white);
c3.setFont(new Font("Releway", Font.BOLD, 14));
c3.setBounds(100, 540, 200, 30);
add(c3);
c4 = new JCheckBox("Email & SMS Alerts");
c4.setBackground(Color.white);
c4.setFont(new Font("Releway", Font.BOLD, 14));
c4.setBounds(400, 540, 200, 30);
add(c4);
c5 = new JCheckBox("Cheque Book");
c5.setBackground(Color.white);
c5.setFont(new Font("Releway", Font.BOLD, 14));
c5.setBounds(100, 590, 200, 30);
add(c5);
c6 = new JCheckBox("E- Statement");
c6.setBackground(Color.white);
c6.setFont(new Font("Releway", Font.BOLD, 14));
c6.setBounds(400, 590, 200, 30);
add(c6);
c7 = new JCheckBox("I hereby declears that above entered details are correct to the best my knowledge");
c7.setBackground(Color.white);
c7.setFont(new Font("Releway", Font.BOLD, 12));
c7.setBounds(100, 640, 500, 30);
add(c7);

submit = new JButton("Submit");
submit.setBackground(Color.BLACK);
submit.setForeground(Color.WHITE);
submit.setFont(new Font("releway", Font.BOLD, 14));
submit.setBounds(250, 720, 100, 30);
submit.addActionListener(this);
add(submit);

cancel = new JButton("Cancel");
cancel.setBackground(Color.BLACK);
cancel.setForeground(Color.WHITE);
cancel.setFont(new Font("releway", Font.BOLD, 14));
cancel.setBounds(420, 720, 100, 30);
cancel.addActionListener(this);
add(cancel);
getContentPane().setBackground(Color.WHITE);

setSize(800, 820);
setLocation(350,10);
setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
if(ae.getSource() == submit){
String accountType = null;
if (r1.isSelected()) {
accountType = "Current Account";
} else if (r2.isSelected()) {
accountType = "Saving Account";
} else if (r3.isSelected()) {
accountType = "Fixed Deposit Account";
} else if (r4.isSelected()) {
accountType = "Recurring Deposit Account";
}
Random random = new Random();
String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
String pinnumber = ""+ Math.abs((random.nextLong() % 9000L) + 1000L);
String facility = "";
if (c1.isSelected()) {
facility = facility + "ATM CARD";
} else if (c2.isSelected()) {
facility = facility + "Internet Banking";
} else if (c3.isSelected()) {
facility = facility + "Mobile Banking";
}else if (c4.isSelected()) {
facility = facility + "Email & SMS Alerts";
} else if (c5.isSelected()) {
facility = facility + "Cheque Book";
} else if (c6.isSelected()) {
facility = facility + "E- Statement";
}
try {
if(accountType.equals("")) {
JOptionPane.showMessageDialog(null, "Acount Type is Required");

} else {
Conn conn = new Conn();
String query1 = "insert into SignupThree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"','"+facility+"')";
String query2 = "insert into loginpg values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
conn.s.executeUpdate(query1);
conn.s.executeUpdate(query2);
JOptionPane.showMessageDialog(null, "Card Number :" + cardnumber + "\n Pin : " + pinnumber);
setVisible(false);
new Transaction(pinnumber).setVisible(true);
}
} catch (Exception e) {
System.out.println(e);
}
} else if (ae.getSource() == cancel) {
setVisible(false);
new LoginPg().setVisible(true);
}
}
public static void main(String[] args) {
new SignupThree("");
}
}

