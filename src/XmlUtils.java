import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XmlUtils {
    private XmlUtils() {
    }

    public static void createXML() throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = docBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement("Departments");
        document.appendChild(rootElement);

        // 1
        Element studentElement1 = document.createElement("Department");
//        studentElement1.setAttribute("ID", "1");   // attr
        rootElement.appendChild(studentElement1);

        Element nameElement = document.createElement("name");
        nameElement.appendChild(document.createTextNode("HR"));
        studentElement1.appendChild(nameElement);

        Element emailElement = document.createElement("email");
        emailElement.appendChild(document.createTextNode("hr@department.com"));
        studentElement1.appendChild(emailElement);

        // 2
        Element studentElement2 = document.createElement("Department");
        rootElement.appendChild(studentElement2);

        Element firstnameElement = document.createElement("firstname");
        firstnameElement.appendChild(document.createTextNode("IT"));
        studentElement2.appendChild(firstnameElement);

        Element emailElement2 = document.createElement("email");
        emailElement2.appendChild(document.createTextNode("IT@department.com"));
        studentElement2.appendChild(emailElement2);

        // generate xml
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult resource = new StreamResult(new File("C:\\Users\\User\\IdeaProjects\\MidtermExample\\department.xml"));
        transformer.transform(domSource, resource);
    }

    public static void parseXML() throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(new File("C:\\Users\\User\\IdeaProjects\\MidtermExample\\department.xml"));

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("Department");

        Element departmentElement1 = (Element) nodeList.item(0);
        NodeList nameList = departmentElement1.getElementsByTagName("name");
        NodeList emailList = departmentElement1.getElementsByTagName("email");
        System.out.println("Name: " + nameList.item(0).getTextContent());
        System.out.println("Email: " + emailList.item(0).getTextContent());

        Element departmentElement2 = (Element) nodeList.item(1);
        NodeList firstname = departmentElement2.getElementsByTagName("firstname");
        NodeList lastnameList = departmentElement2.getElementsByTagName("email");
        System.out.println("FirstName: " + firstname.item(0).getTextContent());
        System.out.println("Email: " + lastnameList.item(0).getTextContent());
    }
}

