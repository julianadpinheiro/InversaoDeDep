package model;

public class LoggingMessageServiceDecorator implements MessageService {
    private MessageService wrapped;

    public LoggingMessageServiceDecorator(MessageService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("[LOG] Enviando mensagem: " + message);
        wrapped.sendMessage(message);
    }
}