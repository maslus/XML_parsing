import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class MyHandler extends DefaultHandler {
    final String VALCURS_TAG = "ValCurs";
    final String VALUTE_TAG = "Valute";
    final String NUMCODE_TAG = "NumCode";
    final String CHARCODE_TAG = "CharCode";
    final String NOMINAL_TAG = "Nominal";
    final String NAME_TAG = "Name";
    final String VALUE_TAG = "Value";

    //   static final Date DATE_ATTRIBUTE = new Date();
    final String NAME_ATTRIBUTE = "Name";
    final String ID_ATTRIBUTE = "ID";

    private ValCurs valCurs;
    private Valute currentValute;
    private String valuteID;
    private String currentElement;

    ValCurs getValCurs() {
        return valCurs;
    }

    public void startDocument() throws SAXException {
        System.out.println("Starting XML parsing...");
    }

    @Override
    public void startElement(String url, String localName, String qName, Attributes attributes) throws SAXException{
        currentElement = qName;

        switch (currentElement){
            case VALCURS_TAG: {
                valCurs=new ValCurs();
                // valCurs.Date = Date.from(attributes.getValue(DATE_ATTRIBUTE));
                valCurs.name = NAME_ATTRIBUTE;
            }
            break;

            case VALUTE_TAG: {
                valCurs.valuteList =new ArrayList<>();

                if (valuteID==null){
                    valuteID=attributes.getValue(ID_ATTRIBUTE);
                }

                  /*  currentValute = new Valute();
                    currentValute.ID = String.copyValueOf(attributes.getValue(ID_ATTRIBUTE));
                 */
            }
            break;

            default:{

            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch,start,length);

        if (text.contains("<") || currentElement == null) {
            return;
        }

        switch (currentElement){
            case NUMCODE_TAG: {
                currentValute.NumCode = Integer.valueOf(text);
            }
            break;

            case CHARCODE_TAG: {
                currentValute.CharCode = text;
            }
            break;

            case NOMINAL_TAG: {
                currentValute.Nominal = Integer.valueOf(text);
            }
            break;

            case NAME_TAG: {
                currentValute.Name = text;
            }
            break;

            case VALUE_TAG: {
                currentValute.Value = Double.valueOf(text);
            }
            break;

            default: {

            }
        }
    }

    @Override
    public void endElement(String url, String localName, String qName) throws SAXException {
        switch (qName) {
            case VALUTE_TAG: {
                valCurs.valuteList.add(currentValute);
                currentValute=null;
            } break;

            default:{

            }
        }
        currentElement = null;
    }

    public void endDocument() throws SAXException {
        System.out.println("XML parsing is completed.");
    }
}