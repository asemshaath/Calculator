import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcFrame extends JFrame implements ActionListener
{

	ImageIcon logo = new ImageIcon("Calculator Symbol.jpg"); 
	
	Font buttonsFont;
	Font ansFunctionsFont;
	Font shortTextFont;
	Font longTextFont;
	
	JPanel panel1; 
	
	JButton [] numberButtons = new JButton[10];  
	JButton plusButton;
	JButton minusButton; 
	JButton divButton; 
	JButton multiButton;
	JButton ansButton;  
	JButton powerButton;  
	JButton clrButton; 
	JButton pointButton; 
	JButton deleteButton; 
	JButton eqButton;
	JButton rightPerenButton; 
	JButton leftPerenButton; 
	JButton ansX2Button;
	JButton ansSquareButton; 
	JButton ansCubeButton; 
	
	static JTextField text; 
	
	double ans = 0; 
	
	
	
	public CalcFrame() 
	{
		
		
		buttonsFont = new Font(null,Font.BOLD, 34); 
		ansFunctionsFont = new Font(null, Font.BOLD, 24);
		shortTextFont = new Font("Consolas", Font.BOLD, 49);
		longTextFont = new Font("Consolas", Font.BOLD, 35);
		
		// text field settings 
		text = new JTextField(); 
		text.setBounds(0, 0, 561, 90);
		text.setFont(shortTextFont);
		text.setBackground(Color.BLACK); 
		text.setForeground(Color.WHITE); 
		text.setEditable(false);
		
		
		// number button settings 
		for (int i = 0; i <=9 ; i++)
		{
			numberButtons[i] = new JButton(); 
			numberButtons[i].setText(String.valueOf(i)); 
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false); 
			numberButtons[i].setFont(buttonsFont);
			numberButtons[i].setForeground(Color.WHITE); 
			numberButtons[i].setBackground(new Color(0x3D3D3D));
		}
		
		// ANS button settings 
		ansButton = new JButton(); 
		ansButton.setText("ANS"); 
		ansButton.addActionListener(this);
		ansButton.setFocusable(false); 
		ansButton.setFont(ansFunctionsFont);
		ansButton.setForeground(Color.WHITE); 
		ansButton.setBackground(new Color(0x3D3D3D));

		// right parenthesis button settings
		rightPerenButton = new JButton(); 
		rightPerenButton.setText(")"); 
		rightPerenButton.addActionListener(this);
		rightPerenButton.setFocusable(false); 
		rightPerenButton.setFont(buttonsFont);
		rightPerenButton.setForeground(Color.BLACK); 
		rightPerenButton.setBackground(Color.ORANGE);
		
		// left parenthesis button settings
		leftPerenButton = new JButton(); 
		leftPerenButton.setText("("); 
		leftPerenButton.addActionListener(this);
		leftPerenButton.setFocusable(false); 
		leftPerenButton.setFont(buttonsFont);
		leftPerenButton.setForeground(Color.BLACK); 
		leftPerenButton.setBackground(Color.ORANGE);
		
		// ANS x 2 button
		ansX2Button = new JButton(); 
		ansX2Button.setText("2ANS"); 
		ansX2Button.addActionListener(this);
		ansX2Button.setFocusable(false); 
		ansX2Button.setFont(ansFunctionsFont);
		ansX2Button.setForeground(Color.BLACK); 
		ansX2Button.setBackground(Color.ORANGE);
		
		// ANS ^ 2 button 
		ansSquareButton = new JButton(); 
		ansSquareButton.setText("ANS^2"); 
		ansSquareButton.addActionListener(this);
		ansSquareButton.setFocusable(false); 
		ansSquareButton.setFont(ansFunctionsFont);
		ansSquareButton.setForeground(Color.BLACK); 
		ansSquareButton.setBackground(Color.ORANGE);
		
		// ANS ^ 3 button 
		ansCubeButton = new JButton(); 
		ansCubeButton.setText("ANS^3"); 
		ansCubeButton.addActionListener(this);
		ansCubeButton.setFocusable(false); 
		ansCubeButton.setFont(ansFunctionsFont);
		ansCubeButton.setForeground(Color.BLACK); 
		ansCubeButton.setBackground(Color.ORANGE);
		
		
		// clr button settings 
		clrButton = new JButton(); 
		clrButton.setText("AC");
		clrButton.addActionListener(this);
		clrButton.setFocusable(false); 
		clrButton.setFont(buttonsFont);
		clrButton.setBackground(new Color(0xE3E3E3));
		
		// point button settings 
		pointButton = new JButton(".");
		pointButton.addActionListener(this);
		pointButton.setFocusable(false); 
		pointButton.setFont(buttonsFont);
		pointButton.setForeground(Color.WHITE); 
		pointButton.setBackground(new Color(0x3D3D3D));
		
		// plus button settings 
		plusButton = new JButton("+");
		plusButton.addActionListener(this);
		plusButton.setFocusable(false); 
		plusButton.setFont(buttonsFont);
		plusButton.setBackground(Color.ORANGE); 
		
		// minus button settings 
		minusButton = new JButton("-");
		minusButton.addActionListener(this);
		minusButton.setFocusable(false); 
		minusButton.setFont(buttonsFont);
		minusButton.setBackground(Color.ORANGE); 
		
		// div button 
		divButton = new JButton("/");
		divButton.addActionListener(this);
		divButton.setFocusable(false); 
		divButton.setFont(buttonsFont);
		divButton.setBackground(Color.ORANGE); 
		
		// multi button settings 
		multiButton = new JButton("x");
		multiButton.addActionListener(this);
		multiButton.setFocusable(false); 
		multiButton.setFont(buttonsFont);
		multiButton.setBackground(Color.ORANGE); 
		
		// delete button settings 
		deleteButton = new JButton("Del");
		deleteButton.addActionListener(this);
		deleteButton.setFocusable(false); 
		deleteButton.setFont(buttonsFont);
		deleteButton.setBackground(new Color(0xE3E3E3));
		
		// power button settings 
		powerButton = new JButton("^");
		powerButton.addActionListener(this);
		powerButton.setFocusable(false); 
		powerButton.setFont(buttonsFont);
		powerButton.setBackground(Color.ORANGE);
		
		// equal button settings 
		eqButton = new JButton("=");
		eqButton.addActionListener(this);
		eqButton.setFocusable(false); 
		eqButton.setFont(buttonsFont);
		eqButton.setBackground(Color.ORANGE); 
		
		// panel1 settings 
		panel1 = new JPanel(); 
		panel1.setLayout(new GridLayout(5,5,0,0));
		panel1.setBounds(0, 90, 560, 500);
		panel1.setBackground(Color.BLACK);
		panel1.setOpaque(true); 
		
		
		panel1.add(clrButton);
		panel1.add(deleteButton);
		panel1.add(powerButton);
		panel1.add(divButton);
		panel1.add(leftPerenButton); 
		
		panel1.add(numberButtons[7]); 
		panel1.add(numberButtons[8]);
		panel1.add(numberButtons[9]);
		panel1.add(multiButton);
		panel1.add(rightPerenButton);
		
		panel1.add(numberButtons[4]);
		panel1.add(numberButtons[5]);
		panel1.add(numberButtons[6]);
		panel1.add(minusButton);
		panel1.add(ansX2Button); 
		
		panel1.add(numberButtons[1]);
		panel1.add(numberButtons[2]);
		panel1.add(numberButtons[3]);
		panel1.add(plusButton);
		panel1.add(ansSquareButton);
		
		panel1.add(numberButtons[0]);
		panel1.add(pointButton); 
		panel1.add(ansButton); 
		panel1.add(eqButton); 
		panel1.add(ansCubeButton);
		
		// frame settings 
		
		this.setSize(576, 630);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		this.setTitle("Calculator"); 
		this.getContentPane().setBackground(new Color(0x000000)); 
		//this.setResizable(false); 
		this.setVisible(true); 
		
		
		// add components
		
		this.add(panel1); 
		this.add(text); 
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		// back space clicked 
		if (e.getSource() == deleteButton)
		{
			
			if(text.getText().equalsIgnoreCase(""))
				text.setText("");
			else 
			{
				//ArrayList<Character> tempAL = new ArrayList<Character>();
				String tempStr = ""; 
				
				for(int i = 0; i < text.getText().length() - 1; i++)
				{
					tempStr += text.getText().charAt(i); 
				}
				
				
				text.setText(tempStr);
			}
				//text.setText(text.getText().substring(0, text.getText().length() - 1));
		}
		
		// numbers clicked 
		
		for (int i = 0; i <=9 ; i++)
		{
			
			if(e.getSource() == numberButtons[i]) 
			{
				
				// to prevent the user from writing more than 18 digits
				if(text.getText().length() < 18)
				{
					text.setText(text.getText() + String.valueOf(i));
				}
				
			}
		}
		
		// clr button clicked 
		
		if (e.getSource() == clrButton) 
		{
			text.setText(""); 
		}
		
		
		// left parenthesis clicked 
		if (e.getSource() == leftPerenButton)
		{
			text.setText(text.getText() + "(");  
		}
		
		
		// right parenthesis clicked 
		if (e.getSource() == rightPerenButton)
		{
			text.setText(text.getText() + ")");  
		}
		
		
		// point button clicked 
		if (e.getSource() == pointButton)
		{
			text.setText(text.getText() + ".");  
		}
		
		// plus button clicked
		
		if (e.getSource() == plusButton)
		{
			text.setText(text.getText() + "+");
		}
		
		// minus button clicked
		
		if (e.getSource() == minusButton)
		{
			text.setText(text.getText() + "-");
		}
		
		
		// multiply button clicked
		
		if (e.getSource() == multiButton)
		{
			text.setText(text.getText() + "*");
		}
		
		
		// division button clicked 
		
		if (e.getSource() == divButton)
		{
			text.setText(text.getText() + "/");
		}
		
		// power button clicked 
		
		if (e.getSource() == powerButton)
		{
			text.setText(text.getText() + "^");
		}
		
		// ANS button clicked 
		
		if (e.getSource() == ansButton)
		{
			dealWithAns(ans); 	
		}
		
		// ANS x 2 clicked 
		
		if (e.getSource() == ansX2Button)
		{
			dealWithAns(ans*2);
		}
		
		
		// ANS^2 clicked 
		
		if (e.getSource() == ansSquareButton)
		{
			dealWithAns(Math.pow(ans, 2));
		}
		
		// ANS^3 clicked 
		
		if (e.getSource() == ansCubeButton)
		{
			dealWithAns(Math.pow(ans, 3));
		}
		
		// equal button clicked 
		
		if (e.getSource() == eqButton)
		{
			try 
			{
				String tempAns; 
				tempAns = Evaluation.eval(text.getText());
				text.setText(tempAns);
				ans = Double.parseDouble(tempAns); 
				
			}
			catch (UnsupportedOperationException e1) 
			{
				text.setText("Error"); 
			} 
			catch (InvalidEntryException e1) 
			{
				showInvalidEntryErrorMessage(e1.getMessage());
			} 
		}
		
	}
	
	
	private static void showInvalidEntryErrorMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
	

	private static void dealWithAns(double ans)
	{

		
		if(text.getText().equals(""))
		{
			try {
				
				if(Evaluation.isDoubleAnswer(String.valueOf(ans)))
				{
					text.setText(String.valueOf(ans) + "*");
				}
				else
				{
					text.setText(Evaluation.toIntString(String.valueOf(ans)) + "*");
				}
				
			} 
			catch (InvalidEntryException e1) 
			{
				showInvalidEntryErrorMessage(e1.getMessage()); 
			}
		}
		else if(Evaluation.isDigit(text.getText().charAt(text.getText().length() - 1)))
		{
			
			try {
				
				if(Evaluation.isDoubleAnswer(String.valueOf(ans)))
				{
					text.setText(text.getText() + "*" + String.valueOf(ans) + "*");
				}
				else
				{
					text.setText(text.getText() + "*" + Evaluation.toIntString(String.valueOf(ans)) + "*");
				}
				
			} 
			catch (InvalidEntryException e1) 
			{
				showInvalidEntryErrorMessage(e1.getMessage()); 
			}
			
			//text.setText(text.getText() + "*" + String.valueOf(ans));
		}
		else if(  Evaluation.isOp(  text.getText().charAt(text.getText().length() - 1)))
		{
			
			try {
				
				if(Evaluation.isDoubleAnswer(String.valueOf(ans)))
				{
					text.setText(text.getText() + String.valueOf(ans) + "*");
				}
				else
				{
					text.setText(text.getText() + Evaluation.toIntString(String.valueOf(ans)) + "*");
				}
				
			} 
			catch (InvalidEntryException e1) 
			{
				showInvalidEntryErrorMessage(e1.getMessage()); 
			}
			
			//text.setText(text.getText() + "*" + String.valueOf(ans));
		}
		else
		{
			text.setText(text.getText());
		}
		
		//text.setText(text.getText() + ".");  
	
	}

}
