public class Version {
    public static int compareVersion(String version1, String version2) {
        // 0.1 < 1.1 < 1.2 < 13.37
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        System.out.println(v1.length);
        System.out.println(v2.length);
        int i = 0;
        for (;i < v1.length && i < v2.length;i++) {
            Integer iv1 = Integer.parseInt(v1[i]);
            Integer iv2 = Integer.parseInt(v2[i]);
            if (iv1 < iv2) {
                return -1;
            } else if (iv1 > iv2) {
                return 1;
            }
        }
        for(;i < v1.length;i++) {
            if (Integer.parseInt(v1[i]) > 0) {
                return 1;
            }
        }
        for(;i < v2.length;i++) {
            if (Integer.parseInt(v2[i]) > 0) {
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Version.compareVersion("1", "0"));
    }
}
