package view.pages;

import dao.Conexao;
import dao.ReferenciaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Referencia;

/**
 *
 * @author Sandro Souza
 */
public class ArtistaPage extends Pane {

    Accordion accordion;
    Label alturaMin;
    Slider sliderMin;
    Label alturaMax;
    Slider sliderMax;
    Label pesoMin;
    Slider sliderMinPeso;
    Label pesoMax;
    Slider sliderMaxPeso;
    Label ombroMin;
    Slider sliderMinOmbro;
    Label ombroMax;
    Slider sliderMaxOmbro;
    Label bustoMin;
    Slider sliderMinBusto;
    Label bustoMax;
    Slider sliderMaxBusto;
    Label quadrilMin;
    Slider sliderMinQuadril;
    Label quadrilMax;
    Slider sliderMaxQuadril;
    Label cinturaMin;
    Slider sliderMinCintura;
    Label cinturaMax;
    Slider sliderMaxCintura;
    Label toraxMin;
    Slider sliderMinTorax;
    Label toraxMax;
    Slider sliderMaxTorax;
    Label camisaMin;
    Slider sliderMinCamisa;
    Label camisaMax;
    Slider sliderMaxCamisa;
    Label calcaMin;
    Slider sliderMinCalca;
    Label calcaMax;
    Slider sliderMaxCalca;

    Label ternoMin;
    Slider sliderMinTerno;
    Label ternoMax;
    Slider sliderMaxTerno;
    
    Label sapatoMin;
    Slider sliderMinSapato;
    Label sapatoMax;
    Slider sliderMaxSapato;
        
    
    public ArtistaPage() {

        Conexao cn = new Conexao();

        // ------------------------------------------------

        Pane bioTipoPane = new Pane();
        VBox bioTipoBox = new VBox();

        bioTipoBox.setSpacing(5);
        bioTipoBox.setLayoutX(20);

        try {
            cn.conectar();

            ArrayList<Referencia> rfList = ReferenciaDAO.getReferencia(Referencia.REF_TIPO_FISICO, cn.getSt());


            for (int i = 0; i < rfList.size(); i++) {

                CheckBox cb = new CheckBox(rfList.get(i).getDescricao());
                cb.setId(rfList.get(i).getIdReferencia() + "");
                cb.setIndeterminate(false);
                cb.setSelected(true);

                bioTipoBox.getChildren().add(cb);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.desconectar();
        }
        bioTipoPane.getChildren().addAll(bioTipoBox);

        TitledPane bioTipo = new TitledPane("Tipo Físico", bioTipoPane);

        // ------------------------------------------------



        Pane alturaPane = new Pane();
        VBox alturaBox = new VBox();

        alturaBox.setSpacing(5);
        alturaBox.setLayoutX(20);

        alturaMin = new Label("Mínima - 0");
        alturaBox.getChildren().add(alturaMin);

        sliderMin = new Slider();
        sliderMin.setMin(0);
        sliderMin.setMax(3.0);
        sliderMin.setValue(0);
        sliderMin.setShowTickLabels(true);
        sliderMin.setShowTickMarks(true);
        sliderMin.setMajorTickUnit(3);
        sliderMin.setMinorTickCount(0);
        sliderMin.setBlockIncrement(0.01);



        sliderMin.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                alturaMin.setText("Mínima - " + String.format("%.2f", sliderMin.getValue()));
            }
        });

        alturaBox.getChildren().add(sliderMin);

        alturaMax = new Label("Máxima - 3,0");
        alturaBox.getChildren().add(alturaMax);

        sliderMax = new Slider();
        sliderMax.setMin(0);
        sliderMax.setMax(3.0);
        sliderMax.setValue(3);
        sliderMax.setShowTickLabels(true);
        sliderMax.setShowTickMarks(true);
        sliderMax.setMajorTickUnit(3);
        sliderMax.setMinorTickCount(0);
        sliderMax.setBlockIncrement(0.01);



        sliderMax.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                alturaMax.setText("Máxima - " + String.format("%.2f", sliderMax.getValue()));
            }
        });


        alturaBox.getChildren().add(sliderMax);



        alturaPane.getChildren().addAll(alturaBox);

        TitledPane altura = new TitledPane("Altura", alturaPane);

        // ------------------------------------------------



        Pane pesoPane = new Pane();
        VBox pesoBox = new VBox();

        pesoBox.setSpacing(5);
        pesoBox.setLayoutX(20);

        pesoMin = new Label("Mínimo - 0");
        pesoBox.getChildren().add(pesoMin);

        sliderMinPeso = new Slider();
        sliderMinPeso.setMin(0);
        sliderMinPeso.setMax(200);
        sliderMinPeso.setValue(0);
        sliderMinPeso.setShowTickLabels(true);
        sliderMinPeso.setShowTickMarks(true);
        sliderMinPeso.setMajorTickUnit(15);
        sliderMinPeso.setMinorTickCount(0);
        sliderMinPeso.setBlockIncrement(1);



        sliderMinPeso.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                pesoMin.setText("Mínimo - " + String.format("%.2f", sliderMinPeso.getValue()));
            }
        });

        pesoBox.getChildren().add(sliderMinPeso);

        pesoMax = new Label("Máximo - 200");
        pesoBox.getChildren().add(pesoMax);

        sliderMaxPeso = new Slider();
        sliderMaxPeso.setMin(0);
        sliderMaxPeso.setMax(200);
        sliderMaxPeso.setValue(200);
        sliderMaxPeso.setShowTickLabels(true);
        sliderMaxPeso.setShowTickMarks(true);
        sliderMaxPeso.setMajorTickUnit(15);
        sliderMaxPeso.setMinorTickCount(0);
        sliderMaxPeso.setBlockIncrement(1);



        sliderMaxPeso.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                pesoMax.setText("Máximo - " + String.format("%.2f", sliderMaxPeso.getValue()));
            }
        });


        pesoBox.getChildren().add(sliderMaxPeso);



        pesoPane.getChildren().addAll(pesoBox);

        TitledPane peso = new TitledPane("Peso", pesoPane);

        // ------------------------------------------------



        Pane ombroPane = new Pane();
        VBox ombroBox = new VBox();

        ombroBox.setSpacing(5);
        ombroBox.setLayoutX(20);

        ombroMin = new Label("Mínimo - 0");
        ombroBox.getChildren().add(ombroMin);

        sliderMinOmbro = new Slider();
        sliderMinOmbro.setMin(0);
        sliderMinOmbro.setMax(1);
        sliderMinOmbro.setValue(0);
        sliderMinOmbro.setShowTickLabels(true);
        sliderMinOmbro.setShowTickMarks(true);
        sliderMinOmbro.setMajorTickUnit(1);
        sliderMinOmbro.setMinorTickCount(0);
        sliderMinOmbro.setBlockIncrement(0.01);



        sliderMinOmbro.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                ombroMin.setText("Mínimo - " + String.format("%.2f", sliderMinOmbro.getValue()));
            }
        });

        ombroBox.getChildren().add(sliderMinOmbro);

        ombroMax = new Label("Máximo - 1,0");
        ombroBox.getChildren().add(ombroMax);

        sliderMaxOmbro = new Slider();
        sliderMaxOmbro.setMin(0);
        sliderMaxOmbro.setMax(1);
        sliderMaxOmbro.setValue(1);
        sliderMaxOmbro.setShowTickLabels(true);
        sliderMaxOmbro.setShowTickMarks(true);
        sliderMaxOmbro.setMajorTickUnit(1);
        sliderMaxOmbro.setMinorTickCount(0);
        sliderMaxOmbro.setBlockIncrement(0.01);



        sliderMaxOmbro.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                ombroMax.setText("Máximo - " + String.format("%.2f", sliderMaxOmbro.getValue()));
            }
        });


        ombroBox.getChildren().add(sliderMaxOmbro);



        ombroPane.getChildren().addAll(ombroBox);

        TitledPane ombro = new TitledPane("Ombro", ombroPane);

        // ------------------------------------------------




        Pane bustoPane = new Pane();
        VBox bustoBox = new VBox();

        bustoBox.setSpacing(5);
        bustoBox.setLayoutX(20);

        bustoMin = new Label("Mínimo - 0");
        bustoBox.getChildren().add(bustoMin);

        sliderMinBusto = new Slider();
        sliderMinBusto.setMin(0);
        sliderMinBusto.setMax(1);
        sliderMinBusto.setValue(0);
        sliderMinBusto.setShowTickLabels(true);
        sliderMinBusto.setShowTickMarks(true);
        sliderMinBusto.setMajorTickUnit(1);
        sliderMinBusto.setMinorTickCount(0);
        sliderMinBusto.setBlockIncrement(0.01);



        sliderMinBusto.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                bustoMin.setText("Mínimo - " + String.format("%.2f", sliderMinBusto.getValue()));
            }
        });

        bustoBox.getChildren().add(sliderMinBusto);

        bustoMax = new Label("Máximo - 1,5");
        bustoBox.getChildren().add(bustoMax);

        sliderMaxBusto = new Slider();
        sliderMaxBusto.setMin(0);
        sliderMaxBusto.setMax(1.5);
        sliderMaxBusto.setValue(1.5);
        sliderMaxBusto.setShowTickLabels(true);
        sliderMaxBusto.setShowTickMarks(true);
        sliderMaxBusto.setMajorTickUnit(1.5);
        sliderMaxBusto.setMinorTickCount(0);
        sliderMaxBusto.setBlockIncrement(0.01);



        sliderMaxBusto.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                bustoMax.setText("Máximo - " + String.format("%.2f", sliderMaxBusto.getValue()));
            }
        });


        bustoBox.getChildren().add(sliderMaxBusto);



        bustoPane.getChildren().addAll(bustoBox);

        TitledPane busto = new TitledPane("Busto", bustoPane);

        // ------------------------------------------------





        Pane camisaPane = new Pane();
        VBox camisaBox = new VBox();

        camisaBox.setSpacing(5);
        camisaBox.setLayoutX(20);

        camisaMin = new Label("Mínimo - 0");
        camisaBox.getChildren().add(camisaMin);

        sliderMinCamisa = new Slider();
        sliderMinCamisa.setMin(0);
        sliderMinCamisa.setMax(10);
        sliderMinCamisa.setValue(0);
        sliderMinCamisa.setShowTickLabels(true);
        sliderMinCamisa.setShowTickMarks(true);
        sliderMinCamisa.setMajorTickUnit(1);
        sliderMinCamisa.setMinorTickCount(0);
        sliderMinCamisa.setBlockIncrement(1);



        sliderMinCamisa.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                camisaMin.setText("Mínimo - " + String.format("%.2f", sliderMinCamisa.getValue()));
            }
        });

        camisaBox.getChildren().add(sliderMinCamisa);

        camisaMax = new Label("Máximo - 10");
        camisaBox.getChildren().add(camisaMax);

        sliderMaxCamisa = new Slider();
        sliderMaxCamisa.setMin(0);
        sliderMaxCamisa.setMax(10);
        sliderMaxCamisa.setValue(10);
        sliderMaxCamisa.setShowTickLabels(true);
        sliderMaxCamisa.setShowTickMarks(true);
        sliderMaxCamisa.setMajorTickUnit(1);
        sliderMaxCamisa.setMinorTickCount(0);
        sliderMaxCamisa.setBlockIncrement(1);



        sliderMaxCamisa.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                camisaMax.setText("Máximo - " + String.format("%.2f", sliderMaxCamisa.getValue()));
            }
        });


        camisaBox.getChildren().add(sliderMaxCamisa);



        camisaPane.getChildren().addAll(camisaBox);

        TitledPane camisa = new TitledPane("Camisa", camisaPane);

        
        // ------------------------------------------------





        Pane calcaPane = new Pane();
        VBox calcaBox = new VBox();

        calcaBox.setSpacing(5);
        calcaBox.setLayoutX(20);

        calcaMin = new Label("Mínimo - 0");
        calcaBox.getChildren().add(calcaMin);

        sliderMinCalca = new Slider();
        sliderMinCalca.setMin(0);
        sliderMinCalca.setMax(70);
        sliderMinCalca.setValue(0);
        sliderMinCalca.setShowTickLabels(true);
        sliderMinCalca.setShowTickMarks(true);
        sliderMinCalca.setMajorTickUnit(5);
        sliderMinCalca.setMinorTickCount(0);
        sliderMinCalca.setBlockIncrement(1);



        sliderMinCalca.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                calcaMin.setText("Mínimo - " + String.format("%.2f", sliderMinCalca.getValue()));
            }
        });

        calcaBox.getChildren().add(sliderMinCalca);

        calcaMax = new Label("Máximo - 70");
        calcaBox.getChildren().add(calcaMax);

        sliderMaxCalca = new Slider();
        sliderMaxCalca.setMin(0);
        sliderMaxCalca.setMax(70);
        sliderMaxCalca.setValue(70);
        sliderMaxCalca.setShowTickLabels(true);
        sliderMaxCalca.setShowTickMarks(true);
        sliderMaxCalca.setMajorTickUnit(5);
        sliderMaxCalca.setMinorTickCount(0);
        sliderMaxCalca.setBlockIncrement(1);



        sliderMaxCalca.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                calcaMax.setText("Máximo - " + String.format("%.2f", sliderMaxCalca.getValue()));
            }
        });


        calcaBox.getChildren().add(sliderMaxCalca);



        calcaPane.getChildren().addAll(calcaBox);

        TitledPane calca = new TitledPane("Calça", calcaPane);
        
        // ------------------------------------------------



        Pane ternoPane = new Pane();
        VBox ternoBox = new VBox();

        ternoBox.setSpacing(5);
        ternoBox.setLayoutX(20);

        ternoMin = new Label("Mínimo - 0");
        ternoBox.getChildren().add(ternoMin);

        sliderMinTerno = new Slider();
        sliderMinTerno.setMin(0);
        sliderMinTerno.setMax(70);
        sliderMinTerno.setValue(0);
        sliderMinTerno.setShowTickLabels(true);
        sliderMinTerno.setShowTickMarks(true);
        sliderMinTerno.setMajorTickUnit(5);
        sliderMinTerno.setMinorTickCount(0);
        sliderMinTerno.setBlockIncrement(1);



        sliderMinTerno.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                ternoMin.setText("Mínimo - " + String.format("%.2f", sliderMinTerno.getValue()));
            }
        });

        ternoBox.getChildren().add(sliderMinTerno);

        ternoMax = new Label("Máximo - 70");
        ternoBox.getChildren().add(ternoMax);

        sliderMaxTerno = new Slider();
        sliderMaxTerno.setMin(0);
        sliderMaxTerno.setMax(70);
        sliderMaxTerno.setValue(70);
        sliderMaxTerno.setShowTickLabels(true);
        sliderMaxTerno.setShowTickMarks(true);
        sliderMaxTerno.setMajorTickUnit(5);
        sliderMaxTerno.setMinorTickCount(0);
        sliderMaxTerno.setBlockIncrement(1);



        sliderMaxTerno.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                ternoMax.setText("Máximo - " + String.format("%.2f", sliderMaxTerno.getValue()));
            }
        });


        ternoBox.getChildren().add(sliderMaxTerno);



        ternoPane.getChildren().addAll(ternoBox);

        TitledPane terno = new TitledPane("Terno", ternoPane);
        
        // ------------------------------------------------        



        Pane sapatoPane = new Pane();
        VBox sapatoBox = new VBox();

        sapatoBox.setSpacing(5);
        sapatoBox.setLayoutX(20);

        sapatoMin = new Label("Mínimo - 0");
        sapatoBox.getChildren().add(sapatoMin);

        sliderMinSapato = new Slider();
        sliderMinSapato.setMin(0);
        sliderMinSapato.setMax(70);
        sliderMinSapato.setValue(0);
        sliderMinSapato.setShowTickLabels(true);
        sliderMinSapato.setShowTickMarks(true);
        sliderMinSapato.setMajorTickUnit(5);
        sliderMinSapato.setMinorTickCount(0);
        sliderMinSapato.setBlockIncrement(1);



        sliderMinSapato.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                sapatoMin.setText("Mínimo - " + String.format("%.2f", sliderMinSapato.getValue()));
            }
        });

        sapatoBox.getChildren().add(sliderMinSapato);

        sapatoMax = new Label("Máximo - 70");
        sapatoBox.getChildren().add(sapatoMax);

        sliderMaxSapato = new Slider();
        sliderMaxSapato.setMin(0);
        sliderMaxSapato.setMax(70);
        sliderMaxSapato.setValue(70);
        sliderMaxSapato.setShowTickLabels(true);
        sliderMaxSapato.setShowTickMarks(true);
        sliderMaxSapato.setMajorTickUnit(5);
        sliderMaxSapato.setMinorTickCount(0);
        sliderMaxSapato.setBlockIncrement(1);



        sliderMaxSapato.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                sapatoMax.setText("Máximo - " + String.format("%.2f", sliderMaxSapato.getValue()));
            }
        });


        sapatoBox.getChildren().add(sliderMaxSapato);



        sapatoPane.getChildren().addAll(sapatoBox);

        TitledPane sapato = new TitledPane("Sapato", sapatoPane);
        
        // ------------------------------------------------                
        
        Pane toraxPane = new Pane();
        VBox toraxBox = new VBox();

        toraxBox.setSpacing(5);
        toraxBox.setLayoutX(20);

        toraxMin = new Label("Mínimo - 0");
        toraxBox.getChildren().add(toraxMin);

        sliderMinTorax = new Slider();
        sliderMinTorax.setMin(0);
        sliderMinTorax.setMax(1);
        sliderMinTorax.setValue(0);
        sliderMinTorax.setShowTickLabels(true);
        sliderMinTorax.setShowTickMarks(true);
        sliderMinTorax.setMajorTickUnit(1);
        sliderMinTorax.setMinorTickCount(0);
        sliderMinTorax.setBlockIncrement(0.01);



        sliderMinTorax.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                toraxMin.setText("Mínimo - " + String.format("%.2f", sliderMinTorax.getValue()));
            }
        });

        toraxBox.getChildren().add(sliderMinTorax);

        toraxMax = new Label("Máximo - 1,5");
        toraxBox.getChildren().add(toraxMax);

        sliderMaxTorax = new Slider();
        sliderMaxTorax.setMin(0);
        sliderMaxTorax.setMax(1.5);
        sliderMaxTorax.setValue(1.5);
        sliderMaxTorax.setShowTickLabels(true);
        sliderMaxTorax.setShowTickMarks(true);
        sliderMaxTorax.setMajorTickUnit(1.5);
        sliderMaxTorax.setMinorTickCount(0);
        sliderMaxTorax.setBlockIncrement(0.01);



        sliderMaxTorax.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                toraxMax.setText("Máximo - " + String.format("%.2f", sliderMaxTorax.getValue()));
            }
        });


        toraxBox.getChildren().add(sliderMaxTorax);



        toraxPane.getChildren().addAll(toraxBox);

        TitledPane torax = new TitledPane("Torax", toraxPane);

        // ------------------------------------------------

        Pane cinturaPane = new Pane();
        VBox cinturaBox = new VBox();

        cinturaBox.setSpacing(5);
        cinturaBox.setLayoutX(20);

        cinturaMin = new Label("Mínimo - 0");
        cinturaBox.getChildren().add(cinturaMin);

        sliderMinCintura = new Slider();
        sliderMinCintura.setMin(0);
        sliderMinCintura.setMax(1);
        sliderMinCintura.setValue(0);
        sliderMinCintura.setShowTickLabels(true);
        sliderMinCintura.setShowTickMarks(true);
        sliderMinCintura.setMajorTickUnit(1);
        sliderMinCintura.setMinorTickCount(0);
        sliderMinCintura.setBlockIncrement(0.01);



        sliderMinCintura.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                cinturaMin.setText("Mínimo - " + String.format("%.2f", sliderMinCintura.getValue()));
            }
        });

        cinturaBox.getChildren().add(sliderMinCintura);

        cinturaMax = new Label("Máximo - 1,5");
        cinturaBox.getChildren().add(cinturaMax);

        sliderMaxCintura = new Slider();
        sliderMaxCintura.setMin(0);
        sliderMaxCintura.setMax(1.5);
        sliderMaxCintura.setValue(1.5);
        sliderMaxCintura.setShowTickLabels(true);
        sliderMaxCintura.setShowTickMarks(true);
        sliderMaxCintura.setMajorTickUnit(1.5);
        sliderMaxCintura.setMinorTickCount(0);
        sliderMaxCintura.setBlockIncrement(0.01);



        sliderMaxCintura.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                cinturaMax.setText("Máximo - " + String.format("%.2f", sliderMaxCintura.getValue()));
            }
        });


        cinturaBox.getChildren().add(sliderMaxCintura);



        cinturaPane.getChildren().addAll(cinturaBox);

        TitledPane cintura = new TitledPane("Cintura", cinturaPane);

        // ------------------------------------------------


        Pane quadrilPane = new Pane();
        VBox quadrilBox = new VBox();

        quadrilBox.setSpacing(5);
        quadrilBox.setLayoutX(20);

        quadrilMin = new Label("Mínimo - 0");
        quadrilBox.getChildren().add(quadrilMin);

        sliderMinQuadril = new Slider();
        sliderMinQuadril.setMin(0);
        sliderMinQuadril.setMax(1);
        sliderMinQuadril.setValue(0);
        sliderMinQuadril.setShowTickLabels(true);
        sliderMinQuadril.setShowTickMarks(true);
        sliderMinQuadril.setMajorTickUnit(1);
        sliderMinQuadril.setMinorTickCount(0);
        sliderMinQuadril.setBlockIncrement(0.01);



        sliderMinQuadril.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                quadrilMin.setText("Mínimo - " + String.format("%.2f", sliderMinQuadril.getValue()));
            }
        });

        quadrilBox.getChildren().add(sliderMinQuadril);

        quadrilMax = new Label("Máximo - 1,5");
        quadrilBox.getChildren().add(quadrilMax);

        sliderMaxQuadril = new Slider();
        sliderMaxQuadril.setMin(0);
        sliderMaxQuadril.setMax(1.5);
        sliderMaxQuadril.setValue(1.5);
        sliderMaxQuadril.setShowTickLabels(true);
        sliderMaxQuadril.setShowTickMarks(true);
        sliderMaxQuadril.setMajorTickUnit(1.5);
        sliderMaxQuadril.setMinorTickCount(0);
        sliderMaxQuadril.setBlockIncrement(0.01);



        sliderMaxQuadril.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
                quadrilMax.setText("Máximo - " + String.format("%.2f", sliderMaxQuadril.getValue()));
            }
        });


        quadrilBox.getChildren().add(sliderMaxQuadril);



        quadrilPane.getChildren().addAll(quadrilBox);

        TitledPane quadril = new TitledPane("Quadril", quadrilPane);


        //----------------------------------------------------------------------



        Pane cabeloPane = new Pane();
        VBox cabeloBox = new VBox();

        cabeloBox.setSpacing(5);
        cabeloBox.setLayoutX(20);

        try {
            cn.conectar();

            ArrayList<Referencia> rfList = ReferenciaDAO.getReferencia(Referencia.REF_COR_CABELO, cn.getSt());


            for (int i = 0; i < rfList.size(); i++) {

                CheckBox cb = new CheckBox(rfList.get(i).getDescricao());
                cb.setId(rfList.get(i).getIdReferencia() + "");
                cb.setIndeterminate(false);
                cb.setSelected(true);

                cabeloBox.getChildren().add(cb);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.desconectar();
        }
        cabeloPane.getChildren().addAll(cabeloBox);

        TitledPane corCabelo = new TitledPane("Cor de Cabelo", cabeloPane);

        // ------------------------------------------------



        Pane cabeloEstiloPane = new Pane();
        VBox cabeloEstiloBox = new VBox();

        cabeloEstiloBox.setSpacing(5);
        cabeloEstiloBox.setLayoutX(20);

        try {
            cn.conectar();

            ArrayList<Referencia> rfList = ReferenciaDAO.getReferencia(Referencia.REF_TIPO_CABELO, cn.getSt());


            for (int i = 0; i < rfList.size(); i++) {

                CheckBox cb = new CheckBox(rfList.get(i).getDescricao());
                cb.setId(rfList.get(i).getIdReferencia() + "");
                cb.setIndeterminate(false);
                cb.setSelected(true);

                cabeloEstiloBox.getChildren().add(cb);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.desconectar();
        }
        cabeloEstiloPane.getChildren().addAll(cabeloEstiloBox);

        TitledPane corCabeloEstilo = new TitledPane("Estilo de Cabelo", cabeloEstiloPane);

        // ------------------------------------------------



        Pane olhosPane = new Pane();
        VBox olhosBox = new VBox();

        olhosBox.setSpacing(5);
        olhosBox.setLayoutX(20);

        try {
            cn.conectar();

            ArrayList<Referencia> rfList = ReferenciaDAO.getReferencia(Referencia.REF_COR_OLHOS, cn.getSt());


            for (int i = 0; i < rfList.size(); i++) {

                CheckBox cb = new CheckBox(rfList.get(i).getDescricao());
                cb.setId(rfList.get(i).getIdReferencia() + "");
                cb.setIndeterminate(false);
                cb.setSelected(true);

                olhosBox.getChildren().add(cb);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.desconectar();
        }
        olhosPane.getChildren().addAll(olhosBox);

        TitledPane olhos = new TitledPane("Cor dos Olhos", olhosPane);

        // ------------------------------------------------



        Pane dentesPane = new Pane();
        VBox dentesBox = new VBox();

        dentesBox.setSpacing(5);
        dentesBox.setLayoutX(20);

        try {
            cn.conectar();

            ArrayList<Referencia> rfList = ReferenciaDAO.getReferencia(Referencia.REF_DENTES, cn.getSt());


            for (int i = 0; i < rfList.size(); i++) {

                CheckBox cb = new CheckBox(rfList.get(i).getDescricao());
                cb.setId(rfList.get(i).getIdReferencia() + "");
                cb.setIndeterminate(false);
                cb.setSelected(true);

                dentesBox.getChildren().add(cb);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cn.desconectar();
        }
        dentesPane.getChildren().addAll(dentesBox);

        TitledPane dentes = new TitledPane("Dentes", dentesPane);

        // ------------------------------------------------

        Pane barbaPane = new Pane();
        VBox barbaBox = new VBox();

        barbaBox.setSpacing(5);
        barbaBox.setLayoutX(20);



        CheckBox cb = new CheckBox("Com Barba");
        cb.setId("chekBarba");
        cb.setIndeterminate(false);
        cb.setSelected(true);

        barbaBox.getChildren().add(cb);


        CheckBox cb2 = new CheckBox("Sem Barba");
        cb2.setId("chekBarba2");
        cb2.setIndeterminate(false);
        cb2.setSelected(true);

        barbaBox.getChildren().add(cb2);



        barbaPane.getChildren().addAll(barbaBox);

        TitledPane barba = new TitledPane("Barba", barbaPane);

        // ------------------------------------------------

        Pane tatuPane = new Pane();
        VBox tatuBox = new VBox();

        tatuBox.setSpacing(5);
        tatuBox.setLayoutX(20);



        CheckBox cb3 = new CheckBox("Com Tatuagem");
        cb3.setId("chekTatu");
        cb3.setIndeterminate(false);
        cb3.setSelected(true);

        tatuBox.getChildren().add(cb3);


        CheckBox cb4 = new CheckBox("Sem Tatuagem");
        cb4.setId("chekTatu2");
        cb4.setIndeterminate(false);
        cb4.setSelected(true);

        tatuBox.getChildren().add(cb4);



        tatuPane.getChildren().addAll(tatuBox);

        TitledPane tatu = new TitledPane("Tatuagem", tatuPane);


        // ------------------------------------------------

        accordion = new Accordion();
        accordion.setPrefWidth(200);
        accordion.getPanes().addAll(
                bioTipo,
                corCabelo,
                altura,
                peso,
                corCabeloEstilo,
                barba,
                olhos,
                dentes,
                tatu,
                ombro,
                busto,
                quadril,
                cintura,
                torax,
                camisa,
                calca,
                terno,
                sapato
                );

        this.getChildren().add(accordion);


    }
}
