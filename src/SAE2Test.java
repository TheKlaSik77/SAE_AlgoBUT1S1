import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SAE2Test {

    @Test
    void triParInsertion() {

        int[] tab = {4,4,7,8,1,2,3,4,7,7,1,78,74};
        int[] tabTrie = {1,1,2,3,4,4,4,7,7,7,8,74,78};

        SAE2.triParInsertion(tab);
        assertArrayEquals(tabTrie,tab);
    }

    @Test
    void triABulle() {
        int[] tab = {4,4,7,8,1,2,3,4,7,7,1,78,74};
        int[] tabTrie = {1,1,2,3,4,4,4,7,7,7,8,74,78};

        SAE2.triABulle(tab);
        assertArrayEquals(tabTrie,tab);
    }

    @Test
    void triAPeigne() {
        int[] tab = {4,4,7,8,1,2,3,4,7,7,1,78,74};
        int[] tabTrie = {1,1,2,3,4,4,4,7,7,7,8,74,78};

        SAE2.triAPeigne(tab);
        assertArrayEquals(tabTrie,tab);
    }

    @Test
    void triAComptage() {
        int[] tab = {4,-4,7,8,1,2,3,4,-7,7,1,-78,74};
        int[] tabTrie = {-78,-7,-4,1,1,2,3,4,4,7,7,8,74};

        SAE2.triAComptage(tab,-78,74);
        assertArrayEquals(tabTrie,tab);
    }

    @Test
    void kylianLasik_YasmineBenYoussef() {

        int[] tab = SAE2.genererDonnees(100000000);
        int[] centPlusGrandesValeurs = SAE2.nPlusGrandesValeursAvecSortJava(tab,100);
        int[] tabFinal = SAE2.kylianLasik_YasmineBenYoussef(tab,100);
        // On crée un tableau de 2000 données, on obtient les 100 plus grand dans l'ordre décroissant avec Sort Java, puis on teste l'égalité entre les deux tableaux.
        assertArrayEquals(centPlusGrandesValeurs,tabFinal);
    }
}