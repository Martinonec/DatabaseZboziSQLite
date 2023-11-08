/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.elektrosqlitedatabase;

/**
 *
 * @author nitra
 */
public class DataModel {
    int id;
    String nazev;
    String znacka;
    int mnozstvi;
    int cenaNakup;
    int cenaProdej;
    
    public DataModel(int id, String nazev, String znacka, int mnozstvi, int cenaNakup, int cenaProdej){
        this.id = id;
        this.nazev = nazev;
        this.znacka = znacka;
        this.mnozstvi = mnozstvi;
        this.cenaNakup = cenaNakup;
        this.cenaProdej = cenaProdej;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public int getMnozstvi() {
        return mnozstvi;
    }

    public void setMnozstvi(int mnozstvi) {
        this.mnozstvi = mnozstvi;
    }

    public int getCenaNakup() {
        return cenaNakup;
    }

    public void setCenaNakup(int cenaNakup) {
        this.cenaNakup = cenaNakup;
    }

    public int getCenaProdej() {
        return cenaProdej;
    }

    public void setCenaProdej(int cenaProdej) {
        this.cenaProdej = cenaProdej;
    }
    
}
