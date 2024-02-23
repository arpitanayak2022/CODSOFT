package quiz.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    
    Score(String name, int score) {
        setBounds(400, 150, 850, 550);
        getContentPane().setBackground(Color.WHITE); // Background color
        setLayout(null);
        
        // adding imageicon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/7.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i1);
        image.setBounds(490, 100, 650, 450);
        add(image);
        
        JLabel heading = new JLabel("Thank you " + name + " for playing Java Quiziccals.");
        heading.setBounds(20, 100, 800, 30);
        heading.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        add(heading);
        
        JLabel finalscore = new JLabel("Your score is " + score + " out of 100.");
        finalscore.setBounds(50, 150, 300, 30);
        finalscore.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(finalscore);
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(100, 250, 180, 30);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submit.setBackground(new Color(0, 0, 128));
        submit.setForeground(Color.WHITE);
        
        submit.addActionListener(this);
        add(submit);
        
        setVisible(true);
        
        // Disable maximize button
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new Score("User", 0);
    }
    
}

