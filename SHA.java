//hash algorithm
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
// Java program to calculate SHA hash value
class SHA {
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException   {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    public static String toHexString(byte[] hash)   {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);
        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));
        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
    // Driver code
    public static void main(String args[])  {
        try {
            System.out.println("\nHashCode Generated by SHA-256 for:");
            // string s1-rollno
            String s1 = "191080054";
            System.out.println("\n" + s1 + " : " + toHexString(getSHA(s1)));
            // string s2-name of student
            String s2 = "Mahesh Pachare";
            System.out.println("\n" + s2 + " : " + toHexString(getSHA(s2)));
        }
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
    }
}