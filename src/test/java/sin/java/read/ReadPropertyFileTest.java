package sin.java.read;

import org.junit.Test;
import sin.java.read.propertyfile.ReadPropertyFile;

import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class ReadPropertyFileTest {

    ReadPropertyFile readPropertyFile = new ReadPropertyFile();

    @Test
    public void validSystemPropertyTest() {
        assertThat(readPropertyFile.readMyProperty("user.name"), is("root"));
        assertThat(readPropertyFile.readMyProperty("my-url"), is("http://yahoo.co.uk"));
        assertThat(readPropertyFile.readMyProperty("my-test-url"), is("http://test.co.uk"));
    }

    @Test
    public void printAllSystemVariablesTest(){
        assertTrue("Properties class is not returned",readPropertyFile.readAllMySystemVariable() instanceof Properties);
    }
}
