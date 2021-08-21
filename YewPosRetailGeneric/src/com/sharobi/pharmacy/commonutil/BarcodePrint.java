package com.sharobi.pharmacy.commonutil;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;

import javax.imageio.ImageIO;

class BarcodePrint implements Printable {

	private String path;
	
	public BarcodePrint(String path) {
		super();
		this.path = path;
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		
		if (pageIndex < 0 || pageIndex >= 1) {
			return Printable.NO_SUCH_PAGE;
		}

		try {
			
			Graphics2D g2d = (Graphics2D) graphics;

			int h = 0;
			int w = 0;
			int y=0;
			
			g2d.translate(0, pageFormat.getImageableY());

			File f = new File(this.path + "/images/" + "barcodefinal.png"
			);
			// path
			BufferedImage image = ImageIO.read(f);
			System.out.println("Reading complete.");
			if (image != null) {
				w = image.getWidth();
				h = image.getHeight();
				/*BufferedImage img = new BufferedImage(w, h,
						BufferedImage.TYPE_INT_ARGB); // Graphics2D g2dImage
				img.createGraphics();*/
				//g2d.drawImage(image, 5, 22+y, null);
				String barCode = "1234567890"; //labelInfo.getBarcode();
				if(barCode.length()<=13){
					if(barCode.matches("[0-9]+")){
						g2d.drawImage(image, 5,22+y,w-25, h, null);
					}else{
						g2d.drawImage(image, 5,22+y,w-100, h, null);
					}
				}
			}
			
			g2d.translate(0, pageFormat.getImageableY());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Printable.PAGE_EXISTS;

	}

}