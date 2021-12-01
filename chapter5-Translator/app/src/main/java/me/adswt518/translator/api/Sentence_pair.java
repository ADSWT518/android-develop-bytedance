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
public class Sentence_pair {

    private String sentence;

    @SerializedName("sentence-eng")
    private String sentence_eng;

    @SerializedName("sentence-translation")
    private String sentence_translation;

    @SerializedName("speech-size")
    private String speech_size;

    @SerializedName("aligned-words")
    private Aligned_words aligned_words;
    private String source;
    private String url;

    @SerializedName("sentence-speech")
    private String sentence_speech;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence_eng() {
        return sentence_eng;
    }

    public void setSentence_eng(String sentence_eng) {
        this.sentence_eng = sentence_eng;
    }

    public String getSentence_translation() {
        return sentence_translation;
    }

    public void setSentence_translation(String sentence_translation) {
        this.sentence_translation = sentence_translation;
    }

    public String getSpeech_size() {
        return speech_size;
    }

    public void setSpeech_size(String speech_size) {
        this.speech_size = speech_size;
    }

    public Aligned_words getAligned_words() {
        return aligned_words;
    }

    public void setAligned_words(Aligned_words aligned_words) {
        this.aligned_words = aligned_words;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSentence_speech() {
        return sentence_speech;
    }

    public void setSentence_speech(String sentence_speech) {
        this.sentence_speech = sentence_speech;
    }
}