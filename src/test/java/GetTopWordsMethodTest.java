
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GetTopWordsMethodTest {

    @Test
    public void methodReturnsNTopWordsForStringWithSpesialSimbols() throws Exception {

        Text text = new Text("## ,123 яяя" + "\n" + ",art-, a, @kot! @#");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "kot"};

        assertEquals(result, expectedResult);
    }

    @Test
    public void methodReturnsNTopWordsForStringWithApperCasesSimbols() throws Exception {

        Text text = new Text("## , Art, a," + "Kot! @#");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "kot"};

        assertEquals(result, expectedResult);
    }

    @Test
    public void methodReturnsUniqueNTopWordsForStringWitSameWords() throws Exception {

        Text text = new Text("##, Art, art, Kot!,a begemot, BEgimot @#");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "begemot"};

        assertEquals(result, expectedResult);
    }

    @Test
    public void methodReturnsEmptyArrayIfNisZero() throws Exception {

        Text text = new Text("begemot art a");
        String[] result = text.getTopWords(0);
        String[] expectedResult = {};

        assertEquals(result, expectedResult);
    }

    @Test
    public void methodReturnsEmptyArrayIfNIsOutOfBounds() throws Exception {

        Text text = new Text("begemot art a");
        String[] result = text.getTopWords(-1);
        String[] expectedResult = {};

        assertEquals(result, expectedResult);
    }

    @Test
    public void methodReturnsEmptyArrayIfTextIsEmpty() throws Exception {

        Text text = new Text("");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {};

        assertEquals(result, expectedResult);
    }


}


