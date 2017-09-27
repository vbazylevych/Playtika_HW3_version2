
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GetLengthInCharsMethodTest {

    @Test
    public void getLenghtMethodReturnsCorrectLengthFotStringWithSpecificSymbols() throws Exception {
        Text text = new Text("ko kot, !" + "\n" );
        int result = text.getLengthInChars();
        int expectedResult = 5;

        assertEquals(result, expectedResult);
    }
    @Test
    public void getLenghtMethodReturnsCorrectLengthFotStringWithSameWords() throws Exception {
        Text text = new Text("kot kot kot, !" + "\n" );
        int result = text.getLengthInChars();
        int expectedResult = 9;

        assertEquals(result, expectedResult);
    }

    @Test
    public void getLenghtMethodReturnsCorrectLengthFotStringWithUpperCases() throws Exception {
        Text text = new Text("Kot KROT !" + "\n" );
        int result = text.getLengthInChars();
        int expectedResult = 7;

        assertEquals(result, expectedResult);
    }
    @Test
    public void getLenghtMethodReturnsZeroIfStringIsEmpty() throws Exception {
        Text text = new Text("");
        int result = text.getLengthInChars();
        int expectedResult = 0;
        assertEquals(result, expectedResult);
    }

    @Test
    public void getLenghtMethodReturnsZeroIfStringWithoutWords() throws Exception {
        Text text = new Text(" ");
        int result = text.getLengthInChars();
        int expectedResult = 0;
        assertEquals(result, expectedResult);
    }
}
