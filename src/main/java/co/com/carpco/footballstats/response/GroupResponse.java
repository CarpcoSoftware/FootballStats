/**
 * 
 */
package co.com.carpco.footballstats.response;

import java.util.Set;

import org.jdom2.Element;

import co.com.carpco.footballstats.entity.Group;

/**
 * @author Alberto Palencia
 */
public class GroupResponse extends AbstractResponse {

	public GroupResponse() {
		super();
	}
	
	public String groupToXML(Set<Group> groupSet){
		doc.setRootElement(new Element("Groups"));
		for (Object object : groupSet) {
			doc.getRootElement().addContent(buildElement(object));
		}
		
		return documentToString();
	}
	
	/* (non-Javadoc)
	 * @see co.com.carpco.footballstats.response.AbstractResponse#buildElement(java.lang.Object)
	 */
	@Override
	public Element buildElement(Object object) {
		Group group = (Group) object;
		Element element = new Element("Group");
		element.addContent(new Element("idGroup").setText(String.valueOf(group.getIdGroup())));
		element.addContent(new Element("name").setText(group.getName()));
		return element;
	}

}
