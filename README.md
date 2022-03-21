# Quotes

### Implementation
- Build and run app from root quotes/ on IDE or using the following in the command line/ terminal
- See link and run from the file in IDE [Run App from this file in IDE](app/src/main/java/quotes/App.java)
- See "Api Random Quote  Generated:" in terminal
- See link for api quotes [ourapiquotes.json](ourapiquotes.json)
- For testing, run command Line/terminal  : `./gradlew test`



## Resources 

- [GSON](https://github.com/google/gson/blob/master/UserGuide.md)
- [recentquotes.json](https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json)

### Feature Tasks 

- Using the file `recentquotes.json` to show three random popular book quotes.
- randomQuote() generates random quotes from`recentquotes.json`see terminal for random quotes
- getForismaticQuote() gets API quote and saves it to ourapiquotes.json [ourapiquotes.json](ourapiquotes.json)
- initalQuote() helper function for getForismaticQuote() to create new file
- getJsonData() call method for random quote Method
#### Testing 

For integration testing, run command Line/terminal  : `./gradlew test`


### Refactor

- 03.20.2022 Lab 8 Redid README with Implementation Instructions
- 03.20.2022 Lab 9 Refactored README for comma to append in ourapiquotes.json; If API is down app pulls from local JSON.
- Work time 4.5 hours