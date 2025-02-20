import java.util.Scanner;
public class AutoKeyCipher {
    public static String encrypt(String plaintext, String key) {
        StringBuilder extendedKey = new StringBuilder(key);
        extendedKey.append(plaintext); // Append plaintext to the key
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            char k = extendedKey.charAt(i);
            char c = (char) (((p - 'A') + (k - 'A')) % 26 + 'A');
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }
    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        StringBuilder extendedKey = new StringBuilder(key);
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char k = extendedKey.charAt(i);
            char p = (char) (((c - 'A') - (k - 'A') + 26) % 26 + 'A');
            plaintext.append(p);
            extendedKey.append(p); 
        }
        return plaintext.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plaintext (uppercase letters only): ");
        String plaintext = sc.nextLine().toUpperCase();
        System.out.print("Enter key (uppercase letters only): ");
        String key = sc.nextLine().toUpperCase();
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
        String decryptedText = decrypt(ciphertext, key);
        System.out.println("Decrypted text: " + decryptedText);
        sc.close();
    }
}