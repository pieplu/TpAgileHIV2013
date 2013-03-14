/*
 * @author Dominique Ménard
 * @author Alexis Piéplu
 * @author Mathieu Latour
 * equipe11
 */
package InsuranceSoftware;

public class InsuranceSoftwareMain {
    
    private static XMLFileCreator document;
    
    public static XMLFileCreator loadXmlDocumentFromArg0(String[] args) throws Exception {
        document = new XMLFileCreator(args[0]);
        return document;
    }
    
    public static void consoleMessageOutput(String[] args) {
        System.out.println("Le fichier entree est dans : " + args[0]);
        System.out.println("Le fichier a ete enregistre dans : " + args[1]);
    }

    public static void main(String[] args) throws Exception {
        document = loadXmlDocumentFromArg0(args);
        
        if (ValidationRunner.runValidationProcess(document)) {
            XMLFileValidOutput xmlOutputFile = new XMLFileValidOutput(args);
            xmlOutputFile.createElementsInXmlOutputFile();
            XMLFileCreator.saveXmlDocument(args[1], xmlOutputFile.getOutputXmlFile());
        } else {
            XMLFileCreator.createErrorFile(args[1]);
        }
        consoleMessageOutput(args);
    }
}