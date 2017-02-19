package com.seda.qoe.rest.controllers.representational;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seda.qoe.rest.endpoints.ApiEndPoints;

/**
 * The main entry point of the REST API Provides access to all the resources
 * with links to resource URIs Can be even extended further so that all the
 * actions on all the resources are available and can be reused in all the
 * controllers (possibly in full HATEOAS style)
 * 
 * @return resources uris
 */
@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
public class MainRestController {

	/**
	 * The main entry point of the REST API Provides access to all the resources
	 * with links to resource URIs Can be even extended further so that all the
	 * actions on all the resources are available and can be reused in all the
	 * controllers (possibly in full HATEOAS style)
	 * 
	 * @return resources uris
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public final Map<String, String> getResources() {

		Map<String, String> resourcesMap = new HashMap<String, String>();

		resourcesMap.put("users_uri", ApiEndPoints.ROOT_URI_USERS);
		resourcesMap.put("questionaries_uri", ApiEndPoints.ROOT_URI_QUESTIONARY);
		resourcesMap.put("mos_uri", ApiEndPoints.ROOT_URI_MOS);
		resourcesMap.put("videos_uri", ApiEndPoints.ROOT_URI_VIDEOS);
		resourcesMap.put("scenarios_uri", ApiEndPoints.ROOT_URI_SCENARIOS);
		resourcesMap.put("scenarioparameters_uri",
				ApiEndPoints.ROOT_URI_SCENARIO_PARAMETERS);

		return Collections.unmodifiableMap(resourcesMap);

	}

}
