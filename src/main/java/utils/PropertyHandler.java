package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @Author: ridwan.julvianto@inmarsat.com
 * @Created: 08.07.2019
 **/
public class PropertyHandler {

	private String propertyFile = "";
	private static Logger logger = Logger.getLogger(PropertyHandler.class);
	public static PropertyHandler testConfig = new PropertyHandler("src/test/resources/TestConfiguration.properties");
	public static PropertyHandler testData = new PropertyHandler("src/test/resources/TestData.properties");

	public PropertyHandler(String filePath) {
		propertyFile = filePath;
	}

	private Properties readFromFile() {
		Properties properties = new Properties();
		try (InputStreamReader fileReader = new InputStreamReader(new FileInputStream(propertyFile))) {
			properties.load(fileReader);
			fileReader.close();
		} catch (IOException e) {
			logger.error("Property file not found!");
			e.printStackTrace();
		}

		return properties;
	}

	public String getValue(String propertyName) {
		String propertyValue;
		propertyValue = (readFromFile().getProperty(propertyName));

		//logger.info(propertyName + " value is: " + propertyValue);
		return propertyValue;
	}

	public void updateValue(String propertyName, String newValue) {
		Properties dataProperties = readFromFile();

		try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(propertyFile))) {
			dataProperties.setProperty(propertyName, newValue);
			dataProperties.store(writer, null);
			writer.close();

			//logger.info("Insert/update " + propertyName + " with new value: " + newValue);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
