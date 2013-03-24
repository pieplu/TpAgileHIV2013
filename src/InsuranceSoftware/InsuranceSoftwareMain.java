/*
 * @author Dominique Ménard
 * @author Alexis Piéplu
 * @author Mathieu Latour
 * equipe11
 */
package InsuranceSoftware;

public class InsuranceSoftwareMain {
    
    private static JSONFileCreator document;
    
    public static JSONFileCreator loadXmlDocumentFromArg0(String[] args) throws Exception {
        document = new JSONFileCreator(args[0]);
        return document;
    }
    
    public static void consoleMessageOutput(String[] args) {
        System.out.println("Le fichier entree est dans : " + args[0]);
        System.out.println("Le fichier a ete enregistre dans : " + args[1]);
    }

    public static void main(String[] args) throws Exception {
        document = loadXmlDocumentFromArg0(args);
        
        if (ValidationRunner.runValidationProcess(document)) {
            JSONFileValidOutput xmlOutputFile = new JSONFileValidOutput(args);
            xmlOutputFile.createElementsInXmlOutputFile();
            JSONFileCreator.saveJSONFile(args[1], xmlOutputFile.getOutputJSONFile());
        } else {
            JSONFileCreator.createErrorFile(args[1]);
        }
        consoleMessageOutput(args);
    }
}