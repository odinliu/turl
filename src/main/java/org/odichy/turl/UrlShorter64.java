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
package org.odichy.turl;

import java.math.BigInteger;
import org.odichy.turl.util.Digester;

/**
 * This class shorten url based on 64 characters
 *
 * @author <a href="mailto:odinushuaia@gmail.com">LIU YIDING (Odin)</a>
 * @version 1.0
 */
public class UrlShorter64 {
	private char[] base64;
	private String url;
	private String codec;
	private String[] tiny;
	private int index;

	public UrlShorter64(String url) {
		base64 = new char[] {'n', 'o', 'O', 'r', 'X', 'L', 'N', 'v',
		          'J', 'l', 'E', 'T', 'c', '6', 'Z', 'b',
		          '5', '7', 'B', '0', 'e', 'I', 'Q', 'M',
		          'm', 'x', 'Y', 'U', '1', 'G', 'K', 'k',
		          'P', 'j', '9', 'S', 't', 'i', 'w', 'a',
		          's', 'F', 'C', 'D', '3', 'R', 'W', 'y',
		          '4', 'H', '-', 'q', 'g', 'u', 'd', 'h',
		          'p', '_', 'z', 'A', '2', 'V', 'f', '8'};
		this.url = url;
		this.index = 0;
		Digester digester = new Digester();
		this.codec = digester.md5Hex(url);
		this.tiny = new String[2];
		build();
	}

	/**
	 * This method can generate short urls based on the original
	 * urls. This is the main algorithm.
	 */
	private void build() {
		int length = this.codec.length();
		int sublength = length / 16;
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<sublength;i++) {
			String subs = this.codec.substring(i*16, i*16+16);
			BigInteger bi = new BigInteger(subs, 16);
			long temp = 0xfffffffffL & bi.longValue();

			for(int j=0;j<6;j++) {
				long var = 0x3fL & temp;
				BigInteger ltoi = new BigInteger(String.valueOf(var));
				sb.append(this.base64[ltoi.intValue()]);
				temp = temp >> 6;
			}

			tiny[i] = sb.toString();
			sb = new StringBuilder();
		}
	}

	/**
	 * Get the default(the first) short url
	 * @return the first generated url
	 */
	public String getShortenUrl() {
		return this.tiny[0];
	}

	/**
	 * If the first url is repeated, use this method to get the next
	 * @return the next shorten url
	 */
	public String next() {
		this.index = (this.index + 1) % 2;
		return this.tiny[this.index];
	}

	/**
	 * Get the shorten url by index
	 * @param index the index of urls you want to get
	 * @return the proper url
	 */
	public String getShortenUrl(int index) {
		return this.tiny[index%2];
	}
}
