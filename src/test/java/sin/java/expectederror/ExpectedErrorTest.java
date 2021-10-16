package sin.java.expectederror;

import org.junit.Test;
import sin.java.read.propertyfile.ReadPropertyFile;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExpectedErrorTest {

    ReadPropertyFile readPropertyFile = new ReadPropertyFile("myproperties.properties");

    @Test(expected = IllegalArgumentException.class)
    public void expectIllegalArgumentException_Test() throws IOException {
        assertThat(readPropertyFile.readMyProperty("my-invalid-url"), is(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentException_Test() throws IOException {
        ReadPropertyFile illegalArgumentException = new ReadPropertyFile("idontexist");
        assertThat(illegalArgumentException.readMyProperty("my-invalid-url"), is(""));
    }

}
