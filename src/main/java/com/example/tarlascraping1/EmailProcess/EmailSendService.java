package com.example.tarlascraping1.EmailProcess;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class EmailSendService implements Predicate<String> {

    private final JavaMailSender mailSender;
    private final static Logger logger = LoggerFactory.getLogger(EmailSendService.class);

    @Async
    public void sendEmail(String to, String email) {
        if (test(email)){
            try {
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
                helper.setText(email, true);
                helper.setTo(to);
                helper.setSubject("Confirm your email");
                helper.setFrom("test@email.com");
                mailSender.send(mimeMessage);
            } catch (MessagingException e) {
                logger.error("Failed to send email for: " + email + "\n" + e);
                throw new IllegalArgumentException("Failed to send email for: " + email);
            }
        }else {
            logger.error("Email not valid: " + email);
            throw new IllegalArgumentException("Email not valid");
        }
    }
    @Override
    public boolean test(String email) {
        String EMAIL_PATTERN = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        return email.matches(EMAIL_PATTERN);
    }
}
