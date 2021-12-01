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
public class Gramcat {

    private String audiourl;
    private String pronunciation;
    private List<Senses> senses;
    private String partofspeech;
    private String audio;
    private List<Phrases> phrases;
    private List<Forms> forms;
    public void setAudiourl(String audiourl) {
         this.audiourl = audiourl;
     }
     public String getAudiourl() {
         return audiourl;
     }

    public void setPronunciation(String pronunciation) {
         this.pronunciation = pronunciation;
     }
     public String getPronunciation() {
         return pronunciation;
     }

    public void setSenses(List<Senses> senses) {
         this.senses = senses;
     }
     public List<Senses> getSenses() {
         return senses;
     }

    public void setPartofspeech(String partofspeech) {
         this.partofspeech = partofspeech;
     }
     public String getPartofspeech() {
         return partofspeech;
     }

    public void setAudio(String audio) {
         this.audio = audio;
     }
     public String getAudio() {
         return audio;
     }

    public void setPhrases(List<Phrases> phrases) {
         this.phrases = phrases;
     }
     public List<Phrases> getPhrases() {
         return phrases;
     }

    public void setForms(List<Forms> forms) {
         this.forms = forms;
     }
     public List<Forms> getForms() {
         return forms;
     }

}