
import com.google.common.collect.Sets;
import com.sun.javafx.collections.MappingChange;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Text {

    private final String text;

    public Text(String text) {
        this.text = text;
    }

    private String clearText(String dirtyText) {
        String clearText = dirtyText.toLowerCase().replaceAll("[^A-Za-z]", " ");
        return clearText;
    }

    private String[] getArrayOfUniqueWords(String string) {
        String[] arrayOfSptiledStrings = getArrayOfSplitedWords(string);

        HashSet<String> setOfStrings = Sets.newHashSet(arrayOfSptiledStrings);
        setOfStrings.remove("");

        String[] clearArray = setOfStrings.toArray(new String[setOfStrings.size()]);
        return clearArray;
    }

    private String[] getArrayOfSplitedWords(String string) {
        return string.split(" ");
    }

    public String[] getTopWords(int n) {

        String[] clearArray = getArrayOfUniqueWords(clearText(text));
        Arrays.sort(clearArray);
        String[] strings = {};
        if (clearArray.length < n){
            System.out.println("Incorrect N: array has only " + clearArray.length + " elements");
            return strings;

        }
        try {
            strings = Arrays.copyOfRange(clearArray, 0, n);
        } catch (Exception e) {
            System.out.println("Incorrect N: " + e.getMessage());
        } finally {
            return strings;
        }
    }

    public Map<String, Integer> getWordFrequencies() {
        String[] splitedArray = getArrayOfSplitedWords(clearText(text));

        Map<String, Integer> resultMap = new HashMap<String, Integer>();

        for (String word : splitedArray) {
            if (resultMap.containsKey(word)) {
                resultMap.put(word, resultMap.get(word) + 1);
            } else {
                resultMap.put(word, 1);
            }
            resultMap.remove("");
        }
        return resultMap;
    }


}
