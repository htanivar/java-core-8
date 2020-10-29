package sin.java.codility.lesson1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
@Slf4j
public class BinaryGapFinderTest {

    /**
     * Given you have Integer it needs to find the Binary Gap
     */
    @Test
    public void findBinaryGapTest(){
        BinaryGapFinder binaryGapFinder = new BinaryGapFinder();
        assertThat(binaryGapFinder.solution(1041 ),is(5));
    }
}