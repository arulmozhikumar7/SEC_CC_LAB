import java.math.BigInteger;

class RSA {
    public static void main(String[] args) {
        // Step 1: Choose two prime numbers
        int p = 3; // First prime
        int q = 11; // Second prime
        // Step 2: Calculate n
        int n = p * q; // n = p * q
        // Step 3: Calculate z
        int z = (p - 1) * (q - 1); // z = (p-1)*(q-1)
        // Step 4: Choose public exponent e
        int e = 3; // A common choice for e
        while (gcd(e, z) != 1) { // Ensure e is coprime with z
            e++; // Increment e until it is coprime with z
        }
        // Step 5: Calculate private exponent d
        int d = 0; // Initialize d
        for (int k = 0; ; k++) {
            if ((1 + k * z) % e == 0) {
                d = (1 + k * z) / e; // Calculate d
                break; // Exit loop when d is found
            }
        }
        // Step 6: The message to encrypt
        int msg = 12;
        // Step 7: Encrypt the message
        BigInteger c = BigInteger.valueOf(msg).modPow(BigInteger.valueOf(e), BigInteger.valueOf(n));
        System.out.println("Encrypted message: " + c);
        // Step 8: Decrypt the message
        BigInteger decryptedMsg = c.modPow(BigInteger.valueOf(d), BigInteger.valueOf(n));
        System.out.println("Decrypted message: " + decryptedMsg);
    }
    // Helper method to compute GCD
    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b); // Recursive GCD calculation
    }
}
