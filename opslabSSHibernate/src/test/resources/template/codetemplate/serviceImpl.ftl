package ${package}.service.impl;

import ${package}.entity.business.${entity};
import ${package}.service.${entity}Service;
import ${package}.dao.SupportDao;
import ${package}.service.${ServiceClass};

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
* 业务方法
*/
@Service("${service}")
public class ${entity}ServiceImpl extends SupportServiceImpl<${entity},${ID}> implements ${entity}Service{
    @Resource(name = "${dao}")
    private ${daoClass} db;


    @Override
    public SupportDao getdb() {
    return db;
    }

}
