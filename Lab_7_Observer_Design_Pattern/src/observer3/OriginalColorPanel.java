package observer3;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.util.Observable;

public class OriginalColorPanel extends ColorPanel {
    public OriginalColorPanel(Color initialColor) {
        super(initialColor);
    }

    @Override
    public void update(Observable o, Object arg) {
        float[] sliderVals = (float[])arg;
        float newHue = sliderVals[0];
        newSaturation = sliderVals[1];
        newBrightness = sliderVals[2];
        Color newColor = Color.getHSBColor(newHue, newSaturation, newBrightness);
        this.setColor(newColor);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
