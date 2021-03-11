package domain.stocks;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Candle {
    public abstract String date();
    public abstract Double openPrice();
    public abstract Double highPrice();
    public abstract Double lowPrice();
    public abstract Double closePrice();
    public abstract Double adjClosePrice();
    public abstract Long volume();

    public static Candle create(String date, Double openPrice, Double highPrice, Double lowPrice, Double closePrice, Double adjClosePrice, Long volume) {
        return builder()
                .date(date)
                .openPrice(openPrice)
                .highPrice(highPrice)
                .lowPrice(lowPrice)
                .closePrice(closePrice)
                .adjClosePrice(adjClosePrice)
                .volume(volume)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_Candle.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder date(String date);

        public abstract Builder openPrice(Double openPrice);

        public abstract Builder highPrice(Double highPrice);

        public abstract Builder lowPrice(Double lowPrice);

        public abstract Builder adjClosePrice(Double adjClosePrice);

        public abstract Builder volume(Long volume);

        public abstract Builder closePrice(Double closePrice);

        public abstract Candle build();
    }
}
