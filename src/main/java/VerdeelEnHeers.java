import java.util.Arrays;

public class VerdeelEnHeers {

    /**
     * Dit programma zoekt het aantal volgorde fouten in een rij
     * @author Arno Molenaers
     * @param args Argumenten die worden mee gegeven aan het programma
     * @since 21/04/2020
     * @version 1.0
     */
    public static void main(String[] args) {
        //voorbeelden vd les
        //int[] rij = {1,4,9,5,8,6,7};
        //int[] rij = {1,4,6,9,5,7,8};

        //zelf
        //int[] rij = {1,6,3,5,4};                                /*  */
        // int[] rij = {1,4,3,5,8,6,7};                           /* 3 fouten */
        // int[] rij = {1,2,4,3,5,8,6,7,9,11,10,12,14,15};       /* 4 fouten */
         //int[] rij = {1,2,14,3,5,8,6,7,9,11,10,12,4,15};          /* 21 fouten */
        //int[] rij = {1,6,9,4,3,11,25,16,2};                       /* 13 fouten */
        // int rij[] = {1,6,4,2,4,5,3,7};                              /* 9 fouten */
        //int rij[] = {1,6,4,2,4,5,4,4};                                 /* 9 fouten */
        int rij[] = {885,1554,1551,11455,2584122,88422,1452,115,51,2255,6816,6,1,61,35,31,651,35,1,615,653,68,4,65,16,1,56,16,51,6,15,651,3,10,651,6,4,6,84,6,46,51,6,51,6,5,16,5,1,6,1,65,1,68,4,8,4,6,5,84,89,64,684,68,1,68,416,1,4,7,468963,3,2,6513,589,6,32,5,8,96,4521,999};

        System.out.println("amount: " + rij.length);
        System.out.print("rij: ");
        for(int i = 0; i < rij.length; i++){
            System.out.print(rij[i] + " , ");
        }
        System.out.println("");
        int aantalfouten = getAantalFouten(rij);
        System.out.println("\n \n ------------------------ FOUTEN: " + aantalfouten + " ------------------------");
    }

    /**
     * @param rij de rij waar het aantal volgorde fouten van gevonden moet worden
     * @return aantalvolgorde fouten in de rij
     */
    public static int getAantalFouten(int[] rij){
        return volgordeFouten(rij, 0 ,rij.length-1);
    }


    /**
     * recursieve functie die met de methode van verdeel en heers eerst de rij gaat op delen in deelrijen,
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
        System.out.println("begin: " + begin + "  midden: " + midden + "  einde: " + einde );
        int[] deelrijL = new int[midden-begin+1];
        int dl = 0;
        for(int i=begin; i<=midden; i++){
            deelrijL[dl] = rij[i];
            dl ++;
        }
        int aantalFoutenL = volgordeFouten(rij, begin, midden);

        int[] deelrijR = new int[einde-(midden+1)+1];
        int dr = 0;
        for(int i=midden+1; i<=einde; i++) {
            deelrijR[dr] = rij[i];
            dr++;
        }
        int aantalFoutenR = volgordeFouten(rij, midden+1, einde);

        aantalFouten = aantalFoutenL + aantalFoutenR;

        System.out.print(" ----------------------|||||||||||||| deelrijL: ");
        for(int i = 0 ; i < deelrijL.length; i++){
            System.out.print(deelrijL[i] + " , ");
        }
        System.out.println("\n");

        System.out.print(" ----------------------|||||||||||||| deelrijR: ");
        for(int j = 0; j < deelrijR.length; j++){
                System.out.print(deelrijR[j] + " , ");
        }
        System.out.println("\n");

        /**lijsten sorteren en tussen de twee deeloplossingen zoeken naar het aantalvolgorde fouten tussen de 2 rijen.
        * Indien er een element in de linkse deelrij groter is dan het eerste element in de rechtse deelrij dan zal er gecontroleerd worden
        * hoeveel volgorde fouten er zijn en zal voor het aantal volgende elemente deze fouten automatisch worden bijgeteld
         */
        Arrays.sort(deelrijL);
        Arrays.sort(deelrijR);

        dl = 0;
        for(int i=begin; i<=midden; i++){
            rij[i] = deelrijL[dl];
            dl ++;
        }

        dr = 0;
        for(int i=midden+1; i<=einde; i++) {
            rij[i] =  deelrijR[dr] ;
            dr++;
        }


        //grens controleren
        if(deelrijL.length> 0 && deelrijR.length >0) {
            int j = 0;
            for (int i = 0; i < deelrijL.length; i++) {
                int fouten = 0;
                 if ( j < deelrijR.length && deelrijL[i] > deelrijR[j]) {
                    while (j < deelrijR.length && deelrijL[i] > deelrijR[j]) {
                        System.out.println(" fout bij deelrijL[i]: "+ deelrijL[i]  + "> deelrijR[j] " + deelrijR[j]);
                        j++;
                        fouten ++;
                    }
                    System.out.println("\n \n ------------------------ FOUTEN: " + aantalFouten + " ------------------------");
                    aantalFouten = aantalFouten + fouten * (deelrijL.length - i);
                    System.out.print(" ************************ FOUT ************************* " +   "---------- FOUTEN: " + aantalFouten + " ------- \n");

                }
            }
        }

        System.out.print(" ---------------------- rij: ");
        for(int i = begin ; i <= einde; i++){
            System.out.print(rij[i] + " , ");
        }
        System.out.println("\n");


        return aantalFouten;
    }
}
