package sin.java.expectederror;

import org.junit.Test;
import sin.java.read.propertyfile.ReadPropertyFile;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExpectedErrorTest {

    ReadPropertyFile readPropertyFile = new ReadPropertyFile();

    @Test (expected = IllegalArgumentException.class)
    public void expectIllegalArgumentException_Test() {
        assertThat(readPropertyFile.readMyProperty("my-invalid-url"), is(""));
    }

}