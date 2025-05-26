package model;

public class EmailService implements MessageService {
    private String emailFrom;

    public EmailService(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Enviando e-mail de " + emailFrom + ": " + message);
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }
}