package api.dto.in;

import domain.CalculationInputs;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CalculationInputsDto {
    @NotNull
    public final String expression;
    @NotNull
    public final List<Integer> variables;

    public CalculationInputsDto(String expression, List<Integer> variables) {
        this.expression = expression;
        this.variables = variables;
    }

    public CalculationInputs toDomain() {
        return CalculationInputs.create(expression, variables);
    }
}
