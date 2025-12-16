package Steks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class UZD2 {
	private static ArrayList<Integer> visiIzvilktie = new ArrayList<>();
    private static Stack<Integer> steks = new Stack<>();
    private static Stack<Integer> laimigie = new Stack<>();
    private static int virMin = 0;
    private static int izlMin = -1;
    private static int spSk = 0;

    public static void main(String[] args) {

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            steks.push(rand.nextInt(10));
        }

        while (true) {
            String[] opcijas = {
                "Spelet izlosi",
                "Apskatit laimigos skaitlus",
                "Pievienot +1 minute",
                "Apturet"
            };

            int izvele = JOptionPane.showOptionDialog(
                    null,
                    "Virtual laiks(min): " + virMin +
                    "\nIzpeletas speles: " + spSk + "/3",
                    "Loterija",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcijas,
                    opcijas[0]
            );

            switch (izvele) {
                case 0:
                    veiktSpeli();
                    break;

                case 1:
                    paradiSteku();
                    break;

                case 2:
                    virMin++;
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "Programma ir aptureta",
                            "Apturesana",
                            JOptionPane.INFORMATION_MESSAGE);
                    return;
            }
        }
    }
    private static void veiktSpeli() {

        if (spSk >= 3) {
            JOptionPane.showMessageDialog(null,
                    "Ir jau izspeletas 3 speles!",
                    "Beigas",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (izlMin != -1 && virMin - izlMin < 1) {
            JOptionPane.showMessageDialog(null,
                    "Nakamo speli var sakt tikai pec 1 minutes",
                    "Kluda",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (steks.size() < 3) {
            JOptionPane.showMessageDialog(null,
                    "Steka nepietiek bumbinu",
                    "Kluda",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Random rand = new Random();
        StringBuilder rezultats = new StringBuilder();
        rezultats.append("Spele ").append(spSk + 1).append(":\n");

        for (int i = 0; i < 3; i++) {
            int noSteka = steks.pop();
            steks.push(noSteka);

            int nejauzs = rand.nextInt(10);
            visiIzvilktie.add(nejauzs);

            rezultats.append("Bumbina ")
                    .append(i + 1)
                    .append(": ")
                    .append(nejauzs)
                    .append("\n");
        }

        spSk++;
        izlMin = virMin;

       
        if (spSk == 3) {
            Collections.shuffle(visiIzvilktie);
            laimigie.clear();
            for (int i = 0; i < 3; i++) {
                laimigie.push(visiIzvilktie.get(i));
            }
        }

        JOptionPane.showMessageDialog(null,
                rezultats.toString(),
                "Speles rezultats",
                JOptionPane.INFORMATION_MESSAGE);
    }

   
    
   
    	private static void paradiSteku() {
    	    if (laimigie.isEmpty()) {
    	        JOptionPane.showMessageDialog(null,
    	                "Laimigie skaitli vel nav noteikti!",
    	                "Info",
    	                JOptionPane.INFORMATION_MESSAGE);
    	        return;
    	    }

    	    JOptionPane.showMessageDialog(null,
    	            "3 laimigas bumbinas:\n" + laimigie,
    	            "Laimigie skaitli",
    	            JOptionPane.INFORMATION_MESSAGE);
    	}

    }

