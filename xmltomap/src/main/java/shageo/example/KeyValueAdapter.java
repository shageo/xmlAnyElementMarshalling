package shageo.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import shageo.example.model.AnyElementWrapper;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.*;

public class KeyValueAdapter extends XmlAdapter<AnyElementWrapper, Map<String, String>> {

    private final DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

    public KeyValueAdapter() throws ParserConfigurationException {
    }

    @Override
    public AnyElementWrapper marshal(Map<String, String> m) throws Exception {
        AnyElementWrapper wrapper = new AnyElementWrapper();
        List<Element> elements = new LinkedList<Element>();
        Document document = documentBuilder.newDocument();

        for (Map.Entry<String, String> property : m.entrySet()) {
            Element element = document.createElement(property.getKey());
            element.appendChild(document.createTextNode(property.getValue()));
            elements.add(element);
        }
        wrapper.setElements(elements);
        return wrapper;
    }

    @Override
    public Map<String, String> unmarshal(AnyElementWrapper v) throws Exception {
        HashMap<String, String> map = new LinkedHashMap<String, String>();
        @SuppressWarnings("unchecked")
        List<Element> elements = v.getElements();
        for (Element element : elements) {
            String key = element.getTagName();
            String value = element.getFirstChild().getNodeValue();
            map.put(key, value);
        }
        return map;
    }
}