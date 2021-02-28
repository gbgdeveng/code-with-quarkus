package api.dto.out;

import domain.CalculationResults;

public class CalculationResultsDto {
    public final String expression;
    public final Integer result;

    public CalculationResultsDto(String expression, Integer result) {
        this.expression = expression;
        this.result = result;
    }

    public static CalculationResultsDto fromDomain(CalculationResults domain) {
        return new CalculationResultsDto(domain.expression(), domain.result());
    }
}
