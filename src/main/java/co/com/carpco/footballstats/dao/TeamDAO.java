/**
 * 
 */
package co.com.carpco.footballstats.dao;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.com.carpco.footballstats.entity.Country;
import co.com.carpco.footballstats.entity.Team;
import co.com.carpco.footballstats.util.ImageUtil;

/**
 * Team data object, use this to perform database operations
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 5/18/2014
 */
@Repository
public class TeamDAO extends AbstractDAO implements IDAO<Team> {

  @Autowired
  private CountryDAO countryDAO;

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#select()
   */
  @Override
  public Set<Team> select() {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT idteam, name, nickname, flag, idcountry, foundation, ranking, coach ");
    sql.append("FROM team ");

    Set<Team> teamSet = new HashSet<>(jdbcTemplateObject.query(sql.toString(), new TeamMapper()));
    return teamSet;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#selectByIdentifier(int)
   */
  @Override
  public Team selectByIdentifier(int identifier) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#insert(java.lang.Object)
   */
  @Override
  public void insert(Team newRecord) {
    StringBuilder sql = new StringBuilder();
    sql.append("INSERT INTO team ");
    sql.append("(name, nickname, flag, idcountry, foundation, ranking, coach) ");
    sql.append("VALUES (?, ?, ?, ?, ?, ?, ?)");

    Team team = newRecord;
    byte[] imageInByte = ImageUtil.encodeToByteArray((BufferedImage) team.getFlag());

    jdbcTemplateObject.update(sql.toString(), new Object[] {team.getName(), team.getNickname(),
        imageInByte, team.getCountry().getIdCountry(), team.getFoundation(), team.getRanking(),
        team.getCoach()});
  }

  /*
   * (non-Javadoc)
   * 
   * @see co.com.carpco.footballstats.dao.IDAO#update(java.lang.Object)
   */
  @Override
  public void update(Team record) {
    // TODO Auto-generated method stub

  }

  /**
   * Selects all teams linked to tournament
   * 
   * @param idTournament Tournament identifier
   * @return User set
   */
  public Set<Team> selectByTournament(int idTournament) {
    StringBuilder sql = new StringBuilder();
    sql.append("SELECT t.idteam, t.name, t.nickname, t.flag, t.idcountry, t.foundation, t.ranking, t.coach ");
    sql.append("FROM team t ");
    sql.append("INNER JOIN tournament_team txt ON t.idteam = txt.idteam ");
    sql.append("WHERE txt.idtournament = ? ");

    Set<Team> teamSet =
        new HashSet<>(jdbcTemplateObject.query(sql.toString(), new Object[] {idTournament},
            new TeamMapper()));
    return teamSet;
  }

  private class TeamMapper implements RowMapper<Team> {

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
     */
    @Override
    public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
      int identifier = rs.getInt("idteam");
      String name = rs.getString("name");
      String nickname = rs.getString("nickname");
      InputStream is = rs.getBinaryStream("flag");
      int idCountry = rs.getInt("idcountry");
      int foundation = rs.getInt("foundation");
      int ranking = rs.getInt("ranking");
      String coach = rs.getString("coach");

      BufferedImage flag = null;
      try {
        flag = ImageIO.read(is);
      } catch (IOException e) {
        e.printStackTrace();
      }

      Country country = countryDAO.selectByIdentifier(idCountry);

      return new Team(identifier, name, nickname, flag, country, foundation, ranking, coach);
    }

  }

}
