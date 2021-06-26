// Author: Bruno Waldvogel
// Exercise: Exercicio 6

package Aula2TM.Exercicio6;

import java.util.regex.Pattern;

public class StringUtil {
    public static String rpad(String s, char c, int n) {
        return s + String.valueOf(c).repeat(n);
    }

    public static String lpad(String s, char c, int n) {
        return String.valueOf(c).repeat(n) + s;
    }

    public static String ltrim(String s) {
        return Pattern.compile("^\\s*").matcher(s).replaceAll("");
    }

    public static String rtrim(String s) {
        return Pattern.compile("\\s*$").matcher(s).replaceAll("");
    }

    public static String trim(String s) {
        s = ltrim(s);
        return rtrim(s);
    }

    public static int indexOfN(String s, char c, int n) {
        if (s.indexOf(c) == -1)
            return -1;

        int countOccurrence = 0;
        char[] charArray = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (charArray[i] == c)
                countOccurrence++;

            if (countOccurrence == n)
                return i;
        }

        return -1;
    }
}
