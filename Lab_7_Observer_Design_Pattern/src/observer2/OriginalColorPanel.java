package observer2;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class OriginalColorPanel extends ColorPanel {
    public OriginalColorPanel(Color initalColor) {
        super(initalColor);
    }

    @Override
    public void update(Observable o, Object arg) {
        float[] sliderVals = (float[])arg;
        float newHue = sliderVals[0];
        float newSaturation = sliderVals[1];
        float newBrightness = sliderVals[2];
        Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
        this.setColor(newColor);
    }
}
