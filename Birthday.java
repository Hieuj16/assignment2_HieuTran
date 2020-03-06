import java.util.Random;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
/**
 * 
 * @author Hieu Tran
 *
 */
public class Birthday
{
	public static void main(String[] args)
	{
		String enterName = null, toyChoice, addCard, addBalloon,anotherToy="yes";
		toyChoice=null; // initialization
		String enterAge, enterAgain = "yes";
		String proName="Hieu Tran"; // programmer name
		int age; // convert String to integer
		boolean ageApproved; // condition true or false
		double totalCost=0.0; // the total of toy(s) and gift(s) if possibility
		Toy information = new Toy(); // the information from user
		Random rand = new Random();		
        int randDigits = rand.nextInt(100000);  // generate 5 digits
        String decimal="###,###.00";
        DecimalFormat df=new DecimalFormat(decimal);
        // A welcome  message
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company\nto choose gifts for young children");
		
		// do-while if the user wants another toy
		do {
			// this works when the user want to cancel the order
			while(enterAgain.equals("yes")) {
				// ask for the name
				enterName = JOptionPane.showInputDialog("Enter the name of the child");
				// ask for the age
				enterAge = JOptionPane.showInputDialog("How old is the child");
				age = Integer.parseInt(enterAge);
				information.setAge(age); // set the age
				// ask for toy's choice
				toyChoice = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
				information.setToy(toyChoice); // set toy
				// use true or false conditioning
				ageApproved = information.ageOK();
				// display a message to remind the user if ageOK is false
				if (ageApproved == !true) {
					enterAgain = JOptionPane.showInputDialog("The toy is not age appropriate\nDo you want to cancel the order? Yes or No ");
					// if answer is no; set toy
					if (enterAgain.equals("no")) {
						ageApproved = true;	
						information.setToy(toyChoice);
					}
				}
					else {
						enterAgain="no";
					}
				}
			// set cost
			information.setCost(toyChoice);
			// ask if the user wants to add a card
			addCard = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
			// if yes; add card
			if (addCard.equals("yes")) {
				information.addCard(addCard);
			}
			// ask if the user wants to add a balloon
			addBalloon = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");		
			// if yes; add balloon
			if (addBalloon.equals("yes")) {
				information.addBalloon(addBalloon);
			}
			// add the total up
			totalCost+=information.getCost();
			// display the message on the console
			System.out.println("The gift for "+enterName+information.toString());
			// ask if the user wants another toy
			anotherToy=JOptionPane.showInputDialog("Do you want another toy? Yes or No");
			// if yes; go back to the beginning from name
			if (anotherToy.equals("yes")) {
				enterAgain="yes";
			}
		}while (anotherToy.equals("yes")); // condition
			// display on the console
			System.out.println("The total cost of you order is $"+df.format((double)totalCost));
			System.out.println("Order number is "+randDigits);
			System.out.println(proName); // programmer name
	}
}

