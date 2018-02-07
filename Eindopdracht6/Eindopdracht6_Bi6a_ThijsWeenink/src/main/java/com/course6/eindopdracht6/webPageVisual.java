package com.course6.eindopdracht6;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Thijs Weenink
 * @version 1.0 <br>
 * Code from: <br>
 * <a href="https://javabeat.net/embedding-html-into-java-swing-applications/">Embedding HTML into Java Swing Applications</a><br>
 * Edited for personal use
 */
public class webPageVisual extends JFrame {

    public static void showWebPage(String url) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationFrame mainFrame = new ApplicationFrame();
                mainFrame.webURL = url;
                mainFrame.setVisible(true);
            }
        });

    }
}

/**
 * Main window used to display the webpage
 */
class ApplicationFrame extends JFrame {

    public String webURL;
    JFXPanel javafxPanel;
    WebView webComponent;
    JPanel mainPanel;

    JTextField urlField;
    JButton goButton;

    public ApplicationFrame() {
        super.setTitle("VirusID search");
        
        Image icon = Toolkit.getDefaultToolkit().getImage("D:/gntop2.gif");
        super.setIconImage(icon);
        
        javafxPanel = new JFXPanel();

        initSwingComponents();

        loadJavaFXScene();
    }

    /**
     * Instantiate the Swing compoents to be used
     */
    private void initSwingComponents() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(javafxPanel, BorderLayout.CENTER);

        JPanel urlPanel = new JPanel(new FlowLayout());

        mainPanel.add(urlPanel, BorderLayout.NORTH);

        this.add(mainPanel);
        this.setSize(1250, 700);
        this.setResizable(false);
    }

    /**
     * Instantiate the JavaFX Components in the JavaFX Application Thread.
     */
    private void loadJavaFXScene() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                BorderPane borderPane = new BorderPane();
                webComponent = new WebView();

                webComponent.getEngine().load(webURL);

                borderPane.setCenter(webComponent);
                Scene scene = new Scene(borderPane, 450, 450);
                javafxPanel.setScene(scene);

            }
        });
    }
}
