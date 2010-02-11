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
 * A class use to test output
 *
 * @author <a href="mailto:odinushuaia@gmail.com">LIU YIDING(Odin)</a>
 * @version 1.0
 */
public class Main { 
	public static void main(String[] args) {
		String url = "http://odichy.org/";
		if(args.length==1) {
			url = args[0];
		}
		UrlShorter32 shorter = new UrlShorter32(url);
		System.out.println(shorter.getShortenUrl());
		for(int i=0;i<3;i++) {
			System.out.println(shorter.next());
		}

		UrlShorter64 shorter64 = new UrlShorter64(url);
		System.out.println("follow shorten urls is based on 64");
		for(int i=0;i<2;i++) {
			System.out.println(shorter64.getShortenUrl(i));
		}
	}
}
