/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java_SendEmail;

/**
 *
 * @author Nguyen Hong The
 */

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
             // Authenticated and send mail
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
                                // Tài khoản và mật khẩu gửi thư gmail.
                                // Bật xác minh hai bước cho tài khoản google
                                // sau đó tạo mật khẩu ứng dụng nhập vào đây.
                                
                                // Địa chỉ gmail
                                "itshare.online@gmail.com",
                                // Mật khẩu ứng dụng
                                "sgmcnudwbenksxto"
                        );
                 }
             };
 
             Session session = Session.getInstance(props, auth);
             Message msg = new MimeMessage(session);
 
             msg.setFrom(new InternetAddress
                (
                        // Gửi Email đi từ địa chỉ này
                        "ITShare.Online Channel<itshare.online@gmail.com>"
                )
             );
             msg.setSubject(
                     // Tiêu đề Email
                     "Anh Nhớ Em"
             );
             msg.setRecipient(Message.RecipientType.TO, new InternetAddress
                (
                        // Địa chỉ người nhận
                        "Nguyen Hong The<honggiatamthieu@gmail.com>"
                )
             );
             msg.setContent
                (
                        // Nội dung lời nhắn, dạng String
                        "<h1>Hello ! How are you ?</h1>"
                                + "<br /><br />"
                                + "Khỏe cái bép!"
                                + "<br /><br />"
                                + "Ờ"
                                + "<br /><br />"
                                + "<p>Tạm Biệt!</p>",
                        "text/html; charset=UTF-8"
                );
 
             Transport.send(msg);
 
         } catch (MessagingException ex) {
             System.out.print(ex.toString());
         }
    }
    
}