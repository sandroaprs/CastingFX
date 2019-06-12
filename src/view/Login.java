package view;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.Usuario;
import javafx.stage.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Login extends Pane {

    private Label tituloLabel;
    private Label titulo2Label;
    private Label senhaLabel;
    private Label loginLabel;
    private Label rodapeLabel;
    private TextField loginInput;
    private PasswordField senhaInput;
    private ImageView logoImgV;
    private Button entrarBt;
    private Pane faixaRodapePane;
    public static Pane parent = null;
    public static Usuario user;
    private JFrame frame;

    private void entrarBtAction() {

        Conexao cn = new Conexao();
        String msg = "";

        try {
            cn.conectar();


            String login = loginInput.getText();
            String senha = senhaInput.getText();

            user = UsuarioDAO.ralizarLogin(login, senha, cn.getSt());

            if (user == null) {
                msg = "UsuÃ¡rio e/ou Senha invÃ¡lido(s)!";
            } else if (user.getStaus() == '2') {
                msg = "UsuÃ¡rio estÃ¡ bloqueado";
            } else if (user.getStaus() == '1') {
                msg = "true";
            } else {
                msg = "status nÃ£o cadastrado!";
            }

            if (msg.equals("true")) {

                ContentPage cpage = new ContentPage(1024, 730);

                
                this.parent.getChildren().remove(0);
                this.parent.getChildren().add(cpage);


            } else {
                JOptionPane.showMessageDialog(null, msg);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cn.desconectar();
        }


    }

    public Login(double width, double height, Pane body, JFrame frame) {

        this.frame = frame;
        this.parent = body;
        this.setId("loginPane");
        this.setPrefWidth(width);
        this.setPrefHeight(height);
        this.getStylesheets().add("style/login.css");

        //------------------------------------------------

        tituloLabel = new Label("Painel Administrativo");
        tituloLabel.setFont(new Font("arial", 27.9));
        tituloLabel.setTextFill(Color.WHITE);
        tituloLabel.setLayoutX(650);
        tituloLabel.setLayoutY(150);
        this.getChildren().add(tituloLabel);

        //------------------------------------------------

        titulo2Label = new Label("Ã�rea Restrita");
        titulo2Label.setFont(new Font("arial", 16));
        titulo2Label.setTextFill(Color.WHITE);
        titulo2Label.setLayoutX(650);
        titulo2Label.setLayoutY(185);

        this.getChildren().add(titulo2Label);

        //------------------------------------------------

        loginLabel = new Label("Digite seu usuÃ¡rio:");
        loginLabel.setFont(new Font("arial", 16));
        loginLabel.setTextFill(Color.WHITE);
        loginLabel.setLayoutX(650);
        loginLabel.setLayoutY(250);

        this.getChildren().add(loginLabel);

        //------------------------------------------------

        senhaLabel = new Label("Digite sua senha:");
        senhaLabel.setFont(new Font("arial", 16));
        senhaLabel.setTextFill(Color.WHITE);
        senhaLabel.setLayoutX(650);
        senhaLabel.setLayoutY(320);

        this.getChildren().add(senhaLabel);


        //------------------------------------------------

        loginInput = new TextField();
        loginInput.setPrefWidth(260);
        loginInput.setPrefHeight(30);
        loginInput.setLayoutX(650);
        loginInput.setLayoutY(270);

        this.getChildren().add(loginInput);


        //------------------------------------------------

        senhaInput = new PasswordField();
        senhaInput.setPrefWidth(260);
        senhaInput.setPrefHeight(30);
        senhaInput.setLayoutX(650);
        senhaInput.setLayoutY(340);

        this.getChildren().add(senhaInput);


        //------------------------------------------------

        Image img = new Image("img/logo.png");
        logoImgV = new ImageView(img);
        logoImgV.setFitHeight(183);
        logoImgV.setFitWidth(350);
        logoImgV.setLayoutX(120);
        logoImgV.setLayoutY(150);

        this.getChildren().add(logoImgV);


        //------------------------------------------------


        entrarBt = new Button("Entrar");
        entrarBt.setPrefWidth(100);
        entrarBt.setPrefHeight(30);
        entrarBt.setLayoutX(810);
        entrarBt.setLayoutY(400);
        entrarBt.setFont(new Font("arial", 16));

        this.getChildren().add(entrarBt);

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

        rodapeLabel = new Label("Â©2013 Novo Casting Todos Direitos Reservados");
        rodapeLabel.setTextFill(Color.WHITE);
        rodapeLabel.setFont(new Font("arial", 16));
        rodapeLabel.setLayoutX(width - 400);
        rodapeLabel.setLayoutY(height - 43);

        this.getChildren().add(rodapeLabel);


        //actions --------------------------------------------------------------


        entrarBt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                entrarBtAction();

            }
        });

        //----------------------------------------------------------------------

    }
}
