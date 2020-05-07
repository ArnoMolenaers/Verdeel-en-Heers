
/**
 *
 * @author uhstudent
 */
public class MaxSomVerdeelEnHeersRij {
    public static Deelrij maxSom(int[] rij) {
        return maxSomRecursief(rij, 0, rij.length-1);
    }

    public static Deelrij maxSomRecursief(int[] rij, int begin, int einde) {
        if (begin == einde) {
            if (rij[begin] < 0) return new Deelrij(begin, begin, 0);
            else return new Deelrij(begin, begin+1, rij[begin]);
        }

        int midden = (begin+einde)/2;
        Deelrij somLinks = maxSomRecursief(rij, begin, midden);
        Deelrij somRechts = maxSomRecursief(rij, midden+1, einde);

        // zoek linkerSom
        Deelrij linkerHelft = new Deelrij(midden+1, midden+1, 0);
        int som = 0;
        for (int i=midden; i>= begin; i--) {
            som = som + rij[i];
            if (som > linkerHelft.getAantalFouten()) linkerHelft = new Deelrij(i, midden+1, som);
        }

        // zoek rechterSom
        Deelrij rechterHelft = new Deelrij(midden+1, midden+1, 0);
        som = 0;
        for (int i=midden+1; i <= einde; i++) {
            som = som + rij[i];
            if (som > rechterHelft.getAantalFouten()) rechterHelft = new Deelrij(midden+1, i+1, som);
        }

        int somOverDeGrens = linkerHelft.getAantalFouten() + rechterHelft.getAantalFouten();
        if (somLinks.getAantalFouten() > somOverDeGrens) {
            if (somRechts.getAantalFouten() > somLinks.getAantalFouten()) {
                return somRechts;
            }
            else {
                return somLinks;
            }
        }
        else {
            if (somRechts.getAantalFouten() > somOverDeGrens) {
                return somRechts;
            }
            else {
                return new Deelrij(linkerHelft.getStart(), rechterHelft.getEinde(), somOverDeGrens);
            }
        }
    }
}
