/**
* Given two words as Strings, determine if they are isomorphic. Two words are called isomorphic
* if the letters in one word can be remapped to get the second word. Remapping a letter means replacing all
* occurrences of it with another letter while the ordering of the letters remains unchanged. No two letters
* may map to the same letter, but a letter may map to itself.
*
* Example:
* given “foo”, “app”; returns true
* we can map ‘f’ -> ‘a’ and ‘o’ -> ‘p’
*
* given “foo”, “boa”; returns false
* we can map ‘f’ -> ‘b’, ‘o’ -> ‘o’, we can’t map ‘o’ -> ‘a’
*
* given “bar”, “foo”; returns false
* we can’t map both ‘a’ and ‘r’ to ‘o’
*
* given “turtle”, “tletur”; returns true
* we can map ‘t’ -> ‘t’, ‘u’ -> ‘l’, ‘r’ -> ‘e’, ‘l’ -> ‘u’, ‘e’ ->’r’
*
* given “ab”, “ca”; returns true
* we can map ‘a’ -> ‘c’, ‘b’ -> ‘a’
*/

import java.util.*;
public class Isomorphic {
    
    public boolean isMorphic(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (map.get(c1) != null) {
                c1 = map.get(c1);
                if (c1 != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public void process(String s1, String s2) {
        System.out.println(s1 + "\t" + s2 + "\t" + isMorphic(s1, s2));
    }

    public static void main(String args[]) {
        Isomorphic is = new Isomorphic();
        is.process("foo", "app");
        is.process("foo", "boa");
        is.process("turtle", "tletur");
        is.process("ab", "ca");
    }

}
