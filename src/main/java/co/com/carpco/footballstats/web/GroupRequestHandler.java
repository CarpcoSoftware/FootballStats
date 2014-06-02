/**
 * 
 */
package co.com.carpco.footballstats.web;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.carpco.footballstats.bo.GroupBO;
import co.com.carpco.footballstats.entity.Group;
import co.com.carpco.footballstats.response.GroupResponse;
import co.com.carpco.footballstats.spring.ServiceLocator;

/**
 * @author Alberto Palencia
 */

@Path("/footballstats/group/")
public class GroupRequestHandler {

	@Autowired
	private GroupBO groupBo = ServiceLocator.getBean(GroupBO.class);

	@GET
	@Path("all")
	@Produces({ MediaType.APPLICATION_XML })
	public String findTeams() {

		Set<Group> groupSet = groupBo.findAll();
		GroupResponse response = new GroupResponse();
		String responseStr = null;
		responseStr = response.groupToXML(groupSet);

		return responseStr;
	}
}
