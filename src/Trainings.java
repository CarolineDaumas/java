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
	 * @param trainingList - liste des formations
	 */
	public static void displayTable(Map<Integer, ArrayList<String>> trainingList) {
		
		System.out.println("Voici la liste de formations actuelles");
		System.out.println("---------------------------------------------------------------------------------------------------------");
	    System.out.printf("%5s | %-15s | %-10s | %-40s |%-10s |%-15s |", "REF.","COURS", "NB JOURS", "DESCRIPTION", "PRIX","DISPONIBILITE");
	    System.out.println();
	    System.out.println("-----------------------------------------------------------------------------------------------------------");
	    
		for (int i=1;i<trainingList.size()+1;i++) {
			
			        System.out.format("%5s | %-15s | %-10s | %-40s |%-10s |%-15s |", i , trainingList.get(i).get(0),trainingList.get(i).get(1),trainingList.get(i).get(2),
			        		trainingList.get(i).get(3),trainingList.get(i).get(4));
			        System.out.println();
			        System.out.println("-------------------------------------------------------------------------------------------------------");
		}
		}
	
	/**Cette méthode permet d'ajouter une formation au panier
	 * 
	 * @param trainingList - liste des formations
	 * @param trainingChoices - Panier de formations choisies
	 */
	
	public static void addTrainingCaddy(Map<Integer, ArrayList<String>> trainingList,Map<Integer, ArrayList<String>> trainingChoices) {
		
		displayTable(trainingList);
	
		System.out.println("Indiquez l'identifiant de la formation que vous voulez ajouter au panier");
		int idTraining = scan.nextInt();
		
		
		
		if (trainingList.get(idTraining)!=null) {//si la formation existe
			
			if(trainingList.get(idTraining).get(4).equals("disponible")) {//si la formation est disponible
				
			if(trainingChoices.get(idTraining)==null) { //si la formation n'existe pas dans notre panier
 				trainingChoices.put(idTraining, trainingList.get(idTraining) );	
				trainingChoices.get(idTraining).add("1");		
				System.out.println("Formation ajoutée: "+ idTraining + " " + trainingList.get(idTraining));
			}
			else { //s'il y a déjà une ou plusieurs formations dans le panier
				int qte = Integer.parseInt(trainingChoices.get(idTraining).get(5));//On récupère la quantité qu'il y a dans la case 5 en entier
				trainingChoices.get(idTraining).set(5,String.valueOf(++qte));//On l'incrémente et la transforme en string
				
				System.out.println("formation ajoutée --->" + trainingChoices.get(idTraining)); 
			}
		}	
			else System.out.println("Cette formation est indisponible à l'achat");
		}
		else System.out.println("Cette formation n'existe pas");
		
		}
	
	
	/** Cette méthode permet de supprimer une formation du panier.
	 * 
	 * @param trainingList - liste des formations
	 * @param trainingChoices - Panier de formations choisies
	 */
	
public static void removeTrainingCaddy(Map<Integer, ArrayList<String>> trainingList,Map<Integer, ArrayList<String>> trainingChoices) {
		
		System.out.println("Indiquez l'identifiant de la formation que vous voulez supprimer du panier");
		int idTraining = scan.nextInt();
	
		
		if (trainingChoices.get(idTraining)!=null) {
			//S'il y a une seule formation dans le panier, la supprimer
			if (trainingChoices.get(idTraining).get(5)=="1") {
				trainingChoices.remove(idTraining, trainingList.get(idTraining) );
				System.out.println("Formation supprimée du panier");
				}
			else { 
				int qte = Integer.parseInt(trainingChoices.get(idTraining).get(5));//On récupère la quantité qu'il y a dans la case 4 et la transforme en entier
			trainingChoices.get(idTraining).set(5,String.valueOf(--qte));//On la décrémente et la transforme en string
			System.out.println("Formation supprimée du panier");
		}
		}
		
		else System.out.println("Cette formation n'existe pas");
		
		}


/** Cette méthode permet d'afficher le panier de formations choisies par l'utilisateur, sans le prix total
 * 
 * @param trainingChoices - le panier de formations choisies
 */
	
public static void printCaddy(Map<Integer, ArrayList<String>> trainingChoices) {
		
	if (! trainingChoices.isEmpty()) {
		
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s | %-15s | %-10s | %-40s |%-10s |%-15s |%-10s |", "REF.", "COURS", "NB JOURS", "DESCRIPTION",
				"PRIX", "DISPONIBILITE", "QTE");
		System.out.println();
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------");

		for (HashMap.Entry<Integer, ArrayList<String>> m : trainingChoices.entrySet()) {

			System.out.format("%5s | %-15s | %-10s | %-40s |%-10s |%-15s |%-10s |", m.getKey(), m.getValue().get(0),
					m.getValue().get(1), m.getValue().get(2), m.getValue().get(3), m.getValue().get(4), m.getValue().get(5));
			System.out.println();
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------");
		}
	}
	
	else System.out.println("Votre panier est vide");
}

/** Cette méthode permet d'afficher le paniercomplet avec un message précisant le total de la commande
 * 
 * @param trainingChoices - le panier de formations choisies
 */

public static void printCaddyWithTotal(Map<Integer, ArrayList<String>> trainingChoices) {
	int total = 0;
	int prix=0;
	if (! trainingChoices.isEmpty()) {
		
		for (HashMap.Entry<Integer, ArrayList<String>> m : trainingChoices.entrySet()) {
			prix= Integer.parseInt(m.getValue().get(3)); 
			int qty= Integer.parseInt(m.getValue().get(5));
			total=total+(prix*qty);
			
		}
		System.out.println(
				"------------------------------------------------------------------------------------------------------------");
		System.out.printf("%5s | %-15s | %-10s | %-40s |%-10s |%-15s |%-10s |", "REF.", "COURS", "NB JOURS", "DESCRIPTION",
				"PRIX", "DISPO", "QTE");
		System.out.println();
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------");

		for (HashMap.Entry<Integer, ArrayList<String>> m : trainingChoices.entrySet()) {

			System.out.format("%5s | %-15s | %-10s | %-40s |%-10s |%-15s |%-10s |", m.getKey(), m.getValue().get(0),
					m.getValue().get(1), m.getValue().get(2), m.getValue().get(3), m.getValue().get(4), m.getValue().get(5));
			System.out.println();
			System.out.println(
					"-------------------------------------------------------------------------------------------------------------");
		}
		
		System.out.println("Le prix total de votre panier est de "+ total + "€");
		
	}
	
	else System.out.println("Votre panier est vide");
}
	

/**Cette méthode permet de valider le panier, c'est-à-dire confirmer l'achat et donc vider le panier, si l'utilisateur confirme le vouloir
 * 
 * @param trainingChoices - le panier de formations choisies
 */

public static void validateCaddy(Map<Integer, ArrayList<String>> trainingChoices) {
	
	printCaddyWithTotal(trainingChoices);
	
	String answer;
	
	do {
		System.out.println("Souhaitez-vous valider le panier? oui/non");
	answer = scan.next();
	}
	while (!answer.equals("oui") && !answer.equals("non"));
	
	if (answer.equals("oui")) {
		trainingChoices.clear();
		System.out.println("panier vidé");}
		//for (HashMap.Entry<Integer, ArrayList<String>> m : trainingChoices.entrySet()) {
		//trainingChoices.remove(m.getKey(), m.getValue()); }
		
		else System.out.println("Opération annulée / Votre panier n'a pas été vidé");
} 



/**Cette méthode permet d'appeler le menu
 * 
 */

public static void menu() {
		
		System.out.println();
		System.out.println();
		
		String menu[] = { "1-Afficher la liste des formations", "2- Ajouter une formation à votre panier", "3-Afficher votre panier",
				"4-Supprimer une formation","5-Afficher votre panier avec le montant total", "6-Valider votre panier"};

		for (int i = 0; i < menu.length; i++)
			{
			System.out.println(menu[i]);
			System.out.println();
			}
	}
	
	
	
	public static void main(String[] args) {
		
	Map<Integer, ArrayList<String>> trainings = new HashMap<Integer, ArrayList<String>>();
	
	ArrayList<String> training1 = new ArrayList<String>();
	training1.add("Java");
	training1.add("20");
	training1.add("Java SE 8");
	training1.add("3000");
	training1.add("disponible");
	
	trainings.put(1, training1);
	
	
	ArrayList<String> training2 = new ArrayList<String>();
	training2.add("Java avancé");
	training2.add("20");
	training2.add("Exceptions, Fichiers, JDBC, threads");
	training2.add("5000");
	training2.add("disponible");

	trainings.put(2, training2);
	
	ArrayList<String> training3 = new ArrayList<String>();
	training3.add("Spring");
	training3.add("20");
	training3.add("Spring Core");
	training3.add("5000");
	training3.add("disponible");

	trainings.put(3, training3);
	
	ArrayList<String> training4 = new ArrayList<String>();
	training4.add("PHP Frameworks");
	training4.add("15");
	training4.add("Symphony");
	training4.add("2500");
	training4.add("disponible");

	trainings.put(4, training4);
	
	
	ArrayList<String> training5 = new ArrayList<String>();
	training5.add("C#");
	training5.add("20");
	training5.add("DoNet Core");
	training5.add("5000");
	training5.add("disponible");

	trainings.put(5, training5);
	
	
	ArrayList<String> training6 = new ArrayList<String>();
	training6.add("Angular");
	training6.add("20");
	training6.add("Angular 8");
	training6.add("5000");
	training6.add("indisponible");

	trainings.put(6, training6);
	
	Map<Integer, ArrayList<String>> trainingChoices= new HashMap <Integer, ArrayList<String>>();
	
	
	int nbMenu;
	
	System.out.println("       Bonjour et Bienvenue dans mon application FullTrainings");
	System.out.println();
	System.out.println("Saisissez le chiffre correspondant à votre choix parmi la liste suivante : ");
	menu();
	do { 
		
		System.out.println("Choisissez une option, saisir un chiffre");
		
		while (scan.hasNextInt() == false) // ignore la saisie tant qu'il ne s'agit pas d'un entier
        scan.next();
		
		nbMenu = scan.nextInt();//l'utilisateur saisit un nombre correspondant au choix du menu
		
	
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
				
		case 5: printCaddyWithTotal(trainingChoices);
				menu();
				break;
			
		case 6: validateCaddy(trainingChoices);
				menu();
				break;
				
		case 7: System.out.println("Au revoir");
				break;

		default: System.out.println("saisie erronnée");
					break;
		}
		  } while (nbMenu!=7);
		scan.close();
			
		
		
	}
	
}

	
	
	
	

