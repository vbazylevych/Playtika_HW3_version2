
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetTopWordsMethodTest {

    @Test
    public void stringWithSpesialSimbols() {

        Text text = new Text("## ,123 яяя" + "\n" + ",art-, a, @kot! @#");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "kot"};

        assertEquals(result, expectedResult);
    }

    @Test
    public void stringWithApperCasesSimbols() {

        Text text = new Text(" a ART Kot");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "kot"};

        assertEquals(result, expectedResult);
    }

    @Test
    public void stringWitSameWords() {

        Text text = new Text("art art kot kot");
        String[] result = text.getTopWords(2);
        String[] expectedResult = {"art", "kot"};

        assertEquals(result, expectedResult);
    }

    @Test
    public void zeroN() {

        Text text = new Text("begemot art a");
        String[] result = text.getTopWords(0);
        String[] expectedResult = {};

        assertEquals(result, expectedResult);
    }

    @Test
    public void outOfBoundsN() {

        Text text = new Text("begemot art a");
        String[] result = text.getTopWords(-1);
        String[] expectedResult = {};

        assertEquals(result, expectedResult);
    }

    @Test
    public void emptyText() {

        Text text = new Text("");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {};

        assertEquals(result, expectedResult);
    }

    @Test(expected = NullPointerException.class)
    public void nullText() {

        Text text = new Text(null);
        String[] result = text.getTopWords(3);
        String[] expectedResult = {};

        assertEquals(result, expectedResult);
    }

}


