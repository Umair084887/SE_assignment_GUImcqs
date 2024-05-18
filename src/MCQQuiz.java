import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MCQQuiz extends JFrame implements ActionListener {

    // GUI elements
    private JLabel questionLabel, optionA, optionB, optionC, optionD;
    private JRadioButton radioA, radioB, radioC, radioD;
    private ButtonGroup answerGroup;
    private JButton nextButton, submitButton;

    // Quiz data (replace with more questions and answers)
    private String[] questions = {
            "What is the capital of France?",
            "What is the tallest mountain in the world?",
            "Which element has the atomic number 1?",
            "What is the largest ocean on Earth?",
            "In which century did the American Revolution take place?"
    };
    private String[][] options = {
            {"London", "Paris", "Berlin", "Rome"},
            {"Mount Everest", "K2", "Kangchenjunga", "Lhotse"},
            {"Hydrogen", "Helium", "Lithium", "Beryllium"},
            {"Pacific", "Atlantic", "Indian", "Arctic"},
            {"16th", "17th", "18th", "19th"}
    };
    private char[] correctAnswers = {'B', 'A', 'A', 'A', 'C'};

    // Current question index and score
    private int currentQuestion = 0;
    private int score = 0;

    public MCQQuiz() {
        // Create and arrange GUI elements
        questionLabel = new JLabel("Question", JLabel.CENTER);
        optionA = new JLabel("A)");
        optionB = new JLabel("B)");
        optionC = new JLabel("C)");
        optionD = new JLabel("D)");
        radioA = new JRadioButton();
        radioB = new JRadioButton();
        radioC = new JRadioButton();
        radioD = new JRadioButton();
        answerGroup = new ButtonGroup();
        answerGroup.add(radioA);
        answerGroup.add(radioB);
        answerGroup.add(radioC);
        answerGroup.add(radioD);
        nextButton = new JButton("Next");
        submitButton = new JButton("Submit");

        // Use BorderLayout for a more flexible layout
        setLayout(new BorderLayout());

        // Add components to the layout
        add(questionLabel, BorderLayout.NORTH);
        JPanel optionsPanel = new JPanel();
        optionsPanel.add(optionA);
        optionsPanel.add(radioA);
        optionsPanel.add(optionB);
        optionsPanel.add(radioB);
        optionsPanel.add(optionC);
        optionsPanel.add(radioC);
        optionsPanel.add(optionD);
        optionsPanel.add(radioD);
        add(optionsPanel, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nextButton);
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to buttons
        nextButton.addActionListener(this);
        submitButton.addActionListener(this);

        // Select random questions on initialization
        selectRandomQuestions();

        // Set initial question
        displayQuestion(currentQuestion);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextButton) {
            // Check answer for current question (simplified logic for brevity)
            char selectedAnswer = getSelectedAnswer();
            if (selectedAnswer == correctAnswers[currentQuestion]) {
                score++;
            }

            // Show next question or display result if last question
            currentQuestion++;
            if (currentQuestion < questions.length) {
                displayQuestion(currentQuestion);
            } else {
                displayResult();
            }
        } else if (e.getSource() == submitButton) {
            // Similar logic as next button click for answer check and result
            currentQuestion++;
            displayResult();
        }
    }

    private char getSelectedAnswer() {
        if (radioA.isSelected()) return 'A';
        else if (radioB.isSelected()) return 'B';
        else if (radioC.isSelected()) return 'C';
        else return 'D';
    }

    private void selectRandomQuestions() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(questions.length);
            // Swap question, answer data as before
            // ... (similar code as previous example)
        }
    }

    private void displayQuestion(int index) {
        questionLabel.setText(questions[index]);
        optionA.setText("A) " + options[index][0]);
        optionB.setText("B) " + options[index][1]);
        optionC.setText("C) " + options[index][2]);
        optionD.setText("D) " + options[index][3]);
        // Clear radio button selections (optional)
        answerGroup.clearSelection();
    }

    private void displayResult() {
        questionLabel.setText("Quiz Result");
        optionA.setText("You scored: " + score + " out of " + questions.length);
        optionB.setText("");
        optionC.setText("");
        optionD.setText("");
        radioA.setVisible(false);
        radioB.setVisible(false);
        radioC.setVisible(false);
        radioD.setVisible(false);
        nextButton.setVisible(false);
        submitButton.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MCQQuiz quiz = new MCQQuiz();
                quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                quiz.setTitle("MCQ Quiz");
                quiz.pack();
                quiz.setVisible(true);
            }
        });
    }
}