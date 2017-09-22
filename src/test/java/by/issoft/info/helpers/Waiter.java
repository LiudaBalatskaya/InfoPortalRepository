package by.issoft.info.helpers;

import static com.codeborne.selenide.Selenide.$;

import by.issoft.info.po.CommonPage;
import com.codeborne.selenide.Condition;

public class Waiter {
    public static void waitForLoading() {
        $(CommonPage.INDICATOR).waitUntil(Condition.disappears, 10000);
    }
}
