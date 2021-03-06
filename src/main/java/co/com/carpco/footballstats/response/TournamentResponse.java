/**
 * 
 */
package co.com.carpco.footballstats.response;

import java.awt.image.BufferedImage;
import java.util.Set;

import javax.xml.transform.TransformerException;

import org.jdom2.Element;

import co.com.carpco.footballstats.entity.Tournament;
import co.com.carpco.footballstats.util.ImageUtil;

/**
 * Team response, use this to build a team response that must be returned as XML
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
public class TournamentResponse extends AbstractResponse {
  
  private CountryResponse countryResponse;
  
  private TeamResponse teamResponse;

  public TournamentResponse() {
    super();
    countryResponse = new CountryResponse();
    teamResponse = new TeamResponse();
  }
  
  public String tournamentsToXML(Set<Tournament> tournamentSet) throws TransformerException {
    doc.setRootElement(new Element("Tournaments"));
    
    for (Object object : tournamentSet) {
      doc.getRootElement().addContent(buildElement(object));
    }
    
    return documentToString();
  }

  @Override
  public Element buildElement(Object object) {
    Tournament tournament = (Tournament) object;
    
    Element element = new Element("Tournament");
    element.addContent(new Element("id").setText(String.valueOf(tournament.getIdTournament())));
    element.addContent(new Element("name").setText(tournament.getName()));
    element.addContent(new Element("foundation_year").setText(String.valueOf(tournament.getFoundationYear())));
    element.addContent(new Element("flag").setText(ImageUtil.encodeToString((BufferedImage) tournament.getFlag())));
    element.addContent(countryResponse.buildElement(tournament.getCountry()));
    element.addContent(teamResponse.teamsToElement(tournament.getTeamSet()));
    
    return element;
  }

}
