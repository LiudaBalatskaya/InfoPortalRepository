# Info Portal Autotests

Technologies:

* Java 8
* Maven 3.3.9+
* Selenide
* TestNG
* Allure Test Report

Code style file: `info-portal-auto\codestyle\GoogleStyleFork.xml` 

## Preparation for run:

**To run tests locally:**
1. Install latest Firefox (It should be version >= 47.0.2, because Selenium WebDriver 3+ is using)
2. Install latest Google Chrome
3. Download and decompress latest version of chrome driver http://chromedriver.storage.googleapis.com/index.html
4. Download and decompress latest version of gecko driver https://github.com/mozilla/geckodriver/releases
5. Update paths of driver*.exe files in `info-portal-auto\src\test\resources\test.properties` file

**To run tests remotely:**
1. Set appropriate values in `info-portal-auto\src\test\resources\test.properties` file for `webdriver.chrome.remote.hub` and `webdriver.firefox.remote.hub` keys 

## To run tests:

* run `mvn clean test`

Or you can override values from `info-portal-auto\src\test\resources\test.properties` file.

Example:
`mvn clean test -Dselenide.base.url=https://info.issoft.by -Dbrowser=local_firefox`

## To generate Allure report:

* run `mvn site`

## To see Allure report:

Just open `info-portal-auto\target\site\allure-maven-plugin.html` file in ***firefox*** browser.
