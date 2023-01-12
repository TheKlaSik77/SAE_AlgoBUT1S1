
import java.util.Arrays;
import java.util.Random;
public class SAE2 {

    public static void main(String[] args) {

        long tempsSortJava = moyenneDeVitesseDExecutionTriInsertion(200000,10);
        long tempsTriInsertion = moyenneDeVitesseDExecutionTriInsertion(200000,10);
        long tempsTriBulle = moyenneDeVitesseDExecutionTriBulle(200000,10);


    }

    /*
        Retourne un tableau de int de longueur n rempli avec des valeurs aleatoires
        (valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */

    public static long moyenneDeVitesseDExecutionSortJava(int nbDonnees, int nbTests){

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
    public static long moyenneDeVitesseDExecutionTriInsertion(int nbDonnees, int nbTests){

        long tempsCalcul = 0;
        long somme = 0;

        for (int cpt = 0 ; cpt < nbTests ; cpt++){
            int[] donnees = genererDonnees(nbDonnees);

            long tempsDebut = System.nanoTime();

            triParInsertion(donnees); // trie le tableau en utilisant un algorithme de type Quicksort

            long tempsFin = System.nanoTime();

            tempsCalcul = (tempsFin - tempsDebut) / 1000000;
            somme += tempsCalcul;
        }
        return somme / nbTests;


    }

    public static long moyenneDeVitesseDExecutionTriBulle(int nbDonnees, int nbTests){

        long tempsCalcul = 0;
        long somme = 0;

        for (int cpt = 0 ; cpt < nbTests ; cpt++){
            int[] donnees = genererDonnees(nbDonnees);

            long tempsDebut = System.nanoTime();

            triABulle(donnees); // trie le tableau en utilisant un algorithme de type Quicksort

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

    public static void triParInsertion(int[] tab) {

        int compteur = 0;
        for (int i = 1 ; i < tab.length ; i++) {
            if (tab[i] >= tab[i-1]) {
                compteur++;
            } else {
                compteur++;
                int j;
                int pivot;
                for (j = compteur; j > 0 && tab[j-1] > tab[j] ; j--) {
                    pivot = tab[j];
                    tab[j] = tab[j-1];
                    tab[j-1] = pivot;

                }

            }
        }
        System.out.println("compteur : " + compteur);

    }

    public static void triABulle(int[] tab){

        boolean aEchange;
        int pivot;

        do {
            aEchange = false;
            for (int i = 1 ; i < tab.length ; i++){
                if (tab[i] < tab[i-1]){
                    pivot = tab[i];
                    tab[i] = tab[i-1];
                    tab[i-1] = pivot;
                    aEchange = true;
                }
            }
        } while (aEchange);

    }
}
