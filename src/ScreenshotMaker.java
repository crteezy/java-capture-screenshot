import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

/**
 * 
 * @author crteezy
 * @since 24-SEP-2019
 *
 */
public class ScreenshotMaker {

	public static void main(String[] args) {

		captureScreenshot();
	}

	private static void captureScreenshot() {
		try {
			Robot robot = new Robot();
			Rectangle area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage bufferedImage = robot.createScreenCapture(area);
			// Try to save the captured image
			try {
				// Create temp folder
				String dir = "C://temp";
				File temp = new File(dir);
				System.out.println("Creating directory '" + dir + "'");
				temp.mkdir();
				System.out.println("Capturing Screenshot...");
				File file = java.io.File.createTempFile("screenshot_full", ".png", new File(dir));
				System.out.println("Saving Screenshot...");
				ImageIO.write(bufferedImage, "png", file);
			} catch (IOException ex) {
				Logger.getLogger(ScreenshotMaker.class.getName()).log(Level.SEVERE, null, ex);
			}
		} catch (AWTException ex) {
			Logger.getLogger(ScreenshotMaker.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
