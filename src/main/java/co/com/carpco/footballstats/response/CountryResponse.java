/**
 * 
 */
package co.com.carpco.footballstats.response;

import java.awt.image.BufferedImage;
import java.util.Set;

import javax.xml.transform.TransformerException;

import org.jdom2.Element;

import co.com.carpco.footballstats.entity.Country;
import co.com.carpco.footballstats.util.ImageUtil;

/**
 * Country response, use this to build a team response that must be returned as XML
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
public class CountryResponse extends AbstractResponse {

  private static final String ROOT_ELEMENT = "Countries";

  private static final String ENTRY_ELEMENT = "Country";

  private static final String ATTRIBUTE_ID = "id";

  private static final String ATTRIBUTE_NAME = "name";

  private static final String ATTRIBUTE_LANGUAGE = "language";

  private static final String ATTRIBUTE_FLAG = "flag";
  
  private static final String ATTRIBUTE_CAPITAL = "capital";

  public CountryResponse() {
    super();
  }

  public String teamsToXML(Set<Object> countrySet) throws TransformerException {
    doc.setRootElement(new Element(ROOT_ELEMENT));

    for (Object object : countrySet) {
      doc.getRootElement().addContent(buildElement(object));
    }

    return documentToString();
  }

  @Override
  public Element buildElement(Object object) {
    Country country = (Country) object;
    Element element = new Element(ENTRY_ELEMENT);
    element.addContent(new Element(ATTRIBUTE_ID).setText(String.valueOf(country.getIdCountry())));
    element.addContent(new Element(ATTRIBUTE_NAME).setText(country.getName()));
    element.addContent(new Element(ATTRIBUTE_LANGUAGE).setText(country.getLanguage()));
    element.addContent(new Element(ATTRIBUTE_CAPITAL).setText(country.getCapital()));
    element.addContent(new Element(ATTRIBUTE_FLAG).setText(ImageUtil
        .encodeToString((BufferedImage) country.getFlag())));
    return element;
  }

}
