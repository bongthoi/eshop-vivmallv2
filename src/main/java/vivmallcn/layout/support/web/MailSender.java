package vivmallcn.layout.support.web;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component("myMailSender")
public class MailSender {

	@Autowired
	private Environment env;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public void send(String from, String subject, String body) {
		String to = env.getProperty("spring.mail.username");
		this.send(from, to, subject, body);
	}
	
	
	public void send(String from, String to, String subject, String body) {
		this.send(from, to, "", "", subject, body, "");
	}
	
	
	public void send(String from, String to, String ccs, String bccs, String subject, String body, String attachments) {
		try {
			MimeMessage mail = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
			if(from.contains("<")){
				helper.setFrom(from);
				helper.setReplyTo(from);
			}
			else{
				helper.setFrom(from, from);
				helper.setReplyTo(from, from);
			}
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			if(ccs != null && ccs.trim().length() > 0){
				String[] emails = ccs.split("[\\s;,]+");
				for (String email : emails) {
					helper.addCc(email);
				}
			}
			
			if(bccs != null && bccs.trim().length() > 0){
				String[] emails = bccs.split("[\\s;,]+");
				for (String email : emails) {
					helper.addBcc(email);
				}
			}
			
			if(attachments != null && attachments.trim().length() > 0){
				String[] paths = attachments.split("[\\s;,]+");
				for (String path : paths) {
					File file = new File(path);
					helper.addAttachment(file.getName(), file);
				}
			}
			
			javaMailSender.send(mail);
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
