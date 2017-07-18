package app.service;

import java.util.List;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;
import app.entries.${entries};


public interface ${entries}Service extends SupportService<${entries}>{

    @Override
    @ServiceMethod(type=ServiceType.BUSINESS,name="保存")
    public void save(${entries} model);


}
