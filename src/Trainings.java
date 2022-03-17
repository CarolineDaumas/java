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
	
	public static void addTrainingCaddy(Map<Integer, ArrayList<String>> trainingList,Map<Integer, ArrayList<String>> trainingChoices) {
		
		displayTable(trainingList);
	
		System.out.println("Indiquez l'identifiant de la formation que vous voulez ajouter au panier");
		int idTraining = scan.nextInt();
		
		if (trainingList.get(idTraining)!=null) {	//si la formation existe
			if(trainingChoices.get(idTraining)==null) { //si la formation n'existe pas dans notre panier
 				trainingChoices.put(idTraining, trainingList.get(idTraining) );	
				trainingChoices.get(idTraining).add("1");		
				System.out.println("Formation ajoutée: "+ idTraining + " " + trainingList.get(idTraining));
			}
			else {
				int qte = Integer.parseInt(trainingChoices.get(idTraining).get(4));//On récupère la quantité qu'il y a dans la case 4 (le 1)
				//System.out.println(">>>" + trainingChoices.get(idTraining).get(4));
				trainingChoices.get(idTraining).set(4,String.valueOf(++qte));//On l'incrémente et la transforme en string
				
				System.out.println("--->" + trainingChoices.get(idTraining)); 
			}
		}
		
	
		
		else System.out.println("Cette formation n'existe pas");
		
		}
	
public static void removeTrainingCaddy(Map<Integer, ArrayList<String>> trainingList,Map<Integer, ArrayList<String>> trainingChoices) {
		
		System.out.println("Indiquez l'identifiant de la formation que vous voulez supprimer du panier");
		int idTraining = scan.nextInt();
		
		if (trainingChoices.get(idTraining)!=null) {
			if (trainingChoices.get(idTraining).get(4)=="1")
				trainingChoices.remove(idTraining, trainingList.get(idTraining) );
			else {
				int qte = Integer.parseInt(trainingChoices.get(idTraining).get(4));//On récupère la quantité qu'il y a dans la case 4 et la transforme en entier
			
			//System.out.println(">>>" + trainingChoices.get(idTraining).get(4));
			trainingChoices.get(idTraining).set(4,String.valueOf(--qte));//On la décrémente et la transforme en string
			
			System.out.println("--->" + trainingChoices.get(idTraining)); 
		}
		}
		
		else System.out.println("Cette formation n'existe pas");
		
		}
	
public static void printCaddy(Map<Integer, ArrayList<String>> trainingChoices) {
		
		System.out.println(trainingChoices);
	
}

	
public static void menu() {
		
		System.out.println();
		
		String menu[] = { "1-Afficher la liste des formations", "2- Ajouter une formation à votre panier", "3-Afficher votre panier",
				"4-Supprimer une formation","5-Quitter l'application" };

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
	
	Map<Integer, ArrayList<String>> trainingChoices= new HashMap <Integer, ArrayList<String>>();
	
	
	int nbMenu;
	int id=0;
	
	menu();
	do { 
		
		System.out.println("Choisissez une option");
		
		//while (scan.hasNextInt() == false) // ignore la saisie tant qu'il ne s'agit pas d'un entier
         //   scan.next();
		
		nbMenu = scan.nextInt();//l'utilisateur saisit un nombre correspondant au choix du menu
		
		//int id=trainingChoices.size()+1;
		switch (nbMenu) {
		
	
		
		case 1: displayTable(trainings);
				menu();
				break;
				
		case 2:
				addTrainingCaddy(trainings,trainingChoices);
				menu();
				break;
				
		case 3: printCaddy(trainingChoices);
				menu();
				break;
				
		case 4: removeTrainingCaddy(trainings, trainingChoices);
				menu();
				break;
				
		case 5: 
			break;

		default: System.out.println("saisie erronnée");
				break;
		}
		  } while (nbMenu!=5);
		scan.close();
			
		
		
	}
	
}

	
	
	
	

