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
public class Ec {

    private List<String> exam_type;
    private Source source;
    private List<Word> word;
    public void setExam_type(List<String> exam_type) {
         this.exam_type = exam_type;
     }
     public List<String> getExam_type() {
         return exam_type;
     }

    public void setSource(Source source) {
         this.source = source;
     }
     public Source getSource() {
         return source;
     }

    public void setWord(List<Word> word) {
         this.word = word;
     }
     public List<Word> getWord() {
         return word;
     }

}