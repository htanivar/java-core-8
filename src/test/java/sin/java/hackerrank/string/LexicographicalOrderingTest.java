package sin.java.hackerrank.string;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.core.Is.is;

public class LexicographicalOrderingTest {

    @Test
    public void getSmallestAndLargest() {
        LexicographicalOrdering lexicographicalOrdering = new LexicographicalOrdering();
        String test1 = lexicographicalOrdering.getSmallestAndLargest("welcometojava", 3);
        AssertionsForClassTypes.assertThat(test1).isEqualTo("ava" + "\n" + "wel");

        String test2 = lexicographicalOrdering.getSmallestAndLargest("RaviArthi", 3);
        assertThat(test2).isEqualTo("Art" + "\n" + "viA");
    }
}