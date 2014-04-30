// awt
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class IceCreamLinePanel extends JPanel implements ActionListener{

	
	// instance variable
	private JButton randomOrder;
	private JButton serveOrder;
	

	private IceCreamLine iceCreamLine;
	
	
	// constructor
	public IceCreamLinePanel()
	{
		// call super constructor
		super();
				
		
		// call instance method to initialize the graphics
		initGUI();
		
		repaint();
		
		
	}
	
	/**
	 * create the GUI components
	 **/
	public void initGUI()
	{
		iceCreamLine = new IceCreamLine();
		// use a border layout
		setLayout( new BorderLayout() );
		
		// first, create panel to hold input 
		// and add to north
		add( createIceCreamLineButtonPanel(), BorderLayout.SOUTH );
		
		// then, create panel for drawing the ice cream cone
		// and add to center
		add(  iceCreamLine, BorderLayout.CENTER );
		
		
	}
	public IceCreamLine getIceCreamLine() {
		return iceCreamLine;
	}

	/** 
	 * Create an input panel
	 * @return created panel
	 **/
	public JPanel createIceCreamLineButtonPanel()
	{
		// create panel to hold input GUI elements, using default FlowLayout
		JPanel buttonPanel = new JPanel();
		//create a grid Layout
		buttonPanel.setLayout(new BorderLayout());
		
		//create random Order button that adds a random order of cones
		randomOrder = new JButton("Add a random order");
		//the button panel will add the elements of randomOrder
		buttonPanel.add(randomOrder);
		//then random order will implement action listener
		randomOrder.addActionListener(this);
		//create serve Order button that deqeueu the order of the cones
		
		
		// return created panel
		return buttonPanel;
	}

	


	/**
	 * Special method required by implementing ActionListener 
	 * (function signature cannot be changed)
	 * Invoked when an action is performed on the spotsButton, since this
	 * was added as an ActionListener.
	 **/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stu
		//implement the actionlistener for the random order button
		if( ( e.getSource()).equals(randomOrder))
		{
			//ice Cream Line will add the random order 	
			iceCreamLine.addOrder();
			//repaint the method
			repaint();
		}
		//implement the actionlistener for the deqeueu button
	/*	if( (e.getSource()) .equals(serveOrder))
		{
			//ice Cream Line will dequeue the order
			//iceCreamLine.removeOrder();
			//repaint the method
			repaint();
		}*/
	
	}

}
