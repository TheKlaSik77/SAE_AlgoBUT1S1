
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
public class SAE2 {

    public static void main(String[] args) {
        // Exercice 1 :
        /*
        long tempsSortJava = moyenneDeVitesseDExecutionSortJava(200000,1);
        long tempsTriInsertion = moyenneDeVitesseDExecutionTriInsertion(200000,1);
        long tempsTriBulle = moyenneDeVitesseDExecutionTriBulle(200000,1);

        System.out.println("Temps, sur 1 exécution, pour la fonction tri de JAVA : " + tempsSortJava + " ms");
        System.out.println("Temps, sur 1 exécution, pour la fonction tri par insertion de complexité n² : " + tempsTriInsertion + " ms");
        System.out.println("Temps, sur 1 exécution, pour la fonction tri à bulle de complexité n² : " + tempsTriBulle + " ms");
        */

        // Exercice 3 :
        /*
        int[] tab = genererDonneesEntreBornes(30,5,20);
        for (int n : tab){
            System.out.print(n + "\t");
        }
        System.out.println();
        triAComptage(tab,5,20);
        for (int n : tab){
            System.out.print(n + "\t");
        }
        System.out.println();
        */

        // Exercice 4 :
        /*
        // Version avec quickSort


        */
        int[] tab1 = genererDonnees(100000000);
        int[] tabFinal1 = nPlusGrandesValeursAvecNotreAlgo(tab1,100);
        for (int n : tabFinal1){
            System.out.print(n + "\t");
        }
        System.out.println("\n");

        int[] tab2 = genererDonnees(100000000);
        int[] tabFinal2 = nPlusGrandesValeursAvecSortJava(tab2,100);
        for (int n : tabFinal2){
            System.out.print(n + "\t");
        }

    }



    /*
        Retourne un tableau de int de longueur n rempli avec des valeurs aleatoires
        (valeurs comprises entre Integer.MIN_VALUE=-2^31 et Integer.MAX_VALUE=2^31-1 inclus).
    */
    public static int[] nPlusGrandesValeursAvecSortJava(int[] tab, int n){
        long tempsCalcul2 = 0;
        long tempsDebut2 = System.nanoTime();
        int[] nPlusGrandesValeurs = new int[n];
        int cpt = 0;
        Arrays.sort(tab); // trie le tableau en utilisant un algorithme de type Quicksort
        for (int i = tab.length - 1; i > tab.length - 1 - n + 1; i--){
            nPlusGrandesValeurs[cpt] = tab[i];
            cpt++;
        }
        

        long tempsFin2 = System.nanoTime();

        tempsCalcul2 = (tempsFin2 - tempsDebut2) / 1000000;
        System.out.println("\n");

        System.out.println("Temps de calcul de Quicksort java puis prendre les 100 derniers : " + tempsCalcul2 + "ms.");
        return nPlusGrandesValeurs;
    }
    public static int[] nPlusGrandesValeursAvecNotreAlgo(int[] tab, int n){


        long tempsCalcul1 = 0;
        // Mon Programme :
        long tempsDebut1 = System.nanoTime();
        int[] nPlusGrandesValeurs = new int[n];
        int min = tab[0];
        int indiceMin = 0;
        for (int i = 0 ; i < nPlusGrandesValeurs.length ; i++){
            if (tab[i] < min){
                min = tab[i];
                indiceMin = i;
            }
            nPlusGrandesValeurs[i] = tab[i];
        }

        System.out.println();
        for (int i = nPlusGrandesValeurs.length ; i < tab.length ; i++){
            if (tab[i] > min){
                nPlusGrandesValeurs[indiceMin] = tab[i];
                min = nPlusGrandesValeurs[0];
                indiceMin = 0;
                for (int j = 0 ; j < nPlusGrandesValeurs.length ; j++){
                    if (nPlusGrandesValeurs[j] < min){
                        min = nPlusGrandesValeurs[j];
                        indiceMin = j;
                    }
                }
            }
        }
        int compteur = 0;
        for (int i = 1 ; i < nPlusGrandesValeurs.length ; i++) {
            compteur++;
            if (nPlusGrandesValeurs[i] > nPlusGrandesValeurs[i - 1]) {
                int j;
                int pivot;
                for (j = compteur; j > 0 && nPlusGrandesValeurs[j - 1] < nPlusGrandesValeurs[j]; j--) {
                    pivot = nPlusGrandesValeurs[j];
                    nPlusGrandesValeurs[j] = nPlusGrandesValeurs[j - 1];
                    nPlusGrandesValeurs[j - 1] = pivot;

                }

            }
        }
        long tempsFin1 = System.nanoTime();
        tempsCalcul1 = (tempsFin1 - tempsDebut1) / 1000000;
        System.out.println("\n");
        System.out.println("Temps de calcul de notre version : " + tempsCalcul1 + "ms.");
        return nPlusGrandesValeurs;
    }

    public static long moyenneDeVitesseDExecutionSortJava(int nbDonnees, int nbTests){

            long tempsCalcul = 0;
            long somme = 0;

            for (int cpt = 0 ; cpt < nbTests ; cpt++){
                int[] donnees = genererDonnees(nbDonnees);

                long tempsDebut = System.nanoTime();
                int n = 1;
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

    public static void triAComptage(int[] tab, int min, int max){

        int cpt = 0;
        int indiceActuel = 0;
        int[] histogramme = new int[(max - min) + 1];
        for (int i = 0 ; i < tab.length ; i++) {
            histogramme[tab[i] - min]++;
        }
        for(int i = 0 ; i < histogramme.length ; i++){
            if (histogramme[i] > 0){
                cpt = histogramme[i];
                while (cpt > 0){
                    tab[indiceActuel] = i + min;
                    indiceActuel++;
                    cpt--;
                }
            }
        }
    }

    public static void plusGrandeValeurTab(int[] tab){
         if (tab.length > 0){
             int max = tab[0];
             for (int i = 0 ; i < tab.length ; i++){
                 if (tab[i] > max){
                     max = tab[i];
                 }
             }
             System.out.println("Plus grand : " + max + ".");
         }


    }

}

