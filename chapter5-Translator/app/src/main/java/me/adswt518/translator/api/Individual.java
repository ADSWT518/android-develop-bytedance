/**
  * Copyright 2021 json.cn 
  */
package me.adswt518.translator.api;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Auto-generated: 2021-11-09 21:39:43
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Individual {

    private List<Trs> trs;
    private String level;
    private ExamInfo examInfo;
    @SerializedName("return-phrase")
    private String return_phrase;
    private List<PastExamSents> pastExamSents;
    public void setTrs(List<Trs> trs) {
         this.trs = trs;
     }
     public List<Trs> getTrs() {
         return trs;
     }

    public void setLevel(String level) {
         this.level = level;
     }
     public String getLevel() {
         return level;
     }

    public void setExamInfo(ExamInfo examInfo) {
         this.examInfo = examInfo;
     }
     public ExamInfo getExamInfo() {
         return examInfo;
     }

    public String getReturn_phrase() {
        return return_phrase;
    }

    public void setReturn_phrase(String return_phrase) {
        this.return_phrase = return_phrase;
    }

    public void setPastExamSents(List<PastExamSents> pastExamSents) {
         this.pastExamSents = pastExamSents;
     }
     public List<PastExamSents> getPastExamSents() {
         return pastExamSents;
     }

}