/**
 * 
 */
package co.com.carpco.footballstats.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import co.com.carpco.footballstats.entity.Group;

/**
 * @author Alberto Palencia
 */
@Repository
public class GroupDAO extends AbstractDAO implements IDAO<Group> {

	@Override
	public Set<Group> select() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idGroup, name ");
		sql.append("FROM tournament_group ");

		Set<Group> groupSet = new HashSet<>(jdbcTemplateObject.query(
				sql.toString(), new GroupMapper()));
		return groupSet;
	}

	@Override
	public Group selectByIdentifier(int identifier) {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idGroup, name ");
		sql.append("FROM  tournament_group ");
		sql.append("WHERE idGroup = ? ");

		Group group = (Group) jdbcTemplateObject.query(sql.toString(), new Object[] { identifier }, new GroupMapper());

		return group;
	}

	@Override
	public void insert(Group newRecord) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tournament_group(name) Values (?)");
		Group group = newRecord;
		jdbcTemplateObject.update(sql.toString(),
				new Object[] { group.getName() });

	}

	@Override
	public void update(Group record) {
		StringBuilder sql = new StringBuilder();
		Group group = record;
		sql.append("UPDATE tournament_group SET name = ? ");
		sql.append("WHERE idGroup = ? ");
		jdbcTemplateObject.update(sql.toString(),new Object[]{group.getName(),group.getIdGroup()});
	}
	
	public Set<Group> selectByTournamentAndTeam(int idTournament, int idTeam) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT idGroup, name ");
		sql.append("FROM tournament_group g ");
		sql.append("INNER JOIN tournament_team tt ON g.idGroup = tt.idGroup ");
		sql.append("WHERE tt.idTournament = ? AND tt.idTeam = ? ");

		Set<Group> groupSet = new HashSet<>(jdbcTemplateObject.query(
				sql.toString(), new Object[] {idTournament, idTeam}, new GroupMapper()));
		return groupSet;
	}

	private class GroupMapper implements RowMapper<Group> {

		public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
			int idGroup = rs.getInt("idGroup");
			String name = rs.getString("name");
			return new Group(idGroup, name);
		}
	}

}
