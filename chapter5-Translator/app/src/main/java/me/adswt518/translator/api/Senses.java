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
public class Senses {

    private List<Examples> examples;
    private String definition;
    private String lang;
    private String word;
    public void setExamples(List<Examples> examples) {
         this.examples = examples;
     }
     public List<Examples> getExamples() {
         return examples;
     }

    public void setDefinition(String definition) {
         this.definition = definition;
     }
     public String getDefinition() {
         return definition;
     }

    public void setLang(String lang) {
         this.lang = lang;
     }
     public String getLang() {
         return lang;
     }

    public void setWord(String word) {
         this.word = word;
     }
     public String getWord() {
         return word;
     }

}