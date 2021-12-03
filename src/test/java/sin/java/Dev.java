package sin.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

@RunWith(JUnit4.class)
public class Dev {
    @Test
    public void dev(){
        List list = new ArrayList();
        list.add("100");
        list.add(1002);
        System.out.println(list);
    }
}
