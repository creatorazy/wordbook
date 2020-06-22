package com.wordbook.controller;

import com.wordbook.entity.User;
import com.wordbook.entity.Word;
import com.wordbook.service.WordService;
import com.wordbook.util.PageUtil;
import com.wordbook.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    @Resource
    private WordService ws;

    @RequestMapping("/query")
    public Result query(Integer id, PageUtil pageUtil) {
        User u = new User();
        u.setWords(ws.queryByUidAndPageAndLimit(id, pageUtil));
        u.setWordCount(pageUtil.getTotal());
        Result result = new Result(200, "获取单词成功", u);
        return result;
    }

    @RequestMapping("/del")
    public Result query(Word word) {
        boolean b = ws.del(word);
        Result result = new Result(b ? 200 : 400, b ? "删除单词成功" : "删除单词失败");
        return result;
    }

    @RequestMapping("/add")
    public Result add(Word word) {
        boolean b = ws.add(word);
        Result result = new Result(b ? 200 : 400, b ? "添加单词成功" : "添加单词失败");
        return result;
    }

    @RequestMapping("/up")
    public Result up(Word word) {
        boolean b = ws.up(word);
        Result result = new Result(b ? 200 : 400, b ? "更新单词成功" : "更新单词失败");
        return result;
    }
}
