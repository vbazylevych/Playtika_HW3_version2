import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetTopWordsMethodTest {

    @Test
    public void metodReturnNTopWordsForStringWithSpesialSimbols() throws Exception {

        Text text = new Text("## , ,art-, a, @kot! @#");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "kot"};

        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void metodReturnNTopWordsForStringWithApperCaseSimbols() throws Exception {

        Text text = new Text("## , Art, a, Kot! @#");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "kot"};

        Assert.assertEquals(result, expectedResult);
    }

    @Test
    public void metodReturnNTopWordsForStringWitSameWords() throws Exception {

        Text text = new Text("## , Art, art, Kot!, begemot, BEgimot @#");
        String[] result = text.getTopWords(3);
        String[] expectedResult = {"a", "art", "kot"};

        Assert.assertEquals(result, expectedResult);
    }
}


