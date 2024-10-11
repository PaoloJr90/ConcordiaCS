package COMP5361.assignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// code version 2
public class warmUp {
    private final Map<String, Boolean> truthMap;
    String[] validatedInputs;
    Boolean[] boolEquivalents;

    public warmUp() {
        // setup for acceptable inputs Map
        truthMap = new HashMap<>();
        truthMap.put("true", true);
        truthMap.put("t", true);
        truthMap.put("1", true);
        truthMap.put("false", false);
        truthMap.put("f", false);
        truthMap.put("0", false);
    }

    private Boolean negation(boolean value) {
        return !value;
    }

    private Boolean conjunction(boolean input1, boolean input2) {
        return input1 && input2;
    }

    private Boolean disjunction(boolean input1, boolean input2) {
        return input1 || input2;
    }

    private Boolean implication(boolean input1, boolean input2) {
        return !input1 || input2;
    }

    private Boolean biconditional(boolean input1, boolean input2) {
        return input1 == input2;
    }

    // user input values output to a String array with validation
    private String[] getUserInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter one or two (space-separated) truth values (True, False, T, F, 0, 1): ");
            String line = scanner.nextLine().trim();
            String[] inputs = line.split("\\s+");

            // check for length to be either 1 or 2
            if (inputs.length == 1 || inputs.length == 2) {
                validatedInputs = new String[inputs.length];
                boolEquivalents = new Boolean[inputs.length];

                // Validate each input
                boolean allValid = true;
                for (int i = 0; i < inputs.length; i++) {
                    if (!isValidInput(inputs[i], i)) {
                        allValid = false;
                        break;
                    }
                }

                if (allValid) {
                    return inputs;
                } else if (inputs.length == 2) {
                    System.out.println("Invalid inputs detected: " + inputs[0] + " " +  inputs[1]);
                } else {
                    System.out.println("Invalid input detected: " + inputs[0]);
                }
            } else {
                System.out.println("Invalid input: " + line + "\nPlease enter one or two (space-separated) truth values.");
            }
        }
    }

    // Check if the input is valid and update the validated input and boolean equivalent arrays
    private boolean isValidInput(String input, int index) {
        Boolean value = truthMap.get(input.toLowerCase());
        if (value != null) {
            boolEquivalents[index] = value;
            validatedInputs[index] = input;
            return true;
        } else {
            return false;
        }
    }

    // format the returned value to be the same as the user input format
    private String getFormat(String original, boolean value, Scanner scanner) {
        while(true) {
            if (original.equalsIgnoreCase("true") || original.equalsIgnoreCase("false")) {
                return value ? "True" : "False";
            } else if (original.equalsIgnoreCase("t") || original.equalsIgnoreCase("f")) {
                return value ? "T" : "F";
            } else if (original.equals("1") || original.equals("0")) {
                return value ? "1" : "0";
            } else {
                System.out.println("Unexpected format: " + original);
                System.out.print("Please enter a valid format (True, False, T, F, 1, 0): ");
                original = scanner.nextLine().trim();
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        warmUp warmUp = new warmUp();

        String[] values = warmUp.getUserInput(scanner);
        
        // for negation; it requires a single input
        if (values.length == 1) {
            System.out.println("One valid truth value entered: " + warmUp.validatedInputs[0]);
            
            boolean negatedValue = warmUp.negation(warmUp.boolEquivalents[0]);
            String formattedBoolean = warmUp.getFormat(warmUp.validatedInputs[0], negatedValue, scanner);
            
            System.out.println("The negated (NOT) value is: " + formattedBoolean);
            
        // for all other functions; they require two inputs
        } else if (values.length == 2) {

            boolean boolValue1 = warmUp.boolEquivalents[0];
            boolean boolValue2 = warmUp.boolEquivalents[1];

            boolean conjunction = warmUp.conjunction(boolValue1, boolValue2);
            String formatConjunction = warmUp.getFormat(warmUp.validatedInputs[0], conjunction, scanner);

            boolean disjunction = warmUp.disjunction(boolValue1, boolValue2);
            String formatDisjunction = warmUp.getFormat(warmUp.validatedInputs[0], disjunction, scanner);

            boolean implication = warmUp.implication(boolValue1, boolValue2);
            String formatImplication = warmUp.getFormat(warmUp.validatedInputs[0], implication, scanner);

            boolean biconditional = warmUp.biconditional(boolValue1, boolValue2);
            String formatBiconditional = warmUp.getFormat(warmUp.validatedInputs[0], biconditional, scanner);

            System.out.println("Two valid truth values entered: " + warmUp.validatedInputs[0] + " " + warmUp.validatedInputs[1]);
            System.out.println("The conjunction (AND) of those values is: " + formatConjunction);
            System.out.println("The disjunction (OR) of those values is: " + formatDisjunction);
            System.out.println("The implication (NOT p OR q) of those values is: " + formatImplication);
            System.out.println("The biconditional ((p AND q) OR (NOT p AND NOT q)) of those values is: " + formatBiconditional);
        }

            scanner.close();
        }

    }