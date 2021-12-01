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
public class Word {

    private List<TransList> transList;
    private String pos;
    private List<Wfs> wfs;
    public void setTransList(List<TransList> transList) {
         this.transList = transList;
     }
     public List<TransList> getTransList() {
         return transList;
     }

    public void setPos(String pos) {
         this.pos = pos;
     }
     public String getPos() {
         return pos;
     }

    public void setWfs(List<Wfs> wfs) {
         this.wfs = wfs;
     }
     public List<Wfs> getWfs() {
         return wfs;
     }

}