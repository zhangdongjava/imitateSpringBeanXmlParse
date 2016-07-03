package imitateSpringBeanXmlParse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SystemFileResource implements FileResource {
	private String systemPath;
	
	public SystemFileResource(String systemPath){
		this.systemPath = systemPath;
	}
	@Override
	public InputStream getInputStream() {
		try {
			return new FileInputStream(systemPath);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(systemPath+" not found!");
		}
	}

}
