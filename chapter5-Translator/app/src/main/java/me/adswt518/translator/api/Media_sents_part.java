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
public class Media_sents_part {

    @SerializedName("sentence-count")
    private int sentence_count;
    private String more;
    private String query;
    private List<Sent> sent;

    public int getSentence_count() {
        return sentence_count;
    }

    public void setSentence_count(int sentence_count) {
        this.sentence_count = sentence_count;
    }

    public void setMore(String more) {
         this.more = more;
     }
     public String getMore() {
         return more;
     }

    public void setQuery(String query) {
         this.query = query;
     }
     public String getQuery() {
         return query;
     }

    public void setSent(List<Sent> sent) {
         this.sent = sent;
     }
     public List<Sent> getSent() {
         return sent;
     }

}