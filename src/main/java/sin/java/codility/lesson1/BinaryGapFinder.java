package sin.java.codility.lesson1;

public class BinaryGapFinder {

    public int solution(int N){
        int ret = 0;
        boolean isCounter = false;
        boolean moreThanOneOne = false;
        int counter =0;
        String binaryString = Integer.toBinaryString(N);
        System.out.println("Input = "+N+" BinaryString = "+binaryString);
        for (int i = 0; i < binaryString.length()-1; i++) {
            System.out.println("i = "+i+", char = "+binaryString.charAt(i));

            if(Character.getNumericValue(binaryString.charAt(i))==1 && !isCounter){
                counter=0;
                isCounter = true;
            }else if(Character.getNumericValue(binaryString.charAt(i))==1 && isCounter){
                isCounter = false;
                ret = Math.max(counter, ret);
                counter = 0;
                moreThanOneOne = true;
            }else{
                counter++;
//                System.out.println(binaryString.charAt(i)+" - "+counter);
            }
        }
        if (!moreThanOneOne)
            return 0;
       return ret;
    }


    private void inputMustBePositiveInteger(int n) {
        if(n<=0)
            throw new IllegalArgumentException("Input must be a positive Integer");
    }

}
