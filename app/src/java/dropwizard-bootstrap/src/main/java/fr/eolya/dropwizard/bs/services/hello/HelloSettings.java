package fr.eolya.dropwizard.bs.services.hello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import com.fasterxml.jackson.dataformat.yaml.snakeyaml.Yaml;

public class HelloSettings implements Cloneable {

	private String template;
	private String defaultName;

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	@SuppressWarnings("unchecked")
	public static HelloSettings load(String path) {
		Yaml yaml = new Yaml();
		Map<String,String> conf;

		try {
			conf = (Map<String,String>) yaml.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		HelloSettings settings = new HelloSettings();
		settings.setDefaultName((String) conf.get("defaultName"));
		settings.setTemplate((String) conf.get("template"));
		return settings;
	}

	public HelloSettings clone() {
		HelloSettings settings;
		try {
			settings = (HelloSettings) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		return settings;

	}
}