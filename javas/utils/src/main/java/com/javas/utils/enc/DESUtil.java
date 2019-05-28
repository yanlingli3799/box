package com.javas.utils.enc;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DESUtil {

  private static final String CHARSET = "UTF8";
  private static final String DES = "DES";

  private static String EncryptDecryptKEY = "liyanlingenc";

  public static String encrypt(String str) throws Exception {
    // com.javas.utils.string to bytes
    byte[] strBytes = str.getBytes(CHARSET);

    DESKeySpec dks = new DESKeySpec(EncryptDecryptKEY.getBytes());
    SecretKeyFactory skf = SecretKeyFactory.getInstance(DES);
    SecretKey desKey = skf.generateSecret(dks);
    Cipher ecipher = Cipher.getInstance(DES);
    ecipher.init(Cipher.ENCRYPT_MODE, desKey);

    // encrypt
    byte[] enc = ecipher.doFinal(strBytes);

    // encode
    return new sun.misc.BASE64Encoder().encode(enc);
  }

  public static String decrypt(String str) throws Exception {
    DESKeySpec dks = new DESKeySpec(EncryptDecryptKEY.getBytes());
    SecretKeyFactory skf = SecretKeyFactory.getInstance(DES);
    SecretKey desKey = skf.generateSecret(dks);
    Cipher dcipher = Cipher.getInstance(DES);
    dcipher.init(Cipher.DECRYPT_MODE, desKey);
    // decode
    byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
    // decrypt
    byte[] strBytes = dcipher.doFinal(dec);

    // bytes to com.javas.utils.string
    return new String(strBytes, CHARSET);
  }


}
