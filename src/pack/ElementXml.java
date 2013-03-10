/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;
import org.w3c.dom.Element;
import org.w3c.dom.*;

/**
 *
 * @author fe291196
 */
public class ElementXml {
    
    public static Element creationElementXmlRoot(Document documentXml, String elementName) throws DOMException {
        Element createdElement = documentXml.createElement(elementName);
        documentXml.appendChild(createdElement);
        return createdElement;
    }
    
    public static Element creationElementXmlChild(Document documentXml, String elementName ,Element parentName) throws DOMException {
        Element createdElement = documentXml.createElement(elementName);
        parentName.appendChild(createdElement);
        return createdElement;
    }
    
}