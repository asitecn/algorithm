public class Solution {

    // 0.1 < 1.1 < 1.2 < 13.37
        
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for(; i < v1.length && i < v2.length; i++) {
            Integer n1 = Integer.parseInt(v1[i]);
            Integer n2 = Integer.parseInt(v2[i]);
            if (n1 < n2) {
                return -1;
            } 
            if (n1 > n2) {
                return 1;
            }
        }
        //System.out.println(i + "\t" + v1.length + "\t" + v2.length);
        while (i < v1.length) {
            if (Integer.parseInt(v1[i++]) != 0) {
                return 1;
            }
        }
        while (i < v2.length) {
            if (Integer.parseInt(v2[i++]) != 0) {
                return -1;
            }
        }
        return 0;
    }
}
