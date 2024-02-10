package com.example.introtojavafx;

public class EncryptorCaesar {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String encrypt(String plainText, int shiftKey) {
        plainText = plainText.toLowerCase();
        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char currentChar = plainText.charAt(i);
            if (Character.isLetter(currentChar)) {
                int charPosition = ALPHABET.indexOf(currentChar);
                int keyVal = (shiftKey + charPosition) % 26;
                char replaceVal = ALPHABET.charAt(keyVal);
                cipherText.append(replaceVal);
            } else {
                cipherText.append(currentChar); // Preserve non-alphabetic characters
            }
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipherText.length(); i++) {
            char currentChar = cipherText.charAt(i);
            if (Character.isLetter(currentChar)) {
                int charPosition = ALPHABET.indexOf(currentChar);
                int keyVal = (charPosition - shiftKey) % 26;
                if (keyVal < 0) {
                    keyVal = ALPHABET.length() + keyVal;
                }
                char replaceVal = ALPHABET.charAt(keyVal);
                plainText.append(replaceVal);
            } else {
                plainText.append(currentChar); // Preserve non-alphabetic characters
            }
        }

        return plainText.toString();
    }
}

