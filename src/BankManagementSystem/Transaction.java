package BankManagementSystem;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
public class Transaction extends JFrame implements ActionListener {

JButton deposit, cashwithdraw, pinchange, fastcash, exit, balanceenquiry, ministatement;
String pinnumber;
Transaction(String pinnumber) {
this.pinnumber = pinnumber;
setLayout(null);
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT );
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(0,0,900,900);
add(image);
JLabel text = new JLabel("Please select your Transaction");
text.setBounds(215,300,700,35);
text.setForeground(Color.WHITE);
text.setFont(new Font("system", Font.BOLD, 16));
image.add(text);

deposit = new JButton("Deposit");
deposit.setBounds(170,415,150,30);
image.add(deposit);
deposit.addActionListener(this);

cashwithdraw = new JButton("Cash Withdraw");
cashwithdraw.setBounds(355,415,150,30);
image.add(cashwithdraw);
cashwithdraw.addActionListener(this);

fastcash = new JButton("Fast Cash");
fastcash.setBounds(170,450,150,30);
image.add(fastcash);
fastcash.addActionListener(this);

ministatement = new JButton("Mini Statement");
ministatement.setBounds(355,450,150,30);
image.add(ministatement);
ministatement.addActionListener(this);

balanceenquiry = new JButton("Balance Enquiry");
balanceenquiry.setBounds(170,485,150,30);
image.add(balanceenquiry);
balanceenquiry.addActionListener(this);

pinchange = new JButton("Pin Change");
pinchange.setBounds(355,485,150,30);
image.add(pinchange);
pinchange.addActionListener(this);

exit = new JButton("Exit");
exit.setBounds(355,520,150,30);
image.add(exit);
exit.addActionListener(this);

setSize(900, 900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}
@Override
public void actionPerformed(ActionEvent ae) {

if(ae.getSource() == exit) {
System.exit(0);
}
else if(ae.getSource() == deposit) {
setVisible(false);
new Deposit(pinnumber).setVisible(true);
}
else if(ae.getSource() == cashwithdraw) {
setVisible(false);
new Withdrawl(pinnumber).setVisible(true);

} else if(ae.getSource() == fastcash) {
setVisible(false);
new FastCash(pinnumber).setVisible(true);
} else if(ae.getSource() == pinchange) {
setVisible(false);
new PinChange(pinnumber).setVisible(true);
}else if(ae.getSource() == balanceenquiry) {
  setVisible(false);
  new BalanceEnquiry(pinnumber).setVisible(true);
}else if(ae.getSource() == ministatement) {
  setVisible(false);
  new MiniStatement(pinnumber).setVisible(true);
}
}
public static void main(String[] args) {
    new Transaction("");
}}

