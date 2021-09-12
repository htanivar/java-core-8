package sin.java.interfaces;

public class MovementImplOldStyle implements MovementInt{
    /*
    * Override annotation is used to implement the method how(), which can be avoided in default method
    * */
    @Override
    public String howOldStyle() {
        return "I am moving from Implementation Class - Old Style";
    }
}
