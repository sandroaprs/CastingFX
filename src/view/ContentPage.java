
package view;

import java.awt.Dimension;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javax.swing.JFrame;
import model.Usuario;
import view.layout.Header;
import view.layout.Menu;

public class ContentPage extends Pane {

    private JFrame frame;
    private ImageView logoImgV;
    public static Menu menu;
    private Pane faixaRodapePane;
    private Label rodapeLabel;
    public static ScrollPane pageScroll;
    public static  Pane page = new Pane();

    public ContentPage(int width, int height) {

        this.setId("contentPage");
        this.setPrefHeight(height);
        this.setPrefWidth(width);
        this.getStylesheets().add("style/default.css");
        //castingfx.CastingFX.frameContent.setSize(new Dimension(width, height));

        //------------------------------------------------------------

        Header header1 = new Header(width);
        this.getChildren().add(header1);

        //------------------------------------------------------------


        Image img = new Image("img/logo2.png");
        logoImgV = new ImageView(img);
        logoImgV.setFitHeight(60);
        logoImgV.setFitWidth(246);
        logoImgV.setLayoutX(20);
        logoImgV.setLayoutY(50);

        this.getChildren().add(logoImgV);


        //------------------------------------------------


        faixaRodapePane = new Pane();
        faixaRodapePane.setId("faixaRodapePane");
        faixaRodapePane.setPrefHeight(30);
        faixaRodapePane.setPrefWidth(width);
        faixaRodapePane.setOpacity(0.30);
        faixaRodapePane.setLayoutX(0);
        faixaRodapePane.setLayoutY(height - 50);

        this.getChildren().add(faixaRodapePane);

        //------------------------------------------------

        rodapeLabel = new Label("©2013 Novo Casting Todos Direitos Reservados");
        rodapeLabel.setTextFill(Color.WHITE);
        rodapeLabel.setFont(new Font("arial", 16));
        rodapeLabel.setLayoutX(width - 400);
        rodapeLabel.setLayoutY(height - 43);

        this.getChildren().add(rodapeLabel);


        //------------------------------------------------

        
        

        pageScroll = new ScrollPane();
        pageScroll.setContent(page);
        pageScroll.setPrefWidth(width);
        pageScroll.setPrefHeight(490);
        pageScroll.setLayoutY(180);

        this.getChildren().add(pageScroll);

        //------------------------------------------------

        menu = new Menu();
        menu.setPrefWidth(width);
        menu.setPrefHeight(35);
        menu.setId("menu");
        menu.setLayoutY(130);

        this.getChildren().add(menu);

        //------------------------------------------------------------    

    }
}
