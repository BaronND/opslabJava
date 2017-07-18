package com.opslab.workflow.framework.entity.business;

/**
 * 流程定义信息
 * 该类在activiti中有定义，但是以接口的方式的实现，因此在转json话的时候会报错
 * 故定义该类
 * 对应的数据库表为act_re_procdef
 * @author 0opslab
 * @date on 2016/6/8 0008.
 */
public class ProcessDef {
    //流程定义数据主键
    private String id;
    //流程描述文件根节点的targetNamespace属性值
    private String category;
    //流程key(process节点key属性)
    private String key;
    //流程名称(process节点name属性)
    private String name;
    private String description;
    //流程的版本号
    private String version;
    //流程描述文件
    private String resourceName;
    //流程部署id
    private String deploymentId;
    //流程对应的流程图文件
    private String diagramResourceName;
    //流程开始时间中是否存在activiti:formKey的定义
    private String hasStartFormKey;
    //流程状态1为激活2为终止
    private String suspensionState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDeploymentId() {
        return deploymentId;
    }

    public void setDeploymentId(String deploymentId) {
        this.deploymentId = deploymentId;
    }

    public String getDiagramResourceName() {
        return diagramResourceName;
    }

    public void setDiagramResourceName(String diagramResourceName) {
        this.diagramResourceName = diagramResourceName;
    }

    public String getHasStartFormKey() {
        return hasStartFormKey;
    }

    public void setHasStartFormKey(String hasStartFormKey) {
        this.hasStartFormKey = hasStartFormKey;
    }

    public String getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(String suspensionState) {
        this.suspensionState = suspensionState;
    }
}
