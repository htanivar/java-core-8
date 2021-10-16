package sin.java.read.propertyfile;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;


public class ReadPropertyFile {

    private String propFileName;

    public ReadPropertyFile(String propFileName) {
        this.propFileName = propFileName;
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
        try (InputStream propFile = getClass()
                .getClassLoader().getResourceAsStream(propFileName)) {
            Properties prop = new Properties();
            // load a properties file
            Preconditions.checkArgument(propFile != null, "Property file input stream is null, filename" + propFileName);
            prop.load(propFile);

            Map<String, String> map = new HashMap();

            map.putAll(prop.entrySet()
                    .stream()
                    .collect(Collectors.toMap(e -> e.getKey().toString(),
                            e -> e.getValue().toString())));
            String propertyFromFile = map.get(propertyName);
            if (!StringUtils.isEmpty(propertyFromFile)) {
                return propertyFromFile;
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.defaultIfEmpty(ret, "");

    }
}
