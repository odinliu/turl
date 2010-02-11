/*
 * Copyright 2008-2010 Odichy Code Factory<odichy@gmail.com>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.odichy.turl.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * An utility for get digest code
 *
 * @author <a href="mailto:odinushuaia@gmail.com">LIU YIDING(Odin)</a>
 * @version 1.0
 */
public class Digester {
	private MessageDigest md = null;
	public Digester() {
	}

	/**
	 * covert binaries to hex string
	 * @param b binaries
	 * @return a hex string
	 */
	private String byte2hex(byte[] bs) {
		StringBuilder hex = new StringBuilder();
		for(byte b: bs) {
			String temp = Integer.toHexString(b&0xff);
			if(temp.length()==1) {
				hex.append('0');
				hex.append(temp);
			}
			else {
				hex.append(temp);
			}
		}

		return hex.toString().toUpperCase();
	}

	/**
	 * get sha-1 code from message
	 * @param message origin message
	 * @return sha-1 code of message
	 */
	public String shaHex(String message) {
		if(message==null || message.length()==0) {
			return null;
		}

		try {
			md = MessageDigest.getInstance("SHA-1");
		}
		catch(NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}

		md.update(message.getBytes());

		return byte2hex(md.digest());
	}

	/**
	 * get md5 code from message
	 * @param message origin message
	 * @return md5 code of message
	 */
	public String md5Hex(String message) {
		if(message==null || message.length()==0) {
			return null;
		}

		try {
			md = MessageDigest.getInstance("MD5");
		}
		catch(NoSuchAlgorithmException nsae) {
			nsae.printStackTrace();
		}

		md.update(message.getBytes());

		return byte2hex(md.digest());
	}
}
