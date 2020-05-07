public class BruteForce {

    /**
     * Dit programma zoekt het aantal volgorde fouten in een rij
     * @author Arno Molenaers
     * @param args Argumenten die worden mee gegeven aan het programma
     * @since 21/04/2020
     * @version 1.0
     */
    public static void main(String[] args) {

        //int[] rij = {1,2,14,3,5,8,6,7,9,11,10,12,4,15};
        int[] rij = {1,2,14,3,5,8,6,7,9,11,10,12,4,15};

        for(int i = 0; i < rij.length; i++){
            System.out.print(rij[i] + " , ");
        }
        int aantalfouten = GetaantalFouten(rij);
        System.out.println("\n \n ------------------------ FOUTEN: " + aantalfouten + " ------------------------");
    }

    /**
     * @param rij de rij waar het aantal volgorde fouten van gevonden moet worden
     * @return aantalvolgorde fouten in de rij
     */
    public static int GetaantalFouten(int[] rij){
        return volgordeFouten(rij, 0 ,rij.length-1);
    }

    /**
     * recursieve functie die met de methode van verdeel en heers eerst de rij gaat op delen in deelrijen van grootte 2,
     * dan gaat kijken of de volgorde klopt en deze oplossing gaat combineren met de andere deelrijen
     * @param rij de rij waar het aantal volgorde fouten van gevonden moet worden
     * @param begin het element waar de (deel)rij begint
     * @param einde het element waar de (deel)rij eindigt
     * @return aantalvolgorde fouten in de (deel)rij
     */
    public static int volgordeFouten(int[] rij, int begin, int einde){
        int aantalFouten = 0;

        if (begin >= einde){
            return aantalFouten;
        }


        int midden = (einde + begin)/2;
        /*
        int aantalFoutenL = volgordeFouten(rij, begin, midden);
        int aantalFoutenR = volgordeFouten(rij, midden+1, einde);
        aantalFouten = aantalFoutenL + aantalFoutenR;
        */

        if(einde-begin == 1){
            return aantalFouten;
        }
        else {
            for (int i = begin; i < (einde); i++) {
                int j= i+1;
                if (rij[i] > rij[j]) {
                    int temp = rij[i];
                    rij[i]= rij[j];
                    rij[j]= temp;
                    i = 0;
                    aantalFouten++;
                }
            }
            for(int i = 0; i < rij.length; i++){
            }

            if(rij[midden] > rij[midden+1]){
                int temp = rij[midden];
                rij[midden]= rij[midden+1];
                rij[midden]= temp;
                aantalFouten++;
            }
            return aantalFouten;
        }
    }
}
