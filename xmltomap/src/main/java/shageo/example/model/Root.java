package shageo.example.model;

import shageo.example.KeyValueAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

@XmlRootElement(name = "root")
public class Root extends AnyElementWrapper {
    private String someElement;
    private Map<String, String> otherElements;

    @XmlElement(name = "someelement")
    public String getSomeElement() {
        return someElement;
    }

    public void setSomeElement(String someElement) {
        this.someElement = someElement;
    }

    @XmlJavaTypeAdapter(KeyValueAdapter.class)
    @XmlElement(name = "otherelements")
    public Map<String, String> getOtherElements() {
        return otherElements;
    }

    public void setOtherElements(Map<String, String> otherElements) {
        this.otherElements = otherElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Root parent = (Root) o;

        return (someElement != null ? someElement.equals(parent.someElement) : parent.someElement == null)
                && (otherElements != null ? otherElements.equals(parent.otherElements) : parent.otherElements == null);
    }

    @Override
    public int hashCode() {
        int result = someElement != null ? someElement.hashCode() : 0;
        result = 31 * result + (otherElements != null ? otherElements.hashCode() : 0);
        return result;
    }
}
