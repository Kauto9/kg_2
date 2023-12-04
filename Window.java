import javax.swing.*;

import java.awt.*;

import static java.lang.Math.abs;

public class Window extends JFrame {
    public void paint(Graphics G) {
        G.setColor(Color.BLACK);
        G.fillRect(0,0,1000,1000);
        int x0 = 500;
        int x1 = 1000;
        int y0 = 500;
        int y1 = 1000;
        int deltax = abs(x1 - x0);
        int deltay = abs(y1 - y0);
        int y = y0;
        int diry = y1 - y0;
        int error = 0;
        double ratio=0;
        int deltaerr = (deltay + 1);
        if (x0 > x1) {
            int vrem = x0;
            x0 = x1;
            x1 = vrem;
        }

        if (diry > 0) {
            diry = 1;
        }
        if (diry < 0) {
            diry = -1;
        }
        for (int x = x0; x <= x1; x++) {
            Color Color = interpolateColor(java.awt.Color.red, java.awt.Color.blue, ratio);
            G.setColor(Color);
            ratio+=1/((x1-x)+0.00000000001);
            G.drawOval(x, y, 1, 1);
            error = error + deltaerr;
            if (error >= (deltaerr + 1)) {
                y += diry;
                error -= (deltax + 1);
            }
        }
    }
    public static Color interpolateColor(Color startColor, Color endColor, double ratio) {

        if (ratio < 0.0) ratio = 0.0;
        if (ratio > 1.0) ratio = 1.0;

        int red = (int) (startColor.getRed() + ratio * (endColor.getRed() - startColor.getRed()));
        int green = (int) (startColor.getGreen() + ratio * (endColor.getGreen() - startColor.getGreen()));
        int blue = (int) (startColor.getBlue() + ratio * (endColor.getBlue() - startColor.getBlue()));

        return new Color(red, green, blue);
    }
}
