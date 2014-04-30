
import javax.swing.JFrame;


public class IceCreamShopApplication {
	/**
	 * show an Ice cream shop
	 **/
	public static void main( String[] args )
	{
		// create a new JFrame to hold IceCreamPanel
		JFrame icFrame = new JFrame();

		// set size
		icFrame.setSize(1300, 800);
		

		// create an IceCreamPanel and add it
		icFrame.add(   new IceCreamShop() );
		
		// exit normally on closing the window
		icFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// show frame
		icFrame.setVisible(true);
	}

}
