import java.util.ArrayList;
import java.util.Date;

public class Phrases {
    private ArrayList<BreakingBadPhrases> phrases;

    public ArrayList<BreakingBadPhrases> getPhrases() {
        return phrases;
    }

    public Phrases(ArrayList<BreakingBadPhrases> phrases) {
        this.phrases = phrases;
    }

    public void setPhrases(ArrayList<BreakingBadPhrases> phrases) {
        this.phrases = phrases;
    }

    public Phrases() {
        phrases = new ArrayList<>();
    }

    public void add(BreakingBadPhrases bbp){
        this.phrases.add(bbp);
    }

    @Override
    public String toString() {
        String result = "Phrases (" + (new Date()).toLocaleString() + ") " + System.lineSeparator();
        for (BreakingBadPhrases bbp : phrases) {
            result += bbp + System.lineSeparator();
        }
        return result;
    }
}
