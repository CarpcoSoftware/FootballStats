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
  
  private static final String ROOT_ELEMENT = "Teams";
  
  private static final String ENTRY_ELEMENT = "Team";
  
  private static final String ATTRIBUTE_ID =  "id";
  
  private static final String ATTRIBUTE_NAME =  "name";
  
  private static final String ATTRIBUTE_NICKNAME = "nickname";
  
  private static final String ATTRIBUTE_FLAG = "flag";
  
  private static final String ATTRIBUTE_FOUNDATION =  "foundation";
  
  private static final String ATTRIBUTE_RANKING = "ranking";
  
  private static final String ATTRIBUTE_COACH = "coach";
  
  private CountryResponse countryResponse;

  public TeamResponse() {
    super();
    countryResponse = new CountryResponse();
  }
  
  public String teamsToXML(Set<Team> teamSet) throws TransformerException {
    doc.setRootElement(new Element(ROOT_ELEMENT));
    
    for (Object object : teamSet) {
      doc.getRootElement().addContent(buildElement(object));
    }
    
    return documentToString();
  }

  @Override
  public Element buildElement(Object object) {
    Team team = (Team) object;
    
    Element element = new Element(ENTRY_ELEMENT);
    element.addContent(new Element(ATTRIBUTE_ID).setText(String.valueOf(team.getIdTeam())));
    element.addContent(new Element(ATTRIBUTE_NAME).setText(team.getName()));
    element.addContent(new Element(ATTRIBUTE_NICKNAME).setText(team.getNickname()));
    element.addContent(new Element(ATTRIBUTE_FLAG).setText(ImageUtil.encodeToString((BufferedImage) team.getFlag())));
    element.addContent(new Element(ATTRIBUTE_FOUNDATION).setText(String.valueOf(team.getFoundation())));
    element.addContent(new Element(ATTRIBUTE_RANKING).setText(String.valueOf(team.getRanking())));
    element.addContent(new Element(ATTRIBUTE_COACH).setText(team.getCoach()));
    element.addContent(countryResponse.buildElement(team.getCountry()));
    return element;
  }
  
  public Element teamsToElement(Set<Team> teamSet) {
    Element element = new Element(ROOT_ELEMENT);
    
    for (Object object : teamSet) {
      element.addContent(buildElement(object));
    }
    
    return element;
  }

}
