
/**
 *
 * @author uhstudent
 */
public class Deelrij {
    private int start, einde;
    private int aantalFouten;

    public Deelrij(int start, int einde, int aantalFouten) {
        this.start = start;
        this.einde = einde;
        this.aantalFouten = aantalFouten;
    }

    /**
     * @return de start
     */
    public int getStart() {
        return start;
    }

    /**
     * @return het einde
     */
    public int getEinde() {
        return einde;
    }

    /**
     * @return het aantal volgorde fouten tot nu toe
     */
    public int getAantalFouten() {
        return aantalFouten;
    }


}
