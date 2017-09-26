
import com.google.common.collect.Sets;


import java.util.Arrays;
import java.util.HashSet;



public class Text {

    private final String text;

    public Text(String text) {
        this.text = text;
    }

    private String clearText(String dirtyText) {
        String clearText = dirtyText.toLowerCase().replaceAll("\\pP", "");
        return clearText;
    }

    private String[] getArrayOfUniqueWords(String string) {
        String[] arrayOfSptiledStrings = string.split(" ");

        HashSet<String> setOfStrings = Sets.newHashSet(arrayOfSptiledStrings);
        setOfStrings.remove("");

        String[] clearArray = setOfStrings.toArray(new String[setOfStrings.size()]);
        return clearArray;
    }

    public String[] getTopWords(int n) {

        String[] clearArray = getArrayOfUniqueWords(clearText(text));
        Arrays.sort(clearArray);
        String[] strings;
        if (n <= clearArray.length) {
            strings = Arrays.copyOfRange(clearArray, 0, n);

        } else {
            strings = Arrays.copyOfRange(clearArray, 0, clearArray.length);
        }

        System.out.println(Arrays.toString(strings));
        return strings;
    }



}
