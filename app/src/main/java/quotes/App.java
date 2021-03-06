/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.checkerframework.checker.units.qual.A;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    static ArrayList quotes;

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        getJsonData();
//        System.out.println(randomQuote(args[0], true)); // Test with args[0] for command line file path default
//        System.out.println(randomQuote(args[0], false)); // Test with args[0] for random index
        File ourApiFile = new File("./ourapiquotes.json");
        if (!ourApiFile.exists()){
            initalQuote("./ourapiquotes.json");
        }
        getForismaticQuote("./ourapiquotes.json");
    }

    public static FileWriter initalQuote(String filePath) throws IOException {

        FileWriter newFile = new FileWriter(filePath);
        return newFile;
    }

    public static void getForismaticQuote (String filePath) throws IOException {

        try {
            URL apiUrl = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
            HttpURLConnection apiUrlConnection = (HttpURLConnection) apiUrl.openConnection();
            apiUrlConnection.setRequestMethod("GET");
            InputStreamReader apiReader = new InputStreamReader(apiUrlConnection.getInputStream());
            BufferedReader apiBufferInput = new BufferedReader(apiReader);
            String apiData = apiBufferInput.readLine();

            System.out.println("Api Random Quote  Generated: " + apiData);
            Gson gsonApi = new GsonBuilder().setPrettyPrinting().create();


            ApiQuotes jsonApi = gsonApi.fromJson(apiData, ApiQuotes.class);

            BufferedReader currentFile = new BufferedReader(new FileReader("ourapiquotes.json"));
            if (currentFile.readLine() != null) {
                try (BufferedWriter appendQuoteFileWriter = (BufferedWriter) new BufferedWriter(new FileWriter("ourapiquotes.json", true)).append(",\n")) {
                    gsonApi.toJson(jsonApi, appendQuoteFileWriter);
                }
            }
            if (currentFile.readLine() == null) {
                FileWriter newFile = new FileWriter(filePath);
                try (BufferedWriter appendQuoteFileWriter = (BufferedWriter) new BufferedWriter(new FileWriter("ourapiquotes.json", true))) {
                    gsonApi.toJson(jsonApi, appendQuoteFileWriter);
                }
            }

        } catch (IOException ioe) {
            BufferedReader currentFile = new BufferedReader(new FileReader("ourapiquotes.json"));
            if (currentFile.readLine() != null) {
                try (BufferedWriter appendQuoteFileWriter = (BufferedWriter) new BufferedWriter(new FileWriter("ourapiquotes.json", true)).append(",\n")) {
                    Gson gson = new Gson();
                    gson.toJson(randomQuote("./app/src/test/resources/recentquotes.json",false), appendQuoteFileWriter);
                }
            }
            if (currentFile.readLine() == null) {
                FileWriter newFile = new FileWriter(filePath);
                try (BufferedWriter appendQuoteFileWriter = (BufferedWriter) new BufferedWriter(new FileWriter("ourapiquotes.json", true))) {
                    Gson gson = new Gson();
                    gson.toJson(randomQuote("./app/src/test/resources/recentquotes.json",false), appendQuoteFileWriter);
                }
            }

        }

        }
    public static void getJsonData() throws IOException {
        String path = "./app/src/test/resources/recentquotes.json";
        System.out.println("Random Quote Test: "+randomQuote(path, true));
        System.out.println("Random Quote 2: "+randomQuote(path, false));
        System.out.println("Random Quote 3: "+randomQuote(path, false));
        System.out.println("Random Quote 4: "+randomQuote(path, false));
    }

    public static String randomQuote(String path, Boolean test) throws IOException {
        File file = new File(path); // input file path
        FileReader readFileLines = new FileReader(file); // read file
        Gson gson = new Gson(); // create a new gson object- this will be used to convert Java Object to JSON
        // representation
        Quotes[] json = gson.fromJson(readFileLines, Quotes[].class); // serialize data
        int index;
        if (test.equals(true)) { // checking input boolean: this will change our index variable
            index = 0;
        } else {
            index = (int) (Math.random() * json.length);
        } // get random number for our json array index
        String author = "{\"quoteAuthor\": " + json[index].author + "\n"; // extract author's name at randomly generated index
        String text = "\"quoteText\": " + json[index].text + "\"\n}" ; // extract text at randomly generated index
        return author + text; // return author + text in String format
    }
}
