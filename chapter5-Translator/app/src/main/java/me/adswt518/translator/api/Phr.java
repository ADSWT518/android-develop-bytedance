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
public class Phr {

    private Headword headword;
    private List<Trs> trs;
    private String source;
    public void setHeadword(Headword headword) {
         this.headword = headword;
     }
     public Headword getHeadword() {
         return headword;
     }

    public void setTrs(List<Trs> trs) {
         this.trs = trs;
     }
     public List<Trs> getTrs() {
         return trs;
     }

    public void setSource(String source) {
         this.source = source;
     }
     public String getSource() {
         return source;
     }

}