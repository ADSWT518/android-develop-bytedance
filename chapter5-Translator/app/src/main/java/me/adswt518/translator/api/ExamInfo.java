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
public class ExamInfo {

    private int year;
    private List<QuestionTypeInfo> questionTypeInfo;
    private int recommendationRate;
    private int frequency;
    public void setYear(int year) {
         this.year = year;
     }
     public int getYear() {
         return year;
     }

    public void setQuestionTypeInfo(List<QuestionTypeInfo> questionTypeInfo) {
         this.questionTypeInfo = questionTypeInfo;
     }
     public List<QuestionTypeInfo> getQuestionTypeInfo() {
         return questionTypeInfo;
     }

    public void setRecommendationRate(int recommendationRate) {
         this.recommendationRate = recommendationRate;
     }
     public int getRecommendationRate() {
         return recommendationRate;
     }

    public void setFrequency(int frequency) {
         this.frequency = frequency;
     }
     public int getFrequency() {
         return frequency;
     }

}