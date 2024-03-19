
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.*;


class Student extends JFrame implements ActionListener
{
    public static int open;
    JButton saveandnext , back ,exit;
    JLabel  photo , add , date , showdate , l1 , l2 , l3 , l4 , l5;
    JTextField tf1 , tf2 , tf3 , tf4  ;
    JTextArea ta;
    JComboBox cb;
    
    Student()
    {
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

        add = new JLabel("Student Fill Up Form");
        add.setBounds(170, 20, 340,90);
        add.setForeground(Color.black);
        add.setFont(new Font( "serif",Font.BOLD,35));
        image.add(add);

        ImageIcon m8 = new ImageIcon(ClassLoader.getSystemResource("icons/Close.png"));
        exit = new JButton(m8);
        exit.setBounds(1180, 30, 70,60);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/Back.png"));
        back = new JButton("Back",i2);
        back.setBounds(1000,30, 150,60);
        back.addActionListener(this);
        image.add(back);

        ImageIcon m11 = new ImageIcon(ClassLoader.getSystemResource("icons/save.png"));
        saveandnext = new JButton("Save & Next",m11);
        saveandnext.setBounds(250, 550, 400,30);
        saveandnext.addActionListener(this);
        image.add(saveandnext);

         date = new JLabel("Date :");
        date.setBounds(600, 30, 100,60);
        date.setFont(new Font("Tahoma" , Font.BOLD,28));
        image. add(date);

        showdate = new JLabel(" ");
        showdate.setBounds(700, 30, 200,60);
        showdate.setFont(new Font("Tahoma" , Font.BOLD,28));
        image. add(showdate);

        SimpleDateFormat dbdate = new SimpleDateFormat("dd-MM-yyyy");
        Date finaldate = new Date();
        showdate.setText(dbdate.format(finaldate));

        l1 = new JLabel("Roll No :");
        l1.setBounds(100, 150, 150,60);
        l1.setFont(new Font("Tahoma" , Font.BOLD,25));
        image. add(l1);

        tf1 = new JTextField();
        tf1.setBounds(250, 165, 400,30);
        tf1.setFont(new Font( "serif",Font.BOLD,25));
        image.add(tf1);


        l2 = new JLabel("Name :");
        l2.setBounds(100, 230, 100,60);
        l2.setFont(new Font("Tahoma" , Font.BOLD,25));
        image. add(l2);

        tf2 = new JTextField();
        tf2.setBounds(250, 245, 400,30);
        tf2.setFont(new Font( "serif",Font.BOLD,25));
        image.add(tf2);


        l3 = new JLabel("Gender :");
        l3.setBounds(100, 310, 150,60);
        l3.setFont(new Font("Tahoma" , Font.BOLD,25));
        image. add(l3);

        String option[] = {"Male","Female","Others"};
         cb = new JComboBox(option);
        cb.setBounds(250, 325, 170, 30);
        cb.setBackground(Color.white);
        cb.setFont(new Font( "serif",Font.BOLD,25));
        image.add(cb);

        l4 = new JLabel("Phone :");
        l4.setBounds(100, 390, 100,60);
        l4.setFont(new Font("Tahoma" , Font.BOLD,25));
        image. add(l4);

        
        tf3 = new JTextField();
        tf3.setBounds(250, 405, 400,30);
        tf3.setFont(new Font( "serif",Font.BOLD,25));
        image.add(tf3);

        l5 = new JLabel("Email ID :");
        l5.setBounds(100, 480, 150,60);
        l5.setFont(new Font("Tahoma" , Font.BOLD,25));
        image. add(l5);

        
        tf4 = new JTextField();
        tf4.setBounds(250, 490, 400,30);
        tf4.setFont(new Font( "serif",Font.BOLD,25));
        image.add(tf4);

        ta = new JTextArea("Examination Management System is manging \n all the activities related to examination management \n right from recipt of Enrollment Forms and \n Examination Processing > ");
        ta.setBounds(670, 160, 600, 450);
        ta.setFont(new Font( "serif",Font.BOLD,25));
        ta.setEditable(false);
        image.add(ta);





        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == back)
        {
           dispose();
        }

        else if (e.getSource() == exit) 
        {
             JFrame jf1 = new JFrame();
            jf1.setAlwaysOnTop(true);
            int a = JOptionPane.showConfirmDialog(jf1, "Do U Really Want to Exit", "Select",JOptionPane.YES_NO_OPTION);
            if (a == 0){
            dispose();
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                window.dispose();
            }
        }
    }
        else if(e.getSource() == saveandnext)
        {
            String roll = tf1.getText();
            String name = tf2.getText();
            String gender = (String)cb.getSelectedItem();
            String phone = tf3.getText();
            String email = tf4.getText();
            String marks = "0";

             if (!isValidRoll(roll)) {
                JOptionPane.showMessageDialog(null, "Invalid Roll Number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
             if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(null, "Invalid Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Invalid Email Format", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
           
           

            try
            {
                 Conn c = new Conn();
                 String str = "insert into studentexam values('"+roll+"' , '"+name+"' , '"+gender+"' , '"+phone+"' , '"+email+"','"+marks+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Successfully Added");
                setVisible(false);
                new Instruction(roll , name);
                

            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }

        }

       
        }

       private boolean isValidEmail(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern pattern = Pattern.compile(emailRegex);
    return pattern.matcher(email).matches();
}
private boolean isValidPhoneNumber(String phone) {
    String phoneRegex = "^[789]\\d{9}$";
    return phone.matches(phoneRegex);
}
private boolean isValidRoll(String roll) {
    String rollRegex = "^2001289\\d{3}$";
    return roll.matches(rollRegex);
}



    


public static void main(String[] args)
 {
    new Student();
}
}