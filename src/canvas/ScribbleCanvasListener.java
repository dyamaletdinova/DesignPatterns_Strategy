 package canvas;

import java.awt.*;
import java.awt.event.*;

import client.Lab1;
import tool.Tool;

public class ScribbleCanvasListener 
    implements MouseListener, MouseMotionListener {
        
  protected Lab1 drawframe;
  protected ScribbleCanvas canvas; 
  protected int xStart, yStart; 
  protected Graphics onscreen, offscreen; 

  public ScribbleCanvasListener(ScribbleCanvas canvas, Lab1 drawframe) {
    this.canvas = canvas;
    this.drawframe=drawframe;
  }

  @Override
  public void mouseDragged(MouseEvent e) {
	  Tool currentTool = drawframe.getCurrentTool();
	  currentTool.mouseDragged(e);
  }


  @Override
  public void mousePressed(MouseEvent e) {
	  Tool currentTool = drawframe.getCurrentTool();
	  currentTool.mousePressed(e);
  }


  @Override
  public void mouseReleased(MouseEvent e) {
	  Tool currentTool = drawframe.getCurrentTool();
	  currentTool.mouseReleased(e);
  	
  }  

  public void mouseClicked(MouseEvent e) {}
  public void mouseEntered(MouseEvent e) {}  
  public void mouseExited(MouseEvent e) {}
  public void mouseMoved(MouseEvent e) {}


   

  
}

