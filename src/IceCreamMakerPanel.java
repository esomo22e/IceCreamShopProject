// IceCreamPanel.java
// Audrey St. John

// awt
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// swing 
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public  class IceCreamMakerPanel extends JPanel implements ActionListener
{
	
	// instance variables
	private JButton buttonVanilla;
	private JButton buttonChocolate;
	private JButton buttonStrawberry;
	private JButton buttonGrape;
	private JButton trashButton;
	private IceCreamCone iceCreamCone;
	
	// constructor
	public IceCreamMakerPanel()
	{
		// call super constructor
		super();
		
		iceCreamCone = new IceCreamCone();
		
		// call instance method to initialize the graphics
		initGUI();
		
		repaint();
	}
	
	/**
	 * create the GUI components
	 **/
	public void initGUI()
	{
		// use a border layout
		setLayout( new BorderLayout() );
		
		setBackground(Color.CYAN);
		
		// first, create panel to hold input 
		// and add to north
		add( createIceCreamButtonPanel(), BorderLayout.NORTH );
		
		// then, create panel for drawing the ice cream cone
		// and add to center
		add(  iceCreamCone, BorderLayout.CENTER );
		
		// finally, create button for "ordering" the cone
		// and add to south
		add( createTrashButton(), BorderLayout.SOUTH );
	}
	
	/** 
	 * Create an input panel
	 * @return created panel
	 **/
	public JPanel createIceCreamButtonPanel()
	{
		// create panel to hold input GUI elements, using default FlowLayout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));
		
		// create and add label
		buttonVanilla = new JButton("vanilla");
		buttonPanel.add(buttonVanilla);
		buttonVanilla.addActionListener(this);
		
		
		buttonChocolate = new JButton("chocolate");
		buttonPanel.add(buttonChocolate);
		buttonChocolate.addActionListener(this);
		
		
		buttonStrawberry = new JButton("strawberry");
		buttonPanel.add(buttonStrawberry);
		buttonStrawberry.addActionListener(this);
		
		
		buttonGrape = new JButton("grape");
		buttonPanel.add(buttonGrape);
		buttonGrape.addActionListener(this);
		
		
		// return created panel
		return buttonPanel;
	}
	
	/** 
	 * Ceate button for making an order
	 * @return the created button
	 **/
	public JButton createTrashButton()
	{
		// create a button
		trashButton = new JButton( "Trash The Top Scoop!" );
		
		
		// add this as the action listener for button's action (click)
	    trashButton.addActionListener( this );
		
		// return the button
		return trashButton;
	}

	public IceCreamCone getIceCreamCone() {
		return iceCreamCone;
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
		if( ( e.getSource()).equals(buttonVanilla))
		{
			System.out.println("paint vanilla");
			iceCreamCone.setFlavor("vanilla");
			iceCreamCone.addScoop();
			repaint();
		}
		if( (e.getSource()) .equals(buttonChocolate))
		{
			iceCreamCone.setFlavor("chocolate");
			iceCreamCone.addScoop();
			repaint();
		}
		if( (e.getSource()) .equals(buttonStrawberry))
		{
			iceCreamCone.setFlavor("strawberry");
			iceCreamCone.addScoop();
			repaint();
		}
		if( (e.getSource()) .equals(buttonGrape))
		{
			iceCreamCone.setFlavor("grape");
			iceCreamCone.addScoop();
			repaint();
		}
		if( (e.getSource()).equals(trashButton))
		{
			iceCreamCone.removeScoop();
			repaint();
		}
	}

	  
	
}