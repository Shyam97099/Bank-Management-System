package BankManagementSystem;
import java.sql.*;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class MiniStatement extends JFrame  {

MiniStatement(String pinnumber) {
setLayout(null);

JLabel mini = new JLabel();
add(mini);

JLabel bank = new JLabel("Indian Bank");
bank.setBounds(150,20,100,20);
add(bank);
JLabel card = new JLabel();
card.setBounds(20,80,300,20);
add(card);

JLabel balance = new JLabel();
balance.setBounds(20, 400, 300, 20);
add(balance);


try {
Conn conn = new Conn();
ResultSet rs = conn.s.executeQuery("select * from loginpg where pin_no = '1234' ");
while(rs.next()) {
card.setText("Card Number : " + rs.getString("Acco_No").substring(0, 4) + "xxxxxxxx" + rs.getString("Acco_No").substring(12));
}
} catch (Exception e) {
System.out.println(e);

}
try {
Conn conn = new Conn();
int bal = 0;
ResultSet rs = conn.s.executeQuery("select * from bank where pin_no = '"+pinnumber+"'");
while(rs.next()) {
    mini.setText(mini.getText() +"<html>"+ rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("Type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount") + "<br><br><html>") ;
    if(rs.getString("type").equals("Deposit")) {
        bal += Integer.parseInt(rs.getString("amount"));
        } else {
        bal -= Integer.parseInt(rs.getString("amount"));
        }
}
balance.setText("Your current balance is Rs " + bal);
} catch (Exception e) {
System.out.println(e);
}
mini.setBounds(20, 170, 400, 200);


setSize(400,600);
setLocation(20,20);
getContentPane().setBackground(Color.white);
setVisible(true);
}

public static void main(String[] args) {
new MiniStatement("");
}
}
