
import java.io.*;
import java.net.*;
class Admin extends FormDesigner//Inheritance
{
    private static ServerSocket serverSocket;
    private static Socket socketAdmin;
    
    Admin() 
    {
        SetPanel();
        SetLabelAdmin();
        SetTextField();
        SetButtonAdmin();
        SetTextArea();
        SetFrame();
    }
    
    public static void main(String[] args ) {
      new Admin().setVisible(true);
      
       try {

        serverSocket = new ServerSocket(6688);
        socketAdmin = serverSocket.accept();
        dataInputStreamAdmin = new DataInputStream(socketAdmin.getInputStream());
        dataOutputStreamAdmin = new DataOutputStream(socketAdmin.getOutputStream());
        
        String messageInputAdmin = "";

        while (true) {
        messageInputAdmin = dataInputStreamAdmin.readUTF();
        textArea.setText(textArea.getText() + "\n" + "Sujash : " + messageInputAdmin);
       }
        
       } catch (Exception e) {
            e.printStackTrace();
       } 
       
    }
}
