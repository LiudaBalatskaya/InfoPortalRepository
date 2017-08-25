# Info Portal Autotests

## To run tests and generate Allure report:

* run `mvn clean test`
* run `mvn site`

## To see a report:

Just open `info-portal-auto\target\site\allure-maven-plugin.html` file in firefox browser.

Or do the next:

1. run `mvn jetty:run`
2. open `http://localhost:8080` in your browser