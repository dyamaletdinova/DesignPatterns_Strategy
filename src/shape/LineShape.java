 package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import canvas.ScribbleCanvas;
import tool.TwoEndsShape;

public class LineShape implements TwoEndsShape{

	protected ScribbleCanvas canvas;
	protected int xStart, yStart;
	protected Graphics onscreen, offscreen;
	
	public LineShape(ScribbleCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void drawShape(MouseEvent e) {
		Point p = e.getPoint(); 
        canvas.mouseButtonDown = false; 
        onscreen.setPaintMode();
        offscreen = canvas.getOffScreenGraphics(); 
        offscreen.drawLine(xStart, yStart, p.x, p.y); 
        canvas.repaint(); 
	}

	@Override
	public void drawOutline(MouseEvent e) {
	    Point p = e.getPoint(); 
	    if (canvas.mouseButtonDown) {
            onscreen.drawLine(xStart, yStart, canvas.x, canvas.y); 
            onscreen.drawLine(xStart, yStart, p.x, p.y);
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
        onscreen.drawLine(xStart, yStart, xStart, yStart); 
	}
}
