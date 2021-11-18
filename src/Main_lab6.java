import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main_lab6 {
    public static void main(String[] args) {
        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter.url = "https://breakingbadapi.com/api/quotes";
        jsonGetter.run();

        System.out.println("Waiting for data...");
        String jsonString = jsonGetter.jsonIn;
        System.out.println(jsonString);

        // Считываем json
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

        Phrases phrases = new Phrases();

        for (Object jsonObject : jsonArray) {
            JSONObject current = (JSONObject) jsonObject;
            int quoteId = Integer.parseInt(String.valueOf(current.get("quote_id")));
            String quote = (String) current.get("quote");
            String author = (String) current.get("author");
            String series = (String) current.get("series");
            BreakingBadPhrase bbp = new BreakingBadPhrase(quoteId, quote, author, series);
            phrases.add(bbp);
        }

        System.out.println("Imported data after parsing:\n" + phrases);
        System.out.println(phrases);

        phrases.getPhrases().sort(BreakingBadPhrase.byAuthorAsc);
        System.out.println("After sorting by author ascending:\n" + phrases);
        phrases.getPhrases().sort(BreakingBadPhrase.byAuthorDesc);
        System.out.println("After sorting by author descending:\n" + phrases);

        phrases.getPhrases().sort(BreakingBadPhrase.byQuoteIDAsc);
        System.out.println("After sorting by quote ID ascending:\n" + phrases);
        phrases.getPhrases().sort(BreakingBadPhrase.byQuoteIDDesc);
        System.out.println("After sorting by quote ID descending:\n" + phrases);

        Phrases withWalterWhite = phrases.filterByAuthor("Walter White");
        System.out.println("Walter White phrases:\n" + withWalterWhite);
    }
}
