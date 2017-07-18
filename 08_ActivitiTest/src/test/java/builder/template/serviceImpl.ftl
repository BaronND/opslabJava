package ${package}.service.impl;

import ${package}.entity.${entity};
import ${package}.service.${entity}Service;
import ${package}.service.impl.SupportServiceImpl;
import org.springframework.stereotype.Service;

/**
* 业务方法
*/
@Service("${service}")
public class ${entity}ServiceImpl extends SupportServiceImpl<${entity},${ID}> implements ${entity}Service{
}
