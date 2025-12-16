package Steks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class UZD2 {
private static Stack<Integer>steks = new Stack<>();
private static int virMin = 0;
private static int izlMin = -1;
private static int spSk = 0;

	public static void main(String[] args) {
 Random rand = new Random();
 for(int i = 0; i < 10; i++) {
	 steks.push(rand.nextInt(10));
 }
 while(true) {
	 String[]opcijas = {
			 "Spelet izlosi","Apskatit laimigos skaitlus","Pievienot +1 minute","Apturet"};	  
	 
	 String izvele = (String)JOptionPane.showInputDialog(null,
				"Izvelies darbibu", "DArbibu saraksts",
				JOptionPane.QUESTION_MESSAGE,null,
				opcijas, opcijas[0]);
	 if(izvele == null)
			izvele = "Apturet";
	 do {
		 switch(izvele){
		 
		 case "Spelet izlosi":
			 veiktSpeli();
			 break;
			 
		 case"Apskatit laimigos skaitlus":
			 paradiSteku();
			 break;
			 
		 case"Pievienot +1 minute":
			 virMin++;
			 JOptionPane.showMessageDialog(null, "Pievienota 1 minute"+virMin,"Laiks",JOptionPane.INFORMATION_MESSAGE);
			 break;
		 case"Apturet":
			 JOptionPane.showMessageDialog(null, "Programma ir aptureta","Apturesana",JOptionPane.INFORMATION_MESSAGE);
			 break;
		 }
	 }while(!izvele.equals("Apturet"));
	 
	 
 }
	}
}

