package model;

public class WhatsAppService implements MessageService {
    private String numero;

    public WhatsAppService(String numero) {
        this.numero = numero;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Enviando WhatsApp para " + numero + ": " + message);
    }
}