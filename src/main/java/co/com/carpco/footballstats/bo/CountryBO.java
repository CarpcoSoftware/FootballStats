/**
 * 
 */
package co.com.carpco.footballstats.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.carpco.footballstats.dao.CountryDAO;
import co.com.carpco.footballstats.entity.Country;

/**
 * Country business object, use this to get records from database
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Service
public class CountryBO implements IBusinessObject<Country> {
  
  @Autowired
  private CountryDAO countryDAO;

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findAll()
   */
  @Override
  public Set<Country> findAll() {
    return countryDAO.select();
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#findByIdentifier(int)
   */
  @Override
  public Country findByIdentifier(int identifier) {
    return countryDAO.selectByIdentifier(identifier);
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#insertRecord(java.lang.Object)
   */
  @Override
  public void insertRecord(Country newRecord) {
    countryDAO.insert(newRecord);
  }

  /* (non-Javadoc)
   * @see co.com.carpco.footballstats.bo.IBussinesObject#updateRecord(java.lang.Object)
   */
  @Override
  public void updateRecord(Country record) {
    countryDAO.update(record);
  }

}
