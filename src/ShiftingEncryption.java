package encryptdecrypt;

public class ShiftingEncryption implements Encryption {

    @Override
    public String encrypt(String data, int key) {
        if (key == 0) {
            return data;
        } else {
            char[] charText = data.toCharArray();

            for (int i = 0; i < charText.length; i++) {
                if (charText[i] >= 'a' && charText[i] <= 'z') {
                    if (charText[i] + key <= 'z') {
                        charText[i] = (char) (charText[i] + key);
                    } else {
                        charText[i] = (char) (charText[i] + key - 26);
                    }
                } else if (charText[i] >= 'A' && charText[i] <= 'Z') {
                    if (charText[i] + key <= 'Z') {
                        charText[i] = (char) (charText[i] + key);
                    } else {
                        charText[i] = (char) (charText[i] + key - 26);
                    }
                }
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
                if (charText[i] >= 'a' && charText[i] <= 'z') {
                    if (charText[i] - key >= 'a') {
                        charText[i] = (char) (charText[i] - key);
                    } else {
                        charText[i] = (char) (charText[i] - key + 26);
                    }
                } else if (charText[i] >= 'A' && charText[i] <= 'Z') {
                    if (charText[i] - key >= 'A') {
                        charText[i] = (char) (charText[i] - key);
                    } else {
                        charText[i] = (char) (charText[i] - key + 26);
                    }
                }
            }
            return new String(charText);
        }
    }
}
