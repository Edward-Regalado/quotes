# Quotes

## Resources 

[GSON](https://github.com/google/gson/blob/master/UserGuide.md)
[recentquotes.json](https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json)

### Feature Tasks 

- Use the file `recentquotes.json` to show random popular book quotes. 
- Your program should use GSON to parse the .json file. 
- The app needs no functionality other than showing the quote and the author when it is run. 
- The app should choose one quote each time it is run.

#### Testing 

- Use JUnit to write at least one test for each of the Features Tasks.

#### Stretch Goals

- Note: if you implement any of these stretch goals, you should also write tests for them
  - Allow users to type in an author (on the command line) and return a quotes by the author.
  - Allow users to type in a word (on the command line) and return a quote that contains that word. 
  - Allow both of those things at the same time, with two different command line args (for example, `./gradlew run 
     --args` "author Chimamanda" vs `./gradlew run --args "contains work"`)
