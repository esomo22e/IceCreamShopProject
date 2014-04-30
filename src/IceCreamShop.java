import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class IceCreamShop extends JPanel implements ActionListener {

	//create an instance of the Queue
	private QueueLL<IceCreamLine> queue = new QueueLL<IceCreamLine>();
	
	private IceCreamCone iceCreamCone; //= new IceCreamCone();

	/*Instance Fields*/
	private IceCreamLine iceCreamLine; 
	private IceCreamLinePanel iceCreamLinePan = new IceCreamLinePanel();
	private IceCreamMakerPanel iceCreamConePan = new IceCreamMakerPanel();
	private JButton serveOrder;
	private JTextArea title;
	private int score = 0;
	
	public IceCreamShop()
	{
		super();
		//call gui method
		initGUI();
		//repaint
		repaint();
		
		
	}
	/*
	 * The Gui will hold all the different components of botht the Ice Cream Cone and Ice Cream line. 
	 */
	
	public void initGUI()
	{
		setLayout( new BorderLayout() );
		
		add(createScoreText(), BorderLayout.PAGE_START);
			
		add( iceCreamLinePan, BorderLayout.WEST);
		
		add(iceCreamConePan, BorderLayout.CENTER);
		
		add(createServeButton(), BorderLayout.SOUTH);
		
	}
	
	
	public JPanel createServeButton()
	{
		
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new BorderLayout());
		

	
		serveOrder = new JButton("Serve the next Order");
		
		//the buttonPanel will add the serveOrder
		buttonPanel.add(serveOrder);
		
		//implement actionListener
		serveOrder.addActionListener(this);
		
		return buttonPanel;
	}
	/*
	 * Make a Text Area that will hold the tile and the score.
	 */
	public JTextArea createScoreText()
	{
		
		JTextArea icLabelPanel = new JTextArea();
		//create an a local variable of iceCream cone that takes int he panel that gets the cone
		iceCreamCone = iceCreamConePan.getIceCreamCone();
		//in this instance the text area will hold the title and get the score
		title = new JTextArea("Welcome to Eunice's Ice Cream Shop!!!           " + "Score:" + iceCreamCone.getScore() );
		title.setVisible(true);
		title.setEditable(false);
		title.setFont(new Font("Times New Roman", Font.BOLD,20));
		
		
		return title;
		
		}
	/*
	 * This method will maintain the score of the GUI. 
	 */
	public int score()
	{
		//instance of the Ice Cream Cone
		iceCreamCone = iceCreamConePan.getIceCreamCone();
		
		////if the match coen is true;
		if(iceCreamCone.matchCone() == false)
		{
			//then add 10 points. 
			score+=10;
			
			//use setText to update score
			title.setText("Welcome to Eunice's Ice Cream Shop!!!" + " Score:" + score);	
		}
		//if they don't match. 
		else if(iceCreamCone.matchCone() )
		{
			//then subtract 5 points. 
			score -= 5;
			//if they don't match then update score. 
			title.setText("Welcome to Eunice's Ice Cream Shop!!!" + " Score:" +score);
		}
		
	
		return score;
		
	}
	/**
	 * Special method required by implementing ActionListener 
	 * (function signature cannot be changed)
	 * Invoked when an action is performed on the spotsButton, since this
	 * was added as an ActionListener.
	 **/
	@Override
	public void actionPerformed(ActionEvent e) {
		//create local variables of the ice Cream cone and line panel
		iceCreamCone = iceCreamConePan.getIceCreamCone();
		iceCreamLine = iceCreamLinePan.getIceCreamLine();
		//implement the actionlistener for the deqeueu button
		if( (e.getSource()) .equals(serveOrder))
		{
			//ice Cream Line will dequeue the order
			//score();
			//call the the matchcone method that will be implemented when you press the serve order button
			iceCreamCone.matchCone();
			//update the score
			score();
			//call the remove order method
			iceCreamLine.removeOrder();
			
			validate();
			//repaint the method
			repaint();
		}
	
	}

}
