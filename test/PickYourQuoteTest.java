import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import org.junit.Test;

public class PickYourQuoteTest {

  @Test
  public void exampleText() throws Exception {

    String input =
        String.join(
            "\n", "What a test!;Anonymous", "Another test!;Anonymous", "The last test!;Anonymous");

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(2, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertThat(
        "Selected line 2 but got a different line.",
        output,
        containsString("Another test!" + "\n" + "Anonymous"));
  }

  @Test
  public void emptyQuote() throws Exception {

    String input = String.join("\n", "What a test!;Anonymous", "", "The last test!;Anonymous");

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(2, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertThat("Selected quote 2 but did not get empty string.", output, containsString(""));
  }

  @Test
  public void outOfBounds() throws Exception {

    String input =
        String.join(
            "\n", "What a test!;Anonymous", "Another test!;Anonymous", "The last test!;Anonymous");

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickYourQuote.reformat(100, new BufferedReader(new StringReader(input)));

    String output = outstream.toString();
    assertThat(
        "Selected line out of bounds but did not get correct error message.",
        output,
        containsString("Error: Quote number out of bounds."));
  }
}
