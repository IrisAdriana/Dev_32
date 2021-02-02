package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class UppercaseText implements Validator {
    private static final String ERROR_MESSAGE = "The uppercase value is incorrect";

    @Override
    public void validate(String value, String conditionValueString, List<String> errors) {
        try {
//            for (int i = 0; i <= value.length(); i++) {
                if (!Character.isUpperCase(value.charAt(0))) {
                    errors.add(ERROR_MESSAGE);
                }
//            }
        } catch (Exception exception) {
            errors.add(ERROR_MESSAGE);
        }

    }
}
