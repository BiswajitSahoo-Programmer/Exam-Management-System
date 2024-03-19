
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.*;


class QuizExam extends JFrame implements ActionListener
{
    public static int open;
    JButton submit , next;
    JLabel  photo , add , date , showdate , l1 , l2 , l3 , l4 , l5 , l6 , l7 , l8 ,l9 , l10  , l13 , l14 , l15 , quest, l11 , l12  , lmin ;
    JRadioButton r1 , r2 , r3 , r4;
    
    JComboBox cb;
     
    String questionid = "1";
    String answer = "";

    int min = 0;
    int sec = 0;
    int marks = 0;
    Timer time;
    String r , n;
    ButtonGroup bgp;

    public void answercheck()
    {
        String studentans = "";
        if(r1.isSelected())
        {
            studentans = r1.getText();
        }
        else if(r2.isSelected())
        {
            studentans = r2.getText();
        }
        else if(r3.isSelected())
        {
            studentans = r3.getText();
        }
        else
        {
            studentans = r4.getText();
        }

        if(studentans.equals(answer))
        {
            marks = marks+1;
            String marks1 = String.valueOf(marks);
            l15.setText(marks1);
        }

        //Question number change
        int quesid = Integer.parseInt(questionid);
        quesid = quesid+1;
        questionid = String.valueOf(quesid);

        //Clear raddiobutton

        //last question hide
        if(questionid.equals("20"))
        {
            next.setVisible(false);
        }

    }
    public void question()
    {
           try
            {
                 Conn c = new Conn();
              
                ResultSet rs1 = c.s.executeQuery("select * from question where id = '"+questionid+"'");
                while(rs1.next())
                {
                    l14.setText(rs1.getString(1));
                    quest.setText(rs1.getString(2));
                    r1.setText(rs1.getString(3));
                    r2.setText(rs1.getString(4));
                    r3.setText(rs1.getString(5));
                    r4.setText(rs1.getString(6));
                    answer = rs1.getString(7);

                }
              

            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }

    }
    public void submit()
    {
        String rollNO = l11.getText();
        answercheck();
        try{
            Conn c = new Conn();
            String query2 = ("update studentexam set marks = '"+marks+"' where roll = '"+rollNO+"'");
            c.s.executeUpdate(query2);
            String marks1 = String.valueOf(marks);
            setVisible(false);
            new Submission(marks1);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    QuizExam(String ro , String na)
    {
      
        r = ro;
        n = na;
       
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

        add = new JLabel("Examination : ");
        add.setBounds(170, 20, 340,90);
        add.setForeground(Color.black);
        add.setFont(new Font( "serif",Font.BOLD,35));
        image.add(add);

         l6 = new JLabel("Total Time : ");
        l6.setBounds(1100, 20, 150,60);
        image. add(l6);

        l7 = new JLabel("10 Min");
        l7.setBounds(1200, 20, 150,60);
        image. add(l7);

        
         l8 = new JLabel("Time Taken : ");
        l8.setBounds(1100, 40, 150,60);
        image. add(l8);

        l9 = new JLabel("00");
        l9.setBounds(1200, 40, 150,60);
        image. add(l9);

         lmin = new JLabel("00");
        lmin.setBounds(1220, 40, 150,60);
        image. add(lmin);



         date = new JLabel("Date :");
        date.setBounds(600, 30, 100,60);
        date.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(date);

        showdate = new JLabel(" ");
        showdate.setBounds(700, 30, 200,60);
        showdate.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(showdate);

        SimpleDateFormat dbdate = new SimpleDateFormat("dd-MM-yyyy");
        Date finaldate = new Date();
        showdate.setText(dbdate.format(finaldate));

        l1 = new JLabel("Roll :");
        l1.setBounds(100, 150, 150,60);
        l1.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l1);


        l2 = new JLabel("Name :");
        l2.setBounds(100, 230, 100,60);
        l2.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l2);


        l3 = new JLabel("Total Question :");
        l3.setBounds(100, 310, 200,60);
        l3.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l3);

        l4 = new JLabel("Question No :");
        l4.setBounds(100, 390, 150,60);
        l4.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l4);

        l5 = new JLabel("Your Marks :");
        l5.setBounds(100, 480, 200,60);
        l5.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l5);


        //CORESSPONDING LEVELS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


         l11 = new JLabel("");
        l11.setBounds(200, 170, 250,20);
        l11.setText(r);
        l11.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l11);


        l12 = new JLabel("");
        l12.setBounds(200, 250, 250,20);
        l12.setFont(new Font("Tahoma" , Font.BOLD,20));
        l12.setText(n);
        image. add(l12);


        l13 = new JLabel("10");
        l13.setBounds(300, 310, 200,60);
        l13.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l13);

        l14 = new JLabel("01");
        l14.setBounds(300, 390, 150,60);
        l14.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l14);

        l15 = new JLabel("00");
        l15.setBounds(300, 480, 200,60);
        l15.setFont(new Font("Tahoma" , Font.BOLD,20));
        image. add(l15);

        //Buttons 

        ImageIcon m11 = new ImageIcon(ClassLoader.getSystemResource("icons/Next.png"));
        next = new JButton("Next",m11);
        next.setBounds(550, 600, 200,40);
        next.addActionListener(this);
        image.add(next);

        ImageIcon m12 = new ImageIcon(ClassLoader.getSystemResource("icons/save.png"));
        submit = new JButton("Submit",m12);
        submit.setBounds(950, 600, 200,40);
        submit.addActionListener(this);
        image.add(submit);

        //Qusetion and options >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        quest = new JLabel(" your question");
        quest.setBounds(500, 100, 800,60);
        quest.setFont(new Font("Tahoma" , Font.BOLD,25));
        image. add(quest);

       r1 = new JRadioButton();
       r1.setBounds(500, 200, 300, 30);
       r1.setBackground(Color.orange);
       image.add(r1);
        r2 = new JRadioButton();
       r2.setBounds(500, 250, 300, 30);
       r2.setBackground(Color.orange);
       image.add(r2);
        r3 = new JRadioButton();
       r3.setBounds(500, 300, 300, 30);
       r3.setBackground(Color.orange);
       image.add(r3);
        r4 = new JRadioButton();
       r4.setBounds(500, 350, 300, 30);
       r4.setBackground(Color.orange);
       image.add(r4);
       bgp = new ButtonGroup();
       bgp.add(r1);
       bgp.add(r2);
       bgp.add(r3);
       bgp.add(r4);


 

          //Question And Student Details>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        
            try
            {
                 Conn c = new Conn();
                String roll = l11.getText();
                ResultSet rs = c.s.executeQuery("select * from studentexam where roll = '"+roll+"'");
            

                while(rs.next())
                {

                    l12.setText(rs.getString(2));
                }

                ResultSet rs1 = c.s.executeQuery("select * from question where id = '"+questionid+"'");
                while(rs1.next())
                {
                    l14.setText(rs1.getString(1));
                    quest.setText(rs1.getString(2));
                    r1.setText(rs1.getString(3));
                    r2.setText(rs1.getString(4));
                    r3.setText(rs1.getString(5));
                    r4.setText(rs1.getString(6));
                    answer = rs1.getString(7);

                }
              

            }
            catch(Exception ae)
            {
                ae.printStackTrace();
            }

            // time 

            setLocationRelativeTo(this);
            time = new Timer(1000,new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    l9.setText(String.valueOf(min));
                    lmin.setText(String.valueOf(sec));

                    if(sec == 60)
                    {
                        sec = 0;
                        min++;
                        if(min == 10)
                        {
                            time.stop();
                            answercheck();
                            submit();
                        }
                    }
                    sec++;
                  
                }
            });
            time.start();
        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == next)
        {
            
            answercheck();
            question();
            bgp.clearSelection();
           
        }


        else  if(e.getSource() == submit)
        {
            int a = JOptionPane.showConfirmDialog(null,"Do You Really Want to submit","Select",JOptionPane.YES_NO_OPTION);
            if(a == 0)
            {
                answercheck();
                submit();
            }

        }

       
        }
    


public static void main(String[] args)
 {
    
    String deroll = "";
    String dename = "";
    new QuizExam(deroll,dename);
}
}