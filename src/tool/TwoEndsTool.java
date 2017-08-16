package tool;


import java.awt.Graphics;

import java.awt.event.MouseEvent;

import canvas.ScribbleCanvas;
import client.Lab1;
import shape.LineShape;
import shape.OvalShape;
import shape.RectShape;

public class TwoEndsTool implements Tool {

	protected TwoEndsShape currentShape;
	protected Lab1 drawframe;
	protected ScribbleCanvas canvas;
	protected int xStart, yStart;
	protected Graphics onscreen, offscreen;
	protected RectShape rectShape;
	protected OvalShape ovalShape;
	protected LineShape lineShape;

	public TwoEndsTool(ScribbleCanvas canvas) {

		rectShape = new RectShape(canvas);
		ovalShape = new OvalShape(canvas);
		lineShape = new LineShape(canvas);

		currentShape = lineShape;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentShape.drawPoint(e);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		currentShape.drawShape(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		currentShape.drawOutline(e);
	}

	public void setLineShape() {
		this.currentShape = lineShape;
	}

	public void setOvalShape() {
		this.currentShape = ovalShape;
	}

	public void setRectShape() {
		this.currentShape = rectShape;
	}

	public TwoEndsShape getCurrentShape() {
		return currentShape;
	}

}
