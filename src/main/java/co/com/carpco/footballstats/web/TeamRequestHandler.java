/**
 * 
 */
package co.com.carpco.footballstats.web;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.TransformerException;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.carpco.footballstats.bo.TeamBO;
import co.com.carpco.footballstats.entity.Team;
import co.com.carpco.footballstats.response.TeamResponse;
import co.com.carpco.footballstats.spring.ServiceLocator;

/**
 * @author Carlos Rodriguez
 */
@Path("/footballstats/team/")
public class TeamRequestHandler {

  @Autowired
  private TeamBO teamBO = ServiceLocator.getBean(TeamBO.class);

  @GET
  @Path("all")
  @Produces({MediaType.APPLICATION_XML})
  public String findTeams() {
    
    Set<Team> teamSet = teamBO.findAll();
    
    TeamResponse response = new TeamResponse();
    String responseStr = null;
    
    try {
      responseStr = response.teamsToXML(teamSet);
    } catch (TransformerException e) {
      e.printStackTrace();
    }
    
    return responseStr;
  }

}
