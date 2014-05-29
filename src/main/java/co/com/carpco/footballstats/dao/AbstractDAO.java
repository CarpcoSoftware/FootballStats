/**
 * 
 */
package co.com.carpco.footballstats.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Abstract DAO <br/>
 * All DAO implementations must extend this class to support Spring integration avoiding code repeated 
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/17/2014
 */
public abstract class AbstractDAO {
  
  /**
   * Data source name from spring, it must be used to connect to correct database
   */
  private static String dataSourceName;

  /**
   * {@link JdbcTemplate} object used to execute statements
   */
  protected JdbcTemplate jdbcTemplateObject;

  /**
   * Sets a new data source
   * 
   * @param dataSource Data source to be set
   */
  @Autowired
  public void setDataSource(DataSource dataSource) {
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }

  /**
   * @return the dataSourceName
   */
  public static String getDataSourceName() {
    return dataSourceName;
  }

  /**
   * @param dsName the dataSourceName to set
   */
  public static void setDataSourceName(final String dsName) {
    dataSourceName = dsName;
  }
}