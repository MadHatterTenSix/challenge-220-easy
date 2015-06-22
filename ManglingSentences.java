/**
 *
 * @author __MadHatter (alias used on https://www.reddit.com/r/dailyprogrammer)
 */

/* ManglingSentences.java */

import java.util.Scanner;
import java.util.StringTokenizer;

public class ManglingSentences {
    public static void main(String[] args) {
        Scanner in;
        String line;
        StringBuilder output;
        StringBuilder input;
        StringTokenizer stringTokenizer;

        in = new Scanner(System.in);
        line = in.nextLine();

        output = new StringBuilder();
        stringTokenizer = new StringTokenizer(line);
        while (stringTokenizer.hasMoreElements()) {
            input = new StringBuilder(stringTokenizer.nextToken());
            output.append(sortWord(input));
            output.append(" ");
        }

        System.out.println(output.toString());
    }

    public static String sortWord(StringBuilder word) {
        int i;
        int j;
        boolean isCapitalized;
        char tmpA;
        char tmpB;

        isCapitalized = Character.isUpperCase(word.charAt(0));

        for (i = 1; i < word.length();i++) {
            j = i;
            while (j > 0) {
                tmpA = Character.toLowerCase(word.charAt(j));
                tmpB = Character.toLowerCase(word.charAt(j-1));
                if (tmpB < tmpA || !Character.isAlphabetic(tmpA)) {
                    break;
                }
                word.setCharAt(j, tmpB);
                word.setCharAt(j-1, tmpA);
                j -= 1;
            }
        }

        if (isCapitalized) {
            word.setCharAt(0, Character.toUpperCase(word.charAt(0)));
        }

        return word.toString();
    }
    
}
