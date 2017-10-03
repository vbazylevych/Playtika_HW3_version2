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
    public void stringWithSpecificSymbols() {
        Text text = new Text("kot ^   ...//%sema, ,,");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 1);
        expectedMap.put("sema", 1);

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void stringWithSameWords() {
        Text text = new Text("kot kot sema");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 2);
        expectedMap.put("sema", 1);

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void stringWithUpperCases() {
        Text text = new Text("koT KOT SEma");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kot", 2);
        expectedMap.put("sema", 1);

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void stringWithUniqueWords() {
        Text text = new Text("kotkot rrr");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        expectedMap.put("kotkot", 1);
        expectedMap.put("rrr", 1);

        assertEquals("krot", expectedMap, text.getWordFrequencies());
    }

    @Test
    public void stringWithoutWords() {
        Text text = new Text("   ");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();

        assertEquals(expectedMap, text.getWordFrequencies());
    }

    @Test
    public void stringIsEmpty() {
        Text text = new Text("");
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();

        assertEquals(expectedMap, text.getWordFrequencies());
    }


    @Test(expected = NullPointerException.class)
    public void nullTest() {
        Text text = new Text(null);
        text.getWordFrequencies();
    }

}
