package botSendingEmail;

import javax.mail.MessagingException;

public class mainEmailBot {

	public static void main(String[] args) {
		
		// emailBot("Adresse mail destinataire","Objet du mail","Contenu du mail");

		emailBot emailBot = new emailBot("XXXXXXXXXX@gmail.com", "TestBotJavaEmail", "Message");
		
		try {
			emailBot.sendMail();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

}
