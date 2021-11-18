import java.util.ArrayList;
import java.util.Date;

public class Phrases {
    private ArrayList<BreakingBadPhrase> phrases;

    public ArrayList<BreakingBadPhrase> getPhrases() {
        return phrases;
    }

    public Phrases(ArrayList<BreakingBadPhrase> phrases) {
        this.phrases = phrases;
    }

    public void setPhrases(ArrayList<BreakingBadPhrase> phrases) {
        this.phrases = phrases;
    }

    public Phrases() {
        phrases = new ArrayList<>();
    }

    public void add(BreakingBadPhrase bbp) {
        this.phrases.add(bbp);
    }

    public Phrases filterByAuthor(String str) {
        Phrases tempObj = new Phrases();
        for (BreakingBadPhrase phrase : this.phrases) {
            if (phrase.getAuthor().toLowerCase().contains(str.toLowerCase()))
                tempObj.add(phrase);
        }
        return tempObj;
    }

    @Override
    public String toString() {
        String result = "Phrases (" + (new Date()).toLocaleString() + ") " + System.lineSeparator();
        for (BreakingBadPhrase bbp : phrases) {
            result += bbp + System.lineSeparator();
        }
        return result;
    }
}
