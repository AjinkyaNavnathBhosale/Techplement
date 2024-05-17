import java.util.ArrayList;
import java.util.Scanner;

class Question {
    String question;
    ArrayList<String> options;
    String correctAnswer;

    Question(String question, ArrayList<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}

class Quiz {
    String name;
    ArrayList<Question> questions;

    Quiz(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    void addQuestion(String question, ArrayList<String> options, String correctAnswer) {
        Question newQuestion = new Question(question, options, correctAnswer);
        questions.add(newQuestion);
    }

    void takeQuiz() {
        int score = 0;
        int totalQuestions = questions.size();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the " + name + " Quiz!\n");

        for (int i = 0; i < totalQuestions; i++) {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.question);
            for (int j = 0; j < currentQuestion.options.size(); j++) {
                System.out.println((j + 1) + ". " + currentQuestion.options.get(j));
            }

            System.out.print("Your answer: ");
            int userAnswerIndex = scanner.nextInt();
            String userAnswer = currentQuestion.options.get(userAnswerIndex - 1);
            if (userAnswer.equalsIgnoreCase(currentQuestion.correctAnswer)) {
                score++;
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your Score: " + score + "/" + totalQuestions);

        if (score == totalQuestions) {
            System.out.println("Congratulations! You got all the answers correct.");
        } else if (score >= totalQuestions * 0.7) {
            System.out.println("Well done! You passed the quiz.");
        } else {
            System.out.println("Sorry, you did not pass the quiz.");
        }
    }
}

public class Quiz1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Generator!");
        System.out.print("Enter the name of the quiz: ");
        String quizName = scanner.nextLine();
        Quiz quiz = new Quiz(quizName);

        while (true) {
            System.out.println("\nCommands:");
            System.out.println("1. Add Question");
            System.out.println("2. Take Quiz");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the question: ");
                    String question = scanner.nextLine();
                    System.out.print("Enter the options separated by commas: ");
                    String[] optionsArray = scanner.nextLine().split(",");
                    ArrayList<String> options = new ArrayList<>();
                    for (String option : optionsArray) {
                        options.add(option.trim());
                    }
                    System.out.print("Enter the correct answer: ");
                    String correctAnswer = scanner.nextLine();
                    quiz.addQuestion(question, options, correctAnswer);
                    System.out.println("Question added successfully!");
                    break;
                case 2:
                    quiz.takeQuiz();
                    break;
                case 3:
                    System.out.println("Thank you for using Quiz Generator. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

