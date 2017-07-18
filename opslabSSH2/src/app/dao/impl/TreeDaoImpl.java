package app.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import app.dao.TreeDao;
import app.entries.Tree;

@Repository("treeDao")
public class TreeDaoImpl extends SupportDaoImpl<Tree> implements TreeDao {

	@Override
	public List<Tree> getTrees(String rootId) {
		String hql = "from Tree t where t.rootId = ?";
		List<Tree> list = this.getEntryListByHQL(hql, rootId);
		return list;
	}


}
