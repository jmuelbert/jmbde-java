/**
 * The main class of the JavaFX application.
 * This class is responsible for launching the application and managing the main scene.
 */
package de.jmuelbert.jmbde;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

  private static Scene scene;

  /**
   * Starts the JavaFX application and sets the primary scene.
   *
   * This method is called by the JavaFX runtime when the application is launched.
   * It creates a new scene with the "primary" FXML layout and sets the scene on the
   * provided stage. The stage is then shown to display the application.
   *
   * @param stage the primary stage for the application
   * @throws IOException if there is an error loading the FXML layout
   */
  @Override
  public void start(Stage stage) throws IOException {
    scene = new Scene(loadFXML("primary"), 640, 480);
    stage.setScene(scene);
    stage.show();
  }

  /**
   * Sets the root node of the application's scene to the FXML layout specified by the given file name.
   *
   * @param fxml the name of the FXML file to load, without the ".fxml" extension
   * @throws IOException if there is an error loading the FXML layout
   */
  static void setRoot(String fxml) throws IOException {
    scene.setRoot(loadFXML(fxml));
  }

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader =
        new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }

  /**
   * Launches the JavaFX application.
   */
  public static void main(String[] args)
  /**
   * Launches the JavaFX application.
   */
  public static void main(String[] args)
  public static void main(String[] args) { launch(); }
}
