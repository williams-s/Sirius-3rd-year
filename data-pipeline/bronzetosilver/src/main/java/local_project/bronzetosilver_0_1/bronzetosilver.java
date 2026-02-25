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


package local_project.bronzetosilver_0_1;

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
 * Job: bronzetosilver Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class bronzetosilver implements TalendJob {

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
			
			if(mongo_server != null){
				
					this.setProperty("mongo_server", mongo_server.toString());
				
			}
			
			if(mongo_collection_bronze != null){
				
					this.setProperty("mongo_collection_bronze", mongo_collection_bronze.toString());
				
			}
			
			if(mongo_collection_silver != null){
				
					this.setProperty("mongo_collection_silver", mongo_collection_silver.toString());
				
			}
			
			if(mongo_database != null){
				
					this.setProperty("mongo_database", mongo_database.toString());
				
			}
			
			if(mongo_kpia != null){
				
					this.setProperty("mongo_kpia", mongo_kpia.toString());
				
			}
			
			if(mongo_player_injuries != null){
				
					this.setProperty("mongo_player_injuries", mongo_player_injuries.toString());
				
			}
			
			if(mongo_player_injuries_modifie != null){
				
					this.setProperty("mongo_player_injuries_modifie", mongo_player_injuries_modifie.toString());
				
			}
			
			if(mongo_player_latest_market_value != null){
				
					this.setProperty("mongo_player_latest_market_value", mongo_player_latest_market_value.toString());
				
			}
			
			if(mongo_player_latest_market_value_modifie != null){
				
					this.setProperty("mongo_player_latest_market_value_modifie", mongo_player_latest_market_value_modifie.toString());
				
			}
			
			if(mongo_player_performances != null){
				
					this.setProperty("mongo_player_performances", mongo_player_performances.toString());
				
			}
			
			if(mongo_player_performances_modifie != null){
				
					this.setProperty("mongo_player_performances_modifie", mongo_player_performances_modifie.toString());
				
			}
			
			if(mongo_player_profiles != null){
				
					this.setProperty("mongo_player_profiles", mongo_player_profiles.toString());
				
			}
			
			if(mongo_player_profiles_modifie != null){
				
					this.setProperty("mongo_player_profiles_modifie", mongo_player_profiles_modifie.toString());
				
			}
			
			if(mongo_port != null){
				
					this.setProperty("mongo_port", mongo_port.toString());
				
			}
			
			if(mongo_team_details != null){
				
					this.setProperty("mongo_team_details", mongo_team_details.toString());
				
			}
			
			if(mongo_team_details_modifie != null){
				
					this.setProperty("mongo_team_details_modifie", mongo_team_details_modifie.toString());
				
			}
			
			if(mongo_transfer_history != null){
				
					this.setProperty("mongo_transfer_history", mongo_transfer_history.toString());
				
			}
			
			if(mongo_transfer_history_modifie != null){
				
					this.setProperty("mongo_transfer_history_modifie", mongo_transfer_history_modifie.toString());
				
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

public String mongo_server;
public String getMongo_server(){
	return this.mongo_server;
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
public String mongo_kpia;
public String getMongo_kpia(){
	return this.mongo_kpia;
}
public String mongo_player_injuries;
public String getMongo_player_injuries(){
	return this.mongo_player_injuries;
}
public String mongo_player_injuries_modifie;
public String getMongo_player_injuries_modifie(){
	return this.mongo_player_injuries_modifie;
}
public String mongo_player_latest_market_value;
public String getMongo_player_latest_market_value(){
	return this.mongo_player_latest_market_value;
}
public String mongo_player_latest_market_value_modifie;
public String getMongo_player_latest_market_value_modifie(){
	return this.mongo_player_latest_market_value_modifie;
}
public String mongo_player_performances;
public String getMongo_player_performances(){
	return this.mongo_player_performances;
}
public String mongo_player_performances_modifie;
public String getMongo_player_performances_modifie(){
	return this.mongo_player_performances_modifie;
}
public String mongo_player_profiles;
public String getMongo_player_profiles(){
	return this.mongo_player_profiles;
}
public String mongo_player_profiles_modifie;
public String getMongo_player_profiles_modifie(){
	return this.mongo_player_profiles_modifie;
}
public String mongo_port;
public String getMongo_port(){
	return this.mongo_port;
}
public String mongo_team_details;
public String getMongo_team_details(){
	return this.mongo_team_details;
}
public String mongo_team_details_modifie;
public String getMongo_team_details_modifie(){
	return this.mongo_team_details_modifie;
}
public String mongo_transfer_history;
public String getMongo_transfer_history(){
	return this.mongo_transfer_history;
}
public String mongo_transfer_history_modifie;
public String getMongo_transfer_history_modifie(){
	return this.mongo_transfer_history_modifie;
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
	private final String jobName = "bronzetosilver";
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
				bronzetosilver.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(bronzetosilver.this, new Object[] { e , currentComponent, globalMap});
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

			public void tMongoDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_4_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_6_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_5_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_8_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_6_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_8_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_9_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_9_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row7_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAggregateRow_2_AGGOUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tAggregateRow_2_AGGIN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tAggregateRow_2_AGGIN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAggregateRow_1_AGGOUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tAggregateRow_1_AGGIN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tAggregateRow_1_AGGIN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_4_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_6_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_5_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_8_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tMongoDBInput_9_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class sortieeeStruct implements routines.system.IPersistableRow<sortieeeStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public Double minutes_played;

				public Double getMinutes_played () {
					return this.minutes_played;
				}
				
			    public String player_slug;

				public String getPlayer_slug () {
					return this.player_slug;
				}
				
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String main_position;

				public String getMain_position () {
					return this.main_position;
				}
				
			    public Double minutes_per_goals;

				public Double getMinutes_per_goals () {
					return this.minutes_per_goals;
				}
				
			    public Double goals;

				public Double getGoals () {
					return this.goals;
				}
				
			    public Double score_players;

				public Double getScore_players () {
					return this.score_players;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final sortieeeStruct other = (sortieeeStruct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(sortieeeStruct other) {

		other.minutes_played = this.minutes_played;
	            other.player_slug = this.player_slug;
	            other.player_id = this.player_id;
	            other.main_position = this.main_position;
	            other.minutes_per_goals = this.minutes_per_goals;
	            other.goals = this.goals;
	            other.score_players = this.score_players;
	            
	}

	public void copyKeysDataTo(sortieeeStruct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
					this.player_slug = readString(dis);
					
					this.player_id = readString(dis);
					
					this.main_position = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_per_goals = null;
           				} else {
           			    	this.minutes_per_goals = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_players = null;
           				} else {
           			    	this.score_players = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
					this.player_slug = readString(dis);
					
					this.player_id = readString(dis);
					
					this.main_position = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_per_goals = null;
           				} else {
           			    	this.minutes_per_goals = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.score_players = null;
           				} else {
           			    	this.score_players = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// String
				
						writeString(this.player_slug,dos);
					
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.main_position,dos);
					
					// Double
				
						if(this.minutes_per_goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_per_goals);
		            	}
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Double
				
						if(this.score_players == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.score_players);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// String
				
						writeString(this.player_slug,dos);
					
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.main_position,dos);
					
					// Double
				
						if(this.minutes_per_goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_per_goals);
		            	}
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Double
				
						if(this.score_players == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.score_players);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("minutes_played="+String.valueOf(minutes_played));
		sb.append(",player_slug="+player_slug);
		sb.append(",player_id="+player_id);
		sb.append(",main_position="+main_position);
		sb.append(",minutes_per_goals="+String.valueOf(minutes_per_goals));
		sb.append(",goals="+String.valueOf(goals));
		sb.append(",score_players="+String.valueOf(score_players));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(sortieeeStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class row8Struct implements routines.system.IPersistableRow<row8Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
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
				
			    public Integer games_missed;

				public Integer getGames_missed () {
					return this.games_missed;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
		sb.append(",games_missed="+String.valueOf(games_missed));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row8Struct other) {

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

public static class OnRowsEndStructtAggregateRow_2 implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_2> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Integer games_missed;

				public Integer getGames_missed () {
					return this.games_missed;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final OnRowsEndStructtAggregateRow_2 other = (OnRowsEndStructtAggregateRow_2) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(OnRowsEndStructtAggregateRow_2 other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.injury_reason = this.injury_reason;
	            other.from_date = this.from_date;
	            other.end_date = this.end_date;
	            other.days_missed = this.days_missed;
	            other.games_missed = this.games_missed;
	            
	}

	public void copyKeysDataTo(OnRowsEndStructtAggregateRow_2 other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
		sb.append(",games_missed="+String.valueOf(games_missed));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(OnRowsEndStructtAggregateRow_2 other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Integer games_missed;

				public Integer getGames_missed () {
					return this.games_missed;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row1Struct other = (row1Struct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row1Struct other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.injury_reason = this.injury_reason;
	            other.from_date = this.from_date;
	            other.end_date = this.end_date;
	            other.days_missed = this.days_missed;
	            other.games_missed = this.games_missed;
	            
	}

	public void copyKeysDataTo(row1Struct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
		sb.append(",games_missed="+String.valueOf(games_missed));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class after_tMongoDBInput_1Struct implements routines.system.IPersistableRow<after_tMongoDBInput_1Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Integer games_missed;

				public Integer getGames_missed () {
					return this.games_missed;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tMongoDBInput_1Struct other = (after_tMongoDBInput_1Struct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(after_tMongoDBInput_1Struct other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.injury_reason = this.injury_reason;
	            other.from_date = this.from_date;
	            other.end_date = this.end_date;
	            other.days_missed = this.days_missed;
	            other.games_missed = this.games_missed;
	            
	}

	public void copyKeysDataTo(after_tMongoDBInput_1Struct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
		sb.append(",games_missed="+String.valueOf(games_missed));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tMongoDBInput_1Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
public void tMongoDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
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


		tMongoDBInput_7Process(globalMap);
		tMongoDBInput_3Process(globalMap);

		row1Struct row1 = new row1Struct();
row8Struct row8 = new row8Struct();
sortieeeStruct sortieee = new sortieeeStruct();




	
	/**
	 * [tAggregateRow_2_AGGOUT begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_2_AGGOUT", false);
		start_Hash.put("tAggregateRow_2_AGGOUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tAggregateRow_2_AGGOUT = 0;
		

// ------------ Seems it is not used

java.util.Map hashAggreg_tAggregateRow_2 = new java.util.HashMap(); 

// ------------

	class UtilClass_tAggregateRow_2 { // G_OutBegin_AggR_144

		public double sd(Double[] data) {
	        final int n = data.length;
        	if (n < 2) {
	            return Double.NaN;
        	}
        	double d1 = 0d;
        	double d2 =0d;
	        
	        for (int i = 0; i < data.length; i++) {
            	d1 += (data[i]*data[i]);
            	d2 += data[i];
        	}
        
	        return Math.sqrt((n*d1 - d2*d2)/n/(n-1));
	    }
	    
		public void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		    byte r = (byte) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'short/Short'", "'byte/Byte'"));
		    }
		}
		
		public void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		    short r = (short) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'int/Integer'", "'short/Short'"));
		    }
		}
		
		public void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		    int r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'long/Long'", "'int/Integer'"));
		    }
		}
		
		public void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {
		    long r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'long/Long'"));
		    }
		}
		
		public void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    float minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
			    }
			}
			
		    if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
		    }
		}
		
		public void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		private String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {
		    return "Type overflow when adding " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}
		
		private String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {
		    return "The double precision is unsufficient to add the value " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}

	} // G_OutBegin_AggR_144

	UtilClass_tAggregateRow_2 utilClass_tAggregateRow_2 = new UtilClass_tAggregateRow_2();

	

	class AggOperationStruct_tAggregateRow_2 { // G_OutBegin_AggR_100

		private static final int DEFAULT_HASHCODE = 1;
	    private static final int PRIME = 31;
	    private int hashCode = DEFAULT_HASHCODE;
	    public boolean hashCodeDirty = true;

    				String player_id;
        
	    @Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;
		
							result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
							
	    		this.hashCode = result;
	    		this.hashCodeDirty = false;		
			}
			return this.hashCode;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			final AggOperationStruct_tAggregateRow_2 other = (AggOperationStruct_tAggregateRow_2) obj;
			
							if (this.player_id == null) {
								if (other.player_id != null) 
									return false;
							} else if (!this.player_id.equals(other.player_id)) 
								return false;
						
			
			return true;
		}
  
        
	} // G_OutBegin_AggR_100

	System.err.println(
	
		"Warning:the operation 'sum' for the output column 'days_missed' can't be processed because of incompatible input and/or output types"
	);
	
	AggOperationStruct_tAggregateRow_2 operation_result_tAggregateRow_2 = null;
	AggOperationStruct_tAggregateRow_2 operation_finder_tAggregateRow_2 = new AggOperationStruct_tAggregateRow_2();
	java.util.Map<AggOperationStruct_tAggregateRow_2,AggOperationStruct_tAggregateRow_2> hash_tAggregateRow_2 = new java.util.HashMap<AggOperationStruct_tAggregateRow_2,AggOperationStruct_tAggregateRow_2>();
	

 



/**
 * [tAggregateRow_2_AGGOUT begin ] stop
 */



	
	/**
	 * [tMongoDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_1", false);
		start_Hash.put("tMongoDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_1";

	
		int tos_count_tMongoDBInput_1 = 0;
		


	

final String applicationName_tMongoDBInput_1 = "Talend";

	int nb_line_tMongoDBInput_1 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_1=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_1 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_1 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_1);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_1 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_1 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_1.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_1.hosts(addrs_tMongoDBInput_1);

                clientSettingsBuilder_tMongoDBInput_1.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_1.build()));



        mongo_tMongoDBInput_1 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_1.build());
        db_tMongoDBInput_1 = mongo_tMongoDBInput_1.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_1 = db_tMongoDBInput_1.getCollection(context.mongo_player_injuries);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_1 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_1.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_1.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_1.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_1 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_1 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_1 = coll_tMongoDBInput_1.find(myQuery_tMongoDBInput_1).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_1{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_1 dbObjectInputUtil_tMongoDBInput_1=new DBObjectInputUtil_tMongoDBInput_1();
				java.util.Map<String, String> pathMap_tMongoDBInput_1=new java.util.HashMap<>();
				pathMap_tMongoDBInput_1.put("player_id","");
				pathMap_tMongoDBInput_1.put("season_name","");
				pathMap_tMongoDBInput_1.put("injury_reason","");
				pathMap_tMongoDBInput_1.put("from_date","");
				pathMap_tMongoDBInput_1.put("end_date","");
				pathMap_tMongoDBInput_1.put("days_missed","");
				pathMap_tMongoDBInput_1.put("games_missed","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_1 = findIterable_tMongoDBInput_1.iterator();
						
				while (cursor_tMongoDBInput_1.hasNext()){
				org.bson.Document o_tMongoDBInput_1 = cursor_tMongoDBInput_1.next();
				nb_line_tMongoDBInput_1++;
				Object valueObj_tMongoDBInput_1=null;
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("player_id"),"player_id",o_tMongoDBInput_1);
					
				row1.player_id = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("season_name"),"season_name",o_tMongoDBInput_1);
					
				row1.season_name = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("injury_reason"),"injury_reason",o_tMongoDBInput_1);
					
				row1.injury_reason = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("from_date"),"from_date",o_tMongoDBInput_1);
					
				row1.from_date = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("end_date"),"end_date",o_tMongoDBInput_1);
					
				row1.end_date = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("days_missed"),"days_missed",o_tMongoDBInput_1);
					
				row1.days_missed = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("games_missed"),"games_missed",o_tMongoDBInput_1);
				if(valueObj_tMongoDBInput_1!=null && valueObj_tMongoDBInput_1.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_1.getClass().equals(Double.class)) {
                                row1.games_missed = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_1.toString()).intValue();
                            } else {
                                row1.games_missed = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_1.toString());
                            }
				}else{
					row1.games_missed = null;
				}


 



/**
 * [tMongoDBInput_1 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 


	tos_count_tMongoDBInput_1++;

/**
 * [tMongoDBInput_1 main ] stop
 */
	
	/**
	 * [tMongoDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGOUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					
	
operation_finder_tAggregateRow_2.player_id = row1.player_id;
			

	operation_finder_tAggregateRow_2.hashCodeDirty = true;
	
	operation_result_tAggregateRow_2 = hash_tAggregateRow_2.get(operation_finder_tAggregateRow_2);

	

	if(operation_result_tAggregateRow_2 == null) { // G_OutMain_AggR_001

		operation_result_tAggregateRow_2 = new AggOperationStruct_tAggregateRow_2();

		operation_result_tAggregateRow_2.player_id = operation_finder_tAggregateRow_2.player_id;
				
		
		

		hash_tAggregateRow_2.put(operation_result_tAggregateRow_2, operation_result_tAggregateRow_2);
	
	} // G_OutMain_AggR_001


	


 


	tos_count_tAggregateRow_2_AGGOUT++;

/**
 * [tAggregateRow_2_AGGOUT main ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGOUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

 



/**
 * [tAggregateRow_2_AGGOUT process_data_begin ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGOUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

 



/**
 * [tAggregateRow_2_AGGOUT process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

            }
                    if(mongo_tMongoDBInput_1 != null) {
                        mongo_tMongoDBInput_1.close();
                    }
    globalMap.put("tMongoDBInput_1_NB_LINE", nb_line_tMongoDBInput_1);
 

ok_Hash.put("tMongoDBInput_1", true);
end_Hash.put("tMongoDBInput_1", System.currentTimeMillis());




/**
 * [tMongoDBInput_1 end ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGOUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tAggregateRow_2_AGGOUT", true);
end_Hash.put("tAggregateRow_2_AGGOUT", System.currentTimeMillis());




/**
 * [tAggregateRow_2_AGGOUT end ] stop
 */



	
	/**
	 * [tMongoDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_1", false);
		start_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"sortieee");
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

                pathMap_tMongoDBOutput_1.put("minutes_played","");
                pathMap_tMongoDBOutput_1.put("player_slug","");
                pathMap_tMongoDBOutput_1.put("player_id","");
                pathMap_tMongoDBOutput_1.put("main_position","");
                pathMap_tMongoDBOutput_1.put("minutes_per_goals","");
                pathMap_tMongoDBOutput_1.put("goals","");
                pathMap_tMongoDBOutput_1.put("score_players","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_1=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_1=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBOutput_1 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBOutput_1 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBOutput_1);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBOutput_1 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBOutput_1 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBOutput_1.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBOutput_1.hosts(addrs_tMongoDBOutput_1);

                clientSettingsBuilder_tMongoDBOutput_1.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBOutput_1.build()));



        mongo_tMongoDBOutput_1 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBOutput_1.build());
        db_tMongoDBOutput_1 = mongo_tMongoDBOutput_1.getDatabase(context.mongo_database);

        db_tMongoDBOutput_1.getCollection(context.mongo_kpia).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_1 = db_tMongoDBOutput_1.getCollection(context.mongo_kpia);


 



/**
 * [tMongoDBOutput_1 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row8");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct>) 
					globalMap.get( "tHash_Lookup_row7" ))
					;					
					
	

row7Struct row7HashKey = new row7Struct();
row7Struct row7Default = new row7Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
	double days_missed;
	double assist_tot;
	double clean_sheets;
	double own_goals;
	double direct_red_cards;
	double minutes_per_goals;
	double score_players;
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
sortieeeStruct sortieee_tmp = new sortieeeStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
 */



	
	/**
	 * [tAggregateRow_2_AGGIN begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_2_AGGIN", false);
		start_Hash.put("tAggregateRow_2_AGGIN", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	
		int tos_count_tAggregateRow_2_AGGIN = 0;
		

java.util.Collection<AggOperationStruct_tAggregateRow_2> values_tAggregateRow_2 = hash_tAggregateRow_2.values();

globalMap.put("tAggregateRow_2_NB_LINE", values_tAggregateRow_2.size());

for(AggOperationStruct_tAggregateRow_2 aggregated_row_tAggregateRow_2 : values_tAggregateRow_2) { // G_AggR_600



 



/**
 * [tAggregateRow_2_AGGIN begin ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGIN main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

            				    row8.player_id = aggregated_row_tAggregateRow_2.player_id;
            				    

 


	tos_count_tAggregateRow_2_AGGIN++;

/**
 * [tAggregateRow_2_AGGIN main ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGIN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

 



/**
 * [tAggregateRow_2_AGGIN process_data_begin ] stop
 */

	
	/**
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row8"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row7" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow7 = false;
       		  	    	
       		  	    	
 							row7Struct row7ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    row7HashKey.player_id = row8.player_id ;
                        		    		

								
		                        	row7HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row7.lookup( row7HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row7 != null && tHash_Lookup_row7.getCount(row7HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row7' and it contains more one result from keys :  row7.player_id = '" + row7HashKey.player_id + "'");
								} // G 071
							

							row7Struct row7 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row7Struct fromLookup_row7 = null;
							row7 = row7Default;
										 
							
								 
							
							
								if (tHash_Lookup_row7 !=null && tHash_Lookup_row7.hasNext()) { // G 099
								
							
								
								fromLookup_row7 = tHash_Lookup_row7.next();

							
							
								} // G 099
							
							

							if(fromLookup_row7 != null) {
								row7 = fromLookup_row7;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    row3HashKey.player_id = row8.player_id ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
		  				
	  								
						
									
  									  		
 								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row3 != null && tHash_Lookup_row3.getCount(row3HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row3' and it contains more one result from keys :  row3.player_id = '" + row3HashKey.player_id + "'");
								} // G 071
							

							row3Struct row3 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row3Struct fromLookup_row3 = null;
							row3 = row3Default;
										 
							
								 
							
							
								if (tHash_Lookup_row3 !=null && tHash_Lookup_row3.hasNext()) { // G 099
								
							
								
								fromLookup_row3 = tHash_Lookup_row3.next();

							
							
								} // G 099
							
							

							if(fromLookup_row3 != null) {
								row3 = fromLookup_row3;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;
Var.days_missed = row8.days_missed == null || row8.days_missed.trim().isEmpty() ? 0.0 : Double.parseDouble(row8.days_missed) ;
Var.assist_tot = row7.assists == null ? 0.0 : Double.valueOf(row7.assists);
Var.clean_sheets = row7.clean_sheets == null ? 0.0 : Double.valueOf(row7.clean_sheets)
;
Var.own_goals = row7.own_goals == null ? 0.0 : Double.valueOf(row7.own_goals)
;
Var.direct_red_cards = row7.direct_red_cards == null ? 0.0 : Double.valueOf(row7.direct_red_cards)
;
Var.minutes_per_goals = (row7.goals == null || row7.goals == 0 
 || row7.minutes_played == null)
? 0
: row7.minutes_played / row7.goals ;
Var.score_players = (
  (row7.goals == null ? 0.0 : row7.goals) * 4
  + (Var.assist_tot) * 3
  + (Var.clean_sheets) * 2
  - (Var.own_goals) * 3
  - (Var.direct_red_cards) * 3
)
*
(
  (
    (row7.minutes_played == null ? 0.0 : row7.minutes_played)
    +
    ((Var.days_missed) * 90)
  ) == 0.0
  ? 0.0
  :
  (row7.minutes_played == null ? 0.0 : row7.minutes_played)
  /
  (
    (row7.minutes_played == null ? 0.0 : row7.minutes_played)
    +
    ((Var.days_missed) * 90)
  )
) ;// ###############################
        // ###############################
        // # Output tables

sortieee = null;


// # Output table : 'sortieee'
sortieee_tmp.minutes_played = row7.minutes_played;
sortieee_tmp.player_slug = row3.player_slug ;
sortieee_tmp.player_id = row8.player_id ;
sortieee_tmp.main_position = row3.main_position ;
sortieee_tmp.minutes_per_goals = Var.minutes_per_goals;
sortieee_tmp.goals = row7.goals ;
sortieee_tmp.score_players = Var.score_players ;
sortieee = sortieee_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_2 = false;










 


	tos_count_tMap_2++;

/**
 * [tMap_2 main ] stop
 */
	
	/**
	 * [tMap_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_begin ] stop
 */
// Start of branch "sortieee"
if(sortieee != null) { 



	
	/**
	 * [tMongoDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"sortieee"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_1.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("minutes_played"),"minutes_played", sortieee.minutes_played);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("player_slug"),"player_slug", sortieee.player_slug);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("player_id"),"player_id", sortieee.player_id);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("main_position"),"main_position", sortieee.main_position);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("minutes_per_goals"),"minutes_per_goals", sortieee.minutes_per_goals);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("goals"),"goals", sortieee.goals);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("score_players"),"score_players", sortieee.score_players);
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

} // End of branch "sortieee"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
 */



	
	/**
	 * [tAggregateRow_2_AGGIN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

 



/**
 * [tAggregateRow_2_AGGIN process_data_end ] stop
 */
	
	/**
	 * [tAggregateRow_2_AGGIN end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

} // G_AggR_600

 

ok_Hash.put("tAggregateRow_2_AGGIN", true);
end_Hash.put("tAggregateRow_2_AGGIN", System.currentTimeMillis());




/**
 * [tAggregateRow_2_AGGIN end ] stop
 */

	
	/**
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row7 != null) {
						tHash_Lookup_row7.endGet();
					}
					globalMap.remove( "tHash_Lookup_row7" );

					
					
				
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row8");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

		if(mongo_tMongoDBOutput_1 != null){
			
				mongo_tMongoDBOutput_1.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_1", true); 
		
	globalMap.put("tMongoDBOutput_1_NB_LINE", nb_line_tMongoDBOutput_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"sortieee");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_1", true);
end_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());




/**
 * [tMongoDBOutput_1 end ] stop
 */












				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_row3"); 
				     			
					     			//free memory for "tMap_2"
					     			globalMap.remove("tHash_Lookup_row7"); 
				     			
							//free memory for "tAggregateRow_2_AGGIN"
							globalMap.remove("tAggregateRow_2");
						
				try{
					
	
	/**
	 * [tMongoDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 finally ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGOUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGOUT";

	

 



/**
 * [tAggregateRow_2_AGGOUT finally ] stop
 */

	
	/**
	 * [tAggregateRow_2_AGGIN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_2";
	
	currentComponent="tAggregateRow_2_AGGIN";

	

 



/**
 * [tAggregateRow_2_AGGIN finally ] stop
 */

	
	/**
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	
		if(resourceMap.get("finish_tMongoDBOutput_1") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_1") != null){

		    
		    			
		    			       ((com.mongodb.client.MongoClient)resourceMap.get("mongo_tMongoDBOutput_1")).close();
		    
		    
			
			}
		}

 



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
		

		globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", 1);
	}
	


public static class row3Struct implements routines.system.IPersistableComparableLookupRow<row3Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row3Struct other = (row3Struct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row3Struct other) {

		other.player_id = this.player_id;
	            other.player_slug = this.player_slug;
	            other.player_name = this.player_name;
	            other.player_image_url = this.player_image_url;
	            other.date_of_birth = this.date_of_birth;
	            other.place_of_birth = this.place_of_birth;
	            other.country_of_birth = this.country_of_birth;
	            other.height = this.height;
	            other.citizenship = this.citizenship;
	            other.is_eu = this.is_eu;
	            other.position = this.position;
	            other.main_position = this.main_position;
	            other.foot = this.foot;
	            other.current_club_id = this.current_club_id;
	            other.current_club_name = this.current_club_name;
	            other.joined = this.joined;
	            other.contract_expires = this.contract_expires;
	            other.outfitter = this.outfitter;
	            other.social_media_url = this.social_media_url;
	            other.player_agent_id = this.player_agent_id;
	            other.player_agent_name = this.player_agent_name;
	            other.contract_option = this.contract_option;
	            other.date_of_last_contract_extension = this.date_of_last_contract_extension;
	            other.on_loan_from_club_id = this.on_loan_from_club_id;
	            other.on_loan_from_club_name = this.on_loan_from_club_name;
	            other.contract_there_expires = this.contract_there_expires;
	            other.second_club_url = this.second_club_url;
	            other.second_club_name = this.second_club_name;
	            other.third_club_url = this.third_club_url;
	            other.third_club_name = this.third_club_name;
	            other.fourth_club_url = this.fourth_club_url;
	            other.fourth_club_name = this.fourth_club_name;
	            other.date_of_death = this.date_of_death;
	            
	}

	public void copyKeysDataTo(row3Struct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.player_slug = readString(dis,ois);
					
						this.player_name = readString(dis,ois);
					
						this.player_image_url = readString(dis,ois);
					
						this.date_of_birth = readString(dis,ois);
					
						this.place_of_birth = readString(dis,ois);
					
						this.country_of_birth = readString(dis,ois);
					
						this.height = readString(dis,ois);
					
						this.citizenship = readString(dis,ois);
					
						this.is_eu = readString(dis,ois);
					
						this.position = readString(dis,ois);
					
						this.main_position = readString(dis,ois);
					
						this.foot = readString(dis,ois);
					
						this.current_club_id = readString(dis,ois);
					
						this.current_club_name = readString(dis,ois);
					
						this.joined = readString(dis,ois);
					
						this.contract_expires = readString(dis,ois);
					
						this.outfitter = readString(dis,ois);
					
						this.social_media_url = readString(dis,ois);
					
						this.player_agent_id = readString(dis,ois);
					
						this.player_agent_name = readString(dis,ois);
					
						this.contract_option = readString(dis,ois);
					
						this.date_of_last_contract_extension = readString(dis,ois);
					
						this.on_loan_from_club_id = readString(dis,ois);
					
						this.on_loan_from_club_name = readString(dis,ois);
					
						this.contract_there_expires = readString(dis,ois);
					
						this.second_club_url = readString(dis,ois);
					
						this.second_club_name = readString(dis,ois);
					
						this.third_club_url = readString(dis,ois);
					
						this.third_club_name = readString(dis,ois);
					
						this.fourth_club_url = readString(dis,ois);
					
						this.fourth_club_name = readString(dis,ois);
					
						this.date_of_death = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.player_slug = readString(dis,objectIn);
					
						this.player_name = readString(dis,objectIn);
					
						this.player_image_url = readString(dis,objectIn);
					
						this.date_of_birth = readString(dis,objectIn);
					
						this.place_of_birth = readString(dis,objectIn);
					
						this.country_of_birth = readString(dis,objectIn);
					
						this.height = readString(dis,objectIn);
					
						this.citizenship = readString(dis,objectIn);
					
						this.is_eu = readString(dis,objectIn);
					
						this.position = readString(dis,objectIn);
					
						this.main_position = readString(dis,objectIn);
					
						this.foot = readString(dis,objectIn);
					
						this.current_club_id = readString(dis,objectIn);
					
						this.current_club_name = readString(dis,objectIn);
					
						this.joined = readString(dis,objectIn);
					
						this.contract_expires = readString(dis,objectIn);
					
						this.outfitter = readString(dis,objectIn);
					
						this.social_media_url = readString(dis,objectIn);
					
						this.player_agent_id = readString(dis,objectIn);
					
						this.player_agent_name = readString(dis,objectIn);
					
						this.contract_option = readString(dis,objectIn);
					
						this.date_of_last_contract_extension = readString(dis,objectIn);
					
						this.on_loan_from_club_id = readString(dis,objectIn);
					
						this.on_loan_from_club_name = readString(dis,objectIn);
					
						this.contract_there_expires = readString(dis,objectIn);
					
						this.second_club_url = readString(dis,objectIn);
					
						this.second_club_name = readString(dis,objectIn);
					
						this.third_club_url = readString(dis,objectIn);
					
						this.third_club_name = readString(dis,objectIn);
					
						this.fourth_club_url = readString(dis,objectIn);
					
						this.fourth_club_name = readString(dis,objectIn);
					
						this.date_of_death = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.player_slug, dos, oos);
					
						writeString(this.player_name, dos, oos);
					
						writeString(this.player_image_url, dos, oos);
					
						writeString(this.date_of_birth, dos, oos);
					
						writeString(this.place_of_birth, dos, oos);
					
						writeString(this.country_of_birth, dos, oos);
					
						writeString(this.height, dos, oos);
					
						writeString(this.citizenship, dos, oos);
					
						writeString(this.is_eu, dos, oos);
					
						writeString(this.position, dos, oos);
					
						writeString(this.main_position, dos, oos);
					
						writeString(this.foot, dos, oos);
					
						writeString(this.current_club_id, dos, oos);
					
						writeString(this.current_club_name, dos, oos);
					
						writeString(this.joined, dos, oos);
					
						writeString(this.contract_expires, dos, oos);
					
						writeString(this.outfitter, dos, oos);
					
						writeString(this.social_media_url, dos, oos);
					
						writeString(this.player_agent_id, dos, oos);
					
						writeString(this.player_agent_name, dos, oos);
					
						writeString(this.contract_option, dos, oos);
					
						writeString(this.date_of_last_contract_extension, dos, oos);
					
						writeString(this.on_loan_from_club_id, dos, oos);
					
						writeString(this.on_loan_from_club_name, dos, oos);
					
						writeString(this.contract_there_expires, dos, oos);
					
						writeString(this.second_club_url, dos, oos);
					
						writeString(this.second_club_name, dos, oos);
					
						writeString(this.third_club_url, dos, oos);
					
						writeString(this.third_club_name, dos, oos);
					
						writeString(this.fourth_club_url, dos, oos);
					
						writeString(this.fourth_club_name, dos, oos);
					
						writeString(this.date_of_death, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.player_slug, dos, objectOut);
					
						writeString(this.player_name, dos, objectOut);
					
						writeString(this.player_image_url, dos, objectOut);
					
						writeString(this.date_of_birth, dos, objectOut);
					
						writeString(this.place_of_birth, dos, objectOut);
					
						writeString(this.country_of_birth, dos, objectOut);
					
						writeString(this.height, dos, objectOut);
					
						writeString(this.citizenship, dos, objectOut);
					
						writeString(this.is_eu, dos, objectOut);
					
						writeString(this.position, dos, objectOut);
					
						writeString(this.main_position, dos, objectOut);
					
						writeString(this.foot, dos, objectOut);
					
						writeString(this.current_club_id, dos, objectOut);
					
						writeString(this.current_club_name, dos, objectOut);
					
						writeString(this.joined, dos, objectOut);
					
						writeString(this.contract_expires, dos, objectOut);
					
						writeString(this.outfitter, dos, objectOut);
					
						writeString(this.social_media_url, dos, objectOut);
					
						writeString(this.player_agent_id, dos, objectOut);
					
						writeString(this.player_agent_name, dos, objectOut);
					
						writeString(this.contract_option, dos, objectOut);
					
						writeString(this.date_of_last_contract_extension, dos, objectOut);
					
						writeString(this.on_loan_from_club_id, dos, objectOut);
					
						writeString(this.on_loan_from_club_name, dos, objectOut);
					
						writeString(this.contract_there_expires, dos, objectOut);
					
						writeString(this.second_club_url, dos, objectOut);
					
						writeString(this.second_club_name, dos, objectOut);
					
						writeString(this.third_club_url, dos, objectOut);
					
						writeString(this.third_club_name, dos, objectOut);
					
						writeString(this.fourth_club_url, dos, objectOut);
					
						writeString(this.fourth_club_name, dos, objectOut);
					
						writeString(this.date_of_death, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
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
    public int compareTo(row3Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
public void tMongoDBInput_7Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_7_SUBPROCESS_STATE", 0);

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
	 * [tAdvancedHash_row3 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row3", false);
		start_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row3");
					}
				
		int tos_count_tAdvancedHash_row3 = 0;
		

			   		// connection name:row3
			   		// source node:tMongoDBInput_7 - inputs:(after_tMongoDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_2 - inputs:(row8,row3,row7) outputs:(sortieee)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_7", false);
		start_Hash.put("tMongoDBInput_7", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_7";

	
		int tos_count_tMongoDBInput_7 = 0;
		


	

final String applicationName_tMongoDBInput_7 = "Talend";

	int nb_line_tMongoDBInput_7 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_7=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_7=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_7 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_7 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_7);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_7 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_7 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_7.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_7.hosts(addrs_tMongoDBInput_7);

                clientSettingsBuilder_tMongoDBInput_7.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_7.build()));



        mongo_tMongoDBInput_7 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_7.build());
        db_tMongoDBInput_7 = mongo_tMongoDBInput_7.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_7 = db_tMongoDBInput_7.getCollection(context.mongo_player_profiles);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_7 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_7.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_7.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_7.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_7 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_7 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_7 = coll_tMongoDBInput_7.find(myQuery_tMongoDBInput_7).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_7{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_7 dbObjectInputUtil_tMongoDBInput_7=new DBObjectInputUtil_tMongoDBInput_7();
				java.util.Map<String, String> pathMap_tMongoDBInput_7=new java.util.HashMap<>();
				pathMap_tMongoDBInput_7.put("player_id","");
				pathMap_tMongoDBInput_7.put("player_slug","");
				pathMap_tMongoDBInput_7.put("player_name","");
				pathMap_tMongoDBInput_7.put("player_image_url","");
				pathMap_tMongoDBInput_7.put("date_of_birth","");
				pathMap_tMongoDBInput_7.put("place_of_birth","");
				pathMap_tMongoDBInput_7.put("country_of_birth","");
				pathMap_tMongoDBInput_7.put("height","");
				pathMap_tMongoDBInput_7.put("citizenship","");
				pathMap_tMongoDBInput_7.put("is_eu","");
				pathMap_tMongoDBInput_7.put("position","");
				pathMap_tMongoDBInput_7.put("main_position","");
				pathMap_tMongoDBInput_7.put("foot","");
				pathMap_tMongoDBInput_7.put("current_club_id","");
				pathMap_tMongoDBInput_7.put("current_club_name","");
				pathMap_tMongoDBInput_7.put("joined","");
				pathMap_tMongoDBInput_7.put("contract_expires","");
				pathMap_tMongoDBInput_7.put("outfitter","");
				pathMap_tMongoDBInput_7.put("social_media_url","");
				pathMap_tMongoDBInput_7.put("player_agent_id","");
				pathMap_tMongoDBInput_7.put("player_agent_name","");
				pathMap_tMongoDBInput_7.put("contract_option","");
				pathMap_tMongoDBInput_7.put("date_of_last_contract_extension","");
				pathMap_tMongoDBInput_7.put("on_loan_from_club_id","");
				pathMap_tMongoDBInput_7.put("on_loan_from_club_name","");
				pathMap_tMongoDBInput_7.put("contract_there_expires","");
				pathMap_tMongoDBInput_7.put("second_club_url","");
				pathMap_tMongoDBInput_7.put("second_club_name","");
				pathMap_tMongoDBInput_7.put("third_club_url","");
				pathMap_tMongoDBInput_7.put("third_club_name","");
				pathMap_tMongoDBInput_7.put("fourth_club_url","");
				pathMap_tMongoDBInput_7.put("fourth_club_name","");
				pathMap_tMongoDBInput_7.put("date_of_death","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_7 = findIterable_tMongoDBInput_7.iterator();
						
				while (cursor_tMongoDBInput_7.hasNext()){
				org.bson.Document o_tMongoDBInput_7 = cursor_tMongoDBInput_7.next();
				nb_line_tMongoDBInput_7++;
				Object valueObj_tMongoDBInput_7=null;
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("player_id"),"player_id",o_tMongoDBInput_7);
					
				row3.player_id = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("player_slug"),"player_slug",o_tMongoDBInput_7);
					
				row3.player_slug = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("player_name"),"player_name",o_tMongoDBInput_7);
					
				row3.player_name = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("player_image_url"),"player_image_url",o_tMongoDBInput_7);
					
				row3.player_image_url = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("date_of_birth"),"date_of_birth",o_tMongoDBInput_7);
					
				row3.date_of_birth = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("place_of_birth"),"place_of_birth",o_tMongoDBInput_7);
					
				row3.place_of_birth = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("country_of_birth"),"country_of_birth",o_tMongoDBInput_7);
					
				row3.country_of_birth = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("height"),"height",o_tMongoDBInput_7);
					
				row3.height = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("citizenship"),"citizenship",o_tMongoDBInput_7);
					
				row3.citizenship = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("is_eu"),"is_eu",o_tMongoDBInput_7);
					
				row3.is_eu = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("position"),"position",o_tMongoDBInput_7);
					
				row3.position = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("main_position"),"main_position",o_tMongoDBInput_7);
					
				row3.main_position = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("foot"),"foot",o_tMongoDBInput_7);
					
				row3.foot = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("current_club_id"),"current_club_id",o_tMongoDBInput_7);
					
				row3.current_club_id = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("current_club_name"),"current_club_name",o_tMongoDBInput_7);
					
				row3.current_club_name = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("joined"),"joined",o_tMongoDBInput_7);
					
				row3.joined = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("contract_expires"),"contract_expires",o_tMongoDBInput_7);
					
				row3.contract_expires = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("outfitter"),"outfitter",o_tMongoDBInput_7);
					
				row3.outfitter = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("social_media_url"),"social_media_url",o_tMongoDBInput_7);
					
				row3.social_media_url = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("player_agent_id"),"player_agent_id",o_tMongoDBInput_7);
					
				row3.player_agent_id = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("player_agent_name"),"player_agent_name",o_tMongoDBInput_7);
					
				row3.player_agent_name = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("contract_option"),"contract_option",o_tMongoDBInput_7);
					
				row3.contract_option = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("date_of_last_contract_extension"),"date_of_last_contract_extension",o_tMongoDBInput_7);
					
				row3.date_of_last_contract_extension = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("on_loan_from_club_id"),"on_loan_from_club_id",o_tMongoDBInput_7);
					
				row3.on_loan_from_club_id = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("on_loan_from_club_name"),"on_loan_from_club_name",o_tMongoDBInput_7);
					
				row3.on_loan_from_club_name = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("contract_there_expires"),"contract_there_expires",o_tMongoDBInput_7);
					
				row3.contract_there_expires = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("second_club_url"),"second_club_url",o_tMongoDBInput_7);
					
				row3.second_club_url = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("second_club_name"),"second_club_name",o_tMongoDBInput_7);
					
				row3.second_club_name = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("third_club_url"),"third_club_url",o_tMongoDBInput_7);
					
				row3.third_club_url = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("third_club_name"),"third_club_name",o_tMongoDBInput_7);
					
				row3.third_club_name = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("fourth_club_url"),"fourth_club_url",o_tMongoDBInput_7);
					
				row3.fourth_club_url = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("fourth_club_name"),"fourth_club_name",o_tMongoDBInput_7);
					
				row3.fourth_club_name = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				
                    valueObj_tMongoDBInput_7=dbObjectInputUtil_tMongoDBInput_7.getValue(pathMap_tMongoDBInput_7.get("date_of_death"),"date_of_death",o_tMongoDBInput_7);
					
				row3.date_of_death = valueObj_tMongoDBInput_7==null ? null : valueObj_tMongoDBInput_7.toString();
				


 



/**
 * [tMongoDBInput_7 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_7 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_7";

	

 


	tos_count_tMongoDBInput_7++;

/**
 * [tMongoDBInput_7 main ] stop
 */
	
	/**
	 * [tMongoDBInput_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_7";

	

 



/**
 * [tMongoDBInput_7 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row3"
						
						);
					}
					


			   
			   

					row3Struct row3_HashRow = new row3Struct();
		   	   	   
				
				row3_HashRow.player_id = row3.player_id;
				
				row3_HashRow.player_slug = row3.player_slug;
				
				row3_HashRow.player_name = row3.player_name;
				
				row3_HashRow.player_image_url = row3.player_image_url;
				
				row3_HashRow.date_of_birth = row3.date_of_birth;
				
				row3_HashRow.place_of_birth = row3.place_of_birth;
				
				row3_HashRow.country_of_birth = row3.country_of_birth;
				
				row3_HashRow.height = row3.height;
				
				row3_HashRow.citizenship = row3.citizenship;
				
				row3_HashRow.is_eu = row3.is_eu;
				
				row3_HashRow.position = row3.position;
				
				row3_HashRow.main_position = row3.main_position;
				
				row3_HashRow.foot = row3.foot;
				
				row3_HashRow.current_club_id = row3.current_club_id;
				
				row3_HashRow.current_club_name = row3.current_club_name;
				
				row3_HashRow.joined = row3.joined;
				
				row3_HashRow.contract_expires = row3.contract_expires;
				
				row3_HashRow.outfitter = row3.outfitter;
				
				row3_HashRow.social_media_url = row3.social_media_url;
				
				row3_HashRow.player_agent_id = row3.player_agent_id;
				
				row3_HashRow.player_agent_name = row3.player_agent_name;
				
				row3_HashRow.contract_option = row3.contract_option;
				
				row3_HashRow.date_of_last_contract_extension = row3.date_of_last_contract_extension;
				
				row3_HashRow.on_loan_from_club_id = row3.on_loan_from_club_id;
				
				row3_HashRow.on_loan_from_club_name = row3.on_loan_from_club_name;
				
				row3_HashRow.contract_there_expires = row3.contract_there_expires;
				
				row3_HashRow.second_club_url = row3.second_club_url;
				
				row3_HashRow.second_club_name = row3.second_club_name;
				
				row3_HashRow.third_club_url = row3.third_club_url;
				
				row3_HashRow.third_club_name = row3.third_club_name;
				
				row3_HashRow.fourth_club_url = row3.fourth_club_url;
				
				row3_HashRow.fourth_club_name = row3.fourth_club_name;
				
				row3_HashRow.date_of_death = row3.date_of_death;
				
			tHash_Lookup_row3.put(row3_HashRow);
			
            




 


	tos_count_tAdvancedHash_row3++;

/**
 * [tAdvancedHash_row3 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row3 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_7";

	

 



/**
 * [tMongoDBInput_7 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_7 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_7";

	

            }
                    if(mongo_tMongoDBInput_7 != null) {
                        mongo_tMongoDBInput_7.close();
                    }
    globalMap.put("tMongoDBInput_7_NB_LINE", nb_line_tMongoDBInput_7);
 

ok_Hash.put("tMongoDBInput_7", true);
end_Hash.put("tMongoDBInput_7", System.currentTimeMillis());




/**
 * [tMongoDBInput_7 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

tHash_Lookup_row3.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row3");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row3", true);
end_Hash.put("tAdvancedHash_row3", System.currentTimeMillis());




/**
 * [tAdvancedHash_row3 end ] stop
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
	 * [tMongoDBInput_7 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_7";

	

 



/**
 * [tMongoDBInput_7 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row3 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row3";

	

 



/**
 * [tAdvancedHash_row3 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBInput_7_SUBPROCESS_STATE", 1);
	}
	


public static class row7Struct implements routines.system.IPersistableComparableLookupRow<row7Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Double goals;

				public Double getGoals () {
					return this.goals;
				}
				
			    public Integer assists;

				public Integer getAssists () {
					return this.assists;
				}
				
			    public Integer own_goals;

				public Integer getOwn_goals () {
					return this.own_goals;
				}
				
			    public Long subed_in;

				public Long getSubed_in () {
					return this.subed_in;
				}
				
			    public Integer subed_out;

				public Integer getSubed_out () {
					return this.subed_out;
				}
				
			    public Integer yellow_cards;

				public Integer getYellow_cards () {
					return this.yellow_cards;
				}
				
			    public Integer second_yellow_cards;

				public Integer getSecond_yellow_cards () {
					return this.second_yellow_cards;
				}
				
			    public Integer direct_red_cards;

				public Integer getDirect_red_cards () {
					return this.direct_red_cards;
				}
				
			    public Integer penalty_goals;

				public Integer getPenalty_goals () {
					return this.penalty_goals;
				}
				
			    public Double minutes_played;

				public Double getMinutes_played () {
					return this.minutes_played;
				}
				
			    public Integer goals_conceded;

				public Integer getGoals_conceded () {
					return this.goals_conceded;
				}
				
			    public Integer clean_sheets;

				public Integer getClean_sheets () {
					return this.clean_sheets;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row7Struct other = (row7Struct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row7Struct other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.competition_id = this.competition_id;
	            other.competition_name = this.competition_name;
	            other.team_id = this.team_id;
	            other.team_name = this.team_name;
	            other.nb_in_group = this.nb_in_group;
	            other.nb_on_pitch = this.nb_on_pitch;
	            other.goals = this.goals;
	            other.assists = this.assists;
	            other.own_goals = this.own_goals;
	            other.subed_in = this.subed_in;
	            other.subed_out = this.subed_out;
	            other.yellow_cards = this.yellow_cards;
	            other.second_yellow_cards = this.second_yellow_cards;
	            other.direct_red_cards = this.direct_red_cards;
	            other.penalty_goals = this.penalty_goals;
	            other.minutes_played = this.minutes_played;
	            other.goals_conceded = this.goals_conceded;
	            other.clean_sheets = this.clean_sheets;
	            
	}

	public void copyKeysDataTo(row7Struct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	
	private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			dis.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			byte[] byteArray = new byte[length];
			unmarshaller.read(byteArray);
			strReturn = new String(byteArray, utf8Charset);
		}
		return strReturn;
	}
	
	private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
	}

	private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
	}
	private Integer readInteger(DataInputStream dis, ObjectInputStream ois) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		Integer intReturn;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
			intReturn = unmarshaller.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, DataOutputStream dos,org.jboss.marshalling.Marshaller marshaller ) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.season_name = readString(dis,ois);
					
						this.competition_id = readString(dis,ois);
					
						this.competition_name = readString(dis,ois);
					
						this.team_id = readString(dis,ois);
					
						this.team_name = readString(dis,ois);
					
						this.nb_in_group = readString(dis,ois);
					
						this.nb_on_pitch = readString(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis,ois);
					
						this.own_goals = readInteger(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis,ois);
					
						this.yellow_cards = readInteger(dis,ois);
					
						this.second_yellow_cards = readInteger(dis,ois);
					
						this.direct_red_cards = readInteger(dis,ois);
					
						this.penalty_goals = readInteger(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis,ois);
					
						this.clean_sheets = readInteger(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.season_name = readString(dis,objectIn);
					
						this.competition_id = readString(dis,objectIn);
					
						this.competition_name = readString(dis,objectIn);
					
						this.team_id = readString(dis,objectIn);
					
						this.team_name = readString(dis,objectIn);
					
						this.nb_in_group = readString(dis,objectIn);
					
						this.nb_on_pitch = readString(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = objectIn.readDouble();
           				}
					
						this.assists = readInteger(dis,objectIn);
					
						this.own_goals = readInteger(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = objectIn.readLong();
           				}
					
						this.subed_out = readInteger(dis,objectIn);
					
						this.yellow_cards = readInteger(dis,objectIn);
					
						this.second_yellow_cards = readInteger(dis,objectIn);
					
						this.direct_red_cards = readInteger(dis,objectIn);
					
						this.penalty_goals = readInteger(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = objectIn.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis,objectIn);
					
						this.clean_sheets = readInteger(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.season_name, dos, oos);
					
						writeString(this.competition_id, dos, oos);
					
						writeString(this.competition_name, dos, oos);
					
						writeString(this.team_id, dos, oos);
					
						writeString(this.team_name, dos, oos);
					
						writeString(this.nb_in_group, dos, oos);
					
						writeString(this.nb_on_pitch, dos, oos);
					
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					writeInteger(this.assists, dos, oos);
					
					writeInteger(this.own_goals, dos, oos);
					
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					writeInteger(this.subed_out, dos, oos);
					
					writeInteger(this.yellow_cards, dos, oos);
					
					writeInteger(this.second_yellow_cards, dos, oos);
					
					writeInteger(this.direct_red_cards, dos, oos);
					
					writeInteger(this.penalty_goals, dos, oos);
					
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					writeInteger(this.goals_conceded, dos, oos);
					
					writeInteger(this.clean_sheets, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.season_name, dos, objectOut);
					
						writeString(this.competition_id, dos, objectOut);
					
						writeString(this.competition_name, dos, objectOut);
					
						writeString(this.team_id, dos, objectOut);
					
						writeString(this.team_name, dos, objectOut);
					
						writeString(this.nb_in_group, dos, objectOut);
					
						writeString(this.nb_on_pitch, dos, objectOut);
					
						if(this.goals == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.goals);
		            	}
					
					writeInteger(this.assists, dos, objectOut);
					
					writeInteger(this.own_goals, dos, objectOut);
					
						if(this.subed_in == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeLong(this.subed_in);
		            	}
					
					writeInteger(this.subed_out, dos, objectOut);
					
					writeInteger(this.yellow_cards, dos, objectOut);
					
					writeInteger(this.second_yellow_cards, dos, objectOut);
					
					writeInteger(this.direct_red_cards, dos, objectOut);
					
					writeInteger(this.penalty_goals, dos, objectOut);
					
						if(this.minutes_played == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeDouble(this.minutes_played);
		            	}
					
					writeInteger(this.goals_conceded, dos, objectOut);
					
					writeInteger(this.clean_sheets, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
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
		sb.append(",goals="+String.valueOf(goals));
		sb.append(",assists="+String.valueOf(assists));
		sb.append(",own_goals="+String.valueOf(own_goals));
		sb.append(",subed_in="+String.valueOf(subed_in));
		sb.append(",subed_out="+String.valueOf(subed_out));
		sb.append(",yellow_cards="+String.valueOf(yellow_cards));
		sb.append(",second_yellow_cards="+String.valueOf(second_yellow_cards));
		sb.append(",direct_red_cards="+String.valueOf(direct_red_cards));
		sb.append(",penalty_goals="+String.valueOf(penalty_goals));
		sb.append(",minutes_played="+String.valueOf(minutes_played));
		sb.append(",goals_conceded="+String.valueOf(goals_conceded));
		sb.append(",clean_sheets="+String.valueOf(clean_sheets));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row7Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class OnRowsEndStructtAggregateRow_1 implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_1> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Double goals;

				public Double getGoals () {
					return this.goals;
				}
				
			    public Integer assists;

				public Integer getAssists () {
					return this.assists;
				}
				
			    public Integer own_goals;

				public Integer getOwn_goals () {
					return this.own_goals;
				}
				
			    public Long subed_in;

				public Long getSubed_in () {
					return this.subed_in;
				}
				
			    public Integer subed_out;

				public Integer getSubed_out () {
					return this.subed_out;
				}
				
			    public Integer yellow_cards;

				public Integer getYellow_cards () {
					return this.yellow_cards;
				}
				
			    public Integer second_yellow_cards;

				public Integer getSecond_yellow_cards () {
					return this.second_yellow_cards;
				}
				
			    public Integer direct_red_cards;

				public Integer getDirect_red_cards () {
					return this.direct_red_cards;
				}
				
			    public Integer penalty_goals;

				public Integer getPenalty_goals () {
					return this.penalty_goals;
				}
				
			    public Double minutes_played;

				public Double getMinutes_played () {
					return this.minutes_played;
				}
				
			    public Integer goals_conceded;

				public Integer getGoals_conceded () {
					return this.goals_conceded;
				}
				
			    public Integer clean_sheets;

				public Integer getClean_sheets () {
					return this.clean_sheets;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final OnRowsEndStructtAggregateRow_1 other = (OnRowsEndStructtAggregateRow_1) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(OnRowsEndStructtAggregateRow_1 other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.competition_id = this.competition_id;
	            other.competition_name = this.competition_name;
	            other.team_id = this.team_id;
	            other.team_name = this.team_name;
	            other.nb_in_group = this.nb_in_group;
	            other.nb_on_pitch = this.nb_on_pitch;
	            other.goals = this.goals;
	            other.assists = this.assists;
	            other.own_goals = this.own_goals;
	            other.subed_in = this.subed_in;
	            other.subed_out = this.subed_out;
	            other.yellow_cards = this.yellow_cards;
	            other.second_yellow_cards = this.second_yellow_cards;
	            other.direct_red_cards = this.direct_red_cards;
	            other.penalty_goals = this.penalty_goals;
	            other.minutes_played = this.minutes_played;
	            other.goals_conceded = this.goals_conceded;
	            other.clean_sheets = this.clean_sheets;
	            
	}

	public void copyKeysDataTo(OnRowsEndStructtAggregateRow_1 other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
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
		sb.append(",goals="+String.valueOf(goals));
		sb.append(",assists="+String.valueOf(assists));
		sb.append(",own_goals="+String.valueOf(own_goals));
		sb.append(",subed_in="+String.valueOf(subed_in));
		sb.append(",subed_out="+String.valueOf(subed_out));
		sb.append(",yellow_cards="+String.valueOf(yellow_cards));
		sb.append(",second_yellow_cards="+String.valueOf(second_yellow_cards));
		sb.append(",direct_red_cards="+String.valueOf(direct_red_cards));
		sb.append(",penalty_goals="+String.valueOf(penalty_goals));
		sb.append(",minutes_played="+String.valueOf(minutes_played));
		sb.append(",goals_conceded="+String.valueOf(goals_conceded));
		sb.append(",clean_sheets="+String.valueOf(clean_sheets));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(OnRowsEndStructtAggregateRow_1 other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Double goals;

				public Double getGoals () {
					return this.goals;
				}
				
			    public Integer assists;

				public Integer getAssists () {
					return this.assists;
				}
				
			    public Integer own_goals;

				public Integer getOwn_goals () {
					return this.own_goals;
				}
				
			    public Long subed_in;

				public Long getSubed_in () {
					return this.subed_in;
				}
				
			    public Integer subed_out;

				public Integer getSubed_out () {
					return this.subed_out;
				}
				
			    public Integer yellow_cards;

				public Integer getYellow_cards () {
					return this.yellow_cards;
				}
				
			    public Integer second_yellow_cards;

				public Integer getSecond_yellow_cards () {
					return this.second_yellow_cards;
				}
				
			    public Integer direct_red_cards;

				public Integer getDirect_red_cards () {
					return this.direct_red_cards;
				}
				
			    public Integer penalty_goals;

				public Integer getPenalty_goals () {
					return this.penalty_goals;
				}
				
			    public Double minutes_played;

				public Double getMinutes_played () {
					return this.minutes_played;
				}
				
			    public Integer goals_conceded;

				public Integer getGoals_conceded () {
					return this.goals_conceded;
				}
				
			    public Integer clean_sheets;

				public Integer getClean_sheets () {
					return this.clean_sheets;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row4Struct other = (row4Struct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row4Struct other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.competition_id = this.competition_id;
	            other.competition_name = this.competition_name;
	            other.team_id = this.team_id;
	            other.team_name = this.team_name;
	            other.nb_in_group = this.nb_in_group;
	            other.nb_on_pitch = this.nb_on_pitch;
	            other.goals = this.goals;
	            other.assists = this.assists;
	            other.own_goals = this.own_goals;
	            other.subed_in = this.subed_in;
	            other.subed_out = this.subed_out;
	            other.yellow_cards = this.yellow_cards;
	            other.second_yellow_cards = this.second_yellow_cards;
	            other.direct_red_cards = this.direct_red_cards;
	            other.penalty_goals = this.penalty_goals;
	            other.minutes_played = this.minutes_played;
	            other.goals_conceded = this.goals_conceded;
	            other.clean_sheets = this.clean_sheets;
	            
	}

	public void copyKeysDataTo(row4Struct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
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
		sb.append(",goals="+String.valueOf(goals));
		sb.append(",assists="+String.valueOf(assists));
		sb.append(",own_goals="+String.valueOf(own_goals));
		sb.append(",subed_in="+String.valueOf(subed_in));
		sb.append(",subed_out="+String.valueOf(subed_out));
		sb.append(",yellow_cards="+String.valueOf(yellow_cards));
		sb.append(",second_yellow_cards="+String.valueOf(second_yellow_cards));
		sb.append(",direct_red_cards="+String.valueOf(direct_red_cards));
		sb.append(",penalty_goals="+String.valueOf(penalty_goals));
		sb.append(",minutes_played="+String.valueOf(minutes_played));
		sb.append(",goals_conceded="+String.valueOf(goals_conceded));
		sb.append(",clean_sheets="+String.valueOf(clean_sheets));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row4Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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
public void tMongoDBInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_3_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
		String currentVirtualComponent = null;
	
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
row7Struct row7 = new row7Struct();




	
	/**
	 * [tAggregateRow_1_AGGOUT begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGOUT", false);
		start_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAggregateRow_1_AGGOUT = 0;
		

// ------------ Seems it is not used

java.util.Map hashAggreg_tAggregateRow_1 = new java.util.HashMap(); 

// ------------

	class UtilClass_tAggregateRow_1 { // G_OutBegin_AggR_144

		public double sd(Double[] data) {
	        final int n = data.length;
        	if (n < 2) {
	            return Double.NaN;
        	}
        	double d1 = 0d;
        	double d2 =0d;
	        
	        for (int i = 0; i < data.length; i++) {
            	d1 += (data[i]*data[i]);
            	d2 += data[i];
        	}
        
	        return Math.sqrt((n*d1 - d2*d2)/n/(n-1));
	    }
	    
		public void checkedIADD(byte a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		    byte r = (byte) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'short/Short'", "'byte/Byte'"));
		    }
		}
		
		public void checkedIADD(short a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		    short r = (short) (a + b);
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'int/Integer'", "'short/Short'"));
		    }
		}
		
		public void checkedIADD(int a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		    int r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'long/Long'", "'int/Integer'"));
		    }
		}
		
		public void checkedIADD(long a, long b, boolean checkTypeOverFlow, boolean checkUlp) {
		    long r = a + b;
		    if (checkTypeOverFlow && ((a ^ r) & (b ^ r)) < 0) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'long/Long'"));
		    }
		}
		
		public void checkedIADD(float a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    float minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
			    }
			}
			
		    if (checkTypeOverFlow && ((double) a + (double) b > (double) Float.MAX_VALUE) || ((double) a + (double) b < (double) -Float.MAX_VALUE)) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'double' or 'BigDecimal'", "'float/Float'"));
		    }
		}
		
		public void checkedIADD(double a, double b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, byte b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, short b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, int b, boolean checkTypeOverFlow, boolean checkUlp) {
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		public void checkedIADD(double a, float b, boolean checkTypeOverFlow, boolean checkUlp) {
		
			if(checkUlp) {
			    double minAddedValue = Math.ulp(a);
			    if (minAddedValue > Math.abs(b)) {
			        throw new RuntimeException(buildPrecisionMessage(String.valueOf(a), String.valueOf(a), "'BigDecimal'", "'double/Double'"));
			    }
			}
		
		    if (checkTypeOverFlow && (a + b > (double) Double.MAX_VALUE) || (a + b < -Double.MAX_VALUE )) {
		        throw new RuntimeException(buildOverflowMessage(String.valueOf(a), String.valueOf(b), "'BigDecimal'", "'double/Double'"));
		    }
		}
		
		private String buildOverflowMessage(String a, String b, String advicedTypes, String originalType) {
		    return "Type overflow when adding " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}
		
		private String buildPrecisionMessage(String a, String b, String advicedTypes, String originalType) {
		    return "The double precision is unsufficient to add the value " + b + " to " + a
		    + ", to resolve this problem, increase the precision by using "+ advicedTypes +" type in place of "+ originalType +".";
		}

	} // G_OutBegin_AggR_144

	UtilClass_tAggregateRow_1 utilClass_tAggregateRow_1 = new UtilClass_tAggregateRow_1();

	

	class AggOperationStruct_tAggregateRow_1 { // G_OutBegin_AggR_100

		private static final int DEFAULT_HASHCODE = 1;
	    private static final int PRIME = 31;
	    private int hashCode = DEFAULT_HASHCODE;
	    public boolean hashCodeDirty = true;

    				String player_id;BigDecimal goals_sum;
           			BigDecimal minutes_played_sum;
           			
         			Integer assists_sum;
         			Integer clean_sheets_sum;
         			Integer direct_red_cards_sum;
        
	    @Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;
		
							result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
							
	    		this.hashCode = result;
	    		this.hashCodeDirty = false;		
			}
			return this.hashCode;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			final AggOperationStruct_tAggregateRow_1 other = (AggOperationStruct_tAggregateRow_1) obj;
			
							if (this.player_id == null) {
								if (other.player_id != null) 
									return false;
							} else if (!this.player_id.equals(other.player_id)) 
								return false;
						
			
			return true;
		}
  
        
	} // G_OutBegin_AggR_100

	AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
	AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
	java.util.Map<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1>();
	

 



/**
 * [tAggregateRow_1_AGGOUT begin ] stop
 */



	
	/**
	 * [tMongoDBInput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_3", false);
		start_Hash.put("tMongoDBInput_3", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_3";

	
		int tos_count_tMongoDBInput_3 = 0;
		


	

final String applicationName_tMongoDBInput_3 = "Talend";

	int nb_line_tMongoDBInput_3 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_3=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_3=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_3 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_3 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_3);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_3 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_3 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_3.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_3.hosts(addrs_tMongoDBInput_3);

                clientSettingsBuilder_tMongoDBInput_3.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_3.build()));



        mongo_tMongoDBInput_3 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_3.build());
        db_tMongoDBInput_3 = mongo_tMongoDBInput_3.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_3 = db_tMongoDBInput_3.getCollection(context.mongo_player_performances);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_3 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_3.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_3.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_3.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_3 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_3 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_3 = coll_tMongoDBInput_3.find(myQuery_tMongoDBInput_3).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_3{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_3 dbObjectInputUtil_tMongoDBInput_3=new DBObjectInputUtil_tMongoDBInput_3();
				java.util.Map<String, String> pathMap_tMongoDBInput_3=new java.util.HashMap<>();
				pathMap_tMongoDBInput_3.put("player_id","");
				pathMap_tMongoDBInput_3.put("season_name","");
				pathMap_tMongoDBInput_3.put("competition_id","");
				pathMap_tMongoDBInput_3.put("competition_name","");
				pathMap_tMongoDBInput_3.put("team_id","");
				pathMap_tMongoDBInput_3.put("team_name","");
				pathMap_tMongoDBInput_3.put("nb_in_group","");
				pathMap_tMongoDBInput_3.put("nb_on_pitch","");
				pathMap_tMongoDBInput_3.put("goals","");
				pathMap_tMongoDBInput_3.put("assists","");
				pathMap_tMongoDBInput_3.put("own_goals","");
				pathMap_tMongoDBInput_3.put("subed_in","");
				pathMap_tMongoDBInput_3.put("subed_out","");
				pathMap_tMongoDBInput_3.put("yellow_cards","");
				pathMap_tMongoDBInput_3.put("second_yellow_cards","");
				pathMap_tMongoDBInput_3.put("direct_red_cards","");
				pathMap_tMongoDBInput_3.put("penalty_goals","");
				pathMap_tMongoDBInput_3.put("minutes_played","");
				pathMap_tMongoDBInput_3.put("goals_conceded","");
				pathMap_tMongoDBInput_3.put("clean_sheets","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_3 = findIterable_tMongoDBInput_3.iterator();
						
				while (cursor_tMongoDBInput_3.hasNext()){
				org.bson.Document o_tMongoDBInput_3 = cursor_tMongoDBInput_3.next();
				nb_line_tMongoDBInput_3++;
				Object valueObj_tMongoDBInput_3=null;
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("player_id"),"player_id",o_tMongoDBInput_3);
					
				row4.player_id = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("season_name"),"season_name",o_tMongoDBInput_3);
					
				row4.season_name = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("competition_id"),"competition_id",o_tMongoDBInput_3);
					
				row4.competition_id = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("competition_name"),"competition_name",o_tMongoDBInput_3);
					
				row4.competition_name = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("team_id"),"team_id",o_tMongoDBInput_3);
					
				row4.team_id = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("team_name"),"team_name",o_tMongoDBInput_3);
					
				row4.team_name = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("nb_in_group"),"nb_in_group",o_tMongoDBInput_3);
					
				row4.nb_in_group = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("nb_on_pitch"),"nb_on_pitch",o_tMongoDBInput_3);
					
				row4.nb_on_pitch = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("goals"),"goals",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            row4.goals = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString());
				}else{
					row4.goals = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("assists"),"assists",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.assists = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.assists = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.assists = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("own_goals"),"own_goals",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.own_goals = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.own_goals = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.own_goals = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("subed_in"),"subed_in",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.subed_in = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).longValue();
                            } else {
                                row4.subed_in = ParserUtils.parseTo_Long(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.subed_in = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("subed_out"),"subed_out",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.subed_out = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.subed_out = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.subed_out = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("yellow_cards"),"yellow_cards",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.yellow_cards = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.yellow_cards = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.yellow_cards = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("second_yellow_cards"),"second_yellow_cards",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.second_yellow_cards = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.second_yellow_cards = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.second_yellow_cards = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("direct_red_cards"),"direct_red_cards",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.direct_red_cards = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.direct_red_cards = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.direct_red_cards = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("penalty_goals"),"penalty_goals",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.penalty_goals = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.penalty_goals = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.penalty_goals = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("minutes_played"),"minutes_played",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            row4.minutes_played = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString());
				}else{
					row4.minutes_played = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("goals_conceded"),"goals_conceded",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.goals_conceded = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.goals_conceded = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.goals_conceded = null;
				}
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("clean_sheets"),"clean_sheets",o_tMongoDBInput_3);
				if(valueObj_tMongoDBInput_3!=null && valueObj_tMongoDBInput_3.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_3.getClass().equals(Double.class)) {
                                row4.clean_sheets = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_3.toString()).intValue();
                            } else {
                                row4.clean_sheets = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_3.toString());
                            }
				}else{
					row4.clean_sheets = null;
				}


 



/**
 * [tMongoDBInput_3 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_3 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 


	tos_count_tMongoDBInput_3++;

/**
 * [tMongoDBInput_3 main ] stop
 */
	
	/**
	 * [tMongoDBInput_3 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 process_data_begin ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					
	
operation_finder_tAggregateRow_1.player_id = row4.player_id;
			

	operation_finder_tAggregateRow_1.hashCodeDirty = true;
	
	operation_result_tAggregateRow_1 = hash_tAggregateRow_1.get(operation_finder_tAggregateRow_1);

	

	if(operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

		operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

		operation_result_tAggregateRow_1.player_id = operation_finder_tAggregateRow_1.player_id;
				
		
		

		hash_tAggregateRow_1.put(operation_result_tAggregateRow_1, operation_result_tAggregateRow_1);
	
	} // G_OutMain_AggR_001


	
				if(row4.goals != null) { // G_OutMain_AggR_546
				
					if(operation_result_tAggregateRow_1.goals_sum == null) {
						operation_result_tAggregateRow_1.goals_sum = new BigDecimal(0);
					}
					operation_result_tAggregateRow_1.goals_sum = operation_result_tAggregateRow_1.goals_sum.add(
						new BigDecimal(
							String.valueOf(
								row4.goals
							)
						)
					);
					
				} // G_OutMain_AggR_546
				
				if(row4.minutes_played != null) { // G_OutMain_AggR_546
				
					if(operation_result_tAggregateRow_1.minutes_played_sum == null) {
						operation_result_tAggregateRow_1.minutes_played_sum = new BigDecimal(0);
					}
					operation_result_tAggregateRow_1.minutes_played_sum = operation_result_tAggregateRow_1.minutes_played_sum.add(
						new BigDecimal(
							String.valueOf(
								row4.minutes_played
							)
						)
					);
					
				} // G_OutMain_AggR_546
				
				if(row4.assists != null) { // G_OutMain_AggR_546
				
					if(operation_result_tAggregateRow_1.assists_sum == null) {
						operation_result_tAggregateRow_1.assists_sum = (int) 0;
					}
					
					if( row4.assists != null)
						operation_result_tAggregateRow_1.assists_sum += row4.assists;
				} // G_OutMain_AggR_546
				
				if(row4.clean_sheets != null) { // G_OutMain_AggR_546
				
					if(operation_result_tAggregateRow_1.clean_sheets_sum == null) {
						operation_result_tAggregateRow_1.clean_sheets_sum = (int) 0;
					}
					
					if( row4.clean_sheets != null)
						operation_result_tAggregateRow_1.clean_sheets_sum += row4.clean_sheets;
				} // G_OutMain_AggR_546
				
				if(row4.direct_red_cards != null) { // G_OutMain_AggR_546
				
					if(operation_result_tAggregateRow_1.direct_red_cards_sum == null) {
						operation_result_tAggregateRow_1.direct_red_cards_sum = (int) 0;
					}
					
					if( row4.direct_red_cards != null)
						operation_result_tAggregateRow_1.direct_red_cards_sum += row4.direct_red_cards;
				} // G_OutMain_AggR_546
				


 


	tos_count_tAggregateRow_1_AGGOUT++;

/**
 * [tAggregateRow_1_AGGOUT main ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGOUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT process_data_begin ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGOUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_3 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_3 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

            }
                    if(mongo_tMongoDBInput_3 != null) {
                        mongo_tMongoDBInput_3.close();
                    }
    globalMap.put("tMongoDBInput_3_NB_LINE", nb_line_tMongoDBInput_3);
 

ok_Hash.put("tMongoDBInput_3", true);
end_Hash.put("tMongoDBInput_3", System.currentTimeMillis());




/**
 * [tMongoDBInput_3 end ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAggregateRow_1_AGGOUT", true);
end_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGOUT end ] stop
 */


	
	/**
	 * [tAdvancedHash_row7 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row7", false);
		start_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row7";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row7");
					}
				
		int tos_count_tAdvancedHash_row7 = 0;
		

			   		// connection name:row7
			   		// source node:tAggregateRow_1_AGGIN - inputs:(OnRowsEnd) outputs:(row7,row7) | target node:tAdvancedHash_row7 - inputs:(row7) outputs:()
			   		// linked node: tMap_2 - inputs:(row8,row3,row7) outputs:(sortieee)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row7 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row7Struct> tHash_Lookup_row7 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row7Struct>getLookup(matchingModeEnum_row7);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row7", tHash_Lookup_row7);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row7 begin ] stop
 */



	
	/**
	 * [tAggregateRow_1_AGGIN begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGIN", false);
		start_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	
		int tos_count_tAggregateRow_1_AGGIN = 0;
		

java.util.Collection<AggOperationStruct_tAggregateRow_1> values_tAggregateRow_1 = hash_tAggregateRow_1.values();

globalMap.put("tAggregateRow_1_NB_LINE", values_tAggregateRow_1.size());

for(AggOperationStruct_tAggregateRow_1 aggregated_row_tAggregateRow_1 : values_tAggregateRow_1) { // G_AggR_600



 



/**
 * [tAggregateRow_1_AGGIN begin ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

            				    row7.player_id = aggregated_row_tAggregateRow_1.player_id;
            				    
    								if(aggregated_row_tAggregateRow_1.goals_sum != null) {
    								row7.goals = aggregated_row_tAggregateRow_1.goals_sum.doubleValue();
										
    								}else{
    								
    									row7.goals = null;
    									
    								}
    								row7.assists = aggregated_row_tAggregateRow_1.assists_sum;
                                	row7.direct_red_cards = aggregated_row_tAggregateRow_1.direct_red_cards_sum;
                                	
    								if(aggregated_row_tAggregateRow_1.minutes_played_sum != null) {
    								row7.minutes_played = aggregated_row_tAggregateRow_1.minutes_played_sum.doubleValue();
										
    								}else{
    								
    									row7.minutes_played = null;
    									
    								}
    								row7.clean_sheets = aggregated_row_tAggregateRow_1.clean_sheets_sum;
                                	

 


	tos_count_tAggregateRow_1_AGGIN++;

/**
 * [tAggregateRow_1_AGGIN main ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row7"
						
						);
					}
					


			   
			   

					row7Struct row7_HashRow = new row7Struct();
		   	   	   
				
				row7_HashRow.player_id = row7.player_id;
				
				row7_HashRow.season_name = row7.season_name;
				
				row7_HashRow.competition_id = row7.competition_id;
				
				row7_HashRow.competition_name = row7.competition_name;
				
				row7_HashRow.team_id = row7.team_id;
				
				row7_HashRow.team_name = row7.team_name;
				
				row7_HashRow.nb_in_group = row7.nb_in_group;
				
				row7_HashRow.nb_on_pitch = row7.nb_on_pitch;
				
				row7_HashRow.goals = row7.goals;
				
				row7_HashRow.assists = row7.assists;
				
				row7_HashRow.own_goals = row7.own_goals;
				
				row7_HashRow.subed_in = row7.subed_in;
				
				row7_HashRow.subed_out = row7.subed_out;
				
				row7_HashRow.yellow_cards = row7.yellow_cards;
				
				row7_HashRow.second_yellow_cards = row7.second_yellow_cards;
				
				row7_HashRow.direct_red_cards = row7.direct_red_cards;
				
				row7_HashRow.penalty_goals = row7.penalty_goals;
				
				row7_HashRow.minutes_played = row7.minutes_played;
				
				row7_HashRow.goals_conceded = row7.goals_conceded;
				
				row7_HashRow.clean_sheets = row7.clean_sheets;
				
			tHash_Lookup_row7.put(row7_HashRow);
			
            




 


	tos_count_tAdvancedHash_row7++;

/**
 * [tAdvancedHash_row7 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row7 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 process_data_end ] stop
 */



	
	/**
	 * [tAggregateRow_1_AGGIN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN process_data_end ] stop
 */
	
	/**
	 * [tAggregateRow_1_AGGIN end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

} // G_AggR_600

 

ok_Hash.put("tAggregateRow_1_AGGIN", true);
end_Hash.put("tAggregateRow_1_AGGIN", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGIN end ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

tHash_Lookup_row7.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row7");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row7", true);
end_Hash.put("tAdvancedHash_row7", System.currentTimeMillis());




/**
 * [tAdvancedHash_row7 end ] stop
 */









				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
							//free memory for "tAggregateRow_1_AGGIN"
							globalMap.remove("tAggregateRow_1");
						
				try{
					
	
	/**
	 * [tMongoDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 finally ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGOUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

 



/**
 * [tAggregateRow_1_AGGOUT finally ] stop
 */

	
	/**
	 * [tAggregateRow_1_AGGIN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGIN";

	

 



/**
 * [tAggregateRow_1_AGGIN finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row7 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row7";

	

 



/**
 * [tAdvancedHash_row7 finally ] stop
 */









				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class player_profilesStruct implements routines.system.IPersistableRow<player_profilesStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String name;

				public String getName () {
					return this.name;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final player_profilesStruct other = (player_profilesStruct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(player_profilesStruct other) {

		other.player_id = this.player_id;
	            other.name = this.name;
	            
	}

	public void copyKeysDataTo(player_profilesStruct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.name = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.name = readString(dis);
					
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
				
						writeString(this.name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.player_id,dos);
					
					// String
				
						writeString(this.name,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("player_id="+player_id);
		sb.append(",name="+name);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(player_profilesStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
public void tMongoDBInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_4_SUBPROCESS_STATE", 0);

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
player_profilesStruct player_profiles = new player_profilesStruct();





	
	/**
	 * [tMongoDBOutput_3 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_3", false);
		start_Hash.put("tMongoDBOutput_3", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_3";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"player_profiles");
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
                pathMap_tMongoDBOutput_3.put("name","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_3=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_3=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBOutput_3 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBOutput_3 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBOutput_3);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBOutput_3 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBOutput_3 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBOutput_3.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBOutput_3.hosts(addrs_tMongoDBOutput_3);

                clientSettingsBuilder_tMongoDBOutput_3.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBOutput_3.build()));



        mongo_tMongoDBOutput_3 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBOutput_3.build());
        db_tMongoDBOutput_3 = mongo_tMongoDBOutput_3.getDatabase(context.mongo_database);

        db_tMongoDBOutput_3.getCollection(context.mongo_player_profiles_modifie).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_3 = db_tMongoDBOutput_3.getCollection(context.mongo_player_profiles_modifie);


 



/**
 * [tMongoDBOutput_3 begin ] stop
 */



	
	/**
	 * [tMap_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_5", false);
		start_Hash.put("tMap_5", System.currentTimeMillis());
		
	
	currentComponent="tMap_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row5");
					}
				
		int tos_count_tMap_5 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_5__Struct  {
	String name;
}
Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
player_profilesStruct player_profiles_tmp = new player_profilesStruct();
// ###############################

        
        



        









 



/**
 * [tMap_5 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_4", false);
		start_Hash.put("tMongoDBInput_4", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_4";

	
		int tos_count_tMongoDBInput_4 = 0;
		


	

final String applicationName_tMongoDBInput_4 = "Talend";

	int nb_line_tMongoDBInput_4 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_4=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_4=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_4 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_4 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_4);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_4 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_4 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_4.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_4.hosts(addrs_tMongoDBInput_4);

                clientSettingsBuilder_tMongoDBInput_4.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_4.build()));



        mongo_tMongoDBInput_4 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_4.build());
        db_tMongoDBInput_4 = mongo_tMongoDBInput_4.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_4 = db_tMongoDBInput_4.getCollection(context.mongo_player_profiles);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_4 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_4.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_4.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_4.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_4 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_4 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_4 = coll_tMongoDBInput_4.find(myQuery_tMongoDBInput_4).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_4{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_4 dbObjectInputUtil_tMongoDBInput_4=new DBObjectInputUtil_tMongoDBInput_4();
				java.util.Map<String, String> pathMap_tMongoDBInput_4=new java.util.HashMap<>();
				pathMap_tMongoDBInput_4.put("player_id","");
				pathMap_tMongoDBInput_4.put("player_slug","");
				pathMap_tMongoDBInput_4.put("player_name","");
				pathMap_tMongoDBInput_4.put("player_image_url","");
				pathMap_tMongoDBInput_4.put("date_of_birth","");
				pathMap_tMongoDBInput_4.put("place_of_birth","");
				pathMap_tMongoDBInput_4.put("country_of_birth","");
				pathMap_tMongoDBInput_4.put("height","");
				pathMap_tMongoDBInput_4.put("citizenship","");
				pathMap_tMongoDBInput_4.put("is_eu","");
				pathMap_tMongoDBInput_4.put("position","");
				pathMap_tMongoDBInput_4.put("main_position","");
				pathMap_tMongoDBInput_4.put("foot","");
				pathMap_tMongoDBInput_4.put("current_club_id","");
				pathMap_tMongoDBInput_4.put("current_club_name","");
				pathMap_tMongoDBInput_4.put("joined","");
				pathMap_tMongoDBInput_4.put("contract_expires","");
				pathMap_tMongoDBInput_4.put("outfitter","");
				pathMap_tMongoDBInput_4.put("social_media_url","");
				pathMap_tMongoDBInput_4.put("player_agent_id","");
				pathMap_tMongoDBInput_4.put("player_agent_name","");
				pathMap_tMongoDBInput_4.put("contract_option","");
				pathMap_tMongoDBInput_4.put("date_of_last_contract_extension","");
				pathMap_tMongoDBInput_4.put("on_loan_from_club_id","");
				pathMap_tMongoDBInput_4.put("on_loan_from_club_name","");
				pathMap_tMongoDBInput_4.put("contract_there_expires","");
				pathMap_tMongoDBInput_4.put("second_club_url","");
				pathMap_tMongoDBInput_4.put("second_club_name","");
				pathMap_tMongoDBInput_4.put("third_club_url","");
				pathMap_tMongoDBInput_4.put("third_club_name","");
				pathMap_tMongoDBInput_4.put("fourth_club_url","");
				pathMap_tMongoDBInput_4.put("fourth_club_name","");
				pathMap_tMongoDBInput_4.put("date_of_death","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_4 = findIterable_tMongoDBInput_4.iterator();
						
				while (cursor_tMongoDBInput_4.hasNext()){
				org.bson.Document o_tMongoDBInput_4 = cursor_tMongoDBInput_4.next();
				nb_line_tMongoDBInput_4++;
				Object valueObj_tMongoDBInput_4=null;
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("player_id"),"player_id",o_tMongoDBInput_4);
					
				row5.player_id = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("player_slug"),"player_slug",o_tMongoDBInput_4);
					
				row5.player_slug = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("player_name"),"player_name",o_tMongoDBInput_4);
					
				row5.player_name = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("player_image_url"),"player_image_url",o_tMongoDBInput_4);
					
				row5.player_image_url = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("date_of_birth"),"date_of_birth",o_tMongoDBInput_4);
					
				row5.date_of_birth = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("place_of_birth"),"place_of_birth",o_tMongoDBInput_4);
					
				row5.place_of_birth = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("country_of_birth"),"country_of_birth",o_tMongoDBInput_4);
					
				row5.country_of_birth = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("height"),"height",o_tMongoDBInput_4);
					
				row5.height = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("citizenship"),"citizenship",o_tMongoDBInput_4);
					
				row5.citizenship = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("is_eu"),"is_eu",o_tMongoDBInput_4);
					
				row5.is_eu = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("position"),"position",o_tMongoDBInput_4);
					
				row5.position = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("main_position"),"main_position",o_tMongoDBInput_4);
					
				row5.main_position = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("foot"),"foot",o_tMongoDBInput_4);
					
				row5.foot = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("current_club_id"),"current_club_id",o_tMongoDBInput_4);
					
				row5.current_club_id = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("current_club_name"),"current_club_name",o_tMongoDBInput_4);
					
				row5.current_club_name = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("joined"),"joined",o_tMongoDBInput_4);
					
				row5.joined = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("contract_expires"),"contract_expires",o_tMongoDBInput_4);
					
				row5.contract_expires = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("outfitter"),"outfitter",o_tMongoDBInput_4);
					
				row5.outfitter = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("social_media_url"),"social_media_url",o_tMongoDBInput_4);
					
				row5.social_media_url = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("player_agent_id"),"player_agent_id",o_tMongoDBInput_4);
					
				row5.player_agent_id = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("player_agent_name"),"player_agent_name",o_tMongoDBInput_4);
					
				row5.player_agent_name = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("contract_option"),"contract_option",o_tMongoDBInput_4);
					
				row5.contract_option = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("date_of_last_contract_extension"),"date_of_last_contract_extension",o_tMongoDBInput_4);
					
				row5.date_of_last_contract_extension = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("on_loan_from_club_id"),"on_loan_from_club_id",o_tMongoDBInput_4);
					
				row5.on_loan_from_club_id = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("on_loan_from_club_name"),"on_loan_from_club_name",o_tMongoDBInput_4);
					
				row5.on_loan_from_club_name = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("contract_there_expires"),"contract_there_expires",o_tMongoDBInput_4);
					
				row5.contract_there_expires = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("second_club_url"),"second_club_url",o_tMongoDBInput_4);
					
				row5.second_club_url = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("second_club_name"),"second_club_name",o_tMongoDBInput_4);
					
				row5.second_club_name = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("third_club_url"),"third_club_url",o_tMongoDBInput_4);
					
				row5.third_club_url = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("third_club_name"),"third_club_name",o_tMongoDBInput_4);
					
				row5.third_club_name = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("fourth_club_url"),"fourth_club_url",o_tMongoDBInput_4);
					
				row5.fourth_club_url = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("fourth_club_name"),"fourth_club_name",o_tMongoDBInput_4);
					
				row5.fourth_club_name = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				
                    valueObj_tMongoDBInput_4=dbObjectInputUtil_tMongoDBInput_4.getValue(pathMap_tMongoDBInput_4.get("date_of_death"),"date_of_death",o_tMongoDBInput_4);
					
				row5.date_of_death = valueObj_tMongoDBInput_4==null ? null : valueObj_tMongoDBInput_4.toString();
				


 



/**
 * [tMongoDBInput_4 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_4 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 


	tos_count_tMongoDBInput_4++;

/**
 * [tMongoDBInput_4 main ] stop
 */
	
	/**
	 * [tMongoDBInput_4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 



/**
 * [tMongoDBInput_4 process_data_begin ] stop
 */

	
	/**
	 * [tMap_5 main ] start
	 */

	

	
	
	currentComponent="tMap_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row5"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_5 = false;
		  boolean mainRowRejected_tMap_5 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_5__Struct Var = Var__tMap_5;
Var.name = row5.player_slug == null || row5.player_slug.trim().isEmpty() ? "" :
row5.player_slug.replace("-", " ").substring(0,1).toUpperCase() + row5.player_slug.replace("-", " ").substring(1);// ###############################
        // ###############################
        // # Output tables

player_profiles = null;


// # Output table : 'player_profiles'
player_profiles_tmp.player_id = row5.player_id ;
player_profiles_tmp.name = Var.name ;
player_profiles = player_profiles_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_5 = false;










 


	tos_count_tMap_5++;

/**
 * [tMap_5 main ] stop
 */
	
	/**
	 * [tMap_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_begin ] stop
 */
// Start of branch "player_profiles"
if(player_profiles != null) { 



	
	/**
	 * [tMongoDBOutput_3 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"player_profiles"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_3.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("player_id"),"player_id", player_profiles.player_id);
                                        updateObjectUtil_tMongoDBOutput_3.put(pathMap_tMongoDBOutput_3.get("name"),"name", player_profiles.name);
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

} // End of branch "player_profiles"




	
	/**
	 * [tMap_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_4 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 



/**
 * [tMongoDBInput_4 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_4 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

            }
                    if(mongo_tMongoDBInput_4 != null) {
                        mongo_tMongoDBInput_4.close();
                    }
    globalMap.put("tMongoDBInput_4_NB_LINE", nb_line_tMongoDBInput_4);
 

ok_Hash.put("tMongoDBInput_4", true);
end_Hash.put("tMongoDBInput_4", System.currentTimeMillis());




/**
 * [tMongoDBInput_4 end ] stop
 */

	
	/**
	 * [tMap_5 end ] start
	 */

	

	
	
	currentComponent="tMap_5";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row5");
			  	}
			  	
 

ok_Hash.put("tMap_5", true);
end_Hash.put("tMap_5", System.currentTimeMillis());




/**
 * [tMap_5 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_3 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	

		if(mongo_tMongoDBOutput_3 != null){
			
				mongo_tMongoDBOutput_3.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_3", true); 
		
	globalMap.put("tMongoDBOutput_3_NB_LINE", nb_line_tMongoDBOutput_3);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"player_profiles");
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
	 * [tMongoDBInput_4 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_4";

	

 



/**
 * [tMongoDBInput_4 finally ] stop
 */

	
	/**
	 * [tMap_5 finally ] start
	 */

	

	
	
	currentComponent="tMap_5";

	

 



/**
 * [tMap_5 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_3 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_3";

	
		if(resourceMap.get("finish_tMongoDBOutput_3") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_3") != null){

		    
		    			
		    			       ((com.mongodb.client.MongoClient)resourceMap.get("mongo_tMongoDBOutput_3")).close();
		    
		    
			
			}
		}

 



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
		

		globalMap.put("tMongoDBInput_4_SUBPROCESS_STATE", 1);
	}
	


public static class transferStruct implements routines.system.IPersistableRow<transferStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Integer transfer_fee;

				public Integer getTransfer_fee () {
					return this.transfer_fee;
				}
				
			    public Integer value_at_transfer;

				public Integer getValue_at_transfer () {
					return this.value_at_transfer;
				}
				
			    public Boolean is_paid;

				public Boolean getIs_paid () {
					return this.is_paid;
				}
				
			    public String transfer_type_simplified;

				public String getTransfer_type_simplified () {
					return this.transfer_type_simplified;
				}
				
			    public boolean isretired;

				public boolean getIsretired () {
					return this.isretired;
				}
				
			    public boolean iswithoutclub;

				public boolean getIswithoutclub () {
					return this.iswithoutclub;
				}
				
			    public String valuecategory;

				public String getValuecategory () {
					return this.valuecategory;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final transferStruct other = (transferStruct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(transferStruct other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.transfer_date = this.transfer_date;
	            other.from_team_id = this.from_team_id;
	            other.from_team_name = this.from_team_name;
	            other.to_team_id = this.to_team_id;
	            other.to_team_name = this.to_team_name;
	            other.transfer_type = this.transfer_type;
	            other.transfer_fee = this.transfer_fee;
	            other.value_at_transfer = this.value_at_transfer;
	            other.is_paid = this.is_paid;
	            other.transfer_type_simplified = this.transfer_type_simplified;
	            other.isretired = this.isretired;
	            other.iswithoutclub = this.iswithoutclub;
	            other.valuecategory = this.valuecategory;
	            
	}

	public void copyKeysDataTo(transferStruct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
						this.transfer_fee = readInteger(dis);
					
						this.value_at_transfer = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_paid = null;
           				} else {
           			    	this.is_paid = dis.readBoolean();
           				}
					
					this.transfer_type_simplified = readString(dis);
					
			        this.isretired = dis.readBoolean();
					
			        this.iswithoutclub = dis.readBoolean();
					
					this.valuecategory = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
						this.transfer_fee = readInteger(dis);
					
						this.value_at_transfer = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.is_paid = null;
           				} else {
           			    	this.is_paid = dis.readBoolean();
           				}
					
					this.transfer_type_simplified = readString(dis);
					
			        this.isretired = dis.readBoolean();
					
			        this.iswithoutclub = dis.readBoolean();
					
					this.valuecategory = readString(dis);
					
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
					
					// Integer
				
						writeInteger(this.transfer_fee,dos);
					
					// Integer
				
						writeInteger(this.value_at_transfer,dos);
					
					// Boolean
				
						if(this.is_paid == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_paid);
		            	}
					
					// String
				
						writeString(this.transfer_type_simplified,dos);
					
					// boolean
				
		            	dos.writeBoolean(this.isretired);
					
					// boolean
				
		            	dos.writeBoolean(this.iswithoutclub);
					
					// String
				
						writeString(this.valuecategory,dos);
					
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
					
					// Integer
				
						writeInteger(this.transfer_fee,dos);
					
					// Integer
				
						writeInteger(this.value_at_transfer,dos);
					
					// Boolean
				
						if(this.is_paid == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeBoolean(this.is_paid);
		            	}
					
					// String
				
						writeString(this.transfer_type_simplified,dos);
					
					// boolean
				
		            	dos.writeBoolean(this.isretired);
					
					// boolean
				
		            	dos.writeBoolean(this.iswithoutclub);
					
					// String
				
						writeString(this.valuecategory,dos);
					
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
		sb.append(",transfer_fee="+String.valueOf(transfer_fee));
		sb.append(",value_at_transfer="+String.valueOf(value_at_transfer));
		sb.append(",is_paid="+String.valueOf(is_paid));
		sb.append(",transfer_type_simplified="+transfer_type_simplified);
		sb.append(",isretired="+String.valueOf(isretired));
		sb.append(",iswithoutclub="+String.valueOf(iswithoutclub));
		sb.append(",valuecategory="+valuecategory);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(transferStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
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
				
			    public Integer value_at_transfer;

				public Integer getValue_at_transfer () {
					return this.value_at_transfer;
				}
				
			    public Integer transfer_fee;

				public Integer getTransfer_fee () {
					return this.transfer_fee;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
						this.value_at_transfer = readInteger(dis);
					
						this.transfer_fee = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
						this.value_at_transfer = readInteger(dis);
					
						this.transfer_fee = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.value_at_transfer,dos);
					
					// Integer
				
						writeInteger(this.transfer_fee,dos);
					
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
					
					// Integer
				
						writeInteger(this.value_at_transfer,dos);
					
					// Integer
				
						writeInteger(this.transfer_fee,dos);
					
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
		sb.append(",value_at_transfer="+String.valueOf(value_at_transfer));
		sb.append(",transfer_fee="+String.valueOf(transfer_fee));
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
public void tMongoDBInput_6Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_6_SUBPROCESS_STATE", 0);

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
transferStruct transfer = new transferStruct();





	
	/**
	 * [tMongoDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_2", false);
		start_Hash.put("tMongoDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"transfer");
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
                pathMap_tMongoDBOutput_2.put("season_name","");
                pathMap_tMongoDBOutput_2.put("transfer_date","");
                pathMap_tMongoDBOutput_2.put("from_team_id","");
                pathMap_tMongoDBOutput_2.put("from_team_name","");
                pathMap_tMongoDBOutput_2.put("to_team_id","");
                pathMap_tMongoDBOutput_2.put("to_team_name","");
                pathMap_tMongoDBOutput_2.put("transfer_type","");
                pathMap_tMongoDBOutput_2.put("transfer_fee","");
                pathMap_tMongoDBOutput_2.put("value_at_transfer","");
                pathMap_tMongoDBOutput_2.put("is_paid","");
                pathMap_tMongoDBOutput_2.put("transfer_type_simplified","");
                pathMap_tMongoDBOutput_2.put("isretired","");
                pathMap_tMongoDBOutput_2.put("iswithoutclub","");
                pathMap_tMongoDBOutput_2.put("valuecategory","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_2=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_2=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBOutput_2 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBOutput_2 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBOutput_2);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBOutput_2 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBOutput_2 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBOutput_2.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBOutput_2.hosts(addrs_tMongoDBOutput_2);

                clientSettingsBuilder_tMongoDBOutput_2.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBOutput_2.build()));



        mongo_tMongoDBOutput_2 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBOutput_2.build());
        db_tMongoDBOutput_2 = mongo_tMongoDBOutput_2.getDatabase(context.mongo_database);

        db_tMongoDBOutput_2.getCollection(context.mongo_transfer_history_modifie).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_2 = db_tMongoDBOutput_2.getCollection(context.mongo_transfer_history_modifie);


 



/**
 * [tMongoDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
	boolean is_paid;
	String transfer_type_simplified;
	boolean isretired;
	boolean iswithoutclub;
	String valuecategory;
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
transferStruct transfer_tmp = new transferStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_6", false);
		start_Hash.put("tMongoDBInput_6", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_6";

	
		int tos_count_tMongoDBInput_6 = 0;
		


	

final String applicationName_tMongoDBInput_6 = "Talend";

	int nb_line_tMongoDBInput_6 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_6=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_6=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_6 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_6 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_6);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_6 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_6 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_6.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_6.hosts(addrs_tMongoDBInput_6);

                clientSettingsBuilder_tMongoDBInput_6.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_6.build()));



        mongo_tMongoDBInput_6 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_6.build());
        db_tMongoDBInput_6 = mongo_tMongoDBInput_6.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_6 = db_tMongoDBInput_6.getCollection(context.mongo_transfer_history);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_6 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_6.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_6.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_6.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_6 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_6 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_6 = coll_tMongoDBInput_6.find(myQuery_tMongoDBInput_6).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_6{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_6 dbObjectInputUtil_tMongoDBInput_6=new DBObjectInputUtil_tMongoDBInput_6();
				java.util.Map<String, String> pathMap_tMongoDBInput_6=new java.util.HashMap<>();
				pathMap_tMongoDBInput_6.put("player_id","");
				pathMap_tMongoDBInput_6.put("season_name","");
				pathMap_tMongoDBInput_6.put("transfer_date","");
				pathMap_tMongoDBInput_6.put("from_team_id","");
				pathMap_tMongoDBInput_6.put("from_team_name","");
				pathMap_tMongoDBInput_6.put("to_team_id","");
				pathMap_tMongoDBInput_6.put("to_team_name","");
				pathMap_tMongoDBInput_6.put("transfer_type","");
				pathMap_tMongoDBInput_6.put("value_at_transfer","");
				pathMap_tMongoDBInput_6.put("transfer_fee","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_6 = findIterable_tMongoDBInput_6.iterator();
						
				while (cursor_tMongoDBInput_6.hasNext()){
				org.bson.Document o_tMongoDBInput_6 = cursor_tMongoDBInput_6.next();
				nb_line_tMongoDBInput_6++;
				Object valueObj_tMongoDBInput_6=null;
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("player_id"),"player_id",o_tMongoDBInput_6);
					
				row2.player_id = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("season_name"),"season_name",o_tMongoDBInput_6);
					
				row2.season_name = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("transfer_date"),"transfer_date",o_tMongoDBInput_6);
					
				row2.transfer_date = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("from_team_id"),"from_team_id",o_tMongoDBInput_6);
					
				row2.from_team_id = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("from_team_name"),"from_team_name",o_tMongoDBInput_6);
					
				row2.from_team_name = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("to_team_id"),"to_team_id",o_tMongoDBInput_6);
					
				row2.to_team_id = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("to_team_name"),"to_team_name",o_tMongoDBInput_6);
					
				row2.to_team_name = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("transfer_type"),"transfer_type",o_tMongoDBInput_6);
					
				row2.transfer_type = valueObj_tMongoDBInput_6==null ? null : valueObj_tMongoDBInput_6.toString();
				
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("value_at_transfer"),"value_at_transfer",o_tMongoDBInput_6);
				if(valueObj_tMongoDBInput_6!=null && valueObj_tMongoDBInput_6.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_6.getClass().equals(Double.class)) {
                                row2.value_at_transfer = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_6.toString()).intValue();
                            } else {
                                row2.value_at_transfer = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_6.toString());
                            }
				}else{
					row2.value_at_transfer = null;
				}
                    valueObj_tMongoDBInput_6=dbObjectInputUtil_tMongoDBInput_6.getValue(pathMap_tMongoDBInput_6.get("transfer_fee"),"transfer_fee",o_tMongoDBInput_6);
				if(valueObj_tMongoDBInput_6!=null && valueObj_tMongoDBInput_6.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_6.getClass().equals(Double.class)) {
                                row2.transfer_fee = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_6.toString()).intValue();
                            } else {
                                row2.transfer_fee = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_6.toString());
                            }
				}else{
					row2.transfer_fee = null;
				}


 



/**
 * [tMongoDBInput_6 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_6 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_6";

	

 


	tos_count_tMongoDBInput_6++;

/**
 * [tMongoDBInput_6 main ] stop
 */
	
	/**
	 * [tMongoDBInput_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_6";

	

 



/**
 * [tMongoDBInput_6 process_data_begin ] stop
 */

	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;
Var.is_paid = row2.transfer_fee == null || row2.transfer_fee.equals(0) ? false : true ;
Var.transfer_type_simplified = row2.transfer_type == null ? "Inconnu" :
row2.transfer_type.equalsIgnoreCase("Loan") ? "Prêt" :
row2.transfer_type.equalsIgnoreCase("Return from loan") ? "Retour de prêt" :
row2.transfer_type.equalsIgnoreCase("Transfer") ? "Transfert" :
row2.transfer_type.equalsIgnoreCase("Retired") ? "Retraite" : "Autre" ;
Var.isretired = (row2.to_team_name != null && row2.to_team_name.equalsIgnoreCase("Retired")) ? true : false
;
Var.iswithoutclub = (row2.to_team_name != null && row2.to_team_name.equalsIgnoreCase("Without Club")) ? true :
(row2.from_team_name != null && row2.from_team_name.equalsIgnoreCase("Without Club")) ? true : false;
Var.valuecategory = row2.value_at_transfer == null || row2.value_at_transfer.equals(0) ? "Sans valeur" :
row2.value_at_transfer < 500000 ? "Bas (< 500K)" :
row2.value_at_transfer < 5000000 ? "Moyen (500K-5M)" :
row2.value_at_transfer < 20000000 ? "Élevé (5M-20M)" :
row2.value_at_transfer < 50000000 ? "Très élevé (20M-50M)" : "Elite (50M+)" ;// ###############################
        // ###############################
        // # Output tables

transfer = null;


// # Output table : 'transfer'
transfer_tmp.player_id = row2.player_id ;
transfer_tmp.season_name = row2.season_name ;
transfer_tmp.transfer_date = row2.transfer_date ;
transfer_tmp.from_team_id = row2.from_team_id ;
transfer_tmp.from_team_name = row2.from_team_name ;
transfer_tmp.to_team_id = row2.to_team_id ;
transfer_tmp.to_team_name = row2.to_team_name ;
transfer_tmp.transfer_type = row2.transfer_type ;
transfer_tmp.transfer_fee = row2.transfer_fee ;
transfer_tmp.value_at_transfer = row2.value_at_transfer ;
transfer_tmp.is_paid = Var.is_paid ;
transfer_tmp.transfer_type_simplified = Var.transfer_type_simplified ;
transfer_tmp.isretired = Var.isretired ;
transfer_tmp.iswithoutclub = Var.iswithoutclub ;
transfer_tmp.valuecategory = Var.valuecategory ;
transfer = transfer_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "transfer"
if(transfer != null) { 



	
	/**
	 * [tMongoDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"transfer"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_2.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("player_id"),"player_id", transfer.player_id);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("season_name"),"season_name", transfer.season_name);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("transfer_date"),"transfer_date", transfer.transfer_date);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("from_team_id"),"from_team_id", transfer.from_team_id);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("from_team_name"),"from_team_name", transfer.from_team_name);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("to_team_id"),"to_team_id", transfer.to_team_id);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("to_team_name"),"to_team_name", transfer.to_team_name);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("transfer_type"),"transfer_type", transfer.transfer_type);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("transfer_fee"),"transfer_fee", transfer.transfer_fee);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("value_at_transfer"),"value_at_transfer", transfer.value_at_transfer);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("is_paid"),"is_paid", transfer.is_paid);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("transfer_type_simplified"),"transfer_type_simplified", transfer.transfer_type_simplified);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("isretired"),"isretired", transfer.isretired);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("iswithoutclub"),"iswithoutclub", transfer.iswithoutclub);
                                        updateObjectUtil_tMongoDBOutput_2.put(pathMap_tMongoDBOutput_2.get("valuecategory"),"valuecategory", transfer.valuecategory);
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

} // End of branch "transfer"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_6";

	

 



/**
 * [tMongoDBInput_6 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_6 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_6";

	

            }
                    if(mongo_tMongoDBInput_6 != null) {
                        mongo_tMongoDBInput_6.close();
                    }
    globalMap.put("tMongoDBInput_6_NB_LINE", nb_line_tMongoDBInput_6);
 

ok_Hash.put("tMongoDBInput_6", true);
end_Hash.put("tMongoDBInput_6", System.currentTimeMillis());




/**
 * [tMongoDBInput_6 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	

		if(mongo_tMongoDBOutput_2 != null){
			
				mongo_tMongoDBOutput_2.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_2", true); 
		
	globalMap.put("tMongoDBOutput_2_NB_LINE", nb_line_tMongoDBOutput_2);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"transfer");
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
	 * [tMongoDBInput_6 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_6";

	

 



/**
 * [tMongoDBInput_6 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_2";

	
		if(resourceMap.get("finish_tMongoDBOutput_2") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_2") != null){

		    
		    			
		    			       ((com.mongodb.client.MongoClient)resourceMap.get("mongo_tMongoDBOutput_2")).close();
		    
		    
			
			}
		}

 



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
		

		globalMap.put("tMongoDBInput_6_SUBPROCESS_STATE", 1);
	}
	


public static class player_latest_market_valueStruct implements routines.system.IPersistableRow<player_latest_market_valueStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String date_unix;

				public String getDate_unix () {
					return this.date_unix;
				}
				
			    public Double value;

				public Double getValue () {
					return this.value;
				}
				
			    public String valcategory;

				public String getValcategory () {
					return this.valcategory;
				}
				
			    public String year;

				public String getYear () {
					return this.year;
				}
				
			    public String month;

				public String getMonth () {
					return this.month;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.date_unix = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.value = null;
           				} else {
           			    	this.value = dis.readDouble();
           				}
					
					this.valcategory = readString(dis);
					
					this.year = readString(dis);
					
					this.month = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.date_unix = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.value = null;
           				} else {
           			    	this.value = dis.readDouble();
           				}
					
					this.valcategory = readString(dis);
					
					this.year = readString(dis);
					
					this.month = readString(dis);
					
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
					
					// Double
				
						if(this.value == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.value);
		            	}
					
					// String
				
						writeString(this.valcategory,dos);
					
					// String
				
						writeString(this.year,dos);
					
					// String
				
						writeString(this.month,dos);
					
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
					
					// Double
				
						if(this.value == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.value);
		            	}
					
					// String
				
						writeString(this.valcategory,dos);
					
					// String
				
						writeString(this.year,dos);
					
					// String
				
						writeString(this.month,dos);
					
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
		sb.append(",value="+String.valueOf(value));
		sb.append(",valcategory="+valcategory);
		sb.append(",year="+year);
		sb.append(",month="+month);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(player_latest_market_valueStruct other) {

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

public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
			    public String player_id;

				public String getPlayer_id () {
					return this.player_id;
				}
				
			    public String date_unix;

				public String getDate_unix () {
					return this.date_unix;
				}
				
			    public Double value;

				public Double getValue () {
					return this.value;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.date_unix = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.value = null;
           				} else {
           			    	this.value = dis.readDouble();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.date_unix = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.value = null;
           				} else {
           			    	this.value = dis.readDouble();
           				}
					
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
					
					// Double
				
						if(this.value == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.value);
		            	}
					
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
					
					// Double
				
						if(this.value == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.value);
		            	}
					
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
		sb.append(",value="+String.valueOf(value));
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
public void tMongoDBInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_2_SUBPROCESS_STATE", 0);

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
player_latest_market_valueStruct player_latest_market_value = new player_latest_market_valueStruct();





	
	/**
	 * [tMongoDBOutput_4 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_4", false);
		start_Hash.put("tMongoDBOutput_4", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"player_latest_market_value");
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
                pathMap_tMongoDBOutput_4.put("date_unix","");
                pathMap_tMongoDBOutput_4.put("value","");
                pathMap_tMongoDBOutput_4.put("valcategory","");
                pathMap_tMongoDBOutput_4.put("year","");
                pathMap_tMongoDBOutput_4.put("month","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_4=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_4=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBOutput_4 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBOutput_4 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBOutput_4);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBOutput_4 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBOutput_4 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBOutput_4.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBOutput_4.hosts(addrs_tMongoDBOutput_4);

                clientSettingsBuilder_tMongoDBOutput_4.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBOutput_4.build()));



        mongo_tMongoDBOutput_4 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBOutput_4.build());
        db_tMongoDBOutput_4 = mongo_tMongoDBOutput_4.getDatabase(context.mongo_database);

        db_tMongoDBOutput_4.getCollection(context.mongo_player_latest_market_value_modifie).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_4 = db_tMongoDBOutput_4.getCollection(context.mongo_player_latest_market_value_modifie);


 



/**
 * [tMongoDBOutput_4 begin ] stop
 */



	
	/**
	 * [tMap_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_6", false);
		start_Hash.put("tMap_6", System.currentTimeMillis());
		
	
	currentComponent="tMap_6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row6");
					}
				
		int tos_count_tMap_6 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_6__Struct  {
	String valcategory;
	String year;
	String month;
}
Var__tMap_6__Struct Var__tMap_6 = new Var__tMap_6__Struct();
// ###############################

// ###############################
// # Outputs initialization
player_latest_market_valueStruct player_latest_market_value_tmp = new player_latest_market_valueStruct();
// ###############################

        
        



        









 



/**
 * [tMap_6 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_2", false);
		start_Hash.put("tMongoDBInput_2", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_2";

	
		int tos_count_tMongoDBInput_2 = 0;
		


	

final String applicationName_tMongoDBInput_2 = "Talend";

	int nb_line_tMongoDBInput_2 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_2=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_2=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_2 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_2 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_2);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_2 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_2 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_2.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_2.hosts(addrs_tMongoDBInput_2);

                clientSettingsBuilder_tMongoDBInput_2.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_2.build()));



        mongo_tMongoDBInput_2 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_2.build());
        db_tMongoDBInput_2 = mongo_tMongoDBInput_2.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_2 = db_tMongoDBInput_2.getCollection(context.mongo_player_latest_market_value);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_2 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_2.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_2.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_2.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_2 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_2 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_2 = coll_tMongoDBInput_2.find(myQuery_tMongoDBInput_2).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_2{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_2 dbObjectInputUtil_tMongoDBInput_2=new DBObjectInputUtil_tMongoDBInput_2();
				java.util.Map<String, String> pathMap_tMongoDBInput_2=new java.util.HashMap<>();
				pathMap_tMongoDBInput_2.put("player_id","");
				pathMap_tMongoDBInput_2.put("date_unix","");
				pathMap_tMongoDBInput_2.put("value","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_2 = findIterable_tMongoDBInput_2.iterator();
						
				while (cursor_tMongoDBInput_2.hasNext()){
				org.bson.Document o_tMongoDBInput_2 = cursor_tMongoDBInput_2.next();
				nb_line_tMongoDBInput_2++;
				Object valueObj_tMongoDBInput_2=null;
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("player_id"),"player_id",o_tMongoDBInput_2);
					
				row6.player_id = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("date_unix"),"date_unix",o_tMongoDBInput_2);
					
				row6.date_unix = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("value"),"value",o_tMongoDBInput_2);
				if(valueObj_tMongoDBInput_2!=null && valueObj_tMongoDBInput_2.toString().length() > 0) {
                            row6.value = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_2.toString());
				}else{
					row6.value = null;
				}


 



/**
 * [tMongoDBInput_2 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_2 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 


	tos_count_tMongoDBInput_2++;

/**
 * [tMongoDBInput_2 main ] stop
 */
	
	/**
	 * [tMongoDBInput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 



/**
 * [tMongoDBInput_2 process_data_begin ] stop
 */

	
	/**
	 * [tMap_6 main ] start
	 */

	

	
	
	currentComponent="tMap_6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row6"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_6 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_6 = false;
		  boolean mainRowRejected_tMap_6 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_6__Struct Var = Var__tMap_6;
Var.valcategory = row6.value <= 0.0 ? "Sans valeur" :
row6.value < 500000 ? "Bas (< 500K)" :
row6.value < 5000000 ? "Moyen (500K-5M)" :
row6.value < 20000000 ? "Élevé (5M-20M)" :
row6.value < 50000000 ? "Très élevé (20M-50M)" : "Elite (50M+)" ;
Var.year = row6.date_unix == null || row6.date_unix.trim().isEmpty() || !row6.date_unix.matches("\\d{4}-\\d{2}-\\d{2}") ? "" :
row6.date_unix.substring(0, 4) ;
Var.month = row6.date_unix == null || row6.date_unix.trim().isEmpty() || !row6.date_unix.matches("\\d{4}-\\d{2}-\\d{2}") ? "" :
row6.date_unix.substring(5, 7) ;// ###############################
        // ###############################
        // # Output tables

player_latest_market_value = null;


// # Output table : 'player_latest_market_value'
player_latest_market_value_tmp.player_id = row6.player_id;
player_latest_market_value_tmp.date_unix = row6.date_unix ;
player_latest_market_value_tmp.value = row6.value ;
player_latest_market_value_tmp.valcategory = Var.valcategory ;
player_latest_market_value_tmp.year = Var.year ;
player_latest_market_value_tmp.month = Var.month ;
player_latest_market_value = player_latest_market_value_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_6 = false;










 


	tos_count_tMap_6++;

/**
 * [tMap_6 main ] stop
 */
	
	/**
	 * [tMap_6 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_6";

	

 



/**
 * [tMap_6 process_data_begin ] stop
 */
// Start of branch "player_latest_market_value"
if(player_latest_market_value != null) { 



	
	/**
	 * [tMongoDBOutput_4 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"player_latest_market_value"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_4.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("player_id"),"player_id", player_latest_market_value.player_id);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("date_unix"),"date_unix", player_latest_market_value.date_unix);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("value"),"value", player_latest_market_value.value);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("valcategory"),"valcategory", player_latest_market_value.valcategory);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("year"),"year", player_latest_market_value.year);
                                        updateObjectUtil_tMongoDBOutput_4.put(pathMap_tMongoDBOutput_4.get("month"),"month", player_latest_market_value.month);
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

} // End of branch "player_latest_market_value"




	
	/**
	 * [tMap_6 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_6";

	

 



/**
 * [tMap_6 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 



/**
 * [tMongoDBInput_2 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_2 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

            }
                    if(mongo_tMongoDBInput_2 != null) {
                        mongo_tMongoDBInput_2.close();
                    }
    globalMap.put("tMongoDBInput_2_NB_LINE", nb_line_tMongoDBInput_2);
 

ok_Hash.put("tMongoDBInput_2", true);
end_Hash.put("tMongoDBInput_2", System.currentTimeMillis());




/**
 * [tMongoDBInput_2 end ] stop
 */

	
	/**
	 * [tMap_6 end ] start
	 */

	

	
	
	currentComponent="tMap_6";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row6");
			  	}
			  	
 

ok_Hash.put("tMap_6", true);
end_Hash.put("tMap_6", System.currentTimeMillis());




/**
 * [tMap_6 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_4 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	

		if(mongo_tMongoDBOutput_4 != null){
			
				mongo_tMongoDBOutput_4.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_4", true); 
		
	globalMap.put("tMongoDBOutput_4_NB_LINE", nb_line_tMongoDBOutput_4);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"player_latest_market_value");
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
	 * [tMongoDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 



/**
 * [tMongoDBInput_2 finally ] stop
 */

	
	/**
	 * [tMap_6 finally ] start
	 */

	

	
	
	currentComponent="tMap_6";

	

 



/**
 * [tMap_6 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_4 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_4";

	
		if(resourceMap.get("finish_tMongoDBOutput_4") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_4") != null){

		    
		    			
		    			       ((com.mongodb.client.MongoClient)resourceMap.get("mongo_tMongoDBOutput_4")).close();
		    
		    
			
			}
		}

 



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
		

		globalMap.put("tMongoDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class player_injuriesStruct implements routines.system.IPersistableRow<player_injuriesStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
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
				
			    public Double days_missed;

				public Double getDays_missed () {
					return this.days_missed;
				}
				
			    public Integer games_missed;

				public Integer getGames_missed () {
					return this.games_missed;
				}
				
			    public String severity;

				public String getSeverity () {
					return this.severity;
				}
				
			    public String gamesmissedcategory;

				public String getGamesmissedcategory () {
					return this.gamesmissedcategory;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.days_missed = null;
           				} else {
           			    	this.days_missed = dis.readDouble();
           				}
					
						this.games_missed = readInteger(dis);
					
					this.severity = readString(dis);
					
					this.gamesmissedcategory = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.days_missed = null;
           				} else {
           			    	this.days_missed = dis.readDouble();
           				}
					
						this.games_missed = readInteger(dis);
					
					this.severity = readString(dis);
					
					this.gamesmissedcategory = readString(dis);
					
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
					
					// Double
				
						if(this.days_missed == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.days_missed);
		            	}
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
					// String
				
						writeString(this.severity,dos);
					
					// String
				
						writeString(this.gamesmissedcategory,dos);
					
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
					
					// Double
				
						if(this.days_missed == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.days_missed);
		            	}
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
					// String
				
						writeString(this.severity,dos);
					
					// String
				
						writeString(this.gamesmissedcategory,dos);
					
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
		sb.append(",days_missed="+String.valueOf(days_missed));
		sb.append(",games_missed="+String.valueOf(games_missed));
		sb.append(",severity="+severity);
		sb.append(",gamesmissedcategory="+gamesmissedcategory);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(player_injuriesStruct other) {

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

public static class row9Struct implements routines.system.IPersistableRow<row9Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
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
				
			    public Integer games_missed;

				public Integer getGames_missed () {
					return this.games_missed;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.player_id = readString(dis);
					
					this.season_name = readString(dis);
					
					this.injury_reason = readString(dis);
					
					this.from_date = readString(dis);
					
					this.end_date = readString(dis);
					
					this.days_missed = readString(dis);
					
						this.games_missed = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
					
					// Integer
				
						writeInteger(this.games_missed,dos);
					
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
		sb.append(",games_missed="+String.valueOf(games_missed));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row9Struct other) {

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
public void tMongoDBInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_5_SUBPROCESS_STATE", 0);

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



		row9Struct row9 = new row9Struct();
player_injuriesStruct player_injuries = new player_injuriesStruct();





	
	/**
	 * [tMongoDBOutput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_5", false);
		start_Hash.put("tMongoDBOutput_5", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_5";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"player_injuries");
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

                pathMap_tMongoDBOutput_5.put("player_id","");
                pathMap_tMongoDBOutput_5.put("season_name","");
                pathMap_tMongoDBOutput_5.put("injury_reason","");
                pathMap_tMongoDBOutput_5.put("from_date","");
                pathMap_tMongoDBOutput_5.put("end_date","");
                pathMap_tMongoDBOutput_5.put("days_missed","");
                pathMap_tMongoDBOutput_5.put("games_missed","");
                pathMap_tMongoDBOutput_5.put("severity","");
                pathMap_tMongoDBOutput_5.put("gamesmissedcategory","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_5=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_5=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBOutput_5 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBOutput_5 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBOutput_5);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBOutput_5 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBOutput_5 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBOutput_5.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBOutput_5.hosts(addrs_tMongoDBOutput_5);

                clientSettingsBuilder_tMongoDBOutput_5.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBOutput_5.build()));



        mongo_tMongoDBOutput_5 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBOutput_5.build());
        db_tMongoDBOutput_5 = mongo_tMongoDBOutput_5.getDatabase(context.mongo_database);

        db_tMongoDBOutput_5.getCollection(context.mongo_player_injuries_modifie).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_5 = db_tMongoDBOutput_5.getCollection(context.mongo_player_injuries_modifie);


 



/**
 * [tMongoDBOutput_5 begin ] stop
 */



	
	/**
	 * [tMap_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_7", false);
		start_Hash.put("tMap_7", System.currentTimeMillis());
		
	
	currentComponent="tMap_7";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row9");
					}
				
		int tos_count_tMap_7 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_7__Struct  {
	double daysmissed;
	String severity;
	String injurycategory;
	String gamesmissedcategory;
}
Var__tMap_7__Struct Var__tMap_7 = new Var__tMap_7__Struct();
// ###############################

// ###############################
// # Outputs initialization
player_injuriesStruct player_injuries_tmp = new player_injuriesStruct();
// ###############################

        
        



        









 



/**
 * [tMap_7 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_5 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_5", false);
		start_Hash.put("tMongoDBInput_5", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_5";

	
		int tos_count_tMongoDBInput_5 = 0;
		


	

final String applicationName_tMongoDBInput_5 = "Talend";

	int nb_line_tMongoDBInput_5 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_5=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_5=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_5 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_5 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_5);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_5 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_5 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_5.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_5.hosts(addrs_tMongoDBInput_5);

                clientSettingsBuilder_tMongoDBInput_5.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_5.build()));



        mongo_tMongoDBInput_5 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_5.build());
        db_tMongoDBInput_5 = mongo_tMongoDBInput_5.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_5 = db_tMongoDBInput_5.getCollection(context.mongo_player_injuries);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_5 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_5.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_5.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_5.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_5 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_5 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_5 = coll_tMongoDBInput_5.find(myQuery_tMongoDBInput_5).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_5{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_5 dbObjectInputUtil_tMongoDBInput_5=new DBObjectInputUtil_tMongoDBInput_5();
				java.util.Map<String, String> pathMap_tMongoDBInput_5=new java.util.HashMap<>();
				pathMap_tMongoDBInput_5.put("player_id","");
				pathMap_tMongoDBInput_5.put("season_name","");
				pathMap_tMongoDBInput_5.put("injury_reason","");
				pathMap_tMongoDBInput_5.put("from_date","");
				pathMap_tMongoDBInput_5.put("end_date","");
				pathMap_tMongoDBInput_5.put("days_missed","");
				pathMap_tMongoDBInput_5.put("games_missed","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_5 = findIterable_tMongoDBInput_5.iterator();
						
				while (cursor_tMongoDBInput_5.hasNext()){
				org.bson.Document o_tMongoDBInput_5 = cursor_tMongoDBInput_5.next();
				nb_line_tMongoDBInput_5++;
				Object valueObj_tMongoDBInput_5=null;
                    valueObj_tMongoDBInput_5=dbObjectInputUtil_tMongoDBInput_5.getValue(pathMap_tMongoDBInput_5.get("player_id"),"player_id",o_tMongoDBInput_5);
					
				row9.player_id = valueObj_tMongoDBInput_5==null ? null : valueObj_tMongoDBInput_5.toString();
				
                    valueObj_tMongoDBInput_5=dbObjectInputUtil_tMongoDBInput_5.getValue(pathMap_tMongoDBInput_5.get("season_name"),"season_name",o_tMongoDBInput_5);
					
				row9.season_name = valueObj_tMongoDBInput_5==null ? null : valueObj_tMongoDBInput_5.toString();
				
                    valueObj_tMongoDBInput_5=dbObjectInputUtil_tMongoDBInput_5.getValue(pathMap_tMongoDBInput_5.get("injury_reason"),"injury_reason",o_tMongoDBInput_5);
					
				row9.injury_reason = valueObj_tMongoDBInput_5==null ? null : valueObj_tMongoDBInput_5.toString();
				
                    valueObj_tMongoDBInput_5=dbObjectInputUtil_tMongoDBInput_5.getValue(pathMap_tMongoDBInput_5.get("from_date"),"from_date",o_tMongoDBInput_5);
					
				row9.from_date = valueObj_tMongoDBInput_5==null ? null : valueObj_tMongoDBInput_5.toString();
				
                    valueObj_tMongoDBInput_5=dbObjectInputUtil_tMongoDBInput_5.getValue(pathMap_tMongoDBInput_5.get("end_date"),"end_date",o_tMongoDBInput_5);
					
				row9.end_date = valueObj_tMongoDBInput_5==null ? null : valueObj_tMongoDBInput_5.toString();
				
                    valueObj_tMongoDBInput_5=dbObjectInputUtil_tMongoDBInput_5.getValue(pathMap_tMongoDBInput_5.get("days_missed"),"days_missed",o_tMongoDBInput_5);
					
				row9.days_missed = valueObj_tMongoDBInput_5==null ? null : valueObj_tMongoDBInput_5.toString();
				
                    valueObj_tMongoDBInput_5=dbObjectInputUtil_tMongoDBInput_5.getValue(pathMap_tMongoDBInput_5.get("games_missed"),"games_missed",o_tMongoDBInput_5);
				if(valueObj_tMongoDBInput_5!=null && valueObj_tMongoDBInput_5.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_5.getClass().equals(Double.class)) {
                                row9.games_missed = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_5.toString()).intValue();
                            } else {
                                row9.games_missed = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_5.toString());
                            }
				}else{
					row9.games_missed = null;
				}


 



/**
 * [tMongoDBInput_5 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_5 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_5";

	

 


	tos_count_tMongoDBInput_5++;

/**
 * [tMongoDBInput_5 main ] stop
 */
	
	/**
	 * [tMongoDBInput_5 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_5";

	

 



/**
 * [tMongoDBInput_5 process_data_begin ] stop
 */

	
	/**
	 * [tMap_7 main ] start
	 */

	

	
	
	currentComponent="tMap_7";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row9"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_7 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_7 = false;
		  boolean mainRowRejected_tMap_7 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_7__Struct Var = Var__tMap_7;
Var.daysmissed = row9.days_missed == null || row9.days_missed.trim().isEmpty() ? 0.0 :
Double.parseDouble(row9.days_missed);
Var.severity = Var.daysmissed <= 0.0 ? "Inconnu" :
Var.daysmissed <= 7.0 ? "Légère (1-7j)" :
Var.daysmissed <= 21.0 ? "Modérée (8-21j)" :
Var.daysmissed <= 60.0 ? "Grave (22-60j)" : "Très grave (60j+)" ;
Var.injurycategory = row9.injury_reason == null || row9.injury_reason.trim().isEmpty() ? "Inconnu" :
row9.injury_reason.toLowerCase().contains("hamstring") ? "Ischio-jambiers" :
row9.injury_reason.toLowerCase().contains("knee") ? "Genou" :
row9.injury_reason.toLowerCase().contains("ankle") ? "Cheville" :
row9.injury_reason.toLowerCase().contains("thigh") ? "Cuisse" :
row9.injury_reason.toLowerCase().contains("back") || row9.injury_reason.toLowerCase().contains("lumbago") ? "Dos" :
row9.injury_reason.toLowerCase().contains("shoulder") ? "Épaule" :
row9.injury_reason.toLowerCase().contains("muscle") || row9.injury_reason.toLowerCase().contains("muscular") ? "Musculaire" :
row9.injury_reason.toLowerCase().contains("hand") ? "Main" :
row9.injury_reason.toLowerCase().contains("foot") || row9.injury_reason.toLowerCase().contains("toe") ? "Pied" :
row9.injury_reason.toLowerCase().contains("hip") || row9.injury_reason.toLowerCase().contains("pelvic") ? "Hanche/Bassin" :
row9.injury_reason.toLowerCase().contains("rest") ? "Repos" :
row9.injury_reason.toLowerCase().contains("cold") || row9.injury_reason.toLowerCase().contains("ill") ? "Maladie" : "Autre" ;
Var.gamesmissedcategory = row9.games_missed == null || row9.games_missed == 0 ? "Aucun match manqué" :
row9.games_missed <= 3 ? "Peu (1-3 matchs)" :
row9.games_missed <= 10 ? "Modéré (4-10 matchs)" : "Beaucoup (10+ matchs)";// ###############################
        // ###############################
        // # Output tables

player_injuries = null;


// # Output table : 'player_injuries'
player_injuries_tmp.player_id = row9.player_id ;
player_injuries_tmp.season_name = row9.season_name ;
player_injuries_tmp.injury_reason = Var.injurycategory ;
player_injuries_tmp.from_date = row9.from_date ;
player_injuries_tmp.end_date = row9.end_date ;
player_injuries_tmp.days_missed = Var.daysmissed ;
player_injuries_tmp.games_missed = row9.games_missed ;
player_injuries_tmp.severity = Var.severity ;
player_injuries_tmp.gamesmissedcategory = Var.gamesmissedcategory ;
player_injuries = player_injuries_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_7 = false;










 


	tos_count_tMap_7++;

/**
 * [tMap_7 main ] stop
 */
	
	/**
	 * [tMap_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_7";

	

 



/**
 * [tMap_7 process_data_begin ] stop
 */
// Start of branch "player_injuries"
if(player_injuries != null) { 



	
	/**
	 * [tMongoDBOutput_5 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"player_injuries"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_5.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("player_id"),"player_id", player_injuries.player_id);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("season_name"),"season_name", player_injuries.season_name);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("injury_reason"),"injury_reason", player_injuries.injury_reason);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("from_date"),"from_date", player_injuries.from_date);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("end_date"),"end_date", player_injuries.end_date);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("days_missed"),"days_missed", player_injuries.days_missed);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("games_missed"),"games_missed", player_injuries.games_missed);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("severity"),"severity", player_injuries.severity);
                                        updateObjectUtil_tMongoDBOutput_5.put(pathMap_tMongoDBOutput_5.get("gamesmissedcategory"),"gamesmissedcategory", player_injuries.gamesmissedcategory);
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

} // End of branch "player_injuries"




	
	/**
	 * [tMap_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_7";

	

 



/**
 * [tMap_7 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_5 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_5";

	

 



/**
 * [tMongoDBInput_5 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_5 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_5";

	

            }
                    if(mongo_tMongoDBInput_5 != null) {
                        mongo_tMongoDBInput_5.close();
                    }
    globalMap.put("tMongoDBInput_5_NB_LINE", nb_line_tMongoDBInput_5);
 

ok_Hash.put("tMongoDBInput_5", true);
end_Hash.put("tMongoDBInput_5", System.currentTimeMillis());




/**
 * [tMongoDBInput_5 end ] stop
 */

	
	/**
	 * [tMap_7 end ] start
	 */

	

	
	
	currentComponent="tMap_7";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row9");
			  	}
			  	
 

ok_Hash.put("tMap_7", true);
end_Hash.put("tMap_7", System.currentTimeMillis());




/**
 * [tMap_7 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_5 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	

		if(mongo_tMongoDBOutput_5 != null){
			
				mongo_tMongoDBOutput_5.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_5", true); 
		
	globalMap.put("tMongoDBOutput_5_NB_LINE", nb_line_tMongoDBOutput_5);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"player_injuries");
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
	 * [tMongoDBInput_5 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_5";

	

 



/**
 * [tMongoDBInput_5 finally ] stop
 */

	
	/**
	 * [tMap_7 finally ] start
	 */

	

	
	
	currentComponent="tMap_7";

	

 



/**
 * [tMap_7 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_5 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_5";

	
		if(resourceMap.get("finish_tMongoDBOutput_5") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_5") != null){

		    
		    			
		    			       ((com.mongodb.client.MongoClient)resourceMap.get("mongo_tMongoDBOutput_5")).close();
		    
		    
			
			}
		}

 



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
		

		globalMap.put("tMongoDBInput_5_SUBPROCESS_STATE", 1);
	}
	


public static class player_performancesStruct implements routines.system.IPersistableRow<player_performancesStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
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
				
			    public Double goals;

				public Double getGoals () {
					return this.goals;
				}
				
			    public Integer assists;

				public Integer getAssists () {
					return this.assists;
				}
				
			    public Integer own_goals;

				public Integer getOwn_goals () {
					return this.own_goals;
				}
				
			    public Long subed_in;

				public Long getSubed_in () {
					return this.subed_in;
				}
				
			    public Integer subed_out;

				public Integer getSubed_out () {
					return this.subed_out;
				}
				
			    public Integer yellow_cards;

				public Integer getYellow_cards () {
					return this.yellow_cards;
				}
				
			    public Integer second_yellow_cards;

				public Integer getSecond_yellow_cards () {
					return this.second_yellow_cards;
				}
				
			    public Integer direct_red_cards;

				public Integer getDirect_red_cards () {
					return this.direct_red_cards;
				}
				
			    public Integer penalty_goals;

				public Integer getPenalty_goals () {
					return this.penalty_goals;
				}
				
			    public Double minutes_played;

				public Double getMinutes_played () {
					return this.minutes_played;
				}
				
			    public Integer goals_conceded;

				public Integer getGoals_conceded () {
					return this.goals_conceded;
				}
				
			    public Integer clean_sheets;

				public Integer getClean_sheets () {
					return this.clean_sheets;
				}
				
			    public int total_cards;

				public int getTotal_cards () {
					return this.total_cards;
				}
				
			    public boolean is_starter;

				public boolean getIs_starter () {
					return this.is_starter;
				}
				
			    public double goals_per_90;

				public double getGoals_per_90 () {
					return this.goals_per_90;
				}
				
			    public double assists_per_90;

				public double getAssists_per_90 () {
					return this.assists_per_90;
				}
				
			    public double goal_contributions;

				public double getGoal_contributions () {
					return this.goal_contributions;
				}
				
			    public double goal_contributions_per_90;

				public double getGoal_contributions_per_90 () {
					return this.goal_contributions_per_90;
				}
				
			    public String performance_rating;

				public String getPerformance_rating () {
					return this.performance_rating;
				}
				
			    public String discipline_status;

				public String getDiscipline_status () {
					return this.discipline_status;
				}
				
			    public String competition_level;

				public String getCompetition_level () {
					return this.competition_level;
				}
				
			    public boolean has_played;

				public boolean getHas_played () {
					return this.has_played;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.player_id == null) ? 0 : this.player_id.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final player_performancesStruct other = (player_performancesStruct) obj;
		
						if (this.player_id == null) {
							if (other.player_id != null)
								return false;
						
						} else if (!this.player_id.equals(other.player_id))
						
							return false;
					

		return true;
    }

	public void copyDataTo(player_performancesStruct other) {

		other.player_id = this.player_id;
	            other.season_name = this.season_name;
	            other.competition_id = this.competition_id;
	            other.competition_name = this.competition_name;
	            other.team_id = this.team_id;
	            other.team_name = this.team_name;
	            other.nb_in_group = this.nb_in_group;
	            other.nb_on_pitch = this.nb_on_pitch;
	            other.goals = this.goals;
	            other.assists = this.assists;
	            other.own_goals = this.own_goals;
	            other.subed_in = this.subed_in;
	            other.subed_out = this.subed_out;
	            other.yellow_cards = this.yellow_cards;
	            other.second_yellow_cards = this.second_yellow_cards;
	            other.direct_red_cards = this.direct_red_cards;
	            other.penalty_goals = this.penalty_goals;
	            other.minutes_played = this.minutes_played;
	            other.goals_conceded = this.goals_conceded;
	            other.clean_sheets = this.clean_sheets;
	            other.total_cards = this.total_cards;
	            other.is_starter = this.is_starter;
	            other.goals_per_90 = this.goals_per_90;
	            other.assists_per_90 = this.assists_per_90;
	            other.goal_contributions = this.goal_contributions;
	            other.goal_contributions_per_90 = this.goal_contributions_per_90;
	            other.performance_rating = this.performance_rating;
	            other.discipline_status = this.discipline_status;
	            other.competition_level = this.competition_level;
	            other.has_played = this.has_played;
	            
	}

	public void copyKeysDataTo(player_performancesStruct other) {

		other.player_id = this.player_id;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
			        this.total_cards = dis.readInt();
					
			        this.is_starter = dis.readBoolean();
					
			        this.goals_per_90 = dis.readDouble();
					
			        this.assists_per_90 = dis.readDouble();
					
			        this.goal_contributions = dis.readDouble();
					
			        this.goal_contributions_per_90 = dis.readDouble();
					
					this.performance_rating = readString(dis);
					
					this.discipline_status = readString(dis);
					
					this.competition_level = readString(dis);
					
			        this.has_played = dis.readBoolean();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
			        this.total_cards = dis.readInt();
					
			        this.is_starter = dis.readBoolean();
					
			        this.goals_per_90 = dis.readDouble();
					
			        this.assists_per_90 = dis.readDouble();
					
			        this.goal_contributions = dis.readDouble();
					
			        this.goal_contributions_per_90 = dis.readDouble();
					
					this.performance_rating = readString(dis);
					
					this.discipline_status = readString(dis);
					
					this.competition_level = readString(dis);
					
			        this.has_played = dis.readBoolean();
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
					// int
				
		            	dos.writeInt(this.total_cards);
					
					// boolean
				
		            	dos.writeBoolean(this.is_starter);
					
					// double
				
		            	dos.writeDouble(this.goals_per_90);
					
					// double
				
		            	dos.writeDouble(this.assists_per_90);
					
					// double
				
		            	dos.writeDouble(this.goal_contributions);
					
					// double
				
		            	dos.writeDouble(this.goal_contributions_per_90);
					
					// String
				
						writeString(this.performance_rating,dos);
					
					// String
				
						writeString(this.discipline_status,dos);
					
					// String
				
						writeString(this.competition_level,dos);
					
					// boolean
				
		            	dos.writeBoolean(this.has_played);
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
					// int
				
		            	dos.writeInt(this.total_cards);
					
					// boolean
				
		            	dos.writeBoolean(this.is_starter);
					
					// double
				
		            	dos.writeDouble(this.goals_per_90);
					
					// double
				
		            	dos.writeDouble(this.assists_per_90);
					
					// double
				
		            	dos.writeDouble(this.goal_contributions);
					
					// double
				
		            	dos.writeDouble(this.goal_contributions_per_90);
					
					// String
				
						writeString(this.performance_rating,dos);
					
					// String
				
						writeString(this.discipline_status,dos);
					
					// String
				
						writeString(this.competition_level,dos);
					
					// boolean
				
		            	dos.writeBoolean(this.has_played);
					
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
		sb.append(",goals="+String.valueOf(goals));
		sb.append(",assists="+String.valueOf(assists));
		sb.append(",own_goals="+String.valueOf(own_goals));
		sb.append(",subed_in="+String.valueOf(subed_in));
		sb.append(",subed_out="+String.valueOf(subed_out));
		sb.append(",yellow_cards="+String.valueOf(yellow_cards));
		sb.append(",second_yellow_cards="+String.valueOf(second_yellow_cards));
		sb.append(",direct_red_cards="+String.valueOf(direct_red_cards));
		sb.append(",penalty_goals="+String.valueOf(penalty_goals));
		sb.append(",minutes_played="+String.valueOf(minutes_played));
		sb.append(",goals_conceded="+String.valueOf(goals_conceded));
		sb.append(",clean_sheets="+String.valueOf(clean_sheets));
		sb.append(",total_cards="+String.valueOf(total_cards));
		sb.append(",is_starter="+String.valueOf(is_starter));
		sb.append(",goals_per_90="+String.valueOf(goals_per_90));
		sb.append(",assists_per_90="+String.valueOf(assists_per_90));
		sb.append(",goal_contributions="+String.valueOf(goal_contributions));
		sb.append(",goal_contributions_per_90="+String.valueOf(goal_contributions_per_90));
		sb.append(",performance_rating="+performance_rating);
		sb.append(",discipline_status="+discipline_status);
		sb.append(",competition_level="+competition_level);
		sb.append(",has_played="+String.valueOf(has_played));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(player_performancesStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.player_id, other.player_id);
						if(returnValue != 0) {
							return returnValue;
						}

					
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

public static class row10Struct implements routines.system.IPersistableRow<row10Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
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
				
			    public Double goals;

				public Double getGoals () {
					return this.goals;
				}
				
			    public Integer assists;

				public Integer getAssists () {
					return this.assists;
				}
				
			    public Integer own_goals;

				public Integer getOwn_goals () {
					return this.own_goals;
				}
				
			    public Long subed_in;

				public Long getSubed_in () {
					return this.subed_in;
				}
				
			    public Integer subed_out;

				public Integer getSubed_out () {
					return this.subed_out;
				}
				
			    public Integer yellow_cards;

				public Integer getYellow_cards () {
					return this.yellow_cards;
				}
				
			    public Integer second_yellow_cards;

				public Integer getSecond_yellow_cards () {
					return this.second_yellow_cards;
				}
				
			    public Integer direct_red_cards;

				public Integer getDirect_red_cards () {
					return this.direct_red_cards;
				}
				
			    public Integer penalty_goals;

				public Integer getPenalty_goals () {
					return this.penalty_goals;
				}
				
			    public Double minutes_played;

				public Double getMinutes_played () {
					return this.minutes_played;
				}
				
			    public Integer goals_conceded;

				public Integer getGoals_conceded () {
					return this.goals_conceded;
				}
				
			    public Integer clean_sheets;

				public Integer getClean_sheets () {
					return this.clean_sheets;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
	private Integer readInteger(ObjectInputStream dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
		Integer intReturn;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			intReturn = null;
		} else {
	    	intReturn = dis.readInt();
		}
		return intReturn;
	}

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.goals = null;
           				} else {
           			    	this.goals = dis.readDouble();
           				}
					
						this.assists = readInteger(dis);
					
						this.own_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.subed_in = null;
           				} else {
           			    	this.subed_in = dis.readLong();
           				}
					
						this.subed_out = readInteger(dis);
					
						this.yellow_cards = readInteger(dis);
					
						this.second_yellow_cards = readInteger(dis);
					
						this.direct_red_cards = readInteger(dis);
					
						this.penalty_goals = readInteger(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.minutes_played = null;
           				} else {
           			    	this.minutes_played = dis.readDouble();
           				}
					
						this.goals_conceded = readInteger(dis);
					
						this.clean_sheets = readInteger(dis);
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
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
					
					// Double
				
						if(this.goals == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.goals);
		            	}
					
					// Integer
				
						writeInteger(this.assists,dos);
					
					// Integer
				
						writeInteger(this.own_goals,dos);
					
					// Long
				
						if(this.subed_in == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.subed_in);
		            	}
					
					// Integer
				
						writeInteger(this.subed_out,dos);
					
					// Integer
				
						writeInteger(this.yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.second_yellow_cards,dos);
					
					// Integer
				
						writeInteger(this.direct_red_cards,dos);
					
					// Integer
				
						writeInteger(this.penalty_goals,dos);
					
					// Double
				
						if(this.minutes_played == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeDouble(this.minutes_played);
		            	}
					
					// Integer
				
						writeInteger(this.goals_conceded,dos);
					
					// Integer
				
						writeInteger(this.clean_sheets,dos);
					
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
		sb.append(",goals="+String.valueOf(goals));
		sb.append(",assists="+String.valueOf(assists));
		sb.append(",own_goals="+String.valueOf(own_goals));
		sb.append(",subed_in="+String.valueOf(subed_in));
		sb.append(",subed_out="+String.valueOf(subed_out));
		sb.append(",yellow_cards="+String.valueOf(yellow_cards));
		sb.append(",second_yellow_cards="+String.valueOf(second_yellow_cards));
		sb.append(",direct_red_cards="+String.valueOf(direct_red_cards));
		sb.append(",penalty_goals="+String.valueOf(penalty_goals));
		sb.append(",minutes_played="+String.valueOf(minutes_played));
		sb.append(",goals_conceded="+String.valueOf(goals_conceded));
		sb.append(",clean_sheets="+String.valueOf(clean_sheets));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row10Struct other) {

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
public void tMongoDBInput_8Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_8_SUBPROCESS_STATE", 0);

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



		row10Struct row10 = new row10Struct();
player_performancesStruct player_performances = new player_performancesStruct();





	
	/**
	 * [tMongoDBOutput_6 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_6", false);
		start_Hash.put("tMongoDBOutput_6", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_6";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"player_performances");
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
                pathMap_tMongoDBOutput_6.put("competition_id","");
                pathMap_tMongoDBOutput_6.put("competition_name","");
                pathMap_tMongoDBOutput_6.put("team_id","");
                pathMap_tMongoDBOutput_6.put("team_name","");
                pathMap_tMongoDBOutput_6.put("nb_in_group","");
                pathMap_tMongoDBOutput_6.put("nb_on_pitch","");
                pathMap_tMongoDBOutput_6.put("goals","");
                pathMap_tMongoDBOutput_6.put("assists","");
                pathMap_tMongoDBOutput_6.put("own_goals","");
                pathMap_tMongoDBOutput_6.put("subed_in","");
                pathMap_tMongoDBOutput_6.put("subed_out","");
                pathMap_tMongoDBOutput_6.put("yellow_cards","");
                pathMap_tMongoDBOutput_6.put("second_yellow_cards","");
                pathMap_tMongoDBOutput_6.put("direct_red_cards","");
                pathMap_tMongoDBOutput_6.put("penalty_goals","");
                pathMap_tMongoDBOutput_6.put("minutes_played","");
                pathMap_tMongoDBOutput_6.put("goals_conceded","");
                pathMap_tMongoDBOutput_6.put("clean_sheets","");
                pathMap_tMongoDBOutput_6.put("total_cards","");
                pathMap_tMongoDBOutput_6.put("is_starter","");
                pathMap_tMongoDBOutput_6.put("goals_per_90","");
                pathMap_tMongoDBOutput_6.put("assists_per_90","");
                pathMap_tMongoDBOutput_6.put("goal_contributions","");
                pathMap_tMongoDBOutput_6.put("goal_contributions_per_90","");
                pathMap_tMongoDBOutput_6.put("performance_rating","");
                pathMap_tMongoDBOutput_6.put("discipline_status","");
                pathMap_tMongoDBOutput_6.put("competition_level","");
                pathMap_tMongoDBOutput_6.put("has_played","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_6=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_6=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBOutput_6 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBOutput_6 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBOutput_6);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBOutput_6 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBOutput_6 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBOutput_6.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBOutput_6.hosts(addrs_tMongoDBOutput_6);

                clientSettingsBuilder_tMongoDBOutput_6.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBOutput_6.build()));



        mongo_tMongoDBOutput_6 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBOutput_6.build());
        db_tMongoDBOutput_6 = mongo_tMongoDBOutput_6.getDatabase(context.mongo_database);

        db_tMongoDBOutput_6.getCollection(context.mongo_player_performances_modifie).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_6 = db_tMongoDBOutput_6.getCollection(context.mongo_player_performances_modifie);


 



/**
 * [tMongoDBOutput_6 begin ] stop
 */



	
	/**
	 * [tMap_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_8", false);
		start_Hash.put("tMap_8", System.currentTimeMillis());
		
	
	currentComponent="tMap_8";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row10");
					}
				
		int tos_count_tMap_8 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_8__Struct  {
	int total_cards;
	boolean is_starter;
	double goals_per_90;
	double assists_per_90;
	double goal_contributions;
	double goal_contributions_per_90;
	String performance_rating;
	boolean has_played;
	String discipline_status;
	String competition_level;
}
Var__tMap_8__Struct Var__tMap_8 = new Var__tMap_8__Struct();
// ###############################

// ###############################
// # Outputs initialization
player_performancesStruct player_performances_tmp = new player_performancesStruct();
// ###############################

        
        



        









 



/**
 * [tMap_8 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_8 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_8", false);
		start_Hash.put("tMongoDBInput_8", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_8";

	
		int tos_count_tMongoDBInput_8 = 0;
		


	

final String applicationName_tMongoDBInput_8 = "Talend";

	int nb_line_tMongoDBInput_8 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_8=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_8=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_8 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_8 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_8);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_8 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_8 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_8.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_8.hosts(addrs_tMongoDBInput_8);

                clientSettingsBuilder_tMongoDBInput_8.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_8.build()));



        mongo_tMongoDBInput_8 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_8.build());
        db_tMongoDBInput_8 = mongo_tMongoDBInput_8.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_8 = db_tMongoDBInput_8.getCollection(context.mongo_player_performances);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_8 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_8.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_8.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_8.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_8 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_8 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_8 = coll_tMongoDBInput_8.find(myQuery_tMongoDBInput_8).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_8{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_8 dbObjectInputUtil_tMongoDBInput_8=new DBObjectInputUtil_tMongoDBInput_8();
				java.util.Map<String, String> pathMap_tMongoDBInput_8=new java.util.HashMap<>();
				pathMap_tMongoDBInput_8.put("player_id","");
				pathMap_tMongoDBInput_8.put("season_name","");
				pathMap_tMongoDBInput_8.put("competition_id","");
				pathMap_tMongoDBInput_8.put("competition_name","");
				pathMap_tMongoDBInput_8.put("team_id","");
				pathMap_tMongoDBInput_8.put("team_name","");
				pathMap_tMongoDBInput_8.put("nb_in_group","");
				pathMap_tMongoDBInput_8.put("nb_on_pitch","");
				pathMap_tMongoDBInput_8.put("goals","");
				pathMap_tMongoDBInput_8.put("assists","");
				pathMap_tMongoDBInput_8.put("own_goals","");
				pathMap_tMongoDBInput_8.put("subed_in","");
				pathMap_tMongoDBInput_8.put("subed_out","");
				pathMap_tMongoDBInput_8.put("yellow_cards","");
				pathMap_tMongoDBInput_8.put("second_yellow_cards","");
				pathMap_tMongoDBInput_8.put("direct_red_cards","");
				pathMap_tMongoDBInput_8.put("penalty_goals","");
				pathMap_tMongoDBInput_8.put("minutes_played","");
				pathMap_tMongoDBInput_8.put("goals_conceded","");
				pathMap_tMongoDBInput_8.put("clean_sheets","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_8 = findIterable_tMongoDBInput_8.iterator();
						
				while (cursor_tMongoDBInput_8.hasNext()){
				org.bson.Document o_tMongoDBInput_8 = cursor_tMongoDBInput_8.next();
				nb_line_tMongoDBInput_8++;
				Object valueObj_tMongoDBInput_8=null;
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("player_id"),"player_id",o_tMongoDBInput_8);
					
				row10.player_id = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("season_name"),"season_name",o_tMongoDBInput_8);
					
				row10.season_name = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("competition_id"),"competition_id",o_tMongoDBInput_8);
					
				row10.competition_id = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("competition_name"),"competition_name",o_tMongoDBInput_8);
					
				row10.competition_name = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("team_id"),"team_id",o_tMongoDBInput_8);
					
				row10.team_id = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("team_name"),"team_name",o_tMongoDBInput_8);
					
				row10.team_name = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("nb_in_group"),"nb_in_group",o_tMongoDBInput_8);
					
				row10.nb_in_group = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("nb_on_pitch"),"nb_on_pitch",o_tMongoDBInput_8);
					
				row10.nb_on_pitch = valueObj_tMongoDBInput_8==null ? null : valueObj_tMongoDBInput_8.toString();
				
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("goals"),"goals",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            row10.goals = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString());
				}else{
					row10.goals = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("assists"),"assists",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.assists = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.assists = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.assists = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("own_goals"),"own_goals",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.own_goals = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.own_goals = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.own_goals = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("subed_in"),"subed_in",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.subed_in = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).longValue();
                            } else {
                                row10.subed_in = ParserUtils.parseTo_Long(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.subed_in = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("subed_out"),"subed_out",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.subed_out = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.subed_out = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.subed_out = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("yellow_cards"),"yellow_cards",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.yellow_cards = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.yellow_cards = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.yellow_cards = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("second_yellow_cards"),"second_yellow_cards",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.second_yellow_cards = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.second_yellow_cards = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.second_yellow_cards = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("direct_red_cards"),"direct_red_cards",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.direct_red_cards = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.direct_red_cards = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.direct_red_cards = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("penalty_goals"),"penalty_goals",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.penalty_goals = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.penalty_goals = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.penalty_goals = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("minutes_played"),"minutes_played",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            row10.minutes_played = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString());
				}else{
					row10.minutes_played = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("goals_conceded"),"goals_conceded",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.goals_conceded = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.goals_conceded = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.goals_conceded = null;
				}
                    valueObj_tMongoDBInput_8=dbObjectInputUtil_tMongoDBInput_8.getValue(pathMap_tMongoDBInput_8.get("clean_sheets"),"clean_sheets",o_tMongoDBInput_8);
				if(valueObj_tMongoDBInput_8!=null && valueObj_tMongoDBInput_8.toString().length() > 0) {
                            if (valueObj_tMongoDBInput_8.getClass().equals(Double.class)) {
                                row10.clean_sheets = ParserUtils.parseTo_Double(valueObj_tMongoDBInput_8.toString()).intValue();
                            } else {
                                row10.clean_sheets = ParserUtils.parseTo_Integer(valueObj_tMongoDBInput_8.toString());
                            }
				}else{
					row10.clean_sheets = null;
				}


 



/**
 * [tMongoDBInput_8 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_8 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_8";

	

 


	tos_count_tMongoDBInput_8++;

/**
 * [tMongoDBInput_8 main ] stop
 */
	
	/**
	 * [tMongoDBInput_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_8";

	

 



/**
 * [tMongoDBInput_8 process_data_begin ] stop
 */

	
	/**
	 * [tMap_8 main ] start
	 */

	

	
	
	currentComponent="tMap_8";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row10"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_8 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_8 = false;
		  boolean mainRowRejected_tMap_8 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_8__Struct Var = Var__tMap_8;
Var.total_cards = (row10.yellow_cards == null ? 0 : row10.yellow_cards) +
(row10.second_yellow_cards == null ? 0 : row10.second_yellow_cards) +
(row10.direct_red_cards == null ? 0 : row10.direct_red_cards);
Var.is_starter = (row10.nb_on_pitch != null && row10.nb_in_group != null &&
row10.nb_on_pitch.equals(row10.nb_in_group)) ? true : false ;
Var.goals_per_90 = (row10.minutes_played == null || row10.minutes_played == 0.0 || row10.goals == null) ? 0.0 :
Math.round((row10.goals / row10.minutes_played * 90.0) * 100.0) / 100.0;
Var.assists_per_90 = (row10.minutes_played == null || row10.minutes_played == 0.0) ? 0.0 :
Math.round(((row10.assists == null ? 0.0 : (double)row10.assists) / row10.minutes_played * 90.0) * 100.0) / 100.0 ;
Var.goal_contributions = (row10.goals == null ? 0.0 : row10.goals) +
(row10.assists == null ? 0.0 : (double)row10.assists) ;
Var.goal_contributions_per_90 = (row10.minutes_played == null || row10.minutes_played == 0.0) ? 0.0 :
Math.round((Var.goal_contributions / row10.minutes_played * 90.0) * 100.0) / 100.0;
Var.performance_rating = !Var.has_played ? "N/A" :
Var.goal_contributions >= 1.0 && Var.total_cards == 0 ? "Excellent" :
Var.goal_contributions >= 1.0 && Var.total_cards > 0 ? "Bon" :
Var.goal_contributions == 0.0 && Var.total_cards == 0 ? "Neutre" : "Mauvais";
Var.has_played = (row10.minutes_played != null && row10.minutes_played > 0.0) ? true : false;
Var.discipline_status = Var.total_cards == 0 ? "Propre" :
row10.direct_red_cards != null && row10.direct_red_cards > 0 ? "Expulsé (rouge direct)" :
row10.second_yellow_cards != null && row10.second_yellow_cards > 0 ? "Expulsé (2e jaune)" :
"Averti (jaune)" ;
Var.competition_level = row10.competition_id == null ? "Inconnu" :
row10.competition_id.startsWith("L1") ? "Ligue 1" :
row10.competition_id.startsWith("L2") ? "Ligue 2" :
row10.competition_id.equalsIgnoreCase("DFB") ? "Coupe nationale" :
row10.competition_id.startsWith("CL") ? "Champions League" :
row10.competition_id.startsWith("EL") ? "Europa League" : "Autre";// ###############################
        // ###############################
        // # Output tables

player_performances = null;


// # Output table : 'player_performances'
player_performances_tmp.player_id = row10.player_id ;
player_performances_tmp.season_name = row10.season_name ;
player_performances_tmp.competition_id = row10.competition_id ;
player_performances_tmp.competition_name = row10.competition_name ;
player_performances_tmp.team_id = row10.team_id ;
player_performances_tmp.team_name = row10.team_name ;
player_performances_tmp.nb_in_group = row10.nb_in_group ;
player_performances_tmp.nb_on_pitch = row10.nb_on_pitch ;
player_performances_tmp.goals = row10.goals ;
player_performances_tmp.assists = row10.assists ;
player_performances_tmp.own_goals = row10.own_goals;
player_performances_tmp.subed_in = row10.subed_in ;
player_performances_tmp.subed_out = row10.subed_out ;
player_performances_tmp.yellow_cards = row10.yellow_cards ;
player_performances_tmp.second_yellow_cards = row10.second_yellow_cards ;
player_performances_tmp.direct_red_cards = row10.direct_red_cards ;
player_performances_tmp.penalty_goals = row10.penalty_goals ;
player_performances_tmp.minutes_played = row10.minutes_played ;
player_performances_tmp.goals_conceded = row10.goals_conceded ;
player_performances_tmp.clean_sheets = row10.clean_sheets ;
player_performances_tmp.total_cards = Var.total_cards ;
player_performances_tmp.is_starter = Var.is_starter ;
player_performances_tmp.goals_per_90 = Var.goals_per_90 ;
player_performances_tmp.assists_per_90 = Var.assists_per_90 ;
player_performances_tmp.goal_contributions = Var.goal_contributions ;
player_performances_tmp.goal_contributions_per_90 = Var.goal_contributions_per_90 ;
player_performances_tmp.performance_rating = Var.performance_rating ;
player_performances_tmp.discipline_status = Var.discipline_status ;
player_performances_tmp.competition_level = Var.competition_level ;
player_performances_tmp.has_played = Var.has_played ;
player_performances = player_performances_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_8 = false;










 


	tos_count_tMap_8++;

/**
 * [tMap_8 main ] stop
 */
	
	/**
	 * [tMap_8 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_8";

	

 



/**
 * [tMap_8 process_data_begin ] stop
 */
// Start of branch "player_performances"
if(player_performances != null) { 



	
	/**
	 * [tMongoDBOutput_6 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"player_performances"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_6.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("player_id"),"player_id", player_performances.player_id);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("season_name"),"season_name", player_performances.season_name);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("competition_id"),"competition_id", player_performances.competition_id);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("competition_name"),"competition_name", player_performances.competition_name);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("team_id"),"team_id", player_performances.team_id);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("team_name"),"team_name", player_performances.team_name);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("nb_in_group"),"nb_in_group", player_performances.nb_in_group);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("nb_on_pitch"),"nb_on_pitch", player_performances.nb_on_pitch);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("goals"),"goals", player_performances.goals);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("assists"),"assists", player_performances.assists);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("own_goals"),"own_goals", player_performances.own_goals);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("subed_in"),"subed_in", player_performances.subed_in);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("subed_out"),"subed_out", player_performances.subed_out);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("yellow_cards"),"yellow_cards", player_performances.yellow_cards);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("second_yellow_cards"),"second_yellow_cards", player_performances.second_yellow_cards);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("direct_red_cards"),"direct_red_cards", player_performances.direct_red_cards);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("penalty_goals"),"penalty_goals", player_performances.penalty_goals);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("minutes_played"),"minutes_played", player_performances.minutes_played);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("goals_conceded"),"goals_conceded", player_performances.goals_conceded);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("clean_sheets"),"clean_sheets", player_performances.clean_sheets);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("total_cards"),"total_cards", player_performances.total_cards);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("is_starter"),"is_starter", player_performances.is_starter);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("goals_per_90"),"goals_per_90", player_performances.goals_per_90);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("assists_per_90"),"assists_per_90", player_performances.assists_per_90);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("goal_contributions"),"goal_contributions", player_performances.goal_contributions);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("goal_contributions_per_90"),"goal_contributions_per_90", player_performances.goal_contributions_per_90);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("performance_rating"),"performance_rating", player_performances.performance_rating);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("discipline_status"),"discipline_status", player_performances.discipline_status);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("competition_level"),"competition_level", player_performances.competition_level);
                                        updateObjectUtil_tMongoDBOutput_6.put(pathMap_tMongoDBOutput_6.get("has_played"),"has_played", player_performances.has_played);
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

} // End of branch "player_performances"




	
	/**
	 * [tMap_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_8";

	

 



/**
 * [tMap_8 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_8 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_8";

	

 



/**
 * [tMongoDBInput_8 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_8 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_8";

	

            }
                    if(mongo_tMongoDBInput_8 != null) {
                        mongo_tMongoDBInput_8.close();
                    }
    globalMap.put("tMongoDBInput_8_NB_LINE", nb_line_tMongoDBInput_8);
 

ok_Hash.put("tMongoDBInput_8", true);
end_Hash.put("tMongoDBInput_8", System.currentTimeMillis());




/**
 * [tMongoDBInput_8 end ] stop
 */

	
	/**
	 * [tMap_8 end ] start
	 */

	

	
	
	currentComponent="tMap_8";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row10");
			  	}
			  	
 

ok_Hash.put("tMap_8", true);
end_Hash.put("tMap_8", System.currentTimeMillis());




/**
 * [tMap_8 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_6 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	

		if(mongo_tMongoDBOutput_6 != null){
			
				mongo_tMongoDBOutput_6.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_6", true); 
		
	globalMap.put("tMongoDBOutput_6_NB_LINE", nb_line_tMongoDBOutput_6);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"player_performances");
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
	 * [tMongoDBInput_8 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_8";

	

 



/**
 * [tMongoDBInput_8 finally ] stop
 */

	
	/**
	 * [tMap_8 finally ] start
	 */

	

	
	
	currentComponent="tMap_8";

	

 



/**
 * [tMap_8 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_6 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_6";

	
		if(resourceMap.get("finish_tMongoDBOutput_6") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_6") != null){

		    
		    			
		    			       ((com.mongodb.client.MongoClient)resourceMap.get("mongo_tMongoDBOutput_6")).close();
		    
		    
			
			}
		}

 



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
		

		globalMap.put("tMongoDBInput_8_SUBPROCESS_STATE", 1);
	}
	


public static class team_detailStruct implements routines.system.IPersistableRow<team_detailStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
			    public String club_id;

				public String getClub_id () {
					return this.club_id;
				}
				
			    public String club_name;

				public String getClub_name () {
					return this.club_name;
				}
				
			    public String country_region;

				public String getCountry_region () {
					return this.country_region;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.club_id = readString(dis);
					
					this.club_name = readString(dis);
					
					this.country_region = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.club_id = readString(dis);
					
					this.club_name = readString(dis);
					
					this.country_region = readString(dis);
					
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
				
						writeString(this.club_name,dos);
					
					// String
				
						writeString(this.country_region,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.club_id,dos);
					
					// String
				
						writeString(this.club_name,dos);
					
					// String
				
						writeString(this.country_region,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("club_id="+club_id);
		sb.append(",club_name="+club_name);
		sb.append(",country_region="+country_region);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(team_detailStruct other) {

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

public static class row11Struct implements routines.system.IPersistableRow<row11Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_bronzetosilver.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_bronzetosilver.length == 0) {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_bronzetosilver, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
    public int compareTo(row11Struct other) {

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
public void tMongoDBInput_9Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_9_SUBPROCESS_STATE", 0);

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



		row11Struct row11 = new row11Struct();
team_detailStruct team_detail = new team_detailStruct();





	
	/**
	 * [tMongoDBOutput_7 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_7", false);
		start_Hash.put("tMongoDBOutput_7", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_7";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"team_detail");
					}
				
		int tos_count_tMongoDBOutput_7 = 0;
		

	

        java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(java.util.logging.Level.SEVERE);

final String applicationName_tMongoDBOutput_7 = "Talend";

    int nb_line_tMongoDBOutput_7 = 0;

			class DBObjectUtil_tMongoDBOutput_7 {
				
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
            DBObjectUtil_tMongoDBOutput_7 updateObjectUtil_tMongoDBOutput_7=new DBObjectUtil_tMongoDBOutput_7();
            DBObjectUtil_tMongoDBOutput_7 queryObjectUtil_tMongoDBOutput_7=new DBObjectUtil_tMongoDBOutput_7();
            java.util.Map<String, String> pathMap_tMongoDBOutput_7=new java.util.HashMap<>();

                pathMap_tMongoDBOutput_7.put("club_id","");
                pathMap_tMongoDBOutput_7.put("club_name","");
                pathMap_tMongoDBOutput_7.put("country_region","");




    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBOutput_7=null;
    com.mongodb.client.MongoDatabase db_tMongoDBOutput_7=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBOutput_7 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBOutput_7 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBOutput_7);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBOutput_7 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBOutput_7 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBOutput_7.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBOutput_7.hosts(addrs_tMongoDBOutput_7);

                clientSettingsBuilder_tMongoDBOutput_7.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBOutput_7.build()));



        mongo_tMongoDBOutput_7 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBOutput_7.build());
        db_tMongoDBOutput_7 = mongo_tMongoDBOutput_7.getDatabase(context.mongo_database);

        db_tMongoDBOutput_7.getCollection(context.mongo_team_details_modifie).drop();
    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_7 = db_tMongoDBOutput_7.getCollection(context.mongo_team_details_modifie);


 



/**
 * [tMongoDBOutput_7 begin ] stop
 */



	
	/**
	 * [tMap_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_9", false);
		start_Hash.put("tMap_9", System.currentTimeMillis());
		
	
	currentComponent="tMap_9";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row11");
					}
				
		int tos_count_tMap_9 = 0;
		




// ###############################
// # Lookup's keys initialization
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_9__Struct  {
	String var1;
	String country_region;
}
Var__tMap_9__Struct Var__tMap_9 = new Var__tMap_9__Struct();
// ###############################

// ###############################
// # Outputs initialization
team_detailStruct team_detail_tmp = new team_detailStruct();
// ###############################

        
        



        









 



/**
 * [tMap_9 begin ] stop
 */



	
	/**
	 * [tMongoDBInput_9 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBInput_9", false);
		start_Hash.put("tMongoDBInput_9", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBInput_9";

	
		int tos_count_tMongoDBInput_9 = 0;
		


	

final String applicationName_tMongoDBInput_9 = "Talend";

	int nb_line_tMongoDBInput_9 = 0;
	


    // Declarations
    com.mongodb.client.MongoClient mongo_tMongoDBInput_9=null;
    com.mongodb.client.MongoDatabase db_tMongoDBInput_9=null;

        // Internal declarations
        List<com.mongodb.ServerAddress> addrs_tMongoDBInput_9 = new java.util.ArrayList<>();
        com.mongodb.MongoClientSettings.Builder clientSettingsBuilder_tMongoDBInput_9 = com.mongodb.MongoClientSettings.builder().applicationName(applicationName_tMongoDBInput_9);
        com.mongodb.connection.ClusterSettings.Builder clusterSettingsBuilder_tMongoDBInput_9 = com.mongodb.connection.ClusterSettings.builder();
        com.mongodb.connection.SslSettings.Builder sslSettingsBuilder_tMongoDBInput_9 = com.mongodb.connection.SslSettings.builder();

                // SSL

                // Client Credentials
                    addrs_tMongoDBInput_9.add(new com.mongodb.ServerAddress(context.mongo_server, Integer.valueOf(context.mongo_port).intValue()));
                clusterSettingsBuilder_tMongoDBInput_9.hosts(addrs_tMongoDBInput_9);

                clientSettingsBuilder_tMongoDBInput_9.applyToClusterSettings(builder -> builder.applySettings(clusterSettingsBuilder_tMongoDBInput_9.build()));



        mongo_tMongoDBInput_9 = com.mongodb.client.MongoClients.create(clientSettingsBuilder_tMongoDBInput_9.build());
        db_tMongoDBInput_9 = mongo_tMongoDBInput_9.getDatabase(context.mongo_database);


				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_9 = db_tMongoDBInput_9.getCollection(context.mongo_team_details);
				
				
				
				try{
					// Add warning if an index is not in the query.
					boolean needIndexWarning = true;
					String indexList = "";
					java.lang.StringBuilder sb_tMongoDBInput_9 = new java.lang.StringBuilder();
	                
	                    for (com.mongodb.DBObject index: coll_tMongoDBInput_9.listIndexes(com.mongodb.DBObject.class)) {
	                 
	                        for (String key: ((com.mongodb.DBObject)index.get("key")).keySet()) {
	                            // The regexp is:
	                            // - contain the db DBcolumnName between two backslashed quotes
	                            // - is followed at some point by a colon
	                            // - there is no comma between the the DBcolumnName and the colon
	                            if  (("{}").matches(".*" + key.replace("*","\\*") + "[^,]*:.*")) {
	                                // We have an index, do not print error message
	                                needIndexWarning = false;
	                            } else {
	                                // This index is not in the query, add it into the indexList
	                                sb_tMongoDBInput_9.append(", ").append(key);
	                            }
	                        }
	                        indexList = sb_tMongoDBInput_9.toString();
	                    }
	                if ((!"".equals(indexList)) && (needIndexWarning)) {
	                    
	                        System.err.println("tMongoDBInput_9 - The query does not contain any reference an index.  [" + indexList.substring(1) + " ]");
	                        
	                }
	            }catch(com.mongodb.MongoException e){
	            	// caught an exception after issuing the getIndexInfo()
	            	// don't fail the whole job
	            	// maybe due to authorization
	            }

						org.bson.Document myQuery_tMongoDBInput_9 = org.bson.Document.parse("{}");
						
							com.mongodb.client.FindIterable<org.bson.Document> findIterable_tMongoDBInput_9 = coll_tMongoDBInput_9.find(myQuery_tMongoDBInput_9).noCursorTimeout(false);
							


				
				class DBObjectInputUtil_tMongoDBInput_9{
					// Get the node value in embedded document, 
					//If have no embedded document get root document node.
					
					public Object getValue(String parentNode,String currentName,org.bson.Document dbObject){
						Object value=null;
						if(dbObject==null){
							return null;
						}
						if (parentNode == null || "".equals(parentNode)) {
						    if ("*".equals(currentName)) {
						        value = dbObject;
						    } else if (dbObject.get(currentName)!=null){
								value=dbObject.get(currentName);
							}
						}else{
							String objNames[] = parentNode.split("\\.");
							org.bson.Document currentObj=dbObject;
							for(int i=0;i<objNames.length;i++){
								currentObj=(org.bson.Document)currentObj.get(objNames[i]);
								if(currentObj==null){
									break;
								}
							}
							if ("*".equals(currentName)) {
                                value = currentObj;
                            } else if(currentObj!=null){
								value=currentObj.get(currentName);
							}
						}
						
						    if(value instanceof org.bson.Document){
						        value = ((org.bson.Document)value).toJson();
						    }else if (value instanceof java.util.List){

						    java.util.List list = new java.util.ArrayList();
						    ((java.util.List)value).stream().forEach(e -> {
						    if(e instanceof org.bson.Document){
						        list.add(((org.bson.Document)e).toJson());
						    }else{
						        list.add(e);
						    }
						    });
						    value = list;
						    }

						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_9 dbObjectInputUtil_tMongoDBInput_9=new DBObjectInputUtil_tMongoDBInput_9();
				java.util.Map<String, String> pathMap_tMongoDBInput_9=new java.util.HashMap<>();
				pathMap_tMongoDBInput_9.put("club_id","");
				pathMap_tMongoDBInput_9.put("club_slug","");
				pathMap_tMongoDBInput_9.put("club_name","");
				pathMap_tMongoDBInput_9.put("logo_url","");
				pathMap_tMongoDBInput_9.put("country_name","");
				pathMap_tMongoDBInput_9.put("competition_id","");
				pathMap_tMongoDBInput_9.put("competition_slug","");
				pathMap_tMongoDBInput_9.put("competition_name","");
				pathMap_tMongoDBInput_9.put("club_division","");
				pathMap_tMongoDBInput_9.put("source_url","");
				pathMap_tMongoDBInput_9.put("_last_modified_at","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_9 = findIterable_tMongoDBInput_9.iterator();
						
				while (cursor_tMongoDBInput_9.hasNext()){
				org.bson.Document o_tMongoDBInput_9 = cursor_tMongoDBInput_9.next();
				nb_line_tMongoDBInput_9++;
				Object valueObj_tMongoDBInput_9=null;
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("club_id"),"club_id",o_tMongoDBInput_9);
					
				row11.club_id = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("club_slug"),"club_slug",o_tMongoDBInput_9);
					
				row11.club_slug = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("club_name"),"club_name",o_tMongoDBInput_9);
					
				row11.club_name = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("logo_url"),"logo_url",o_tMongoDBInput_9);
					
				row11.logo_url = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("country_name"),"country_name",o_tMongoDBInput_9);
					
				row11.country_name = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("competition_id"),"competition_id",o_tMongoDBInput_9);
					
				row11.competition_id = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("competition_slug"),"competition_slug",o_tMongoDBInput_9);
					
				row11.competition_slug = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("competition_name"),"competition_name",o_tMongoDBInput_9);
					
				row11.competition_name = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("club_division"),"club_division",o_tMongoDBInput_9);
					
				row11.club_division = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("source_url"),"source_url",o_tMongoDBInput_9);
					
				row11.source_url = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				
                    valueObj_tMongoDBInput_9=dbObjectInputUtil_tMongoDBInput_9.getValue(pathMap_tMongoDBInput_9.get("_last_modified_at"),"_last_modified_at",o_tMongoDBInput_9);
					
				row11._last_modified_at = valueObj_tMongoDBInput_9==null ? null : valueObj_tMongoDBInput_9.toString();
				


 



/**
 * [tMongoDBInput_9 begin ] stop
 */
	
	/**
	 * [tMongoDBInput_9 main ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_9";

	

 


	tos_count_tMongoDBInput_9++;

/**
 * [tMongoDBInput_9 main ] stop
 */
	
	/**
	 * [tMongoDBInput_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_9";

	

 



/**
 * [tMongoDBInput_9 process_data_begin ] stop
 */

	
	/**
	 * [tMap_9 main ] start
	 */

	

	
	
	currentComponent="tMap_9";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row11"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_9 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_9 = false;
		  boolean mainRowRejected_tMap_9 = false;
            				    								  
		// ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_9__Struct Var = Var__tMap_9;
Var.var1 = row11.club_name == null || row11.club_name.trim().isEmpty() ? "" :
row11.club_name.replaceAll("\\s*\\(\\d+\\)\\s*$", "").trim();
Var.country_region = row11.country_name == null ? "Inconnu" :
(row11.country_name.equals("Germany") || row11.country_name.equals("France") ||
 row11.country_name.equals("England") || row11.country_name.equals("Italy") ||
 row11.country_name.equals("Spain") || row11.country_name.equals("Portugal")) ? "Europe Top 5" :
(row11.country_name.equals("Brazil") || row11.country_name.equals("Argentina") ||
 row11.country_name.equals("Mexico")) ? "Amérique Latine" :
(row11.country_name.equals("United States")) ? "Amérique du Nord" :
(row11.country_name.equals("Japan") || row11.country_name.equals("China")) ? "Asie" : "Autre";// ###############################
        // ###############################
        // # Output tables

team_detail = null;


// # Output table : 'team_detail'
team_detail_tmp.club_id = row11.club_id ;
team_detail_tmp.club_name = Var.var1 ;
team_detail_tmp.country_region = Var.country_region ;
team_detail = team_detail_tmp;
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_9 = false;










 


	tos_count_tMap_9++;

/**
 * [tMap_9 main ] stop
 */
	
	/**
	 * [tMap_9 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_9";

	

 



/**
 * [tMap_9 process_data_begin ] stop
 */
// Start of branch "team_detail"
if(team_detail != null) { 



	
	/**
	 * [tMongoDBOutput_7 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_7";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"team_detail"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_7.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_7.put(pathMap_tMongoDBOutput_7.get("club_id"),"club_id", team_detail.club_id);
                                        updateObjectUtil_tMongoDBOutput_7.put(pathMap_tMongoDBOutput_7.get("club_name"),"club_name", team_detail.club_name);
                                        updateObjectUtil_tMongoDBOutput_7.put(pathMap_tMongoDBOutput_7.get("country_region"),"country_region", team_detail.country_region);
				org.bson.Document updateObj_tMongoDBOutput_7 = updateObjectUtil_tMongoDBOutput_7.getObject();
				
						coll_tMongoDBOutput_7.insertOne(updateObj_tMongoDBOutput_7);
					
				} catch (Exception e_tMongoDBOutput_7) {
				
    					
    						System.err.println(e_tMongoDBOutput_7.getMessage());
    					
    			}
				nb_line_tMongoDBOutput_7 ++;
				
 


	tos_count_tMongoDBOutput_7++;

/**
 * [tMongoDBOutput_7 main ] stop
 */
	
	/**
	 * [tMongoDBOutput_7 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_7";

	

 



/**
 * [tMongoDBOutput_7 process_data_begin ] stop
 */
	
	/**
	 * [tMongoDBOutput_7 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_7";

	

 



/**
 * [tMongoDBOutput_7 process_data_end ] stop
 */

} // End of branch "team_detail"




	
	/**
	 * [tMap_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_9";

	

 



/**
 * [tMap_9 process_data_end ] stop
 */



	
	/**
	 * [tMongoDBInput_9 process_data_end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_9";

	

 



/**
 * [tMongoDBInput_9 process_data_end ] stop
 */
	
	/**
	 * [tMongoDBInput_9 end ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_9";

	

            }
                    if(mongo_tMongoDBInput_9 != null) {
                        mongo_tMongoDBInput_9.close();
                    }
    globalMap.put("tMongoDBInput_9_NB_LINE", nb_line_tMongoDBInput_9);
 

ok_Hash.put("tMongoDBInput_9", true);
end_Hash.put("tMongoDBInput_9", System.currentTimeMillis());




/**
 * [tMongoDBInput_9 end ] stop
 */

	
	/**
	 * [tMap_9 end ] start
	 */

	

	
	
	currentComponent="tMap_9";

	


// ###############################
// # Lookup hashes releasing
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row11");
			  	}
			  	
 

ok_Hash.put("tMap_9", true);
end_Hash.put("tMap_9", System.currentTimeMillis());




/**
 * [tMap_9 end ] stop
 */

	
	/**
	 * [tMongoDBOutput_7 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_7";

	

		if(mongo_tMongoDBOutput_7 != null){
			
				mongo_tMongoDBOutput_7.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_7", true); 
		
	globalMap.put("tMongoDBOutput_7_NB_LINE", nb_line_tMongoDBOutput_7);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"team_detail");
			  	}
			  	
 

ok_Hash.put("tMongoDBOutput_7", true);
end_Hash.put("tMongoDBOutput_7", System.currentTimeMillis());




/**
 * [tMongoDBOutput_7 end ] stop
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
	 * [tMongoDBInput_9 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_9";

	

 



/**
 * [tMongoDBInput_9 finally ] stop
 */

	
	/**
	 * [tMap_9 finally ] start
	 */

	

	
	
	currentComponent="tMap_9";

	

 



/**
 * [tMap_9 finally ] stop
 */

	
	/**
	 * [tMongoDBOutput_7 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_7";

	
		if(resourceMap.get("finish_tMongoDBOutput_7") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_7") != null){

		    
		    			
		    			       ((com.mongodb.client.MongoClient)resourceMap.get("mongo_tMongoDBOutput_7")).close();
		    
		    
			
			}
		}

 



/**
 * [tMongoDBOutput_7 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tMongoDBInput_9_SUBPROCESS_STATE", 1);
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
        final bronzetosilver bronzetosilverClass = new bronzetosilver();

        int exitCode = bronzetosilverClass.runJobInTOS(args);

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
            java.io.InputStream inContext = bronzetosilver.class.getClassLoader().getResourceAsStream("local_project/bronzetosilver_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = bronzetosilver.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
                        context.setContextType("mongo_server", "id_String");
                        if(context.getStringValue("mongo_server") == null) {
                            context.mongo_server = null;
                        } else {
                            context.mongo_server=(String) context.getProperty("mongo_server");
                        }
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
                        context.setContextType("mongo_kpia", "id_String");
                        if(context.getStringValue("mongo_kpia") == null) {
                            context.mongo_kpia = null;
                        } else {
                            context.mongo_kpia=(String) context.getProperty("mongo_kpia");
                        }
                        context.setContextType("mongo_player_injuries", "id_String");
                        if(context.getStringValue("mongo_player_injuries") == null) {
                            context.mongo_player_injuries = null;
                        } else {
                            context.mongo_player_injuries=(String) context.getProperty("mongo_player_injuries");
                        }
                        context.setContextType("mongo_player_injuries_modifie", "id_String");
                        if(context.getStringValue("mongo_player_injuries_modifie") == null) {
                            context.mongo_player_injuries_modifie = null;
                        } else {
                            context.mongo_player_injuries_modifie=(String) context.getProperty("mongo_player_injuries_modifie");
                        }
                        context.setContextType("mongo_player_latest_market_value", "id_String");
                        if(context.getStringValue("mongo_player_latest_market_value") == null) {
                            context.mongo_player_latest_market_value = null;
                        } else {
                            context.mongo_player_latest_market_value=(String) context.getProperty("mongo_player_latest_market_value");
                        }
                        context.setContextType("mongo_player_latest_market_value_modifie", "id_String");
                        if(context.getStringValue("mongo_player_latest_market_value_modifie") == null) {
                            context.mongo_player_latest_market_value_modifie = null;
                        } else {
                            context.mongo_player_latest_market_value_modifie=(String) context.getProperty("mongo_player_latest_market_value_modifie");
                        }
                        context.setContextType("mongo_player_performances", "id_String");
                        if(context.getStringValue("mongo_player_performances") == null) {
                            context.mongo_player_performances = null;
                        } else {
                            context.mongo_player_performances=(String) context.getProperty("mongo_player_performances");
                        }
                        context.setContextType("mongo_player_performances_modifie", "id_String");
                        if(context.getStringValue("mongo_player_performances_modifie") == null) {
                            context.mongo_player_performances_modifie = null;
                        } else {
                            context.mongo_player_performances_modifie=(String) context.getProperty("mongo_player_performances_modifie");
                        }
                        context.setContextType("mongo_player_profiles", "id_String");
                        if(context.getStringValue("mongo_player_profiles") == null) {
                            context.mongo_player_profiles = null;
                        } else {
                            context.mongo_player_profiles=(String) context.getProperty("mongo_player_profiles");
                        }
                        context.setContextType("mongo_player_profiles_modifie", "id_String");
                        if(context.getStringValue("mongo_player_profiles_modifie") == null) {
                            context.mongo_player_profiles_modifie = null;
                        } else {
                            context.mongo_player_profiles_modifie=(String) context.getProperty("mongo_player_profiles_modifie");
                        }
                        context.setContextType("mongo_port", "id_String");
                        if(context.getStringValue("mongo_port") == null) {
                            context.mongo_port = null;
                        } else {
                            context.mongo_port=(String) context.getProperty("mongo_port");
                        }
                        context.setContextType("mongo_team_details", "id_String");
                        if(context.getStringValue("mongo_team_details") == null) {
                            context.mongo_team_details = null;
                        } else {
                            context.mongo_team_details=(String) context.getProperty("mongo_team_details");
                        }
                        context.setContextType("mongo_team_details_modifie", "id_String");
                        if(context.getStringValue("mongo_team_details_modifie") == null) {
                            context.mongo_team_details_modifie = null;
                        } else {
                            context.mongo_team_details_modifie=(String) context.getProperty("mongo_team_details_modifie");
                        }
                        context.setContextType("mongo_transfer_history", "id_String");
                        if(context.getStringValue("mongo_transfer_history") == null) {
                            context.mongo_transfer_history = null;
                        } else {
                            context.mongo_transfer_history=(String) context.getProperty("mongo_transfer_history");
                        }
                        context.setContextType("mongo_transfer_history_modifie", "id_String");
                        if(context.getStringValue("mongo_transfer_history_modifie") == null) {
                            context.mongo_transfer_history_modifie = null;
                        } else {
                            context.mongo_transfer_history_modifie=(String) context.getProperty("mongo_transfer_history_modifie");
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
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("mongo_server")) {
                context.mongo_server = (String) parentContextMap.get("mongo_server");
            }if (parentContextMap.containsKey("mongo_collection_bronze")) {
                context.mongo_collection_bronze = (String) parentContextMap.get("mongo_collection_bronze");
            }if (parentContextMap.containsKey("mongo_collection_silver")) {
                context.mongo_collection_silver = (String) parentContextMap.get("mongo_collection_silver");
            }if (parentContextMap.containsKey("mongo_database")) {
                context.mongo_database = (String) parentContextMap.get("mongo_database");
            }if (parentContextMap.containsKey("mongo_kpia")) {
                context.mongo_kpia = (String) parentContextMap.get("mongo_kpia");
            }if (parentContextMap.containsKey("mongo_player_injuries")) {
                context.mongo_player_injuries = (String) parentContextMap.get("mongo_player_injuries");
            }if (parentContextMap.containsKey("mongo_player_injuries_modifie")) {
                context.mongo_player_injuries_modifie = (String) parentContextMap.get("mongo_player_injuries_modifie");
            }if (parentContextMap.containsKey("mongo_player_latest_market_value")) {
                context.mongo_player_latest_market_value = (String) parentContextMap.get("mongo_player_latest_market_value");
            }if (parentContextMap.containsKey("mongo_player_latest_market_value_modifie")) {
                context.mongo_player_latest_market_value_modifie = (String) parentContextMap.get("mongo_player_latest_market_value_modifie");
            }if (parentContextMap.containsKey("mongo_player_performances")) {
                context.mongo_player_performances = (String) parentContextMap.get("mongo_player_performances");
            }if (parentContextMap.containsKey("mongo_player_performances_modifie")) {
                context.mongo_player_performances_modifie = (String) parentContextMap.get("mongo_player_performances_modifie");
            }if (parentContextMap.containsKey("mongo_player_profiles")) {
                context.mongo_player_profiles = (String) parentContextMap.get("mongo_player_profiles");
            }if (parentContextMap.containsKey("mongo_player_profiles_modifie")) {
                context.mongo_player_profiles_modifie = (String) parentContextMap.get("mongo_player_profiles_modifie");
            }if (parentContextMap.containsKey("mongo_port")) {
                context.mongo_port = (String) parentContextMap.get("mongo_port");
            }if (parentContextMap.containsKey("mongo_team_details")) {
                context.mongo_team_details = (String) parentContextMap.get("mongo_team_details");
            }if (parentContextMap.containsKey("mongo_team_details_modifie")) {
                context.mongo_team_details_modifie = (String) parentContextMap.get("mongo_team_details_modifie");
            }if (parentContextMap.containsKey("mongo_transfer_history")) {
                context.mongo_transfer_history = (String) parentContextMap.get("mongo_transfer_history");
            }if (parentContextMap.containsKey("mongo_transfer_history_modifie")) {
                context.mongo_transfer_history_modifie = (String) parentContextMap.get("mongo_transfer_history_modifie");
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
errorCode = null;tMongoDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_1) {
globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", -1);

e_tMongoDBInput_1.printStackTrace();

}
try {
errorCode = null;tMongoDBInput_4Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_4) {
globalMap.put("tMongoDBInput_4_SUBPROCESS_STATE", -1);

e_tMongoDBInput_4.printStackTrace();

}
try {
errorCode = null;tMongoDBInput_6Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_6) {
globalMap.put("tMongoDBInput_6_SUBPROCESS_STATE", -1);

e_tMongoDBInput_6.printStackTrace();

}
try {
errorCode = null;tMongoDBInput_2Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_2) {
globalMap.put("tMongoDBInput_2_SUBPROCESS_STATE", -1);

e_tMongoDBInput_2.printStackTrace();

}
try {
errorCode = null;tMongoDBInput_5Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_5) {
globalMap.put("tMongoDBInput_5_SUBPROCESS_STATE", -1);

e_tMongoDBInput_5.printStackTrace();

}
try {
errorCode = null;tMongoDBInput_8Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_8) {
globalMap.put("tMongoDBInput_8_SUBPROCESS_STATE", -1);

e_tMongoDBInput_8.printStackTrace();

}
try {
errorCode = null;tMongoDBInput_9Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_9) {
globalMap.put("tMongoDBInput_9_SUBPROCESS_STATE", -1);

e_tMongoDBInput_9.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : bronzetosilver");
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
 *     621009 characters generated by Talend Open Studio for Big Data 
 *     on the 26 février 2026 à 00:08:34 CET
 ************************************************************************************************/