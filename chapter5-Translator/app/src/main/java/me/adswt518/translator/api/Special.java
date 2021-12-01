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
public class Special {

    private Summary summary;

    @SerializedName("co-add")
    private String co_add;
    private String total;

    @SerializedName("entries")
    private List<EntriesTwo> entries;

    public void setSummary(Summary summary) {
         this.summary = summary;
     }
     public Summary getSummary() {
         return summary;
     }

    public String getCo_add() {
        return co_add;
    }

    public void setCo_add(String co_add) {
        this.co_add = co_add;
    }

    public void setTotal(String total) {
         this.total = total;
     }
     public String getTotal() {
         return total;
     }

    public List<EntriesTwo> getEntries() {
        return entries;
    }

    public void setEntries(List<EntriesTwo> entries) {
        this.entries = entries;
    }
}