package sin.java.read.propertyfile;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import sin.java.domain.InputFileType;
import sin.java.domain.nse.getoptions.NseOptionsChainData;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.readFileToString;


public class ReadInputFile {

    private InputFileType inputFileType;
    private String inputFileName;
    private String inputFileContent;
    private Properties prop = new Properties();
    private NseOptionsChainData nseOptionsChainData;


    public ReadInputFile(String inputFileName, String inputFileType) {
        this.inputFileName = inputFileName;
        this.inputFileType = InputFileType.valueOf(inputFileType.toUpperCase());
        loadFile();

    }

    public Properties readAllMySystemVariable() {
        Properties pros = System.getProperties();
        return pros;
    }

    public String readMyProperty(String propertyName) throws IOException {
        String ret = "";
        ret = System.getProperty(propertyName);
        if (!StringUtils.isEmpty(ret)) {
            return ret;
        } else {
            ret = readPropertyFromFile(propertyName);
            if (StringUtils.isEmpty(ret)) {
                throw new IllegalArgumentException("Unable to find System Property :" + propertyName);
            }

        }
        return ret;
    }


    private String readPropertyFromFile(String propertyName) throws IOException {
        String ret = "";
        loadFile();
        Map<String, String> map = new HashMap();

        map.putAll(prop.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().toString(),
                        e -> e.getValue().toString())));
        String propertyFromFile = map.get(propertyName);
        if (!StringUtils.isEmpty(propertyFromFile)) {
            return propertyFromFile;
        }
        return StringUtils.defaultIfEmpty(ret, "");
    }

    private void loadFile() {
        switch (inputFileType) {
            case PROP: {
                loadPropertyFile();
                break;
            }
            case JSON: {
                readFileContentAsString();
                loadJsonObject();
                break;
            }
            default: {
                throw new IllegalArgumentException("Unable to find the input file type: " + inputFileType.toString());
            }
        }
    }

    private void loadPropertyFile() {
        try {
            prop.load(getInputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to find the input file " + inputFileName, e);
        }
    }

    private void loadJsonObject() {
        Gson gson = new Gson();
        this.nseOptionsChainData = gson.fromJson(inputFileContent, NseOptionsChainData.class);
    }

    private InputStream getInputStream() {
        InputStream inputStream = getClass()
                .getClassLoader().getResourceAsStream(inputFileName);
        Preconditions.checkArgument(inputStream != null, "Unable to get input stream from filename : " + inputFileName);
        return inputStream;
    }

    private void readFileContentAsString() {
        String filePath = getClass().getClassLoader().getResource(inputFileName).getPath();
        File file = new File(filePath);
        try {
            this.inputFileContent = readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to find the input file " + inputFileName, e);
        }
    }
}
