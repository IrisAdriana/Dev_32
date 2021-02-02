package org.fundacionjala.app.quizz.model.validator;

import java.util.ArrayList;
import java.util.List;

import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.QuestionType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorIT {
    private List<ValidatorType> validations;

    @Test
    public void testDateValidator() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("24/12/2021", null, errors);

        Assert.assertEquals(DateValidator.class, dateValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }
    @Test
    public void getTitle() {
        Question question = new Question("iris", QuestionType.TEXT, validations);
        assertEquals("iris", question.getTitle());
    }

    @Test
    public void getType() {
        Question question = new Question("iris", QuestionType.DATE, validations);
        assertEquals(QuestionType.DATE, question.getType());
    }
}
