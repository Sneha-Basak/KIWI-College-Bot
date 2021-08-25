package Secure;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sneha
 */
public class chatbot extends JFrame implements KeyListener {
    static String name;
     static String dsa;
      static String dsm;
       static String ja;
         static String jm;
           static String ma;
             static String mm;
             static String at;
             static String m;
              
    
  Connection conn=null;
PreparedStatement pst=null;
ResultSet rs=null; 
JPanel p=new JPanel();
JTextArea dialog=new JTextArea(20,50);
JTextArea input=new JTextArea(1,50);
JScrollPane scroll=new JScrollPane(
dialog,
JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
);

String[][] chatBot = new String[100][100];


public static void main(String[] args) throws SQLException{
new chatbot();
}

public chatbot() throws SQLException{
super("Chat Bot");
try
{
    String a=null ;
    a=JOptionPane.showInputDialog("Enter your prn");
   
Connection con = (Connection)
    DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/kiwi","root","shreya");
    Statement stmt = (Statement) con.createStatement();
    String query = "SELECT CONCAT(Firstname,' ',Lastname) as 'Name',ds.attendance as 'ds-a',ds.marks as'ds-m',java.attendance as 'java-a',java.marks as 'java-m',maths.attendance as 'maths-a', maths.marks as 'maths-m' FROM ds,java,maths,studentinfo WHERE ds.prn=studentinfo.prn AND ds.prn=java.prn AND ds.prn=maths.prn AND ds.prn='"+a+"';";
   ResultSet rs = stmt.executeQuery(query);
    if(rs.next())
    {
    name=rs.getString(1);
    dsa=rs.getString(2);
    dsm=rs.getString(3);
    ja=rs.getString(4);
    jm=rs.getString(5);
    ma=rs.getString(6);
    mm=rs.getString(7);
    
    }
    int a1=Integer.parseInt(dsa);
    int a2=Integer.parseInt(ja);
    int a3=Integer.parseInt(ma);
    int m1=Integer.parseInt(dsm);
    int m2=Integer.parseInt(jm);
    int m3=Integer.parseInt(mm);
    
    if(a1<=75)
    { at="\n    Your attendance must be improved or you might get a CNG";}
    if(a2<=75)
    { at="\n     Your attendance must be improved or you might get a CNG";}
    if(a3<=75)
    { at="\n     Your attendance must be improved or you might get a CNG";}
    if(a1>75&&a1<90)
    {at="\n      Your attendance is above borderline but can be improved";}
    if(a2>75&&a2<90)
    {at="\n      Your attendance is above borderline but can be improved";}
    if(a3>75&&a3<90)
    {at="\n      Your attendance is above borderline but can be improved";}
    if(a1>90)
      { at="\n   Your attendance is great! Keep maintaing it!!";}
    if(a2>90)
      { at="\n   Your attendance is great! Keep maintaing it!!";}
    if(a3>90)
      { at="\n   Your attendance is great! Keep maintaing it!!";}
    
    if(m1<=30)
    { m="\n     Your current Grade iS : C. You must improve your performance!";}
     if(m2<=30)
    { m="\n     Your current Grade iS : C. You must improve your performance!";}
      if(m3<=30)
    { m="\n     Your current Grade iS : C. You must improve your performance!";}
    if(m1>40&&m1<30)
    {m="\n      Your current Grade is : B. You are doing good, you can improve more! ";}
    if(m2>40&&m2<30)
    {m="\n      Your current Grade is : B. You are doing good, you can improve more! ";}
    if(m3>40&&m3<30)
    {m="\n      Your current Grade is : B. You are doing good, you can improve more! ";}
    if(m1>40)
      { m="\n   Your current Grade is : A. You are doing great, Keep it up!!";}
     if(m2>40)
      { m="\n   Your current Grade is : A. You are doing great, Keep it up!!";}
      if(m3>40)
      { m="\n   Your current Grade is : A. You are doing great, Keep it up!!";}
    
    
}
catch(Exception e)
{
System.out.println(e.getMessage());
}
this.chatBot = new String[][]{{"hi","hello","hola","hey"}, {"Hi","Hello! How Can i help you?","Hey !,how can i help you?"},
    
   
    {"what branch am i in?","branch"},{"Computer Science"},
    {"what semester is going on"},{"4th sem"},
    {"when is my internship semester"},{"Your internship is in sem 6. ALL THE BEST!"},
        
    
    {"what is my name","pls tell me my name","who am i?"},{"I know you! Your name is "+name},
    
{"how are you","how r you","how r u","how are u"}, {"good","doing well"}, 
    
{"attendance for java","java attendance","what is my attendance in java"}, {"Your attendance in java is :"+ja+at},
    
 {"attendance for ds","ds attendance","what is my attendance in ds"},{"Your attendance in data structures is :"+dsa+at},
    
{"attendance for maths","maths attendance","what is my attendance in maths"},{"Your attendance in maths is :"+ma+at},


{"marks for ds","ds marks","what are my ds marks"},{"Your marks in data structures is :"+dsm+m},

{"marks for maths","maths marks","what are my maths marks"},{"Your marks in maths is :"+mm+m},

{"marks for java","java marks","what are my java marks"},{"Your marks in data structures is :"+jm+m},

{"what are the cultural events in college","info about cultural events","what all events take place in college"},

{"many--SIT Reverb,Techfest,PROTA(sports fest),Kirdaar and many more....."},

{"what all clubs exist in the college","tell me about the clubs","club info"},
{"There are many clubs like Varsity,Mosaic,EPIC,DSA.."},

{"time table for monday"},
{"Maths   |   DS  |   DS(Lab) |  Java"},

{"time table for tuesday"},
{"OS   |    MT  |   Maths(tut) |  OS(lab)"},

{"time table for wednesday"},
{"DS(Lab)   |    Maths  |   Java |  MT(lab)"},

{"time table for thursday"},
{"JP(lab) |  LA  |  Maths  |  OS"},

{"time table for friday"},
{"MT(lab) | DS   |  cultural |  ELH"},

 {"subjects","What are my subjects"}, 
 {"1. Engineering Mathematics 2. Operating System 3.Java Programming 4.Data Structures 5.Microprocessor Techniques 6. Liberal Arts"}, 
 {"liberal arts info","liberal arts"}, {"1.German---Ms.Nirupama Joshi\n                             2.French---Ms.Sumedha Agrawal\n                             3.Spanish---Ms.Payal Khedkar"}, 
 {"teachers","who all are my teachers","my teachers"}, {"1.Maths--Mr.Ramesh Katta\n                             2.OS--Ms.Smita Mahajan\n                             3.JAVA--Mr.Shubham Lodhe\n                             4.DS--Ms.Rupali Gangarde\n                             5.MT--Mr.Sharnil Pandya"},
 
 {"sem details","can you give me sem start and end detail"}, {"WINTER SEMESTER: SEM Starts: 13th July\n                             SEM ends: 2nd December\n                             SEM EVENTS- REVERB(cultural fest),NAD(govt.competition),Google startup weekend"}, 
           
            {"I didnt understand","What?","I dont know","Pls ask again",
                "I am confused"}};
setSize(600,400);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);

dialog.setEditable(false);
input.addKeyListener(this);
 addText("-->KIWI\tHey!I am Kiwi!Ask me questions about your subjects,marks,events etc\n");
p.add(scroll);
p.add(input);
p.setBackground(new Color(255,200,0));
add(p);

setVisible(true);
}

public void keyPressed(KeyEvent e){

if(e.getKeyCode()==KeyEvent.VK_ENTER){
input.setEditable(false);

String quote=input.getText();
input.setText("");
addText("\n-->You:\t"+quote);
quote.trim();
while(
quote.charAt(quote.length()-1)=='!' ||
quote.charAt(quote.length()-1)=='.' ||
quote.charAt(quote.length()-1)=='?'
){
quote=quote.substring(0,quote.length()-1);
}
quote.trim();
byte response=0;

int j=0;
while(response==0){
if(inArray(quote.toLowerCase(),chatBot[j*2])){
response=2;
int r=(int)Math.floor(Math.random()*chatBot[(j*2)+1].length);
addText("\n-->KIWI\t"+chatBot[(j*2)+1][r]);
}
j++;
if(j*2==chatBot.length-1 && response==0){
response=1;
}
}

if(response==1){
int r=(int)Math.floor(Math.random()*chatBot[chatBot.length-1].length);
addText("\n-->KIWI\t"+chatBot[chatBot.length-1][r]);
}
addText("\n");
}
}

public void keyReleased(KeyEvent e){
if(e.getKeyCode()==KeyEvent.VK_ENTER){
input.setEditable(true);
}
}

public void keyTyped(KeyEvent e){}

public void addText(String str){
dialog.setText(dialog.getText()+str);
}

public boolean inArray(String in,String[] str){
boolean match=false;
for(int i=0;i<str.length;i++){
if(str[i].equals(in)){
match=true;
}
}
return match;
}

}

