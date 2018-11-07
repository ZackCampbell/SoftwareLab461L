package observer3;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;
import java.util.Observer;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener {
    public ComplementaryColorPanel(Color initialColor) {
        super(initialColor);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        float newHue;
        if (evt.getPropertyName().equals("hue")) {
            newHue = (float)evt.getNewValue();
        } else {
            JSlider slider = (JSlider)evt.getSource();
            newHue = (float)slider.getValue()/100;
        }
        float complementaryHue = newHue - (float) 0.5;
        if (complementaryHue < 0) {
            complementaryHue = complementaryHue + 1;
        }
        Color complementaryColor = Color.getHSBColor(complementaryHue, super.newSaturation, super.newBrightness);
        this.setColor(complementaryColor);
    }

    @Override
    public void update(Observable o, Object arg) {
        float[] sliderVals = (float[])arg;
        newSaturation = sliderVals[1];
        newBrightness = sliderVals[2];
    }
}
