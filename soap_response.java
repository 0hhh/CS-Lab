import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class SoapResponse {
    public static void main(String[] args) {
        try {
            File inputFile = new File("SOAP_response.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("ns2:addResponse");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                // System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("result : " +
                            eElement.getElementsByTagName("return").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// SOAP_response.xml
// <?xml version="1.0" encoding="UTF-8"?>
// <S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
// <S:Header/>
//  <S:Body>
//      <ns2:addResponse xmlns:ns2="http://abc/">
//          <return>300</return>
//      </ns2:addResponse>
//  </S:Body>
// </S:Envelope>