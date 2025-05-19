
public class Main {
    public static void main(String[] args) {
        // Usando EmailService
        EmailService emailService = new EmailService("admin@exemplo.com");
        NotificationManager emailManager = new NotificationManager(emailService);
        emailManager.send("Olá por e-mail!");

        // Usando SMSService
        SMSService smsService = new SMSService("+5511999999999");
        NotificationManager smsManager = new NotificationManager(smsService);
        smsManager.send("Olá por SMS!");
    }
}
