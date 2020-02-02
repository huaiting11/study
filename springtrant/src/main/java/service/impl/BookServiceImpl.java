package service.impl;

import bean.Book;
import bean.Student;
import exec.BookExecption;
import exec.UserAccountExecption;
import mapper.BookMapper;
import mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import service.BookService;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    StudentMapper studentMapper;
    @Override
    /**添加事务注解
     * 1.使用propagation 指定事务的传播行为，即当前的事务方法被另一个事务
     * 方法调用时，如何使用事务
     * 默认取值required ，即使用调用方法的事务
     * REQUIRES_NEW 使用自己的事务，调用的事务方法的事务被挂起
     *  2 使用isolation 指定事务的隔离级别，最常用的取值为READ_COMMITTED
        3默认情况下Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置
     超时和只读属性
     由于事务可以在行和表上获得锁，因此长事务会占用资源，并对整体性能产生影响
     如果一个事务只读取数据但是不做修改，数据库引擎可以对这个事务进行优化
     超时事务属性：事务在强制回滚之前可以 保持多久，这样可以防止长期运行的事务占用资源
     只读事务属性，表示这个事务只读取数据但不更新数据，这样可以帮助数据库引擎优化事务
     4 使用readOnly 指定事务是否为只读，
     若这个方法 只读取数据库值的方法，应设置 readOnly = true
     5.使用timeout 指定强制回滚之前事务可以占用的时间
     */
    @Transactional(propagation=Propagation.REQUIRES_NEW,
            isolation = Isolation.READ_COMMITTED,readOnly = false,timeout = 3
    )
    public void buybook(Integer bookId) {

        // 库存减1 ;
        Book book = bookMapper.getById(bookId);
        if(book.getLeft() == 0){
            throw new BookExecption("库存不足");

        }
        bookMapper.decLeft(bookId); // 更新库存
        Student student = studentMapper.findStudentById(1);
        if(student.getAccount() < book.getPrice()){
            throw new UserAccountExecption();
        }
        student.setAccount(student.getAccount()-book.getPrice());
        studentMapper.updateAcc(student); //更新余额
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Transactional()
    @Override
    public void buyList(List<Integer> bookId) {
        for (Integer book :bookId){
            buybook(book);
        }
    }
}
/*
  事务传播属性
  当事务方法被另一个事务方法调用时，必须指定事务应该如何传播，例如：
  方法可能继续在现有事务运行，也可能开启一个新事务，并在自己的事务运行
  一个事务的传播行为，可以有传播属性指定 spring 指定了7种类传播行为
 */
/**
 * REQUIED 传播行为
 * 当bug 方法 被另一个事务方法 buyList 调用时，它默认会在现有的事务内运行，这个默认的传播行为就是
 * REQUIED ，因此在buyList 方法的开始和终止边界内只有一个事务，这个事务只在buyList 方法结束的时候
 * 被提交，结果用户一本书都买不了
 * 事务传播属性可以在 @Transactional 注解的 propagation 属性定义
 */
/**
 * 另一个常用的传播性为是REQUIRES_NEW
 * 它表示该方法必须启动一个新事务，并在自己的事务内运行，如果有事务在运行，就应该先
 * 挂起它。
 *
 * 小总结 ：总结：要想总的方法的异常不影响 新事务方法REQUIRES_NEW的提交，新事务的方法，要写在另一个service里
 */
/**
 TransactionDefinition.ISOLATION_DEFAULT:    使用后端数据库默认的隔离级别，Mysql 默认采用的 REPEATABLE_READ隔离级别 Oracle 默认采用的 READ_COMMITTED隔离级别.
 TransactionDefinition.ISOLATION_READ_UNCOMMITTED: 最低的隔离级别，允许读取尚未提交的数据变更，可能会导致脏读、幻读或不可重复读
 TransactionDefinition.ISOLATION_READ_COMMITTED: 允许读取并发事务已经提交的数据，可以阻止脏读，但是幻读或不可重复读仍有可能发生
 TransactionDefinition.ISOLATION_REPEATABLE_READ: 对同一字段的多次读取结果都是一致的，除非数据是被本身事务自己所修改，可以阻止脏读和不可重复读，但幻读仍有可能发生。
 TransactionDefinition.ISOLATION_SERIALIZABLE:     最高的隔离级别，完全服从ACID的隔离级别。所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。
';l

 **/