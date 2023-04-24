package py.com;
import java.util.Random;
import ij.*;
import ij.gui.NewImage;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;

public class RandomImage_Plugin implements PlugInFilter {

   public int setup(String arg, ImagePlus imp) {
      return DOES_8G; // Process 8-bit grayscale images
   }

   public void run(ImageProcessor ip) {
      int width = ip.getWidth();
      int height = ip.getHeight();
      ImagePlus randomImage = NewImage.createByteImage("Random Image", width, height, 1, NewImage.FILL_BLACK);
      ImageProcessor randomIp = randomImage.getProcessor();
      Random rand = new Random();

      for (int y = 0; y < height; y++) {
         for (int x = 0; x < width; x++) {
            int value = (int) (rand.nextDouble() * 256); // Generate a random number between 0 and 255
            randomIp.set(x, y, value);
         }
      }

      randomImage.show();
   }
}
