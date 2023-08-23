package utilities;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "testData")
    public static Object[][] testData() {
        return new Object[][]{
                {"97074", "Alandsgrund", "8", "01.01.1980", "150"},
                {"97491", "Distler", "7", "02.02.1990","134"},
                {"97488", "Bachgasse", "9", "03.03.1975", "543"},
                {"97488", "Bachgasse", "10", "03.03.1975", "543"}
        };
    }
}
