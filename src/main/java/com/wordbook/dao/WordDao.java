package com.wordbook.dao;

import com.wordbook.entity.Word;
import com.wordbook.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WordDao extends BaseDao<Word>{
    List<Word> queryByUidAndPageAndLimit(@Param("uid") Integer uid, @Param("page") PageUtil page);

    Integer del(Word word);
}
