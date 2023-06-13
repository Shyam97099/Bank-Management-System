package BankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener {

JTextField nameTextFiled, addressTextFiled, cityTextFiled;
JTextField fnameTextFiled,emailTextFiled,stateTextFiled,pincodeTextFiled;
JRadioButton male,  female, single, married, unmarried, transgender, other;
JDateChooser dateChooser;
JButton next;
long random;

Signup() {

setLayout(null);
Random ran = new Random();
random = Math.abs((ran.nextLong() % 9000L) + 1000L);
JLabel formno = new JLabel("APPLICATION FORM NO.  " +random);
formno.setBounds(140, 20,600, 40);
formno.setFont(new Font("raleway", Font.BOLD, 30));
add(formno); 

JLabel personalDetails = new JLabel("Page 1: Personal Details");
personalDetails.setBounds(290, 80,400, 30);
personalDetails.setFont(new Font("raleway", Font.BOLD, 14));
add(personalDetails); 

JLabel name = new JLabel("Name:");
name.setBounds(100, 140,100, 30);
name.setFont(new Font("raleway", Font.BOLD, 14));
add(name); 

nameTextFiled = new JTextField();
nameTextFiled.setFont(new Font("releway", Font.BOLD, 14));
nameTextFiled.setBounds(340, 140,400, 30);
add(nameTextFiled);

JLabel fname = new JLabel("Father's Name:");
fname.setBounds(100, 190,200, 30);
fname.setFont(new Font("raleway", Font.BOLD, 14));
add(fname); 

fnameTextFiled = new JTextField();
fnameTextFiled.setFont(new Font("releway", Font.BOLD, 14));
fnameTextFiled.setBounds(340, 190,400, 30);
add(fnameTextFiled);

JLabel dob = new JLabel("Date of birth :");
dob.setBounds(100, 240,200, 30);
dob.setFont(new Font("raleway", Font.BOLD, 14));
add(dob); 

dateChooser = new JDateChooser();
dateChooser.setBounds(340,240,400,30);
dateChooser.setForeground(new Color(105,105,105));
add(dateChooser);
 
JLabel gender = new JLabel("Gender:");
gender.setBounds(100, 290,200, 30);
gender.setFont(new Font("raleway", Font.BOLD, 14));
add(gender); 

male = new JRadioButton("Male");
male.setBounds(340, 290,60,30);
male.setBackground(Color.WHITE);
add(male);

female = new JRadioButton("Female");
female.setBounds(450, 290,80,30);
female.setBackground(Color.WHITE);
add(female);
transgender = new JRadioButton("Transgender");
transgender.setBounds(560, 290,100,30);
transgender.setBackground(Color.WHITE);
add(transgender);

ButtonGroup buttonGroup = new ButtonGroup();
buttonGroup.add(male);
buttonGroup.add(female);
buttonGroup.add(transgender);

JLabel  email = new JLabel("Email Address:");
email.setBounds(100, 340,200, 30);
email.setFont(new Font("raleway", Font.BOLD, 14));
add(email); 

emailTextFiled = new JTextField();
emailTextFiled.setFont(new Font("releway", Font.BOLD, 14));
emailTextFiled.setBounds(340, 340,400, 30);
add(emailTextFiled);

JLabel  marital = new JLabel("Marital Status:");
marital.setBounds(100, 390,200, 30);
marital.setFont(new Font("raleway", Font.BOLD, 14));
add(marital);

single = new JRadioButton("Single");
single.setBounds(330, 390,120,30);
single.setBackground(Color.WHITE);
add(single);

married = new JRadioButton("Married");
married.setBounds(450, 390,120,30);
married.setBackground(Color.WHITE);
add(married);

unmarried = new JRadioButton("Unmarried");
unmarried.setBounds(570, 390,120,30);
unmarried.setBackground(Color.WHITE);
add(unmarried);
other = new JRadioButton("Other");
other.setBounds(690, 390,120,30);
other.setBackground(Color.WHITE);
add(other);

ButtonGroup bGroup = new ButtonGroup();
bGroup.add(single);
bGroup.add(married);
bGroup.add(unmarried);
bGroup.add(other);

JLabel  address = new JLabel("Address:");
address.setBounds(100, 440,200, 30);
address.setFont(new Font("raleway", Font.BOLD, 14));
add(address);

addressTextFiled = new JTextField();
addressTextFiled.setFont(new Font("releway", Font.BOLD, 14));
addressTextFiled.setBounds(340, 440,400, 30);
add(addressTextFiled);

JLabel  city = new JLabel("City:");
city.setBounds(100, 490,200, 30);
city.setFont(new Font("raleway", Font.BOLD, 14));
add(city);

cityTextFiled = new JTextField();
cityTextFiled.setFont(new Font("releway", Font.BOLD, 14));
cityTextFiled.setBounds(340, 490,400, 30);
add(cityTextFiled);

JLabel state = new JLabel("State:");
state.setBounds(100, 540,200, 30);
state.setFont(new Font("raleway", Font.BOLD, 14));
add(state);

stateTextFiled = new JTextField();
stateTextFiled.setFont(new Font("releway", Font.BOLD, 14));
stateTextFiled.setBounds(340, 540,400, 30);
add(stateTextFiled);

JLabel  pincode = new JLabel("Pin Code:");
pincode.setBounds(100, 590,200, 30);
pincode.setFont(new Font("raleway", Font.BOLD, 14));
add(pincode);

pincodeTextFiled = new JTextField();
pincodeTextFiled.setFont(new Font("releway", Font.BOLD, 14));
pincodeTextFiled.setBounds(340, 590,400, 30);
add(pincodeTextFiled);

next = new JButton("Next");
next.setBounds(640, 640, 100, 30);
next.setBackground(Color.BLACK);
next.setForeground(Color.WHITE);
next.addActionListener(this);
add(next);

getContentPane().setBackground(Color.white);
setSize(800, 480);
setLocation(350, 10);
setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
String formno = "" + random;
String name = nameTextFiled.getText();
String fname = fnameTextFiled.getText();
String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
String gender = null;
if (male.isSelected()) {
gender = "Male";

} else if (female.isSelected()) {
    gender = "Female";
} else if (transgender.isSelected()) {
    gender = "Transgender";
}
String email = emailTextFiled.getText();
String marrital  = null;
if(single.isSelected()) {
    marrital = "Single";
} else if (married.isSelected()) {
    marrital = "Married";

}else if (unmarried.isSelected()) {
    marrital = "Unmarried";
}else if (other.isSelected()) {
    marrital = "Other";
}
String address = addressTextFiled.getText();
String city = cityTextFiled.getText();
String state = stateTextFiled.getText();
String pincode = pincodeTextFiled.getText();
try {
if (name.equals("")) {
JOptionPane.showMessageDialog(null, "Name is required");
    } else {
Conn c = new Conn();
String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+state+"','"+city+"','"+pincode+"','"+marrital+"','"+address+"')";
c.s.executeUpdate(query);
setVisible(false);
new SignupTwo(formno).setVisible(true); 
 }
} catch (Exception e) {
System.out.println(e);
}
}
   public static void main(String[] args) {
    new Signup();
   } 
}
