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

/**
 * This class shorten url based on 32 characters
 *
 * @author <a href="mailto:odinushuaia@gmail.com">LIU YIDING(Odin)</a>
 * @version 1.0
 */
public class UrlShorter32 {
	private char[] base32;
	private String url;

	public UrlShorter32(String url) {
		base32 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
		          'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
		          'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
		          'y', 'z', '2', '3', '4', '5', '6', '7'};
		this.url = url;
	}
}
