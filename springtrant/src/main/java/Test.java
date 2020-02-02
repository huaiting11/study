import bean.Book;
import bean.Student;
import mapper.BookMapper;
import mapper.StudentMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class Test {
    public static void main(String[] args) {
        //获取applicationContext文件并加载
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取StudentDao的bean
       // CheckService bookService = (CheckService) ac.getBean("checkService");
        BookService bookService = (BookService) ac.getBean("bookService");
        bookService.buybook(1);
       // bookService.buyList(Arrays.asList(new Integer[]{1,2,3}));

    }

    private static void test(ApplicationContext ac) {
        StudentMapper sd = (StudentMapper) ac.getBean("studentMapper");
        Student s = sd.findStudentById(1);
        System.out.println("学生姓名：" + s.getUsername());
        System.out.println("学生密码：" + s.getPassword());
        System.out.println("学生邮箱：" + s.getEmail());
        BookMapper bookMapper = (BookMapper) ac.getBean("bookMapper");
        Book book = bookMapper.getById(11);
        System.out.println(book);
    }
}
