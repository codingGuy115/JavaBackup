import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SalaryCalculatorMain 
{
	private static boolean fullTime = false;
	private static int numClicks = 0;
	
	private static boolean isDouble(String str)
	{
	     try{
	             Double.parseDouble(str);
	             return true;
	     }
	     catch(NumberFormatException e)
	     {
	          return false;
	     }
	}

	public static void main(String[] args) 
	{
		
		
		//Must make a new JFrame to start 
		JFrame myFrame = new JFrame("Salary Calculator Thing");
		myFrame.setBounds(300, 300, 400, 300);
		myFrame.setLayout(null);
		
		//Label to display final asDisplayLbl
		JLabel asDisplayLbl = new JLabel("Annual Salary: $");
		asDisplayLbl.setBounds(190, 180, 200, 40);
		myFrame.add(asDisplayLbl);
		
		// hourly rate label and text field
		JLabel hourlyRateLbl = new JLabel("Hourly Rate:");
		hourlyRateLbl.setBounds(40, 20, 80, 40);
		myFrame.add(hourlyRateLbl);
		JTextField hourlyRateField = new JTextField();
		hourlyRateField.setBounds(150, 28, 80, 30);
		myFrame.add(hourlyRateField);
		
		//hours per week label and text field
		JLabel hoursPerWeekLbl = new JLabel("Hours / week:");
		hoursPerWeekLbl.setBounds(40, 65, 80, 40);
		myFrame.add(hoursPerWeekLbl);
		JTextField hoursPerWeekField = new JTextField();
		hoursPerWeekField.setBounds(150, 70, 80, 30);
		myFrame.add(hoursPerWeekField);
		
		//full time checkbox and label
		JCheckBox fullTimeBox = new JCheckBox();
		fullTimeBox.setBounds(38, 140, 20, 20);
		fullTimeBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				numClicks++;
				if (numClicks % 2 == 1)
				{
					fullTime = true;
					System.out.println("FullTime box is checked.");
					hoursPerWeekField.setEnabled(false);
					hoursPerWeekField.setText("");
				}
				else
				{
					fullTime = false;
					System.out.println("FullTime box is unchecked.");
					hoursPerWeekField.setEnabled(true);
					
				}
				
			}
			
		});
		myFrame.add(fullTimeBox);
		
		JLabel fullTimeLbl = new JLabel("Full Time");
		fullTimeLbl.setBounds(70, 130, 80, 40);
		myFrame.add(fullTimeLbl);
		
		//calculate button and Annual Salary display label
		JButton calcButton = new JButton("CALCULATE");
		calcButton.setBounds(40, 180, 120, 45);
		calcButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				if (fullTime)
				{
					if (hourlyRateField.getText() == null)
					{
						System.out.println("This required field is empty.");
					}
					else
					{
						System.out.println("This required field is filled.");
						//now have to check if the text entered is a double
						if (SalaryCalculatorMain.isDouble(hourlyRateField.getText()))
						{
							System.out.println("This field IS a double.");
							double hrfValue = Double.parseDouble(hourlyRateField.getText());
							asDisplayLbl.setText("Annual Salary: $" + (40.0*hrfValue*52.0));
						}
						else
						{
							System.out.println("This field is NOT a double.");
						}
					}
				}
				else
				{
					//fullTime checkbox is not checked
					if (hourlyRateField.getText() == null || hoursPerWeekField == null)
					{
						System.out.println("One or more required fields is not filled in.");
					}
					else
					{
						//both filled, now need to make sure both are a double
						if ((SalaryCalculatorMain.isDouble(hourlyRateField.getText()) && (SalaryCalculatorMain.isDouble(hoursPerWeekField.getText()))))
						{
							System.out.println("Both fields are filled and are doubles.");
							asDisplayLbl.setText("Annual Salary: $" + ((Double.parseDouble(hoursPerWeekField.getText()))*(Double.parseDouble(hourlyRateField.getText()))*52.0));
						}
						else
						{
							System.out.println("One or more of the filled fields is not a double.");
						}
					}
				}
				
			}
			
		});
		myFrame.add(calcButton);
		
		//always last two lines
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
