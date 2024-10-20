import java.io.*;
import java.security.*;

public class DSA {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DSS <filename>");
            return;
        }
        try {
            // Key pair generation
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            keyGen.initialize(1024);
            KeyPair keyPair = keyGen.generateKeyPair();

            // Initialize signature with private key
            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initSign(keyPair.getPrivate());

            // Read file and update signature
            try (FileInputStream fis = new FileInputStream(args[0])) {
                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) != -1) {
                    signature.update(buffer, 0, len);
                }
            }

            // Generate and save digital signature
            byte[] digitalSignature = signature.sign();
            try (FileOutputStream sigOut = new FileOutputStream("signature.sig")) {
                sigOut.write(digitalSignature);
            }

            // Save public key
            try (FileOutputStream keyOut = new FileOutputStream("publicKey.pub")) {
                keyOut.write(keyPair.getPublic().getEncoded());
            }

            System.out.println("Signature and public key saved.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
