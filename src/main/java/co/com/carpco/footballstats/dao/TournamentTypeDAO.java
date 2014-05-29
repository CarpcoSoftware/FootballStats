/**
 * 
 */
package co.com.carpco.footballstats.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.com.carpco.footballstats.entity.TournamentType;

/**
 * Team data object, use this to perform database operations
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Repository
public class TournamentTypeDAO extends AbstractDAO implements IDAO<TournamentType> {

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#select()
   */
  @Override
  public Set<TournamentType> select() {

    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#selectByIdentifier(int)
   */
  @Override
  public TournamentType selectByIdentifier(int identifier) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT idtournament_type, name ");
    sql.append("FROM tournament_type ");
    sql.append("WHERE idtournament_type = ? ");

    TournamentType tournamentType = jdbcTemplateObject.queryForObject(sql.toString(),
            new Object[] {identifier}, new TournamentTypeMapper());
    return tournamentType;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#insert(java.lang.Object)
   */
  @Override
  public void insert(TournamentType newRecord) {
    // TODO Auto-generated method stub

  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#update(java.lang.Object)
   */
  @Override
  public void update(TournamentType record) {
    // TODO Auto-generated method stub

  }

  private class TournamentTypeMapper implements RowMapper<TournamentType> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public TournamentType mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("idtournament_type");
      String name = rs.getString("name");

      return new TournamentType(identifier, name);
    }

  }

}
