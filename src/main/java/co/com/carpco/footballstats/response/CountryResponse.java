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

  public CountryResponse() {
    super();
  }

  public String teamsToXML(Set<Object> countrySet) throws TransformerException {
    doc.setRootElement(new Element("Countries"));

    for (Object object : countrySet) {
      doc.getRootElement().addContent(buildElement(object));
    }

    return documentToString();
  }

  @Override
  public Element buildElement(Object object) {
    Country country = (Country) object;
    Element element = new Element("Country");
    element.setAttribute("id", String.valueOf(country.getIdCountry()));
    element.addContent(new Element("name").setText(country.getName()));
    element.addContent(new Element("flag").setText(ImageUtil.encodeToString((BufferedImage) country
        .getFlag())));
    element.addContent(new Element("language").setText(country.getLanguage()));
    return element;
  }

}
