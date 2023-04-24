package py.com;
//import java.util.Arrays;
import java.util.Random;
//import ij.*;
import ij.gui.NewImage;
//import ij.plugin.filter.PlugInFilter;
//import ij.process.*;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Imagen_Random {

   ImagePlus imp;

public static void main (String[] args) {

       int width = 256;    // Ancho de la imagen definido por el usuario
       int height = 256;   // Altura de la imagen definido por el usuario
      ImagePlus randomImage = NewImage.createByteImage("Rand_Image", width, height, 1, NewImage.FILL_BLACK);
      ImageProcessor randomIp = randomImage.getProcessor();
      Random rand = new Random();

      for (int v = 0; v < height; v++) {
         for (int u = 0; u < width; u++) {
            int value = (rand.nextInt(256)); // Generate a random number between 0 and 255
            randomIp.set(u, v, value);
         }
      }

      randomImage.show();
      
   // Para imagen con Math		
  	ComputeHistogram ch3 = new ComputeHistogram();
  	ch3.setup(null, randomImage);
  	ch3.run(randomIp);
      
	}
   

		
}