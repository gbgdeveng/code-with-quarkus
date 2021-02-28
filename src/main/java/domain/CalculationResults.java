package domain;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class CalculationResults {
    public abstract String expression();

    public abstract int result();

    public static CalculationResults create(String expression, int result) {
        return builder()
                .expression(expression)
                .result(result)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_CalculationResults.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder expression(String expression);

        public abstract Builder result(int result);

        public abstract CalculationResults build();
    }
}
