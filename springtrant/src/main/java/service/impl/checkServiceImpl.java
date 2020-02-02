package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BookService;
import service.CheckService;

import javax.transaction.Transactional;
import java.util.List;
@Service("checkService")
public class checkServiceImpl implements CheckService {
    @Autowired
    BookService bookService;
    @Transactional
    @Override
    public void buyList(List<Integer> bookId) {
        for (Integer book :bookId){
            bookService.buybook(book);
        }
    }
}
