import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Pavel Pavlov on 2/7/2017.
 */
public class MostCommonLetter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter some text: ");
        String input = sc.nextLine();
        input = input.toLowerCase();

        HashMap<Character, Integer> charMap = new HashMap();

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);
            if (Character.isAlphabetic(letter)) {
                if (charMap.containsKey(letter)) {
                    int counter = charMap.get(letter);
                    counter++;
                    charMap.put(letter, counter);
                } else {
                    charMap.put(letter, 1);
                }
            }
        }

        TreeSet<ValueCompare> sortedByValue = new TreeSet();

        for (Iterator<Entry<Character, Integer>> it = charMap.entrySet().iterator(); it.hasNext(); ) {
            Entry<Character, Integer> temp = it.next();
            ValueCompare temp2 = new ValueCompare(temp.getKey(), temp.getValue());
            sortedByValue.add(temp2);
        }

        double totalLetters = 0;
        for (ValueCompare x : sortedByValue) {
            totalLetters += x.getValue();
        }
        for (ValueCompare x : sortedByValue) {
            double times = x.getValue() / totalLetters;
            System.out.print(x.getKey() + ": " + x.getValue() + " ");
            for (int i = 0; i < (int) (times * 100); i++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
