package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import canvas.ScribbleCanvas;
import tool.TwoEndsShape;

public class OvalShape implements TwoEndsShape {

	protected ScribbleCanvas canvas;
	protected int xStart, yStart;
	protected Graphics onscreen, offscreen;

	public OvalShape(ScribbleCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void drawShape(MouseEvent e) {
		Point p = e.getPoint();
        canvas.mouseButtonDown = false; 
        onscreen.setPaintMode();
        offscreen = canvas.getOffScreenGraphics(); 
        offscreen.drawOval(xStart, yStart, p.x-xStart+1, p.y-yStart+1); 
        canvas.repaint(); 
	}

	@Override
	public void drawOutline(MouseEvent e) {
		Point p = e.getPoint();
		if (canvas.mouseButtonDown) {
            onscreen.drawOval(xStart, yStart, canvas.x - xStart + 1, canvas.y - yStart + 1); 
            onscreen.drawOval(xStart, yStart, p.x - xStart + 1, p.y - yStart + 1);  
        }
        canvas.x = p.x; 
        canvas.y = p.y; 
	}

	@Override
	public void drawPoint(MouseEvent e) {
		Point p = e.getPoint();
		canvas.mouseButtonDown = true;
        xStart = canvas.x = p.x; 
        yStart = canvas.y = p.y; 
        onscreen = canvas.getGraphics();
        onscreen.setXORMode(Color.darkGray); 
        onscreen.setColor(Color.lightGray); 
       
        onscreen.drawOval(xStart, yStart, 1, 1); 
		
	}

}
