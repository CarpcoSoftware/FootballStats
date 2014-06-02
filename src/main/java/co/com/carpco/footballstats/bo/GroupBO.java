/**
 * 
 */
package co.com.carpco.footballstats.bo;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.carpco.footballstats.dao.GroupDAO;
import co.com.carpco.footballstats.entity.Group;

/**
 * @author Alberto Palencia
 */
@Service
public class GroupBO implements IBusinessObject<Group> {

	@Autowired
	private GroupDAO groupDAO;

	@Override
	public Set<Group> findAll() {
		return groupDAO.select();
	}

	@Override
	public Group findByIdentifier(int identifier) {
		return groupDAO.selectByIdentifier(identifier);
	}

	@Override
	public void insertRecord(Group newRecord) {
		groupDAO.insert(newRecord);
	}

	@Override
	public void updateRecord(Group record) {
		groupDAO.update(record);
	}

	public Set<Group> findByTournamentAndTeam(int idTournament, int idTeam){
		return groupDAO.selectByTournamentAndTeam(idTournament, idTeam);
	}
}
