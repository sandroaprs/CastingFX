package view.layout;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.ContentPage;
import static view.ContentPage.page;
import view.pages.ArtistaPage;

/**
*
* @author Sandro Souza
*/

public class Menu extends Pane {

    public static double auxL = 0;
    public static double marginL = 143;
    public static ItemMenu homeMenu;
    public static ItemMenu artistasMenu;
    public static ItemMenu jobsMenu;
    public static ItemMenu clientesMenu;
    public static ItemMenu referenciasMenu;
    public static ItemMenu usuariosMenu;
    private final Node page = null;

    public void callPage(final int page) {

        Menu.homeMenu.setSelected(false);
        Menu.artistasMenu.setSelected(false);
        Menu.clientesMenu.setSelected(false);
        Menu.jobsMenu.setSelected(false);
        Menu.referenciasMenu.setSelected(false);
        Menu.usuariosMenu.setSelected(false);





        if (page == 1) {
            Menu.homeMenu.setSelected(true);
        } else if (page == 2) {
            Menu.artistasMenu.setSelected(true);
        } else if (page == 3) {
            Menu.jobsMenu.setSelected(true);
        } else if (page == 4) {
            Menu.clientesMenu.setSelected(true);
        } else if (page == 5) {
            Menu.referenciasMenu.setSelected(true);
        } else if (page == 6) {
            Menu.usuariosMenu.setSelected(true);
        }

        ContentPage.pageScroll.setOpacity(1);
        Timeline efeito = new Timeline();

        efeito.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(ContentPage.pageScroll.opacityProperty(), 0)));
        efeito.getKeyFrames().add(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                new Timeline(new KeyFrame(Duration.millis(500),
                        new KeyValue(ContentPage.pageScroll.opacityProperty(), 1))).play();


                ContentPage.page.getChildren().clear();
                Pane pagina = null;

                if (page == 1) {
                    pagina = new Pane();
                } else if (page == 2) {
                    pagina = new ArtistaPage();
                } else if (page == 3) {
                    pagina = new Pane();
                } else if (page == 4) {
                    pagina = new Pane();
                } else if (page == 5) {
                    pagina = new Pane();
                } else if (page == 6) {
                    pagina = new Pane();
                }

                ContentPage.page.getChildren().add(pagina);

            }
        }));

        efeito.play();

    }

    public void paginacao(final Node node, double tempoExibicao, final double timeEf) {

        Timeline show = new Timeline();


        node.setOpacity(0);

        show.getKeyFrames().add(new KeyFrame(Duration.seconds(timeEf),
                new KeyValue(node.opacityProperty(), 1)));

        Timeline hide = new Timeline();

        show.getKeyFrames().add(new KeyFrame(Duration.seconds(tempoExibicao + timeEf),
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                new Timeline(new KeyFrame(Duration.seconds(timeEf),
                        new KeyValue(node.opacityProperty(), 0))).play();
            }
        }));

        show.play();
        hide.play();

    }

    public Menu() {



        //-----------------------------

        homeMenu = new ItemMenu("Home", 100, 35);

        this.getChildren().add(homeMenu);

        //-----------------------------

        artistasMenu = new ItemMenu("Artistas", 130, 35);

        this.getChildren().add(artistasMenu);

        //----------------------------- 

        jobsMenu = new ItemMenu("Jobs", 100, 35);
        this.getChildren().add(jobsMenu);

        //----------------------------- 

        clientesMenu = new ItemMenu("Clientes", 130, 35);
        this.getChildren().add(clientesMenu);

        //----------------------------- 

        referenciasMenu = new ItemMenu("Referências", 130, 35);
        this.getChildren().add(referenciasMenu);

        //----------------------------- 

        usuariosMenu = new ItemMenu("Usuários", 130, 35);
        this.getChildren().add(usuariosMenu);

        //----------------------------- 




        //actions-------------------------------------------------------------

        homeMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                callPage(1);
            }
        });
        callPage(1);

        artistasMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                callPage(2);
            }
        });

        jobsMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                callPage(3);
            }
        });
        clientesMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                callPage(4);
            }
        });
        referenciasMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                callPage(5);
            }
        });
        usuariosMenu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                callPage(6);
            }
        });

    }
}
