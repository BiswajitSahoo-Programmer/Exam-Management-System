import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

class Home extends JFrame implements ActionListener {
    JButton student, admin, exit;
    int studentClickCount = 0;
    String lastClickDate = "";

    Home() {
        setSize(1350, 1000);
        setBounds(-10, 0, 1350, 1000);
        setUndecorated(true);

        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/index background.png"));
        Image m2 = m1.getImage().getScaledInstance(1350, 1000, Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m2);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350, 1000);
        add(image);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/index student.png"));
        student = new JButton("Student", i1);
        student.setBounds(700, 50, 150, 60);
        student.setBackground(Color.ORANGE);
        student.addActionListener(this);
        image.add(student);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/index admin.png"));
        admin = new JButton("Admin", i2);
        admin.setBounds(900, 50, 140, 60);
        admin.setBackground(Color.GREEN);
        admin.addActionListener(this);
        image.add(admin);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/close.png"));
        exit = new JButton("Exit", i3);
        exit.setBounds(1100, 50, 130, 60);
        exit.setBackground(Color.white);
        exit.addActionListener(this);
        image.add(exit);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == admin) {
            new Admin();
        } else if (e.getSource() == student) {
            handleStudentButtonClick();
        } else if (e.getSource() == exit) {
            int a = JOptionPane.showConfirmDialog(null, "Do U Really Want to Exit", "Select", JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                System.exit(0);
            }
        }
    }

    private void handleStudentButtonClick() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String currentTime = dateFormat.format(new Date());

       
        if (currentTime.compareTo("10:00") >= 0 && currentTime.compareTo("4:00") <= 0) {
            SimpleDateFormat dateOnlyFormat = new SimpleDateFormat("yyyy-MM-dd");
            String currentDate = dateOnlyFormat.format(new Date());

            if (!currentDate.equals(lastClickDate)) {
                studentClickCount = 0;
                lastClickDate = currentDate;
            }

            if (studentClickCount < 12) {
                new Student();
                studentClickCount++;
            } else {
                JOptionPane.showMessageDialog(null, "Exam Attempt Exceeds, come back tomorrow");
            }
        } else {
            JOptionPane.showMessageDialog(null,  "Exam is only accessible from 4:00 PM to 6:00 PM");
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
