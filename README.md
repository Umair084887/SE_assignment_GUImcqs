
# Title
###  MCQ Quiz




# packages and libraries

javax.swing: This package provides classes for creating GUI components such as frames, buttons, labels, and text fields.

java.awt: This package provides classes for creating GUI components and handling events.

java.awt.event: This package provides classes for handling events such as button clicks and key presses.

java.util.Random: This class is used to generate random numbers for selecting questions.
# Program Over View
The program creates a GUI window with a question, four options, and two buttons (Next and Submit). The user can select an answer using the radio buttons and click the Next button to proceed to the next question. The Submit button is used to submit the answers and display the quiz result.
# Class And Methods
MCQQuiz class: This is the main class that extends JFrame and implements ActionListener.

actionPerformed method: This method is called when the user clicks the Next or Submit button. It checks the user's answer, updates the score, and displays the next question or the quiz result.

getSelectedAnswer method: This method returns the user's selected answer.

selectRandomQuestions method: This method is used to select random questions (not implemented in this code).

displayQuestion method: This method displays the current question and options.

displayResult method: This method displays the quiz result.

main method: This method creates an instance of the MCQQuiz class and sets up the GUI.
# Gui Components
JFrame: This is the main window that contains all the GUI components.

JLabel: This is used to display the question, options, and result.

JRadioButton: This is used to select the answer.

ButtonGroup: This is used to group the radio buttons.

JButton: This is used for the Next and Submit buttons.