package com.sample;

import com.sample.util.SecurityUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.security.KeyPair;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * Created by crequena on 03/05/2016.
 */
@Log4j2
public class SignatureVerificationIT {


    @Test
    public void A_Signature_VerificationIT() throws Exception {
        log.info("=============================");
        log.info("A_Signature_VerificationIT");
        log.info("=============================");
        KeyPair keyPair = SecurityUtils.generateKeyPair(999);
        //UUID uuid = UUID.randomUUID();
        byte[] data = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74};
        byte[] digitalSignature = SecurityUtils.signData(data, keyPair.getPrivate());
        boolean verified;
        verified = SecurityUtils.verifySignature(data, keyPair.getPublic(), digitalSignature);
        assertTrue("Verified", verified);

        keyPair = SecurityUtils.generateKeyPair(888);
        verified = SecurityUtils.verifySignature(data, keyPair.getPublic(), digitalSignature);
        assertFalse("Not Verified", verified);
    }

    @Test
    public void B_AcessToken_VerificationIT() throws Exception {
        log.info("=============================");
        log.info("B_AcessToken_VerificationIT With KeyPair");
        log.info("=============================");
        UUID apiKey = UUID.randomUUID();
        KeyPair keyPair = SecurityUtils.generateKeyPair(999);
        String accessToken = SecurityUtils.generateAccessToken(keyPair.getPrivate(), apiKey.toString());
        log.info("ACCESS TOKEN: {}", accessToken);
        log.info("API KEY: {}", apiKey);
        log.info("PRIVATE KEY: {}", keyPair.getPrivate());
        boolean verified = SecurityUtils.verifyAccessToken(accessToken, apiKey.toString(), keyPair.getPrivate());
        assertTrue("Verified", verified);
        keyPair = SecurityUtils.generateKeyPair(888);
        verified = SecurityUtils.verifyAccessToken(accessToken, apiKey.toString(), keyPair.getPrivate());
        assertFalse("Not Verified", verified);
    }

    @Test
    public void C_AcessToken_VerificationIT() throws Exception {
        log.info("=============================");
        log.info("B_AcessToken_VerificationIT Without KeyPair");
        log.info("=============================");
        UUID apiKey = UUID.randomUUID();
        UUID privateKey = UUID.randomUUID();
        String accessToken = SecurityUtils.generateAccessToken(privateKey.toString(), apiKey.toString());
        log.info("ACCESS TOKEN: {}", accessToken);
        log.info("API KEY: {}", apiKey);
        log.info("PRIVATE KEY: {}", privateKey);

        boolean verified = SecurityUtils.verifyAccessToken(accessToken, apiKey.toString(), privateKey.toString());
        assertTrue("Verified", verified);
        privateKey = UUID.randomUUID();
        verified = SecurityUtils.verifyAccessToken(accessToken, apiKey.toString(), privateKey.toString());
        assertFalse("Not Verified", verified);

    }

    @Test
    public void D_Signature_VerificationIT() throws Exception {
        log.info("=============================");
        log.info("D_Signature_VerificationIT");
        log.info("=============================");
        UUID apiKey = UUID.randomUUID();
        KeyPair keyPair = SecurityUtils.generateKeyPair(999);
        String accessToken = SecurityUtils.generateAccessToken(keyPair.getPrivate(), apiKey.toString());
        String signature = SecurityUtils.generateSignature(accessToken, apiKey.toString());

        log.info("ACCESS TOKEN: {}", accessToken);
        log.info("API KEY: {}", apiKey.toString());
        log.info("SIGNATURE: {}", signature);

        boolean verified = SecurityUtils.verifySignature(accessToken, apiKey.toString(), signature);
        assertTrue("Verified", verified);

        keyPair = SecurityUtils.generateKeyPair(888);
        accessToken = SecurityUtils.generateAccessToken(keyPair.getPrivate(), apiKey.toString());
        verified = SecurityUtils.verifySignature(accessToken, apiKey.toString(), signature);
        assertFalse("Not Verified", verified);

    }

    @Test
    public void E_Signature_VerificationIT() throws Exception {
        log.info("=============================");
        log.info("E_Signature_VerificationIT");
        log.info("=============================");
        String apiKey = "bacb3r2vtucwbyugywtvh89u";
        KeyPair keyPair = SecurityUtils.generateKeyPair(999);
        String accessToken = SecurityUtils.generateAccessToken(keyPair.getPrivate(), apiKey);
        String signature = SecurityUtils.generateSignature(accessToken, apiKey.toString());
        boolean  verified = SecurityUtils.verifySignature(accessToken, apiKey, signature);
        assertTrue("Verified", verified);

        keyPair = SecurityUtils.generateKeyPair(888);
        accessToken = SecurityUtils.generateAccessToken(keyPair.getPrivate(), apiKey);
        verified = SecurityUtils.verifySignature(accessToken, apiKey, signature);
        assertFalse("Not Verified", verified);

    }
}
