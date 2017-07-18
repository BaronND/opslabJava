package app.service.impl;

import app.constant.config;
import app.dao.${entries}Dao;
import app.entries.EntryPage;
import app.entries.${entries};

import app.service.${entries}Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("${entriesService}")
public class ${entries}ServiceImpl extends SupportServiceImpl<${entries}> implements ${entries}Service {

    @Resource(name="${entriesDao}")
    @Getter @Setter private ${entries}Dao dao;




}
