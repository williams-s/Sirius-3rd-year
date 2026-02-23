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
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class sortieeStruct implements routines.system.IPersistableRow<sortieeStruct> {
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
				
			    public String date_unix;

				public String getDate_unix () {
					return this.date_unix;
				}
				
			    public String value;

				public String getValue () {
					return this.value;
				}
				
			    public String team_id;

				public String getTeam_id () {
					return this.team_id;
				}
				
			    public String goals;

				public String getGoals () {
					return this.goals;
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
					
					this.season_name = readString(dis);
					
					this.date_unix = readString(dis);
					
					this.value = readString(dis);
					
					this.team_id = readString(dis);
					
					this.goals = readString(dis);
					
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
					
					this.date_unix = readString(dis);
					
					this.value = readString(dis);
					
					this.team_id = readString(dis);
					
					this.goals = readString(dis);
					
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
				
						writeString(this.date_unix,dos);
					
					// String
				
						writeString(this.value,dos);
					
					// String
				
						writeString(this.team_id,dos);
					
					// String
				
						writeString(this.goals,dos);
					
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
				
						writeString(this.date_unix,dos);
					
					// String
				
						writeString(this.value,dos);
					
					// String
				
						writeString(this.team_id,dos);
					
					// String
				
						writeString(this.goals,dos);
					
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
		sb.append(",date_unix="+date_unix);
		sb.append(",value="+value);
		sb.append(",team_id="+team_id);
		sb.append(",goals="+goals);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(sortieeStruct other) {

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
				
			    public Integer days_missed;

				public Integer getDays_missed () {
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
					
						this.days_missed = readInteger(dis);
					
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
					
						this.days_missed = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.days_missed,dos);
					
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
					
					// Integer
				
						writeInteger(this.days_missed,dos);
					
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
		sb.append(",days_missed="+String.valueOf(days_missed));
		sb.append(",games_missed="+String.valueOf(games_missed));
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

public static class OnRowsEndStructtAggregateRow_1 implements routines.system.IPersistableRow<OnRowsEndStructtAggregateRow_1> {
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
				
			    public Integer days_missed;

				public Integer getDays_missed () {
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
					
						this.days_missed = readInteger(dis);
					
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
					
						this.days_missed = readInteger(dis);
					
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
					
					// Integer
				
						writeInteger(this.days_missed,dos);
					
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
					
					// Integer
				
						writeInteger(this.days_missed,dos);
					
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
		sb.append(",days_missed="+String.valueOf(days_missed));
		sb.append(",games_missed="+String.valueOf(games_missed));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(OnRowsEndStructtAggregateRow_1 other) {

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

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
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

public static class after_tMongoDBInput_1Struct implements routines.system.IPersistableRow<after_tMongoDBInput_1Struct> {
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
    public int compareTo(after_tMongoDBInput_1Struct other) {

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


		tMongoDBInput_2Process(globalMap);
		tMongoDBInput_3Process(globalMap);

		row1Struct row1 = new row1Struct();
row2Struct row2 = new row2Struct();
sortieeStruct sortiee = new sortieeStruct();




	
	/**
	 * [tAggregateRow_1_AGGOUT begin ] start
	 */

	

	
		
		ok_Hash.put("tAggregateRow_1_AGGOUT", false);
		start_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
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

	
	
		class AggCountDistinctValuesStruct_player_id_tAggregateRow_1 { // G_OutBegin_AggR_1100
	
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
				final AggCountDistinctValuesStruct_player_id_tAggregateRow_1 other = (AggCountDistinctValuesStruct_player_id_tAggregateRow_1) obj;
				
									if (this.player_id == null) {
										if (other.player_id != null) 
											return false;
									} else if (!this.player_id.equals(other.player_id)) 
										return false;
								
				
				return true;
			}
	  
	        
		} // G_OutBegin_AggR_1100

	

	class AggOperationStruct_tAggregateRow_1 { // G_OutBegin_AggR_100

		private static final int DEFAULT_HASHCODE = 1;
	    private static final int PRIME = 31;
	    private int hashCode = DEFAULT_HASHCODE;
	    public boolean hashCodeDirty = true;

    				String player_id;java.util.Set<AggCountDistinctValuesStruct_player_id_tAggregateRow_1> distinctValues_player_id = new java.util.HashSet<AggCountDistinctValuesStruct_player_id_tAggregateRow_1>();
           			
        
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

	System.err.println(
	
		"Warning:the operation 'distinct' for the output column 'player_id' can't be processed because of incompatible input and/or output types"
	);
	
	AggOperationStruct_tAggregateRow_1 operation_result_tAggregateRow_1 = null;
	AggOperationStruct_tAggregateRow_1 operation_finder_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();
	java.util.Map<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1> hash_tAggregateRow_1 = new java.util.HashMap<AggOperationStruct_tAggregateRow_1,AggOperationStruct_tAggregateRow_1>();
	

 



/**
 * [tAggregateRow_1_AGGOUT begin ] stop
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
	 * [tAggregateRow_1_AGGOUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					
	
operation_finder_tAggregateRow_1.player_id = row1.player_id;
			

	operation_finder_tAggregateRow_1.hashCodeDirty = true;
	
	operation_result_tAggregateRow_1 = hash_tAggregateRow_1.get(operation_finder_tAggregateRow_1);

	

	if(operation_result_tAggregateRow_1 == null) { // G_OutMain_AggR_001

		operation_result_tAggregateRow_1 = new AggOperationStruct_tAggregateRow_1();

		operation_result_tAggregateRow_1.player_id = operation_finder_tAggregateRow_1.player_id;
				
		
		

		hash_tAggregateRow_1.put(operation_result_tAggregateRow_1, operation_result_tAggregateRow_1);
	
	} // G_OutMain_AggR_001


	


 


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
	 * [tAggregateRow_1_AGGOUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tAggregateRow_1";
	
	currentComponent="tAggregateRow_1_AGGOUT";

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tAggregateRow_1_AGGOUT", true);
end_Hash.put("tAggregateRow_1_AGGOUT", System.currentTimeMillis());




/**
 * [tAggregateRow_1_AGGOUT end ] stop
 */



	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"sortiee");
					}
				
		int tos_count_tLogRow_1 = 0;
		

	///////////////////////
	
		final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
		java.io.PrintStream consoleOut_tLogRow_1 = null;	

 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tMap_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_2", false);
		start_Hash.put("tMap_2", System.currentTimeMillis());
		
	
	currentComponent="tMap_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tMap_2 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct>) 
					globalMap.get( "tHash_Lookup_row3" ))
					;					
					
	

row3Struct row3HashKey = new row3Struct();
row3Struct row3Default = new row3Struct();
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct>) 
					globalMap.get( "tHash_Lookup_row4" ))
					;					
					
	

row4Struct row4HashKey = new row4Struct();
row4Struct row4Default = new row4Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_2__Struct  {
}
Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
sortieeStruct sortiee_tmp = new sortieeStruct();
// ###############################

        
        



        









 



/**
 * [tMap_2 begin ] stop
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

	

            				    row2.player_id = aggregated_row_tAggregateRow_1.player_id;
            				    

 


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
	 * [tMap_2 main ] start
	 */

	

	
	
	currentComponent="tMap_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_2 = false;
		  boolean mainRowRejected_tMap_2 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row3" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow3 = false;
       		  	    	
       		  	    	
 							row3Struct row3ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    row3HashKey.player_id = row2.player_id ;
                        		    		

								
		                        	row3HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row3.lookup( row3HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row3.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



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
							
							
							
			  							
								
	                    		  	
		                    
	            	
	           	
	            	
	            	
	            

				///////////////////////////////////////////////
				// Starting Lookup Table "row4" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow4 = false;
       		  	    	
       		  	    	
 							row4Struct row4ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_2) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_2 = false;
								
                        		    		    row4HashKey.player_id = row2.player_id ;
                        		    		

								
		                        	row4HashKey.hashCodeDirty = true;
                        		
	  					
	  							
			  					
			  					
	  					
		  							tHash_Lookup_row4.lookup( row4HashKey );

	  							

	  							

 								
								  
								  if(!tHash_Lookup_row4.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_2 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row4 != null && tHash_Lookup_row4.getCount(row4HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row4' and it contains more one result from keys :  row4.player_id = '" + row4HashKey.player_id + "'");
								} // G 071
							

							row4Struct row4 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row4Struct fromLookup_row4 = null;
							row4 = row4Default;
										 
							
								 
							
							
								if (tHash_Lookup_row4 !=null && tHash_Lookup_row4.hasNext()) { // G 099
								
							
								
								fromLookup_row4 = tHash_Lookup_row4.next();

							
							
								} // G 099
							
							

							if(fromLookup_row4 != null) {
								row4 = fromLookup_row4;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_2__Struct Var = Var__tMap_2;// ###############################
        // ###############################
        // # Output tables

sortiee = null;

if(!rejectedInnerJoin_tMap_2 ) {

// # Output table : 'sortiee'
sortiee_tmp.player_id = row2.player_id ;
sortiee_tmp.season_name = row2.season_name ;
sortiee_tmp.date_unix = row3.date_unix ;
sortiee_tmp.value = row3.value ;
sortiee_tmp.team_id = row4.team_id ;
sortiee_tmp.goals = row4.goals ;
sortiee = sortiee_tmp;
}  // closing inner join bracket (2)
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
// Start of branch "sortiee"
if(sortiee != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"sortiee"
						
						);
					}
					
///////////////////////		
						



				strBuffer_tLogRow_1 = new StringBuilder();




   				
	    		if(sortiee.player_id != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(sortiee.player_id)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(sortiee.season_name != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(sortiee.season_name)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(sortiee.date_unix != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(sortiee.date_unix)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(sortiee.value != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(sortiee.value)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(sortiee.team_id != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(sortiee.team_id)							
				);


							
	    		} //  			

    			strBuffer_tLogRow_1.append("|");
    			


   				
	    		if(sortiee.goals != null) { //              
                    							
       
				strBuffer_tLogRow_1.append(
				                String.valueOf(sortiee.goals)							
				);


							
	    		} //  			
 

                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
                    consoleOut_tLogRow_1.flush();
                    nb_line_tLogRow_1++;
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */

} // End of branch "sortiee"




	
	/**
	 * [tMap_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 process_data_end ] stop
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
	 * [tMap_2 end ] start
	 */

	

	
	
	currentComponent="tMap_2";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row3 != null) {
						tHash_Lookup_row3.endGet();
					}
					globalMap.remove( "tHash_Lookup_row3" );

					
					
				
					if(tHash_Lookup_row4 != null) {
						tHash_Lookup_row4.endGet();
					}
					globalMap.remove( "tHash_Lookup_row4" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tMap_2", true);
end_Hash.put("tMap_2", System.currentTimeMillis());




/**
 * [tMap_2 end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"sortiee");
			  	}
			  	
 

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
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
					     			globalMap.remove("tHash_Lookup_row4"); 
				     			
							//free memory for "tAggregateRow_1_AGGIN"
							globalMap.remove("tAggregateRow_1");
						
				try{
					
	
	/**
	 * [tMongoDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 finally ] stop
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
	 * [tMap_2 finally ] start
	 */

	

	
	
	currentComponent="tMap_2";

	

 



/**
 * [tMap_2 finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
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
				
			    public String date_unix;

				public String getDate_unix () {
					return this.date_unix;
				}
				
			    public String value;

				public String getValue () {
					return this.value;
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
	            other.date_unix = this.date_unix;
	            other.value = this.value;
	            
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
		
						this.date_unix = readString(dis,ois);
					
						this.value = readString(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.date_unix = readString(dis,objectIn);
					
						this.value = readString(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeString(this.date_unix, dos, oos);
					
						writeString(this.value, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeString(this.date_unix, dos, objectOut);
					
						writeString(this.value, dos, objectOut);
					
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
		sb.append(",date_unix="+date_unix);
		sb.append(",value="+value);
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
			   		// source node:tMongoDBInput_2 - inputs:(after_tMongoDBInput_1) outputs:(row3,row3) | target node:tAdvancedHash_row3 - inputs:(row3) outputs:()
			   		// linked node: tMap_2 - inputs:(row2,row3,row4) outputs:(sortiee)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row3 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row3Struct> tHash_Lookup_row3 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row3Struct>getLookup(matchingModeEnum_row3);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row3", tHash_Lookup_row3);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row3 begin ] stop
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
					
				row3.player_id = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("date_unix"),"date_unix",o_tMongoDBInput_2);
					
				row3.date_unix = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				
                    valueObj_tMongoDBInput_2=dbObjectInputUtil_tMongoDBInput_2.getValue(pathMap_tMongoDBInput_2.get("value"),"value",o_tMongoDBInput_2);
					
				row3.value = valueObj_tMongoDBInput_2==null ? null : valueObj_tMongoDBInput_2.toString();
				


 



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
				
				row3_HashRow.date_unix = row3.date_unix;
				
				row3_HashRow.value = row3.value;
				
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
	 * [tMongoDBInput_2 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_2";

	

 



/**
 * [tMongoDBInput_2 finally ] stop
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
		

		globalMap.put("tMongoDBInput_2_SUBPROCESS_STATE", 1);
	}
	


public static class row4Struct implements routines.system.IPersistableComparableLookupRow<row4Struct> {
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
		
						this.season_name = readString(dis,ois);
					
						this.competition_id = readString(dis,ois);
					
						this.competition_name = readString(dis,ois);
					
						this.team_id = readString(dis,ois);
					
						this.team_name = readString(dis,ois);
					
						this.nb_in_group = readString(dis,ois);
					
						this.nb_on_pitch = readString(dis,ois);
					
						this.goals = readString(dis,ois);
					
						this.assists = readString(dis,ois);
					
						this.own_goals = readString(dis,ois);
					
						this.subed_in = readString(dis,ois);
					
						this.subed_out = readString(dis,ois);
					
						this.yellow_cards = readString(dis,ois);
					
						this.second_yellow_cards = readString(dis,ois);
					
						this.direct_red_cards = readString(dis,ois);
					
						this.penalty_goals = readString(dis,ois);
					
						this.minutes_played = readString(dis,ois);
					
						this.goals_conceded = readString(dis,ois);
					
						this.clean_sheets = readString(dis,ois);
					
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
					
						this.goals = readString(dis,objectIn);
					
						this.assists = readString(dis,objectIn);
					
						this.own_goals = readString(dis,objectIn);
					
						this.subed_in = readString(dis,objectIn);
					
						this.subed_out = readString(dis,objectIn);
					
						this.yellow_cards = readString(dis,objectIn);
					
						this.second_yellow_cards = readString(dis,objectIn);
					
						this.direct_red_cards = readString(dis,objectIn);
					
						this.penalty_goals = readString(dis,objectIn);
					
						this.minutes_played = readString(dis,objectIn);
					
						this.goals_conceded = readString(dis,objectIn);
					
						this.clean_sheets = readString(dis,objectIn);
					
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
					
						writeString(this.goals, dos, oos);
					
						writeString(this.assists, dos, oos);
					
						writeString(this.own_goals, dos, oos);
					
						writeString(this.subed_in, dos, oos);
					
						writeString(this.subed_out, dos, oos);
					
						writeString(this.yellow_cards, dos, oos);
					
						writeString(this.second_yellow_cards, dos, oos);
					
						writeString(this.direct_red_cards, dos, oos);
					
						writeString(this.penalty_goals, dos, oos);
					
						writeString(this.minutes_played, dos, oos);
					
						writeString(this.goals_conceded, dos, oos);
					
						writeString(this.clean_sheets, dos, oos);
					
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
					
						writeString(this.goals, dos, objectOut);
					
						writeString(this.assists, dos, objectOut);
					
						writeString(this.own_goals, dos, objectOut);
					
						writeString(this.subed_in, dos, objectOut);
					
						writeString(this.subed_out, dos, objectOut);
					
						writeString(this.yellow_cards, dos, objectOut);
					
						writeString(this.second_yellow_cards, dos, objectOut);
					
						writeString(this.direct_red_cards, dos, objectOut);
					
						writeString(this.penalty_goals, dos, objectOut);
					
						writeString(this.minutes_played, dos, objectOut);
					
						writeString(this.goals_conceded, dos, objectOut);
					
						writeString(this.clean_sheets, dos, objectOut);
					
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
	 * [tAdvancedHash_row4 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row4", false);
		start_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row4");
					}
				
		int tos_count_tAdvancedHash_row4 = 0;
		

			   		// connection name:row4
			   		// source node:tMongoDBInput_3 - inputs:(after_tMongoDBInput_1) outputs:(row4,row4) | target node:tAdvancedHash_row4 - inputs:(row4) outputs:()
			   		// linked node: tMap_2 - inputs:(row2,row3,row4) outputs:(sortiee)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row4 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row4Struct> tHash_Lookup_row4 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row4Struct>getLookup(matchingModeEnum_row4);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row4", tHash_Lookup_row4);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row4 begin ] stop
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
					
				row4.goals = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("assists"),"assists",o_tMongoDBInput_3);
					
				row4.assists = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("own_goals"),"own_goals",o_tMongoDBInput_3);
					
				row4.own_goals = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("subed_in"),"subed_in",o_tMongoDBInput_3);
					
				row4.subed_in = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("subed_out"),"subed_out",o_tMongoDBInput_3);
					
				row4.subed_out = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("yellow_cards"),"yellow_cards",o_tMongoDBInput_3);
					
				row4.yellow_cards = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("second_yellow_cards"),"second_yellow_cards",o_tMongoDBInput_3);
					
				row4.second_yellow_cards = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("direct_red_cards"),"direct_red_cards",o_tMongoDBInput_3);
					
				row4.direct_red_cards = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("penalty_goals"),"penalty_goals",o_tMongoDBInput_3);
					
				row4.penalty_goals = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("minutes_played"),"minutes_played",o_tMongoDBInput_3);
					
				row4.minutes_played = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("goals_conceded"),"goals_conceded",o_tMongoDBInput_3);
					
				row4.goals_conceded = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				
                    valueObj_tMongoDBInput_3=dbObjectInputUtil_tMongoDBInput_3.getValue(pathMap_tMongoDBInput_3.get("clean_sheets"),"clean_sheets",o_tMongoDBInput_3);
					
				row4.clean_sheets = valueObj_tMongoDBInput_3==null ? null : valueObj_tMongoDBInput_3.toString();
				


 



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
	 * [tAdvancedHash_row4 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row4"
						
						);
					}
					


			   
			   

					row4Struct row4_HashRow = new row4Struct();
		   	   	   
				
				row4_HashRow.player_id = row4.player_id;
				
				row4_HashRow.season_name = row4.season_name;
				
				row4_HashRow.competition_id = row4.competition_id;
				
				row4_HashRow.competition_name = row4.competition_name;
				
				row4_HashRow.team_id = row4.team_id;
				
				row4_HashRow.team_name = row4.team_name;
				
				row4_HashRow.nb_in_group = row4.nb_in_group;
				
				row4_HashRow.nb_on_pitch = row4.nb_on_pitch;
				
				row4_HashRow.goals = row4.goals;
				
				row4_HashRow.assists = row4.assists;
				
				row4_HashRow.own_goals = row4.own_goals;
				
				row4_HashRow.subed_in = row4.subed_in;
				
				row4_HashRow.subed_out = row4.subed_out;
				
				row4_HashRow.yellow_cards = row4.yellow_cards;
				
				row4_HashRow.second_yellow_cards = row4.second_yellow_cards;
				
				row4_HashRow.direct_red_cards = row4.direct_red_cards;
				
				row4_HashRow.penalty_goals = row4.penalty_goals;
				
				row4_HashRow.minutes_played = row4.minutes_played;
				
				row4_HashRow.goals_conceded = row4.goals_conceded;
				
				row4_HashRow.clean_sheets = row4.clean_sheets;
				
			tHash_Lookup_row4.put(row4_HashRow);
			
            




 


	tos_count_tAdvancedHash_row4++;

/**
 * [tAdvancedHash_row4 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row4 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 process_data_end ] stop
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
	 * [tAdvancedHash_row4 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

tHash_Lookup_row4.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row4");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row4", true);
end_Hash.put("tAdvancedHash_row4", System.currentTimeMillis());




/**
 * [tAdvancedHash_row4 end ] stop
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
	 * [tMongoDBInput_3 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_3";

	

 



/**
 * [tMongoDBInput_3 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row4 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row4";

	

 



/**
 * [tAdvancedHash_row4 finally ] stop
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
errorCode = null;tMongoDBInput_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tMongoDBInput_1) {
globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", -1);

e_tMongoDBInput_1.printStackTrace();

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
 *     188450 characters generated by Talend Open Studio for Big Data 
 *     on the 23 février 2026 à 02:51:34 CET
 ************************************************************************************************/