
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GetLengthInCharsMethodTest {

    @Test
    public void stringWithSpecificSymbols() {
        Text text = new Text("kot,% #@ !" + "\n");
        int result = text.getLengthInChars();
        int expectedResult = 3;

        assertEquals(result, expectedResult);
    }

    @Test
    public void stringWithSameWords() {
        Text text = new Text("kot kot");
        int result = text.getLengthInChars();
        int expectedResult = 6;

        assertEquals(result, expectedResult);
    }

    @Test
    public void stringWithUpperCases() {
        Text text = new Text("Kot KROT");
        int result = text.getLengthInChars();
        int expectedResult = 7;

        assertEquals(result, expectedResult);
    }

    @Test
    public void stringIsEmpty() {
        Text text = new Text("");
        int result = text.getLengthInChars();
        int expectedResult = 0;
        assertEquals(result, expectedResult);
    }

    @Test
    public void stringWithoutWords() {
        Text text = new Text(" ");
        int result = text.getLengthInChars();
        int expectedResult = 0;
        assertEquals(result, expectedResult);
    }
    @Test(expected = NullPointerException.class)
    public void stringWithNull() {
        Text text = new Text(null);
        text.getLengthInChars();
    }


}
