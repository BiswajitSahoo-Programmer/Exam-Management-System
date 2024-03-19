
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;


class AddNewQuestion extends JFrame implements ActionListener
{
  
    JLabel photo , add ;
    JLabel qid  , ques , op1 , op2 , op3 , op4 , ans;
    JTextField tf1 , tf2 , tf3 , tf4 , tf5 , tf6 , idvalue;
    JButton save , clear , exit;
    AddNewQuestion()
    {
        setSize(1350,1000);
        setBounds(-10, 0, 1350, 1000);

        ImageIcon m4 = new ImageIcon(ClassLoader.getSystemResource("icons/pages background admin.jpg"));
        Image m5 = m4.getImage().getScaledInstance(1350, 1000,Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m5);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350,1000);
        add(image);

        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/add new question.png"));
        photo = new JLabel(m1);
        photo.setBounds(30, 30, 150,60);
        image. add(photo);

        add = new JLabel("Add New Question");
        add.setBounds(180, 20, 300,90);
        add.setForeground(Color.black);
        add.setFont(new Font( "serif",Font.BOLD,35));
        image.add(add);

         ImageIcon m2 = new ImageIcon(ClassLoader.getSystemResource("icons/Close.png"));
        exit = new JButton(m2);
        exit.setBounds(1150, 30, 70,60);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

        qid = new JLabel("Question ID");
        qid.setBounds(200, 150, 200,60);
        qid.setFont(new Font("Tahoma" , Font.BOLD,28));
        image.add(qid);

        idvalue = new JTextField();
        idvalue.setBounds(400, 170, 100,30);
        idvalue.setFont(new Font( "serif",Font.BOLD,20));
        add(idvalue);

        ques = new JLabel("Question");
        ques.setBounds(200, 230, 200,60);
        ques.setFont(new Font("Tahoma" , Font.BOLD,28));
        image.add(ques);

        tf1 = new JTextField();
        tf1.setBounds(400, 250, 400,30);
        tf1.setFont(new Font( "serif",Font.BOLD,20));
        add(tf1);

        op1 = new JLabel("Option 1");
        op1.setBounds(200, 310, 200,60);
        op1.setFont(new Font("Tahoma" , Font.BOLD,28));
        image.add(op1);

        tf2 = new JTextField();
        tf2.setBounds(400, 325, 400,30);
        tf2.setFont(new Font( "serif",Font.BOLD,20));
        add(tf2);

        op2 = new JLabel("Option 2");
        op2.setBounds(200, 390, 200,60);
        op2.setFont(new Font("Tahoma" , Font.BOLD,28));
       image.add(op2);

        tf3 = new JTextField();
        tf3.setBounds(400, 400, 400,30);
        tf3.setFont(new Font( "serif",Font.BOLD,20));
        add(tf3);

       op3 = new JLabel("Option 3");
        op3.setBounds(200, 470, 200,60);
        op3.setFont(new Font("Tahoma" , Font.BOLD,28));
       image. add(op3);

        tf4 = new JTextField();
        tf4.setBounds(400, 480, 400,30);
        tf4.setFont(new Font( "serif",Font.BOLD,20));
        add(tf4);

         op4 = new JLabel("Option 4");
        op4.setBounds(200, 550, 200,60);
        op4.setFont(new Font("Tahoma" , Font.BOLD,28));
       image.add(op4);

        tf5 = new JTextField();
        tf5.setBounds(400, 565, 400,30);
        tf5.setFont(new Font( "serif",Font.BOLD,20));
        add(tf5);

        ans = new JLabel("Answer");
        ans.setBounds(200, 620, 200,60);
        ans.setFont(new Font("Tahoma" , Font.BOLD,28));
        image.add(ans);

        tf6 = new JTextField();
        tf6.setBounds(400, 630, 400,30);
        tf6.setFont(new Font( "serif",Font.BOLD,20));
        add(tf6);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/save.png"));
        save = new JButton("Save",i1);
        save.setBounds(1100,350, 150,60);
        save.addActionListener(this);
        image.add(save);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/clear.png"));
        clear = new JButton("Clear",i2);
        clear.setBounds(1100,550, 150,60);
        clear.addActionListener(this);
        image.add(clear);

        
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == save)
        {
            String id = idvalue.getText();
            String name = tf1.getText();
            String op1 = tf2.getText();
            String op2 = tf3.getText();
            String op3 = tf4.getText();
            String op4 = tf5.getText();
            String answer = tf6.getText();

            try
            {
                 Conn c = new Conn();
                 String str = "insert into question values('"+id+"' , '"+name+"' , '"+op1+"' , '"+op2+"' , '"+op3+"' , '"+op4+"' , '"+answer+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Successfully Added");
                
                

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

        }

        else if (ae.getSource() == clear)
        {
              tf1.setText("");
              tf2.setText("");
              tf3.setText("");
              tf4.setText("");
              tf5.setText("");
              tf6.setText("");

        }

        else if (ae.getSource() == exit)
        {
            Login.open = 0;
            dispose();
        }


    }
public static void main(String[] args)
 {
    new AddNewQuestion();
}
}




