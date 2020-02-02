import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring.xml",
})
/**
 * ProcessEngine 流程引擎，其他几个API都是通过流程引擎来创建的
 * ProcessEngineFactoryBean  属性 processEngineConfiguration
 */
public class Test02 {
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
    @Test
    public void testTask() throws Exception {
        // 1 发布流程
        InputStream inputStreamBpmn = this.getClass().getResourceAsStream("/test_02.xml");
        InputStream inputStreamPng = this.getClass().getResourceAsStream("/test_02.png");

        processEngine.getRepositoryService()
                .createDeployment()
                .addInputStream("test_02.xml", inputStreamBpmn)
                .addInputStream("test_02.png", inputStreamPng)
                .deploy();

        ProcessInstance pi = processEngine.getRuntimeService()//
                .startProcessInstanceByKey("myProcess_1");
        System.out.println("pid:" + pi.getId());
    }

}
