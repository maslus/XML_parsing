import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

//import java.util.Date;

public class Test {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        final String fileName = "XMLDaily.xml";

        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        MyHandler handler = new MyHandler();
        xmlReader.setContentHandler(handler);
        xmlReader.parse("C:\\Java\\Currency-converter\\src\\XMLDaily");

        ValCurs valCurs = handler.getValCurs();

        System.out.println(
                //"\nValCurs date: "+ valCurs.Date +
                "\nValCurs name: " + valCurs.name);
        valCurs.valuteList.forEach(System.out::println);
    }
}
