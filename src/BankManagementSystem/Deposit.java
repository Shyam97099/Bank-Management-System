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
public class Deposit extends JFrame implements ActionListener {
JButton deposit,back;
JTextField amount;
String pinnumber;

Deposit(String pinnumber) {
this.pinnumber = pinnumber;
setLayout(null);

ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT); 
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);

JLabel text = new JLabel("Enter the Amount you want to deposit..");
text.setForeground(Color.WHITE);
text.setFont( new Font( "system", Font.BOLD, 16));
text.setBounds(185, 300, 400,20);
image.add(text);

amount = new JTextField();
amount.setFont(new Font("raleway", Font.BOLD, 20));
amount.setBounds(255,330,150,25);
add(amount);

deposit = new JButton("Deposit");
deposit.setFont(new Font("raleway", Font.BOLD, 22));
deposit.setBounds(375,485, 120,30);
image.add(deposit);
deposit.addActionListener(this);

back = new JButton("Back");
back.setFont(new Font("raleway", Font.BOLD, 22));
back.setBounds(375,520, 120,30);
image.add(back);
back.addActionListener(this);

setSize(900,900);
setLocation(350,0);
//setUndecorated(true);
setVisible(true);
    
}
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == deposit) {
String  number = amount.getText();
Date date = new Date();
if(number.equals("")) {
    JOptionPane.showMessageDialog(null, "Plese enter the amount you want to deposit ");
} else {
    try {
    Conn conn = new Conn();
    String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"') ";
   conn.s.executeUpdate(query);
   JOptionPane.showMessageDialog(null, "Rs " +number+ " Deposited Successfully!");
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
        new Deposit("");
    }
    }