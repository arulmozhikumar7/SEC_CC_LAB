import java.util.Scanner;

public class VigenereCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter plaintext (lowercase) or ciphertext: ");
        String text = sc.nextLine().toLowerCase();

        System.out.println("Enter key (lowercase): ");
        String key = sc.nextLine().toLowerCase();

        StringBuilder encryptedText = new StringBuilder();
        StringBuilder decryptedText = new StringBuilder();

        // Encrypt
        for (int i = 0, j = 0; i < text.length(); i++) {
            char p = text.charAt(i);
            char k = key.charAt(j % key.length());
            encryptedText.append((char) (((p - 'a' + k - 'a') % 26) + 'a'));
            j++;
        }

        System.out.println("Encrypted Text: " + encryptedText);

        // Decrypt
        for (int i = 0, j = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            char k = key.charAt(j % key.length());
            decryptedText.append((char) (((c - k + 26) % 26) + 'a'));
            j++;
        }

        System.out.println("Decrypted Text: " + decryptedText);
        sc.close();
    }
}
