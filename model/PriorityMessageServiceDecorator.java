package model;

public class PriorityMessageServiceDecorator implements MessageService {
    private MessageService wrapped;

    public PriorityMessageServiceDecorator(MessageService wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void sendMessage(String message) {
        wrapped.sendMessage("[PRIORITÁRIA] " + message);
    }
}