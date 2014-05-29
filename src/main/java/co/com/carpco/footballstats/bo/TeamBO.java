/**
 * 
 */
package co.com.carpco.footballstats.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.carpco.footballstats.dao.TeamDAO;
import co.com.carpco.footballstats.entity.Team;

/**
 * Team business object, use this to get records from database
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Service
public class TeamBO implements IBusinessObject<Team> {
  
  @Autowired
  private TeamDAO teamDAO;

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findAll()
   */
  @Override
  public Set<Team> findAll() {
    return teamDAO.select();
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findByIdentifier(int)
   */
  @Override
  public Team findByIdentifier(int identifier) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#insertRecord(java.lang.Object)
   */
  @Override
  public void insertRecord(Team newRecord) {
    teamDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#updateRecord(java.lang.Object)
   */
  @Override
  public void updateRecord(Team record) {
    // TODO Auto-generated method stub

  }

}
