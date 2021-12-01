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
public class Entry {

    private String major;
    private List<Trs> trs;
    private int num;
    public void setMajor(String major) {
         this.major = major;
     }
     public String getMajor() {
         return major;
     }

    public void setTrs(List<Trs> trs) {
         this.trs = trs;
     }
     public List<Trs> getTrs() {
         return trs;
     }

    public void setNum(int num) {
         this.num = num;
     }
     public int getNum() {
         return num;
     }

}