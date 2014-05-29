/**
 * 
 */
package co.com.carpco.footballstats.response;

import java.awt.image.BufferedImage;
import java.util.Set;

import javax.xml.transform.TransformerException;

import org.jdom2.Element;

import co.com.carpco.footballstats.entity.Team;
import co.com.carpco.footballstats.util.ImageUtil;

/**
 * Team response, use this to build a team response that must be returned as XML
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
public class TeamResponse extends AbstractResponse {
  
  private CountryResponse countryResponse;

  public TeamResponse() {
    super();
    countryResponse = new CountryResponse();
  }
  
  public String teamsToXML(Set<Team> teamSet) throws TransformerException {
    doc.setRootElement(new Element("Teams"));
    
    for (Object object : teamSet) {
      doc.getRootElement().addContent(buildElement(object));
    }
    
    return documentToString();
  }

  @Override
  public Element buildElement(Object object) {
    Team team = (Team) object;
    
    Element element = new Element("Team");
    element.addContent(new Element("id").setText(String.valueOf(team.getIdTeam())));
    element.addContent(new Element("name").setText(team.getName()));
    element.addContent(new Element("nickname").setText(team.getNickname()));
    element.addContent(new Element("flag").setText(ImageUtil.encodeToString((BufferedImage) team.getFlag())));
    element.addContent(new Element("foundation").setText(String.valueOf(team.getFoundation().getMillis())));
    element.addContent(countryResponse.buildElement(team.getCountry()));
    return element;
  }
  
  public Element teamsToElement(Set<Team> teamSet) {
    Element element = new Element("Teams");
    
    for (Object object : teamSet) {
      element.addContent(buildElement(object));
    }
    
    return element;
  }

}
