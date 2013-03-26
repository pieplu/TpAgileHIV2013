/*
 * @author Dominique Ménard
 * @author Alexis Piéplu
 * @author Mathieu Latour
 * equipe11
 */
package InsuranceSoftware;

public class InsuranceSoftwareMain {
    
    private static JSONFileCreator file;
    
    public static JSONFileCreator loadJSONFileFromArg0(String[] args) throws Exception {
        file = new JSONFileCreator(args[0]);
        return file;
    }
    
    public static void consoleMessageOutput(String[] args) {
        System.out.println("Le fichier entree est dans : " + args[0]);
        System.out.println("Le fichier a ete enregistre dans : " + args[1]);
    }

    public static void main(String[] args) throws Exception {
        file = loadJSONFileFromArg0(args);
        
        if (ValidationRunner.runValidationProcess(file)) {
            JSONFileValidOutput jsonOutputFile = new JSONFileValidOutput(args);
            jsonOutputFile.createElementsInXmlOutputFile();
            JSONFileCreator.saveJSONFile(args[1], jsonOutputFile.getOutputJSONFile());
        } else {
            JSONFileCreator.createErrorFile(args[1]);
        }
        consoleMessageOutput(args);
    }
}