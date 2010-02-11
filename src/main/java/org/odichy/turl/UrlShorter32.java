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

import org.apache.commons.codec.digest.DigestUtils;

/**
 * This class shorten url based on 32 characters
 *
 * @author <a href="mailto:odinushuaia@gmail.com">LIU YIDING (Odin)</a>
 * @version 1.0
 */
public class UrlShorter32 {
	private char[] base32;
	private String url;
	private String sha1;
	private String[4] tiny;
	private int index;

	public UrlShorter32(String url) {
		base32 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
		          'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
		          'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
		          'y', 'z', '2', '3', '4', '5', '6', '7'};
		this.url = url;
		this.sha1 = DigestUtils.shaHex(url);
		this,index = 0;
		build();
	}

	/**
	 * This method can generate short urls based on the original
	 * urls. This is the main algorithm.
	 */
	private void build() {
		int length = this.sha1.length();
		int sublength = length / 8;
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<sublength;i++) {
			String subs = this.sha1.substring(i*8, 8);
			int temp = 0x3fffffff & Integer.parseInt(subs, 16);

			for(int j=0;j<6;j++) {
				int var = 0x1f & temp;
				sb.append(this.base32[var]);
				temp = temp >> 5;
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
		this.index = (this.index + 1) % 4;
		return this.tiny[this.index];
	}

	/**
	 * Get the shorten url by index
	 * @param index the index of urls you want to get
	 * @return the proper url
	 */
	public String getShortenUrl(int index) {
		return this.tiny[index%4];
	}
}
