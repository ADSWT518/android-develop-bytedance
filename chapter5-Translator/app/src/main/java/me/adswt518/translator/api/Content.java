/**
  * Copyright 2021 json.cn 
  */
package me.adswt518.translator.api;
import java.util.List;

/**
 * Auto-generated: 2021-11-09 21:39:43
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Content {

    private String detailPos;
    private List<ExamType> examType;
    private List<Sents> sents;
    public void setDetailPos(String detailPos) {
         this.detailPos = detailPos;
     }
     public String getDetailPos() {
         return detailPos;
     }

    public void setExamType(List<ExamType> examType) {
         this.examType = examType;
     }
     public List<ExamType> getExamType() {
         return examType;
     }

    public void setSents(List<Sents> sents) {
         this.sents = sents;
     }
     public List<Sents> getSents() {
         return sents;
     }

}