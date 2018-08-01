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

    double PANE_MIN_WIDTH = 0;
    double PANE_STARTING_WIDTH = 200;
    double PANES_TOTAL_WIDTH = 800;

    AtomicBoolean initialMove = new AtomicBoolean(true);

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        SplitPane.Divider divider = splitPane.getDividers().get(0);

        divider.positionProperty().addListener((obs, oldValue, newValue) -> {
            //System.out.println("oldValue: " + oldValue.doubleValue() + " newValue: " + newValue);
            //System.out.println(anchorPane2.getWidth() + " :: " + (PANES_TOTAL_WIDTH - 2 * PANE_STARTING_WIDTH));

            if (newValue.doubleValue() > oldValue.doubleValue() && !initialMove.get()) {
                if (anchorPane2.getWidth() <= PANES_TOTAL_WIDTH && anchorPane2.getWidth() > PANES_TOTAL_WIDTH - PANE_STARTING_WIDTH) {
                    sp1.setMinWidth(PANE_MIN_WIDTH);
                    sp1.setMaxWidth(anchorPane2.getWidth() - (PANES_TOTAL_WIDTH - PANE_STARTING_WIDTH));
                }
                else if (anchorPane2.getWidth() <= (PANES_TOTAL_WIDTH - PANE_STARTING_WIDTH) && anchorPane2.getWidth() > (PANES_TOTAL_WIDTH - 2 * PANE_STARTING_WIDTH)) {
                    sp2.setMinWidth(PANE_MIN_WIDTH);
                    sp2.setMaxWidth(anchorPane2.getWidth() - (PANES_TOTAL_WIDTH - 2 * PANE_STARTING_WIDTH));
                }
                else if (anchorPane2.getWidth() <= (PANES_TOTAL_WIDTH - 2 * PANE_STARTING_WIDTH) && anchorPane2.getWidth() > (PANES_TOTAL_WIDTH - 3 * PANE_STARTING_WIDTH)) {
                    sp3.setMinWidth(PANE_MIN_WIDTH);
                    sp3.setMaxWidth(anchorPane2.getWidth() - (PANES_TOTAL_WIDTH - 3 * PANE_STARTING_WIDTH));
                }
            }
            else if (newValue.doubleValue() < oldValue.doubleValue()) {
                if (anchorPane2.getWidth() < (PANES_TOTAL_WIDTH - 3 * PANE_STARTING_WIDTH)) {
                    sp4.setMaxWidth(PANE_STARTING_WIDTH);
                    sp4.setMinWidth(anchorPane2.getWidth());
                }
                else if (anchorPane2.getWidth() < (PANES_TOTAL_WIDTH - 2 * PANE_STARTING_WIDTH) && anchorPane2.getWidth() >= (PANES_TOTAL_WIDTH - 3 * PANE_STARTING_WIDTH)) {
                    sp3.setMaxWidth(PANE_STARTING_WIDTH);
                    sp3.setMinWidth(anchorPane2.getWidth() - PANE_STARTING_WIDTH);
                }
                else if (anchorPane2.getWidth() < (PANES_TOTAL_WIDTH - PANE_STARTING_WIDTH) && anchorPane2.getWidth() >= (PANES_TOTAL_WIDTH - 2 * PANE_STARTING_WIDTH)) {
                    sp2.setMaxWidth(PANE_STARTING_WIDTH);
                    sp2.setMinWidth(anchorPane2.getWidth() - 2 * PANE_STARTING_WIDTH);
                }
                else if (anchorPane2.getWidth() <= PANES_TOTAL_WIDTH && anchorPane2.getWidth() >= (PANES_TOTAL_WIDTH - PANE_STARTING_WIDTH)) {
                    sp1.setMaxWidth(PANE_STARTING_WIDTH);
                    sp1.setMinWidth(anchorPane2.getWidth() - 3 * PANE_STARTING_WIDTH);
                }
            }

            initialMove.set(false);//Used becase of the first pass, the AnchorPane's width = 0
        });
    }
}
