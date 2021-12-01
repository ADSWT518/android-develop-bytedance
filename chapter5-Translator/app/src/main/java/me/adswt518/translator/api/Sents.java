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
public class Sents {

    private String sentOrig;
    private String sourceType;
    private String sentSpeech;
    private String sentTrans;
    private String source;
    private List<Usages> usages;
    public void setSentOrig(String sentOrig) {
         this.sentOrig = sentOrig;
     }
     public String getSentOrig() {
         return sentOrig;
     }

    public void setSourceType(String sourceType) {
         this.sourceType = sourceType;
     }
     public String getSourceType() {
         return sourceType;
     }

    public void setSentSpeech(String sentSpeech) {
         this.sentSpeech = sentSpeech;
     }
     public String getSentSpeech() {
         return sentSpeech;
     }

    public void setSentTrans(String sentTrans) {
         this.sentTrans = sentTrans;
     }
     public String getSentTrans() {
         return sentTrans;
     }

    public void setSource(String source) {
         this.source = source;
     }
     public String getSource() {
         return source;
     }

    public void setUsages(List<Usages> usages) {
         this.usages = usages;
     }
     public List<Usages> getUsages() {
         return usages;
     }

}