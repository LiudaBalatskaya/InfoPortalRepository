# Info Portal Autotests

## To run tests:

* run `mvn clean test`

Or you can override values from `info-portal-auto\src\test\resources\test.properties` file.

Example:
`mvn clean test -Dselenide.base.url=https://info.issoft.by -Dbrowser=local_firefox`

## To generate Allure report:

* run `mvn site`

## To see Allure report:

Just open `info-portal-auto\target\site\allure-maven-plugin.html` file in ***firefox*** browser.
