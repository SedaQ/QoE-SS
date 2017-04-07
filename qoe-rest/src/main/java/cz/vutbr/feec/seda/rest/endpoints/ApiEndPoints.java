package cz.vutbr.feec.seda.rest.endpoints;

/**
 * Represents the entry points for the API this list can be increased so that it
 * contains all the other URIs also for the sub-resources so that it can reused
 * globally from all the controllers
 * 
 * @author Pavel Šeda
 */
public abstract class ApiEndPoints {

	public static final String ROOT_URI_USERS = "/rest/users";
	public static final String ROOT_URI_QUESTIONARY = "/rest/questionaries";
	public static final String ROOT_URI_MOS = "/rest/mos";
	public static final String ROOT_URI_VIDEOS = "/rest/videos";
	public static final String ROOT_URI_SCENARIOS = "/rest/scenarios";
	public static final String ROOT_URI_SCENARIO_PARAMETERS = "/rest/scenarioparameters";
	
}
