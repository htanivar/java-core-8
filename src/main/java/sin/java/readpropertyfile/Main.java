package sin.java.readpropertyfile;

public class Main {
    public static void main(String[] args) {
        ReadPropertyFile readPropertyFile = new ReadPropertyFile();
        System.out.println(readPropertyFile.readMyProperty("my-url"));
    }
}
