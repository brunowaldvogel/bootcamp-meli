package Aula2TM.Exercicio6;

public class Main {
    public static void main(String[] args) {
        String[] str = {
            "Oi!",
            "     Oi!",
            "Oi!     ",
            "     Oi!     ",
            "John|Paul|George|Ringo",
        };

        String leftPadded = StringUtil.lpad(str[0], 'c', 3);
        System.out.println("Left padded: " + leftPadded);

        String rightPadded = StringUtil.rpad(str[0], 'c', 3);
        System.out.println("Right padded: " + rightPadded);

        String leftTrimmed = StringUtil.ltrim(str[1]);
        System.out.println("Left trimmed: " + leftTrimmed);

        String rightTrimmed = StringUtil.rtrim(str[2]);
        System.out.println("Right trimmed: " + rightTrimmed);

        String trimmed = StringUtil.trim(str[3]);
        System.out.println("Trimmed both sides: " + trimmed);

        int index = StringUtil.indexOfN(str[4], '|', 2);
        System.out.println("Index: " + index);
    }
}
