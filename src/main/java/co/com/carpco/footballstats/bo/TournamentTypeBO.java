/**
 * 
 */
package co.com.carpco.footballstats.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.carpco.footballstats.dao.TournamentTypeDAO;
import co.com.carpco.footballstats.entity.TournamentType;

/**
 * Tournament type business object, use this to get records from database
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Service
public class TournamentTypeBO implements IBusinessObject<TournamentType> {
  
  @Autowired
  private TournamentTypeDAO tournamentTypeDAO;

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findAll()
   */
  @Override
  public Set<TournamentType> findAll() {
    return tournamentTypeDAO.select();
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findByIdentifier(int)
   */
  @Override
  public TournamentType findByIdentifier(int identifier) {
    return tournamentTypeDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#insertRecord(java.lang.Object)
   */
  @Override
  public void insertRecord(TournamentType newRecord) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#updateRecord(java.lang.Object)
   */
  @Override
  public void updateRecord(TournamentType record) {
    // TODO Auto-generated method stub

  }

}
