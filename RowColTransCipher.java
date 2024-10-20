import java.util.Scanner;

public class RowColTransCipher {
    private static Scanner in;

    public static void main(String[] args) {
        System.out.println("Columnar Transposition Cipher");
        in = new Scanner(System.in);
        System.out.print("1. Encryption\n2. Decryption\nChoose(1,2): ");
        int choice = in.nextInt();
        in.nextLine();

        if (choice == 1) {
            System.out.println("Encryption");
            encryption();
        } else if (choice == 2) {
            System.out.println("Decryption");
            decryption();
        } else {
            System.out.println("Invalid Choice");
            System.exit(0);
        }
    }

    private static void encryption() {
        System.out.print("Enter Message: ");
        String plainText = in.nextLine().toUpperCase().replace(" ", "");
        StringBuilder msg = new StringBuilder(plainText);

        System.out.print("Enter Keyword: ");
        String keyword = in.nextLine().toUpperCase();
        int[] kywrdNumList = keywordNumAssign(keyword);

        // Display the keyword and its numeric assignments
        for (int i = 0, j = 1; i < keyword.length(); i++, j++) {
            System.out.print(keyword.substring(i, j) + " ");
        }
        System.out.println();

        for (int i : kywrdNumList) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("-------------------------");

        int extraLetters = msg.length() % keyword.length();
        int dummyCharacters = keyword.length() - extraLetters;

        // Add dummy characters if necessary
        if (extraLetters != 0) {
            for (int i = 0; i < dummyCharacters; i++) {
                msg.append(".");
            }
        }

        // Prepare the 2D array for the cipher text
        int numOfRows = msg.length() / keyword.length();
        char[][] arr = new char[numOfRows][keyword.length()];
        int z = 0;

        // Fill the array with characters from the message
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                arr[i][j] = msg.charAt(z);
                z++;
            }
        }

        // Display the 2D array
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        StringBuilder cipherText = new StringBuilder();
        System.out.println();
        String numLoc = getNumberLocation(keyword, kywrdNumList);
        System.out.println("Location of numbers: " + numLoc);
        System.out.println();

        // Generate the cipher text based on keyword order
        for (int i = 0, k = 0; i < numOfRows; i++, k++) {
            int d;
            if (k == keyword.length()) {
                break;
            } else {
                d = Character.getNumericValue(numLoc.charAt(k));
            }
            for (int j = 0; j < numOfRows; j++) {
                cipherText.append(arr[j][d]);
            }
        }

        System.out.println("Cipher Text: " + cipherText);
    }

    private static void decryption() {
        System.out.print("Enter Message: ");
        String msg = in.nextLine().toUpperCase().replace(" ", "");
        System.out.print("Enter Keyword: ");
        String keyword = in.nextLine().toUpperCase();
        int numOfRows = msg.length() / keyword.length();
        char[][] arr = new char[numOfRows][keyword.length()];
        int[] kywrdNumList = keywordNumAssign(keyword);
        String numLoc = getNumberLocation(keyword, kywrdNumList);

        // Fill the array with characters from the message
        for (int i = 0, k = 0; i < msg.length(); i++, k++) {
            int d = 0;
            if (k == keyword.length()) {
                k = 0;
            } else {
                d = Character.getNumericValue(numLoc.charAt(k));
            }
            for (int j = 0; j < numOfRows; j++, i++) {
                arr[j][d] = msg.charAt(i);
            }
            --i;
        }

        // Construct the plain text from the array
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                plainText.append(arr[i][j]);
            }
        }

        System.out.println("Plain Text: " + plainText);
    }

    private static String getNumberLocation(String keyword, int[] kywrdNumList) {
        StringBuilder numLoc = new StringBuilder();
        for (int i = 1; i < keyword.length() + 1; i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (kywrdNumList[j] == i) {
                    numLoc.append(j);
                }
            }
        }
        return numLoc.toString();
    }

    private static int[] keywordNumAssign(String keyword) {
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] kywrdNumList = new int[keyword.length()];
        int init = 0;

        for (int i = 0; i < alpha.length(); i++) {
            for (int j = 0; j < keyword.length(); j++) {
                if (alpha.charAt(i) == keyword.charAt(j)) {
                    init++;
                    kywrdNumList[j] = init;
                }
            }
        }

        return kywrdNumList;
    }
}
