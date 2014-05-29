/**
 * 
 */
package co.com.carpco.footballstats.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.com.carpco.footballstats.entity.Country;
import co.com.carpco.footballstats.entity.Tournament;
import co.com.carpco.footballstats.entity.TournamentType;

/**
 * Team data object, use this to perform database operations
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Repository
public class TournamentDAO extends AbstractDAO implements IDAO<Tournament> {

  @Autowired
  private CountryDAO countryDAO;

  @Autowired
  private TournamentTypeDAO tournamentTypeDAO;

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#select()
   */
  @Override
  public Set<Tournament> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT idtournament, name, foundation_year, idcountry, idtournament_type ");
    sql.append("FROM tournament ");

    Set<Tournament> tournamentList = new HashSet<>(jdbcTemplateObject.query(sql.toString(), new TournamentMapper()));
    return tournamentList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#selectByIdentifier(int)
   */
  @Override
  public Tournament selectByIdentifier(int identifier) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#insert(java.lang.Object)
   */
  @Override
  public void insert(Tournament newRecord) {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#update(java.lang.Object)
   */
  @Override
  public void update(Tournament record) {
    // TODO Auto-generated method stub

  }
  
  public Set<Tournament> selectByCountry(int idCountry) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT idtournament, name, foundation_year, idcountry, idtournament_type ");
    sql.append("FROM tournament ");
    sql.append("WHERE idcountry = ? ");

    Set<Tournament> tournamentSet = new HashSet<>(jdbcTemplateObject.query(sql.toString(), new Object[] {idCountry}, new TournamentMapper()));
    return tournamentSet;
  }

  private class TournamentMapper implements RowMapper<Tournament> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public Tournament mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("idtournament");
      String name = rs.getString("name");
      int foundation = rs.getInt("foundation_year");
      int idCountry = rs.getInt("idcountry");
      int idTournamentType = rs.getInt("idtournament_type");

      Country country = (Country) countryDAO.selectByIdentifier(idCountry);
      TournamentType tournamentType =
          (TournamentType) tournamentTypeDAO.selectByIdentifier(idTournamentType);

      return new Tournament(identifier, name, foundation, country, tournamentType);
    }

  }

}
