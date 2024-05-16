package cityHallAPI.dev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    public void sendEmail(String toEmail, String subject, String body) {


        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(env.getProperty("spring.mail.username"));
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        javaMailSender.send(message);

        System.out.print("Email sent");
    }
}
