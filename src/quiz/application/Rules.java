
package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Rules extends JFrame implements ActionListener, ItemListener  {
    
    String name;
    JButton start, back ;
    JCheckBox confirmBox;
    
    Rules(String name) {
        this.name = name;
        
        getContentPane().setBackground(Color.WHITE); // Background color
        
        //Rules label
        JLabel headingLabel = new JLabel("Welcome! "+ name +" to Java Quizzical");
        headingLabel.setBounds(50, 60, 500, 30);
        headingLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
        headingLabel.setForeground(new Color(0, 0, 128));
        add(headingLabel);
        
        
        //Rulesinformation label
        JLabel rules = new JLabel();
        rules.setBounds(30, 100, 580, 300);
        rules.setFont(new Font("Tahoma", Font.PLAIN, 12));
        rules.setText(
                "<HTML>"+
                "1. Each quiz session has a predefined duration. Ensure you complete the quiz within the allotted time."+"<br><br>"+
                "2. The quiz consists of multiple-choice questions. Each question has four options, labeled A, B, C, and D."+"<br><br>"+
                "3. Once you have answered all the questions, click the 'Submit' button to finish the quiz."+"<br><br>"+
                "4. You cannot make any changes after submitting the quiz."+"<br><br>"+
                "5. Each correct answer earns you points based on the quiz's scoring system."+"<br><br>"+
                "6. There is no penalty for incorrect answers."+"<br><br>"+
                "7. After submitting the quiz, you will receive immediate feedback on your performance."+"<br><br>"+
                "8. Attempt the quiz independently, without any external assistance or resources."+"<br><br>"+
                "9. Above all, Best wishes for your exam! Use it as an opportunity to test your knowledge and learn new things. "+"<br><br>"+
              "<HTML>"
        );
        add(rules);
        
        // Checkbox to confirm reading rules
        confirmBox = new JCheckBox("I have read and understood all the rules.");
        confirmBox.setBounds(50, 380, 350, 30);
        confirmBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        confirmBox.setBackground(Color.WHITE);
        confirmBox.addItemListener(this); // Add item listener to checkbox
        confirmBox.setBorder(null);
        add(confirmBox);
        
        //Button back label
        back = new JButton("Back");
        back.setBounds(50, 430, 100, 28);
        back.setBackground(new Color(0, 0, 128));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        //Button start label
        start = new JButton("Start");
        start.setBounds(280, 430, 100, 28);
        start.setBackground(new Color(0, 0, 128));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        start.setEnabled(false); // Start button initially disabled
        add(start);
        
        
        setSize(900, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }
    
    //Clickevent action perform override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()== start){
           setVisible(false);
           new Quiz(name);
           
       } else {
           setVisible(false);
           new Login();
       }
    }
    
    // ItemStateChanged event for checkbox
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            start.setEnabled(true); // Enable Start button if checkbox is checked
        } else {
            start.setEnabled(false); // Disable Start button if checkbox is unchecked
        }
    }
    public static void main(String[] args){
        new Rules("User");
    }
    
}
