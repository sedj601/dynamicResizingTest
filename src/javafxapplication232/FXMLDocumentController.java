/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication232;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    HBox hBox;
    @FXML
    SplitPane splitPane;
    @FXML
    AnchorPane anchorPane2;

    @FXML
    StackPane sp1, sp2, sp3, sp4;

    double orgX, orgY;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        double panesStartingWidths = 200;
        double hboxTotalWidth = 800;
        AtomicBoolean initialMove = new AtomicBoolean(true);

        SplitPane.Divider divider = splitPane.getDividers().get(0);

        divider.positionProperty().addListener((obs, oldValue, newValue) -> {
            System.out.println("oldValue: " + oldValue.doubleValue() + " newValue: " + newValue);
            //anchorPane2.setMinWidth(anchorPane2.getWidth() - newValue.doubleValue());
            System.out.println(anchorPane2.getWidth() + " :: " + (hboxTotalWidth - 2 * panesStartingWidths));
            if (newValue.doubleValue() > oldValue.doubleValue() && !initialMove.get()) {
                if (anchorPane2.getBoundsInParent().getWidth() <= (hboxTotalWidth - panesStartingWidths)) {
                    sp2.setMinWidth(0);
                    sp1.setPrefWidth(0);
                }
                if (anchorPane2.getBoundsInParent().getWidth() <= (hboxTotalWidth - 2 * panesStartingWidths)) {
                    sp3.setMinWidth(0);
                    sp2.setPrefWidth(0);
                }
                if (anchorPane2.getBoundsInParent().getWidth() <= (hboxTotalWidth - 3 * panesStartingWidths)) {
                    sp4.setMinWidth(0);
                    sp3.setPrefWidth(0);
                }
            }

            initialMove.set(false);
//            else if (newValue.doubleValue() < oldValue.doubleValue()) {
//
//            }
        });

        //anchorPane2.minWidthProperty().bind(sp1.widthProperty().add(sp2.widthProperty()).add(sp3.widthProperty()).add(sp4.widthProperty()));
//        sp1.widthProperty().addListener((observable, oldValue, newValue) -> {
//            System.out.println("setting sp1 to 0 and sp2 to zero");
//            if (newValue.doubleValue() <= 0) {
//                sp2.setMinWidth(0);
//                sp1.setPrefWidth(0);
//
//            }
//        });
//        sp2.widthProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue.doubleValue() <= 0) {
//                sp3.setMinWidth(0);
//                sp2.setPrefWidth(0);
//            }
//        });
//        sp3.widthProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue.doubleValue() <= 0) {
//                sp4.setMinWidth(0);
//                sp3.setPrefWidth(0);
//            }
//        });
    }

}
