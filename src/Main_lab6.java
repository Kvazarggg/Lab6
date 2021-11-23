import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main_lab6 {
    public static final int MS_TIMEOUT = 100;
    public static final int TIMEOUT = 3000;

    public static void main(String[] args) throws InterruptedException {
        JSONGetter jsonGetter = new JSONGetter();
        JSONGetter.url = "https://breakingbadapi.com/api/quotes";
        jsonGetter.run();
        int msForWaiting = 0;
        do {
            msForWaiting += MS_TIMEOUT;
            Thread.sleep(MS_TIMEOUT);
        } while (msForWaiting <= TIMEOUT && jsonGetter.jsonIn == "");
        if (msForWaiting >= TIMEOUT) {
            System.out.println("Не удалось загрузить данные");
        }

        Phrases phrases = new Phrases();

        phrases.ReadAndParseToList(jsonGetter);

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
