package com.common.path;

import org.springframework.stereotype.Component;

@Component
public class Path {
	public String getFirstProjectResourcePath() {
		String rootDir = System.getProperty("user.dir");
		return rootDir + "/spring-first-project/src/main/resources";
	}

	public String getFirstProjectResourceFileUploadPath() {
		String rootDir = System.getProperty("user.dir");
		return rootDir + "/spring-first-project/src/main/resources/fileUpload";
	}

	public String getParentRootPath() {
		String rootDir = System.getProperty("user.dir");
		return rootDir;
	}
}