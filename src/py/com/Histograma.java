package py.com;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Histograma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImagePlus im= new ImagePlus("C:\\Users\\Familia Villegas\\Desktop\\2023\\DOCTORADO\\PDI 2\\Clases\\Images\\nena.jpeg");
		im.show();
		
		//ComputeHistogram ch= new ComputeHistogram();
		//Ejercicio1_T2 ch = new Ejercicio1_T2();
		//Ejercicio3_T2 ch = new Ejercicio3_T2();
		//ch.setup(null,im);
		
		ImageProcessor ip= im.getProcessor();
		
		//ch.run(ip);
		
	      // Para imagen con Math		
	    ComputeHistogram ch1 = new ComputeHistogram();
	    ch1.setup(null, im);
	    ch1.run(ip);
	    
	    HistoAcumulativo ch2 = new HistoAcumulativo();
	    ch2.setup(null, im);
	    ch2.run(ip);
			

	}
}


