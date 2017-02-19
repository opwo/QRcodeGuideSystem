package com.wt.QRcode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {
	public static boolean  insertImgCreateQRCode(String imgName,String imgPath,String contents,int  sideLength ,String savePath){
		BitMatrix bitMatrix;
		String path = savePath+imgName+".png";
		int width = sideLength;
		int height = width;
		boolean iscode = false;
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.MARGIN, 0);//设置边界值0
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");//设置编码格式
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);//设置错误修正等级为高
		
		try {
			bitMatrix = new QRCodeWriter().encode(contents,BarcodeFormat.QR_CODE, width, height,hints);
			BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
			
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					image.setRGB(x, y, bitMatrix.get(x, y) == true ? Color.BLACK.getRGB():Color.WHITE.getRGB());
				}
			}
			
			//压缩图片
			Image inset_img = ImageIO.read(new File(imgPath));
			int w = inset_img.getWidth(null);
			int h = inset_img.getHeight(null);
			//if(w>sideLength)
				w = sideLength/4;
			//if(h>sideLength) 
				h = sideLength/4;
			Image compress_img = inset_img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			BufferedImage tag = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
			Graphics gr = tag.getGraphics();
			gr.drawImage(compress_img, 0, 0, null);
			gr.dispose();
			inset_img=compress_img;
			
			//插入图片
			Graphics2D graph = image.createGraphics();
			int x = (sideLength-w)/2;
			int y = (sideLength-h)/2;
			graph.drawImage(inset_img, x, y, w, h, null);
			Shape shape = new RoundRectangle2D.Float(x, y, w, w, 6, 6);
			graph.setStroke(new BasicStroke(3f));
			graph.draw(shape);
			graph.dispose();
			
			iscode = ImageIO.write(image,"png", new File(path));
			
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return iscode;
		
	}
}
