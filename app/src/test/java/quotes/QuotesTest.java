package quotes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class QuotesTest {

    @DisplayName("create a new quote instance")
    @Test
    void CreateNewQuote(){
       Quotes quote = new Quotes("author", "quote body");
       System.out.println(quote);
       assertEquals("author", quote.author);
       assertEquals("quote body", quote.text);
    }



}