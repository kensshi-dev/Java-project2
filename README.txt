Calculator Project
This project is a console-based calculator built using Java that can handle various arithmetic expressions. It supports basic operations such as addition, subtraction, multiplication, division, and modulus, as well as advanced operations such as power, square root, absolute value, and rounding. The calculator also maintains a history of previous calculations, which can be accessed by the user at any time.
Design Choices

    User Interface: The user interface is kept simple and console-based, where users can input arithmetic expressions and receive results.
    History Feature: The program keeps track of previous calculations in a history list, allowing users to view past results with the history command.
    Error Handling: The calculator provides feedback if there is an error in the input expression (such as invalid syntax or division by zero).

Algorithms and Data Structures Used

    Stack-based Evaluation Algorithm: The algorithm uses two stacks:
        A stack for numbers (Stack<Double> j).
        A stack for operators (Stack<Character> k).

    This design allows the program to evaluate expressions following the order of operations (PEMDAS), also known as BODMAS (Brackets, Orders, Division and Multiplication, Addition and Subtraction).

    The algorithm processes the expression character by character, handling numbers, operators, and parentheses accordingly. It applies the operators in the correct order by popping from the operator stack and calculating the result using the operands stored in the number stack.

    Handling Parentheses: Parentheses are handled by ensuring that expressions within parentheses are evaluated first. When a closing parenthesis is encountered, the program pops operators off the stack until it finds an opening parenthesis and processes the operations in the correct order.

    Function Parsing: The program supports functions such as pow(), abs(), sqrt(), and round(). The r() method processes these functions by locating the function in the expression and evaluating them in isolation before continuing with the main expression.

    Regular Expressions: The program uses regular expressions (i.replaceAll("\\s+", "")) to remove whitespace from the input expression to ensure it is parsed correctly.

Key Features

    Arithmetic Operations: Supports basic operations such as addition, subtraction, multiplication, division, and modulus.
    Advanced Operations: Supports pow(), abs(), sqrt(), and round() functions.
    History Feature: Users can view the history of previous calculations with the history command.
    Error Handling: Provides error messages when encountering invalid operations, such as division by zero or malformed expressions.
    Exit Command: The user can exit the program by typing exit.

Challenges Encountered

    Function Parsing: Handling functions like pow(), abs(), sqrt(), and round() required careful extraction of arguments from within parentheses and evaluation before incorporating the result into the larger expression.
    Operator Precedence: Correctly implementing the operator precedence (PEMDAS/BODMAS) using stacks required handling both precedence levels (e.g., multiplication and division have higher precedence than addition and subtraction).
    Handling Parentheses: Ensuring proper handling of parentheses for nested expressions was a challenge, especially when considering complex expressions with multiple levels of parentheses.

Improvements Made to the Initial Implementation

    History Tracking: The program was improved to keep track of all previous calculations. This feature allows users to view their calculation history.
    Error Handling: Improved error handling to provide feedback when invalid expressions are entered.
    Function Support: The implementation was expanded to support functions like power, absolute value, square root, and rounding.

Input and Output

The program does not use files for input or output. It interacts with the user through the console:

    Input: Users input arithmetic expressions directly through the console.
    Output: The result of the calculation is displayed in the console. If the user types history, the program displays the list of previous calculations.
