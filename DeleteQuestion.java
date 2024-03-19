import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


import javax.swing.*;


class DeleteQuestion extends JFrame implements ActionListener
{
  
    JLabel photo , add ;
    JLabel qid  , ques , op1 , op2 , op3 , op4 , ans;
    JTextField tf1 , tf2 , tf3 , tf4 , tf5 , tf6 , idvalue;
    JButton delete , clear , exit , search;
    DeleteQuestion()
    {
        setSize(1350,1000);
        setBounds(-10, 0, 1350, 1000);
        setUndecorated(true);

        ImageIcon m4 = new ImageIcon(ClassLoader.getSystemResource("icons/pages background admin.jpg"));
        Image m5 = m4.getImage().getScaledInstance(1350, 1000,Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m5);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350,1000);
        add(image);

        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete Question.png"));
        photo = new JLabel(m1);
        photo.setBounds(30, 30, 150,60);
        image. add(photo);

        add = new JLabel("Delete Question");
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

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        delete = new JButton("Delete",i1);
        delete.setBounds(1100,350, 150,60);
        delete.addActionListener(this);
        image.add(delete);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/clear.png"));
        clear = new JButton("Clear",i2);
        clear.setBounds(1100,550, 150,60);
        clear.addActionListener(this);
        image.add(clear);

        ImageIcon i9 = new ImageIcon(ClassLoader.getSystemResource("icons/search.png"));
        search = new JButton("Search",i9);
        search.setBounds(650,160, 150,60);
        search.addActionListener(this);
        image.add(search);

        
        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == delete)
        {
            String strid = idvalue.getText();
           

            try
            {
                 Conn c = new Conn();
                 String str = "delete from question where id = '"+idvalue.getText()+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
                setVisible(false);
                new Login();

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

        else if(ae.getSource() == search)
        {
            String idno = idvalue.getText();
            try
            {
                 Conn c = new Conn();
                 String query = "select * from question where id = '"+idno+"' ";
                 ResultSet rs = c.s.executeQuery(query);
                 if(rs.next())
                 {
                    tf1.setText(rs.getString(2));
                    tf2.setText(rs.getString(3));
                    tf3.setText(rs.getString(4));
                    tf4.setText(rs.getString(5));
                    tf5.setText(rs.getString(6));
                    tf6.setText(rs.getString(7));

                    

                 }

                 else
                 {
                    JOptionPane.showMessageDialog(null, "Question does not exist");
                    setVisible(false);
                 }


            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }


    }
public static void main(String[] args)
 {
    new DeleteQuestion();
}
}