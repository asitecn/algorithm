public class Solution {
    public String largestNumber(int[] nums) {
        // For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
        if (nums.length == 0) {
            return "";
        }        

        List<String> list = new ArrayList<String>();
        for(int i = 0; i < nums.length; i++) {
            list.add("" + nums[i]);
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });

                
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < list.size() && "0".equals(list.get(i))) {
            i++;
        }
        for(; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        String output = sb.toString();
        return (output.length() == 0 ? "0" : output);
    }
}
