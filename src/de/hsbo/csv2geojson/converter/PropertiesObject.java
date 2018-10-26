package de.hsbo.csv2geojson.converter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringReader;
import java.util.Properties;

public class PropertiesObject {
	
	// Attribute
	private String propUrl;
	private String propSep;
	private String propXField;
	private String propYField;
	private String propZiel;

	// Properties-Datei
	public PropertiesObject(String propertiesSpeicher) {
		// Einlesen
		Properties properties = new Properties();
		try {
			 File fileIn = new File(propertiesSpeicher); 
			BufferedReader reader = new BufferedReader(new FileReader(fileIn)); 
			properties.load(reader);
			 reader.close();
			/*
			File fileIn = new File(propertiesSpeicher);
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fileIn));
			String InputString = (String) stream.readObject();
			properties.load(new StringReader(InputString.replace("\\", "\\\\")));
			stream.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			*/
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Inhalte der Properties-Datei zuweisen
		this.propUrl = properties.getProperty("url");
		this.propSep = properties.getProperty("fieldSep");
		this.propXField = properties.getProperty("xFeld");
		this.propYField = properties.getProperty("yFeld");
		this.propZiel = properties.getProperty("ort");
		// this.propZiel = propZiel.replaceAll("\\", "//");
	}
	
	public String getPropUrl() {
		return propUrl;
	}

	public void setPropUrl(String propUrl) {
		this.propUrl = propUrl;
	}

	public String getPropSep() {
		return propSep;
	}

	public void setPropSep(String propSep) {
		this.propSep = propSep;
	}

	public String getPropXField() {
		return propXField;
	}

	public void setPropXField(String propXField) {
		this.propXField = propXField;
	}

	public String getPropYField() {
		return propYField;
	}

	public void setPropYField(String propYField) {
		this.propYField = propYField;
	}

	public String getPropZiel() {
		return propZiel;
	}

	public void setPropZiel(String propZiel) {
		this.propZiel = propZiel;
	}


}