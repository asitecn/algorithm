public class Digits {
    public boolean isNumber(String s) {

    // "0" => true
    // ".1" => true
    // " 0.1 " => true
    // "abc" => false
    // "1 a" => false
    // "2e10" => true
    // "01" => true
        
        if (s == null) {
            return false;
        }
        int idx = 0;
        while(idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }
        if (idx == s.length()) {
            return false;
        }

        boolean wDigits = false;
        boolean wSign = false;
        if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
            if (idx == s.length()-1) {
                return false;
            } else {
                if (s.charAt(idx+1) < '0' || s.charAt(idx+1) > '9') {
                    if (s.charAt(idx+1) != '.') {
                        return false;
                    }
                }
            }
            wSign = true;
            idx++;
        }
        while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
            wDigits = true;
            idx++;
        }
        if (idx == s.length()) {
            return true;
        }
        
        if (s.charAt(idx) == '.') {
            if (idx == s.length()-1) {
                // -. is not right
                // -3. is fine
                // -.3 is fine
                return wDigits;
            } else {
                char next = s.charAt(idx+1);
                if ((next < '0' || next > '9')) {
                    if (next == 'e') {
                    } else if (!(next == ' ' && (wDigits || wSign))) {
                        return false;
                    }
                }
            }
            idx++;
            while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                wDigits = true;
                idx++;
            }   
        }
        if (idx == s.length()) {
            return true;
        }
        if (s.charAt(idx) == 'e') {
            if (idx == s.length()-1) {
                return false;
            } else {
                System.out.println("here2");
                if (!wDigits && !wSign) {
                System.out.println("here3");
                    return false;
                }
                if (s.charAt(idx+1) == '+' || s.charAt(idx+1) == '-') {
                    idx++;
                    if (idx == s.length()-1) {
                        return false;
                    }
                }
                if (s.charAt(idx+1) < '0' || s.charAt(idx+1) > '9') {
                System.out.println("here4");
                    return false;
                } 

                idx++;
                while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                  idx++;
                }
            }
            if (idx == s.length()) {
                return true;
            }
            if (s.charAt(idx) == '0') {
                if (idx == s.length()-1) {
                    return true;
                } else {
                    if (s.charAt(idx+1) != ' ') {
                System.out.println("here4");
                        return false;
                    }
                }
            }
            //idx++;
        }

        
        if (idx == s.length()) {
            System.out.println("there1");
            return true;
        }
        
        if (s.charAt(idx) == ' ') {
            while(idx < s.length() && s.charAt(idx) == ' ') {
                idx++;
            }
            if (idx == s.length()) {
                System.out.println("there2");
                return true;
            } else {
                System.out.println("here5");
                return false;
            }
        } else {
                System.out.println("here6" + "\t" + s.charAt(idx));
            return false;
        }
    }

    public static void main(String args[]) {
        Digits d = new Digits();
        System.out.println(d.isNumber(" 4e+.3"));
    }
}
