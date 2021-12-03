package sin.java.generics;

public class Dimension <T>{
    private T length;
    private T height;
    private T width;

    public Dimension(T length, T height, T width) {
        super();
        this.length = length;
        this.height = height;
        this.width = width;
    }

}
