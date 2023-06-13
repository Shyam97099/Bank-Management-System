package BankManagementSystem;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

JTextField  pannumTextFiled, aadharTextFiled ;
JRadioButton syes, sno, eyes, eno;
JComboBox occupation, riligion, category, income, education;
JButton next;
String formno;

SignupTwo(String formno) {
this.formno = formno;
setLayout(null);
setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
AdditionalDetails.setBounds(290, 80,400, 30);
AdditionalDetails.setFont(new Font("raleway", Font.BOLD, 14));
add(AdditionalDetails);

JLabel name = new JLabel("Riligion:");
name.setBounds(100, 140,100, 30);
name.setFont(new Font("raleway", Font.BOLD, 14));
add(name);

String valriligion[] = {"Hindu", "Muslim", "Shikh", "Christion","Other"};
riligion = new JComboBox(valriligion);
riligion.setBounds(340,140,400,30);
riligion.setBackground(Color.WHITE);
add(riligion);

JLabel fname = new JLabel("Category:");
fname.setBounds(100, 190,200, 30);
fname.setFont(new Font("raleway", Font.BOLD, 14));
add(fname);

String valcategiry[] = {"General", "OBC", "SC", "ST","Other"};
category = new JComboBox(valcategiry);
category.setBounds(340,190,400,30);
category.setBackground(Color.WHITE);
add(category);


JLabel dob = new JLabel("Income:");
dob.setBounds(100, 240,200, 30);
dob.setFont(new Font("raleway", Font.BOLD, 14));
add( dob);

String incomecategiry[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000","Up to 10,00,000"};
income = new JComboBox(incomecategiry);
income.setBounds(340,240,400,30);
income.setBackground(Color.WHITE);
add(income);

JLabel gender  = new JLabel("Educational");
gender.setBounds(100, 290,200, 30);
gender.setFont(new Font("raleway", Font.BOLD, 14));
add(gender);

JLabel  email = new JLabel("Qualification:");
email.setBounds(100, 310,200, 30);
email.setFont(new Font("raleway", Font.BOLD, 14));
add(email);

String educationValue[] = {"Non-Graduation", "Graduation", "Post Graduation", "Doctrate","Other"};
education = new JComboBox(educationValue);
education.setBounds(340,290,400,30);
education.setBackground(Color.WHITE);
add(education);

JLabel  marital = new JLabel("Occupation:");
marital.setBounds(100, 340,200, 30);
marital.setFont(new Font("raleway", Font.BOLD, 14));
add(marital);

String occupationValue[] = {"Salaried", "Selt-Employed", "Bussiness", "Student","Retired","Other"};
occupation= new JComboBox(occupationValue);
occupation.setBounds(340,340,400,30);
occupation.setBackground(Color.WHITE);
add(occupation);

JLabel  pannum = new JLabel("Pan Number:");
pannum.setBounds(100, 390,200, 30);
pannum.setFont(new Font("raleway", Font.BOLD, 14));
add(pannum);

pannumTextFiled = new JTextField();
pannumTextFiled.setFont(new Font("releway", Font.BOLD, 14));
pannumTextFiled.setBounds(340, 390,400, 30);
add(pannumTextFiled);

JLabel  aadhar = new JLabel("Aadhar Number:");
aadhar.setBounds(100, 440,200, 30);
aadhar.setFont(new Font("raleway", Font.BOLD, 14));
add(aadhar);

aadharTextFiled = new JTextField();
aadharTextFiled.setFont(new Font("releway", Font.BOLD, 14));
aadharTextFiled.setBounds(340, 440,400, 30);
add(aadharTextFiled);

JLabel seniorcitizen = new JLabel("Senior Citizen:");
seniorcitizen.setBounds(100, 490,200, 30);
seniorcitizen.setFont(new Font("raleway", Font.BOLD, 14));
add(seniorcitizen);

syes = new JRadioButton("Yes");
syes.setBounds(340, 490,60,30);
syes.setBackground(Color.WHITE);
add(syes);

sno = new JRadioButton("No");
sno.setBounds(500, 490,80,30);
sno.setBackground(Color.WHITE);
add(sno);

ButtonGroup buttonGroup = new ButtonGroup();
buttonGroup.add(syes);
buttonGroup.add(sno);

JLabel  existaccount = new JLabel("Exisiting Account:");
existaccount.setBounds(100, 540,200, 30);
existaccount.setFont(new Font("raleway", Font.BOLD, 14));
add(existaccount);

eyes = new JRadioButton("Yes");
eyes.setBounds(340, 540,60,30);
eyes.setBackground(Color.WHITE);
add(eyes);

eno = new JRadioButton("No");
eno.setBounds(500, 540,80,30);
eno.setBackground(Color.WHITE);
add(eno);

ButtonGroup button_Group = new ButtonGroup();
button_Group.add(eyes);
button_Group.add(eno);

next = new JButton("Next");
next.setBounds(640, 600, 100, 30);
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

String sriligion = (String) riligion.getSelectedItem();
String scategory = (String) category.getSelectedItem();
String seducation = (String) education.getSelectedItem();
String sincome = (String) income.getSelectedItem();
String soccupation = (String) occupation.getSelectedItem();

String existaccount = null;
if (eyes.isSelected()) {
existaccount = "Yes";

} else if (eno.isSelected()) {
existaccount = "No";
}
String seniorcitizen = null;
if (syes.isSelected()) {
seniorcitizen = "Yes";

} else if (sno.isSelected()) {
seniorcitizen = "No";
}

String saadhar = aadharTextFiled.getText();
String spannum = pannumTextFiled.getText();
try {
if (saadhar.equals("")) {
JOptionPane.showMessageDialog(null, "Adhar Number is required");
} else {
Conn c = new Conn();
String query = "insert into signupTwo values('"+formno+"','"+sriligion+"','"+scategory+"','"+saadhar+"','"+spannum+"','"+sincome+"','"+soccupation+"','"+ seducation+"','"+seniorcitizen+"','" +existaccount+"')";
c.s.executeUpdate(query);
setVisible(false);
new SignupThree(formno).setVisible(true);
}
} catch (Exception e) {
System.out.println(e);

}
}
public static void main(String[] args) {
new SignupTwo("");
}
}
