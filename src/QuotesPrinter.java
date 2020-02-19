import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuotesPrinter {

  static final String quotesFile =
      "/Users/FinnHarman/Google Drive/Computing Science/Software Engineering/Coursework/T1/575_tut1_fh219/Quotes.txt";

  public static void main(String[] args) throws Exception {

    // read the file Quotes.txt using a BufferedReader
    FileReader r = new FileReader(quotesFile);
    BufferedReader Quotes = new BufferedReader(r);

    // reformat the file
    reformat(Quotes);

    Quotes.close();
  }

  public static void reformat(BufferedReader input) throws IOException {

    // read lines from the input
    // reformat as appropriate
    // print to System.out
    String line = input.readLine();

    while (line != null) {
      String parts[] = line.split(";", 2);
      for (String part : parts) {
        System.out.println(part);
      }
      line = input.readLine();
    }
  }
}
