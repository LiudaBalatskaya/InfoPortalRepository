package by.issoft.info.allure;

import com.google.common.io.Files;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

public class AllureAttacher {

    @Attachment(value = "Page screen", type = "image/png")
    public static byte[] attachScreen() {
        File screenshot = com.codeborne.selenide.Screenshots.getLastScreenshot();// getScreenShotAsFile();
        byte[] b = null;
        try {
            b = Files.toByteArray(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }
}
