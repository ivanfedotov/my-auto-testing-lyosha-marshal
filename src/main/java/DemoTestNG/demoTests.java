package DemoTestNG;

import org.testng.annotations.Test;

public class demoTests {

    @Test (groups = {"demo", "test_N", "local"})
    public void demoTest1() {
        System.out.println("[demo] Test 1");
    }

    @Test (groups = {"demo", "test_N", "local"})
    public void demoTest2() {
        System.out.println("[demo] Test 2");
    }
}
