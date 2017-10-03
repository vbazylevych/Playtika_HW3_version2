import com.sun.istack.internal.NotNull;
import org.hamcrest.CoreMatchers;

import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GetWordFrequenciesMethodTest {



    @Test()
    public void getWordFrequenciesReturnsCorrectNumbersOfWordsForStringWithSpecificSymbols() {
        Text text = new Text("kot ^   ...//%sema, ,,");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 1);
        expectedMap.put("sema", 1);

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void getWordFrequenciesReturnsCorrectNumbersOfWordsForStringWithSameWords() {
        Text text = new Text("kot kot ^   %sema, ,,");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 2);
        expectedMap.put("sema", 1);

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void getWordFrequenciesReturnsCorrectNumbersOfWordsForStringWithUpperCases() {
        Text text = new Text("koT KOT   %SEma, ,,");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 2);
        expectedMap.put("sema", 1);

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void getWordFrequenciesReturnsCorrectNumbersOfWordsForStringWithUniqueWords() {
        Text text = new Text("kotkot, ,," + "rrr");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kotkot", 1);
        expectedMap.put("rrr1", 1);
       // assertThat(expectedMap, CoreMatchers.is(CoreMatchers.equalTo(text.getWordFrequencies()))); // если строка матчится то тест проходит, НЕ матчитс не проходит
      //  assertThat(expectedMap, CoreMatchers.allOf(hasEntry("hello",2)));
        //assertEquals("krot",expectedMap, text.getWordFrequencies());
        Set<String> words = text.getWordFrequencies().keySet();
        assertThat(words, hasSize(2));
        assertThat(words, hasItems("hello", "text"));
//
    }

    @Test
    public void getWordFrequenciesReturnsEmptyMapIfStringWithoutWords() {
        Text text = new Text("   ");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void getWordFrequenciesReturnsEmptyMapIfStringIsEmpty() {
        Text text = new Text("");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();

        assertEquals(expectedMap, text.getWordFrequencies());
    }


@Test (expected = IllegalArgumentException.class)
    public void nullTest( ){
        Text text = new Text(null);
         text.getWordFrequencies();
    }

}
