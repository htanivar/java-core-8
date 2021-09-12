package sin.java.interfaces;

public interface MovementInt {
    String howOldStyle();
    default String how(){
     return "I am implemented in Interface with default - New Style";
    }
}
