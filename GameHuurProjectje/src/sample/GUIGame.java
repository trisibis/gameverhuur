package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class GUIGame {


    //startprijs
    private double totaalPrijs = 0.00;
    //prijs per game
    private double prijs = 7.50;

    public GUIGame(Stage primaryStage){

        //Overkoppelende borderpane bouwen
        BorderPane main = new BorderPane();

        //Titel van dit scherm
        Label title = new Label("Game Huren");

        //layout GridPane
        GridPane root = new GridPane();

        //Nog een gridPane waar de knoppen in komen onder elkaar
        GridPane knoppen = new GridPane();

        //Nog een gridPane waar de textareas komen
        GridPane textAreas = new GridPane();

        //ArrayList waar die de games opsla
        ArrayList<GameGegevens> games = new ArrayList<>();

        //Labels, textfields, localdates en buttons
        Label lbgNaam = new Label("Naam Game:");
        Label lbconsolePc = new Label("PC:");
        Label lbconsoleXbox = new Label("Xbox:");
        Label lbconsolePs4 = new Label("PS4:");
        Label lbUDatum = new Label("Uitleendatum:");
        Label lbRDatum = new Label("Retourdatum:");

        //Textfield voor de naam van de game
        TextField txtgNaam = new TextField();
        //RadioButtons voor de consoles
        RadioButton rbPC = new RadioButton();
        RadioButton rbXbox = new RadioButton();
        RadioButton rbPs4 = new RadioButton();
        //ToggleGroup zodat er maar een geselecteerd kan worden
        ToggleGroup consoles = new ToggleGroup();
        //Radiobuttons toevoegen aan de togglegroup
        rbPC.setToggleGroup(consoles);
        rbXbox.setToggleGroup(consoles);
        rbPs4.setToggleGroup(consoles);

        //Datepickers voor de datums
        DatePicker dpUd = new DatePicker();
        DatePicker dpRd = new DatePicker();

        //Button om op te slaan en een button om gegevens in te zien welke games geregistreerd zijn
        Button btnOpslaan = new Button("Huren");
        //Button om het overzicht te zien wat een persoon gehuurd heeft
        Button btnOverzicht = new Button("Huuroverzicht");
        // Button om de titels van de gehuurde games te kunnen inzien
        Button btnGames = new Button("Alle gehuurde games");
        //Buttons om de overzichten leeg te maken
        Button btnClearHuuroverzicht = new Button("Clear Huuroverzicht");
        Button btnClearGehuurdeGames = new Button("Clear GamesOverzicht");
        //Button om terug te gaan naar personenregistratie
        Button btnPersoon = new Button("Registratie Persoon");

        //TextArea waar ik de gegevens van de hoeveelheid games neerzet en wat de eindprijs is.
        TextArea gameOverzicht = new TextArea();
        //TextArea waar ik de games toon die verhuurd zijn.
        TextArea gehuurdeGamesOverzicht = new TextArea();

        //Alle elementen vastmaken aan de gridpane
        root.add(lbgNaam,0,0);
        root.add(lbconsolePc,0,1);
        root.add(lbconsoleXbox,0,2);
        root.add(lbconsolePs4,0,3);
        root.add(lbUDatum,0,4);
        root.add(lbRDatum,0,5);

        root.add(txtgNaam,1,0);
        root.add(rbPC,1,1);
        root.add(rbXbox,1,2);
        root.add(rbPs4,1,3);
        root.add(dpUd,1,4);
        root.add(dpRd,1,5);
        root.add(btnOpslaan,1,6);



        //TextArea
        textAreas.add(gameOverzicht,0,0);
        textAreas.add(gehuurdeGamesOverzicht,0,1);

        //Knoppen
        knoppen.add(btnOverzicht,0,0);
        knoppen.add(btnGames,0,1);
        knoppen.add(btnClearHuuroverzicht,0,2);
        knoppen.add(btnClearGehuurdeGames,0,3);
        knoppen.add(btnPersoon,0,5);

        //Styling op de knop Persoon
        btnPersoon.setPadding(new Insets(20,0,20,0));

        //Neerzetten van gegevens in de borderpane
        main.setTop(title);
        main.setCenter(root);
        main.setRight(knoppen);
        main.setBottom(textAreas);

        //Styling van de elementen
        main.setAlignment(title, Pos.TOP_CENTER);
        //Padding van titel
        title.setPadding(new Insets(50,0,0,0));
        //Styling label lettertype
        title.setFont(Font.font("arial", FontWeight.BOLD,30));

        //Centraliseer gridpane root
        root.setAlignment(Pos.CENTER);
        //Ruimte creeren tussen onderdelen
        root.setVgap(10);
        root.setHgap(10);

        //Ruimte creeren tussen onderdelen in knoppen
        knoppen.setHgap(10);
        knoppen.setVgap(10);

        //Alle knoppen even groot maken
        btnGames.setMinWidth(200);
        btnClearGehuurdeGames.setMinWidth(200);
        btnClearHuuroverzicht.setMinWidth(200);
        btnOverzicht.setMinWidth(200);

        //Textarea even groot naast elkaar zetten
        gameOverzicht.setPrefSize(600,200);
        gehuurdeGamesOverzicht.setPrefSize(600,200);
        //Ruimte tussen de textareas voegen
        textAreas.setVgap(20);
        textAreas.setHgap(20);
        //Positioneren van textarea
        textAreas.setAlignment(Pos.CENTER);
        //Padding aan de onderkant van het laagste textarea voegen
        textAreas.setPadding(new Insets(20,0,50,0));






        //Gegevens uit de onderdelen halen na klikken op de knop en een overzicht maken van de games die die persoon gehuurd heeft dit is een andere knop
        btnOpslaan.setOnAction(e->{


            //if statement om te kunnen bepalen welke data is ingevoerd door de gebruiker
            if(rbPC.isSelected()){
                //Waardes uit de textfields en Localdates
                String wGnaam = txtgNaam.getText();
                String pc = "PC";
                LocalDate uitlenen = dpUd.getValue();
                LocalDate terugbrengen = dpRd.getValue();


                //Nieuw Game object aanmaken waar de data inzit
                GameGegevens game = new GameGegevens(wGnaam,pc,uitlenen,terugbrengen,prijs);

                //Object toevoegen aan lijst
                games.add(game);


            }
            else if(rbXbox.isSelected()){
                //Waardes uit de textfields en Localdates
                String wGnaam = txtgNaam.getText();
                String xbox = "Xbox";
                LocalDate uitlenen = dpUd.getValue();
                LocalDate terugbrengen = dpRd.getValue();

                //Nieuw Game object aanmaken waar de data inzit
                GameGegevens game = new GameGegevens(wGnaam,xbox,uitlenen,terugbrengen,prijs);

                //Object toevoegen aan lijst
                games.add(game);

            }
            else if(rbPs4.isSelected()){
                //Waardes uit de textfields en Localdates
                String wGnaam = txtgNaam.getText();
                String ps4 = "Ps4";
                LocalDate uitlenen = dpUd.getValue();
                LocalDate terugbrengen = dpRd.getValue();

                //Nieuw Game object aanmaken waar de data inzit
                GameGegevens game = new GameGegevens(wGnaam,ps4,uitlenen,terugbrengen,prijs);

                //Object toevoegen aan lijst
                games.add(game);

            }
        });


        //Button die string gaat vormen met alle informatie die in een Gamegegevens object zit
        btnOverzicht.setOnAction(d-> {
            //Eerst leegmaken
            gameOverzicht.setText("");

            //Elk item in lijst games doorlopen en elke object te displayen op de string die beneden gevormd wordt
            games.forEach(g->{

                String glijst = "Game: " + g.getGnaam() + "\n" + "Console: " + g.getConsole() + "\n" + "Uitleendatum: " + g.getUitleenDatum() + "\n" + "Terugbrengdatum: " + g.getRetourDatum();

                //totaalprijs maken en die vermedigvuldingen met hoeveel items er in de arraylist zitten
                totaalPrijs = g.getPrijs() * games.size();

                //Hier vind een typecasting plaats totaalprijs is een double en wordt gedisplayed in een String.
               gameOverzicht.setText(gameOverzicht.getText() + glijst + " | " + "Totaalprijs: €" + totaalPrijs + "\n" + "\n");

            });

        });

        //Deze button selecteert alle game titels en zet deze neer in gamesoverzicht
        btnGames.setOnAction(a->{
            //leeg maken van textarea
            gehuurdeGamesOverzicht.clear();

            //for loop om door de lijst heen te lopen
            for (GameGegevens e : games){
                String var = e.getGnaam();
                System.out.println(var);
                gehuurdeGamesOverzicht.setText(gehuurdeGamesOverzicht.getText() + var + "\n");
            }
        });

        //Dit is een button die ervoor zorgt dat het huuroverzicht wordt leeg gejaald
        btnClearHuuroverzicht.setOnAction(r->{
            gameOverzicht.setText("");
        });

        //Dit is een button die ervoor zorgt dat het overzicht van games leeg wordt gehaald
        btnClearGehuurdeGames.setOnAction(r->{
            gehuurdeGamesOverzicht.setText("");
        });

        //Terug naar het personen registratie formulier
        btnPersoon.setOnAction(h->{
            new GUIReserveren(primaryStage);
        });



        //Naam applicatie staat bovenin de balk van het venster
        primaryStage.setTitle("Game Huren");
        //Nieuwe scene object aanmaken en de grote meegeven
        primaryStage.setScene(new Scene(main, 800, 800));
        //De stage/scene laten zien
        primaryStage.show();

    }
}
