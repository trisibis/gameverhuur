package sample;

import java.time.LocalDate;

public class GameGegevens {
    //attributen
    private double prijs = 7.50;
    private String gnaam;
    private String console;
    private LocalDate uitleenDatum;
    private LocalDate retourDatum;

    public GameGegevens(String gnaam, String console, LocalDate uitleenDatum, LocalDate retourDatum,double prijs) {
        this.prijs = prijs;
        this.gnaam = gnaam;
        this.console = console;
        this.uitleenDatum = uitleenDatum;
        this.retourDatum = retourDatum;
    }

    //Getters
    public double getPrijs() {
        return prijs;
    }

    public String getGnaam() {
        return gnaam;
    }

    public String getConsole() {
        return console;
    }

    public LocalDate getUitleenDatum() {
        return uitleenDatum;
    }

    public LocalDate getRetourDatum() {
        return retourDatum;
    }

    //Setters
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setGnaam(String gnaam) {
        this.gnaam = gnaam;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public void setUitleenDatum(LocalDate uitleenDatum) {
        this.uitleenDatum = uitleenDatum;
    }

    public void setRetourDatum(LocalDate retourDatum) {
        this.retourDatum = retourDatum;
    }

    @Override
    public String toString() {
        return "Game: " + gnaam + "\n" + "Console: " + console + "\n" + "Uitleendatum: " + uitleenDatum + "\n" + "Terugbrengdatum: " + retourDatum + "\n";
    }
}
