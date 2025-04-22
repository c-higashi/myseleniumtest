# myseleniumtest

## Overview

This is Java Selenium template project that will allow you to start writing your UI automation right away.

## Motivation
I recently had to write Java Selenium tests for the first time in a decade.  I was surprised how Selenium documentation is still not so user-friendly, and it took me a lot of time just to set up the project.

So I created a one-stop shop Java Selenium project that you can just clone and start writing the UI automated tests.

## Quick Start

### Prerequisites
* Git and Java are installed.

### Installation and running the tests
1. Run the following to download the project:
```bash
git clone https://github.com/c-higashi/myseleniumtest.git
cd myseleniumtest
```

2. To run the example tests (in `src/test/java/tests/MySeleniumTest.java`), please run the following:
```bash
./gradlew --rerun-tasks clean test
```
Note: The example tests are executed against https://yltrue.com/automation.

## Creating a New Test
To start writing your first test, extend `utils/SeleniumAbstractTest.java`. 

For examples, please refer to
* `src/test/java/tests/MySeleniumTest.java` for how to write your tests
* classes under `src/main/java/pages/` for Page Object Model examples

### NOTES
* Tests currently only run in Chrome.
* Logging for tests is provided in  `src/test/java/utils/SeleniumAbstractTest.java` (though still WIP).
* To change the versions for Selenium and other libraries, please update `build.gradle.kts`.
