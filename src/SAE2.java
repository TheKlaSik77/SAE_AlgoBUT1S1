
import java.util.Arrays;
import java.util.Random;
public class SAE2 {

    public static void main(String[] args) {

        /*
        // int[] donnees = genererDonneesEntreBornes(50, 0, 20);
        // System.out.println(Arrays.toString(donnees));

        int[] donnees = genererDonnees(200000);

        long tempsDebut = System.nanoTime();

        Arrays.sort(donnees); // trie le tableau en utilisant un algorithme de type Quicksort

        long tempsFin = System.nanoTime();

        System.out.println("Temps de calcul en millisecondes: " + ((tempsFin - tempsDebut) / 1000000) );

        //System.out.println(Arrays.toString(donnees));



        System.out.println( "Moyenne pour 50 tours de la vitesse execution pour 200 000 valeurs dans le tableau : " + moyenneDeVitesseDExecution(200000,50) + "ms");
        System.out.println( "Moyenne pour 10 tours de la vitesse execution pour 1 000 000 valeurs dans le tableau : " + moyenneDeVitesseDExecution(10000000,10) + "ms");

         */
        int[] tab = {0,4,1,2,4,32,14,1,0,144,17};
        triParInserer(tab);
        for (int n : tab){
            System.out.println(n);
        }

    }

    /*
        Retourne un tableau de int de longueur n rempli avec des valeurs aleatoires
        (valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */

    public static long moyenneDeVitesseDExecution(int nbDonnees, int nbTests){

            long tempsCalcul = 0;
            long somme = 0;

            for (int cpt = 0 ; cpt < nbTests ; cpt++){
                int[] donnees = genererDonnees(nbDonnees);

                long tempsDebut = System.nanoTime();

                Arrays.sort(donnees); // trie le tableau en utilisant un algorithme de type Quicksort

                long tempsFin = System.nanoTime();

                tempsCalcul = (tempsFin - tempsDebut) / 1000000;
                somme += tempsCalcul;
            }
            return somme / nbTests;


    }
    public static int[] genererDonnees(int n) {
        Random random = new Random();
        int[] t = new int[n];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(); // tirage aleatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
        return t;
    }

    /*
        Retourne un tableau de int de longueur n rempli avec des valeurs aleatoires comprises entre min et max inclus.
    */
    public static int[] genererDonneesEntreBornes(int n, int min, int max) {
        Random random = new Random();
        int[] t = new int[n];
        for (int i = 0 ; i < t.length ; i++)
            t[i] = random.nextInt(max-min+1)+min; // nextInt(borne) retourne un int compris entre 0 inclus et borne exclus.
        return t;
    }

    public static void triParInserer(int[] tab) {

        int compteur = 0;
        for (int i = 1 ; i < tab.length ; i++) {
            if (tab[i] >= tab[i - 1]) {
                compteur++;
            } else {
                compteur++;
                int j;
                int pivot = tab[i];
                for (j = compteur; j > 0 && tab[j - 1] > tab[i]; j--) {
                    tab[j] = tab[j - 1];
                }
                tab[j] = pivot;

            }
        }

    }
}
