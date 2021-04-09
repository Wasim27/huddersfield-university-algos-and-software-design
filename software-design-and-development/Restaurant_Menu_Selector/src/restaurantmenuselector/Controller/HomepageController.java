package restaurantmenuselector.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomepageController implements Initializable {

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/menu.fxml"));
                Parent root1 = (Parent) fxmlLoader.load(); 
                Scene scene = new Scene(root1);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(scene);
                appStage.show();
            }catch(IOException ex) {
                ex.printStackTrace();
            }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
