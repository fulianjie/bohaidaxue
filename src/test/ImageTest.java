package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		try {
			BufferedImage image = ImageIO.read(new File("/Users/fulianjie0830/Desktop/✈️大战"));
			
			
			assertNotNull(image);
			
			BufferedImage images = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertNotNull(new Object());
		
	}

}
