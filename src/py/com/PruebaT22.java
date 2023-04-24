package py.com;
import java.util.Arrays;
import java.util.Random;
import ij.*;
import ij.gui.NewImage;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;

public class PruebaT22 implements PlugInFilter {

   ImagePlus imp;

public int setup(String arg, ImagePlus imp) {
		//this.imp = imp;
		return DOES_8G + NO_CHANGES; // Process 8-bit grayscale images
   }

   public void run(ImageProcessor ip) {
       int width = 256;    // Ancho de la imagen
       int height = 256;   // Altura de la imagen
      ImagePlus randomImage = NewImage.createByteImage("Random Image", width, height, 1, NewImage.FILL_BLACK);
      ImageProcessor randomIp = randomImage.getProcessor();
      Random rand = new Random();

      for (int y = 0; y < height; y++) {
         for (int x = 0; x < width; x++) {
            int value = (rand.nextInt(256)); // Generate a random number between 0 and 255
            randomIp.set(x, y, value);
         }
      }

      randomImage.show();
		
      int[] h = new int[256];
		//int[] h_mod = new int[256];
		int M = randomIp.getWidth();
		int N = randomIp.getHeight();
		
		for(int v = 0; v < N; v++){
			for(int u = 0; u < M; u++){
				int i = randomIp.getPixel(u, v);
				h[i] = h[i] + 1;
			}
		}
		

		System.out.println(Arrays.toString(h));
		// ... histogram h can now be used

		// create the histogram image:
		ImagePlus himage = NewImage.createByteImage("Histo Image", width, height, 1, NewImage.FILL_BLACK);
		ImageProcessor hip = new ByteProcessor(256, 150);
		hip.setValue(255); // white = 255
		hip.fill();

		// draw the histogram values as black bars in hip here,
		// for example, using hip.putpixel(u, v, 0)
		// ...
		
		//Obtener la frecuencia mas alta del vector h
		int ma = maximo(h);
		for(int x = 0; x < 256; x++){
			int esc = (h[x]*150)/ma;
			for(int y = 0; y<=esc; y++){
				hip.putPixel(x, 150-y, 0);
			}
		}
		
		// compose a nice title:
		String imTitle = himage.getShortTitle();
		String histTitle = "Histogra de " + imTitle;

		// display the histogram image:
		ImagePlus him = new ImagePlus(histTitle, hip);
		him.show();
	}
	
	private int maximo(int[] H){
		int maxi = H[0];
		int ta = H.length; //Tamanho del vector o arreglo unidimensional
		for(int t = 0; t < ta; t++){  //Recorrer mi vector
			if(H[t]>maxi){
				maxi = H[t];
			}
		}
		return maxi;
	}

 }
