package com.sample.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import java.security.*;

/**
 * Created by crequena on 27/04/2016.
 */
public class SignatureUtil {


    public static void main(String arg[]) {


        try {
            String apiKey = "bacb3r2vtucwbyugywtvh89u";

            // initialize key generator
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            keyGen.initialize(512, random);

            // generate a keypair
            KeyPair pair = keyGen.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();
            final String privateKeyEncode = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
            final String publicKeyEncode = Base64.encodeBase64URLSafeString(publicKey.getEncoded());

            System.out.println("Private Key: " + privateKeyEncode);
            System.out.println("Public Key: " + publicKeyEncode);
            System.out.println("API Key: " + apiKey);

            // generate token
            String accessToken = Jwts.builder().setSubject(privateKeyEncode).signWith(SignatureAlgorithm.HS256, apiKey).compact();
            System.out.println("TOKEN: " + accessToken);
            String signature = DigestUtils.sha256Hex(apiKey + accessToken + System.currentTimeMillis() / 1000);

            //generate signature
            System.out.println("SIGNATURE: " + signature);
            DigestUtils.getSha256Digest();

            if (Jwts.parser().setSigningKey(apiKey).parseClaimsJws(accessToken).getBody().getSubject().equals(privateKeyEncode)) {
                System.out.println("Private Key Correct: " + Jwts.parser().setSigningKey(apiKey).parseClaimsJws(accessToken).getBody().getSubject());
            } else {
                System.out.println("Private Key Incorrect: ");
            }

            String signature2 = DigestUtils.sha256Hex(apiKey + accessToken + System.currentTimeMillis() / 1000);

            if (signature.equals(signature2)){
                System.out.println("Signature Correct " + signature2);
            }else{
                System.out.println("Signature  No Correct ");
            }

            String signatureApitude = DigestUtils.sha256Hex("bacb3r2vtucwbyugywtvh89u" + "vUxEZvXUJB" + System.currentTimeMillis() / 1000);
            System.out.println("SIgnature APITUDE " + signatureApitude);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
