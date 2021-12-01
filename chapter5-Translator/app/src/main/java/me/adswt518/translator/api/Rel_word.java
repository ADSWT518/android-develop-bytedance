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
public class Rel_word {

    private String word;
    private String stem;
    private List<Rels> rels;
    public void setWord(String word) {
         this.word = word;
     }
     public String getWord() {
         return word;
     }

    public void setStem(String stem) {
         this.stem = stem;
     }
     public String getStem() {
         return stem;
     }

    public void setRels(List<Rels> rels) {
         this.rels = rels;
     }
     public List<Rels> getRels() {
         return rels;
     }

}