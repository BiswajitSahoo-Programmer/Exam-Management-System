
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.*;


class Instruction extends JFrame implements ActionListener
{
   
    JButton startexam;
    JLabel  photo , add ;
    JTextArea ta;
    String ro , na;
    
    Instruction(String roll , String name)
    {
      
     ro = roll;
     na = name;

        setSize(1350,1000);
        setBounds(-10, 0, 1350, 1000);
        setUndecorated(true);
        

         ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/pages background student.jpg"));
        Image m2 = m1.getImage().getScaledInstance(1350, 1000,Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m2);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350,1000);
        add(image);

           

        ImageIcon m6 = new ImageIcon(ClassLoader.getSystemResource("icons/index student.png"));
        photo = new JLabel(m6);
        photo.setBounds(30, 30, 150,60);
        image. add(photo);

        add = new JLabel("Instructions");
        add.setBounds(170, 20, 340,90);
        add.setForeground(Color.black);
        add.setFont(new Font( "serif",Font.BOLD,35));
        image.add(add);

       
        startexam = new JButton("Start Exam/Quiz");
        startexam.setBounds(480, 620, 300,30);
        startexam.setBackground(Color.white);
        startexam.addActionListener(this);
        image.add(startexam);

        ta = new JTextArea("1.Carry All Necessary Materials.\r\n" + //
                "2.Follow the Instructions Carefully:\r\n" + //
                "3.Getting Answer Sheet Signed by Invigilator.\r\n" + //
                "4.Make Strategy for Writing an Answer:\r\n" + //
                "5.Manage Your Time:\r\n" + //
                "6.Ignore Other Test Takers:\r\n" + //
                "7.Listen to Any Verbal Instructions.\r\n" + //
                "8.Stay Relax! It's just an exam:");
        ta.setBounds(50, 100, 1200, 500);
        ta.setFont(new Font( "serif",Font.BOLD,42));
        ta.setForeground(Color.white);
        ta.setBackground(Color.BLACK);
        ta.setEditable(false);
        image.add(ta);


        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        

         if(e.getSource() == startexam)
        {

            setVisible(false);
            new QuizExam(ro,na);
           

        }

       
        }
    


public static void main(String[] args)
 {
    String deroll = "";
    String dename = "";
    new Instruction(deroll,dename);
}
}