
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.*;

class Submission extends JFrame implements ActionListener {

    JLabel photo, l1;

    JButton exit;

    Submission(String marks1) {

        setSize(1350, 1000);
        setBounds(-10, 0, 1350, 1000);
        setUndecorated(true);

        ImageIcon m4 = new ImageIcon(ClassLoader.getSystemResource("icons/pages background admin.jpg"));
        Image m5 = m4.getImage().getScaledInstance(1350, 1000, Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m5);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350, 1000);
        add(image);

        photo = new JLabel("Marks Obtained : 10");
        photo.setBounds(400, 200, 600, 200);
        photo.setFont(new Font("serif", Font.BOLD, 60));
        image.add(photo);

        l1 = new JLabel("Successfully Updated");
        l1.setBounds(400, 300, 600, 200);
        l1.setFont(new Font("serif", Font.BOLD, 60));
        image.add(l1);

        ImageIcon m2 = new ImageIcon(ClassLoader.getSystemResource("icons/Close.png"));
        exit = new JButton(m2);
        exit.setBounds(1150, 30, 70, 60);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

        String marks2 = "Marks Obtained : " + marks1;
        photo.setText(marks2);

        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exit) {
            int option = JOptionPane.showConfirmDialog(null, "Try Again?","Confirmation",JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                dispose();
               
                
            } else if(option == JOptionPane.NO_OPTION){

                dispose();
                Window[] windows = Window.getWindows();
            for (Window window : windows) {
                window.dispose();
            }
            }

        }

    }

    public static void main(String[] args) {
        String deresult = "";

        new Submission(deresult);
    }
}
