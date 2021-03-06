/**
 * 
 */
package co.com.carpco.footballstats.entity;

import java.awt.Image;

/**
 * Country entity
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/17/2014
 */
public class Country {

  private int idCountry;

  private String name;

  private Image flag;

  private String language;
  
  private String capital;
  
  public Country(String name, Image flag, String language, String capital) {
    super();
    this.name = name;
    this.flag = flag;
    this.language = language;
    this.capital = capital;
  }

  public Country(int idCountry, String name, Image flag, String language, String capital) {
    super();
    this.idCountry = idCountry;
    this.name = name;
    this.flag = flag;
    this.language = language;
    this.capital = capital;
  }

  /**
   * @return the idCountry
   */
  public int getIdCountry() {
    return idCountry;
  }

  /**
   * @param idCountry the idCountry to set
   */
  public void setIdCountry(int idCountry) {
    this.idCountry = idCountry;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the flag
   */
  public Image getFlag() {
    return flag;
  }

  /**
   * @param flag the flag to set
   */
  public void setFlag(Image flag) {
    this.flag = flag;
  }

  /**
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * @param language the language to set
   */
  public void setLanguage(String language) {
    this.language = language;
  }

  /**
   * @return the capital
   */
  public String getCapital() {
    return capital;
  }

  /**
   * @param capital the capital to set
   */
  public void setCapital(String capital) {
    this.capital = capital;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((capital == null) ? 0 : capital.hashCode());
    result = prime * result + ((flag == null) ? 0 : flag.hashCode());
    result = prime * result + idCountry;
    result = prime * result + ((language == null) ? 0 : language.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Country))
      return false;
    Country other = (Country) obj;
    if (capital == null) {
      if (other.capital != null)
        return false;
    } else if (!capital.equals(other.capital))
      return false;
    if (flag == null) {
      if (other.flag != null)
        return false;
    } else if (!flag.equals(other.flag))
      return false;
    if (idCountry != other.idCountry)
      return false;
    if (language == null) {
      if (other.language != null)
        return false;
    } else if (!language.equals(other.language))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Country [idCountry=" + idCountry + ", name=" + name + ", flag=" + flag + ", language="
        + language + ", capital=" + capital + "]";
  }

}
