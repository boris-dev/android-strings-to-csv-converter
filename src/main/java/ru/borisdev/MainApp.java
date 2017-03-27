package ru.borisdev;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MainApp extends Application {

    private static final Logger log = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void start(final Stage stage) throws Exception {
        log.info("Starting Hello JavaFX and Maven demonstration application");
        VBox vBox = new VBox();
        HBox hBox1 = new HBox();
        final TextField tsvFilePath = new TextField();
        Button fileChooserButton = new Button("Choose tsv file");

        fileChooserButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open tsv File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("All Files", "*.*"),
                        new FileChooser.ExtensionFilter("CSV", "*.csv"),
                        new FileChooser.ExtensionFilter("TSV", "*.tsv")
                );

                File file = fileChooser.showOpenDialog(stage);
                if (file != null) {
                    tsvFilePath.setText(file.getAbsolutePath());
                }
            }
        });


        hBox1.getChildren().addAll(tsvFilePath, fileChooserButton);
        HBox hBox2 = new HBox();
        final TextField resFolderFilePath = new TextField();
        Button resFolderChooserButton = new Button("Choose res folder");
        resFolderChooserButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                DirectoryChooser chooser = new DirectoryChooser();
                chooser.setTitle("Open Resource Folder");
                File file = chooser.showDialog(stage);
                if (file != null) {
                    resFolderFilePath.setText(file.getAbsolutePath());
                }
            }
        });
        hBox2.getChildren().addAll(resFolderFilePath, resFolderChooserButton);
        Button convert = new Button("Convert");

        convert.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                new CsvConverter(tsvFilePath.getText(), resFolderFilePath.getText()).convert();
            }
        });

        vBox.getChildren().addAll(hBox1, hBox2, convert);
        log.debug("Showing JFX scene");
        Scene scene = new Scene(vBox, 400, 200);
        scene.getStylesheets().add("/styles/styles.css");
        stage.setTitle("Android string To CSV Converter");
        stage.setScene(scene);
        stage.show();
    }
}
