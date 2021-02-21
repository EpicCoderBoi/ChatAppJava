import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public abstract class FormDesigner extends JFrame{
    
    protected JPanel panel;
    protected JLabel label;
    protected JTextField textField;
    protected JButton button;
    protected JOptionPane questionPane;
    protected static JTextArea textArea;

    protected static DataInputStream dataInputStreamUser;
    protected static DataOutputStream dataOutputStreamUser;

    protected static DataInputStream dataInputStreamAdmin;
    protected static DataOutputStream dataOutputStreamAdmin;

    protected void SetPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(7,94,84));
        panel.setBounds(0,0, 450,70);
        add(panel);
    }

    protected void SetLabelAdmin() {
        label = new JLabel("Chatting Application Admin");
        label.setForeground(Color.ORANGE);
        label.setBounds(175,15,170,30);
        panel.add(label);
    }

    protected void SetLabelClient() {
        label = new JLabel("Chatting Application Client");
        label.setForeground(Color.ORANGE);
        label.setBounds(175,15,170,30);
        panel.add(label);
    }

    protected void SetTextField() {
        textField = new JTextField();
        textField.setBounds(10, 600, 310, 40);
        textField.setFont(new Font("Calibri", Font.PLAIN, 18));
        add(textField);
    }

    protected void SetButtonUser() {
        button = new JButton("Send");
        button.setBounds(310, 600, 120, 40);
        button.setBackground(new Color(7,94,84));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Calibri", Font.BOLD, 18));
        button.addActionListener(new ActionsUser());
        add(button);
    }

    protected void SetButtonAdmin() {
        button = new JButton("Send");
        button.setBounds(310, 600, 120, 40);
        button.setBackground(new Color(7,94,84));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Calibri", Font.BOLD, 18));
        button.addActionListener(new ActionsAdmin());
        add(button);
    }
    
    protected void SetTextArea() {
        textArea = new JTextArea();
        textArea.setBounds(5,75,425,510);
        textArea.setBackground(Color.WHITE);
        textArea.setFont(new Font("Calibri", Font.PLAIN, 18));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(textArea);
    }

    /*
    protected void SetUsernamePassword() {
        questionPane = new JOptionPane();
        username = JOptionPane.showInputDialog("Please enter your username: ");
        password = JOptionPane.showInputDialog("Please enter your password");

    }
    */

    protected void SetFrame () {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setTitle("Online Chatting Application");
        setVisible(true);
        setSize(450,685);
        setResizable(false);

    }

    class ActionsUser implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            try {
                String outputMessage = textField.getText();
                textArea.setText(textArea.getText() + "\n"+ outputMessage); //Keeps on setting and removing the text from the textArea so that we can append more messages.
                textField.setText("");
                dataOutputStreamUser.writeUTF(outputMessage);
                } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class ActionsAdmin implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {
            try {
                String outputMessage = textField.getText();
                textArea.setText(textArea.getText() + "\n"+ outputMessage); //Keeps on setting and removing the text from the textArea so that we can append more messages.
                textField.setText("");
                dataOutputStreamAdmin.writeUTF(outputMessage);
                } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
