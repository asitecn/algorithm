public class TwoSum {

    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    map.put(number, map.containsKey(number) ? 2 : 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Map.Entry<Integer, Integer> me : map.entrySet()) {
	        int target = value - me.getKey();
            if (target == me.getKey()) {
                if (me.getValue() == 2) {
                    return true;
                }
            } else if (map.containsKey(target)) {
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
