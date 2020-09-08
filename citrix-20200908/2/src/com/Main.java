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
	 * Complete the 'countDuplicate' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts INTEGER_ARRAY numbers as parameter.
	 */

	public static int countDuplicate(List<Integer> numbers) {
		// creat two set, 1 is for all elements and the other is for duplicate elem.
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> duplicateSet =new HashSet<>();

		for(int i:numbers){
			if(set.contains(i)){
				duplicateSet.add(i);
			}else{
				set.add(i);
			}
		}
		return duplicateSet.size();
	}

}
public class Solution {}