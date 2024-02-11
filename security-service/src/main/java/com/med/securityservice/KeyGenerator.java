package com.med.securityservice;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyGenerator {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        byte[] publicKey = keyPair.getPublic().getEncoded();
        byte[] privateKey = keyPair.getPrivate().getEncoded();
        PemWriter publicPemWriter = new PemWriter(new OutputStreamWriter(new FileOutputStream("public.pem")));
        PemObject publicPemObject = new PemObject("PUBLIC KEY", publicKey) ;
        publicPemWriter.writeObject(publicPemObject);
        publicPemWriter.close();
        PemWriter privatePemWriter = new PemWriter(new OutputStreamWriter(new FileOutputStream("private.pem")));
        PemObject privatePemObject = new PemObject("PRIVATE KEY" , privateKey) ;
        privatePemWriter.writeObject(privatePemObject);
        privatePemWriter.close();
    }
}
