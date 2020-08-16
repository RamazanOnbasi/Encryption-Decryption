package encryptdecrypt;

public class UnicodeEncryption implements Encryption {
    @Override
    public String encrypt(String data, int key) {
        if (key == 0) {
            return data;
        } else {
            char[] charText = data.toCharArray();
            for (int i = 0; i < charText.length; i++) {
                charText[i] = (char) (charText[i] + key);
            }
            return new String(charText);
        }
    }

    @Override
    public String decrypt(String data, int key) {
        if (key == 0) {
            return data;
        } else {
            char[] charText = data.toCharArray();
            for (int i = 0; i < charText.length; i++) {
                charText[i] = (char) (charText[i] - key);
            }
            return new String(charText);
        }
    }
}
