package quotes;


public class Quotes extends App {
    String author;
    String text;

    public Quotes(String author, String text) {
        this.author = author;
        this.text = text;
    }

    @Override
    public String toString() {
        System.out.println("Author: " + this.author + " " + "Text: " + this.text);
        return this.author + " " + this.text;
    }
}
