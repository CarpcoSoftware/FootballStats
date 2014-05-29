/**
 * 
 */
package co.com.carpco.footballstats.bo;

import java.util.Set;

/**
 * BO interface <br/> 
 * Add here all methods that must be provided to BO implementation
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
public interface IBusinessObject<T> {
  
  /**
   * Selects all records from database
   * 
   * @return User set
   */
  public Set<T> findAll();

  /**
   * Select a record using identifier
   * 
   * @param identifier The identifier from database
   * @return A record if identifier is found in database, null otherwise
   */
  public T findByIdentifier(int identifier);

  /**
   * Insert a new record in database
   * 
   * @param newRecord Object to be inserted
   */
  public void insertRecord(T newRecord);

  /**
   * Update a record in database
   * 
   * @param record Object to be updated
   */
  public void updateRecord(T record);

}
