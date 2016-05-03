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
public class SecurityUtils {

    public static final String APIKEY_HEADER = "apiKey";
    public static final String TIMESTAMP_HEADER = "timestamp";
    public static final String SIGNATURE_HEADER = "signature";
    public static final String ACCESS_TOKEN_HEADER = "accessToken";

    public static KeyPair generateKeyPair(long seed) throws Exception {
        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("DSA");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
        secureRandom.setSeed(seed);
        keyGenerator.initialize(1024, secureRandom);
        return (keyGenerator.generateKeyPair());
    }

    public static byte[] signData(byte[] data, PrivateKey key) throws Exception {
        Signature signer = Signature.getInstance("SHA1withDSA");
        signer.initSign(key);
        signer.update(data);
        return (signer.sign());
    }

    public static String generateAccessToken(PrivateKey privateKey, String apiKey) {
        final String privateKeyEncode = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        String accessToken = Jwts.builder().setSubject(privateKeyEncode).signWith(SignatureAlgorithm.HS256, apiKey).compact();
        return accessToken;
    }

    public static String generateAccessToken(String privateKey, String apiKey) {
        final String privateKeyEncode = Base64.encodeBase64URLSafeString(privateKey.getBytes());
        String accessToken = Jwts.builder().setSubject(privateKeyEncode).signWith(SignatureAlgorithm.HS256, apiKey).compact();
        return accessToken;
    }

    public static String generateSignature(String accessToken, String apiKey) {
        return DigestUtils.sha256Hex(apiKey + accessToken + System.currentTimeMillis() / 1000);
    }

    public static boolean verifySignature(byte[] data, PublicKey publicKey, byte[] signature) throws Exception {
        Signature signer = Signature.getInstance("SHA1withDSA");
        signer.initVerify(publicKey);
        signer.update(data);
        return (signer.verify(signature));
    }

    public static Boolean verifySignature(String accessToken,String apiKey, String signature) {
        return generateSignature(accessToken,apiKey).equals(signature);
    }

    public static Boolean verifyAccessToken(String accessToken,String apiKey,  PrivateKey privateKey) {
        final String privateKeyEncode = Base64.encodeBase64URLSafeString(privateKey.getEncoded());
        return  Jwts.parser().setSigningKey(apiKey).parseClaimsJws(accessToken).getBody().getSubject().equals(privateKeyEncode);
    }

    public static Boolean verifyAccessToken(String accessToken,String apiKey,  String privateKey) {
        final String privateKeyEncode = Base64.encodeBase64URLSafeString(privateKey.getBytes());
        return  Jwts.parser().setSigningKey(apiKey).parseClaimsJws(accessToken).getBody().getSubject().equals(privateKeyEncode);
    }
}
