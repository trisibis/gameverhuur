package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;

public class GUIReserveren {

    public GUIReserveren(Stage primaryStage){
        //Layout borderpane
        BorderPane mainLayout = new BorderPane();
        //titel borderpane
        Label naamPersoon = new Label("Registratie Klant");

        //MainLayout als GridPane & Arraylist om personen op te slaan
        GridPane main = new GridPane();
        ArrayList<GeregistreerdePersonen> lijst = new ArrayList<>();

        //Onderdelen om gegevens in te vullen
        //Labels, Textfields, DatePicker en Buttons

        Label lbNaam = new Label("Naam:");
        Label lbAdres = new Label("Adres:");
        Label lbPostcode = new Label("Postcode:");
        Label lbWoonplaats = new Label("Woonplaats:");
        Label lbGb = new Label("Geboortedatum:");
        Label lbEmail = new Label("Email:");
        Label lbTel = new Label("Telefoonnummer:");

        TextField txtNaam = new TextField();
        TextField txtAdres = new TextField();
        TextField txtPostcode = new TextField();
        TextField txtWoonplaats = new TextField();
        DatePicker dp = new DatePicker();
        TextField txtEmail = new TextField();
        TextField txtTel = new TextField();

        Button btnRegistreer = new Button("Registreer");


        //Neerzetten van onderdelen in de GridPane
        main.add(lbNaam, 0,0);
        main.add(lbAdres, 0,1);
        main.add(lbPostcode, 0,2);
        main.add(lbWoonplaats, 0,3);
        main.add(lbGb, 0,4);
        main.add(lbEmail, 0,5);
        main.add(lbTel, 0,6);

        main.add(txtNaam, 1,0);
        main.add(txtAdres, 1,1);
        main.add(txtPostcode, 1,2);
        main.add(txtWoonplaats, 1,3);
        main.add(dp, 1,4);
        main.add(txtEmail, 1,5);
        main.add(txtTel, 1,6);
        main.add(btnRegistreer, 1,7);

        //BorderPane invullen met main en met titel
        mainLayout.setCenter(main);
        mainLayout.setTop(naamPersoon);

        //Positionering en styling van layout
        //Positionering van label title op scene
        mainLayout.setAlignment(naamPersoon, Pos.TOP_CENTER);
        //Positionering van gridpane in borderpane
        main.setAlignment(Pos.CENTER);
        //Ruimte tussen de velden in de gridpane
        main.setHgap(10);
        main.setVgap(10);
        //Padding van titel
        naamPersoon.setPadding(new Insets(100,0,-100,0));
        //Styling label lettertype
        naamPersoon.setFont(Font.font("arial", FontWeight.BOLD,50));

        btnRegistreer.setOnAction(e -> {

            //Als de gebruiker iets vergeten in te vullen is kan hij/zij niet verder
            if(txtNaam.getText().equals("") || txtAdres.getText().equals("") || txtPostcode.getText().equals("") || txtWoonplaats.getText().equals("") || dp.getValue() == null || txtEmail.getText().equals("") || txtTel.getText().equals("")) {

                    //Bericht als een waarde niet is ingevuld
                    // Title Pane
                    TilePane r = new TilePane();

                    // create a alert
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Je bent iets vergeten in te vullen");
                    //Messagebox appears
                    a.show();

                    // Return if true so next code won't be executed
                    return;

                }
            else {
                //Event maken als er op de knop wordt gedrukt, hier worden de gegevens uit de textfields gehaald en in variabelen gestopt


                    //Gegevens uit Textfields en datepicker
                    String wNaam = txtNaam.getText();
                    String wAdres = txtAdres.getText();
                    String wPostcode = txtPostcode.getText();
                    String wWoonplaats = txtWoonplaats.getText();
                    LocalDate wGd = dp.getValue();
                    String wEmail = txtEmail.getText();
                    String wTel = txtTel.getText();

                    //Gegevens stop ik in een nieuw object van geregistreerde personen
                    GeregistreerdePersonen pers = new GeregistreerdePersonen(wNaam, wAdres, wPostcode, wWoonplaats, wGd, wEmail, wTel);

                    lijst.add(pers);

                    lijst.size();

                    //Naar GamePagina gaan waar er vervolgens geleend kan worden
                    new GUIGame(primaryStage);



            }
        });


        primaryStage.setTitle("Registratie");
        primaryStage.setScene(new Scene(mainLayout, 800, 800));
        primaryStage.show();

    }
}
