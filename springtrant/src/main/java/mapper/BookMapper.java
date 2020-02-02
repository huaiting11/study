package mapper;

import bean.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookMapper {
    public Book getById(Integer id);
    public int decLeft(Integer id);

}
