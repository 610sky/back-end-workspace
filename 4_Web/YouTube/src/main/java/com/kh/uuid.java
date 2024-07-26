package com.kh;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class uuid {
	
	void createShortUuid() {
		for(int i=0;i<10;i++) {
			String uuidString = UUID.randomUUID().toString();
			System.out.print(uuidString + " -> ");
			byte[] uuidStringBytes = uuidString.getBytes(StandardCharsets.UTF_8);
			byte[] hashBytes;
			
			try {
				MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
				hashBytes=messageDigest.digest(uuidStringBytes);
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException(e);
			}
			
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<4; j++) {
				sb.append(String.format("%02x", hashBytes[j]));
			}
			System.out.println(sb.toString());
		}
	}
	public static void main(String[] args) {
		uuid u = new uuid();
		u.createShortUuid();
	}

}
