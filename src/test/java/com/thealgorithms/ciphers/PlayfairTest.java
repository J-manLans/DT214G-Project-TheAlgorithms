package com.thealgorithms.ciphers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayfairTest {
    private PlayfairCipher playfairCipher;
    private final String keyword = "KEYWORD";

    @BeforeEach
    public void setup() {
        playfairCipher = new PlayfairCipher(keyword);
    }

    @Test
    public void testEncryption() {
        String plaintext = "HELLO";
        String encryptedText = playfairCipher.encrypt(plaintext);
        assertEquals("GYIZSC", encryptedText);
    }

    @Test
    public void testDecryption() {
        String encryptedText = "UDRIYP";
        String decryptedText = playfairCipher.decrypt(encryptedText);
        assertEquals("NEBFVH", decryptedText);
    }

    @Test
    public void testEncryptionAndDecryption() {
        String plaintext = "PLAYFAIR";
        String encryptedText = playfairCipher.encrypt(plaintext);
        String decryptedText = playfairCipher.decrypt(encryptedText);

        assertEquals(plaintext, decryptedText);
    }

    @Test
    void shouldEncryptAndDecryptDuringSameRowDigraph() {
        String plaintext = keyword.substring(0, 2);

        String encrypted = playfairCipher.encrypt(plaintext);
        String decrypted = playfairCipher.decrypt(encrypted);

        assertEquals(plaintext, decrypted, "Should not decrypt to the same letters");
    }

    @Test
    void shouldPadOddLengthplaintext() {
        String plaintext = "cat";

        String encrypted = playfairCipher.encrypt(plaintext);

        assertTrue(encrypted.length() % 2 == 0, "Should be even length");
    }
}
