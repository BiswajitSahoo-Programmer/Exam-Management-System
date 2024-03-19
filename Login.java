
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class Login extends JFrame implements ActionListener 
{
    public static int open = 0;
    JButton update;

    Login() 
    {
        setSize(1350, 1000);
        setBounds(-10, 0, 1350, 1000);
        setUndecorated(true);
        

        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("icons/index background.png"));
        Image m2 = m1.getImage().getScaledInstance(1350, 1000, Image.SCALE_DEFAULT);
        ImageIcon m3 = new ImageIcon(m2);
        JLabel image = new JLabel(m3);
        image.setBounds(-10, 0, 1350, 1000);
        add(image);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1350, 70);
        image.add(mb);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add new question.png"));
        JMenuItem add = new JMenuItem("Add New Question", i1);
        add.setForeground(Color.blue);
        add.addActionListener(this);
        mb.add(add);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/Update Question.png"));
        JMenuItem update = new JMenuItem("Update Question", i2);
        update.setForeground(Color.blue);
        update.addActionListener(this);
        mb.add(update);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/all questions.png"));
        JMenuItem all = new JMenuItem("All Question", i3);
        all.setForeground(Color.blue);
        all.addActionListener(this);
        mb.add(all);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/delete Question.png"));
        JMenuItem delete = new JMenuItem("Delete Question", i4);
        delete.setForeground(Color.blue);
        delete.addActionListener(this);
        mb.add(delete);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("icons/all student result.png"));
        JMenuItem result = new JMenuItem("All Student Result", i5);
        result.setForeground(Color.blue);
        result.addActionListener(this);
        mb.add(result);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("icons/Logout.png"));
        JMenuItem logout = new JMenuItem("Logout", i6);
        logout.setForeground(Color.blue);
        logout.addActionListener(this);
        mb.add(logout);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/Close.png"));
        JMenuItem exit = new JMenuItem("Exit", i7);
        exit.setForeground(Color.blue);
        exit.addActionListener(this);
        mb.add(exit);

        setLayout(null);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Add New Question")) {
            if(open == 0)
            {
                new AddNewQuestion();
                open = 1;
            }

            else
            {
            //      JFrame jf = new JFrame();
            // jf.setAlwaysOnTop(true);
            // JOptionPane.showMessageDialog(jf, "One form is allready open");
            new AddNewQuestion();
            }
        } 

        else if (ae.getActionCommand().equals("Update Question")) {
            if(open == 0)
            {
                new UpdateQuestion();
                open = 1;
            }
        }

         else if (ae.getActionCommand().equals("All Question")) {
            if(open == 0)
            {
                new AllQuestion();
                open = 1;
            }
        }
         else if (ae.getActionCommand().equals("Delete Question")) {
            if(open == 0)
            {
                new DeleteQuestion();
                open = 1;
            }
        }

         else if (ae.getActionCommand().equals("All Student Result")) {
            if(open == 0)
            {
                new AllStudentResult();
                open = 1;
            }
        }
        else if (ae.getActionCommand().equals("Logout")) 
        {
            JFrame jf = new JFrame();
            jf.setAlwaysOnTop(true);
            int a = JOptionPane.showConfirmDialog(jf, "Do U Really Want to Logout", "Select",JOptionPane.YES_NO_OPTION);
            if (a == 0) {
                dispose();
                

            }
        } 
        else if (ae.getActionCommand().equals("Exit")) 
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
    }

    public static void main(String[] args) {
        new Login();
    }
}