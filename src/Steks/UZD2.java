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
	 
	 int izvele = JOptionPane.showOptionDialog(null, "Virtual laiks(min)"+virMin+ "\nIzpeletas speles: "+spSk+"/3","Loterija",
			  JOptionPane.DEFAULT_OPTION,
			  JOptionPane.INFORMATION_MESSAGE,
			  null,
			  opcijas,
			  opcijas[0]);
	 
	 do {
		 switch(izvele){
		 
		 case 0:
			 veiktSpeli();
			 break;
			 
		 case 1:
		 paradiSteku();
			 break;
			 
		 case 3:
			 virMin();
			 break;
			 
		 case 4:
			 JOptionPane.showMessageDialog(null, "Programma ir aptureta","Apturesana",JOptionPane.INFORMATION_MESSAGE);
			 break;
		 }while(izvele !=4);
	 }while(izvele !=4);
 }
	 
	 
 
	}
	private static void veiktSpeli() {
		if(spSk >= 3) {
			JOptionPane.showMessageDialog(null, "Ir jau izpeletas 3 speles!", "Beigas",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if(izlMin != -1) {
			if(virMin - izlMin < 1) {
				JOptionPane.showMessageDialog(null, "Nakamo speli var sakt tikai pec 1 virMin","Kluda", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if(steks.size()<3) {
			JOptionPane.showMessageDialog(null, "Steka nepietiek bumbinu","Kluda",JOptionPane.ERROR_MESSAGE);
			return;
		}
		Random rand = new Random();
		StringBuilder rezultats = new StringBuilder();
		rezultats.append("Spele ").append(spSk + 1).append(" (3 bumbunas): \n");
		
		for(int i = 0; i< 3; i++) {
			int noSteka = steks.pop();
			int nejauzs = rand.nextInt(10);
			steks.push(noSteka);
			steks.push(nejauzs);
			rezultats.append("Bumbina").append(i + 1).append("; ").append(noSteka).append(" + ").append(nejauzs).append("\n");
			
		}
		spSk++;
	izlMin = virMin;
	JOptionPane.showMessageDialog(null, rezultats.toString(),"Speles rezultats",JOptionPane.INFORMATION_MESSAGE);
	}
	private static void paradiSteku() {
		JOptionPane.showMessageDialog(null, "Laimigo skaitlu steks:\n"+steks.toString(),"Steks",JOptionPane.INFORMATION_MESSAGE);
	}
	private static void virMin() {
		virMin++;
		return;
		
	}
}

