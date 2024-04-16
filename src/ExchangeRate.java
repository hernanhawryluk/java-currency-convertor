import java.util.Map;

public class ExchangeRate {
    private String result;
    private String documentation;
    private String terms_of_use;
    private int time_last_update_unix;
    private String time_last_update_utc;
    private int time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public ExchangeRate(ExchangeRateAPI api) {
        this.result = api.result();
        this.documentation = api.documentation();
        this.terms_of_use = api.terms_of_use();
        this.time_last_update_unix = api.time_last_update_unix();
        this.time_last_update_utc = api.time_last_update_utc();
        this.time_next_update_unix = api.time_next_update_unix();
        this.time_next_update_utc = api.time_next_update_utc();
        this.base_code = api.base_code();
        this.conversion_rates = api.conversion_rates();
    }

    public Double getValue(String currency) {
        return this.conversion_rates.get(currency);
    }

    @Override
    public String toString() {
        return conversion_rates.toString();
    }
}
