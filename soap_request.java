import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class SoapRequest {
    public static void main(String[] args) {
        try {
            File inputFile = new File("SOAP_request.txt");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("ns2:add");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("First number : " +
                            eElement.getElementsByTagName("x").item(0).getTextContent());
                    System.out.println("Second number : " +
                            eElement.getElementsByTagName("y").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// SOAP_request.xml
// <?xml version="1.0" encoding="UTF-8"?>
// <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
//  <S:Header/>
//  <S:Body>
//      <ns2:add xmlns:ns2="http://abc/">
//          <x>100</x>
//          <y>200</y>
//      </ns2:add>
//  </S:Body>
// </S:Envelope>