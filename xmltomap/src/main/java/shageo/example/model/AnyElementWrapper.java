package shageo.example.model;

import org.w3c.dom.Element;

import javax.xml.bind.annotation.XmlAnyElement;
import java.util.List;

public class AnyElementWrapper {
    private List<Element> elements;

    @XmlAnyElement
    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }
}
