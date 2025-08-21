import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    boolean askQuestion(Scanner sc) {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your choice (1-4): ");
        int answer = sc.nextInt();
        if (answer - 1 == correctAnswer) {
            System.out.println("✅ Correct!");
            return true;
        } else {
            System.out.println("❌ Wrong! Correct answer: " + options[correctAnswer]);
            return false;
        }
    }
}

public class QuizGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        Question[] quiz = {
            new Question("Which language is used for Android Development?",
                new String[]{"Python", "Java", "C++", "Ruby"}, 1),
            new Question("What is the capital of India?",
                new String[]{"Mumbai", "Kolkata", "New Delhi", "Chennai"}, 2),
            new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"implement", "extends", "inherits", "super"}, 1),
            new Question("Who invented Java?",
                new String[]{"James Gosling", "Guido van Rossum", "Dennis Ritchie", "Bjarne Stroustrup"}, 0)
        };

        System.out.println("===== Welcome to Quiz Game =====");
        
      
        for (Question q : quiz) {
            if (q.askQuestion(sc)) {
                score++;
            }
        }

       
        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + quiz.length);
        if (score == quiz.length) {
            System.out.println("🎉 Excellent! You got all correct!");
        } else if (score >= 2) {
            System.out.println("👍 Good Job!");
        } else {
            System.out.println("😢 Better Luck Next Time!");
        }

        sc.close();
    }
}

