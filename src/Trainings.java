import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Cette application permet de présenter les formations FullTrainings
 * @author Stagiaires06P
 *
 */

public class Trainings {
	
	
	/**Cette méthode permet d'afficher les formations existantes sous forme de tableau
	 * @param trainingList liste des formations
	 */

	public static void displayTable(Map<Integer, ArrayList<String>> trainingList) {
		
		System.out.println("       Bonjour et Bienvenue dans mon application FullTrainings");
		System.out.println("Nous allons vous proposer une liste de formations actuellement disponibles");
		System.out.println("-------------------------------------------------------------------------------------");
	    System.out.printf("%-15s | %-10s | %-40s |%-10s |", "COURS", "NB JOURS", "DESCRIPTION", "PRIX");
	    System.out.println();
	    System.out.println("-------------------------------------------------------------------------------------");
	    
	   
	    
		for (int i=1;i<trainingList.size()+1;i++) {
			
			        System.out.format("%-15s | %-10s | %-40s |%-10s |", trainingList.get(i).get(0),trainingList.get(i).get(1),trainingList.get(i).get(2),
			        		trainingList.get(i).get(3));
			        System.out.println();
			        System.out.println("------------------------------------------------------------------------------------");
		}
		
		}
	
 

	
	
	
	public static void main(String[] args) {
		
	Map<Integer, ArrayList<String>> trainings = new HashMap<Integer, ArrayList<String>>();
	
	ArrayList<String> training1 = new ArrayList<String>();
	training1.add("Java");
	training1.add("20");
	training1.add("Java SE 8");
	training1.add("3000");

	trainings.put(1, training1);
	
	
	ArrayList<String> training2 = new ArrayList<String>();
	training2.add("Java avanc�");
	training2.add("20");
	training2.add("Exceptions, Fichiers, JDBC, threads");
	training2.add("5000");

	trainings.put(2, training2);
	
	ArrayList<String> training3 = new ArrayList<String>();
	training3.add("Spring");
	training3.add("20");
	training3.add("Spring Core");
	training3.add("5000");

	trainings.put(3, training3);
	
	ArrayList<String> training4 = new ArrayList<String>();
	training4.add("PHP Frameworks");
	training4.add("15");
	training4.add("Symphony");
	training4.add("2500");

	trainings.put(4, training4);
	
	
	ArrayList<String> training5 = new ArrayList<String>();
	training5.add("C#");
	training5.add("20");
	training5.add("DoNet Core");
	training5.add("5000");

	trainings.put(5, training5);
	
	
	displayTable(trainings);

	}

}
