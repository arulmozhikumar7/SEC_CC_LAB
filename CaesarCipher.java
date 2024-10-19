public class CaesarCipher{
    public static String encrypt(String msg,int shift)
    {
        StringBuilder encryptedmsg = new StringBuilder();
        for(int i=0;i<msg.length();i++){
            char c = msg.charAt(i);
            if(Character.isLetter(c)){
                char base = Character.isUpperCase(c) ? 'A':'a';
                c = (char) ((c-base+shift)%26+base);
            }
            encryptedmsg.append(c);
        }
        return encryptedmsg.toString();
    }
    public static String decrypt(String msg,int shift){
        return encrypt(msg, 26-shift);
    }
    public static void main(String[] args){
        String message = "HELLO WORLD";
        int shift = 3;
        String encryptedMessage = encrypt(message, shift);
        System.out.println("Original Message: " + message);
        System.out.println("Shift: " + shift);
        System.out.println("Encrypted Message: " + encryptedMessage);
        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}