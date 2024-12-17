package com.example.oktatest;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSACrypto2 {

    public static void main(String[] args) {
        final String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuloVssHolqAFqV2x0hjaCoCLgLI2aztvLpd+6d+XSHqtz1VRJLynKX/OYgmPKTRmUWZYbRzxPUQyyt89kpqdYsKNTn9SAPHNll7QFmewLhfx0jazdE8iJ3fzDF12eYqlklpTewHGXUY3Z3aG+ClEEFmrS8TbNowSCT4e5QDZ+PKEzbOuWSjCLnBV6BI8r4kFA1mnYb/g0R/GQTa3MrwB+7eI1G8fQMJkposvrzJff8AisyXlHNMFSbOSNHo+5LxxAP5AKf/tSsNQ2sAE5FaAJex6WPSSPeI51cPy93WPGCFOT8mwHJOue4cUxvtB5mLngBwMyd5sz/IDanFq7iTNTwIDAQAB";
        final String privateKey = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQC6WhWyweiWoAWpXbHSGNoKgIuAsjZrO28ul37p35dIeq3PVVEkvKcpf85iCY8pNGZRZlhtHPE9RDLK3z2Smp1iwo1Of1IA8c2WXtAWZ7AuF/HSNrN0TyInd/MMXXZ5iqWSWlN7AcZdRjdndob4KUQQWatLxNs2jBIJPh7lANn48oTNs65ZKMIucFXoEjyviQUDWadhv+DRH8ZBNrcyvAH7t4jUbx9AwmSmiy+vMl9/wCKzJeUc0wVJs5I0ej7kvHEA/kAp/+1Kw1DawATkVoAl7HpY9JI94jnVw/L3dY8YIU5PybAck657hxTG+0HmYueAHAzJ3mzP8gNqcWruJM1PAgMBAAECggEAGK5GsmqugIiIHMLX2Bt01rA+Ca5QuR9hiHpbE47f7U2w3cVkc6j4EMMoaovukIar8yWgGi9w9JbRjVScxeEWwtZBOyoaCnL8B2mI8MwMevED6j4BbYBE5epOio7fBUDreziIVuxza7YZhL6ffe2P4gR7mejkHv4qg1vdYUzIEbQ/Ldl6PBfm3Is/oWvHGK82yXRl7zsKUJSWv63jFBNfHxCTLuXbpEkAEyeiCkHSO0sUpp59Aj3BKTYrEnA47ZOgJxOVNR1uI/aGDLoYOSawXsXSJPsSy53yPXGhyBZba34QAirQ8AtZL1mvTcOYJ9kQCROiLEVowUvY+7318PZ+ZQKBgQDXodk+uq1s1bBFyFV89+VzNcADUKXm/G5CKr8nOI8IzOhrLBCJvJn3NTW6Uuc9VpJax5NYDs1axiuWedLDPww2cqLXgF419jpru8JaMtEvJzvJeLm6fzrJd/V6g7evGK8rBZX2S8Wy4VjsdhuuP9s5EMjWssGyIyMxXgOQJkmY8wKBgQDdPPrDc+OPdKhnZ8sCMTZjyb2pK5ottiaSTPtn/CX3vVJOX0cvQKrWfBVCfz4eA3yPZQc0V0bPg7ubxzg8o9QmcLvLqX1w9OMMAYcCpqjsp1gR4adkEyk3GRDFQIWZ07jWypGKxH4O3tmsXEpXW3tchF0g6CVlB3usr/GO20ARNQKBgDVKvctADb55LYCBm4cwKRgJL7RiCS6GMqXNtMJ3uvn80nAySsAPyamMEARFmvrQ24juDB9WQTBvC7S71PgGK/mE6XQDOMVzXkrj84uhRYu20ZLgcF6ENT43lIa76PiwTBKA5egiH/EuunBuXDb7dy2qVUiikzZ4cqkvyAenPsc7AoGACWlisZXohF3OHDgKJtm5Gp2md9/m+zLYiTjFKTNM2jEvoy3idVwm6GD29pE7L0OutNrzZ4Ke/Iz6GjJrbgj6KXh6RLu9HmUMk6ItACve29JyqLAU0ukNw85JLFsGU/jx0BFmB6U8R52rXO3AK980bEclPxUhIh8jX8FMYWtqWlECgYAmqhbpSDjtxfASqwpz9pdP/Gza0GnsT4IailOJ3RyNGAkgFY3suS7wiiH4QqnlUWSu1H6WN3UdmuZVKZNoS6K/Q0pp3R5JJ1tyNmetv3xp0wkop+5U67zzqtBLGxCGKuIHjZEMnMklFMI+JBmxXZWdUWcyT/GFq3lrlQ4apCeRjw==";

        String plainText = "플레인 텍스트1";
        System.out.println("평문: " + plainText);

        String encryptedText = encrypt(plainText, publicKey);
        System.out.println("암호화: " + encryptedText);

        String decryptedText = decrypt(encryptedText, privateKey);
        System.out.println("복호화: " + decryptedText);
    }

    /*
     * 암호화 : 공개키로 진행
     */
    public static String encrypt(String plainText, String stringPublicKey) {
        String encryptedText = null;

        try {
            // 평문으로 전달받은 공개키를 사용하기 위해 공개키 객체 생성
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePublicKey = Base64.getDecoder().decode(stringPublicKey.getBytes());
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytePublicKey);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            // 만들어진 공개키 객체로 암호화 설정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
            encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return encryptedText;
    }

    /*
     * 복호화 : 개인키로 진행
     */
    public static String decrypt(String encryptedText, String stringPrivateKey) {
        String decryptedText = null;

        try {
            // 평문으로 전달받은 공개키를 사용하기 위해 공개키 객체 생성
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] bytePrivateKey = Base64.getDecoder().decode(stringPrivateKey.getBytes());
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytePrivateKey);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);

            // 만들어진 공개키 객체로 복호화 설정
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            // 암호문을 평문화하는 과정
            byte[] encryptedBytes =  Base64.getDecoder().decode(encryptedText.getBytes());
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            decryptedText = new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return decryptedText;
    }
}