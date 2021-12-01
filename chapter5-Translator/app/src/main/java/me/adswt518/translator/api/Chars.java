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
public class Chars {

    @SerializedName("@s")
    private String s;

    @SerializedName("@e")
    private String e;

    private Aligns aligns;

    @SerializedName("@id")
    private String id;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public Aligns getAligns() {
        return aligns;
    }

    public void setAligns(Aligns aligns) {
        this.aligns = aligns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}