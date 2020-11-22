package jsilv.app.exerc;

import java.io.Serializable;

public class Word implements Serializable {

    private String txt;
    private String date;

    public Word(String txt, String date){
        this.txt = txt;
        this.date = date;
    }

    public String getTxt() {
        return txt;
    }

    public String getDate() {
        return date;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nText: " + txt  ;
    }

}
