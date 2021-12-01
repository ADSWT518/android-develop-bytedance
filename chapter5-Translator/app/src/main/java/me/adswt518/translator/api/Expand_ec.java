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
public class Expand_ec {

    @SerializedName("return-phrase")
    private String return_phrase;
    private Source source;
    private List<Word> word;

    public String getReturn_phrase() {
        return return_phrase;
    }

    public void setReturn_phrase(String return_phrase) {
        this.return_phrase = return_phrase;
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