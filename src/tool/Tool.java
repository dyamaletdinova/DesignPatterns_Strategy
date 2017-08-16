 package tool;

import java.awt.event.MouseEvent;

public interface Tool {
	void mousePressed(MouseEvent e);
	void mouseReleased(MouseEvent e);
	void mouseDragged(MouseEvent e);
	
}
