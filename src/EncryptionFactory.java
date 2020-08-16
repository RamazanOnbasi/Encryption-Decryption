package encryptdecrypt;

public class EncryptionFactory {
    public static Encryption newInstance(String alg) {
        switch (alg) {
            case "unicode":
                return new UnicodeEncryption();
            default:
                return new ShiftingEncryption();
        }
    }
}
