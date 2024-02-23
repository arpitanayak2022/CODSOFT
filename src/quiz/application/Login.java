/* Developed by ARPITA NAYAK */
package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
    JButton rules, back;
    JTextField tFname;
    
    Login(){
        
        // Create a layered pane to hold the images
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(400, 600));
        
        // Image label
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/image.jpg"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0, 0, 400, 600);
        layeredPane.add(imageLabel, JLayeredPane.DEFAULT_LAYER);
        
        // Imageiconjava label
        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icons/icons8-java-500.png"));
        JLabel imageLabel2 = new JLabel(imageIcon2);
        imageLabel2.setBounds(0, 0, 400, 450);
        layeredPane.add(imageLabel2, JLayeredPane.PALETTE_LAYER);
        
        setContentPane(layeredPane);
        
        // Heading label
        JLabel headingLabel = new JLabel("Java Quizzical");
        headingLabel.setBounds(500, 40, 300, 80);
        headingLabel.setFont(new Font("Snap ITC", Font.BOLD, 30));
        headingLabel.setForeground(new Color(0, 0, 128));
        add(headingLabel);
        
        // Sub-heading label
        JLabel subHeadingLabel = new JLabel("Enter Your Name");
        subHeadingLabel.setBounds(540, 160, 300, 16);
        subHeadingLabel.setFont(new Font("Mongolian Baiti", Font.PLAIN, 24));
        subHeadingLabel.setForeground(new Color(0, 0, 128));
        add(subHeadingLabel);
        
        // Textfield label
        tFname = new JTextField();
        tFname.setBounds(500, 210, 260, 38);
        tFname.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(tFname);
        
        //  Jlabel to check the rules
        JLabel checkRule = new JLabel("Please read the rules carefully before starting.");
        checkRule.setBounds(500, 250, 260, 38);
        checkRule.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        checkRule.setForeground(Color.red);
        add(checkRule);
        
        // Button label1
        rules = new JButton("Rules");
        rules.setBounds(500, 300, 100, 28);
        rules.setBackground(new Color(0, 0, 128));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        // Button label2
        back = new JButton("Back");
        back.setBounds(660, 300, 100, 28);
        back.setBackground(new Color(0, 0, 128));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Java Quizzical");
        getContentPane().setBackground(Color.WHITE); // Background color
        setVisible(true);
        
        // Disable maximize button
        setResizable(false);
    }
    
    // Click event action perform override
    public void actionPerformed(ActionEvent ae){
        /*if(ae.getSource()== rules){
            String name = tFname.getText();
            setVisible(true);
            new Rules(name);
        } else if (ae.getSource()== back){
            setVisible(false);*/

            if(ae.getSource()== rules){
        String name = tFname.getText().trim(); // Trim to remove leading and trailing whitespaces
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name before proceeding.", "Name Required", JOptionPane.WARNING_MESSAGE);
        } else {
            setVisible(false); // Hide the login window
            new Rules(name); // Show the rules window with the provided name
        }
    } else if (ae.getSource()== back){
        setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
