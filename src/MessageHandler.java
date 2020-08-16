package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MessageHandler {
    private String alg;
    private String mode;
    private String data;
    private int key;
    private String in;
    private String out;

    public MessageHandler() {
        alg = "shift";
        mode = "enc";
        data = "";
        key = 0;
        in = "";
        out = "";
    }

    public MessageHandler(String[] args) {
        this();
        assigner(args);
    }

    public void assigner(String[] args) {
        if (args.length % 2 != 0)
            System.out.println("Error: Invalid syntax.");
        else {
            for (int i = 0; i < args.length; i += 2) {
                switch (args[i]) {
                    case "-mode":
                        mode = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        data = args[i + 1];
                        break;
                    case "-in":
                        in = args[i + 1];
                        break;
                    case "-out":
                        out = args[i + 1];
                        break;
                    case "-alg":
                        alg = args[i + 1];
                }
            }
        }
    }

    private String dataSelector(String data, String in) throws IOException {
        if (!data.isEmpty() || in.isEmpty())
            return data;
        else
            return Files.readString(Path.of(in));
    }

    private void dataPrinter(String message, String out) {
        if (out.isEmpty())
            System.out.println(message);
        else {
            try (FileWriter fileWriter = new FileWriter(out)) {
                fileWriter.write(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleMessage() {
        try {
            String selectedData = dataSelector(data, in);
            Encryption encryption = EncryptionFactory.newInstance(alg);
            String message;

            if (mode.equals("dec")) {
                message = encryption.decrypt(selectedData, key);
            } else {
                message = encryption.encrypt(selectedData, key);
            }

            dataPrinter(message, out);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
