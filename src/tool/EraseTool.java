package tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import canvas.ScribbleCanvas;

public class EraseTool implements Tool {

	protected ScribbleCanvas canvas;
	protected Graphics onscreen, offscreen;
	protected int xStart, yStart;

	public EraseTool(ScribbleCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		canvas.mouseButtonDown = true;
		canvas.x = p.x;
		canvas.y = p.y;
		offscreen = canvas.getOffScreenGraphics();
		offscreen.setColor(Color.white);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		canvas.mouseButtonDown = false;
		canvas.setPenColor(canvas.penColor);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		if (canvas.mouseButtonDown) {
			int xs, ys, dx, dy;
			xs = Math.min(canvas.x, p.x) - 2;
			ys = Math.min(canvas.y, p.y) - 2;
			dx = Math.abs(p.x - canvas.x) + 6;
			dy = Math.abs(p.y - canvas.y) + 6;
			offscreen.fillRect(xs, ys, dx, dy);
			canvas.repaint(xs, ys, dx, dy);
			canvas.x = p.x;
			canvas.y = p.y;
		}
	}

}
