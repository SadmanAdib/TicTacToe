package sample;

import javafx.scene.control.Button;

public class ButtonJob {

    public void disableBoxButtons(Controller controller) {
        for (Button[] innerArray : controller.buttons)
        {
            for (Button val : innerArray)
            {
                val.setMouseTransparent(true);
            }
        }
    }

    public void enableBoxButtons(Controller controller) {
        for (Button[] innerArray : controller.buttons)
        {
            for (Button val : innerArray)
            {
                val.setMouseTransparent(false);
            }
        }
    }

    public void resetButtonText(Controller controller) {
        for (Button[] innerArray : controller.buttons)
        {
            for (Button val : innerArray)
            {
                val.setText("");
            }
        }
    }

    // Only for HighContrast Theme
    public void resetButtonColor(Controller controller) {
        for (Button[] innerArray : controller.buttons)
        {
            for (Button val : innerArray)
            {
                val.setStyle("-fx-opacity: 1.0;-fx-background-color: darkgray;");
            }
        }
    }
}
