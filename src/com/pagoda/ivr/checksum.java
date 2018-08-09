package com.pagoda.ivr;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class checksum {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String encode(String appSecret, String nonce, String time) {
        String content = appSecret + nonce + time;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            messageDigest.update(content.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

	public static String MD5encryption(String plain) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plain.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return re_md5;
	}

	public static String AESencrypt(String content, String encryptKey) {
		//只在订单绩效接口中使用
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.setSeed(encryptKey.getBytes());
			kgen.init(128, random);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));
			return byteArr2HexStr(cipher.doFinal(content.getBytes("utf-8")));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String byteArr2HexStr(byte[] b) {
		int length = b.length;
		StringBuffer sb = new StringBuffer(length * 2);
		for (int i = 0; i < length; i++) {
			int temp = b[i];
			while (temp < 0) {
				temp = temp + 256;
			}
			if (temp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(temp, 16));
		}
		return sb.toString();
	}
	
	

	public static void main(String[] args) {
		String content = "{\"eventType\":1,\"name\":\"意向客户回访\",\"description\":\"新注册用户回访\",\"timeModel\":0,\"eventTime\":1517722346089,\"occasionType\":1,\"relativeStartTime\":10,\"relativeEndTime\":1440,\"seatType\":0,\"seatIds\":\"40004,40005\",\"customerInfo\":[{\"name\":\"阿波罗\",\"value\":\"18957128912\"},{\"name\":\"小喽喽\",\"value\":\"15411660066\"}]}";
		String encryptKey = "APPSECRET";
		String a = AESencrypt(content, encryptKey);
		System.out.println("acs:" + a);
		String nonce = MD5encryption(content);
		System.out.println("MD5:" + nonce);
		String time = Long.toString(Calendar.getInstance().getTimeInMillis() / 1000);
		String b = encode(encryptKey, nonce, time);
		System.out.println("time:" + time);
		System.out.println("checksum:" + b);
	}
}
