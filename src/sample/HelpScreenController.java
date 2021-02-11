package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;


public class HelpScreenController {

    @FXML private TextField helpEmail;
    @FXML private TextArea helpPrompt;
    private String senderAddress;
    private String sentMessage;

    /*
    When the user clicks the back arrow, loads the main menu.
     */
    public void returnHome() throws IOException {

        Parent menuRoot = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene menu = new Scene(menuRoot);
        menu.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

        Main.getWindow().setScene(menu);
    }

    /*
    Prepares the messages that will be sent by defining a session,
    as well as two internet addresses (the recipient and sender).
    Returns null if it is unable to do so to prevent the program from crashing.
     */
    public Message prepareMessage(Session session, String supportEmail, String recipient){

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(supportEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Help Requested");
            message.setText(sentMessage + "\n\n\nFROM: " + senderAddress);
            return message;

        } catch (MessagingException e) {
            e.printStackTrace();

        }
        return null;

    }

    /*
    Logs into Gmail's  smtp server, and also logs into the
    support gmail account that was created for this program. The
    message from the prepareMessage() function is then sent from the
    support email to itself.
     */
    public void sendEmail() throws MessagingException {
        senderAddress = helpEmail.getText();
        sentMessage = helpPrompt.getText();

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String supportEmail = "fblaquizhelp2021@gmail.com";
        String password = "fblaquiz2021";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(supportEmail, password);
            }
        });

        Message message = prepareMessage(session, supportEmail, supportEmail);

        Transport.send(message);
    }

}
