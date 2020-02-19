import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PickYourQuote {

  public static void main(String[] args) throws Exception {

    final String quotesFile = args[0];
    final int num = Integer.parseInt(args[1]);

    // read the file Quotes.txt using a BufferedReader
    FileReader r = new FileReader(quotesFile);
    BufferedReader Quotes = new BufferedReader(r);

    // reformat the file
    reformat(num, Quotes);

    Quotes.close();
  }

  public static void reformat(int i, BufferedReader in) throws IOException {

    // read lines from the input
    // reformat as appropriate
    // print to specified quote to System.out

    int line_num = 0;
    String line = in.readLine();
    line_num++;

    while ((line_num < i) && (line != null)) {
      line = in.readLine();
      line_num++;
    }

    if ((line == null) && (line_num > 1)) {
      System.out.println("Error: Quote number out of bounds.");
    } else {
      String parts[] = line.split(";", 2);
      for (String part : parts) {
        System.out.println(part);
      }
    }
  }
}
