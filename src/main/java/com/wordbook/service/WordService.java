package com.wordbook.service;

import com.wordbook.dao.WordDao;
import com.wordbook.entity.Word;
import com.wordbook.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WordService {

    @Resource
    private WordDao wd;

    public List<Word> queryByUidAndPageAndLimit(Integer uid, PageUtil pageUtil) {
        pageUtil.setTotal(wd.queryCountByUid(uid));
        return wd.queryByUidAndPageAndLimit(uid, pageUtil);
    }

    public boolean del(Word word) {
        return wd.del(word) > 0;
    }

    public boolean add(Word word){
        return wd.insert(word)>0;
    }

    public boolean up(Word word){
        return wd.update(word)>0;
    }
}
