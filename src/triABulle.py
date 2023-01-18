# Programmation de la version python du tri par insertion pour l'Exercice 5 de la SAE d'algorithmie.

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
                
            
    

tab = [4,5,7,8,9,4,1,2,0,12,14,14,10,11]
triABulle(tab)

for n in tab:
    print(str(n) + "\t", end= '')
    
print()