package domain.template;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Service {
    public Service() {
    }

    public CalculationResults calculate(CalculationInputs inputs) {
        String expression = inputs.expression();
        int result = 0;
        if (!inputs.variables().isEmpty()) {
            for (Integer value : inputs.variables()) {
                expression = expression.replaceFirst("x", value.toString());
            }
            result = MathUtils.eval(expression);
        }

        return CalculationResults.create(expression, result);
    }
}
