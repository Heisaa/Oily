package oily.main;

import java.awt.BorderLayout;
import java.awt.Container;
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
	private ImageIcon icon;
	private BufferedImage image;
	private JLabel label;

	public View() {
		super("View");
		
		try {
			image = ImageIO.read(new File("./res/landscape.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		buttonSegment = new JButton("Segment");
		panelBottom = new JPanel();
		panelBottom.add(buttonSegment);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		label = new JLabel();
		icon = new ImageIcon(image);
		label.setIcon(icon);
		
		contentPane.add(panelBottom, BorderLayout.SOUTH);
		contentPane.add(label, BorderLayout.NORTH);
		
		// JFrame stuff
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(image.getWidth(), image.getHeight() + 75);
		setLocationRelativeTo(null);
		setVisible(true); 
	}
	
	void addSegmentListener(ActionListener actList) { 
		buttonSegment.addActionListener(actList);
	}

	public void setImage(BufferedImage image) {
		this.image = image;
		ImageIcon newIcon = new ImageIcon(image);
		label.setIcon(newIcon);
		System.out.println(panelBottom.getHeight());
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
