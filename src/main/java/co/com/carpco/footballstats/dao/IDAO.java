/**
 * 
 */
package co.com.carpco.footballstats.dao;

import java.util.Set;

/**
 * DAO interface <br/> 
 * Add here all methods that must be provided to DAO implementation
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/17/2014
 */
public interface IDAO <T> {
  
  /**
   * Selects all records from database
   * 
   * @return User set
   */
  public Set<T> select();

  /**
   * Select a record using identifier
   * 
   * @param identifier The identifier from database
   * @return A record if identifier is found in database, null otherwise
   */
  public T selectByIdentifier(int identifier);

  /**
   * Insert a new record in database
   * 
   * @param newRecord Object to be inserted
   */
  public void insert(T newRecord);

  /**
   * Update a record in database
   * 
   * @param record Object to be updated
   */
  public void update(T record);

}
