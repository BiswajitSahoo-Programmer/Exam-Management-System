
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;


class AllStudentResult extends JFrame implements ActionListener 
{
  
    JLabel photo , add ;
    JTable table;
    JButton  exit;
    AllStudentResult()
    {
        setSize(1350,1000);
        setBounds(-10, 0, 1350, 1000);
        setUndecorated(true);
        setLayout(null);


        ImageIcon m4 = new ImageIcon(ClassLoader.getSystemResource("icons/pages background admin.jpg"));
        Image m5 = m4.getImage().getScaledInstance(1350, 1000,Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m5);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350,1000);
        add(image);

        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/all student result.png"));
        photo = new JLabel(m1);
        photo.setBounds(30, 30, 150,60);
        image. add(photo);

        add = new JLabel("All Student Result");
        add.setBounds(180, 20, 400,90);
        add.setForeground(Color.black);
        add.setFont(new Font( "serif",Font.BOLD,35));
        image.add(add);

         ImageIcon m2 = new ImageIcon(ClassLoader.getSystemResource("icons/Close.png"));
        exit = new JButton(m2);
        exit.setBounds(1150, 30, 70,60);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

        //  l1 = new JLabel("Filter Student By Marks : ");
        // l1.setBounds(50, 100, 400,90);
        // l1.setFont(new Font( "serif",Font.BOLD,30));
        // image.add(l1);

        //  tf1 = new JTextField();
        // tf1.setBounds(400, 125, 100,40);
        // tf1.setFont(new Font( "serif",Font.BOLD,35));
        // image.add(tf1);



        table = new JTable();
        table.setBounds(100, 200, 1100, 450);
        image.add(table);


        try
        {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentexam");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
    
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
      
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae)
    {
       
        if (ae.getSource() == exit)
        {
            Login.open = 0;
           dispose();
            
        }
    }

public static void main(String[] args)
 {
    new AllStudentResult();
}
}


