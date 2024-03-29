package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Quiz extends JFrame implements ActionListener {
    
    // 2D array for question
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    
    JLabel queno, question;
    JRadioButton option1, option2, option3, option4;
    ButtonGroup groupoptions;
    JButton next, submit;
    
    public static int timer = 15;
    public static int answer_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        
        setBounds(50, 50, 1430, 730);
        getContentPane().setBackground(Color.WHITE); // Background color
        setLayout(null);
        
        // adding imageicon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/imagecolor.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1430, 250);
        add(image);
        
        queno = new JLabel();
        queno.setBounds(100, 300, 50, 30);
        queno.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        add(queno);
        
        question = new JLabel();
        question.setBounds(140, 300, 900, 30);
        question.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(question);
        
        questions[0][0] = "Who invented Java Programming?";
        questions[0][1] = "Guido van Rossum";
        questions[0][2] = "James Gosling";
        questions[0][3] = "Dennis Ritchie";
        questions[0][4] = "Bjarne Stroustrup";
        
        questions[1][0] = "Which component is used to compile, debug and execute the java programs?";
        questions[1][1] = "JRE";
        questions[1][2] = "JIT";
        questions[1][3] = "JVM";
        questions[1][4] = "JDK";
        
        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";
        
        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";
        
        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";
        
        questions[5][0] = "Which of the following is not an OOPS concept in Java?";
        questions[5][1] = "Polymorphism";
        questions[5][2] = "Inheritance";
        questions[5][3] = "Compilation";
        questions[5][4] = "Encapsulation";
        
        questions[6][0] = "Which of the following is a valid long literal?";
        questions[6][1] = "ABH8097";
        questions[6][2] = "L990023";
        questions[6][3] = "904423";
        questions[6][4] = "0xnf029L";
        
        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";
        
        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";
        
        questions[9][0] = "_____ is used to find and fix bugs in the Java programs.";
        questions[9][1] = "JVM";
        questions[9][2] = "JDK";
        questions[9][3] = "JRE";
        questions[9][4] = "JDB";
        
        answers[0][1] = "James Gosling";
        answers[1][1] = "JDK";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Compilation";
        answers[6][1] = "0xnf029L";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "JDB";
        
        option1 = new JRadioButton();
        option1.setBounds(140, 380, 700, 30);
        option1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        option1.setBackground(Color.WHITE);
        add(option1);
        
        option2 = new JRadioButton();
        option2.setBounds(140, 430, 700, 30);
        option2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        option2.setBackground(Color.WHITE);
        add(option2);
        
        option3 = new JRadioButton();
        option3.setBounds(140, 480, 700, 30);
        option3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        option3.setBackground(Color.WHITE);
        add(option3);
        
        option4 = new JRadioButton();
        option4.setBounds(140, 530, 700, 30);
        option4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        option4.setBackground(Color.WHITE);
        add(option4);
        
        // Buttongroup for options
        groupoptions = new ButtonGroup();
        groupoptions.add(option1);
        groupoptions.add(option2);
        groupoptions.add(option3);
        groupoptions.add(option4);
        
        next = new JButton("Next");
        next.setBounds(1100, 430, 200, 40);
        next.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        next.setBackground(new Color(0, 0, 128));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 490, 200, 40);
        submit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        submit.setBackground(new Color(0, 0, 128));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false);
        submit.addActionListener(this);
        add(submit);
        
        start(count);
        
        setVisible(true);
        
        // Disable maximize button
        setResizable(false);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {// for next buttom perform
            repaint();// count increase
            
            answer_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
            
        } else if (ae.getSource() == submit) { // submit button
            answer_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
            
            // score
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time Left - " + timer + "seconds"; // timer for 15 sec.
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 20)); // Define font for the text
        
        if (timer > 0) {
            // Set the font for drawing text
            g.drawString(time, 1100, 400);
        } else {
            // Set the font for drawing text
            g.drawString("Time Out!!", 1160, 400);
        }
        timer--; // 14sec
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (answer_given == 1) {
            answer_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // for submit button
                
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                
                // score
                new Score(name, score);
            } else {// for next button
                if (groupoptions.getSelection() == null) {
                    useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                count++; // 0 //1
                start(count);
            }
        }
    }
    
    public void start(int count) {
        queno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        option1.setText(questions[count][1]);
        option1.setActionCommand(questions[count][1]);
        
        option2.setText(questions[count][2]);
        option2.setActionCommand(questions[count][2]);
        
        option3.setText(questions[count][3]);
        option3.setActionCommand(questions[count][3]);
        
        option4.setText(questions[count][4]);
        option4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
    
}

