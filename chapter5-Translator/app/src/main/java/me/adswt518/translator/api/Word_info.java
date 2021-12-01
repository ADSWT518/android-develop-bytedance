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
public class Word_info {

    @SerializedName("return-phrase")
    private String return_phrase;

    private List<String> sense;

    public String getReturn_phrase() {
        return return_phrase;
    }

    public void setReturn_phrase(String return_phrase) {
        this.return_phrase = return_phrase;
    }

    public void setSense(List<String> sense) {
         this.sense = sense;
     }
     public List<String> getSense() {
         return sense;
     }

}