import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("XML-daily.xml"));
            writer.writeStartDocument();
            writer.writeStartElement("a");
            writer.writeAttribute("b", "blah");
            writer.setPrefix("d", "http://");
            writer.writeEmptyElement("d");
            writer.writeAttribute("chris", "fry");
            writer.writeCharacters("Jean Arp");
            writer.writeEndElement();
            writer.flush();
        }
        catch (XMLStreamException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
