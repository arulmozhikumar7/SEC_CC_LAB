import java.util.Scanner;

class Railfence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message:");
        String msg = sc.nextLine(); 
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder(); 
        for (int ptr = 0; ptr < msg.length(); ptr++) {
            if (ptr % 2 == 0) {
                a.append(msg.charAt(ptr));
            } else {
                b.append(msg.charAt(ptr));
            }
        }
        String enmsg = a.toString() + b.toString();
        System.out.println("Cipher Text: " + enmsg);
        StringBuilder pltxt = new StringBuilder();
        int maxLength = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLength; i++) {
            if (i < a.length()) pltxt.append(a.charAt(i));
            if (i < b.length()) pltxt.append(b.charAt(i));
        }
        System.out.println("Plain Text: " + pltxt.toString());
        sc.close();
    }
}
