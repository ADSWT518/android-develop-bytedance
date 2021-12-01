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
public class Web_trans {

    public List<Web_translation> getWeb_translation() {
        return web_translation;
    }

    public void setWeb_translation(List<Web_translation> web_translation) {
        this.web_translation = web_translation;
    }

    @SerializedName("web-translation")
    private List<Web_translation> web_translation;


}