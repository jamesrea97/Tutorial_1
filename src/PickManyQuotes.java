import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PickManyQuotes {

  public static void main(String[] args) throws Exception {

    // Use file name and quote numbers in args
    // to first create a list of quotes using loadQuotes
    // and then print to System.out the chosen quotes.

    final String quotesFile = args[0];

    int[] choices = new int[args.length - 1];
    for (int i = 1; i < args.length; i++) {
      choices[i - 1] = Integer.parseInt(args[i]);
    }

    FileReader r = new FileReader(quotesFile);
    BufferedReader Quotes = new BufferedReader(r);

    List<Quote> quotes = loadQuotes(Quotes);
    reformat(quotes, choices);

    Quotes.close();
  }

  public static void reformat(List<Quote> quotes, int[] choices) {

    // Print to System.out quotes according to choices.

    final int quotes_length = quotes.size();
    boolean outOfBounds = false;

    for (int i : choices) {
      if (i > quotes_length) {
        outOfBounds = true;
      }
    }

    if (outOfBounds == true) {
      System.out.println("Error: One or more quote numbers are out of bounds.");
    } else {
      for (int i : choices) {
        System.out.println(quotes.get(i - 1));
      }
    }
  }

  public static List<Quote> loadQuotes(BufferedReader in) throws IOException {
    List<Quote> quotes = new ArrayList<Quote>();

    // Read lines from the input // Create a quote object for each line and store in list.
    String line = in.readLine();
    while (line != null) {
      quotes.add(new Quote(line));
      line = in.readLine();
    }

    return quotes;
  }
}
