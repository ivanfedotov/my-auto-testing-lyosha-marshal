package DemoTestNG;

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

    @Test (groups = {"demo", "test_N", "local"}, dataProvider = "demoDP")
    public void demoTest1(String e1, Integer e2) {
        System.out.println("[demo] Test 1 " + e1 + " " + e2);
    }

    @Test (groups = {"demo", "test_N", "local"})
    public void demoTest2() {
        System.out.println("[demo] Test 2");
    }
}
