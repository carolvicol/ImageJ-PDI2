package py.com;
//import java.util.Arrays;
import java.util.Random;
import ij.*;
import ij.gui.NewImage;
//import ij.plugin.filter.PlugInFilter;
import ij.process.*;

public class Imagen_Gaussian {

   ImagePlus imp;

   public static void main (String[] args) {
       int width = 256;    // Ancho de la imagen definido por el usuario
       int height = 256;   // Altura de la imagen definido por el usuario
       double mean = 128;
       double stddev = 50;
      ImagePlus randomImageGauss = NewImage.createByteImage("Gaussian_Image", width, height, 1, NewImage.FILL_BLACK);
      ImageProcessor randomIpGauss = randomImageGauss.getProcessor();
      Random rand = new Random();

      for (int v = 0; v < height; v++) {
         for (int u = 0; u < width; u++) {
            double val = rand.nextGaussian(); // Generate a random number
            val = (val * stddev) + mean; // scale to pixel value
            randomIpGauss.set(u, v, (int)val);
         }
      }

      randomImageGauss.show();
      // Para imagen con Math		
    	ComputeHistogram ch4 = new ComputeHistogram();
    	ch4.setup(null, randomImageGauss);
    	ch4.run(randomIpGauss);
		
   }
}
