package observer3;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observer;

public abstract class ColorPanel extends JPanel implements Observer, PropertyChangeListener {
    private Color color;

    protected float newSaturation;
    protected float newBrightness;

    public ColorPanel(Color initialColor) {
        this.color = initialColor;
    }
    public void setColor(Color newColor) {
        this.color = newColor;
        repaint();
    }
    public Color getColor() {
        return this.color;
    }
    protected void paintComponent(Graphics g) {
        this.setBackground(color);
        super.paintComponent(g);
    }
}