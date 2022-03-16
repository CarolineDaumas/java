import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Cette application permet de présenter les formations FullTrainings
 * @author Stagiaires06P
 *
 */

public class Trainings {
	
	
	public static final Scanner scan=new Scanner(System.in);
	
	/**Cette méthode permet d'afficher les formations existantes sous forme de tableau
	 * @param trainingList liste des formations
	 */
	public static void displayTable(Map<Integer, ArrayList<String>> trainingList) {
		
		System.out.println("       Bonjour et Bienvenue dans mon application FullTrainings");
		System.out.println("Nous allons vous proposer une liste de formations actuellement disponibles");
		System.out.println("-------------------------------------------------------------------------------------");
	    System.out.printf("%5s | %-15s | %-10s | %-40s |%-10s |", "REF.","COURS", "NB JOURS", "DESCRIPTION", "PRIX");
	    System.out.println();
	    System.out.println("-------------------------------------------------------------------------------------");
	    
	   
	    
		for (int i=1;i<trainingList.size()+1;i++) {
			
			        System.out.format("%5s | %-15s | %-10s | %-40s |%-10s |", i , trainingList.get(i).get(0),trainingList.get(i).get(1),trainingList.get(i).get(2),
			        		trainingList.get(i).get(3));
			        System.out.println();
			        System.out.println("------------------------------------------------------------------------------------");
		}
		
		}
	
	public static void addTrainingCaddy(Map<Integer, ArrayList<String>> trainingList,Map<Integer, ArrayList<String>> trainingChoices, int id) {
		
		
		displayTable(trainingList);
	
		System.out.println("Indiquez l'identifiant de la formation que vous voulez ajouter au panier");
		int idTraining = scan.nextInt();
		
		if (trainingList.get(idTraining)!=null) {
			trainingChoices.put(id, trainingList.get(idTraining));
			System.out.println("Formation ajoutée: "+ idTraining+ trainingList.get(idTraining));
		}
		
		else System.out.println("Cette formation n'existe pas");
		
		}
	
	
	
public static void menu() {
		
		System.out.println();
		
		String menu[] = { "1-Afficher la liste des formations", "2- Ajouter une formation à votre panier", "3-Afficher votre panier",
				"4-Quitter l'application" };

		for (int i = 0; i < menu.length; i++)
			{System.out.println(menu[i]);
			System.out.println();}
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
	training2.add("Java avancé");
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
	
	Map<Integer, ArrayList<String>> trainingChoices= new HashMap<Integer, ArrayList<String>>();
	
	
	int nbMenu;
	
	menu();
	do { 
		
		System.out.println("Choisissez une option");
		
		//while (scan.hasNextInt() == false) // ignore la saisie tant qu'il ne s'agit pas d'un entier
         //   scan.next();
		
		nbMenu = scan.nextInt();//l'utilisateur saisit un nombre correspondant au choix du menu
			
		switch (nbMenu) {
		
		case 1: displayTable(trainings);
				menu();
				break;
				
		case 2: int id=trainingChoices.size()+1;
				addTrainingCaddy(trainings,trainingChoices,id);
				menu();
				break;
				
		case 3: System.out.println(trainingChoices);
				break;
				
		case 4: System.out.println("Au revoir");
				break;

		default: System.out.println("saisie erronnée");
				break;
		}
		  } while (nbMenu!=4);
		scan.close();
			
		
		//displayTable(trainings);
		//addTrainingCaddy(trainings);
	}
	
}

	
	
	
	

