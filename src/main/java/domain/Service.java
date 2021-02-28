package domain;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Service {
    public Service() {
    }

    public CalculationResults calculate(CalculationInputs inputs) {
        String expression = inputs.expression();
        for (Integer value : inputs.variables()) {
            expression = expression.replaceFirst("x", value.toString());
        }

        int result = MathUtils.eval(expression);

        return CalculationResults.create(expression, result);
    }
}
