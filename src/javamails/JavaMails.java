
package javamails;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMails {
 public static void sendMails(String recipient) throws Exception
 {
     System.out.println("preparing to send email");
     Properties properties = new Properties();
     properties.put("mail.smtp.auth","true");
     properties.put("mail.smtp.starttls.enable","true");
     properties.put("mail.smtp.host","smtp.gmail.com");
     properties.put("mail.smtp.port","587");
     
    String myAccount ="silumikaundika@gmail.com";
    String password ="Kaundi@20817";
    
     
     //mail.smtp.auth -- whether authentication is needed (mandatory)
     //mail.smtp.starttls.enable
     //mail.smtp.host -- smtp.gmail.com
     //mail.smtp.port -- 587
   Session session = Session.getInstance(properties, new Authenticator(){ // login to account
       @Override
       protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(myAccount,password);
       }
       
   });
   Message message = prepareMessage(session, myAccount, recipient);
   Transport.send(message);
   System.out.println("Message sent successfully!");
 }
 private static Message prepareMessage(Session session, String myAccount, String recipient){
     try {
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(myAccount));
         message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));// cc  can
         message.setSubject("My First Email from java");
         message.setText("Hey my Love \n I love You \n Forever!!!"); //setContent
         return message;
     } catch (Exception ex) {
         Logger.getLogger(JavaMails.class.getName()).log(Level.SEVERE, null, ex);
     }
     return null;
 }
}
// security of senders email should be reduced
//avast deactivated
