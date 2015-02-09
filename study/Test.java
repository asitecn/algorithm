import java.util.ArrayList;
import java.util.List;

public class Test {

	// 1, 2
	// 3, 4, 5
	// 6, 7
	// 2*3*2=12
	
	// 136, 137, 146, 147, 156, 157
	// 236, 237, 246, 247, 256, 257
	// (100+200)*6 + (30+40+50)*4 + (6+7)*6
	// find product of all others not including itself

	public static int cal(List<List<Integer>> lists) {
		int prod_total = 1;
		for(int i = 0; i < lists.size(); i++) {
			prod_total *= lists.get(i).size();
		}
		//int[] prod = new int[lists.size()];
		//int[] sum = new int[lists.size()];
		int total = 0;
		int tens = 1;
		for(int i = lists.size()-1; i >= 0; i--) {
			int sum = 0;
			for(int j = 0; j < lists.get(i).size(); j++) {
				sum += lists.get(i).get(j);
			}
			total += sum*tens * (prod_total / lists.get(i).size());
			System.out.println(i + "\t" + sum + "\t" + tens);
			tens *= 10;
		}
		return total;
	}

	public static void main(String args[]) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		{ list.add(1); list.add(2); lists.add(list); }
		{ list1.add(3); list1.add(4); list1.add(5); lists.add(list1); }
		{ list2.add(6); list2.add(7); lists.add(list2); }
		int val = Test.cal(lists);
		System.out.println(val);
	}
}
