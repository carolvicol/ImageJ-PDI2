package py.com;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ShowImagens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImagePlus im= new ImagePlus("C:\\Users\\Familia Villegas\\Desktop\\2023\\DOCTORADO\\PDI 2\\Clases\\Images\\nena.jpeg");
		im.show();
		
		MarcoBlanco ch= new MarcoBlanco();
		//My_Inverter_A ch= new My_Inverter_A();
		ch.setup(null,im);
		
		ImageProcessor ip= im.getProcessor();
		
		ch.run(ip);

	}

}
