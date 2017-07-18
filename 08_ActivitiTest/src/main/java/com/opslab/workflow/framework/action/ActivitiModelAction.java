package com.opslab.workflow.framework.action;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opslab.workflow.framework.entity.activiti.ActivitiModel;
import com.opslab.workflow.framework.entity.view.UIResult;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author 0opslab
 * @date on 2016/6/19 0019.
 */
@Controller
@RequestMapping("/activiti-model")
public class ActivitiModelAction {
    protected Logger logger = Logger.getLogger(ActivitiModelAction.class);
    @Autowired
    RepositoryService repositoryService;

    @RequestMapping
    public String model(ModelMap model){
        long count = repositoryService.createModelQuery().count();
        model.addAttribute("count",count);
        return "admin/workflow/model-list";
    }

    @RequestMapping("add")
    public String addModel(){
        return "admin/workflow/modelAdd";
    }

    @RequestMapping("save")
    public String saveModel(@RequestBody ActivitiModel activiti,
                          HttpServletRequest request, HttpServletResponse response){
        Model newModel = repositoryService.newModel();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME,
                    activiti.getName());
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION,
                    StringUtils.defaultString(activiti.getDescription()));
            newModel.setMetaInfo(modelObjectNode.toString());
            newModel.setName(activiti.getName());
            newModel.setKey(StringUtils.defaultString(activiti.getKey()));
            repositoryService.saveModel(newModel);
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace",
                    "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            repositoryService.addModelEditorSource(newModel.getId(),
                    editorNode.toString().getBytes("utf-8"));
        } catch (Exception e) {
            e.getStackTrace();
        }

        return newModel.getId();

    }
    /**
     * 模型列表
     */
    @RequestMapping({"list/{page}/{pagesize}"})
    @ResponseBody
    public List<Model> modelList(
            @PathVariable("page") int page,
            @PathVariable("pagesize") int pagesize
    ) {
        List<Model> list = repositoryService.createModelQuery()
                .listPage(page,pagesize);
        return list;
    }
    /**
     * 创建模型
     */
    @RequestMapping(value = "create")
    @ResponseBody
    public UIResult create(
            @RequestParam("name") String name,
            @RequestParam("key") String key,
            @RequestParam("category") String category,
            @RequestParam("description") String description,
            HttpServletRequest request, HttpServletResponse response)
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "canvas");
            editorNode.put("resourceId", "canvas");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.put("stencilset", stencilSetNode);
            Model modelData = repositoryService.newModel();
            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
            description = StringUtils.defaultString(description);
            modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, description);
            modelData.setMetaInfo(modelObjectNode.toString());
            modelData.setName(name);
            modelData.setKey(StringUtils.defaultString(key));
            modelData.setCategory(category);
            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
            modelData.getId();
            return new UIResult("success","操作成功!模型id:"+modelData.getId());
        } catch (Exception e) {
            logger.error("创建模型失败：", e);
        }
        return new UIResult("error","操作失败!");
    }
    /**
     * 根据Model部署流程
     */
    @RequestMapping(value = "deploy/{modelId}")
    public String deploy(@PathVariable("modelId") String modelId, RedirectAttributes redirectAttributes) {
        try {
            Model modelData = repositoryService.getModel(modelId);
            ObjectNode modelNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            byte[] bpmnBytes = null;
            BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
            bpmnBytes = new BpmnXMLConverter().convertToXML(model);
            String processName = modelData.getName() + ".bpmn20.xml";
            Deployment deployment = repositoryService.createDeployment().name(modelData.getName()).addString(processName, new String(bpmnBytes)).deploy();
            redirectAttributes.addFlashAttribute("message", "部署成功，部署ID=" + deployment.getId());
        } catch (Exception e) {
            logger.error("根据模型部署流程失败：modelId={}"+modelId, e);
        }
        return "redirect:/workflow/model/list";
    }
    /**
     * 导出model的xml文件
     */
    @RequestMapping(value = "export/{modelId}")
    public void export(@PathVariable("modelId") String modelId, HttpServletResponse response) {
        try {
            Model modelData = repositoryService.getModel(modelId);
            BpmnJsonConverter jsonConverter = new BpmnJsonConverter();
            JsonNode editorNode = new ObjectMapper().readTree(repositoryService.getModelEditorSource(modelData.getId()));
            BpmnModel bpmnModel = jsonConverter.convertToBpmnModel(editorNode);
            BpmnXMLConverter xmlConverter = new BpmnXMLConverter();
            byte[] bpmnBytes = xmlConverter.convertToXML(bpmnModel);
            ByteArrayInputStream in = new ByteArrayInputStream(bpmnBytes);
            IOUtils.copy(in, response.getOutputStream());
            String filename = bpmnModel.getMainProcess().getId() + ".bpmn20.xml";
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            response.flushBuffer();
        } catch (Exception e) {
            logger.error("导出model的xml文件失败：modelId={}"+ modelId+ e);
        }
    }
}
