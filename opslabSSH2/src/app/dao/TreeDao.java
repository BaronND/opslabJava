package app.dao;

import app.entries.Tree;
import app.exception.DataAccessException;

import java.util.List;

public interface TreeDao extends SupportDao<Tree> {
	
	public List<Tree> getTrees(String rootId) throws DataAccessException;

}
