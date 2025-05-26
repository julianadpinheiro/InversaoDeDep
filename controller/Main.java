package controller;
import model.EmailService;
import model.SMSService;
import model.WhatsAppService;
import model.LoggingMessageServiceDecorator;
import model.PriorityMessageServiceDecorator;

public class Main {
    public static void main(String[] args) {
        // Polimorfismo: NotificationManager aceita qualquer MessageService
        EmailService emailService = new EmailService("admin@exemplo.com");
        SMSService smsService = new SMSService("+5511999999999");
        WhatsAppService whatsAppService = new WhatsAppService("+5511988888888");

        // Baixo acoplamento: NotificationManager não sabe qual implementação está usando
        NotificationManager emailManager = new NotificationManager(emailService);
        NotificationManager smsManager = new NotificationManager(smsService);
        NotificationManager whatsManager = new NotificationManager(whatsAppService);

        emailManager.send("Mensagem simples por e-mail.");
        smsManager.send("Mensagem simples por SMS.");
        whatsManager.send("Mensagem simples por WhatsApp.");

        // Decorator robusto: combinando log e prioridade
        // Email com prioridade e log
        PriorityMessageServiceDecorator priorityEmail = new PriorityMessageServiceDecorator(emailService);
        LoggingMessageServiceDecorator loggedPriorityEmail = new LoggingMessageServiceDecorator(priorityEmail);
        NotificationManager decoratedEmailManager = new NotificationManager(loggedPriorityEmail);
        decoratedEmailManager.send("Mensagem importante!");

        // WhatsApp só com log
        LoggingMessageServiceDecorator loggedWhats = new LoggingMessageServiceDecorator(whatsAppService);
        NotificationManager decoratedWhatsManager = new NotificationManager(loggedWhats);
        decoratedWhatsManager.send("Mensagem logada no WhatsApp!");

        // SMS só com prioridade
        PriorityMessageServiceDecorator prioritySMS = new PriorityMessageServiceDecorator(smsService);
        NotificationManager decoratedSMSManager = new NotificationManager(prioritySMS);
        decoratedSMSManager.send("Mensagem urgente por SMS!");
    }
}