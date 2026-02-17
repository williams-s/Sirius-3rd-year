// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Big Data
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package local_project.sourcetobronze_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 





@SuppressWarnings("unused")

/**
 * Job: sourcetobronze Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class sourcetobronze implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(mongo_collection_bronze != null){
				
					this.setProperty("mongo_collection_bronze", mongo_collection_bronze.toString());
				
			}
			
			if(mongo_collection_silver != null){
				
					this.setProperty("mongo_collection_silver", mongo_collection_silver.toString());
				
			}
			
			if(mongo_database != null){
				
					this.setProperty("mongo_database", mongo_database.toString());
				
			}
			
			if(mongo_player_injuries != null){
				
					this.setProperty("mongo_player_injuries", mongo_player_injuries.toString());
				
			}
			
			if(mongo_player_latest_market_value != null){
				
					this.setProperty("mongo_player_latest_market_value", mongo_player_latest_market_value.toString());
				
			}
			
			if(mongo_player_performances != null){
				
					this.setProperty("mongo_player_performances", mongo_player_performances.toString());
				
			}
			
			if(mongo_player_profiles != null){
				
					this.setProperty("mongo_player_profiles", mongo_player_profiles.toString());
				
			}
			
			if(mongo_port != null){
				
					this.setProperty("mongo_port", mongo_port.toString());
				
			}
			
			if(mongo_server != null){
				
					this.setProperty("mongo_server", mongo_server.toString());
				
			}
			
			if(mongo_team_details != null){
				
					this.setProperty("mongo_team_details", mongo_team_details.toString());
				
			}
			
			if(mongo_transfer_history != null){
				
					this.setProperty("mongo_transfer_history", mongo_transfer_history.toString());
				
			}
			
			if(postgres_database != null){
				
					this.setProperty("postgres_database", postgres_database.toString());
				
			}
			
			if(postgres_password != null){
				
					this.setProperty("postgres_password", postgres_password.toString());
				
			}
			
			if(postgres_port != null){
				
					this.setProperty("postgres_port", postgres_port.toString());
				
			}
			
			if(postgres_schema != null){
				
					this.setProperty("postgres_schema", postgres_schema.toString());
				
			}
			
			if(postgres_server != null){
				
					this.setProperty("postgres_server", postgres_server.toString());
				
			}
			
			if(postgres_table_bodytype != null){
				
					this.setProperty("postgres_table_bodytype", postgres_table_bodytype.toString());
				
			}
			
			if(postgres_table_players != null){
				
					this.setProperty("postgres_table_players", postgres_table_players.toString());
				
			}
			
			if(postgres_user != null){
				
					this.setProperty("postgres_user", postgres_user.toString());
				
			}
			
			if(source != null){
				
					this.setProperty("source", source.toString());
				
			}
			
			if(source_player_injuries != null){
				
					this.setProperty("source_player_injuries", source_player_injuries.toString());
				
			}
			
			if(source_player_latest_market_value != null){
				
					this.setProperty("source_player_latest_market_value", source_player_latest_market_value.toString());
				
			}
			
			if(source_player_performances != null){
				
					this.setProperty("source_player_performances", source_player_performances.toString());
				
			}
			
			if(source_player_profiles != null){
				
					this.setProperty("source_player_profiles", source_player_profiles.toString());
				
			}
			
			if(source_team_details != null){
				
					this.setProperty("source_team_details", source_team_details.toString());
				
			}
			
			if(source_transfer_history != null){
				
					this.setProperty("source_transfer_history", source_transfer_history.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String mongo_collection_bronze;
public String getMongo_collection_bronze(){
	return this.mongo_collection_bronze;
}
public String mongo_collection_silver;
public String getMongo_collection_silver(){
	return this.mongo_collection_silver;
}
public String mongo_database;
public String getMongo_database(){
	return this.mongo_database;
}
public String mongo_player_injuries;
public String getMongo_player_injuries(){
	return this.mongo_player_injuries;
}
public String mongo_player_latest_market_value;
public String getMongo_player_latest_market_value(){
	return this.mongo_player_latest_market_value;
}
public String mongo_player_performances;
public String getMongo_player_performances(){
	return this.mongo_player_performances;
}
public String mongo_player_profiles;
public String getMongo_player_profiles(){
	return this.mongo_player_profiles;
}
public String mongo_port;
public String getMongo_port(){
	return this.mongo_port;
}
public String mongo_server;
public String getMongo_server(){
	return this.mongo_server;
}
public String mongo_team_details;
public String getMongo_team_details(){
	return this.mongo_team_details;
}
public String mongo_transfer_history;
public String getMongo_transfer_history(){
	return this.mongo_transfer_history;
}
public String postgres_database;
public String getPostgres_database(){
	return this.postgres_database;
}
public String postgres_password;
public String getPostgres_password(){
	return this.postgres_password;
}
public String postgres_port;
public String getPostgres_port(){
	return this.postgres_port;
}
public String postgres_schema;
public String getPostgres_schema(){
	return this.postgres_schema;
}
public String postgres_server;
public String getPostgres_server(){
	return this.postgres_server;
}
public String postgres_table_bodytype;
public String getPostgres_table_bodytype(){
	return this.postgres_table_bodytype;
}
public String postgres_table_players;
public String getPostgres_table_players(){
	return this.postgres_table_players;
}
public String postgres_user;
public String getPostgres_user(){
	return this.postgres_user;
}
public String source;
public String getSource(){
	return this.source;
}
public String source_player_injuries;
public String getSource_player_injuries(){
	return this.source_player_injuries;
}
public String source_player_latest_market_value;
public String getSource_player_latest_market_value(){
	return this.source_player_latest_market_value;
}
public String source_player_performances;
public String getSource_player_performances(){
	return this.source_player_performances;
}
public String source_player_profiles;
public String getSource_player_profiles(){
	return this.source_player_profiles;
}
public String source_team_details;
public String getSource_team_details(){
	return this.source_team_details;
}
public String source_transfer_history;
public String getSource_transfer_history(){
	return this.source_transfer_history;
}
	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "sourcetobronze";
	private final String projectName = "LOCAL_PROJECT";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				sourcetobronze.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(sourcetobronze.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tMongoDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputDelimited_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputDelimited_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputDelimited_6_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tMongoDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tMongoDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBConnection_1", false);
		start_Hash.put("tMongoDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBConnection_1";

	
		int tos_count_tMongoDBConnection_1 = 0;
		

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);
        
    

final String applicationName_tMongoDBConnection_1 = "Talend";

    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBConnection_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBConnection_1=null;
    List<com.mongodb.ServerAddress> addrs_tMongoDBConnection_1 = new java.util.ArrayList<>();
    com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBConnection_1 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBConnection_1);
    com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.ClusterSettings.builder();
    com.mongodb.connection.ConnectionPoolSettings.Builder connPoolSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.ConnectionPoolSettings.builder();
    com.mongodb.connection.ServerSettings.Builder serverSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.ServerSettings.builder();
    com.mongodb.connection.SocketSettings.Builder socketSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.SocketSettings.builder();
    com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBConnection_1 = com.mongodb.connection.SslSettings.builder();



                // SSL

                // Client Credentials
                    addrs_tMongoDBConnection_1.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBConnection_1.hosts(addrs_tMongoDBConnection_1);

                clientSettingsBuilder_tMongoDBConnection_1.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBConnection_1.build()));




    mongo_tMongoDBConnection_1 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBConnection_1.build());
    resourceMap.put("mongo_tMongoDBConnection_1", mongo_tMongoDBConnection_1);
    db_tMongoDBConnection_1 = mongo_tMongoDBConnection_1.getDatabase(context.mongo_database);


    globalMap.put("mongo_tMongoDBConnection_1", mongo_tMongoDBConnection_1);
    globalMap.put("db_tMongoDBConnection_1", db_tMongoDBConnection_1);


 



/**
 * [tMongoDBConnection_1 begin ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 


	tos_count_tMongoDBConnection_1++;

/**
 * [tMongoDBConnection_1 main ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 



/**
 * [tMongoDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 



/**
 * [tMongoDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 

ok_Hash.put("tMongoDBConnection_1", true);
end_Hash.put("tMongoDBConnection_1", System.currentTimeMillis());




/**
 * [tMongoDBConnection_1 end ] stop
 */
				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tMongoDBConnection_1:OnSubjobOk1", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
								} 
							
							tFileInputDelimited_1Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tMongoDBConnection_1:OnSubjobOk2", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk2", 0, "ok");
								} 
							
							tFileInputDelimited_2Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tMongoDBConnection_1:OnSubjobOk3", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
								} 
							
							tFileInputDelimited_3Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tMongoDBConnection_1:OnSubjobOk4", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk4", 0, "ok");
								} 
							
							tFileInputDelimited_4Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tMongoDBConnection_1:OnSubjobOk5", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk5", 0, "ok");
								} 
							
							tFileInputDelimited_5Process(globalMap); 
						
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tMongoDBConnection_1:OnSubjobOk6", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
								if(execStat){    	
									runStat.updateStatOnConnection("OnSubjobOk6", 0, "ok");
								} 
							
							tFileInputDelimited_6Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tMongoDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBConnection_1";

	

 



/**
 * [tMongoDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBConnection_1_SUBPROCESS_STATE", 1);
	}
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_sourcetobronze = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[0];

	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String season_name;

				public String getSeason_name () {
					return this.season_name;
				}
				
			    public String injury_reason;

				public String getInjury_reason () {
					return this.injury_reason;
				}
				
			    public String from_date;

				public String getFrom_date () {
					return this.from_date;
				}
				
			    public String end_date;

				public String getEnd_date () {
					return this.end_date;
				}
				
			    public String days_missed;

				public String getDays_missed () {
					return this.days_missed;
				}
				
			    public String games_missed;

				public String getGames_missed () {
					return this.games_missed;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
					this.games_missed = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
					this.games_missed = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.season_name,dos);
					
					// String
				
						writeString(this.injury_reason,dos);
					
					// String
				
						writeString(this.from_date,dos);
					
					// String
				
						writeString(this.end_date,dos);
					
					// String
				
						writeString(this.days_missed,dos);
					
					// String
				
						writeString(this.games_missed,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.season_name,dos);
					
					// String
				
						writeString(this.injury_reason,dos);
					
					// String
				
						writeString(this.from_date,dos);
					
					// String
				
						writeString(this.end_date,dos);
					
					// String
				
						writeString(this.days_missed,dos);
					
					// String
				
						writeString(this.games_missed,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("player_id="+player_id);
		sb.append(",season_name="+season_name);
		sb.append(",injury_reason="+injury_reason);
		sb.append(",from_date="+from_date);
		sb.append(",end_date="+end_date);
		sb.append(",days_missed="+days_missed);
		sb.append(",games_missed="+games_missed);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();




	
	/**
	 * [tMongoDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_1", false);
		start_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMongoDBOutput_1 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_1 = "Talend";

    int nb_line_tMongoDBOutput_1 = 0;

			class DBObjectUtil_tMongoDBOutput_1 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_1 updateObjectUtil_tMongoDBOutput_1=new DBObjectUtil_tMongoDBOutput_1();
            DBObjectUtil_tMongoDBOutput_1 queryObjectUtil_tMongoDBOutput_1=new DBObjectUtil_tMongoDBOutput_1();
            java.util.Map<String, String> pathMap_tMongoDBOutput_1=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_1.put("player_id","");
                pathMap_tMongoDBOutput_1.put("season_name","");
                pathMap_tMongoDBOutput_1.put("injury_reason","");
                pathMap_tMongoDBOutput_1.put("from_date","");
                pathMap_tMongoDBOutput_1.put("end_date","");
                pathMap_tMongoDBOutput_1.put("days_missed","");
                pathMap_tMongoDBOutput_1.put("games_missed","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_1=null;

        mongo_tMongoDBOutput_1=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_1 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_1.getCollection(context.mongo_player_injuries).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_1 = db_tMongoDBOutput_1.getCollection(context.mongo_player_injuries);


 



/**
 * [tMongoDBOutput_1 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_1", false);
		start_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_1";

	
		int tos_count_tFileInputDelimited_1 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_1 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_1 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_1 = null;
				int limit_tFileInputDelimited_1 = -1;
				try{
					
						Object filename_tFileInputDelimited_1 = context.source_player_injuries;
						if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
			if(footer_value_tFileInputDelimited_1 >0 || random_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited(context.source_player_injuries, "UTF-8",",","\n",true,1,0,
									limit_tFileInputDelimited_1
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_1!=null && fid_tFileInputDelimited_1.nextRecord()) {
						rowstate_tFileInputDelimited_1.reset();
						
			    						row1 = null;			
												
									boolean whetherReject_tFileInputDelimited_1 = false;
									row1 = new row1Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_1 = 0;
				
					columnIndexWithD_tFileInputDelimited_1 = 0;
					
							row1.player_id = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 1;
					
							row1.season_name = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 2;
					
							row1.injury_reason = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 3;
					
							row1.from_date = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 4;
					
							row1.end_date = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 5;
					
							row1.days_missed = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 6;
					
							row1.games_missed = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
				
										
										if(rowstate_tFileInputDelimited_1.getException()!=null) {
											throw rowstate_tFileInputDelimited_1.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_1_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_1 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row1 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_1 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 


	tos_count_tFileInputDelimited_1++;

/**
 * [tFileInputDelimited_1 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tMongoDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_1.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("player_id"),"player_id", row1.player_id);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("season_name"),"season_name", row1.season_name);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("injury_reason"),"injury_reason", row1.injury_reason);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("from_date"),"from_date", row1.from_date);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("end_date"),"end_date", row1.end_date);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("days_missed"),"days_missed", row1.days_missed);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("games_missed"),"games_missed", row1.games_missed);
				org.bson.Document updateObj_tMongoDBOutput_1 = updateObjectUtil_tMongoDBOutput_1.getObject();
				
						coll_tMongoDBOutput_1.insertOne(updateObj_tMongoDBOutput_1);
					
				} catch (Exception e_tMongoDBOutput_1) {
				
    					
    						System.err.println(e_tMongoDBOutput_1.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_1 ++;
				
 


	tos_count_tMongoDBOutput_1++;

/**
 * [tMongoDBOutput_1 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

 



/**
 * [tMongoDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

 



/**
 * [tMongoDBOutput_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputDelimited_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_1 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	



            }
            }finally{
                if(!((Object)(context.source_player_injuries) instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_1!=null){
                		fid_tFileInputDelimited_1.close();
                	}
                }
                if(fid_tFileInputDelimited_1!=null){
                	globalMap.put("tFileInputDelimited_1_NB_LINE", fid_tFileInputDelimited_1.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_1", true);
end_Hash.put("tFileInputDelimited_1", System.currentTimeMillis());




/**
 * [tFileInputDelimited_1 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

	globalMap.put("tMongoDBOutput_1_NB_LINE", nb_line_tMongoDBOutput_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_1", true);
end_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());




/**
 * [tMongoDBOutput_1 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_1 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_1";

	

 



/**
 * [tFileInputDelimited_1 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	


 



/**
 * [tMongoDBOutput_1 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_sourcetobronze = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[0];

	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String date_unix;

				public String getDate_unix () {
					return this.date_unix;
				}
				
			    public String value;

				public String getValue () {
					return this.value;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.date_unix = readString(dis);
					
					this.value = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.date_unix = readString(dis);
					
					this.value = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.date_unix,dos);
					
					// String
				
						writeString(this.value,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.date_unix,dos);
					
					// String
				
						writeString(this.value,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("player_id="+player_id);
		sb.append(",date_unix="+date_unix);
		sb.append(",value="+value);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tMongoDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_2", false);
		start_Hash.put("tMongoDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMongoDBOutput_2 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_2 = "Talend";

    int nb_line_tMongoDBOutput_2 = 0;

			class DBObjectUtil_tMongoDBOutput_2 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_2 updateObjectUtil_tMongoDBOutput_2=new DBObjectUtil_tMongoDBOutput_2();
            DBObjectUtil_tMongoDBOutput_2 queryObjectUtil_tMongoDBOutput_2=new DBObjectUtil_tMongoDBOutput_2();
            java.util.Map<String, String> pathMap_tMongoDBOutput_2=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_2.put("player_id","");
                pathMap_tMongoDBOutput_2.put("date_unix","");
                pathMap_tMongoDBOutput_2.put("value","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_2=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_2=null;

        mongo_tMongoDBOutput_2=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_2 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_2.getCollection(context.mongo_player_latest_market_value).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_2 = db_tMongoDBOutput_2.getCollection(context.mongo_player_latest_market_value);


 



/**
 * [tMongoDBOutput_2 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_2", false);
		start_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_2";

	
		int tos_count_tFileInputDelimited_2 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_2 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_2 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_2 = null;
				int limit_tFileInputDelimited_2 = -1;
				try{
					
						Object filename_tFileInputDelimited_2 = context.source_player_latest_market_value;
						if(filename_tFileInputDelimited_2 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_2 = 0, random_value_tFileInputDelimited_2 = -1;
			if(footer_value_tFileInputDelimited_2 >0 || random_value_tFileInputDelimited_2 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_2 = new org.talend.fileprocess.FileInputDelimited(context.source_player_latest_market_value, "UTF-8",",","\n",true,1,0,
									limit_tFileInputDelimited_2
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_2!=null && fid_tFileInputDelimited_2.nextRecord()) {
						rowstate_tFileInputDelimited_2.reset();
						
			    						row2 = null;			
												
									boolean whetherReject_tFileInputDelimited_2 = false;
									row2 = new row2Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_2 = 0;
				
					columnIndexWithD_tFileInputDelimited_2 = 0;
					
							row2.player_id = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 1;
					
							row2.date_unix = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
					columnIndexWithD_tFileInputDelimited_2 = 2;
					
							row2.value = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
						
				
				
										
										if(rowstate_tFileInputDelimited_2.getException()!=null) {
											throw rowstate_tFileInputDelimited_2.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_2 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row2 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_2 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 


	tos_count_tFileInputDelimited_2++;

/**
 * [tFileInputDelimited_2 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 process_data_begin ] stop
 */
// Start of branch "row2"
if(row2 != null) { 



	
	/**
	 * [tMongoDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_2.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("player_id"),"player_id", row2.player_id);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("date_unix"),"date_unix", row2.date_unix);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("value"),"value", row2.value);
				org.bson.Document updateObj_tMongoDBOutput_2 = updateObjectUtil_tMongoDBOutput_2.getObject();
				
						coll_tMongoDBOutput_2.insertOne(updateObj_tMongoDBOutput_2);
					
				} catch (Exception e_tMongoDBOutput_2) {
				
    					
    						System.err.println(e_tMongoDBOutput_2.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_2 ++;
				
 


	tos_count_tMongoDBOutput_2++;

/**
 * [tMongoDBOutput_2 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

 



/**
 * [tMongoDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

 



/**
 * [tMongoDBOutput_2 process_data_end ] stop
 */

} // End of branch "row2"




	
	/**
	 * [tFileInputDelimited_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_2 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	



            }
            }finally{
                if(!((Object)(context.source_player_latest_market_value) instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_2!=null){
                		fid_tFileInputDelimited_2.close();
                	}
                }
                if(fid_tFileInputDelimited_2!=null){
                	globalMap.put("tFileInputDelimited_2_NB_LINE", fid_tFileInputDelimited_2.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_2", true);
end_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());




/**
 * [tFileInputDelimited_2 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

	globalMap.put("tMongoDBOutput_2_NB_LINE", nb_line_tMongoDBOutput_2);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_2", true);
end_Hash.put("tMongoDBOutput_2", System.currentTimeMillis());




/**
 * [tMongoDBOutput_2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_2";

	

 



/**
 * [tFileInputDelimited_2 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	


 



/**
 * [tMongoDBOutput_2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_sourcetobronze = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[0];

	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String season_name;

				public String getSeason_name () {
					return this.season_name;
				}
				
			    public String competition_id;

				public String getCompetition_id () {
					return this.competition_id;
				}
				
			    public String competition_name;

				public String getCompetition_name () {
					return this.competition_name;
				}
				
			    public String team_id;

				public String getTeam_id () {
					return this.team_id;
				}
				
			    public String team_name;

				public String getTeam_name () {
					return this.team_name;
				}
				
			    public String nb_in_group;

				public String getNb_in_group () {
					return this.nb_in_group;
				}
				
			    public String nb_on_pitch;

				public String getNb_on_pitch () {
					return this.nb_on_pitch;
				}
				
			    public String goals;

				public String getGoals () {
					return this.goals;
				}
				
			    public String assists;

				public String getAssists () {
					return this.assists;
				}
				
			    public String own_goals;

				public String getOwn_goals () {
					return this.own_goals;
				}
				
			    public String subed_in;

				public String getSubed_in () {
					return this.subed_in;
				}
				
			    public String subed_out;

				public String getSubed_out () {
					return this.subed_out;
				}
				
			    public String yellow_cards;

				public String getYellow_cards () {
					return this.yellow_cards;
				}
				
			    public String second_yellow_cards;

				public String getSecond_yellow_cards () {
					return this.second_yellow_cards;
				}
				
			    public String direct_red_cards;

				public String getDirect_red_cards () {
					return this.direct_red_cards;
				}
				
			    public String penalty_goals;

				public String getPenalty_goals () {
					return this.penalty_goals;
				}
				
			    public String minutes_played;

				public String getMinutes_played () {
					return this.minutes_played;
				}
				
			    public String goals_conceded;

				public String getGoals_conceded () {
					return this.goals_conceded;
				}
				
			    public String clean_sheets;

				public String getClean_sheets () {
					return this.clean_sheets;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.competition_id = readString(dis);
					
					this.competition_name = readString(dis);
					
					this.team_id = readString(dis);
					
					this.team_name = readString(dis);
					
					this.nb_in_group = readString(dis);
					
					this.nb_on_pitch = readString(dis);
					
					this.goals = readString(dis);
					
					this.assists = readString(dis);
					
					this.own_goals = readString(dis);
					
					this.subed_in = readString(dis);
					
					this.subed_out = readString(dis);
					
					this.yellow_cards = readString(dis);
					
					this.second_yellow_cards = readString(dis);
					
					this.direct_red_cards = readString(dis);
					
					this.penalty_goals = readString(dis);
					
					this.minutes_played = readString(dis);
					
					this.goals_conceded = readString(dis);
					
					this.clean_sheets = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.competition_id = readString(dis);
					
					this.competition_name = readString(dis);
					
					this.team_id = readString(dis);
					
					this.team_name = readString(dis);
					
					this.nb_in_group = readString(dis);
					
					this.nb_on_pitch = readString(dis);
					
					this.goals = readString(dis);
					
					this.assists = readString(dis);
					
					this.own_goals = readString(dis);
					
					this.subed_in = readString(dis);
					
					this.subed_out = readString(dis);
					
					this.yellow_cards = readString(dis);
					
					this.second_yellow_cards = readString(dis);
					
					this.direct_red_cards = readString(dis);
					
					this.penalty_goals = readString(dis);
					
					this.minutes_played = readString(dis);
					
					this.goals_conceded = readString(dis);
					
					this.clean_sheets = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.season_name,dos);
					
					// String
				
						writeString(this.competition_id,dos);
					
					// String
				
						writeString(this.competition_name,dos);
					
					// String
				
						writeString(this.team_id,dos);
					
					// String
				
						writeString(this.team_name,dos);
					
					// String
				
						writeString(this.nb_in_group,dos);
					
					// String
				
						writeString(this.nb_on_pitch,dos);
					
					// String
				
						writeString(this.goals,dos);
					
					// String
				
						writeString(this.assists,dos);
					
					// String
				
						writeString(this.own_goals,dos);
					
					// String
				
						writeString(this.subed_in,dos);
					
					// String
				
						writeString(this.subed_out,dos);
					
					// String
				
						writeString(this.yellow_cards,dos);
					
					// String
				
						writeString(this.second_yellow_cards,dos);
					
					// String
				
						writeString(this.direct_red_cards,dos);
					
					// String
				
						writeString(this.penalty_goals,dos);
					
					// String
				
						writeString(this.minutes_played,dos);
					
					// String
				
						writeString(this.goals_conceded,dos);
					
					// String
				
						writeString(this.clean_sheets,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.season_name,dos);
					
					// String
				
						writeString(this.competition_id,dos);
					
					// String
				
						writeString(this.competition_name,dos);
					
					// String
				
						writeString(this.team_id,dos);
					
					// String
				
						writeString(this.team_name,dos);
					
					// String
				
						writeString(this.nb_in_group,dos);
					
					// String
				
						writeString(this.nb_on_pitch,dos);
					
					// String
				
						writeString(this.goals,dos);
					
					// String
				
						writeString(this.assists,dos);
					
					// String
				
						writeString(this.own_goals,dos);
					
					// String
				
						writeString(this.subed_in,dos);
					
					// String
				
						writeString(this.subed_out,dos);
					
					// String
				
						writeString(this.yellow_cards,dos);
					
					// String
				
						writeString(this.second_yellow_cards,dos);
					
					// String
				
						writeString(this.direct_red_cards,dos);
					
					// String
				
						writeString(this.penalty_goals,dos);
					
					// String
				
						writeString(this.minutes_played,dos);
					
					// String
				
						writeString(this.goals_conceded,dos);
					
					// String
				
						writeString(this.clean_sheets,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("player_id="+player_id);
		sb.append(",season_name="+season_name);
		sb.append(",competition_id="+competition_id);
		sb.append(",competition_name="+competition_name);
		sb.append(",team_id="+team_id);
		sb.append(",team_name="+team_name);
		sb.append(",nb_in_group="+nb_in_group);
		sb.append(",nb_on_pitch="+nb_on_pitch);
		sb.append(",goals="+goals);
		sb.append(",assists="+assists);
		sb.append(",own_goals="+own_goals);
		sb.append(",subed_in="+subed_in);
		sb.append(",subed_out="+subed_out);
		sb.append(",yellow_cards="+yellow_cards);
		sb.append(",second_yellow_cards="+second_yellow_cards);
		sb.append(",direct_red_cards="+direct_red_cards);
		sb.append(",penalty_goals="+penalty_goals);
		sb.append(",minutes_played="+minutes_played);
		sb.append(",goals_conceded="+goals_conceded);
		sb.append(",clean_sheets="+clean_sheets);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row3Struct row3 = new row3Struct();




	
	/**
	 * [tMongoDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_3", false);
		start_Hash.put("tMongoDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tMongoDBOutput_3 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_3 = "Talend";

    int nb_line_tMongoDBOutput_3 = 0;

			class DBObjectUtil_tMongoDBOutput_3 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_3 updateObjectUtil_tMongoDBOutput_3=new DBObjectUtil_tMongoDBOutput_3();
            DBObjectUtil_tMongoDBOutput_3 queryObjectUtil_tMongoDBOutput_3=new DBObjectUtil_tMongoDBOutput_3();
            java.util.Map<String, String> pathMap_tMongoDBOutput_3=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_3.put("player_id","");
                pathMap_tMongoDBOutput_3.put("season_name","");
                pathMap_tMongoDBOutput_3.put("competition_id","");
                pathMap_tMongoDBOutput_3.put("competition_name","");
                pathMap_tMongoDBOutput_3.put("team_id","");
                pathMap_tMongoDBOutput_3.put("team_name","");
                pathMap_tMongoDBOutput_3.put("nb_in_group","");
                pathMap_tMongoDBOutput_3.put("nb_on_pitch","");
                pathMap_tMongoDBOutput_3.put("goals","");
                pathMap_tMongoDBOutput_3.put("assists","");
                pathMap_tMongoDBOutput_3.put("own_goals","");
                pathMap_tMongoDBOutput_3.put("subed_in","");
                pathMap_tMongoDBOutput_3.put("subed_out","");
                pathMap_tMongoDBOutput_3.put("yellow_cards","");
                pathMap_tMongoDBOutput_3.put("second_yellow_cards","");
                pathMap_tMongoDBOutput_3.put("direct_red_cards","");
                pathMap_tMongoDBOutput_3.put("penalty_goals","");
                pathMap_tMongoDBOutput_3.put("minutes_played","");
                pathMap_tMongoDBOutput_3.put("goals_conceded","");
                pathMap_tMongoDBOutput_3.put("clean_sheets","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_3=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_3=null;

        mongo_tMongoDBOutput_3=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_3 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_3.getCollection(context.mongo_player_performances).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_3 = db_tMongoDBOutput_3.getCollection(context.mongo_player_performances);


 



/**
 * [tMongoDBOutput_3 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_3", false);
		start_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_3";

	
		int tos_count_tFileInputDelimited_3 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_3 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_3 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_3 = null;
				int limit_tFileInputDelimited_3 = -1;
				try{
					
						Object filename_tFileInputDelimited_3 = context.source_player_performances;
						if(filename_tFileInputDelimited_3 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_3 = 0, random_value_tFileInputDelimited_3 = -1;
			if(footer_value_tFileInputDelimited_3 >0 || random_value_tFileInputDelimited_3 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_3 = new org.talend.fileprocess.FileInputDelimited(context.source_player_performances, "UTF-8",",","\n",true,1,0,
									limit_tFileInputDelimited_3
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_3!=null && fid_tFileInputDelimited_3.nextRecord()) {
						rowstate_tFileInputDelimited_3.reset();
						
			    						row3 = null;			
												
									boolean whetherReject_tFileInputDelimited_3 = false;
									row3 = new row3Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_3 = 0;
				
					columnIndexWithD_tFileInputDelimited_3 = 0;
					
							row3.player_id = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 1;
					
							row3.season_name = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 2;
					
							row3.competition_id = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 3;
					
							row3.competition_name = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 4;
					
							row3.team_id = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 5;
					
							row3.team_name = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 6;
					
							row3.nb_in_group = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 7;
					
							row3.nb_on_pitch = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 8;
					
							row3.goals = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 9;
					
							row3.assists = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 10;
					
							row3.own_goals = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 11;
					
							row3.subed_in = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 12;
					
							row3.subed_out = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 13;
					
							row3.yellow_cards = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 14;
					
							row3.second_yellow_cards = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 15;
					
							row3.direct_red_cards = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 16;
					
							row3.penalty_goals = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 17;
					
							row3.minutes_played = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 18;
					
							row3.goals_conceded = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
					columnIndexWithD_tFileInputDelimited_3 = 19;
					
							row3.clean_sheets = fid_tFileInputDelimited_3.get(columnIndexWithD_tFileInputDelimited_3);
						
				
				
										
										if(rowstate_tFileInputDelimited_3.getException()!=null) {
											throw rowstate_tFileInputDelimited_3.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_3_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_3 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row3 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_3 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 


	tos_count_tFileInputDelimited_3++;

/**
 * [tFileInputDelimited_3 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 process_data_begin ] stop
 */
// Start of branch "row3"
if(row3 != null) { 



	
	/**
	 * [tMongoDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_3.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("player_id"),"player_id", row3.player_id);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("season_name"),"season_name", row3.season_name);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("competition_id"),"competition_id", row3.competition_id);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("competition_name"),"competition_name", row3.competition_name);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("team_id"),"team_id", row3.team_id);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("team_name"),"team_name", row3.team_name);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("nb_in_group"),"nb_in_group", row3.nb_in_group);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("nb_on_pitch"),"nb_on_pitch", row3.nb_on_pitch);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("goals"),"goals", row3.goals);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("assists"),"assists", row3.assists);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("own_goals"),"own_goals", row3.own_goals);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("subed_in"),"subed_in", row3.subed_in);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("subed_out"),"subed_out", row3.subed_out);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("yellow_cards"),"yellow_cards", row3.yellow_cards);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("second_yellow_cards"),"second_yellow_cards", row3.second_yellow_cards);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("direct_red_cards"),"direct_red_cards", row3.direct_red_cards);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("penalty_goals"),"penalty_goals", row3.penalty_goals);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("minutes_played"),"minutes_played", row3.minutes_played);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("goals_conceded"),"goals_conceded", row3.goals_conceded);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("clean_sheets"),"clean_sheets", row3.clean_sheets);
				org.bson.Document updateObj_tMongoDBOutput_3 = updateObjectUtil_tMongoDBOutput_3.getObject();
				
						coll_tMongoDBOutput_3.insertOne(updateObj_tMongoDBOutput_3);
					
				} catch (Exception e_tMongoDBOutput_3) {
				
    					
    						System.err.println(e_tMongoDBOutput_3.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_3 ++;
				
 


	tos_count_tMongoDBOutput_3++;

/**
 * [tMongoDBOutput_3 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	

 



/**
 * [tMongoDBOutput_3 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	

 



/**
 * [tMongoDBOutput_3 process_data_end ] stop
 */

} // End of branch "row3"




	
	/**
	 * [tFileInputDelimited_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_3 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	



            }
            }finally{
                if(!((Object)(context.source_player_performances) instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_3!=null){
                		fid_tFileInputDelimited_3.close();
                	}
                }
                if(fid_tFileInputDelimited_3!=null){
                	globalMap.put("tFileInputDelimited_3_NB_LINE", fid_tFileInputDelimited_3.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_3", true);
end_Hash.put("tFileInputDelimited_3", System.currentTimeMillis());




/**
 * [tFileInputDelimited_3 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	

	globalMap.put("tMongoDBOutput_3_NB_LINE", nb_line_tMongoDBOutput_3);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_3", true);
end_Hash.put("tMongoDBOutput_3", System.currentTimeMillis());




/**
 * [tMongoDBOutput_3 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_3 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_3";

	

 



/**
 * [tFileInputDelimited_3 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	


 



/**
 * [tMongoDBOutput_3 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_3_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_sourcetobronze = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[0];

	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String player_slug;

				public String getPlayer_slug () {
					return this.player_slug;
				}
				
			    public String player_name;

				public String getPlayer_name () {
					return this.player_name;
				}
				
			    public String player_image_url;

				public String getPlayer_image_url () {
					return this.player_image_url;
				}
				
			    public String date_of_birth;

				public String getDate_of_birth () {
					return this.date_of_birth;
				}
				
			    public String place_of_birth;

				public String getPlace_of_birth () {
					return this.place_of_birth;
				}
				
			    public String country_of_birth;

				public String getCountry_of_birth () {
					return this.country_of_birth;
				}
				
			    public String height;

				public String getHeight () {
					return this.height;
				}
				
			    public String citizenship;

				public String getCitizenship () {
					return this.citizenship;
				}
				
			    public String is_eu;

				public String getIs_eu () {
					return this.is_eu;
				}
				
			    public String position;

				public String getPosition () {
					return this.position;
				}
				
			    public String main_position;

				public String getMain_position () {
					return this.main_position;
				}
				
			    public String foot;

				public String getFoot () {
					return this.foot;
				}
				
			    public String current_club_id;

				public String getCurrent_club_id () {
					return this.current_club_id;
				}
				
			    public String current_club_name;

				public String getCurrent_club_name () {
					return this.current_club_name;
				}
				
			    public String joined;

				public String getJoined () {
					return this.joined;
				}
				
			    public String contract_expires;

				public String getContract_expires () {
					return this.contract_expires;
				}
				
			    public String outfitter;

				public String getOutfitter () {
					return this.outfitter;
				}
				
			    public String social_media_url;

				public String getSocial_media_url () {
					return this.social_media_url;
				}
				
			    public String player_agent_id;

				public String getPlayer_agent_id () {
					return this.player_agent_id;
				}
				
			    public String player_agent_name;

				public String getPlayer_agent_name () {
					return this.player_agent_name;
				}
				
			    public String contract_option;

				public String getContract_option () {
					return this.contract_option;
				}
				
			    public String date_of_last_contract_extension;

				public String getDate_of_last_contract_extension () {
					return this.date_of_last_contract_extension;
				}
				
			    public String on_loan_from_club_id;

				public String getOn_loan_from_club_id () {
					return this.on_loan_from_club_id;
				}
				
			    public String on_loan_from_club_name;

				public String getOn_loan_from_club_name () {
					return this.on_loan_from_club_name;
				}
				
			    public String contract_there_expires;

				public String getContract_there_expires () {
					return this.contract_there_expires;
				}
				
			    public String second_club_url;

				public String getSecond_club_url () {
					return this.second_club_url;
				}
				
			    public String second_club_name;

				public String getSecond_club_name () {
					return this.second_club_name;
				}
				
			    public String third_club_url;

				public String getThird_club_url () {
					return this.third_club_url;
				}
				
			    public String third_club_name;

				public String getThird_club_name () {
					return this.third_club_name;
				}
				
			    public String fourth_club_url;

				public String getFourth_club_url () {
					return this.fourth_club_url;
				}
				
			    public String fourth_club_name;

				public String getFourth_club_name () {
					return this.fourth_club_name;
				}
				
			    public String date_of_death;

				public String getDate_of_death () {
					return this.date_of_death;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.player_slug = readString(dis);
					
					this.player_name = readString(dis);
					
					this.player_image_url = readString(dis);
					
					this.date_of_birth = readString(dis);
					
					this.place_of_birth = readString(dis);
					
					this.country_of_birth = readString(dis);
					
					this.height = readString(dis);
					
					this.citizenship = readString(dis);
					
					this.is_eu = readString(dis);
					
					this.position = readString(dis);
					
					this.main_position = readString(dis);
					
					this.foot = readString(dis);
					
					this.current_club_id = readString(dis);
					
					this.current_club_name = readString(dis);
					
					this.joined = readString(dis);
					
					this.contract_expires = readString(dis);
					
					this.outfitter = readString(dis);
					
					this.social_media_url = readString(dis);
					
					this.player_agent_id = readString(dis);
					
					this.player_agent_name = readString(dis);
					
					this.contract_option = readString(dis);
					
					this.date_of_last_contract_extension = readString(dis);
					
					this.on_loan_from_club_id = readString(dis);
					
					this.on_loan_from_club_name = readString(dis);
					
					this.contract_there_expires = readString(dis);
					
					this.second_club_url = readString(dis);
					
					this.second_club_name = readString(dis);
					
					this.third_club_url = readString(dis);
					
					this.third_club_name = readString(dis);
					
					this.fourth_club_url = readString(dis);
					
					this.fourth_club_name = readString(dis);
					
					this.date_of_death = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.player_slug = readString(dis);
					
					this.player_name = readString(dis);
					
					this.player_image_url = readString(dis);
					
					this.date_of_birth = readString(dis);
					
					this.place_of_birth = readString(dis);
					
					this.country_of_birth = readString(dis);
					
					this.height = readString(dis);
					
					this.citizenship = readString(dis);
					
					this.is_eu = readString(dis);
					
					this.position = readString(dis);
					
					this.main_position = readString(dis);
					
					this.foot = readString(dis);
					
					this.current_club_id = readString(dis);
					
					this.current_club_name = readString(dis);
					
					this.joined = readString(dis);
					
					this.contract_expires = readString(dis);
					
					this.outfitter = readString(dis);
					
					this.social_media_url = readString(dis);
					
					this.player_agent_id = readString(dis);
					
					this.player_agent_name = readString(dis);
					
					this.contract_option = readString(dis);
					
					this.date_of_last_contract_extension = readString(dis);
					
					this.on_loan_from_club_id = readString(dis);
					
					this.on_loan_from_club_name = readString(dis);
					
					this.contract_there_expires = readString(dis);
					
					this.second_club_url = readString(dis);
					
					this.second_club_name = readString(dis);
					
					this.third_club_url = readString(dis);
					
					this.third_club_name = readString(dis);
					
					this.fourth_club_url = readString(dis);
					
					this.fourth_club_name = readString(dis);
					
					this.date_of_death = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.player_slug,dos);
					
					// String
				
						writeString(this.player_name,dos);
					
					// String
				
						writeString(this.player_image_url,dos);
					
					// String
				
						writeString(this.date_of_birth,dos);
					
					// String
				
						writeString(this.place_of_birth,dos);
					
					// String
				
						writeString(this.country_of_birth,dos);
					
					// String
				
						writeString(this.height,dos);
					
					// String
				
						writeString(this.citizenship,dos);
					
					// String
				
						writeString(this.is_eu,dos);
					
					// String
				
						writeString(this.position,dos);
					
					// String
				
						writeString(this.main_position,dos);
					
					// String
				
						writeString(this.foot,dos);
					
					// String
				
						writeString(this.current_club_id,dos);
					
					// String
				
						writeString(this.current_club_name,dos);
					
					// String
				
						writeString(this.joined,dos);
					
					// String
				
						writeString(this.contract_expires,dos);
					
					// String
				
						writeString(this.outfitter,dos);
					
					// String
				
						writeString(this.social_media_url,dos);
					
					// String
				
						writeString(this.player_agent_id,dos);
					
					// String
				
						writeString(this.player_agent_name,dos);
					
					// String
				
						writeString(this.contract_option,dos);
					
					// String
				
						writeString(this.date_of_last_contract_extension,dos);
					
					// String
				
						writeString(this.on_loan_from_club_id,dos);
					
					// String
				
						writeString(this.on_loan_from_club_name,dos);
					
					// String
				
						writeString(this.contract_there_expires,dos);
					
					// String
				
						writeString(this.second_club_url,dos);
					
					// String
				
						writeString(this.second_club_name,dos);
					
					// String
				
						writeString(this.third_club_url,dos);
					
					// String
				
						writeString(this.third_club_name,dos);
					
					// String
				
						writeString(this.fourth_club_url,dos);
					
					// String
				
						writeString(this.fourth_club_name,dos);
					
					// String
				
						writeString(this.date_of_death,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.player_slug,dos);
					
					// String
				
						writeString(this.player_name,dos);
					
					// String
				
						writeString(this.player_image_url,dos);
					
					// String
				
						writeString(this.date_of_birth,dos);
					
					// String
				
						writeString(this.place_of_birth,dos);
					
					// String
				
						writeString(this.country_of_birth,dos);
					
					// String
				
						writeString(this.height,dos);
					
					// String
				
						writeString(this.citizenship,dos);
					
					// String
				
						writeString(this.is_eu,dos);
					
					// String
				
						writeString(this.position,dos);
					
					// String
				
						writeString(this.main_position,dos);
					
					// String
				
						writeString(this.foot,dos);
					
					// String
				
						writeString(this.current_club_id,dos);
					
					// String
				
						writeString(this.current_club_name,dos);
					
					// String
				
						writeString(this.joined,dos);
					
					// String
				
						writeString(this.contract_expires,dos);
					
					// String
				
						writeString(this.outfitter,dos);
					
					// String
				
						writeString(this.social_media_url,dos);
					
					// String
				
						writeString(this.player_agent_id,dos);
					
					// String
				
						writeString(this.player_agent_name,dos);
					
					// String
				
						writeString(this.contract_option,dos);
					
					// String
				
						writeString(this.date_of_last_contract_extension,dos);
					
					// String
				
						writeString(this.on_loan_from_club_id,dos);
					
					// String
				
						writeString(this.on_loan_from_club_name,dos);
					
					// String
				
						writeString(this.contract_there_expires,dos);
					
					// String
				
						writeString(this.second_club_url,dos);
					
					// String
				
						writeString(this.second_club_name,dos);
					
					// String
				
						writeString(this.third_club_url,dos);
					
					// String
				
						writeString(this.third_club_name,dos);
					
					// String
				
						writeString(this.fourth_club_url,dos);
					
					// String
				
						writeString(this.fourth_club_name,dos);
					
					// String
				
						writeString(this.date_of_death,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("player_id="+player_id);
		sb.append(",player_slug="+player_slug);
		sb.append(",player_name="+player_name);
		sb.append(",player_image_url="+player_image_url);
		sb.append(",date_of_birth="+date_of_birth);
		sb.append(",place_of_birth="+place_of_birth);
		sb.append(",country_of_birth="+country_of_birth);
		sb.append(",height="+height);
		sb.append(",citizenship="+citizenship);
		sb.append(",is_eu="+is_eu);
		sb.append(",position="+position);
		sb.append(",main_position="+main_position);
		sb.append(",foot="+foot);
		sb.append(",current_club_id="+current_club_id);
		sb.append(",current_club_name="+current_club_name);
		sb.append(",joined="+joined);
		sb.append(",contract_expires="+contract_expires);
		sb.append(",outfitter="+outfitter);
		sb.append(",social_media_url="+social_media_url);
		sb.append(",player_agent_id="+player_agent_id);
		sb.append(",player_agent_name="+player_agent_name);
		sb.append(",contract_option="+contract_option);
		sb.append(",date_of_last_contract_extension="+date_of_last_contract_extension);
		sb.append(",on_loan_from_club_id="+on_loan_from_club_id);
		sb.append(",on_loan_from_club_name="+on_loan_from_club_name);
		sb.append(",contract_there_expires="+contract_there_expires);
		sb.append(",second_club_url="+second_club_url);
		sb.append(",second_club_name="+second_club_name);
		sb.append(",third_club_url="+third_club_url);
		sb.append(",third_club_name="+third_club_name);
		sb.append(",fourth_club_url="+fourth_club_url);
		sb.append(",fourth_club_name="+fourth_club_name);
		sb.append(",date_of_death="+date_of_death);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row4Struct row4 = new row4Struct();




	
	/**
	 * [tMongoDBOutput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_4", false);
		start_Hash.put("tMongoDBOutput_4", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tMongoDBOutput_4 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_4 = "Talend";

    int nb_line_tMongoDBOutput_4 = 0;

			class DBObjectUtil_tMongoDBOutput_4 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_4 updateObjectUtil_tMongoDBOutput_4=new DBObjectUtil_tMongoDBOutput_4();
            DBObjectUtil_tMongoDBOutput_4 queryObjectUtil_tMongoDBOutput_4=new DBObjectUtil_tMongoDBOutput_4();
            java.util.Map<String, String> pathMap_tMongoDBOutput_4=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_4.put("player_id","");
                pathMap_tMongoDBOutput_4.put("player_slug","");
                pathMap_tMongoDBOutput_4.put("player_name","");
                pathMap_tMongoDBOutput_4.put("player_image_url","");
                pathMap_tMongoDBOutput_4.put("date_of_birth","");
                pathMap_tMongoDBOutput_4.put("place_of_birth","");
                pathMap_tMongoDBOutput_4.put("country_of_birth","");
                pathMap_tMongoDBOutput_4.put("height","");
                pathMap_tMongoDBOutput_4.put("citizenship","");
                pathMap_tMongoDBOutput_4.put("is_eu","");
                pathMap_tMongoDBOutput_4.put("position","");
                pathMap_tMongoDBOutput_4.put("main_position","");
                pathMap_tMongoDBOutput_4.put("foot","");
                pathMap_tMongoDBOutput_4.put("current_club_id","");
                pathMap_tMongoDBOutput_4.put("current_club_name","");
                pathMap_tMongoDBOutput_4.put("joined","");
                pathMap_tMongoDBOutput_4.put("contract_expires","");
                pathMap_tMongoDBOutput_4.put("outfitter","");
                pathMap_tMongoDBOutput_4.put("social_media_url","");
                pathMap_tMongoDBOutput_4.put("player_agent_id","");
                pathMap_tMongoDBOutput_4.put("player_agent_name","");
                pathMap_tMongoDBOutput_4.put("contract_option","");
                pathMap_tMongoDBOutput_4.put("date_of_last_contract_extension","");
                pathMap_tMongoDBOutput_4.put("on_loan_from_club_id","");
                pathMap_tMongoDBOutput_4.put("on_loan_from_club_name","");
                pathMap_tMongoDBOutput_4.put("contract_there_expires","");
                pathMap_tMongoDBOutput_4.put("second_club_url","");
                pathMap_tMongoDBOutput_4.put("second_club_name","");
                pathMap_tMongoDBOutput_4.put("third_club_url","");
                pathMap_tMongoDBOutput_4.put("third_club_name","");
                pathMap_tMongoDBOutput_4.put("fourth_club_url","");
                pathMap_tMongoDBOutput_4.put("fourth_club_name","");
                pathMap_tMongoDBOutput_4.put("date_of_death","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_4=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_4=null;

        mongo_tMongoDBOutput_4=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_4 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_4.getCollection(context.mongo_player_profiles).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_4 = db_tMongoDBOutput_4.getCollection(context.mongo_player_profiles);


 



/**
 * [tMongoDBOutput_4 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_4", false);
		start_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_4";

	
		int tos_count_tFileInputDelimited_4 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_4 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_4 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_4 = null;
				int limit_tFileInputDelimited_4 = -1;
				try{
					
						Object filename_tFileInputDelimited_4 = context.source_player_profiles;
						if(filename_tFileInputDelimited_4 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_4 = 0, random_value_tFileInputDelimited_4 = -1;
			if(footer_value_tFileInputDelimited_4 >0 || random_value_tFileInputDelimited_4 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_4 = new org.talend.fileprocess.FileInputDelimited(context.source_player_profiles, "UTF-8",",","\n",true,1,0,
									limit_tFileInputDelimited_4
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_4!=null && fid_tFileInputDelimited_4.nextRecord()) {
						rowstate_tFileInputDelimited_4.reset();
						
			    						row4 = null;			
												
									boolean whetherReject_tFileInputDelimited_4 = false;
									row4 = new row4Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_4 = 0;
				
					columnIndexWithD_tFileInputDelimited_4 = 0;
					
							row4.player_id = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 1;
					
							row4.player_slug = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 2;
					
							row4.player_name = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 3;
					
							row4.player_image_url = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 4;
					
							row4.date_of_birth = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 5;
					
							row4.place_of_birth = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 6;
					
							row4.country_of_birth = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 7;
					
							row4.height = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 8;
					
							row4.citizenship = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 9;
					
							row4.is_eu = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 10;
					
							row4.position = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 11;
					
							row4.main_position = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 12;
					
							row4.foot = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 13;
					
							row4.current_club_id = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 14;
					
							row4.current_club_name = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 15;
					
							row4.joined = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 16;
					
							row4.contract_expires = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 17;
					
							row4.outfitter = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 18;
					
							row4.social_media_url = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 19;
					
							row4.player_agent_id = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 20;
					
							row4.player_agent_name = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 21;
					
							row4.contract_option = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 22;
					
							row4.date_of_last_contract_extension = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 23;
					
							row4.on_loan_from_club_id = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 24;
					
							row4.on_loan_from_club_name = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 25;
					
							row4.contract_there_expires = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 26;
					
							row4.second_club_url = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 27;
					
							row4.second_club_name = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 28;
					
							row4.third_club_url = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 29;
					
							row4.third_club_name = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 30;
					
							row4.fourth_club_url = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 31;
					
							row4.fourth_club_name = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
					columnIndexWithD_tFileInputDelimited_4 = 32;
					
							row4.date_of_death = fid_tFileInputDelimited_4.get(columnIndexWithD_tFileInputDelimited_4);
						
				
				
										
										if(rowstate_tFileInputDelimited_4.getException()!=null) {
											throw rowstate_tFileInputDelimited_4.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_4_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_4 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row4 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_4 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 


	tos_count_tFileInputDelimited_4++;

/**
 * [tFileInputDelimited_4 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 process_data_begin ] stop
 */
// Start of branch "row4"
if(row4 != null) { 



	
	/**
	 * [tMongoDBOutput_4 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_4.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("player_id"),"player_id", row4.player_id);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("player_slug"),"player_slug", row4.player_slug);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("player_name"),"player_name", row4.player_name);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("player_image_url"),"player_image_url", row4.player_image_url);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("date_of_birth"),"date_of_birth", row4.date_of_birth);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("place_of_birth"),"place_of_birth", row4.place_of_birth);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("country_of_birth"),"country_of_birth", row4.country_of_birth);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("height"),"height", row4.height);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("citizenship"),"citizenship", row4.citizenship);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("is_eu"),"is_eu", row4.is_eu);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("position"),"position", row4.position);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("main_position"),"main_position", row4.main_position);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("foot"),"foot", row4.foot);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("current_club_id"),"current_club_id", row4.current_club_id);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("current_club_name"),"current_club_name", row4.current_club_name);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("joined"),"joined", row4.joined);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("contract_expires"),"contract_expires", row4.contract_expires);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("outfitter"),"outfitter", row4.outfitter);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("social_media_url"),"social_media_url", row4.social_media_url);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("player_agent_id"),"player_agent_id", row4.player_agent_id);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("player_agent_name"),"player_agent_name", row4.player_agent_name);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("contract_option"),"contract_option", row4.contract_option);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("date_of_last_contract_extension"),"date_of_last_contract_extension", row4.date_of_last_contract_extension);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("on_loan_from_club_id"),"on_loan_from_club_id", row4.on_loan_from_club_id);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("on_loan_from_club_name"),"on_loan_from_club_name", row4.on_loan_from_club_name);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("contract_there_expires"),"contract_there_expires", row4.contract_there_expires);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("second_club_url"),"second_club_url", row4.second_club_url);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("second_club_name"),"second_club_name", row4.second_club_name);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("third_club_url"),"third_club_url", row4.third_club_url);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("third_club_name"),"third_club_name", row4.third_club_name);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("fourth_club_url"),"fourth_club_url", row4.fourth_club_url);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("fourth_club_name"),"fourth_club_name", row4.fourth_club_name);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("date_of_death"),"date_of_death", row4.date_of_death);
				org.bson.Document updateObj_tMongoDBOutput_4 = updateObjectUtil_tMongoDBOutput_4.getObject();
				
						coll_tMongoDBOutput_4.insertOne(updateObj_tMongoDBOutput_4);
					
				} catch (Exception e_tMongoDBOutput_4) {
				
    					
    						System.err.println(e_tMongoDBOutput_4.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_4 ++;
				
 


	tos_count_tMongoDBOutput_4++;

/**
 * [tMongoDBOutput_4 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	

 



/**
 * [tMongoDBOutput_4 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	

 



/**
 * [tMongoDBOutput_4 process_data_end ] stop
 */

} // End of branch "row4"




	
	/**
	 * [tFileInputDelimited_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_4 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	



            }
            }finally{
                if(!((Object)(context.source_player_profiles) instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_4!=null){
                		fid_tFileInputDelimited_4.close();
                	}
                }
                if(fid_tFileInputDelimited_4!=null){
                	globalMap.put("tFileInputDelimited_4_NB_LINE", fid_tFileInputDelimited_4.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_4", true);
end_Hash.put("tFileInputDelimited_4", System.currentTimeMillis());




/**
 * [tFileInputDelimited_4 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_4 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	

	globalMap.put("tMongoDBOutput_4_NB_LINE", nb_line_tMongoDBOutput_4);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_4", true);
end_Hash.put("tMongoDBOutput_4", System.currentTimeMillis());




/**
 * [tMongoDBOutput_4 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_4 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_4";

	

 



/**
 * [tFileInputDelimited_4 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_4 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	


 



/**
 * [tMongoDBOutput_4 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_4_SUBPROCESS_STATE", 1);
	}
	


public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_sourcetobronze = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[0];

	
			    public String club_id;

				public String getClub_id () {
					return this.club_id;
				}
				
			    public String club_slug;

				public String getClub_slug () {
					return this.club_slug;
				}
				
			    public String club_name;

				public String getClub_name () {
					return this.club_name;
				}
				
			    public String logo_url;

				public String getLogo_url () {
					return this.logo_url;
				}
				
			    public String country_name;

				public String getCountry_name () {
					return this.country_name;
				}
				
			    public String competition_id;

				public String getCompetition_id () {
					return this.competition_id;
				}
				
			    public String competition_slug;

				public String getCompetition_slug () {
					return this.competition_slug;
				}
				
			    public String competition_name;

				public String getCompetition_name () {
					return this.competition_name;
				}
				
			    public String club_division;

				public String getClub_division () {
					return this.club_division;
				}
				
			    public String source_url;

				public String getSource_url () {
					return this.source_url;
				}
				
			    public String _last_modified_at;

				public String get_last_modified_at () {
					return this._last_modified_at;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.club_id = readString(dis);
					
					this.club_slug = readString(dis);
					
					this.club_name = readString(dis);
					
					this.logo_url = readString(dis);
					
					this.country_name = readString(dis);
					
					this.competition_id = readString(dis);
					
					this.competition_slug = readString(dis);
					
					this.competition_name = readString(dis);
					
					this.club_division = readString(dis);
					
					this.source_url = readString(dis);
					
					this._last_modified_at = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.club_id = readString(dis);
					
					this.club_slug = readString(dis);
					
					this.club_name = readString(dis);
					
					this.logo_url = readString(dis);
					
					this.country_name = readString(dis);
					
					this.competition_id = readString(dis);
					
					this.competition_slug = readString(dis);
					
					this.competition_name = readString(dis);
					
					this.club_division = readString(dis);
					
					this.source_url = readString(dis);
					
					this._last_modified_at = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.club_id,dos);
					
					// String
				
						writeString(this.club_slug,dos);
					
					// String
				
						writeString(this.club_name,dos);
					
					// String
				
						writeString(this.logo_url,dos);
					
					// String
				
						writeString(this.country_name,dos);
					
					// String
				
						writeString(this.competition_id,dos);
					
					// String
				
						writeString(this.competition_slug,dos);
					
					// String
				
						writeString(this.competition_name,dos);
					
					// String
				
						writeString(this.club_division,dos);
					
					// String
				
						writeString(this.source_url,dos);
					
					// String
				
						writeString(this._last_modified_at,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.club_id,dos);
					
					// String
				
						writeString(this.club_slug,dos);
					
					// String
				
						writeString(this.club_name,dos);
					
					// String
				
						writeString(this.logo_url,dos);
					
					// String
				
						writeString(this.country_name,dos);
					
					// String
				
						writeString(this.competition_id,dos);
					
					// String
				
						writeString(this.competition_slug,dos);
					
					// String
				
						writeString(this.competition_name,dos);
					
					// String
				
						writeString(this.club_division,dos);
					
					// String
				
						writeString(this.source_url,dos);
					
					// String
				
						writeString(this._last_modified_at,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("club_id="+club_id);
		sb.append(",club_slug="+club_slug);
		sb.append(",club_name="+club_name);
		sb.append(",logo_url="+logo_url);
		sb.append(",country_name="+country_name);
		sb.append(",competition_id="+competition_id);
		sb.append(",competition_slug="+competition_slug);
		sb.append(",competition_name="+competition_name);
		sb.append(",club_division="+club_division);
		sb.append(",source_url="+source_url);
		sb.append(",_last_modified_at="+_last_modified_at);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row5Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row5Struct row5 = new row5Struct();




	
	/**
	 * [tMongoDBOutput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_5", false);
		start_Hash.put("tMongoDBOutput_5", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tMongoDBOutput_5 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_5 = "Talend";

    int nb_line_tMongoDBOutput_5 = 0;

			class DBObjectUtil_tMongoDBOutput_5 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_5 updateObjectUtil_tMongoDBOutput_5=new DBObjectUtil_tMongoDBOutput_5();
            DBObjectUtil_tMongoDBOutput_5 queryObjectUtil_tMongoDBOutput_5=new DBObjectUtil_tMongoDBOutput_5();
            java.util.Map<String, String> pathMap_tMongoDBOutput_5=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_5.put("club_id","");
                pathMap_tMongoDBOutput_5.put("club_slug","");
                pathMap_tMongoDBOutput_5.put("club_name","");
                pathMap_tMongoDBOutput_5.put("logo_url","");
                pathMap_tMongoDBOutput_5.put("country_name","");
                pathMap_tMongoDBOutput_5.put("competition_id","");
                pathMap_tMongoDBOutput_5.put("competition_slug","");
                pathMap_tMongoDBOutput_5.put("competition_name","");
                pathMap_tMongoDBOutput_5.put("club_division","");
                pathMap_tMongoDBOutput_5.put("source_url","");
                pathMap_tMongoDBOutput_5.put("_last_modified_at","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_5=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_5=null;

        mongo_tMongoDBOutput_5=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_5 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_5.getCollection(context.mongo_team_details).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_5 = db_tMongoDBOutput_5.getCollection(context.mongo_team_details);


 



/**
 * [tMongoDBOutput_5 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_5", false);
		start_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_5";

	
		int tos_count_tFileInputDelimited_5 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_5 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_5 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_5 = null;
				int limit_tFileInputDelimited_5 = -1;
				try{
					
						Object filename_tFileInputDelimited_5 = context.source_team_details;
						if(filename_tFileInputDelimited_5 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_5 = 0, random_value_tFileInputDelimited_5 = -1;
			if(footer_value_tFileInputDelimited_5 >0 || random_value_tFileInputDelimited_5 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_5 = new org.talend.fileprocess.FileInputDelimited(context.source_team_details, "UTF-8",",","\n",true,1,0,
									limit_tFileInputDelimited_5
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_5!=null && fid_tFileInputDelimited_5.nextRecord()) {
						rowstate_tFileInputDelimited_5.reset();
						
			    						row5 = null;			
												
									boolean whetherReject_tFileInputDelimited_5 = false;
									row5 = new row5Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_5 = 0;
				
					columnIndexWithD_tFileInputDelimited_5 = 0;
					
							row5.club_id = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 1;
					
							row5.club_slug = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 2;
					
							row5.club_name = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 3;
					
							row5.logo_url = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 4;
					
							row5.country_name = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 5;
					
							row5.competition_id = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 6;
					
							row5.competition_slug = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 7;
					
							row5.competition_name = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 8;
					
							row5.club_division = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 9;
					
							row5.source_url = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
					columnIndexWithD_tFileInputDelimited_5 = 10;
					
							row5._last_modified_at = fid_tFileInputDelimited_5.get(columnIndexWithD_tFileInputDelimited_5);
						
				
				
										
										if(rowstate_tFileInputDelimited_5.getException()!=null) {
											throw rowstate_tFileInputDelimited_5.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_5_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_5 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row5 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_5 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 


	tos_count_tFileInputDelimited_5++;

/**
 * [tFileInputDelimited_5 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 process_data_begin ] stop
 */
// Start of branch "row5"
if(row5 != null) { 



	
	/**
	 * [tMongoDBOutput_5 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_5.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("club_id"),"club_id", row5.club_id);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("club_slug"),"club_slug", row5.club_slug);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("club_name"),"club_name", row5.club_name);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("logo_url"),"logo_url", row5.logo_url);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("country_name"),"country_name", row5.country_name);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("competition_id"),"competition_id", row5.competition_id);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("competition_slug"),"competition_slug", row5.competition_slug);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("competition_name"),"competition_name", row5.competition_name);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("club_division"),"club_division", row5.club_division);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("source_url"),"source_url", row5.source_url);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("_last_modified_at"),"_last_modified_at", row5._last_modified_at);
				org.bson.Document updateObj_tMongoDBOutput_5 = updateObjectUtil_tMongoDBOutput_5.getObject();
				
						coll_tMongoDBOutput_5.insertOne(updateObj_tMongoDBOutput_5);
					
				} catch (Exception e_tMongoDBOutput_5) {
				
    					
    						System.err.println(e_tMongoDBOutput_5.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_5 ++;
				
 


	tos_count_tMongoDBOutput_5++;

/**
 * [tMongoDBOutput_5 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	

 



/**
 * [tMongoDBOutput_5 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	

 



/**
 * [tMongoDBOutput_5 process_data_end ] stop
 */

} // End of branch "row5"




	
	/**
	 * [tFileInputDelimited_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_5 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	



            }
            }finally{
                if(!((Object)(context.source_team_details) instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_5!=null){
                		fid_tFileInputDelimited_5.close();
                	}
                }
                if(fid_tFileInputDelimited_5!=null){
                	globalMap.put("tFileInputDelimited_5_NB_LINE", fid_tFileInputDelimited_5.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_5", true);
end_Hash.put("tFileInputDelimited_5", System.currentTimeMillis());




/**
 * [tFileInputDelimited_5 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_5 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	

	globalMap.put("tMongoDBOutput_5_NB_LINE", nb_line_tMongoDBOutput_5);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_5", true);
end_Hash.put("tMongoDBOutput_5", System.currentTimeMillis());




/**
 * [tMongoDBOutput_5 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_5 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_5";

	

 



/**
 * [tFileInputDelimited_5 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_5 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	


 



/**
 * [tMongoDBOutput_5 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_5_SUBPROCESS_STATE", 1);
	}
	


public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_sourcetobronze = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[0];

	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String season_name;

				public String getSeason_name () {
					return this.season_name;
				}
				
			    public String transfer_date;

				public String getTransfer_date () {
					return this.transfer_date;
				}
				
			    public String from_team_id;

				public String getFrom_team_id () {
					return this.from_team_id;
				}
				
			    public String from_team_name;

				public String getFrom_team_name () {
					return this.from_team_name;
				}
				
			    public String to_team_id;

				public String getTo_team_id () {
					return this.to_team_id;
				}
				
			    public String to_team_name;

				public String getTo_team_name () {
					return this.to_team_name;
				}
				
			    public String transfer_type;

				public String getTransfer_type () {
					return this.transfer_type;
				}
				
			    public String value_at_transfer;

				public String getValue_at_transfer () {
					return this.value_at_transfer;
				}
				
			    public String transfer_fee;

				public String getTransfer_fee () {
					return this.transfer_fee;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_sourcetobronze.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_sourcetobronze.length == 0) {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_sourcetobronze = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_sourcetobronze, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.transfer_date = readString(dis);
					
					this.from_team_id = readString(dis);
					
					this.from_team_name = readString(dis);
					
					this.to_team_id = readString(dis);
					
					this.to_team_name = readString(dis);
					
					this.transfer_type = readString(dis);
					
					this.value_at_transfer = readString(dis);
					
					this.transfer_fee = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_sourcetobronze) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.transfer_date = readString(dis);
					
					this.from_team_id = readString(dis);
					
					this.from_team_name = readString(dis);
					
					this.to_team_id = readString(dis);
					
					this.to_team_name = readString(dis);
					
					this.transfer_type = readString(dis);
					
					this.value_at_transfer = readString(dis);
					
					this.transfer_fee = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.season_name,dos);
					
					// String
				
						writeString(this.transfer_date,dos);
					
					// String
				
						writeString(this.from_team_id,dos);
					
					// String
				
						writeString(this.from_team_name,dos);
					
					// String
				
						writeString(this.to_team_id,dos);
					
					// String
				
						writeString(this.to_team_name,dos);
					
					// String
				
						writeString(this.transfer_type,dos);
					
					// String
				
						writeString(this.value_at_transfer,dos);
					
					// String
				
						writeString(this.transfer_fee,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.season_name,dos);
					
					// String
				
						writeString(this.transfer_date,dos);
					
					// String
				
						writeString(this.from_team_id,dos);
					
					// String
				
						writeString(this.from_team_name,dos);
					
					// String
				
						writeString(this.to_team_id,dos);
					
					// String
				
						writeString(this.to_team_name,dos);
					
					// String
				
						writeString(this.transfer_type,dos);
					
					// String
				
						writeString(this.value_at_transfer,dos);
					
					// String
				
						writeString(this.transfer_fee,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("player_id="+player_id);
		sb.append(",season_name="+season_name);
		sb.append(",transfer_date="+transfer_date);
		sb.append(",from_team_id="+from_team_id);
		sb.append(",from_team_name="+from_team_name);
		sb.append(",to_team_id="+to_team_id);
		sb.append(",to_team_name="+to_team_name);
		sb.append(",transfer_type="+transfer_type);
		sb.append(",value_at_transfer="+value_at_transfer);
		sb.append(",transfer_fee="+transfer_fee);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row6Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputDelimited_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputDelimited_6_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row6Struct row6 = new row6Struct();




	
	/**
	 * [tMongoDBOutput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_6", false);
		start_Hash.put("tMongoDBOutput_6", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tMongoDBOutput_6 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_6 = "Talend";

    int nb_line_tMongoDBOutput_6 = 0;

			class DBObjectUtil_tMongoDBOutput_6 {
				
				private org.bson.Document object = null;
				//Put value to embedded document
				//If have no embedded document, put the value to root document
				public void put(String parentNode, String curentName, Object value) {
					if (parentNode == null || "".equals(parentNode)) {
						object.put(curentName, value);
					} else {
						String objNames[]= parentNode.split("\\.");
						org.bson.Document lastNode = getParentNode(parentNode, objNames.length-1);
						lastNode.put(curentName, value);
						org.bson.Document parenttNode = null;
						for (int i = objNames.length - 1; i >=0; i--) {
							parenttNode=getParentNode(parentNode, i-1);
							parenttNode.put(objNames[i], lastNode);
							lastNode=clone(parenttNode);
						}
						object=lastNode;
					}
				}
				
				private org.bson.Document clone(org.bson.Document source){
					org.bson.Document to = new org.bson.Document();
					for(java.util.Map.Entry<String,Object> cur:source.entrySet()) {
						to.append(cur.getKey(), cur.getValue());
					}
					return to;
				}
				
				//Get node(embedded document) by path configuration
				public org.bson.Document getParentNode(String parentNode, int index) {
					org.bson.Document document = object;
					if (parentNode == null || "".equals(parentNode)) {
						return object;
					} else {
						String objNames[] = parentNode.split("\\.");
						for (int i = 0; i <= index; i++) {
							document = (org.bson.Document) document
									.get(objNames[i]);
							if (document == null) {
								document = new org.bson.Document();
								return document;
							}
							if (i == index) {
								break;
							}
						}
						return document;
					}
				}
				
				public void putkeyNode(String parentNode, String curentName, Object value){
					if (parentNode == null || "".equals(parentNode) || ".".equals(parentNode)) {
						put(parentNode, curentName, value);
					}else{
						put("", parentNode+"."+curentName, value);
					}
				}
			
				public org.bson.Document getObject() {
					return this.object;
				}
				
				public void setObject(org.bson.Document object){
					this.object=object;
				}
			
			}
            DBObjectUtil_tMongoDBOutput_6 updateObjectUtil_tMongoDBOutput_6=new DBObjectUtil_tMongoDBOutput_6();
            DBObjectUtil_tMongoDBOutput_6 queryObjectUtil_tMongoDBOutput_6=new DBObjectUtil_tMongoDBOutput_6();
            java.util.Map<String, String> pathMap_tMongoDBOutput_6=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_6.put("player_id","");
                pathMap_tMongoDBOutput_6.put("season_name","");
                pathMap_tMongoDBOutput_6.put("transfer_date","");
                pathMap_tMongoDBOutput_6.put("from_team_id","");
                pathMap_tMongoDBOutput_6.put("from_team_name","");
                pathMap_tMongoDBOutput_6.put("to_team_id","");
                pathMap_tMongoDBOutput_6.put("to_team_name","");
                pathMap_tMongoDBOutput_6.put("transfer_type","");
                pathMap_tMongoDBOutput_6.put("value_at_transfer","");
                pathMap_tMongoDBOutput_6.put("transfer_fee","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_6=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_6=null;

        mongo_tMongoDBOutput_6=(com.mongodb.client.MongoClient)globalMap.get("mongo_tMongoDBConnection_1");
        db_tMongoDBOutput_6 = (com.mongodb.client.MongoDatabase)globalMap.get("db_tMongoDBConnection_1");

        db_tMongoDBOutput_6.getCollection(context.mongo_transfer_history).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_6 = db_tMongoDBOutput_6.getCollection(context.mongo_transfer_history);


 



/**
 * [tMongoDBOutput_6 begin ] stop
 */



	
	/**
	 * [tFileInputDelimited_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputDelimited_6", false);
		start_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());
		
	
	currentComponent="tFileInputDelimited_6";

	
		int tos_count_tFileInputDelimited_6 = 0;
		
	
	
	
 
	
	
	final routines.system.RowState rowstate_tFileInputDelimited_6 = new routines.system.RowState();
	
	
				int nb_line_tFileInputDelimited_6 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_6 = null;
				int limit_tFileInputDelimited_6 = -1;
				try{
					
						Object filename_tFileInputDelimited_6 = context.source_transfer_history;
						if(filename_tFileInputDelimited_6 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_6 = 0, random_value_tFileInputDelimited_6 = -1;
			if(footer_value_tFileInputDelimited_6 >0 || random_value_tFileInputDelimited_6 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_6 = new org.talend.fileprocess.FileInputDelimited(context.source_transfer_history, "UTF-8",",","\n",true,1,0,
									limit_tFileInputDelimited_6
								,-1, false);
						} catch(java.lang.Exception e) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",e.getMessage());
							
								
								System.err.println(e.getMessage());
							
						}
					
				    
					while (fid_tFileInputDelimited_6!=null && fid_tFileInputDelimited_6.nextRecord()) {
						rowstate_tFileInputDelimited_6.reset();
						
			    						row6 = null;			
												
									boolean whetherReject_tFileInputDelimited_6 = false;
									row6 = new row6Struct();
									try {
										
				int columnIndexWithD_tFileInputDelimited_6 = 0;
				
					columnIndexWithD_tFileInputDelimited_6 = 0;
					
							row6.player_id = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 1;
					
							row6.season_name = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 2;
					
							row6.transfer_date = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 3;
					
							row6.from_team_id = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 4;
					
							row6.from_team_name = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 5;
					
							row6.to_team_id = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 6;
					
							row6.to_team_name = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 7;
					
							row6.transfer_type = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 8;
					
							row6.value_at_transfer = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
					columnIndexWithD_tFileInputDelimited_6 = 9;
					
							row6.transfer_fee = fid_tFileInputDelimited_6.get(columnIndexWithD_tFileInputDelimited_6);
						
				
				
										
										if(rowstate_tFileInputDelimited_6.getException()!=null) {
											throw rowstate_tFileInputDelimited_6.getException();
										}
										
										
							
			    					} catch (java.lang.Exception e) {
globalMap.put("tFileInputDelimited_6_ERROR_MESSAGE",e.getMessage());
			        					whetherReject_tFileInputDelimited_6 = true;
			        					
			                					System.err.println(e.getMessage());
			                					row6 = null;
			                				
										
			    					}
								

 



/**
 * [tFileInputDelimited_6 begin ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 main ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 


	tos_count_tFileInputDelimited_6++;

/**
 * [tFileInputDelimited_6 main ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 process_data_begin ] stop
 */
// Start of branch "row6"
if(row6 != null) { 



	
	/**
	 * [tMongoDBOutput_6 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_6.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("player_id"),"player_id", row6.player_id);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("season_name"),"season_name", row6.season_name);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("transfer_date"),"transfer_date", row6.transfer_date);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("from_team_id"),"from_team_id", row6.from_team_id);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("from_team_name"),"from_team_name", row6.from_team_name);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("to_team_id"),"to_team_id", row6.to_team_id);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("to_team_name"),"to_team_name", row6.to_team_name);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("transfer_type"),"transfer_type", row6.transfer_type);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("value_at_transfer"),"value_at_transfer", row6.value_at_transfer);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("transfer_fee"),"transfer_fee", row6.transfer_fee);
				org.bson.Document updateObj_tMongoDBOutput_6 = updateObjectUtil_tMongoDBOutput_6.getObject();
				
						coll_tMongoDBOutput_6.insertOne(updateObj_tMongoDBOutput_6);
					
				} catch (Exception e_tMongoDBOutput_6) {
				
    					
    						System.err.println(e_tMongoDBOutput_6.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_6 ++;
				
 


	tos_count_tMongoDBOutput_6++;

/**
 * [tMongoDBOutput_6 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	

 



/**
 * [tMongoDBOutput_6 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	

 



/**
 * [tMongoDBOutput_6 process_data_end ] stop
 */

} // End of branch "row6"




	
	/**
	 * [tFileInputDelimited_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 process_data_end ] stop
 */
	
	/**
	 * [tFileInputDelimited_6 end ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	



            }
            }finally{
                if(!((Object)(context.source_transfer_history) instanceof java.io.InputStream)){
                	if(fid_tFileInputDelimited_6!=null){
                		fid_tFileInputDelimited_6.close();
                	}
                }
                if(fid_tFileInputDelimited_6!=null){
                	globalMap.put("tFileInputDelimited_6_NB_LINE", fid_tFileInputDelimited_6.getRowNumber());
					
                }
			}
			  

 

ok_Hash.put("tFileInputDelimited_6", true);
end_Hash.put("tFileInputDelimited_6", System.currentTimeMillis());




/**
 * [tFileInputDelimited_6 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_6 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	

	globalMap.put("tMongoDBOutput_6_NB_LINE", nb_line_tMongoDBOutput_6);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_6", true);
end_Hash.put("tMongoDBOutput_6", System.currentTimeMillis());




/**
 * [tMongoDBOutput_6 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tFileInputDelimited_6 finally ] start
	 */

	

	
	
	currentComponent="tFileInputDelimited_6";

	

 



/**
 * [tFileInputDelimited_6 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_6 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	


 



/**
 * [tMongoDBOutput_6 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputDelimited_6_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final sourcetobronze sourcetobronzeClass = new sourcetobronze();

        int exitCode = sourcetobronzeClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = sourcetobronze.class.getClassLoader().getResourceAsStream("local_project/sourcetobronze_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = sourcetobronze.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("mongo_collection_bronze", "id_String");
                        if(context.getStringValue("mongo_collection_bronze") == null) {
                            context.mongo_collection_bronze = null;
                        } else {
                            context.mongo_collection_bronze=(String) context.getProperty("mongo_collection_bronze");
                        }
                        context.setContextType("mongo_collection_silver", "id_String");
                        if(context.getStringValue("mongo_collection_silver") == null) {
                            context.mongo_collection_silver = null;
                        } else {
                            context.mongo_collection_silver=(String) context.getProperty("mongo_collection_silver");
                        }
                        context.setContextType("mongo_database", "id_String");
                        if(context.getStringValue("mongo_database") == null) {
                            context.mongo_database = null;
                        } else {
                            context.mongo_database=(String) context.getProperty("mongo_database");
                        }
                        context.setContextType("mongo_player_injuries", "id_String");
                        if(context.getStringValue("mongo_player_injuries") == null) {
                            context.mongo_player_injuries = null;
                        } else {
                            context.mongo_player_injuries=(String) context.getProperty("mongo_player_injuries");
                        }
                        context.setContextType("mongo_player_latest_market_value", "id_String");
                        if(context.getStringValue("mongo_player_latest_market_value") == null) {
                            context.mongo_player_latest_market_value = null;
                        } else {
                            context.mongo_player_latest_market_value=(String) context.getProperty("mongo_player_latest_market_value");
                        }
                        context.setContextType("mongo_player_performances", "id_String");
                        if(context.getStringValue("mongo_player_performances") == null) {
                            context.mongo_player_performances = null;
                        } else {
                            context.mongo_player_performances=(String) context.getProperty("mongo_player_performances");
                        }
                        context.setContextType("mongo_player_profiles", "id_String");
                        if(context.getStringValue("mongo_player_profiles") == null) {
                            context.mongo_player_profiles = null;
                        } else {
                            context.mongo_player_profiles=(String) context.getProperty("mongo_player_profiles");
                        }
                        context.setContextType("mongo_port", "id_String");
                        if(context.getStringValue("mongo_port") == null) {
                            context.mongo_port = null;
                        } else {
                            context.mongo_port=(String) context.getProperty("mongo_port");
                        }
                        context.setContextType("mongo_server", "id_String");
                        if(context.getStringValue("mongo_server") == null) {
                            context.mongo_server = null;
                        } else {
                            context.mongo_server=(String) context.getProperty("mongo_server");
                        }
                        context.setContextType("mongo_team_details", "id_String");
                        if(context.getStringValue("mongo_team_details") == null) {
                            context.mongo_team_details = null;
                        } else {
                            context.mongo_team_details=(String) context.getProperty("mongo_team_details");
                        }
                        context.setContextType("mongo_transfer_history", "id_String");
                        if(context.getStringValue("mongo_transfer_history") == null) {
                            context.mongo_transfer_history = null;
                        } else {
                            context.mongo_transfer_history=(String) context.getProperty("mongo_transfer_history");
                        }
                        context.setContextType("postgres_database", "id_String");
                        if(context.getStringValue("postgres_database") == null) {
                            context.postgres_database = null;
                        } else {
                            context.postgres_database=(String) context.getProperty("postgres_database");
                        }
                        context.setContextType("postgres_password", "id_String");
                        if(context.getStringValue("postgres_password") == null) {
                            context.postgres_password = null;
                        } else {
                            context.postgres_password=(String) context.getProperty("postgres_password");
                        }
                        context.setContextType("postgres_port", "id_String");
                        if(context.getStringValue("postgres_port") == null) {
                            context.postgres_port = null;
                        } else {
                            context.postgres_port=(String) context.getProperty("postgres_port");
                        }
                        context.setContextType("postgres_schema", "id_String");
                        if(context.getStringValue("postgres_schema") == null) {
                            context.postgres_schema = null;
                        } else {
                            context.postgres_schema=(String) context.getProperty("postgres_schema");
                        }
                        context.setContextType("postgres_server", "id_String");
                        if(context.getStringValue("postgres_server") == null) {
                            context.postgres_server = null;
                        } else {
                            context.postgres_server=(String) context.getProperty("postgres_server");
                        }
                        context.setContextType("postgres_table_bodytype", "id_String");
                        if(context.getStringValue("postgres_table_bodytype") == null) {
                            context.postgres_table_bodytype = null;
                        } else {
                            context.postgres_table_bodytype=(String) context.getProperty("postgres_table_bodytype");
                        }
                        context.setContextType("postgres_table_players", "id_String");
                        if(context.getStringValue("postgres_table_players") == null) {
                            context.postgres_table_players = null;
                        } else {
                            context.postgres_table_players=(String) context.getProperty("postgres_table_players");
                        }
                        context.setContextType("postgres_user", "id_String");
                        if(context.getStringValue("postgres_user") == null) {
                            context.postgres_user = null;
                        } else {
                            context.postgres_user=(String) context.getProperty("postgres_user");
                        }
                        context.setContextType("source", "id_String");
                        if(context.getStringValue("source") == null) {
                            context.source = null;
                        } else {
                            context.source=(String) context.getProperty("source");
                        }
                        context.setContextType("source_player_injuries", "id_String");
                        if(context.getStringValue("source_player_injuries") == null) {
                            context.source_player_injuries = null;
                        } else {
                            context.source_player_injuries=(String) context.getProperty("source_player_injuries");
                        }
                        context.setContextType("source_player_latest_market_value", "id_String");
                        if(context.getStringValue("source_player_latest_market_value") == null) {
                            context.source_player_latest_market_value = null;
                        } else {
                            context.source_player_latest_market_value=(String) context.getProperty("source_player_latest_market_value");
                        }
                        context.setContextType("source_player_performances", "id_String");
                        if(context.getStringValue("source_player_performances") == null) {
                            context.source_player_performances = null;
                        } else {
                            context.source_player_performances=(String) context.getProperty("source_player_performances");
                        }
                        context.setContextType("source_player_profiles", "id_String");
                        if(context.getStringValue("source_player_profiles") == null) {
                            context.source_player_profiles = null;
                        } else {
                            context.source_player_profiles=(String) context.getProperty("source_player_profiles");
                        }
                        context.setContextType("source_team_details", "id_String");
                        if(context.getStringValue("source_team_details") == null) {
                            context.source_team_details = null;
                        } else {
                            context.source_team_details=(String) context.getProperty("source_team_details");
                        }
                        context.setContextType("source_transfer_history", "id_String");
                        if(context.getStringValue("source_transfer_history") == null) {
                            context.source_transfer_history = null;
                        } else {
                            context.source_transfer_history=(String) context.getProperty("source_transfer_history");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("mongo_collection_bronze")) {
                context.mongo_collection_bronze = (String) parentContextMap.get("mongo_collection_bronze");
            }if (parentContextMap.containsKey("mongo_collection_silver")) {
                context.mongo_collection_silver = (String) parentContextMap.get("mongo_collection_silver");
            }if (parentContextMap.containsKey("mongo_database")) {
                context.mongo_database = (String) parentContextMap.get("mongo_database");
            }if (parentContextMap.containsKey("mongo_player_injuries")) {
                context.mongo_player_injuries = (String) parentContextMap.get("mongo_player_injuries");
            }if (parentContextMap.containsKey("mongo_player_latest_market_value")) {
                context.mongo_player_latest_market_value = (String) parentContextMap.get("mongo_player_latest_market_value");
            }if (parentContextMap.containsKey("mongo_player_performances")) {
                context.mongo_player_performances = (String) parentContextMap.get("mongo_player_performances");
            }if (parentContextMap.containsKey("mongo_player_profiles")) {
                context.mongo_player_profiles = (String) parentContextMap.get("mongo_player_profiles");
            }if (parentContextMap.containsKey("mongo_port")) {
                context.mongo_port = (String) parentContextMap.get("mongo_port");
            }if (parentContextMap.containsKey("mongo_server")) {
                context.mongo_server = (String) parentContextMap.get("mongo_server");
            }if (parentContextMap.containsKey("mongo_team_details")) {
                context.mongo_team_details = (String) parentContextMap.get("mongo_team_details");
            }if (parentContextMap.containsKey("mongo_transfer_history")) {
                context.mongo_transfer_history = (String) parentContextMap.get("mongo_transfer_history");
            }if (parentContextMap.containsKey("postgres_database")) {
                context.postgres_database = (String) parentContextMap.get("postgres_database");
            }if (parentContextMap.containsKey("postgres_password")) {
                context.postgres_password = (String) parentContextMap.get("postgres_password");
            }if (parentContextMap.containsKey("postgres_port")) {
                context.postgres_port = (String) parentContextMap.get("postgres_port");
            }if (parentContextMap.containsKey("postgres_schema")) {
                context.postgres_schema = (String) parentContextMap.get("postgres_schema");
            }if (parentContextMap.containsKey("postgres_server")) {
                context.postgres_server = (String) parentContextMap.get("postgres_server");
            }if (parentContextMap.containsKey("postgres_table_bodytype")) {
                context.postgres_table_bodytype = (String) parentContextMap.get("postgres_table_bodytype");
            }if (parentContextMap.containsKey("postgres_table_players")) {
                context.postgres_table_players = (String) parentContextMap.get("postgres_table_players");
            }if (parentContextMap.containsKey("postgres_user")) {
                context.postgres_user = (String) parentContextMap.get("postgres_user");
            }if (parentContextMap.containsKey("source")) {
                context.source = (String) parentContextMap.get("source");
            }if (parentContextMap.containsKey("source_player_injuries")) {
                context.source_player_injuries = (String) parentContextMap.get("source_player_injuries");
            }if (parentContextMap.containsKey("source_player_latest_market_value")) {
                context.source_player_latest_market_value = (String) parentContextMap.get("source_player_latest_market_value");
            }if (parentContextMap.containsKey("source_player_performances")) {
                context.source_player_performances = (String) parentContextMap.get("source_player_performances");
            }if (parentContextMap.containsKey("source_player_profiles")) {
                context.source_player_profiles = (String) parentContextMap.get("source_player_profiles");
            }if (parentContextMap.containsKey("source_team_details")) {
                context.source_team_details = (String) parentContextMap.get("source_team_details");
            }if (parentContextMap.containsKey("source_transfer_history")) {
                context.source_transfer_history = (String) parentContextMap.get("source_transfer_history");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob





this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tMongoDBConnection_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBConnection_1) {
globalMap.put("tMongoDBConnection_1_SUBPROCESS_STATE", -1);

e_tMongoDBConnection_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : sourcetobronze");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {


    }














    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     223088 characters generated by Talend Open Studio for Big Data 
 *     on the 17 février 2026 à 19:17:52 CET
 ************************************************************************************************/