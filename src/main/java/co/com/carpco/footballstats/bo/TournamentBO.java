/**
 * 
 */
package co.com.carpco.footballstats.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.carpco.footballstats.dao.TournamentDAO;
import co.com.carpco.footballstats.entity.Tournament;

/**
 * Tournament business object, use this to get records from database
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Service
public class TournamentBO implements IBusinessObject<Tournament> {
  
  @Autowired
  private TournamentDAO tournamentDAO;

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findAll()
   */
  @Override
  public Set<Tournament> findAll() {
    return tournamentDAO.select();
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findByIdentifier(int)
   */
  @Override
  public Tournament findByIdentifier(int identifier) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#insertRecord(java.lang.Object)
   */
  @Override
  public void insertRecord(Tournament newRecord) {
    tournamentDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#updateRecord(java.lang.Object)
   */
  @Override
  public void updateRecord(Tournament record) {
    // TODO Auto-generated method stub

  }

}
