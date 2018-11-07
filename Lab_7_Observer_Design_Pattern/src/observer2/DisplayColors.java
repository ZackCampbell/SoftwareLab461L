package observer2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Observable;

public class DisplayColors extends Observable implements ChangeListener{

    public static void main(String[] args) {
	    SwingFacade.launch(new DisplayColors().mainPanel(), "Compute Complementary Colors");
    }

    protected ColorPanel originalColorPanel;
    protected ColorPanel complementaryColorPanel;

    protected JSlider hueSlider;
    protected JSlider saturationSlider;
    protected JSlider brightnessSlider;

    protected JLabel hueValueLabel;
    protected JLabel saturationValueLabel;
    protected JLabel brightnessValueLabel;

    protected JPanel colorsPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(1,2));
        originalColorPanel = createColorPanel(Color.getHSBColor(0,(float).5,(float).5), "original");
        p.add(SwingFacade.createTitledPanel("Original Color", originalColorPanel));
        complementaryColorPanel = createColorPanel(Color.getHSBColor((float).5, (float).5, (float).5), "complementary");
        p.add(SwingFacade.createTitledPanel("Complementary Color", complementaryColorPanel));
        return p;
    }

    protected JPanel mainPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,1));
        JPanel colorsPanel = colorsPanel();
        JPanel subP = new JPanel();
        subP.setLayout(new GridLayout(3,1));
        hueSlider = slider();
        subP.add(sliderBox("H", hueSlider, hueValueLabel));
        saturationSlider = slider();
        saturationSlider.setValue(50);
        subP.add(sliderBox("S", saturationSlider, saturationValueLabel));
        brightnessSlider = slider();
        brightnessSlider.setValue(50);
        subP.add(sliderBox("B", brightnessSlider, brightnessValueLabel));
        p.add(subP);
        p.add(colorsPanel);
        return p;
    }

    private JSlider slider(){
        JSlider slider = new JSlider();
        slider.addChangeListener(this);
        slider.setValue(slider.getMinimum());
        return slider;
    }

    private Box sliderBox(String sliderLabel, JSlider slider, JLabel valueLabel){
        if(valueLabel == null){
            valueLabel = new JLabel();
            valueLabel.setFont(SwingFacade.getStandardFont());
            valueLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            valueLabel.setForeground(Color.black);
        }
        Box b = Box. createHorizontalBox();
        JLabel label = new JLabel(sliderLabel);
        label.setFont(SwingFacade.getStandardFont());
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        label.setForeground(Color.black);
        b.add(label);
        b.add(valueLabel);
        b.add(slider);
        b.setPreferredSize(new Dimension(600, 50));
        return b;
    }

    protected ColorPanel createColorPanel(Color initialColor, String type){
        ColorPanel colorPanel;
        switch (type) {
            case "original":
                colorPanel = new OriginalColorPanel(initialColor);
                break;
            case "complementary":
                colorPanel = new ComplementaryColorPanel(initialColor);
                break;
            default:
                colorPanel = new OriginalColorPanel(initialColor);
                break;
        }

        colorPanel.setPreferredSize(new Dimension(300, 200));
        addObserver(colorPanel);
        return colorPanel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (hueSlider != null && saturationSlider != null && brightnessSlider != null) {
            float[] sliderVals = new float[3];
            sliderVals[0] = (float)hueSlider.getValue()/100;
            sliderVals[1] = (float)saturationSlider.getValue()/100;
            sliderVals[2] = (float)brightnessSlider.getValue()/100;
            setChanged();
            notifyObservers(sliderVals);
        }
    }

}
    
