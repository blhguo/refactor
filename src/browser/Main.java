package browser;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * A simple HTML browser.
 * 
 * @author Robert C. Duvall
 */
public class Main extends Application {
    // convenience constants
    public static final String TITLE = "NanoBrowser";
    public static final String DEFAULT_START_PAGE = "http://www.cs.duke.edu/rcd";
    public static final String LANGUAGE = "English";

    @Override
    public void start (Stage stage) {
        // create program specific components
        BrowserModel model = new BrowserModel(LANGUAGE);
        BrowserView display = new BrowserView(model, LANGUAGE);
        // give the window a title
        stage.setTitle(TITLE);
        // add our user interface components to Frame and show it
        stage.setScene(display.getScene());
        stage.show();
        // start somewhere, less typing for debugging
        display.showPage(DEFAULT_START_PAGE);
    }

    /**
     * Start of the program.
     */
    public static void main (String[] args) {
        launch(args);
    }
}
