public class SearchString {

    // Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
    // Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1

    public int search(String[] strings, String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        int s = 0, e = strings.length-1;
        while(s < e) {
            int mid = s + (e-s)/2;
            if (strings[mid].length() > 0) {
                if (str.equals(strings[mid])) {
                    return mid;
                } else if (strings[mid].compareTo(str) < 0) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                int next = mid;
                while(strings[next].length() == 0 && next <= e) {
                    next++;
                }
                if (next == e+1) {
                    e = mid-1;
                } else {
                   if (str.equals(strings[next])) {
                        return next;
                    } else if (strings[next].compareTo(str) < 0) {
                        s = next + 1;
                    } else {
                        e = next - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        SearchString s = new SearchString();
        String[] strings = {"at", "", "", "", "ball", "car", "", "", "dad", "", ""};
        String str = "car";
        System.out.println(s.search(strings, str));
    }
}
