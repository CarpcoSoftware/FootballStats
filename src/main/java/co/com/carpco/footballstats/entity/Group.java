/**
 * 
 */
package co.com.carpco.footballstats.entity;

/**
 * @author Alberto Palencia
 */
public class Group {

	private int idGroup;
	
	private String name;

	public Group(String name) {
		super();
		this.name = name;

	}
	
	public Group(int idGroup, String name) {
		super();
		this.idGroup = idGroup;
		this.name = name;
	}
	
	public int getIdGroup() {
		return idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Group [idGroup=" + idGroup + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idGroup;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (idGroup != other.idGroup)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
