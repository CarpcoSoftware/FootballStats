/**
 * 
 */
package co.com.carpco.footballstats.dao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.com.carpco.footballstats.entity.Country;
import co.com.carpco.footballstats.util.ImageUtil;

/**
 * Country data object, use this to perform database operations
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Repository
public class CountryDAO extends AbstractDAO implements IDAO<Country> {

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#select()
   */
  @Override
  public Set<Country> select() {
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#selectByIdentifier(int)
   */
  @Override
  public Country selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT idcountry, name, flag, language ");
    sql.append("FROM country ");
    sql.append("WHERE idcountry = ? ");

    Country country =
        jdbcTemplateObject.queryForObject(sql.toString(), new Object[] {identifier},
            new CountryMapper());
    return country;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#insert(java.lang.Object)
   */
  @Override
  public void insert(Country newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO country ");
    sql.append("(name, flag, language) ");
    sql.append("VALUES (?, ?, ?)");

    Country country = newRecord;
    byte[] imageInByte = ImageUtil.encodeToByteArray((BufferedImage) country.getFlag());

    jdbcTemplateObject.update(sql.toString(),
        new Object[] {country.getName(), imageInByte, country.getLanguage()});
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#update(java.lang.Object)
   */
  @Override
  public void update(Country record) {
    // TODO Auto-generated method stub

  }

  private class CountryMapper implements RowMapper<Country> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("idcountry");
      String name = rs.getString("name");
      InputStream is = rs.getBinaryStream("flag");
      String languange = rs.getString("language");

      BufferedImage flag = null;
      try {
        flag = ImageIO.read(is);
      } catch (IOException e) {
        e.printStackTrace();
      }

      return new Country(identifier, name, flag, languange);
    }

  }

}
