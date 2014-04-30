// awt
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Box;
// swing
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IceCreamLine extends JPanel{

	//create an instance of the Queue
	private QueueLL<IceCreamCone> queue = new QueueLL<IceCreamCone>();
	//create an instance of Ice Cream Cone
		private IceCreamCone iceCreamCone = new IceCreamCone();

		

		/**
		 * constructor with specified flavor
		 **/
		public IceCreamLine() {
			
			//set the background black
			this.setBackground(Color.BLACK);
			//the layout contains the box layout which would put the layout top to bottom
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			
			
			
		}

		/**
		 * Override the paint method to draw an ice cream cone.
		 **/
		public void paint(Graphics g) {
			//call to the super class
			super.paint(g);
						
		}
	/**
	 *Create the order of the scoop
	 */
		public void addOrder() {
			//create instance of Ice Cream Cone called cone
			IceCreamCone cone = new IceCreamCone();
			
				//in the line add the cone inn the line
				queue.enqueue(cone);
				//add the cone
				add(cone);
				//add the different flavor of scoops
				cone.addRandomScoop();
				//add the different amount of scoops
				cone.randomScoopStack();
				//add a component
				validate();
				//repaint now that it's changed
				repaint();
				

		}
		
		/**
		 * Remove the order of the scoop.
		 */
		public void removeOrder() {
			//if the queue is not empty
			if (!queue.isEmpty()) {
				//remove the queue
				remove( queue.dequeue());
				//add a component
				validate();
				//repaint now that it's changed
				repaint();
			}

		}
	
}
