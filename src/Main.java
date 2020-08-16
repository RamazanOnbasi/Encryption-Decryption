package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        MessageHandler messageHandler = new MessageHandler(args);
        messageHandler.handleMessage();
    }
}