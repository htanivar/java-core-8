package sin.java.generics;

import lombok.Data;

@Data
public class DemoClass<T> implements DemoInterface<Integer,Integer>{
    private T t;
    private Dimension<Integer> dimension = new Dimension<Integer>(5,6,7);

    @Override
    public Integer addOperation(int a, int b) {
        return a+b;
    }

    @Override
    public Integer minusOperation(int a, int b) {
        return a-b;
    }
}