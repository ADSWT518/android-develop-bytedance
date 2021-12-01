/**
  * Copyright 2021 json.cn 
  */
package me.adswt518.translator.api;

import com.google.gson.annotations.SerializedName;

/**
 * Auto-generated: 2021-11-09 21:39:43
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Sent {

    @SerializedName("@mediatype")
    private String mediatype;
    private Snippets snippets;
    @SerializedName("speech-size")
    private String speech_size;
    private String eng;

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public String getSpeech_size() {
        return speech_size;
    }

    public void setSpeech_size(String speech_size) {
        this.speech_size = speech_size;
    }

    public void setSnippets(Snippets snippets) {
         this.snippets = snippets;
     }
     public Snippets getSnippets() {
         return snippets;
     }



    public void setEng(String eng) {
         this.eng = eng;
     }
     public String getEng() {
         return eng;
     }

}