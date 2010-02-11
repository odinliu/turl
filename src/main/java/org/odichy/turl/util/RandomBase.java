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

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class produce random base
 *
 * @author <a href="mailto:odinushuaia@gmail.com">LIU YIDING (Odin)</a>
 * @version 1.0
 */
public class RandomBase {
	private static char[] base64 = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
		          'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
		          'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
		          'y', 'z', '0', '1', '2', '3', '4', '5',
		          '6', '7', '8', '9', 'A', 'B', 'C', 'D',
		          'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
		          'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
		          'U', 'V', 'W', 'X', 'Y', 'Z', '_', '-'};
	private static char[] base32 = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
		          'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
		          'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
		          'y', 'z', '2', '3', '4', '5', '6', '7'};

	public static void main(String[] args) {
		List<Character> temp32List = new ArrayList<Character>();
		List<Character> temp64List = new ArrayList<Character>();
		List<Character> baseList = fromArrayToList(base32);
		Random rand = new Random(System.currentTimeMillis());
		int size = baseList.size();
		while(size!=0) {
			temp32List.add(baseList.remove(rand.nextInt(0x7fffffff)%size));
			size = baseList.size();
		}

		baseList = fromArrayToList(base64);
		rand = new Random(System.currentTimeMillis());
		size = baseList.size();
		while(size!=0) {
			temp64List.add(baseList.remove(rand.nextInt(0x7fffffff)%size));
			size = baseList.size();
		}

		System.out.println(output(32, temp32List));
		System.out.println(output(64, temp64List));
	}

	private static String output(int base, List<Character> list) {
		StringBuilder sb = new StringBuilder();
		sb.append("base");
		sb.append(base);
		sb.append(" = new char[] {\'");
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i).charValue());
			if(i==list.size()-1) {
				sb.append("\'};");
			}
			else if(i%8==7) {
				sb.append("\',\n          \'");
			}
			else {
				sb.append("\', \'");
			}
		}

		return sb.toString();
	}

	private static LinkedList<Character> fromArrayToList(char[] array) {
		LinkedList<Character> list = new LinkedList<Character>();
		for(char c: array) {
			list.add(c);
		}
		return list;
	}
}
