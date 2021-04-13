package javapattern;

import javapattern.Logger.LogType;

abstract class Logger{
	protected Logger nextLogger;
	protected LogType logType;
	enum LogType{
		INFO_LOGGER(1),
		ERROR_LOGGER(2),
		WARN_LOGGER(3);
		
		private int logType;
		
		private LogType(int logType) {
			this.logType = logType;
		}
		
		public int getLogType() {
			return this.logType;
		}
	}
	public void setNextLogger(Logger logger) {
		this.nextLogger = logger;
	}
	abstract protected void logMessage(String message, LogType logType);
}

class InfoLogger extends Logger{
	public InfoLogger() {
		this.logType = LogType.INFO_LOGGER;
	}
	@Override
	public void logMessage(String message,LogType logType) {
		if( logType.getLogType()==this.logType.getLogType() ) {
			System.out.println("Info Message : "+message);
		}else {
			nextLogger.logMessage(message, logType);
		}
	}
}

class ErrorLogger extends Logger{
	public ErrorLogger() {
		this.logType = LogType.ERROR_LOGGER;
	}
	@Override
	public void logMessage(String message,LogType logType) {
		if( logType.getLogType()==this.logType.getLogType() ) {
			System.out.println("Error Message : "+message);
		}else {
			nextLogger.logMessage(message, logType);
		}
	}
}

public class ChainOfResponsbilityPattern {
	public static Logger doChaining() {
		InfoLogger infoLogger = new InfoLogger();
		infoLogger.setNextLogger(new ErrorLogger());
		return infoLogger;
	}
	public static void main(String[] args) {
		Logger logger = doChaining();
		logger.logMessage("RunTime Exception",LogType.ERROR_LOGGER);
		logger.logMessage("Execution Successful",LogType.INFO_LOGGER);
	}
}
