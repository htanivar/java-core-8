package sin.java.sorting;

/**
 * Guide from Youtube: https://www.youtube.com/watch?v=lCDZ0IprFw4
 */
public class InsertionSort {
    public int[] getIntArraySorted(int[] inputAsArray){
        System.out.println("input array for sorting: "+debugTest(inputAsArray));
        int[] sortedArray = getSortedArray(inputAsArray);
        System.out.println("sorted Array : "+debugTest(inputAsArray));
        return sortedArray;
    }

    private int[] getSortedArray(int[] inputAsArray) {
        int outerLoopCounter,innerLoopCounter,temp,keyValue;
        System.out.println( "0th Element :"+inputAsArray[0] +" always sorted because it is the first element");
        for(outerLoopCounter=1;outerLoopCounter<=inputAsArray.length-1;outerLoopCounter++){
            keyValue=inputAsArray[outerLoopCounter];
            System.out.println("Key Value: "+keyValue);
            innerLoopCounter = outerLoopCounter -1; //This will make innerLoop count
            while (innerLoopCounter >=0 && keyValue<inputAsArray[innerLoopCounter]){

//                Swap
                temp = inputAsArray[innerLoopCounter];
                inputAsArray[innerLoopCounter]=inputAsArray[innerLoopCounter+1];
                inputAsArray[innerLoopCounter+1]=temp;

                innerLoopCounter--;
            }
        }
        return inputAsArray;
    }

    private String debugTest(int[] input){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            stringBuilder.append(input[i]);
            if(i!=input.length-1)
                stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
