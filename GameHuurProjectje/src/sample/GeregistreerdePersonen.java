package sample;

import java.time.LocalDate;

public class GeregistreerdePersonen {

    //attributen
    private String naam;
    private String adres;
    private String postcode;
    private String woonplaats;
    private LocalDate gb;
    private String email;
    private String tel;

    //Constructor
    public GeregistreerdePersonen(String naam, String adres, String postcode, String woonplaats, LocalDate gb, String email, String tel){
        this.naam = naam;
        this.adres = adres;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.gb = gb;
        this.email = email;
        this.tel = tel;
    }

    //Getters
    public String getNaam() {
        return naam;
    }

    public String getAdres() {
        return adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public LocalDate getGb() {
        return gb;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    //Setters
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setGb(LocalDate gb) {
        this.gb = gb;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
