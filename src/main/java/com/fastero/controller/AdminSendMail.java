package com.fastero.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.tomcat.util.http.fileupload.util.mime.MimeUtility;

import com.mysql.cj.protocol.Message;

/**
 * Servlet implementation class AdminSendMail
 */
@WebServlet("/AdminSendMail")
public class AdminSendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}

//class MailService {
//	private final static String HOST = "smtp.gmail.com";
//	private final static String AUTH = "true";
//	private final static String PORT = "587";
//	private final static String STARTTLE_ENABLE = "true";
//	private final static String SENDER = "9766533@gmail.com";
//	private final static String PASSWORD = "mqajmyfwwxrzsuai";
//
//	// 設定傳送郵件:至收信人的Email信箱,Email主旨,Email內容
//	public void sendMail(String recipients, String mailSubject, String mailBody) {
////			String recipientCcs = "副本mail";
//		Properties props = new Properties();
//		props.put("mail.smtp.host", HOST);
//		props.put("mail.smtp.auth", AUTH);
//		props.put("mail.smtp.port", PORT);
//		props.put("mail.smtp.starttls.enable", STARTTLE_ENABLE);
//		props.put("mail.smtp.ssl.trust", HOST);
//		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//
////	      設定 gmail 的帳號 & 密碼 (將藉由你的Gmail來傳送Email)
//		Authenticator authenticator = new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(SENDER, PASSWORD);
//			}
//		};
//
//		Session session = Session.getDefaultInstance(props, authenticator);
//		Message message = new MimeMessage(session);
//
//		try {
////				設定Email Message start
//
////				設定寄件人、收件人、副本、主旨
//			message.setSentDate(new Date());
//			message.setHeader("Content-Type", "text/html; charset=UTF-8");
//			message.setFrom(new InternetAddress(SENDER));
//			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
////				message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(recipientCcs));
////	          https://javaee.github.io/javamail/docs/api/javax/mail/internet/MimeUtility.html#encodeText-java.lang.String-java.lang.String-java.lang.String- (第三個參數參考API文件)
//			message.setSubject(MimeUtility.encodeText(mailSubject, StandardCharsets.UTF_8.toString(), "B"));
//
////				first part (text)
//			MimeBodyPart messageBody = new MimeBodyPart();
//			messageBody.setContent(mailBody, "text/html; charset=UTF-8");
//
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBody);
//
////////	          second part (the image) 可根據自己需要決定是否要加這段
////				File file = new File("picture/20211214151834.jpg");
////				MimeBodyPart messageImgBody = new MimeBodyPart();
////				DataSource fds = new FileDataSource(file);
//			//
////				messageImgBody.setDataHandler(new DataHandler(fds));
////				messageImgBody.setHeader("Content-ID", "<image>");
////				messageImgBody.setFileName(file.getName());
//			//
//////	          add image to the multipart
////				multipart.addBodyPart(messageImgBody);
//
//			message.setContent(multipart);
//
////	   		寄出email
//			Transport transport = session.getTransport("smtp");
//			try {
//				transport.connect();
//				transport.sendMessage(message, message.getAllRecipients());
//			} finally {
//				transport.close();
//			}
//
//		} catch (AddressException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		} catch (NoSuchProviderException e) {
//			e.printStackTrace();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//	}
//
//	// 測試用
//	public static void main(String args[]) {
//
//		String to = "接收者的信箱";
//
//		String subject = "密碼通知";
//
//		String ch_name = "David";
//		String passRandom = "111";
//		String messageText = "Hello! " + ch_name + " 請謹記此密碼: " + passRandom + "\n" + " (已經啟用)";
//
//		MailService mailService = new MailService();
//		mailService.sendMail(to, subject, messageText);
//
//	}
//
//}