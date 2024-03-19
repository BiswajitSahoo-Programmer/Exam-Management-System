
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class Admin extends JFrame implements ActionListener
{
    public static int open;
    JButton login , back;
    JLabel lbluser , lblpass;
    JTextField username;
    JPasswordField password;
    JCheckBox cb;
    Admin()
    {
        setSize(1350,1000);
        setBounds(-10, 0, 1350, 1000);
        setUndecorated(true);

        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/login1.jpg"));
        Image m2 = m1.getImage().getScaledInstance(1350, 1000,Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m2);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350,1000);
        add(image);

        lbluser = new JLabel("Username");
        lbluser.setBounds(600, 150, 200,90);
        lbluser.setForeground(Color.black);
        lbluser.setFont(new Font( "serif",Font.BOLD,25));
        image.add(lbluser);

        username = new JTextField();
        username.setBounds(800, 180, 400,30);
        username.setFont(new Font( "serif",Font.BOLD,25));
        image.add(username);

        lblpass = new JLabel("Password");
        lblpass.setBounds(600, 250, 1000,90);
        lblpass.setForeground(Color.black);
        lblpass.setFont(new Font( "serif",Font.BOLD,25));
        image.add(lblpass);

        password = new JPasswordField();
        password.setBounds(800, 280, 400,30);
        password.setFont(new Font( "serif",Font.BOLD,25));
        image.add(password);


        cb = new JCheckBox("Show Password");
        cb.setBounds(890, 350, 170,30);
        cb.setForeground(Color.black);
        cb.setFont(new Font( "serif",Font.BOLD,20));
        cb.addActionListener(this);
        image.add(cb);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        login = new JButton("Login",i1);
        login.setBounds(800,450, 150,60);
        login.addActionListener(this);
        image.add(login);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/Back.png"));
        back = new JButton("Back",i2);
        back.setBounds(1060,450, 150,60);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == login)
        {
            if(username.getText().equals("admin@2024") && password.getText().equals("0412"))
            {
                dispose();
                new Login();
            }
            else{
                ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icons/Incorrect Password.png"));
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                username.setText("");
                password.setText("");
            }
        }
        if(e.getSource() == back)
        { 
            int a = JOptionPane.showConfirmDialog(null, "Do U Really Want to Exit","Select",JOptionPane.YES_NO_OPTION);
            if(a == 0)
            {
                dispose();
                
            }
        }

        if(cb.isSelected())
        {
            password.setEchoChar((char)0);
        }
        else
        {
            password.setEchoChar('*');
        }
    }

public static void main(String[] args)
 {
    new Admin();
}
}