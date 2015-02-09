public class Solution2 {
    // 3, 1, 3, 1           n => n/2, n => 2*n+1
    // 5, 3, 1, 3, 5        n => n/2, n => 2*n+1
    // 4, 2, 4, 2           n => n/2, n => 2*n
    public static String convert(String s, int nRows) {
	if (nRows == 1 || nRows == 2) {
		return s;
	}
        String[] rows = new String[nRows];
	for(int j = 0; j < rows.length; j++) {
		rows[j] = "";
	}
        int i = 0;
	int zigStart = 0;
	int zigEnd = nRows-1;
        boolean bIncrease = false;
        while(i < s.length()) {
            for(int j = zigStart; j <= zigEnd; j++) {
                if (i == s.length()) {
                    break;
                } else {
                    rows[j] += s.charAt(i++);
                }
            }
            if (!bIncrease) {
		zigStart++;
		zigEnd--;
		if (zigEnd - zigStart <= 1) {
			bIncrease = true;
		}
            } else {
		zigStart--;
		zigEnd++;
		if (zigStart == 0) {
			bIncrease = false;
		}
            }
        }
        String result = "";
        for(int j = 0; j < nRows; j++) {
		result += rows[j];
	}
        return result;
    }

	public static void main(String args[]) {
		String s = "ABCDE";
		String result = convert(s, 4);
		System.out.println(result);		
	}
}

