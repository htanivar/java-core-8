package sin.java.expectederror;

import org.junit.Test;
import sin.java.read.propertyfile.ReadInputFile;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ExpectedErrorTest {

    @Test(expected = IllegalArgumentException.class)
    public void wrongInputFileType_Test() {
        new ReadInputFile("nseOptionChainModel.json", "DUMMY");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalArgumentException_Test() {
        assertThat(attemptToReadFileWithoutPropFile(), is(""));
    }

    @Test(expected = NullPointerException.class)
    public void readNonExistingFile_Test() {
        attemptToReadNonExistingJsonFile();
    }

    @Test(expected = IllegalArgumentException.class)
    public void readEmptyPropertyFile_test() {
        try {
            attemptToReadNonExistingProperty();
        } catch (IOException e) {
            throw new IllegalStateException("Expecting Illegal Argument Exeption but got IO Exception");
        }
    }

    @Test
    public void readJsonFileType_Test() {
        attemptToReadJsonFile();
    }


    private ReadInputFile attemptToReadFileWithoutPropFile() {
        return new ReadInputFile("idontexist", "PROP");
    }

    private ReadInputFile attemptToReadNonExistingJsonFile() {
        return new ReadInputFile("idontexist", "JSON");
    }

    private ReadInputFile attemptToReadJsonFile() {
        return new ReadInputFile("nseOptionChainModel.json", "JSON");
    }

    private void attemptToReadNonExistingProperty() throws IOException {
        new ReadInputFile("emptyprop.properties", "PROP")
                .readMyProperty("I don't exist");

    }
}
