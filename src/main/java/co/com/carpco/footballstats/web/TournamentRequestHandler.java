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

import co.com.carpco.footballstats.bo.TournamentBO;
import co.com.carpco.footballstats.entity.Tournament;
import co.com.carpco.footballstats.response.TournamentResponse;
import co.com.carpco.footballstats.spring.ServiceLocator;

/**
 * @author Carlos Rodriguez
 */
@Path("/footballstats/tournament/")
public class TournamentRequestHandler {

  @Autowired
  private TournamentBO tournamentBO = ServiceLocator.getBean(TournamentBO.class);

  @GET
  @Path("all")
  @Produces({MediaType.APPLICATION_XML})
  public String findTournaments() {
    
    Set<Tournament> tournamentSet = tournamentBO.findAll();
    
    TournamentResponse response = new TournamentResponse();
    String responseStr = null;
    
    try {
      responseStr = response.tournamentsToXML(tournamentSet);
    } catch (TransformerException e) {
      e.printStackTrace();
    }
    
    return responseStr;
  }

}
