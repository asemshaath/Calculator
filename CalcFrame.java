import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalcFrame extends JFrame implements ActionListener
{

	ImageIcon logo = new ImageIcon("Calculator Symbol.jpg"); 
	
	Font buttonsFont; 
	
	JPanel panel1; 
	
	JButton [] numberButtons = new JButton[10];  
	JButton plusButton;
	JButton minusButton; 
	JButton divButton; 
	JButton multiButton;
	JButton decimalButton;  
	JButton percentButton;  
	JButton clrButton; 
	JButton backspaceButton; 
	JButton negPosButton; 
	JButton eqButton;
	
	JTextField text; 
	
	double num1 = 0;
	double num2 = 0;
	double result = 0; 
	double percentResult = 0; 
	char function; 
	
	public CalcFrame() 
	{
		
		
		buttonsFont = new Font(null,Font.BOLD, 41); 
		
		// text field settings 
		text = new JTextField(); 
		text.setBounds(0, 0, 400, 90);
		text.setFont(new Font("DialogInput", Font.BOLD, 49));
		text.setBackground(Color.BLACK); 
		text.setForeground(Color.GREEN); 
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
		
		// decimal button settings 
		decimalButton = new JButton(); 
		decimalButton.setText("."); 
		decimalButton.addActionListener(this);
		decimalButton.setFocusable(false); 
		decimalButton.setFont(buttonsFont);
		decimalButton.setForeground(Color.WHITE); 
		decimalButton.setBackground(new Color(0x3D3D3D));

		
		// clr button settings 
		clrButton = new JButton(); 
		clrButton.setText("AC");
		clrButton.addActionListener(this);
		clrButton.setFocusable(false); 
		clrButton.setFont(buttonsFont);
		clrButton.setBackground(new Color(0xE3E3E3));
		
		// delete button settings 
		backspaceButton = new JButton("Del");
		backspaceButton.addActionListener(this);
		backspaceButton.setFocusable(false); 
		backspaceButton.setFont(buttonsFont);
		backspaceButton.setForeground(Color.WHITE); 
		backspaceButton.setBackground(new Color(0x3D3D3D));
		
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
		
		// negative positive button settings 
		negPosButton = new JButton("+/-");
		negPosButton.addActionListener(this);
		negPosButton.setFocusable(false); 
		negPosButton.setFont(buttonsFont);
		negPosButton.setBackground(new Color(0xE3E3E3));
		
		// square root button settings 
		percentButton = new JButton("%");
		percentButton.addActionListener(this);
		percentButton.setFocusable(false); 
		percentButton.setFont(buttonsFont);
		percentButton.setBackground(new Color(0xE3E3E3));
		
		// equal button settings 
		eqButton = new JButton("=");
		eqButton.addActionListener(this);
		eqButton.setFocusable(false); 
		eqButton.setFont(buttonsFont);
		eqButton.setBackground(Color.ORANGE); 
		
		// panel1 settings 
		panel1 = new JPanel(); 
		panel1.setLayout(new GridLayout(5,4,0,0));
		panel1.setBounds(0, 90, 400, 500);
		panel1.setBackground(Color.BLACK);
		panel1.setOpaque(true); 
		
		
		panel1.add(clrButton);
		panel1.add(negPosButton);
		panel1.add(percentButton);
		panel1.add(divButton);
		
		panel1.add(numberButtons[7]); 
		panel1.add(numberButtons[8]);
		panel1.add(numberButtons[9]);
		panel1.add(multiButton);
		
		panel1.add(numberButtons[4]);
		panel1.add(numberButtons[5]);
		panel1.add(numberButtons[6]);
		panel1.add(minusButton); 
		
		panel1.add(numberButtons[1]);
		panel1.add(numberButtons[2]);
		panel1.add(numberButtons[3]);
		panel1.add(plusButton);
		
		panel1.add(numberButtons[0]);
		panel1.add(backspaceButton); 
		panel1.add(decimalButton); 
		panel1.add(eqButton); 
		
		// frame settings 
		
		this.setSize(415, 629);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(logo.getImage());
		this.setTitle("Calculator"); 
		this.getContentPane().setBackground(new Color(0x000000)); 
		this.setResizable(false); 
		this.setVisible(true); 
		
		
		// add components
		
		this.add(panel1); 
		this.add(text); 
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		
		// back space clicked 
		if (e.getSource() == backspaceButton)
		{
			
			if(text.getText().equalsIgnoreCase(""))
				text.setText("");
			else
				text.setText(text.getText().substring(0, text.getText().length() - 1));
		}
		
		// numbers clicked 
		
		for (int i = 0; i <=9 ; i++)
		{
			
			if(e.getSource() == numberButtons[i]) 
			{
				
				
				if(text.getText().length() <= 11)
				{
					text.setText(text.getText() + String.valueOf(i));
				}
				
			}
		}
		
		// clr button clicked 
		
		if (e.getSource() == clrButton) 
		{
			text.setText(""); 
			num1 = 0;
			num2 = 0;
			result = 0; 
			
		}
		
		// neagtvie postive button clicked 
		
		if (e.getSource() == negPosButton)
		{
			
		
			try 
			{
				
				String numStr;
				double num; 
			
				numStr = text.getText();
				num = Double.parseDouble(numStr) * -1; 
			
				text.setText(String.valueOf(num));
			
			}
				catch(NumberFormatException f) 
			{
				text.setText(""); 
			}
			
			
		}
		
		// decimal button clicked 
		if (e.getSource() == decimalButton)
		{
			
			text.setText(text.getText() + ".");  
		}
		
		// plus button clicked
		
		if (e.getSource() == plusButton)
		{
			
			num1 = Double.parseDouble(text.getText()); 
			function = '+'; 
			text.setText("");
			
		}
		
		// minus button clicked
		
		if (e.getSource() == minusButton)
		{
			
			num1 = Double.parseDouble(text.getText()); 
			function = '-'; 
			text.setText("");
			
		}
		
		
		// multiply button clicked
		
		if (e.getSource() == multiButton)
		{
			
			num1 = Double.parseDouble(text.getText()); 
			function = '*'; 
			text.setText("");
			
		}
		
		
		// division button clicked 
		
		if (e.getSource() == divButton)
		{
			
			num1 = Double.parseDouble(text.getText()); 
			function = '/'; 
			text.setText("");
			
		}
		
		// percent button clicked 
		
		if (e.getSource() == percentButton)
		{
			
			if(num1 != 0 || num2 != 0) 
			{
				num2 = Double.parseDouble(text.getText());  
				percentResult = num1 * num2 / 100;
				text.setText(String.valueOf(percentResult)); 
			}
			else
			{
				double num; 
				num = Double.parseDouble(text.getText());  
				text.setText(String.valueOf(num/100));  
			}
			
		}
		
		// equal button clicked 
		
		if (e.getSource() == eqButton)
		{
			
			num2 = Double.parseDouble(text.getText()); 
			 
			switch(function) 
			{
				case '+':
					result = num1 + num2; 
					break;
					
				case '-':
					result = num1 - num2; 
					break;
					
				case '*':
					result = num1 * num2; 
					break; 
					
				case '/':
					result = num1 / num2; 
					break; 

			}
			
			text.setText(String.valueOf(result)); 
			num1 = result; 
			
			if(text.getText().length()>= 11)
			{
				text.setFont(new Font("DialogInput", Font.BOLD, 35));
				
			}
			
		}
		
	}

}
