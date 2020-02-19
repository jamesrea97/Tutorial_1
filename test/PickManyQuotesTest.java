import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.List;
import org.junit.Test;

public class PickManyQuotesTest {

  @Test
  public void test() throws Exception {

    final String quote = "What a test!;Anonymous";
    final String reformattedQuote = "`What a test!' by Anonymous";

    String input = String.join("\n", quote + " Line 1", quote + " Line 2", quote + " Line 3");

    BufferedReader in = new BufferedReader(new StringReader(input));

    List<Quote> quotes = PickManyQuotes.loadQuotes(in);

    assertThat(quotes.size(), is(3));
    for (int i = 0; i < 3; i++) {
      assertThat(quotes.get(i).toString(), containsString(reformattedQuote + " Line " + (i + 1)));
    }

    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outstream));

    PickManyQuotes.reformat(quotes, new int[] {1});

    String output = outstream.toString();

    assertThat(output, containsString(reformattedQuote + " Line " + 1));
  }
}
