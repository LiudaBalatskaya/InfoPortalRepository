package by.issoft.info.po;


import org.openqa.selenium.By;

import java.util.Arrays;
import java.util.List;

public class IndividualPage {
    public static final By FULL_NAME = By.cssSelector(".personFullName.ellipsis-full-container-hidden");
    //RMSys - Individual  - title
    List<String> FULLNAME = Arrays.asList("Kapitonov, Roman",
            "Sagalovich, Michael",
            "Ivanova, Liuda",
            "Zhevnyak, Alexander",
            "Tisinevich, Petr",
            "Sidoryk, Andrei",
            "Gorbatenko, Dmitry",
            "Kupreev, Slava",
            "Shklenski, Valery",
            "Yurkevich, Vladimir",
            "Shklenski, Valery"
    );

    List<String> RMSYS_FULLNAME_COHERENT_SOLITIONS = Arrays.asList("Schneerson, Alexandre",
            "Epshteyn, Igor",
            "Kittock, Michael",
            "Duff, Robert",
            "Belov, Maksim",
            "Duff, Robert",
            "Schneider, Dan",
            "Duff, Robert",
            "",
            "Syverson, Jay",
            "Syverson, Jay",
            "Wollberg, Amy",
            "Gordeeva, Julia",
            "",
            "Belov, Maksim",
            "Belov, Maksim",
            "",
            "",
            ""
    );

    List<String> RMSYS_FULLNAME_ISSOFT_ADMIN = Arrays.asList("Schneerson, Alexandre",
            "Epshteyn, Igor",
            "Belov, Maksim",
            "",
            "Petruchenya, Dmitry",
            "Duff, Robert",
            "Belov, Maksim",
            "Evmenkov, Alexey",
            "Kapelko, Eugen",
            "Mikhailovsky, Kirill",
            "Hilevski, Sergey",
            "Fominchik, Lena",
            "Katonova, Kira",
            "Nikonov, Andrey",
            "Smelovsky, Sergey",
            "Montvolinsky, Matvey",
            "Mikhailovsky, Kirill",
            "Seredina, Lena",
            "Perepichka, Oksana",
            "Shostak, Stanislav"
    );
}
