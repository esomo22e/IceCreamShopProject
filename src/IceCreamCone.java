
// awt
import java.awt.Color;
import java.awt.Graphics;


// swing
import javax.swing.JComponent;

public class IceCreamCone extends JComponent {

	private StackLL<Color> stack = new StackLL<Color>();
	// class properties
	public static final String[] FLAVORS = { "vanilla", "strawberry",
			"chocolate", "grape" };
	public static final Color chocolate = new Color(160, 82, 45);
	private static final Color vanilla = new Color(243, 229, 171);
	private static final Color strawberry = new Color(255, 34, 89);
	private static final Color grape = new Color(186,85,211);
	public static final Color[] PAINT_COLORS = {vanilla, strawberry,
			chocolate, grape };
	public static final int CONE_WIDTH = 40;
	public static final int CONE_HEIGHT = 70;
	public static final int SCOOP_DIAMETER = 60;
	public static final int SCOOP_OVERLAP = 10;
	
	private int score;
	public int getScore() {
		return score;
	}
	// instance properties
	private int flavorIndex; // value must be -1 to indicate no scoop or in
								// [0,FLAVORS.length)

	/**
	 * constructor with specified flavor
	 **/
	public IceCreamCone(String flavor) {
		// call superclass constructor
		super();

		setFlavor(flavor);
	}

	/**
	 * constructor with no parameters, default is no flavor
	 **/
	public IceCreamCone() {
		// call other constructor to default to no flavor
		this("none");
	}

	/**
	 * Given a flavor, set it as this ice cream cone's flavor. Valid parameter
	 * values: "none" or one of FLAVORS If invalid paramter is passed, defaults
	 * to "none"
	 **/
	public void setFlavor(String flavor) {
		flavorIndex = findFlavorIndex(flavor);
		System.out.println("set f stack size" + stack.size());
	}

	/**
	 * Given a flavor, returns the corresponding index in FLAVORS. Valid
	 * parameter values: "none" or one of FLAVORS If invalid paramter is passed,
	 * defaults to -1
	 **/
	private int findFlavorIndex(String flavor) {
		// if none, ignoring case
		if (flavor.toLowerCase().equals("none"))
			// flag of -1 indicates none
			return -1;
		else {
			// for each allowed flavor
			for (int i = 0; i < FLAVORS.length; i++) {
				// if found a match, ignoring case
				if (flavor.toLowerCase().equals(FLAVORS[i]))
					// found flavor index
					return i;
			}

			// if we get here, passed flavor did not match any element
			// set to none
			return -1;
		}
	}

	/**
	 * Override the paint method to draw an ice cream cone.
	 **/
	public void paint(Graphics g) {
		// draw the cone
		paintCone(g);
		System.out.println("other stack size" + stack.size());
		// draw the scoop
		paintScoop(g);
		System.out.println("paint ice cream");
	}

	/**
	 * paint the cone
	 **/
	public void paintCone(Graphics g) {
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];

		// center bottom point
		xPoints[0] = getWidth() / 2;
		yPoints[0] = getHeight();

		// upper left point
		xPoints[1] = xPoints[0] - (CONE_WIDTH / 2);
		yPoints[1] = yPoints[0] - CONE_HEIGHT;

		// upper right point
		xPoints[2] = xPoints[0] + (CONE_WIDTH / 2);
		yPoints[2] = yPoints[0] - CONE_HEIGHT;

		// set the paint color
		Color cone = new Color(195, 143, 3);
		g.setColor(cone);

		// draw triangle
		g.fillPolygon(xPoints, yPoints, 3);
	}

	/**
	 * paint the scoop
	 **/
	public void paintScoop(Graphics g) {
		//create a temporary stack
		StackLL<Color> temp = new StackLL<Color>();
		//while the temporary stack is empty
		while (!stack.isEmpty()) {
			//the temporary stack will push what the main stacked popped
			temp.push(stack.pop());
		}
		//the size equals the size of the temp
		int size = temp.size();
		//create a counter i
		int i = 0;
		//while the temporary stack is not  empty
		while (!temp.isEmpty()) {
			//the temp color will equal the what the temporary stack pops
			Color tempColor = temp.pop();
			//if the color is white
			if (tempColor.equals(vanilla)) {
				//the flavor index is 1st in the array and it is 0, vanilla
				flavorIndex = 0;
				
			} 
			//if the color is pink
			else if (tempColor.equals(strawberry)) {
				//the flavor is 2nd in the array and it is 1, strawberry
				flavorIndex = 1;
				
			} 
			//if the color is chocolate
			else if (tempColor.equals(chocolate)) {
				//the flavor is 3rd int he array and it is 2, chocolate
				flavorIndex = 2;
			} 
			else {
				//the 4th in the array, orange
				flavorIndex = 3;
			}
			// set the paint color based on the flavor
			g.setColor(PAINT_COLORS[flavorIndex]);
		//	System.out.println("color scoop");
			// fill oval (upper left x, upper left y, width, height)
			
			//for(int i = 0; i < size; i++){
			g.fillOval(
					// upper left x is center minus half diameter
					getWidth() / 2 - SCOOP_DIAMETER / 2,
					// upper left y accounts for cone height and a bit of
					// overlap
					getHeight() - CONE_HEIGHT - SCOOP_DIAMETER + SCOOP_OVERLAP -(i*50),
					SCOOP_DIAMETER, SCOOP_DIAMETER);
			//}
			stack.push(tempColor);
			i++;
		}

	}
	
	
	public void addScoop() {
		//if the flavor index is equal or greater than 0
		if (flavorIndex >= 0) {
			// System.out.println("add scoop");
			//push the paint color containing the specific flavor
			stack.push(PAINT_COLORS[flavorIndex]);

		}
		// .out.println("add stack size" + stack.size());
	}
	/*
	 * Create this method to get a random number of stacks of scoops
	 * From 1 to 4. 
	 */
	public void randomScoopStack(){
		//create random number of scoops
		int ranScoop = (int)Math.floor(Math.random()*4);
		//go through the ranScoop from 1 to 4
		for(int sc = 1; sc <= ranScoop; sc++)
		{
			//and random flavor of scoop. 
			addRandomScoop();
		}
	}
	/*
	 * Create this method that get the random flavor index.
	 */
	public void addRandomScoop() {
		//create random flavor fromt he four flavors int he Flavors array
		int ranFlav = (int)Math.floor(Math.random()*4);
		//the random flavor must be greater than 0
		if (ranFlav >= 0) {
			//push the paint color with the random flavor index
			// System.out.println("add scoop");
			stack.push(PAINT_COLORS[ranFlav]);


		
		}
	
	}
	public void removeScoop() {
		//if stack is not empty
		if (!stack.isEmpty()) {
			//the stack needs to be popped to be removed
			stack.pop();
		}
	}
		public boolean matchCone()
		{
			//create instance of Ice Cream Cone called cone
			//IceCreamCone cone = new IceCreamCone();
			StackLL<Color> temp = new StackLL<Color>();
			//if the stakc is not empty			
			while(!stack.isEmpty())
			{
				//one stack will equal another stack
				if((stack.size()) == (stack.size()) )
				{
					//then pop the stack - remove the top scoop
					stack.pop();
					//add component
					validate();
					//repaint 
					repaint();
				}
				return false;
				
			}
			//score -=5;
			return true;
		}
	
}
