package domain;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class CalculationInputs {

    public abstract String expression();

    public abstract List<Integer> variables();

    public static CalculationInputs create(String expression, List<Integer> variables) {
        return builder()
                .expression(expression)
                .variables(variables)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_CalculationInputs.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder expression(String expression);

        public abstract Builder variables(List<Integer> variables);

        public abstract CalculationInputs build();
    }
}
