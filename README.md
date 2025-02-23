# myseleniumtest

### Java Selenium template project that will allow you to start writing your UI automation right away.
I recently had to write Java Selenium tests for the first time in a decade.  I was surprised how Selenium documentation is still not so user-friendly, and it took me a lot of time just to set up the project.

So I created a one-stop shop Java Selenium project that you can just clone and start writing the UI automated tests.  

### Prerequisite
* Java is installed.

### Quick Start
Please run the following to download the project:
```bash
git clone https://github.com/c-higashi/myseleniumtest.git
cd myseleniumtest
```

To run the example tests (in `src/test/java/tests/MySeleniumTest.java`), please run the following:
```bash
./gradlew --rerun-tasks clean test
```
* To start writing your first test, you just have to extend `utils/SeleniumAbstractTest.java`.  Please refer to `src/test/java/tests/MySeleniumTest.java` for an example.
* Please refer to `src/main/java/pages/LoginPage.java` for a Page Object example.

### NOTES
* Logging is provided (though still WIP).
* To change the versions for Selenium and other libraries, please update `build.gradle.kts`. 




