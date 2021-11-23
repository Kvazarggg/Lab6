import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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

    public void ReadAndParseToList(JSONGetter jsonGetter) {
        System.out.println("Waiting for data...");
        String jsonString = jsonGetter.jsonIn;
        System.out.println(jsonString);

        Object obj = null;
        try {
            obj = new JSONParser().parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println();

        JSONArray jsonArray = (JSONArray) obj;
        //System.out.println(jsonArray.toJSONString());
        System.out.println();

        for (Object jsonObject : jsonArray) {
            JSONObject current = (JSONObject) jsonObject;
            int quoteId = Integer.parseInt(String.valueOf(current.get("quote_id")));
            String quote = (String) current.get("quote");
            String author = (String) current.get("author");
            String series = (String) current.get("series");
            BreakingBadPhrase bbp = new BreakingBadPhrase(quoteId, quote, author, series);
            phrases.add(bbp);
        }
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
