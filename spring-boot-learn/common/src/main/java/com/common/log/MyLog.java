package com.common.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyLog {

	private Logger logger;

	public Logger getLog(Class Class) {
		return logger = LoggerFactory.getLogger(Class);
	}

	public void logStart(Class Class) {
		logger = LoggerFactory.getLogger(Class);
		logger.info("启动成功");
	}


}