package oily.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class View extends JFrame {

	private JPanel panelBottom;
	private JButton buttonSegment;
	private BufferedImage image;
	private JLabel label;
	private Container contentPane;

	public View() {
		super("View");
		
		try {
			image = ImageIO.read(new File("./res/land.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		buttonSegment = new JButton("Segment");
		panelBottom = new JPanel();
		panelBottom.add(buttonSegment);
		
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		label = new JLabel();
		setImage(image);
		
		contentPane.add(panelBottom, BorderLayout.SOUTH);
		contentPane.add(label, BorderLayout.NORTH);
		
		// JFrame stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); 
	}
	
	void addSegmentListener(ActionListener actList) { 
		buttonSegment.addActionListener(actList);
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		Image displayedImage;
		
		if (image.getHeight() > 800) {
			double ratio = (double)image.getWidth() / image.getHeight();
			displayedImage = this.image.getScaledInstance((int)(800 * ratio), 800, 0);
			setSize((int)(800 * ratio), 800 + 75);
		} else {
			displayedImage = this.image;
			setSize(image.getWidth(), image.getHeight() + 75);
		}
		
		ImageIcon newIcon = new ImageIcon(displayedImage);
		label.setIcon(newIcon);
	}

	public BufferedImage getImage() {
		return image;
	}

	public JButton getButtonSegment() {
		return buttonSegment;
	}

	public void setButtonSegment(JButton buttonSegment) {
		this.buttonSegment = buttonSegment;
	}
}
