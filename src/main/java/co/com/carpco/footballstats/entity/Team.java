/**
 * 
 */
package co.com.carpco.footballstats.entity;

import java.awt.Image;

/**
 * Team entity
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/17/2014
 */
public class Team {

  private int idTeam;
  
  private String name;
  
  private String nickname;
  
  private Image flag;
  
  private Country country;
  
  private int foundation;
  
  private int ranking;
  
  private String coach;
  
  public Team(String name, String nickname, Image flag, Country country, int foundation, int ranking, String coach) {
    super();
    this.name = name;
    this.nickname = nickname;
    this.flag = flag;
    this.country = country;
    this.foundation = foundation;
    this.ranking = ranking;
    this.coach = coach;
  }
  
  public Team(int idTeam, String name, String nickname, Image flag, Country country, int foundation, int ranking, String coach) {
    super();
    this.idTeam = idTeam;
    this.name = name;
    this.nickname = nickname;
    this.flag = flag;
    this.country = country;
    this.foundation = foundation;
    this.ranking = ranking;
    this.coach = coach;
  }

  /**
   * @return the idTeam
   */
  public int getIdTeam() {
    return idTeam;
  }

  /**
   * @param idTeam the idTeam to set
   */
  public void setIdTeam(int idTeam) {
    this.idTeam = idTeam;
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
   * @return the nickname
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * @param nickname the nickname to set
   */
  public void setNickname(String nickname) {
    this.nickname = nickname;
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
   * @return the country
   */
  public Country getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(Country country) {
    this.country = country;
  }
  
  /**
   * @return the foundation
   */
  public int getFoundation() {
    return foundation;
  }

  /**
   * @param foundation the foundation to set
   */
  public void setFoundation(int foundation) {
    this.foundation = foundation;
  }

  /**
   * @return the ranking
   */
  public int getRanking() {
    return ranking;
  }

  /**
   * @param ranking the ranking to set
   */
  public void setRanking(int ranking) {
    this.ranking = ranking;
  }

  /**
   * @return the coach
   */
  public String getCoach() {
    return coach;
  }

  /**
   * @param coach the coach to set
   */
  public void setCoach(String coach) {
    this.coach = coach;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((coach == null) ? 0 : coach.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((flag == null) ? 0 : flag.hashCode());
    result = prime * result + foundation;
    result = prime * result + idTeam;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
    result = prime * result + ranking;
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
    if (!(obj instanceof Team))
      return false;
    Team other = (Team) obj;
    if (coach == null) {
      if (other.coach != null)
        return false;
    } else if (!coach.equals(other.coach))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (flag == null) {
      if (other.flag != null)
        return false;
    } else if (!flag.equals(other.flag))
      return false;
    if (foundation != other.foundation)
      return false;
    if (idTeam != other.idTeam)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (nickname == null) {
      if (other.nickname != null)
        return false;
    } else if (!nickname.equals(other.nickname))
      return false;
    if (ranking != other.ranking)
      return false;
    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "Team [idTeam=" + idTeam + ", name=" + name + ", nickname=" + nickname + ", flag="
        + flag + ", country=" + country + ", foundation=" + foundation + ", ranking=" + ranking
        + ", coach=" + coach + "]";
  }
}
