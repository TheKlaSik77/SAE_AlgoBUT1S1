# Programmation de la version python du tri par insertion pour l'Exercice 5 de la SAE d'algorithmie.

import time
import random
"""
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
"""
"""
public static int[] genererDonnees(int n) {
    Random random = new Random();
    int[] t = new int[n];
    for (int i = 0 ; i < t.length ; i++)
        t[i] = random.nextInt(); // tirage aleatoire d'un int quelconque (compris entre -2^31 et 2^31-1)
    return t;
}
"""
def genererDonnees(nbDonnees):
    
    tab = nbDonnees  * [0]
    for i in range (0,nbDonnees):
        tab[i] = random.randint(-2147483648,2147483648)

    return tab
        
    
def triABulle(tab):
    
    aEchange = True
    while aEchange == True:
        aEchange = False
        for i in range(1,len(tab)):
            if tab[i] < tab[i-1]:
                pivot = tab[i]
                tab[i] = tab[i-1]
                tab[i-1] = pivot
                aEchange = True 
                
            
    

tab = genererDonnees(2000)
tempsDebut = time.time() * 1000000000
triABulle(tab)
tempsFin = time.time() * 1000000000


    
print()
print((tempsFin-tempsDebut) / 1000000)