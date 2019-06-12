package view.layout;

/**
*
* @author Sandro Souza
*/

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import view.ContentPage;

public class ItemMenu extends Pane {

    private final Label texto;
    private final Pane fundo = new Pane();
    private boolean selected = false;

    public void setSelected(boolean selected) {

        if (selected) {
            texto.setTextFill(Color.web("#fff"));
            fundo.setStyle("-fx-background-color:#0095cc");
            fundo.setCursor(Cursor.HAND);
        } else {
            texto.setTextFill(Color.web("#000"));
            fundo.setStyle("-fx-background-color:#fff");
        }

        this.selected = selected;
    }

    public ItemMenu(String titulo, double width, double height) {

        this.texto = new Label(titulo);
        this.texto.setFont(new Font("arial", 20));
        this.texto.setTextFill(Color.web("#000"));

        this.texto.setPrefWidth(width);
        this.texto.setPrefHeight(height);
        this.texto.setAlignment(Pos.CENTER);


        //-----------------------------------------------


        fundo.setPrefHeight(height);
        fundo.setPrefWidth(width);
        fundo.setStyle("-fx-background-color:#fff");
        fundo.getChildren().add(this.texto);



        //-----------------------------------------------                  

        this.getChildren().add(fundo);

        if (Menu.auxL == 0) {
            this.setLayoutX(Menu.marginL);
            Menu.auxL += Menu.marginL + width;
        } else {
            this.setLayoutX(Menu.auxL);
            Menu.auxL += width;
        }



        //acoes ------------------------------------------------------
        this.setOnMouseEntered(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                texto.setTextFill(Color.web("#fff"));
                fundo.setStyle("-fx-background-color:#0095cc");
                fundo.setCursor(Cursor.HAND);
            }
        });

        this.setOnMouseExited(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {

                if (!selected) {
                    texto.setTextFill(Color.web("#000"));
                    fundo.setStyle("-fx-background-color:#fff");
                }
            }
        });

        //----------------------------------------------------------



    }
}
