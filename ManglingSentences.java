/**
 *
 * @author __MadHatter (alias used on https://www.reddit.com/r/dailyprogrammer)
 *
 * Edited: 2015-06-25
 *
 */

/* ManglingSentences.java */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ManglingSentences {

    public static void main(String[] args) {
        int index;
        Character c;
        Scanner in = new Scanner(System.in);
        String line;
        StringBuilder output = new StringBuilder();
        StringBuilder input;
        StringTokenizer stringTokenizer;
        ArrayList<Integer> listOfCapitals;

        line = in.nextLine();
        listOfCapitals = getListOfCapitals(line);

        stringTokenizer = new StringTokenizer(line);
        while (stringTokenizer.hasMoreElements()) {
            input = new StringBuilder(stringTokenizer.nextToken());
            output.append(sortWord(input));
            output.append(" ");
        }

        for (int i = 0; i < listOfCapitals.size(); i++) {
            index = listOfCapitals.get(i);
            c = Character.toUpperCase(output.charAt(index));
            output.setCharAt(index, c);
        }

        System.out.println(output.toString());
    }

    public static ArrayList<Integer> getListOfCapitals(String s) {
        ArrayList<Integer> listOfCapitals = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                listOfCapitals.add(i);
            }
        }
        return listOfCapitals;
    }

    public static String sortWord(StringBuilder word) {
        int i;
        int j;
        char tmpA;
        char tmpB;
        for (i = 1; i < word.length(); i++) {
            j = i;
            while (j > 0) {
                tmpA = Character.toLowerCase(word.charAt(j));
                tmpB = Character.toLowerCase(word.charAt(j-1));
                if (tmpB < tmpA || !isLetterOrDigit(tmpA) || !isLetterOrDigit(tmpB)) {
                    break;
                }
                word.setCharAt(j, tmpB);
                word.setCharAt(j-1, tmpA);
                j -= 1;
            }
        }
        return word.toString();
    }

    public static boolean isLetterOrDigit(Character c) {
        return (c >= 'a' && c <= 'z'
                || c >= 'A' && c <= 'Z'
                || c >= '0' && c <= '9');
    }

}
