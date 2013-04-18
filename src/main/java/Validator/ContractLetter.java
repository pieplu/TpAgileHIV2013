package Validator;

public class ContractLetter {

    private static String contractLetter = "";
    final static String[] ArrayOfValidContractLetters = {"A", "B", "C", "D", "E"};

    public static boolean isContractLetterValid(String contractLetter) {
        ContractLetter.contractLetter = contractLetter;
        for (int i = 0; i < ArrayOfValidContractLetters.length; i++) {
            if (contractLetter.equals(ArrayOfValidContractLetters[i])) {
                return true;
            }
        }
        return false;
    }
}
