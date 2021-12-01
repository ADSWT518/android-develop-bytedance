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
public class Blng_sents_part {

    @SerializedName("sentence-count")
    private int sentence_count;

    @SerializedName("sentence-pair")
    private List<Sentence_pair> sentence_pair;

    private String more;

    @SerializedName("trs-classify")
    private List<Trs_classify> trs_classify;

    public int getSentence_count() {
        return sentence_count;
    }

    public void setSentence_count(int sentence_count) {
        this.sentence_count = sentence_count;
    }

    public List<Sentence_pair> getSentence_pair() {
        return sentence_pair;
    }

    public void setSentence_pair(List<Sentence_pair> sentence_pair) {
        this.sentence_pair = sentence_pair;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public List<Trs_classify> getTrs_classify() {
        return trs_classify;
    }

    public void setTrs_classify(List<Trs_classify> trs_classify) {
        this.trs_classify = trs_classify;
    }
}