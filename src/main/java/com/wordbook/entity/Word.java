package com.wordbook.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * (Word)实体类
 *
 * @author makejava
 * @since 2020-06-19 09:23:24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Word implements Serializable {
    private static final long serialVersionUID = -91327848105759729L;

    private Integer id;

    private Integer uid;

    private String word;

    private String pronunciation;

    private String chinese_translation;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getChinese_translation() {
        return chinese_translation;
    }

    public void setChinese_translation(String chinese_translation) {
        this.chinese_translation = chinese_translation;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", uid=" + uid +
                ", word='" + word + '\'' +
                ", pronunciation='" + pronunciation + '\'' +
                ", chinese_translation='" + chinese_translation + '\'' +
                '}';
    }
}