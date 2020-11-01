package sin.java.codility.lesson1;

public class BinaryGapFinder {

    public int solution(int N){
        int ret = 0;
        int numberOfOne = 0;
        int counter =0;
        String binaryString = Integer.toBinaryString(N);
//        System.out.println("Input = "+N+" BinaryString = "+binaryString);
        for (int i = 0; i <= binaryString.length()-1; i++) {
//            System.out.println(binaryString.length()-1);
//            System.out.println("i = "+i+", char = "+binaryString.charAt(i));
            if(Character.getNumericValue(binaryString.charAt(i))==1){
                ret = Math.max(counter, ret);
                counter = 0;
                numberOfOne++;
            }else{
                counter++;
            }
        }
        if (numberOfOne<=1)
            return 0;
       return ret;
    }


    private void inputMustBePositiveInteger(int n) {
        if(n<=0)
            throw new IllegalArgumentException("Input must be a positive Integer");
    }

}
