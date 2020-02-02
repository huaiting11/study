import org.activiti.engine.*;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring.xml",
})
public class Test03 {
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private RepositoryService repositoryService;
    @Test
    public void test(){

        // 加载配置文件
       /* ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("spring.xml","processEngineConfiguration").buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();
        RuntimeService runtimeService = processEngine.getRuntimeService();*/
        repositoryService.createDeployment().addClasspathResource("Interview.bpmn").deploy();
        String processId = runtimeService.startProcessInstanceByKey("Interview").getId();

        TaskService taskService = processEngine.getTaskService();
        //得到笔试的流程
        System.out.println("\n***************笔试流程开始***************");
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("人力资源部").list();
        for (Task task : tasks) {
            System.out.println("人力资源部的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.claim(task.getId(), "张三");
        }

        System.out.println("张三的任务数量："+taskService.createTaskQuery().taskAssignee("张三").count());
        tasks = taskService.createTaskQuery().taskAssignee("张三").list();
        for (Task task : tasks) {
            System.out.println("张三的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.complete(task.getId());
        }

        System.out.println("张三的任务数量："+taskService.createTaskQuery().taskAssignee("张三").count());
        System.out.println("***************笔试流程结束***************");

        System.out.println("\n***************一面流程开始***************");
        tasks = taskService.createTaskQuery().taskCandidateGroup("技术部").list();
        for (Task task : tasks) {
            System.out.println("技术部的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.claim(task.getId(), "李四");
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        for (Task task : tasks) {
            System.out.println("李四的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.complete(task.getId());
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        System.out.println("***************一面流程结束***************");

        System.out.println("\n***************二面流程开始***************");
        tasks = taskService.createTaskQuery().taskCandidateGroup("技术部").list();
        for (Task task : tasks) {
            System.out.println("技术部的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.claim(task.getId(), "李四");
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        for (Task task : tasks) {
            System.out.println("李四的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.complete(task.getId());
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        System.out.println("***************二面流程结束***************");

        System.out.println("***************HR面流程开始***************");
        tasks = taskService.createTaskQuery().taskCandidateGroup("人力资源部").list();
        for (Task task : tasks) {
            System.out.println("技术部的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.claim(task.getId(), "李四");
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        for (Task task : tasks) {
            System.out.println("李四的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.complete(task.getId());
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        System.out.println("***************HR面流程结束***************");

        System.out.println("\n***************录用流程开始***************");
        tasks = taskService.createTaskQuery().taskCandidateGroup("人力资源部").list();
        for (Task task : tasks) {
            System.out.println("技术部的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.claim(task.getId(), "李四");
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        for (Task task : tasks) {
            System.out.println("李四的任务：name:"+task.getName()+",id:"+task.getId());
            taskService.complete(task.getId());
        }

        System.out.println("李四的任务数量："+taskService.createTaskQuery().taskAssignee("李四").count());
        System.out.println("***************录用流程结束***************");

        HistoryService historyService = processEngine.getHistoryService();
        HistoricProcessInstance historicProcessInstance = historyService
                .createHistoricProcessInstanceQuery()
                .processInstanceId(processId).singleResult();
        System.out.println("\n流程结束时间："+historicProcessInstance.getEndTime());
        processEngine.close();
    }
}
