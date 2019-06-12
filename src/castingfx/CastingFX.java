package castingfx;

/**
*
* @author Sandro Souza
*/
import java.awt.BorderLayout;
import java.awt.Dimension;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javax.swing.JApplet;
import javax.swing.JFrame;
import view.Login;


public class CastingFX extends JApplet {

    JFXPanel panel;
    public static Pane body = new Pane();
    public static JFrame frameContent;

    public CastingFX(JFrame frame) {
        frameContent = frame;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(1040, 768));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Novo Casting Agenciamento");

        JApplet t = new CastingFX(frame);
        t.init();

        frame.setContentPane(t.getContentPane());
        t.start();


    }

    @Override
    public void init() {

        panel = new JFXPanel();
        panel.setPreferredSize(new Dimension(1024, 768));

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                startLayout();
            }
        });


        add(panel, BorderLayout.CENTER);
    }

    public void startLayout() {

        Login login = new Login(1024, 730, body, frameContent);

        body.getChildren().add(login);
        Scene scene = new Scene(body);

        panel.setScene(scene);


    }
}
