package observer2;

import java.awt.*;
import java.util.Observable;

public class ComplementaryColorPanel extends ColorPanel {


    public ComplementaryColorPanel(Color initalColor) {
        super(initalColor);
    }

    @Override
    public void update(Observable o, Object arg) {
        float[] sliderVals = (float[])arg;
        float newHue = sliderVals[0];
        float newSaturation = sliderVals[1];
        float newBrightness = sliderVals[2];
        float complementaryHue = newHue - (float)0.5;
        if(complementaryHue < 0){
            complementaryHue = complementaryHue + 1;
        }
        Color complementaryColor = Color.getHSBColor(complementaryHue, newSaturation, newBrightness);
        this.setColor(complementaryColor);
    }
}
