package org.fundacionjala.app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;
import org.fundacionjala.app.quizz.console.QuizUIHandler;
import org.fundacionjala.app.quizz.model.*;
import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public class JsonPersistence {

    public static void main(String[] args) {
//        Person person = new Person("Iris", "Musk", 49);

//        QuizUIHandler quizUIHandler=new QuizUIHandler();
        Quiz title = QuizUIHandler.createQuiz();
        QuizAnswers qanswers=QuizUIHandler.fillQuiz(title);

        QuizAnswers quizAnswers = new QuizAnswers(title);
        List<ValidatorType> validatorTypes = new ArrayList<>();
        Question question = new Question(title.getTitle(), QuestionType.TEXT, validatorTypes);

        Set<String> answers = new HashSet<>();
        Answer answer = new Answer(question, answers);
        writeJsonFile(answer);
//        Answer parsedPerson = readJsonFile();
//        System.out.println(parsedPerson);
    }

    private static void menu() {

    }

    private static Answer readJsonFile() {
        Gson gson = new Gson();
        Answer person = null;
        try (JsonReader reader = new JsonReader(new FileReader("./myForm.json"))) {
            person = gson.fromJson(reader, Answer.class);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return person;
    }

    public static void writeJsonFile(Answer answer) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("./myForm.json")) {
            gson.toJson(answer, writer);
        } catch (JsonIOException | IOException exception) {
            exception.printStackTrace();
        }
    }

//    public static class Person {
//        private final String name;
//        private final String lastName;
//        private final int age;
//
//        public Person(String name, String lastName, int age) {
//            this.name = name;
//            this.lastName = lastName;
//            this.age = age;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getLastName() {
//            return lastName;
//        }
//
//        public int getAge() {
//            return age;
//        }
//
//        @Override
//        public String toString() {
//            return getName() + " " + getLastName() + " : " + getAge();
//        }
//    }
}
