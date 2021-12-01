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
public class Web_translation {

    @SerializedName("@same")
    private String same;
    private String key;

    public String getKey_speech() {
        return key_speech;
    }

    public void setKey_speech(String key_speech) {
        this.key_speech = key_speech;
    }

    @SerializedName("key-speech")
    private String key_speech;

    private List<Trans> trans;

    public void setSame(String same) {
         this.same = same;
     }
     public String getSame() {
         return same;
     }

    public void setKey(String key) {
         this.key = key;
     }
     public String getKey() {
         return key;
     }



    public void setTrans(List<Trans> trans) {
         this.trans = trans;
     }
     public List<Trans> getTrans() {
         return trans;
     }

}