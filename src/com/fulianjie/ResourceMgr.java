package com.fulianjie;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	public static BufferedImage plane,bullet;//tankU,tankD,tankL,tankR;

	static {

		try {
			//tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/fulianjie/images/tankU.gif"));
			//tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/fulianjie/images/tankD.gif"));
			plane = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("feiji/1.png"));
			//tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("com/fulianjie/images/tankR.gif"));
			bullet = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("feiji/2.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
