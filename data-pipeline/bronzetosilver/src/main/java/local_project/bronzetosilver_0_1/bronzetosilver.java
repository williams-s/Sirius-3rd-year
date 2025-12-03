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
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tMongoDBInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMongoDBInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	






public static class coucouStruct implements routines.system.IPersistableRow<coucouStruct> {
    final static byte[] commonByteArrayLock_LOCAL_PROJECT_bronzetosilver = new byte[0];
    static byte[] commonByteArray_LOCAL_PROJECT_bronzetosilver = new byte[0];

	
			    public String name;

				public String getName () {
					return this.name;
				}
				
			    public String full_name;

				public String getFull_name () {
					return this.full_name;
				}
				
			    public String nationality;

				public String getNationality () {
					return this.nationality;
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
		
					this.name = readString(dis);
					
					this.full_name = readString(dis);
					
					this.nationality = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

        	try {

        		int length = 0;
		
					this.name = readString(dis);
					
					this.full_name = readString(dis);
					
					this.nationality = readString(dis);
					
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
				
						writeString(this.nationality,dos);
					
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
				
						writeString(this.nationality,dos);
					
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
		sb.append(",nationality="+nationality);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(coucouStruct other) {

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

		synchronized(commonByteArrayLock_LOCAL_PROJECT_bronzetosilver) {

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
public void tMongoDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", 0);

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
coucouStruct coucou = new coucouStruct();





	
	/**
	 * [tMongoDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMongoDBOutput_1", false);
		start_Hash.put("tMongoDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"coucou");
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
                pathMap_tMongoDBOutput_1.put("nationality","");





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




    com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBOutput_1 = db_tMongoDBOutput_1.getCollection("silver");


 



/**
 * [tMongoDBOutput_1 begin ] stop
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
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
coucouStruct coucou_tmp = new coucouStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
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
	



        com.mongodb.MongoClient mongo_tMongoDBInput_1=null;
        com.mongodb.client.MongoDatabase db_tMongoDBInput_1=null;

            // Empty client options
            com.mongodb.MongoClientOptions clientOptions_tMongoDBInput_1 = new com.mongodb.MongoClientOptions.Builder().applicationName(applicationName_tMongoDBInput_1).build();
            // Empty client credentials list
            java.util.List<com.mongodb.MongoCredential> mongoCredentialList_tMongoDBInput_1 = new java.util.ArrayList<com.mongodb.MongoCredential>();

                com.mongodb.ServerAddress serverAddress_tMongoDBInput_1 = new com.mongodb.ServerAddress("192.168.0.31", 27017);
                mongo_tMongoDBInput_1 = new com.mongodb.MongoClient(serverAddress_tMongoDBInput_1, mongoCredentialList_tMongoDBInput_1, clientOptions_tMongoDBInput_1);


            resourceMap.put("mongo_tMongoDBInput_1", mongo_tMongoDBInput_1);
                db_tMongoDBInput_1 = mongo_tMongoDBInput_1.getDatabase("playersdata");





				
					com.mongodb.client.MongoCollection<org.bson.Document> coll_tMongoDBInput_1 = db_tMongoDBInput_1.getCollection("bronze");
				
				
				
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
						
						return value;
					}
				}
				DBObjectInputUtil_tMongoDBInput_1 dbObjectInputUtil_tMongoDBInput_1=new DBObjectInputUtil_tMongoDBInput_1();
				java.util.Map<String, String> pathMap_tMongoDBInput_1=new java.util.HashMap<>();
				pathMap_tMongoDBInput_1.put("name","");
				pathMap_tMongoDBInput_1.put("full_name","");
				pathMap_tMongoDBInput_1.put("birth_date","");
				pathMap_tMongoDBInput_1.put("age","");
				pathMap_tMongoDBInput_1.put("height_cm","");
				pathMap_tMongoDBInput_1.put("weight_kgs","");
				pathMap_tMongoDBInput_1.put("positions","");
				pathMap_tMongoDBInput_1.put("nationality","");
				pathMap_tMongoDBInput_1.put("overall_rating","");
				pathMap_tMongoDBInput_1.put("potential","");
				pathMap_tMongoDBInput_1.put("value_euro","");
				pathMap_tMongoDBInput_1.put("wage_euro","");
				pathMap_tMongoDBInput_1.put("preferred_foot","");
				pathMap_tMongoDBInput_1.put("international_reputation","");
				pathMap_tMongoDBInput_1.put("weak_foot","");
				pathMap_tMongoDBInput_1.put("skill_moves","");
				pathMap_tMongoDBInput_1.put("body_type","");
				pathMap_tMongoDBInput_1.put("release_clause_euro","");
				pathMap_tMongoDBInput_1.put("national_team","");
				pathMap_tMongoDBInput_1.put("national_rating","");
				pathMap_tMongoDBInput_1.put("national_team_position","");
				pathMap_tMongoDBInput_1.put("national_jersey_number","");
				pathMap_tMongoDBInput_1.put("crossing","");
				pathMap_tMongoDBInput_1.put("finishing","");
				pathMap_tMongoDBInput_1.put("heading_accuracy","");
				pathMap_tMongoDBInput_1.put("short_passing","");
				pathMap_tMongoDBInput_1.put("volleys","");
				pathMap_tMongoDBInput_1.put("dribbling","");
				pathMap_tMongoDBInput_1.put("curve","");
				pathMap_tMongoDBInput_1.put("freekick_accuracy","");
				pathMap_tMongoDBInput_1.put("long_passing","");
				pathMap_tMongoDBInput_1.put("ball_control","");
				pathMap_tMongoDBInput_1.put("acceleration","");
				pathMap_tMongoDBInput_1.put("sprint_speed","");
				pathMap_tMongoDBInput_1.put("agility","");
				pathMap_tMongoDBInput_1.put("reactions","");
				pathMap_tMongoDBInput_1.put("balance","");
				pathMap_tMongoDBInput_1.put("shot_power","");
				pathMap_tMongoDBInput_1.put("jumping","");
				pathMap_tMongoDBInput_1.put("stamina","");
				pathMap_tMongoDBInput_1.put("strength","");
				pathMap_tMongoDBInput_1.put("long_shots","");
				pathMap_tMongoDBInput_1.put("aggression","");
				pathMap_tMongoDBInput_1.put("interceptions","");
				pathMap_tMongoDBInput_1.put("positioning","");
				pathMap_tMongoDBInput_1.put("vision","");
				pathMap_tMongoDBInput_1.put("penalties","");
				pathMap_tMongoDBInput_1.put("composure","");
				pathMap_tMongoDBInput_1.put("marking","");
				pathMap_tMongoDBInput_1.put("standing_tackle","");
				pathMap_tMongoDBInput_1.put("sliding_tackle","");

						
					com.mongodb.client.MongoCursor<org.bson.Document> cursor_tMongoDBInput_1 = findIterable_tMongoDBInput_1.iterator();
						
				while (cursor_tMongoDBInput_1.hasNext()){
				org.bson.Document o_tMongoDBInput_1 = cursor_tMongoDBInput_1.next();
				nb_line_tMongoDBInput_1++;
				Object valueObj_tMongoDBInput_1=null;
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("name"),"name",o_tMongoDBInput_1);
					
				row2.name = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("full_name"),"full_name",o_tMongoDBInput_1);
					
				row2.full_name = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("birth_date"),"birth_date",o_tMongoDBInput_1);
					
				row2.birth_date = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("age"),"age",o_tMongoDBInput_1);
					
				row2.age = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("height_cm"),"height_cm",o_tMongoDBInput_1);
					
				row2.height_cm = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("weight_kgs"),"weight_kgs",o_tMongoDBInput_1);
					
				row2.weight_kgs = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("positions"),"positions",o_tMongoDBInput_1);
					
				row2.positions = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("nationality"),"nationality",o_tMongoDBInput_1);
					
				row2.nationality = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("overall_rating"),"overall_rating",o_tMongoDBInput_1);
					
				row2.overall_rating = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("potential"),"potential",o_tMongoDBInput_1);
					
				row2.potential = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("value_euro"),"value_euro",o_tMongoDBInput_1);
					
				row2.value_euro = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("wage_euro"),"wage_euro",o_tMongoDBInput_1);
					
				row2.wage_euro = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("preferred_foot"),"preferred_foot",o_tMongoDBInput_1);
					
				row2.preferred_foot = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("international_reputation"),"international_reputation",o_tMongoDBInput_1);
					
				row2.international_reputation = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("weak_foot"),"weak_foot",o_tMongoDBInput_1);
					
				row2.weak_foot = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("skill_moves"),"skill_moves",o_tMongoDBInput_1);
					
				row2.skill_moves = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("body_type"),"body_type",o_tMongoDBInput_1);
					
				row2.body_type = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("release_clause_euro"),"release_clause_euro",o_tMongoDBInput_1);
					
				row2.release_clause_euro = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("national_team"),"national_team",o_tMongoDBInput_1);
					
				row2.national_team = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("national_rating"),"national_rating",o_tMongoDBInput_1);
					
				row2.national_rating = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("national_team_position"),"national_team_position",o_tMongoDBInput_1);
					
				row2.national_team_position = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("national_jersey_number"),"national_jersey_number",o_tMongoDBInput_1);
					
				row2.national_jersey_number = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("crossing"),"crossing",o_tMongoDBInput_1);
					
				row2.crossing = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("finishing"),"finishing",o_tMongoDBInput_1);
					
				row2.finishing = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("heading_accuracy"),"heading_accuracy",o_tMongoDBInput_1);
					
				row2.heading_accuracy = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("short_passing"),"short_passing",o_tMongoDBInput_1);
					
				row2.short_passing = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("volleys"),"volleys",o_tMongoDBInput_1);
					
				row2.volleys = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("dribbling"),"dribbling",o_tMongoDBInput_1);
					
				row2.dribbling = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("curve"),"curve",o_tMongoDBInput_1);
					
				row2.curve = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("freekick_accuracy"),"freekick_accuracy",o_tMongoDBInput_1);
					
				row2.freekick_accuracy = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("long_passing"),"long_passing",o_tMongoDBInput_1);
					
				row2.long_passing = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("ball_control"),"ball_control",o_tMongoDBInput_1);
					
				row2.ball_control = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("acceleration"),"acceleration",o_tMongoDBInput_1);
					
				row2.acceleration = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("sprint_speed"),"sprint_speed",o_tMongoDBInput_1);
					
				row2.sprint_speed = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("agility"),"agility",o_tMongoDBInput_1);
					
				row2.agility = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("reactions"),"reactions",o_tMongoDBInput_1);
					
				row2.reactions = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("balance"),"balance",o_tMongoDBInput_1);
					
				row2.balance = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("shot_power"),"shot_power",o_tMongoDBInput_1);
					
				row2.shot_power = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("jumping"),"jumping",o_tMongoDBInput_1);
					
				row2.jumping = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("stamina"),"stamina",o_tMongoDBInput_1);
					
				row2.stamina = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("strength"),"strength",o_tMongoDBInput_1);
					
				row2.strength = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("long_shots"),"long_shots",o_tMongoDBInput_1);
					
				row2.long_shots = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("aggression"),"aggression",o_tMongoDBInput_1);
					
				row2.aggression = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("interceptions"),"interceptions",o_tMongoDBInput_1);
					
				row2.interceptions = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("positioning"),"positioning",o_tMongoDBInput_1);
					
				row2.positioning = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("vision"),"vision",o_tMongoDBInput_1);
					
				row2.vision = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("penalties"),"penalties",o_tMongoDBInput_1);
					
				row2.penalties = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("composure"),"composure",o_tMongoDBInput_1);
					
				row2.composure = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("marking"),"marking",o_tMongoDBInput_1);
					
				row2.marking = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("standing_tackle"),"standing_tackle",o_tMongoDBInput_1);
					
				row2.standing_tackle = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				
                    valueObj_tMongoDBInput_1=dbObjectInputUtil_tMongoDBInput_1.getValue(pathMap_tMongoDBInput_1.get("sliding_tackle"),"sliding_tackle",o_tMongoDBInput_1);
					
				row2.sliding_tackle = valueObj_tMongoDBInput_1==null ? null : valueObj_tMongoDBInput_1.toString();
				


 



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
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

coucou = null;


// # Output table : 'coucou'
// # Filter conditions 
if( 

row2.nationality.equals("France")

 ) {
coucou_tmp.name = row2.name ;
coucou_tmp.full_name = row2.full_name ;
coucou_tmp.nationality = row2.nationality ;
coucou = coucou_tmp;
} // closing filter/reject
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
// Start of branch "coucou"
if(coucou != null) { 



	
	/**
	 * [tMongoDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"coucou"
						
						);
					}
					

	
try{
				updateObjectUtil_tMongoDBOutput_1.setObject(new org.bson.Document());
				
				

				
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("name"),"name", coucou.name);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("full_name"),"full_name", coucou.full_name);
                                        updateObjectUtil_tMongoDBOutput_1.put(pathMap_tMongoDBOutput_1.get("nationality"),"nationality", coucou.nationality);
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

} // End of branch "coucou"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
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
                    if(mongo_tMongoDBInput_1 != null ) {
                        mongo_tMongoDBInput_1.close();
                    }
    globalMap.put("tMongoDBInput_1_NB_LINE", nb_line_tMongoDBInput_1);
 

ok_Hash.put("tMongoDBInput_1", true);
end_Hash.put("tMongoDBInput_1", System.currentTimeMillis());




/**
 * [tMongoDBInput_1 end ] stop
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
	 * [tMongoDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tMongoDBOutput_1";

	

		if(mongo_tMongoDBOutput_1 != null){
			
				mongo_tMongoDBOutput_1.close();
			
		}
		resourceMap.put("finish_tMongoDBOutput_1", true); 
		
	globalMap.put("tMongoDBOutput_1_NB_LINE", nb_line_tMongoDBOutput_1);

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"coucou");
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
	 * [tMongoDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tMongoDBInput_1";

	

 



/**
 * [tMongoDBInput_1 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
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
		

		globalMap.put("tMongoDBInput_1_SUBPROCESS_STATE", 1);
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
 *     90769 characters generated by Talend Open Studio for Big Data 
 *     on the 4 décembre 2025 à 00:16:00 CET
 ************************************************************************************************/