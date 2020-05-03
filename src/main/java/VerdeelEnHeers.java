public class VerdeelEnHeers {


    public static void main(String[] args) {
        //voorbeelden vd les
        //int[] rij = {1,4,9,5,8,6,7};
        //int[] rij = {1,4,6,9,5,7,8};

        //zelf
        //int[] rij = {1,6,3,5,4};                                /*  */
        //int[] rij = {1,4,3,5,8,6,7};                           /* 3 fouten */
        //int[] rij = {1,2,4,3,5,8,6,7,9,11,10,12,14,15};       /* 4 fouten */
        int[] rij = {1,2,14,3,5,8,6,7,9,11,10,12,4,15};

        System.out.println("amount: " + rij.length);
        System.out.print("rij: ");
        for(int i = 0; i < rij.length; i++){
            System.out.print(rij[i] + " , ");
        }
        System.out.println("");
        int aantalfouten = GetaantalFouten(rij);
        System.out.println("\n \n ------------------------ FOUTEN: " + aantalfouten + " ------------------------");
    }

    public static int GetaantalFouten(int[] rij){
        return volgordeFouten(rij, 0 ,rij.length-1);
    }

    public static int volgordeFouten(int[] rij, int begin, int einde){
        int aantalFouten = 0;

        if (begin >= einde){
            return aantalFouten;
        }

        int midden = (einde + begin)/2;
        int aantalFoutenL = volgordeFouten(rij, begin, midden);
        int aantalFoutenR = volgordeFouten(rij, midden+1, einde);
        aantalFouten = aantalFoutenL + aantalFoutenR;

        if(einde-begin == 1){
            System.out.println("----------------------------- begin: " + begin + " - einde: " + einde  );
            return aantalFouten;
        }
        else {
            System.out.println("\n ----------------------------- begin: " + begin + " - einde: " + einde  );
            for (int i = begin; i < (einde); i++) {
                int j= i+1;
                if (rij[i] > rij[j]) {
                    int temp = rij[i];
                    rij[i]= rij[j];
                    rij[j]= temp;
                    System.out.println("begin: " + begin + " - einde: " + einde + " - rij[i]: " + rij[i] + " - rij[j]: " + rij[j] );
                    i = 0;
                    aantalFouten++;
                }
            }
            System.out.print(" rij: ");
            for(int i = 0; i < rij.length; i++){
                System.out.print(rij[i] + " , ");
            }
            System.out.println("");

            if(rij[midden] > rij[midden+1]){
                int temp = rij[midden];
                rij[midden]= rij[midden+1];
                rij[midden]= temp;
                aantalFouten++;
                System.out.println("begin: " + begin + " - einde: " + einde + " - rij[i]: " + rij[midden] + " - rij[j]: " + rij[midden+1] );
            }
            return aantalFouten;
        }
    }
}
