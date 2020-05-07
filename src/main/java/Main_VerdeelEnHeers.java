public class Main_VerdeelEnHeers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] rij = {3,4,-5,2,-18,6,11,-4,5};

        Deelrij maxInt = MaxSomVerdeelEnHeersRij.maxSom(rij);
        System.out.println("Snelle versie voor rij1 = " + maxInt);
        /*
        int[] rij2 = {9, -8, -6, 7, -4, 8, -7, 5};
        System.out.println("Rij2 = {9, -8, -6, 7, -4, 8, -7, 5}");
        max = MaxSomBruteForce.maxSom(rij2);
        System.out.println("Trage versie voor rij2 = " + max);
        max = MaxSomDeelrijVerdeelEnHeers.maxSom(rij2);
        System.out.println("Snelle versie voor rij2 = " + max);
        */
    }
}
