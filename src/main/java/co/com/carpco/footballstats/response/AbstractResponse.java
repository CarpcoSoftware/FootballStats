/**
 * 
 */
package co.com.carpco.footballstats.response;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Response object, use this to build response that must be returned as XML
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
public abstract class AbstractResponse {

  protected Document doc;

  public AbstractResponse() {
    super();
    doc = new Document();
  }

  protected String documentToString() {
    XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
    String xmlString = outputter.outputString(doc);
    return xmlString;
  }
  
  public abstract Element buildElement(Object object);

}
