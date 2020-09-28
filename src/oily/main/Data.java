package oily.main;


import java.awt.image.BufferedImage;

public class Data {
	private BufferedImage image;
	private Superpixel sp;
	
    public BufferedImage superPixel(BufferedImage originalImage, int cellWidth, int proxMod) {
    	double S = cellWidth; 
        double m = proxMod;
        sp = new Superpixel();
        BufferedImage outImage = sp.calculate(originalImage, S, m);
        
        return outImage;
    }

	public BufferedImage getImage() {
		return image;
	}

}
