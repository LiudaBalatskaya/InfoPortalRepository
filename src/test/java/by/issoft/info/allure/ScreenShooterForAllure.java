package by.issoft.info.allure;

import static com.codeborne.selenide.ex.ErrorMessages.screenshot;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.ex.UIAssertionError;
import com.codeborne.selenide.testng.ScreenShooter;
import org.testng.ITestResult;

import java.util.logging.Logger;

public class ScreenShooterForAllure extends ScreenShooter {
    private final Logger log = Logger.getLogger(getClass().getName());


    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);

        String className = result.getMethod().getTestClass().getName();
        String methodName = result.getMethod().getMethodName();
        Screenshots.startContext(className, methodName);
    }


    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        if (!(result.getThrowable() instanceof UIAssertionError)) {
            log.info(screenshot());
        }

        Screenshots.finishContext();
        AllureAttacher.attachScreen();
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        if (captureSuccessfulTests) {
            log.info(screenshot());
            AllureAttacher.attachScreen();
        }
        Screenshots.finishContext();
    }
}
