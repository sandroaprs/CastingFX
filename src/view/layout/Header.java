package view.layout;

import castingfx.CastingFX;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Usuario;
import view.Login;

/**
*
* @author Sandro Souza
*/
public class Header extends Pane {
    
    private Pane faixaHeader;
    private Label emailLb;
    private Label saudacaoLb;
    private Label sairLb;
    
    
    private void sairLbMoved(){
        sairLb.setTextFill(Color.web("#d9043e"));
        sairLb.setCursor(Cursor.HAND);
    }
    private void sairLbExited(){
        sairLb.setTextFill(Color.web("#ffffff"));
    }
    private void sairLbClicked(){
        
        Login login = new Login(1024,730,CastingFX.body,CastingFX.frameContent);
        
        Login.parent.getChildren().remove(0);
        Login.parent.getChildren().add(login);
        
        Login.user = null;
        Menu.auxL = 0;
        
    }
    
    
    
    public Header(double width){
        
        this.setPrefWidth(width);
        this.setPrefHeight(50);
        
        
        //-------------------------------------------------
        
        faixaHeader = new Pane();
        faixaHeader.setId("faixaHeader1");
        faixaHeader.setPrefHeight(28);
        faixaHeader.setPrefWidth(width);
        faixaHeader.setOpacity(0.30);
        faixaHeader.setLayoutX(0);
        faixaHeader.setLayoutY(5);

        this.getChildren().add(faixaHeader);
        
        //-------------------------------------------------
        
        saudacaoLb = new Label("Bem Vindo Sr(a) " + Login.user.getNome());
        saudacaoLb.setTextFill(Color.WHITE);
        saudacaoLb.setFont(new Font("arial",14));
        saudacaoLb.setLayoutX(20);
        saudacaoLb.setLayoutY(10);
        
        this.getChildren().add(saudacaoLb);
        
        //--------------------------------------------------
        
        emailLb = new Label(Login.user.getEmail());
        emailLb.setTextFill(Color.WHITE);
        emailLb.setFont(new Font("arial",14));
        emailLb.setLayoutX(700);
        emailLb.setLayoutY(10);
        
        //this.getChildren().add(emailLb);
        
        
        //--------------------------------------------------
        
        sairLb = new Label("Sair");
        sairLb.setTextFill(Color.web("#ffffff"));
        sairLb.setFont(new Font("arial",14));
        sairLb.setLayoutX(960);
        sairLb.setLayoutY(10);
        
        this.getChildren().add(sairLb);
        
        //--------------------------------------------------
        
        
        //actions ------------------------------------------
        
        sairLb.setOnMouseMoved(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                sairLbMoved();
            }
            
        });
        
        sairLb.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                sairLbExited();
            }
            
        });
        
        sairLb.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                sairLbClicked();
            }
            
        });
        
        
        //-------------------------------------------------
        
        
    }
    
    
    
}
