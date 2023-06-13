package BankManagementSystem;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class LoginPg extends JFrame implements ActionListener {

JPasswordField pinTextField;
JTextField CardTextField;
JButton login, clear, signup;
JLabel cardno, pin, text;

LoginPg() {
setLayout(null);
setTitle("AUTOMATIC TELLER MACHINE");
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
ImageIcon i3 =new ImageIcon(i2);
JLabel label = new JLabel(i3);
label.setBounds(70, 10, 100, 100);
add(label);
getContentPane().setBackground(Color.white);

text = new JLabel("Welcom to ATM");
text.setBounds(200, 40, 400, 40);
text.setFont(new Font("Osward", Font.BOLD, 38));
add(text);

cardno = new JLabel("Card No:");
cardno.setBounds(120, 150, 150, 40);
cardno.setFont(new Font("Raleway", Font.BOLD, 28));
add(cardno);

CardTextField = new JTextField();
CardTextField.setBounds(300, 150, 230, 30);
add(CardTextField);

pin = new JLabel("Pin:");
pin.setBounds(120, 220, 150, 40);
pin.setFont(new Font("Raleway", Font.BOLD, 28));
add(pin);

pinTextField = new JPasswordField();
pinTextField.setBounds(300, 220, 230, 30);
add(pinTextField);

login = new JButton("SIGN IN");
login.setBounds(300, 300, 100, 30);
login.setBackground(Color.BLACK);
login.setForeground(Color.WHITE);
login.addActionListener(this);
add(login);

clear = new JButton("CLEAR");
clear.setBounds(430, 300, 100, 30);
clear.setBackground(Color.BLACK);
clear.setForeground(Color.WHITE);
clear.addActionListener(this);
add(clear);

signup = new JButton("SIGN UP");
signup.setBounds(300, 350, 230, 30);
signup.setBackground(Color.BLACK);
signup.setForeground(Color.WHITE);
signup.addActionListener(this);
add(signup);

   setSize(800,480); 
   setVisible(true);
   setLocation(350,200); }
   
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource() == clear) {
        
    CardTextField.setText("");
    pinTextField.setText(""); 
    } else if (ae.getSource() == login) {
       Conn conn =new Conn();
       String cardnumber = CardTextField.getText();
       String pinnumber = pinTextField.getText();
       String query = "select * from loginpg where Acco_No = '"+cardnumber+"'and Pin_No = '"+pinnumber+"' ";
    try {
    ResultSet rs = conn.s.executeQuery(query);
    if(rs.next()) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }else {
        JOptionPane.showMessageDialog(null,"Incorrect card number or pin" );
    }
    } catch (Exception e) {
        System.out.println(e);
    }
    } else if (ae.getSource() == signup) {
        setVisible(false);
       new Signup().setVisible(true); 
    }
}
    public static void main(String[] args) {
    new LoginPg();
    }
}
