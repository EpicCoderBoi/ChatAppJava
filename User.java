import java.net.*;
import java.io.*;

public class User extends FormDesigner  //Inheritance
{
    private static Socket socketClient;

    User () 
    {
        SetPanel();
        //SetUsernamePassword();
        SetLabelClient();
        SetTextField();
        SetButtonUser();
        SetTextArea();
        SetFrame();
    }

    

    public static void main(String[] args ) {
      
       new User();
       
       try {
        var myIP = InetAddress.getLocalHost();
        socketClient = new Socket(myIP.getHostAddress(), 6688);
        dataInputStreamUser = new DataInputStream(socketClient.getInputStream());
        dataOutputStreamUser = new DataOutputStream(socketClient.getOutputStream());

        String messageInputUser = "";

        while(true) {
        messageInputUser = dataInputStreamUser.readUTF();
        textArea.setText(textArea.getText() + "\n" + "Admin : " + messageInputUser);
        }
        
       } catch (Exception e) {
            e.printStackTrace();
       }
    }

}