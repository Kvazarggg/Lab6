public class BreakingBadPhrases {
    //static final long serialVersionUID = 454564564564564L;
    private int quoteId;
    private String quote;
    private String author;
    private String series;

    /**
     * No args constructor for use in serialization
     *
     */
    public BreakingBadPhrases() {
    }

    /**
     *
     * @param quote
     * @param author
     * @param series
     * @param quoteId
     */
    public BreakingBadPhrases(int quoteId, String quote, String author, String series) {
        super();
        this.quoteId = quoteId;
        this.quote = quote;
        this.author = author;
        this.series = series;
    }

    public int getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(int quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "BreakingBadPhrases{" +
                "quoteId=" + quoteId +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}