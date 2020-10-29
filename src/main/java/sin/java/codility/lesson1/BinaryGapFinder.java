package sin.java.codility.lesson1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BinaryGapFinder {

    public int solution(int N){
        List<Integer> gaps = new ArrayList<>();
        inputMustBePositiveInteger(N);
        String binaryString = getBinaryString(N);
        while(binaryString.length()!=0){
            int firstOnePos = findFirstOne(binaryString);
            binaryString = binaryString.substring(firstOnePos+1);
            int secondOnePos = findFirstOne(binaryString);
            binaryString = binaryString.substring(secondOnePos);
            gaps.add(secondOnePos-firstOnePos);
        }
        return Collections.max(gaps) ;
    }


    private int findFirstOne(String binaryString) {
        return binaryString.indexOf("1");
    }

    private String getBinaryString(int n){
        return Integer.toBinaryString(n);
    }

    private void inputMustBePositiveInteger(int n) {
        if(n<=0)
            throw new IllegalArgumentException("Input must be a positive Integer");
    }

}
