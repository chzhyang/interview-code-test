import java.util.*;


public class Solution {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 * 对输入集合做hash join，输出关联后的下标的二元组集合
	 * @param setA int整型ArrayList 输入集合1
	 * @param setB int整型ArrayList 输入集合2
	 * @return int整型ArrayList<ArrayList<>>
	 */
	public ArrayList<ArrayList<Integer>> hashJoin (ArrayList<Integer> setA, ArrayList<Integer> setB) {
		// write code here
		if(setA==null||setB==null){
			return null;
		}
		//短数组放入hashmap
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> hashB = new ArrayList<>();
		if(setA.size()>=setB.size()){
			A = setA;
			hashB = setB;
		}else{
			A = setB;
			hashB = setA;
		}
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int i=0; i<hashB.size(); i++){
			if(!map.containsKey(hashB.get(i))){
				ArrayList<Integer> list =new ArrayList<>();
				list.add(i);
				map.put(hashB.get(i), list);
			}else{
				ArrayList<Integer> list = map.get(hashB.get(i));
				list.add(i);
			}
		}

		//遍历长数组
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		for(int j=0; j<A.size(); j++){
			int t = A.get(j);
			if(map.containsKey(t)){
				ArrayList<Integer> tList = new ArrayList<>();
				tList.add(j);
				ArrayList<Integer> l = map.get(t);
				tList.add(l.get(0));
				l.remove(0);
				if(l.isEmpty()){
					map.remove(t);
				}
				result.add(tList);
			}
		}

		return result;
	}
}