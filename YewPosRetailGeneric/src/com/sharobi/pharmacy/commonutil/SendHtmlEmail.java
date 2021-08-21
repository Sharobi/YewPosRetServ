package com.sharobi.pharmacy.commonutil;
import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sharobi.pharmacy.common.EmailBean;

public class SendHtmlEmail {

	public SendHtmlEmail() {
		// TODO Auto-generated constructor stub
	}

	public int sendEmail(EmailBean bean) throws Exception {
		int status=0;
	try {
		
		System.out.println("Mail");
		//byte[] attchmentData=bean.getAttchmntData();
		//System.out.println("size of data:: "+attchmentData.length);
	
		//final String from = "rajarshi.chaki@sharobitech.com";
		final String from = bean.getFromAddr();
		//String to = "rajarshi.chaki@sharobitech.com";
		String to = bean.getToAddr();
		//String host = "smtpout.secureserver.net";
		String host = bean.getMailSmtp();

		//final String mailpwd = "chaki@123";
		final String mailpwd = bean.getMailPwd();

		//String portno = "25";
		String portno = bean.getMailPort();

		Properties properties = new Properties();

		properties.put("mail.smtp.host", host);

		//properties.put("mail.smtp.socketFactory.port", portno);
		//if you use SSL then you might get security issue,authentication error
		properties.put("mail.smtp.starttls.enable", "true");

		properties.put("mail.smtp.auth", "true");

		properties.put("mail.smtp.port", portno);

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, mailpwd);
			}
		});

		
			MimeBodyPart htmlBodyPart = new MimeBodyPart();
			htmlBodyPart.setContent(bean.getMessageBody(),"text/html; charset=utf-8");
	        MimeMultipart mimeMultipart = new MimeMultipart();
	        mimeMultipart.addBodyPart(htmlBodyPart);
	        
	        //DataSource dataSource = new ByteArrayDataSource(attchmentData, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        String tempFile= "c:\\temp_data\\purchase_order.xlsx";
	        if (bean.getIsAttachment().equalsIgnoreCase("Y")) {
				
				DataSource dataSource = new FileDataSource(tempFile);
				MimeBodyPart xlsBodyPart = new MimeBodyPart();
				xlsBodyPart.setDataHandler(new DataHandler(dataSource));
				xlsBodyPart.setFileName("purchaseOrder.xlsx");
				mimeMultipart.addBodyPart(xlsBodyPart);
			}
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(bean.getSubject());
			message.setContent(mimeMultipart);
			
			
			// Send message
			Transport.send(message);
			status=-10;
			System.out.println("Sent message successfully....");
			//Delete if tempFile exists
	        File fileTemp = new File(tempFile);
	          if (fileTemp.exists()){
	             fileTemp.delete();
	          }
	         	//success
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		catch (Exception x) {
			x.printStackTrace();
		}
		return status;	
	}
	

}
