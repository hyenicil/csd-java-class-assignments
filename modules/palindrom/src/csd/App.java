

package csd;

import javax.print.DocFlavor;

class App {
    public static void main(String[] args) {
        PalindromUtilTest.run();
    }
}

class PalindromUtilTest {
    public static void run () {
        String str = "Ali Papila";
        System.out.println(StringUtil.isPalindrome(str.toLowerCase()));
        System.out.println(str.toLowerCase().substring(0, (str.length() / 2) + 1));
        System.out.println(str.toLowerCase().substring(str.length() / 2));
    }
}

class StringUtil {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (!isLetter(str, left)) {
                ++left;
                continue;
            }
            if (!isLetter(str, right)) {
                --right;
                continue;
            }

            if(str.charAt(left) != str.charAt(right))
                return false;

            --right;
            ++left;
        }

        return true;
    }


    public static Boolean isLetter(String str, int index) {
        return Character.isLetter(str.charAt(index));
    }
}
