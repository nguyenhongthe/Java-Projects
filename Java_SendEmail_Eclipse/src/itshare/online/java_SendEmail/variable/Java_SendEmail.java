package itshare.online.java_SendEmail.variable;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Java_SendEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
            // Authenticated and send mail
            // Please reconfigure the information
            // relevant to your mail delivery service
            
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.mime.charset", "utf-8");


            Authenticator auth;
            auth = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication
                       (
                           // Mail account and password.
                           // If you use Gmail, please turn on two-step verification:
                           // https://myaccount.google.com/security/signinoptions/two-step-verification
                           // Then create an application password and enter it below
                           // https://security.google.com/settings/security/apppasswords
                               
                           // Email address
                           "YourName@gmail.com",
                           // Application password
                           "YourAppPass"
                       );
                }
            };

            Session session = Session.getInstance(props, auth);
            Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress
               (
                       // Send an email from this address
                       "YourName<YourName@gmail.com>"
               )
            );
            msg.setSubject(
                    // Email Subject
                    "This is a test subject for your message"
            );
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress
               (
                       // Receiver's address
                       "ITShare.Online Channel<itshare.online@gmail.com>"
               )
            );
            msg.setContent
               (
                       // Message body, String type
                       "<h1>Hello ! How are you ?</h1>"
                       + "<p>Nice to meet you!</p>"
                       + "<p>Goodbye!</p>"
                       + "<p>Sent from Mail for Java project on Eclipse.</p>",
                       "text/html; charset=UTF-8"
               );

            Transport.send(msg);

        } catch (MessagingException ex) {
            System.out.print(ex.toString());
        }

	}

}
