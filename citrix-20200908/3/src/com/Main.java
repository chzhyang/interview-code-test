import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

	/*
	 * Complete the 'countSentences' function below.
	 *
	 * The function is expected to return a LONG_INTEGER_ARRAY.
	 * The function accepts following parameters:
	 *  1. STRING_ARRAY wordSet
	 *  2. STRING_ARRAY sentences
	 */

	public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
		// Write your code here
		HashMap<String, List<String>> map = countAnagrams(wordSet);//anagram map , key is one word (unique)
		HashMap<String, Long> countMap = new HashMap<>();
		//count anagrams of all words 遍历map，把anagrams中所有word机器anagrams个数放入count map
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			String mapKey = entry.getKey();
			List<String> mapValue = entry.getValue();
			long cnt = (long)mapValue.size()+1;
			countMap.put(mapKey, cnt);
			for(String s : mapValue){
				countMap.put(s, cnt);
			}
		}
		//每个句子中的所有word，通过count map获取其anagrams个数，每个句子的result就是所有word的anagrams 的个数的乘积
		List<Long> results = new ArrayList<>();
		for(String s : sentences){
			long result = 1;
			String[] str = s.split(" ");
			for(int i=0; i<str.length; i++){
				if(countMap.containsKey(str[i])){//find word who has anagrams
					long cnt = countMap.get(str[i]);
					result = result * cnt;
				}
			}
			results.add(result);
		}
		return results;
	}

	/**
	 * 判断两个string是不是anagram
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean anagram(String s1, String s2){
		// converting strings to char arrays
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();

		// sorting both char arrays
		Arrays.sort(ch1);
		Arrays.sort(ch2);

		// Check for equality of strings
		if (Arrays.equals(ch1, ch2))
			return true;
		else
			return false;
	}

	/**
	 * 遍历word set，把anagrams放入map，key是这几个中第一个出现的word
	 * @param wordSet
	 * @return
	 */
	public static HashMap<String, List<String>> countAnagrams(List<String> wordSet){
		HashMap<String, List<String>> map = new HashMap<>();
		HashSet<String> visited = new HashSet<>();
		for(int i=0; i<wordSet.size();i++){
			if(!visited.contains(wordSet.get(i))){
				visited.add(wordSet.get(i));
				List<String> list = new ArrayList<>();//anagrams
				for(int j=i+1; j<wordSet.size();j++){
					if(!visited.contains(wordSet.get(j)) && anagram(wordSet.get(i), wordSet.get(j))){
						visited.add(wordSet.get(j));
						list.add(wordSet.get(j));
					}
				}
				if(list!=null){
					map.put(wordSet.get(i), list);
				}
			}
		}
		return map;
	}
}

public class Solution {

}