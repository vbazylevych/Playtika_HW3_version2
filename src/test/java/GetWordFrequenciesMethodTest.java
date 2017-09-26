import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GetWordFrequenciesMethodTest {

    @Test
    public void getWordFrequenciesReturnsCorrectNumbersOfWordsForStringWithSpecificSymbols() {
        Text text = new Text("kot kot   %Sema, ,,");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 2);
        expectedMap.put("sema", 1);
        Assert.assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void getWordFrequenciesReturnsCorrectNumbersOfWordsForStringWithUniqueWords() {
        Text text = new Text("kot, ,," + "rrr");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 1);
        expectedMap.put("rrr", 1);
        Assert.assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void getWordFrequenciesReturnsEmptyMapIfStringWithoutWords() {
        Text text = new Text(" ^$");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();

        Assert.assertEquals(expectedMap, text.getWordFrequencies());
    }


}
