public class Solution {
    
    public String toWords(int num) {
        if (num == 0) {
            return "";
        }
        String[] ones = new String[]{"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

        StringBuilder sb = new StringBuilder();
        if (num >= 100) {
            sb.append(ones[(num / 100) - 1] + " Hundred");
            num %= 100;
            if (num == 0) {
                return sb.toString();
            }
            sb.append(" ");
        }
        if (num >= 10) {
            if (num >= 10 && num <= 19) {
                String[] tens = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", 
                                    "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
                sb.append(tens[num % 10]);
                return sb.toString();
            } else {
                String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
                sb.append(tens[num / 10 - 2]);
                num %= 10;
                if (num == 0) {
                    return sb.toString();
                }
                sb.append(" ");
            }
        }

        sb.append(ones[num-1]);
        return sb.toString();
    }
    
    public String numberToWords(int num) {
        /*
            123 -> "One Hundred Twenty Three"
            12345 -> "Twelve Thousand Three Hundred Forty Five"
            1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
        */
        
        if (num == 0) {
            return "Zero";
        }
        
        String[] units = new String[]{"", "Thousand", "Million", "Billion", "Trillion"};
        
        List<Integer> results = new ArrayList<Integer>();
        while(num > 0) {
            results.add(num % 1000);
            num /= 1000;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < results.size(); i++) {
            String unit = units[i];
            // 123, 456
            // 456,  123 thousand
            String str = toWords(results.get(i));
            if (str.length() != 0) {
                sb.insert(0, toWords(results.get(i)) + ((units[i].length() == 0 ? "" : " ") + units[i] + " "));
            }
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
