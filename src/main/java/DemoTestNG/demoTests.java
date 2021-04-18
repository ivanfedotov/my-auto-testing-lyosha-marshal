package DemoTestNG;

import Modules.RetryTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class demoTests {

    @DataProvider (name = "demoDP")
    public static Object[][] wordAndDigit () {
        return new Object[][] {
                {"строка 1", new Integer(123)},
                {"строка 2", new Integer(321)},
        };
    }

    @Test (
            groups = {"demo", "test_N", "local"},
            dataProvider = "demoDP"
    )
    public void demoTest1(String e1, Integer e2) {
        System.out.println("[demo] Test 1 " + e1 + " " + e2);
    }

    @Test (
            groups = {"demo", "test_N", "local"},
            dependsOnMethods = {"demoTest1"}, alwaysRun = false
    )
    public void demoTest2() {
        System.out.println("[demo] Test 2 (Зависимый тест)");
    }

    @Test (
            groups = {"fail"},
            retryAnalyzer = RetryTest.class
    )
    public void testFail() {
        System.out.println("[demo] Test 3 (Ошибка и повторение)");
        Assert.fail();
    }

}