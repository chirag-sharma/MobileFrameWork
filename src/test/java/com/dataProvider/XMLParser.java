package com.dataProvider;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

//import com.accenture.aaft.logger.CTLogger;


/**
 * Class is used to parse the xml file
 *
 * @author vijay.venkatappa
 *
 */
public class XMLParser extends DefaultHandler {
	
	public static final Logger logger = LogManager.getLogger(XMLParser.class);
	private static XMLParser parser = null;
	//PropertyFileReader fileReader=new PropertyFileReader();
	public XMLParser() {		
		parseFile(new File("./src/test/resources/DeviceConfig.xml"));
			//fileReader.getValue("EXTENDED_CONFIG_PATH") 
	}

	public static XMLParser getInstance() {
		if (parser == null) {
			parser = new XMLParser();
		}
		return parser;
	}

	private Map<String, Map<String, String>> configMap = new HashMap<>();
	private Map<String, String[]> configMetaDataMap = new HashMap<>();

	Map<String, String> capabilitiesMap;
	String name;
	StringBuffer buffer;

	/**
	 * Method is used to parse the XML file
	 *
	 * @param file
	 *            - name of the XML file to parse
	 */
	public void parseFile(File file) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(file, this);
		} catch (Exception exception) {
			logger.error(exception.getMessage());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		if ("name".equalsIgnoreCase(qName)) {
			capabilitiesMap = new HashMap<>();
			name = attributes.getValue("value");

			String[] attrArray = new String[2];
			attrArray[0] = attributes.getValue("for");
			attrArray[1] = attributes.getValue("type");

			if (null != attrArray[1] && null != attrArray[0]) {
				name = attrArray[1] + "_" + attrArray[0] + "_" + name;
			}
			getConfigMetaDataMap().put(name, attrArray);
		} else if (!"DeviceConfig".equalsIgnoreCase(qName)) {
			buffer = new StringBuffer();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if ("name".equalsIgnoreCase(qName)) {
			getConfigMap().put(name, capabilitiesMap);
		} else if (!"DeviceConfig".equalsIgnoreCase(qName)) {
			capabilitiesMap.put(qName, buffer.toString());
			buffer = null;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) {
		if (null != buffer) {
			buffer.append(ch, start, length);
		}
	}

	public Map<String, Map<String, String>> getConfigMap() {
		return this.configMap;
	}

	public Map<String, String[]> getConfigMetaDataMap() {
		return this.configMetaDataMap;
	}

}
