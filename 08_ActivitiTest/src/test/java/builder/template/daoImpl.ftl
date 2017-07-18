package ${package}.dao.impl;

import ${package}.dao.${entity}Dao;
import ${package}.entity.${entity};
import ${package}.dao.impl.SupportDaoImpl;
import org.springframework.stereotype.Repository;

/**
* 业务实体DAO
*/
@Repository("${dao}")
public class ${entity}DaoImpl extends SupportDaoImpl<${entity},${ID}> implements ${entity}Dao {
}

