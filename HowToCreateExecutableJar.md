**How to make Executable JAR***

1. Create .mf file

   ```touch myfile.mf```

2. content of the .mf file is expected to have the MainClass </br>
     ```Main-Class: ExecutbaleJar ```


3. Create Main Class
   ```
   public class ExecutableJar {
          public static void main(String[] args) {
             System.out.println("Hello World!!!");
          }
      }
   ```
4. Compile Java Class [navigate to the correct directory], the command below is expected to create ExecutableJar.class file

    ```javac ExecutableJar.java```

5. Use  ```jar``` command with proper switches to create the jar file
   ``` jar -cvmf myfile.mf executableJar.jar ExecutableJar.class  ```


5. Test the executbale jar file
    ```java -jar executableJar.jar```
   
