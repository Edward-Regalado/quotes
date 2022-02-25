package quotes;



public class ApiQuotes {
    String quoteAuthor;
    String quoteText;
    ApiQuotes[] apiQuotes;


    public ApiQuotes(String quoteAuthor, String quoteText) {
        this.quoteAuthor = quoteAuthor;
        this.quoteText = quoteText;
    }

    @Override
    public String toString() {
        return "ApiQuotes{" +
                "quoteAuthor='" + quoteAuthor + '\'' +
                ", quoteText='" + quoteText + '\'' +
                '}';
    }
}
