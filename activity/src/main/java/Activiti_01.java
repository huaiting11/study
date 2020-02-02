import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class Activiti_01 {
    public static void main(String[] args) {
        ProcessEngineConfiguration pec = ProcessEngineConfiguration
                .createStandaloneProcessEngineConfiguration();
        // 设置数据库的类型
        pec.setDatabaseType("mysql");
        // 设置创建数据库的方式
        // ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE(true);//如果没有数据库表就会创建数据库表，有的话就修改表结构.
        // ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE(false): 不会创建数据库表
        // ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP(create-drop): 先创建、再删除.
        pec.setDatabaseSchemaUpdate("true");
        // 设置数据库驱动
        pec.setJdbcDriver("com.mysql.jdbc.Driver");
        // 设置jdbcURL
        pec.setJdbcUrl("jdbc:mysql://localhost:3306/activitiTest?useUnicode=true&characterEncoding=UTF-8");
        // 设置用户名
        pec.setJdbcUsername("root");
        // 设置密码

        pec.setJdbcPassword("root");

        //  pec.setJdbcPassword("XXXX");

        // 构建流程引擎对象
        ProcessEngine pe = pec.buildProcessEngine(); // 调用访方法才会创建数据表
        // 调用close方法时，才会删除
        pe.close();
    }
}
