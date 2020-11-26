package sin.java.sorting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class InsertionSortTest {

    private final int[] input;
    private InsertionSort insertionSort;

    @Before
    public void init() {
        insertionSort = new InsertionSort();
    }


    public InsertionSortTest(int[] input) {
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<int[]> data() {
        int[] inputOne = {5,8,9,3,7,6,6,6};
        int[] inputTwo = {5,8,1,9,3,7,6};
        List<int[]> inputList = new ArrayList<>();
        inputList.add(inputOne);
        inputList.add(inputTwo);
        return inputList;
    }


    @Test
    public void printTest() {
        insertionSort.getIntArraySorted(input);
    }



}