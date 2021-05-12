package com.ssm.mapper;

import com.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //增加
    int addBook(Books books);

    //删
    int deleteBook(@Param("bookId") int id);

    //改
    int updateBook(Books books);

    //查
    Books queryBookById(@Param("bookId") int id);

    //查询所有书
    List<Books> queryAllBook();
}
