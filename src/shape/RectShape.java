 package shape;

import java.awt.*;
import java.awt.event.MouseEvent;

import canvas.ScribbleCanvas;
import tool.TwoEndsShape;


public class RectShape implements TwoEndsShape{

	protected ScribbleCanvas canvas;
	protected int xStart, yStart;
	protected Graphics onscreen, offscreen;
	
	public RectShape(ScribbleCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void drawShape(MouseEvent e) {
		Point p = e.getPoint(); 
        canvas.mouseButtonDown = false; 
        onscreen.setPaintMode();
        offscreen = canvas.getOffScreenGraphics(); 
        offscreen.drawRect(xStart, yStart, p.x-xStart+1, p.y-yStart+1); 
        canvas.repaint(); 
	}

	@Override
	public void drawOutline(MouseEvent e) {
		 Point p = e.getPoint(); 
         if (canvas.mouseButtonDown) {
             onscreen.drawRect(xStart, yStart, canvas.x - xStart + 1, canvas.y - yStart + 1);  
             onscreen.drawRect(xStart, yStart, p.x - xStart + 1, p.y - yStart + 1); 
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
        onscreen.drawRect(xStart, yStart, 1, 1); 	
	}

}
