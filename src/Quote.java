public class Quote {
  private String quote;
  private String context;

  Quote(String input) {
    String parts[] = input.split(";", 2);
    this.quote = parts[0];
    this.context = parts[1];
  }

  public String getQuote() {
    return quote;
  }

  public String getContext() {
    return context;
  }

  public String toString() {
    return "`" + quote + "'" + " by " + context;
  }
}
