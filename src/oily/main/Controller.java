package oily.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Controller {
	private View view;
	private Data data;
	
	public Controller(View view, Data data) {
		this.view = view;
		this.data = data;
		
		this.view.addSegmentListener(new SegmentListener());
		//this.view.setImage(data.getImage());
	}
	
	class SegmentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			BufferedImage image = view.getImage();
			BufferedImage segImage = data.superPixel(image, 200,200); //20,20 for oil
			view.setImage(segImage);
		}
		
	}

}
