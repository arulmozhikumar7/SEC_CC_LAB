import java.util.Scanner;

public class HillCipher {
    public static void main(String[] args) {
        int[][] key = { {17, 17, 5}, {21, 18, 21}, {2, 2, 19} };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plain text (multiple of 3): ");
        String plainText = sc.nextLine().toLowerCase();
        while (plainText.length() % 3 != 0) {
            plainText += 'x';
        }
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i += 3) {
            for (int row = 0; row < 3; row++) {
                int sum = 0;
                for (int col = 0; col < 3; col++) {
                    sum += key[row][col] * (plainText.charAt(i + col) - 'a');
                }
                cipherText.append((char) ((sum % 26) + 'a'));
            }
        }
        System.out.println("Encrypted Text: " + cipherText.toString());
        sc.close();
    }
}
