package sin.java.generics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class DemoClassTest {
    @Test
    public void demoClassVariableTest() {
    DemoClass<String> demoClass = new DemoClass<>();
    demoClass.setT("Ravi");
    }

    @Test
    public void demoClassTestAddition(){
        DemoClass<String> demoClass = new DemoClass<>();
        assertThat(demoClass.addOperation(5,6),is(11));
    }

    @Test
    public void demoClassTestMinus() {
        DemoClass<String> demoClass = new DemoClass<>();
        assertThat(demoClass.minusOperation(5, 6), is(-1));
    }
}