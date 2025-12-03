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


package local_project.players_0_1;

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
 * Job: Players Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class Players implements TalendJob {

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
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "Players";
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
				Players.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Players.this, new Object[] { e , currentComponent, globalMap});
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
			
			public void tFileInputDelimited_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_Players = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_Players = new byte[0];

	
			    public String name;

				public String getName () {
					return this.name;
				}
				
			    public String full_name;

				public String getFull_name () {
					return this.full_name;
				}
				
			    public String birth_date;

				public String getBirth_date () {
					return this.birth_date;
				}
				
			    public String age;

				public String getAge () {
					return this.age;
				}
				
			    public String height_cm;

				public String getHeight_cm () {
					return this.height_cm;
				}
				
			    public String weight_kgs;

				public String getWeight_kgs () {
					return this.weight_kgs;
				}
				
			    public String positions;

				public String getPositions () {
					return this.positions;
				}
				
			    public String nationality;

				public String getNationality () {
					return this.nationality;
				}
				
			    public String overall_rating;

				public String getOverall_rating () {
					return this.overall_rating;
				}
				
			    public String potential;

				public String getPotential () {
					return this.potential;
				}
				
			    public String value_euro;

				public String getValue_euro () {
					return this.value_euro;
				}
				
			    public String wage_euro;

				public String getWage_euro () {
					return this.wage_euro;
				}
				
			    public String preferred_foot;

				public String getPreferred_foot () {
					return this.preferred_foot;
				}
				
			    public String international_reputation;

				public String getInternational_reputation () {
					return this.international_reputation;
				}
				
			    public String weak_foot;

				public String getWeak_foot () {
					return this.weak_foot;
				}
				
			    public String skill_moves;

				public String getSkill_moves () {
					return this.skill_moves;
				}
				
			    public String body_type;

				public String getBody_type () {
					return this.body_type;
				}
				
			    public String release_clause_euro;

				public String getRelease_clause_euro () {
					return this.release_clause_euro;
				}
				
			    public String national_team;

				public String getNational_team () {
					return this.national_team;
				}
				
			    public String national_rating;

				public String getNational_rating () {
					return this.national_rating;
				}
				
			    public String national_team_position;

				public String getNational_team_position () {
					return this.national_team_position;
				}
				
			    public String national_jersey_number;

				public String getNational_jersey_number () {
					return this.national_jersey_number;
				}
				
			    public String crossing;

				public String getCrossing () {
					return this.crossing;
				}
				
			    public String finishing;

				public String getFinishing () {
					return this.finishing;
				}
				
			    public String heading_accuracy;

				public String getHeading_accuracy () {
					return this.heading_accuracy;
				}
				
			    public String short_passing;

				public String getShort_passing () {
					return this.short_passing;
				}
				
			    public String volleys;

				public String getVolleys () {
					return this.volleys;
				}
				
			    public String dribbling;

				public String getDribbling () {
					return this.dribbling;
				}
				
			    public String curve;

				public String getCurve () {
					return this.curve;
				}
				
			    public String freekick_accuracy;

				public String getFreekick_accuracy () {
					return this.freekick_accuracy;
				}
				
			    public String long_passing;

				public String getLong_passing () {
					return this.long_passing;
				}
				
			    public String ball_control;

				public String getBall_control () {
					return this.ball_control;
				}
				
			    public String acceleration;

				public String getAcceleration () {
					return this.acceleration;
				}
				
			    public String sprint_speed;

				public String getSprint_speed () {
					return this.sprint_speed;
				}
				
			    public String agility;

				public String getAgility () {
					return this.agility;
				}
				
			    public String reactions;

				public String getReactions () {
					return this.reactions;
				}
				
			    public String balance;

				public String getBalance () {
					return this.balance;
				}
				
			    public String shot_power;

				public String getShot_power () {
					return this.shot_power;
				}
				
			    public String jumping;

				public String getJumping () {
					return this.jumping;
				}
				
			    public String stamina;

				public String getStamina () {
					return this.stamina;
				}
				
			    public String strength;

				public String getStrength () {
					return this.strength;
				}
				
			    public String long_shots;

				public String getLong_shots () {
					return this.long_shots;
				}
				
			    public String aggression;

				public String getAggression () {
					return this.aggression;
				}
				
			    public String interceptions;

				public String getInterceptions () {
					return this.interceptions;
				}
				
			    public String positioning;

				public String getPositioning () {
					return this.positioning;
				}
				
			    public String vision;

				public String getVision () {
					return this.vision;
				}
				
			    public String penalties;

				public String getPenalties () {
					return this.penalties;
				}
				
			    public String composure;

				public String getComposure () {
					return this.composure;
				}
				
			    public String marking;

				public String getMarking () {
					return this.marking;
				}
				
			    public String standing_tackle;

				public String getStanding_tackle () {
					return this.standing_tackle;
				}
				
			    public String sliding_tackle;

				public String getSliding_tackle () {
					return this.sliding_tackle;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_LOCAL_PROJECT_Players.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_Players.length == 0) {
   					commonByteArray_LOCAL_PROJECT_Players = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_Players = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_LOCAL_PROJECT_Players, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_Players, 0, length, utf8Charset);
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
			if(length > commonByteArray_LOCAL_PROJECT_Players.length) {
				if(length < 1024 && commonByteArray_LOCAL_PROJECT_Players.length == 0) {
   					commonByteArray_LOCAL_PROJECT_Players = new byte[1024];
				} else {
   					commonByteArray_LOCAL_PROJECT_Players = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_LOCAL_PROJECT_Players, 0, length);
			strReturn = new String(commonByteArray_LOCAL_PROJECT_Players, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_Players) {

        	try {

        		int length = 0;
		
					this.name = readString(dis);
					
					this.full_name = readString(dis);
					
					this.birth_date = readString(dis);
					
					this.age = readString(dis);
					
					this.height_cm = readString(dis);
					
					this.weight_kgs = readString(dis);
					
					this.positions = readString(dis);
					
					this.nationality = readString(dis);
					
					this.overall_rating = readString(dis);
					
					this.potential = readString(dis);
					
					this.value_euro = readString(dis);
					
					this.wage_euro = readString(dis);
					
					this.preferred_foot = readString(dis);
					
					this.international_reputation = readString(dis);
					
					this.weak_foot = readString(dis);
					
					this.skill_moves = readString(dis);
					
					this.body_type = readString(dis);
					
					this.release_clause_euro = readString(dis);
					
					this.national_team = readString(dis);
					
					this.national_rating = readString(dis);
					
					this.national_team_position = readString(dis);
					
					this.national_jersey_number = readString(dis);
					
					this.crossing = readString(dis);
					
					this.finishing = readString(dis);
					
					this.heading_accuracy = readString(dis);
					
					this.short_passing = readString(dis);
					
					this.volleys = readString(dis);
					
					this.dribbling = readString(dis);
					
					this.curve = readString(dis);
					
					this.freekick_accuracy = readString(dis);
					
					this.long_passing = readString(dis);
					
					this.ball_control = readString(dis);
					
					this.acceleration = readString(dis);
					
					this.sprint_speed = readString(dis);
					
					this.agility = readString(dis);
					
					this.reactions = readString(dis);
					
					this.balance = readString(dis);
					
					this.shot_power = readString(dis);
					
					this.jumping = readString(dis);
					
					this.stamina = readString(dis);
					
					this.strength = readString(dis);
					
					this.long_shots = readString(dis);
					
					this.aggression = readString(dis);
					
					this.interceptions = readString(dis);
					
					this.positioning = readString(dis);
					
					this.vision = readString(dis);
					
					this.penalties = readString(dis);
					
					this.composure = readString(dis);
					
					this.marking = readString(dis);
					
					this.standing_tackle = readString(dis);
					
					this.sliding_tackle = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_Players) {

        	try {

        		int length = 0;
		
					this.name = readString(dis);
					
					this.full_name = readString(dis);
					
					this.birth_date = readString(dis);
					
					this.age = readString(dis);
					
					this.height_cm = readString(dis);
					
					this.weight_kgs = readString(dis);
					
					this.positions = readString(dis);
					
					this.nationality = readString(dis);
					
					this.overall_rating = readString(dis);
					
					this.potential = readString(dis);
					
					this.value_euro = readString(dis);
					
					this.wage_euro = readString(dis);
					
					this.preferred_foot = readString(dis);
					
					this.international_reputation = readString(dis);
					
					this.weak_foot = readString(dis);
					
					this.skill_moves = readString(dis);
					
					this.body_type = readString(dis);
					
					this.release_clause_euro = readString(dis);
					
					this.national_team = readString(dis);
					
					this.national_rating = readString(dis);
					
					this.national_team_position = readString(dis);
					
					this.national_jersey_number = readString(dis);
					
					this.crossing = readString(dis);
					
					this.finishing = readString(dis);
					
					this.heading_accuracy = readString(dis);
					
					this.short_passing = readString(dis);
					
					this.volleys = readString(dis);
					
					this.dribbling = readString(dis);
					
					this.curve = readString(dis);
					
					this.freekick_accuracy = readString(dis);
					
					this.long_passing = readString(dis);
					
					this.ball_control = readString(dis);
					
					this.acceleration = readString(dis);
					
					this.sprint_speed = readString(dis);
					
					this.agility = readString(dis);
					
					this.reactions = readString(dis);
					
					this.balance = readString(dis);
					
					this.shot_power = readString(dis);
					
					this.jumping = readString(dis);
					
					this.stamina = readString(dis);
					
					this.strength = readString(dis);
					
					this.long_shots = readString(dis);
					
					this.aggression = readString(dis);
					
					this.interceptions = readString(dis);
					
					this.positioning = readString(dis);
					
					this.vision = readString(dis);
					
					this.penalties = readString(dis);
					
					this.composure = readString(dis);
					
					this.marking = readString(dis);
					
					this.standing_tackle = readString(dis);
					
					this.sliding_tackle = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.name,dos);
					
					// String
				
						writeString(this.full_name,dos);
					
					// String
				
						writeString(this.birth_date,dos);
					
					// String
				
						writeString(this.age,dos);
					
					// String
				
						writeString(this.height_cm,dos);
					
					// String
				
						writeString(this.weight_kgs,dos);
					
					// String
				
						writeString(this.positions,dos);
					
					// String
				
						writeString(this.nationality,dos);
					
					// String
				
						writeString(this.overall_rating,dos);
					
					// String
				
						writeString(this.potential,dos);
					
					// String
				
						writeString(this.value_euro,dos);
					
					// String
				
						writeString(this.wage_euro,dos);
					
					// String
				
						writeString(this.preferred_foot,dos);
					
					// String
				
						writeString(this.international_reputation,dos);
					
					// String
				
						writeString(this.weak_foot,dos);
					
					// String
				
						writeString(this.skill_moves,dos);
					
					// String
				
						writeString(this.body_type,dos);
					
					// String
				
						writeString(this.release_clause_euro,dos);
					
					// String
				
						writeString(this.national_team,dos);
					
					// String
				
						writeString(this.national_rating,dos);
					
					// String
				
						writeString(this.national_team_position,dos);
					
					// String
				
						writeString(this.national_jersey_number,dos);
					
					// String
				
						writeString(this.crossing,dos);
					
					// String
				
						writeString(this.finishing,dos);
					
					// String
				
						writeString(this.heading_accuracy,dos);
					
					// String
				
						writeString(this.short_passing,dos);
					
					// String
				
						writeString(this.volleys,dos);
					
					// String
				
						writeString(this.dribbling,dos);
					
					// String
				
						writeString(this.curve,dos);
					
					// String
				
						writeString(this.freekick_accuracy,dos);
					
					// String
				
						writeString(this.long_passing,dos);
					
					// String
				
						writeString(this.ball_control,dos);
					
					// String
				
						writeString(this.acceleration,dos);
					
					// String
				
						writeString(this.sprint_speed,dos);
					
					// String
				
						writeString(this.agility,dos);
					
					// String
				
						writeString(this.reactions,dos);
					
					// String
				
						writeString(this.balance,dos);
					
					// String
				
						writeString(this.shot_power,dos);
					
					// String
				
						writeString(this.jumping,dos);
					
					// String
				
						writeString(this.stamina,dos);
					
					// String
				
						writeString(this.strength,dos);
					
					// String
				
						writeString(this.long_shots,dos);
					
					// String
				
						writeString(this.aggression,dos);
					
					// String
				
						writeString(this.interceptions,dos);
					
					// String
				
						writeString(this.positioning,dos);
					
					// String
				
						writeString(this.vision,dos);
					
					// String
				
						writeString(this.penalties,dos);
					
					// String
				
						writeString(this.composure,dos);
					
					// String
				
						writeString(this.marking,dos);
					
					// String
				
						writeString(this.standing_tackle,dos);
					
					// String
				
						writeString(this.sliding_tackle,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.name,dos);
					
					// String
				
						writeString(this.full_name,dos);
					
					// String
				
						writeString(this.birth_date,dos);
					
					// String
				
						writeString(this.age,dos);
					
					// String
				
						writeString(this.height_cm,dos);
					
					// String
				
						writeString(this.weight_kgs,dos);
					
					// String
				
						writeString(this.positions,dos);
					
					// String
				
						writeString(this.nationality,dos);
					
					// String
				
						writeString(this.overall_rating,dos);
					
					// String
				
						writeString(this.potential,dos);
					
					// String
				
						writeString(this.value_euro,dos);
					
					// String
				
						writeString(this.wage_euro,dos);
					
					// String
				
						writeString(this.preferred_foot,dos);
					
					// String
				
						writeString(this.international_reputation,dos);
					
					// String
				
						writeString(this.weak_foot,dos);
					
					// String
				
						writeString(this.skill_moves,dos);
					
					// String
				
						writeString(this.body_type,dos);
					
					// String
				
						writeString(this.release_clause_euro,dos);
					
					// String
				
						writeString(this.national_team,dos);
					
					// String
				
						writeString(this.national_rating,dos);
					
					// String
				
						writeString(this.national_team_position,dos);
					
					// String
				
						writeString(this.national_jersey_number,dos);
					
					// String
				
						writeString(this.crossing,dos);
					
					// String
				
						writeString(this.finishing,dos);
					
					// String
				
						writeString(this.heading_accuracy,dos);
					
					// String
				
						writeString(this.short_passing,dos);
					
					// String
				
						writeString(this.volleys,dos);
					
					// String
				
						writeString(this.dribbling,dos);
					
					// String
				
						writeString(this.curve,dos);
					
					// String
				
						writeString(this.freekick_accuracy,dos);
					
					// String
				
						writeString(this.long_passing,dos);
					
					// String
				
						writeString(this.ball_control,dos);
					
					// String
				
						writeString(this.acceleration,dos);
					
					// String
				
						writeString(this.sprint_speed,dos);
					
					// String
				
						writeString(this.agility,dos);
					
					// String
				
						writeString(this.reactions,dos);
					
					// String
				
						writeString(this.balance,dos);
					
					// String
				
						writeString(this.shot_power,dos);
					
					// String
				
						writeString(this.jumping,dos);
					
					// String
				
						writeString(this.stamina,dos);
					
					// String
				
						writeString(this.strength,dos);
					
					// String
				
						writeString(this.long_shots,dos);
					
					// String
				
						writeString(this.aggression,dos);
					
					// String
				
						writeString(this.interceptions,dos);
					
					// String
				
						writeString(this.positioning,dos);
					
					// String
				
						writeString(this.vision,dos);
					
					// String
				
						writeString(this.penalties,dos);
					
					// String
				
						writeString(this.composure,dos);
					
					// String
				
						writeString(this.marking,dos);
					
					// String
				
						writeString(this.standing_tackle,dos);
					
					// String
				
						writeString(this.sliding_tackle,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("name="+name);
		sb.append(",full_name="+full_name);
		sb.append(",birth_date="+birth_date);
		sb.append(",age="+age);
		sb.append(",height_cm="+height_cm);
		sb.append(",weight_kgs="+weight_kgs);
		sb.append(",positions="+positions);
		sb.append(",nationality="+nationality);
		sb.append(",overall_rating="+overall_rating);
		sb.append(",potential="+potential);
		sb.append(",value_euro="+value_euro);
		sb.append(",wage_euro="+wage_euro);
		sb.append(",preferred_foot="+preferred_foot);
		sb.append(",international_reputation="+international_reputation);
		sb.append(",weak_foot="+weak_foot);
		sb.append(",skill_moves="+skill_moves);
		sb.append(",body_type="+body_type);
		sb.append(",release_clause_euro="+release_clause_euro);
		sb.append(",national_team="+national_team);
		sb.append(",national_rating="+national_rating);
		sb.append(",national_team_position="+national_team_position);
		sb.append(",national_jersey_number="+national_jersey_number);
		sb.append(",crossing="+crossing);
		sb.append(",finishing="+finishing);
		sb.append(",heading_accuracy="+heading_accuracy);
		sb.append(",short_passing="+short_passing);
		sb.append(",volleys="+volleys);
		sb.append(",dribbling="+dribbling);
		sb.append(",curve="+curve);
		sb.append(",freekick_accuracy="+freekick_accuracy);
		sb.append(",long_passing="+long_passing);
		sb.append(",ball_control="+ball_control);
		sb.append(",acceleration="+acceleration);
		sb.append(",sprint_speed="+sprint_speed);
		sb.append(",agility="+agility);
		sb.append(",reactions="+reactions);
		sb.append(",balance="+balance);
		sb.append(",shot_power="+shot_power);
		sb.append(",jumping="+jumping);
		sb.append(",stamina="+stamina);
		sb.append(",strength="+strength);
		sb.append(",long_shots="+long_shots);
		sb.append(",aggression="+aggression);
		sb.append(",interceptions="+interceptions);
		sb.append(",positioning="+positioning);
		sb.append(",vision="+vision);
		sb.append(",penalties="+penalties);
		sb.append(",composure="+composure);
		sb.append(",marking="+marking);
		sb.append(",standing_tackle="+standing_tackle);
		sb.append(",sliding_tackle="+sliding_tackle);
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

                pathMap_tMongoDBOutput_1.put("name","");
                pathMap_tMongoDBOutput_1.put("full_name","");
                pathMap_tMongoDBOutput_1.put("birth_date","");
                pathMap_tMongoDBOutput_1.put("age","");
                pathMap_tMongoDBOutput_1.put("height_cm","");
                pathMap_tMongoDBOutput_1.put("weight_kgs","");
                pathMap_tMongoDBOutput_1.put("positions","");
                pathMap_tMongoDBOutput_1.put("nationality","");
                pathMap_tMongoDBOutput_1.put("overall_rating","");
                pathMap_tMongoDBOutput_1.put("potential","");
                pathMap_tMongoDBOutput_1.put("value_euro","");
                pathMap_tMongoDBOutput_1.put("wage_euro","");
                pathMap_tMongoDBOutput_1.put("preferred_foot","");
                pathMap_tMongoDBOutput_1.put("international_reputation","");
                pathMap_tMongoDBOutput_1.put("weak_foot","");
                pathMap_tMongoDBOutput_1.put("skill_moves","");
                pathMap_tMongoDBOutput_1.put("body_type","");
                pathMap_tMongoDBOutput_1.put("release_clause_euro","");
                pathMap_tMongoDBOutput_1.put("national_team","");
                pathMap_tMongoDBOutput_1.put("national_rating","");
                pathMap_tMongoDBOutput_1.put("national_team_position","");
                pathMap_tMongoDBOutput_1.put("national_jersey_number","");
                pathMap_tMongoDBOutput_1.put("crossing","");
                pathMap_tMongoDBOutput_1.put("finishing","");
                pathMap_tMongoDBOutput_1.put("heading_accuracy","");
                pathMap_tMongoDBOutput_1.put("short_passing","");
                pathMap_tMongoDBOutput_1.put("volleys","");
                pathMap_tMongoDBOutput_1.put("dribbling","");
                pathMap_tMongoDBOutput_1.put("curve","");
                pathMap_tMongoDBOutput_1.put("freekick_accuracy","");
                pathMap_tMongoDBOutput_1.put("long_passing","");
                pathMap_tMongoDBOutput_1.put("ball_control","");
                pathMap_tMongoDBOutput_1.put("acceleration","");
                pathMap_tMongoDBOutput_1.put("sprint_speed","");
                pathMap_tMongoDBOutput_1.put("agility","");
                pathMap_tMongoDBOutput_1.put("reactions","");
                pathMap_tMongoDBOutput_1.put("balance","");
                pathMap_tMongoDBOutput_1.put("shot_power","");
                pathMap_tMongoDBOutput_1.put("jumping","");
                pathMap_tMongoDBOutput_1.put("stamina","");
                pathMap_tMongoDBOutput_1.put("strength","");
                pathMap_tMongoDBOutput_1.put("long_shots","");
                pathMap_tMongoDBOutput_1.put("aggression","");
                pathMap_tMongoDBOutput_1.put("interceptions","");
                pathMap_tMongoDBOutput_1.put("positioning","");
                pathMap_tMongoDBOutput_1.put("vision","");
                pathMap_tMongoDBOutput_1.put("penalties","");
                pathMap_tMongoDBOutput_1.put("composure","");
                pathMap_tMongoDBOutput_1.put("marking","");
                pathMap_tMongoDBOutput_1.put("standing_tackle","");
                pathMap_tMongoDBOutput_1.put("sliding_tackle","");





        com.mongodb.MongoClient mongo_tMongoDBOutput_1=null;
        com.mongodb.client.MongoDatabase db_tMongoDBOutput_1=null;

            // Empty client options
            com.mongodb.MongoClientOptions clientOptions_tMongoDBOutput_1 = new com.mongodb.MongoClientOptions.Builder().applicationName(applicationName_tMongoDBOutput_1).build();
            // Empty client credentials list
            java.util.List<com.mongodb.MongoCredential> mongoCredentialList_tMongoDBOutput_1 = new java.util.ArrayList<com.mongodb.MongoCredential>();

                com.mongodb.ServerAddress serverAddress_tMongoDBOutput_1 = new com.mongodb.ServerAddress("192.168.0.31", 27017);
                mongo_tMongoDBOutput_1 = new com.mongodb.MongoClient(serverAddress_tMongoDBOutput_1, mongoCredentialList_tMongoDBOutput_1, clientOptions_tMongoDBOutput_1);


            resourceMap.put("mongo_tMongoDBOutput_1", mongo_tMongoDBOutput_1);
                db_tMongoDBOutput_1 = mongo_tMongoDBOutput_1.getDatabase("playersdata");




    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_1 = db_tMongoDBOutput_1.getCollection("bronze");


 



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
				int limit_tFileInputDelimited_1 = 17955;
				try{
					
						Object filename_tFileInputDelimited_1 = "C:/Users/perso/Downloads/archive/fifa_players.csv";
						if(filename_tFileInputDelimited_1 instanceof java.io.InputStream){
							
			int footer_value_tFileInputDelimited_1 = 0, random_value_tFileInputDelimited_1 = -1;
			if(footer_value_tFileInputDelimited_1 >0 || random_value_tFileInputDelimited_1 > 0){
				throw new java.lang.Exception("When the input source is a stream,footer and random shouldn't be bigger than 0.");				
			}
		
						}
						try {
							fid_tFileInputDelimited_1 = new org.talend.fileprocess.FileInputDelimited("C:/Users/perso/Downloads/archive/fifa_players.csv", "ISO-8859-15",",","\n",true,1,0,
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
					
							row1.name = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 1;
					
							row1.full_name = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 2;
					
							row1.birth_date = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 3;
					
							row1.age = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 4;
					
							row1.height_cm = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 5;
					
							row1.weight_kgs = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 6;
					
							row1.positions = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 7;
					
							row1.nationality = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 8;
					
							row1.overall_rating = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 9;
					
							row1.potential = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 10;
					
							row1.value_euro = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 11;
					
							row1.wage_euro = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 12;
					
							row1.preferred_foot = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 13;
					
							row1.international_reputation = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 14;
					
							row1.weak_foot = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 15;
					
							row1.skill_moves = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 16;
					
							row1.body_type = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 17;
					
							row1.release_clause_euro = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 18;
					
							row1.national_team = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 19;
					
							row1.national_rating = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 20;
					
							row1.national_team_position = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 21;
					
							row1.national_jersey_number = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 22;
					
							row1.crossing = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 23;
					
							row1.finishing = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 24;
					
							row1.heading_accuracy = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 25;
					
							row1.short_passing = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 26;
					
							row1.volleys = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 27;
					
							row1.dribbling = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 28;
					
							row1.curve = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 29;
					
							row1.freekick_accuracy = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 30;
					
							row1.long_passing = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 31;
					
							row1.ball_control = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 32;
					
							row1.acceleration = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 33;
					
							row1.sprint_speed = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 34;
					
							row1.agility = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 35;
					
							row1.reactions = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 36;
					
							row1.balance = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 37;
					
							row1.shot_power = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 38;
					
							row1.jumping = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 39;
					
							row1.stamina = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 40;
					
							row1.strength = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 41;
					
							row1.long_shots = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 42;
					
							row1.aggression = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 43;
					
							row1.interceptions = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 44;
					
							row1.positioning = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 45;
					
							row1.vision = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 46;
					
							row1.penalties = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 47;
					
							row1.composure = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 48;
					
							row1.marking = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 49;
					
							row1.standing_tackle = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
					columnIndexWithD_tFileInputDelimited_1 = 50;
					
							row1.sliding_tackle = fid_tFileInputDelimited_1.get(columnIndexWithD_tFileInputDelimited_1);
						
				
				
										
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
				
				

				
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("name"),"name", row1.name);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("full_name"),"full_name", row1.full_name);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("birth_date"),"birth_date", row1.birth_date);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("age"),"age", row1.age);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("height_cm"),"height_cm", row1.height_cm);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("weight_kgs"),"weight_kgs", row1.weight_kgs);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("positions"),"positions", row1.positions);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("nationality"),"nationality", row1.nationality);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("overall_rating"),"overall_rating", row1.overall_rating);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("potential"),"potential", row1.potential);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("value_euro"),"value_euro", row1.value_euro);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("wage_euro"),"wage_euro", row1.wage_euro);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("preferred_foot"),"preferred_foot", row1.preferred_foot);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("international_reputation"),"international_reputation", row1.international_reputation);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("weak_foot"),"weak_foot", row1.weak_foot);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("skill_moves"),"skill_moves", row1.skill_moves);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("body_type"),"body_type", row1.body_type);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("release_clause_euro"),"release_clause_euro", row1.release_clause_euro);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("national_team"),"national_team", row1.national_team);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("national_rating"),"national_rating", row1.national_rating);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("national_team_position"),"national_team_position", row1.national_team_position);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("national_jersey_number"),"national_jersey_number", row1.national_jersey_number);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("crossing"),"crossing", row1.crossing);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("finishing"),"finishing", row1.finishing);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("heading_accuracy"),"heading_accuracy", row1.heading_accuracy);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("short_passing"),"short_passing", row1.short_passing);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("volleys"),"volleys", row1.volleys);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("dribbling"),"dribbling", row1.dribbling);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("curve"),"curve", row1.curve);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("freekick_accuracy"),"freekick_accuracy", row1.freekick_accuracy);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("long_passing"),"long_passing", row1.long_passing);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("ball_control"),"ball_control", row1.ball_control);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("acceleration"),"acceleration", row1.acceleration);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("sprint_speed"),"sprint_speed", row1.sprint_speed);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("agility"),"agility", row1.agility);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("reactions"),"reactions", row1.reactions);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("balance"),"balance", row1.balance);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("shot_power"),"shot_power", row1.shot_power);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("jumping"),"jumping", row1.jumping);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("stamina"),"stamina", row1.stamina);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("strength"),"strength", row1.strength);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("long_shots"),"long_shots", row1.long_shots);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("aggression"),"aggression", row1.aggression);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("interceptions"),"interceptions", row1.interceptions);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("positioning"),"positioning", row1.positioning);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("vision"),"vision", row1.vision);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("penalties"),"penalties", row1.penalties);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("composure"),"composure", row1.composure);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("marking"),"marking", row1.marking);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("standing_tackle"),"standing_tackle", row1.standing_tackle);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("sliding_tackle"),"sliding_tackle", row1.sliding_tackle);
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
                if(!((Object)("C:/Users/perso/Downloads/archive/fifa_players.csv") instanceof java.io.InputStream)){
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

	

		if(mongo_tMongoDBOutput_1 != null){
			
				mongo_tMongoDBOutput_1.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_1", true); 
		
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

	
		if(resourceMap.get("finish_tMongoDBOutput_1") == null){
			if(resourceMap.get("mongo_tMongoDBOutput_1") != null){

		    
		    			
		    			       ((com.mongodb.MongoClient)resourceMap.get("mongo_tMongoDBOutput_1")).close();
		    
		    
			
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
		

		globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", 1);
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
        final Players PlayersClass = new Players();

        int exitCode = PlayersClass.runJobInTOS(args);

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
            java.io.InputStream inContext = Players.class.getClassLoader().getResourceAsStream("local_project/players_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Players.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
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
errorCode = null;tFileInputDelimited_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputDelimited_1) {
globalMap.put("tFileInputDelimited_1_SUBPROCESS_STATE", -1);

e_tFileInputDelimited_1.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Players");
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
 *     81332 characters generated by Talend Open Studio for Big Data 
 *     on the 3 décembre 2025 à 23:28:03 CET
 ************************************************************************************************/