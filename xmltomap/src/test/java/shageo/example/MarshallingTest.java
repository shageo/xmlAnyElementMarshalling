package shageo.example;

import com.google.common.io.Resources;
import org.testng.annotations.Test;
import org.testng.collections.Maps;
import shageo.example.model.Root;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class MarshallingTest {
    @Test
    public void testToXml() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Root unmarshaled = (Root) jaxbUnmarshaller.unmarshal(Resources.getResource("test.xml"));
        Root expected = new Root();
        LinkedHashMap<String, String> otherElements = new LinkedHashMap<String, String>();
        otherElements.put("key1", "value1");
        otherElements.put("key2", "value2");
        expected.setOtherElements(otherElements);
        expected.setSomeElement("some value");
        assertEquals(unmarshaled, expected);
    }

    @Test
    public void testFromXml() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        StringWriter writer = new StringWriter();
        Root parent = new Root();
        Map<String, String> elements = Maps.newHashMap();
        elements.put("key1", "value1");
        elements.put("key2", "value2");
        parent.setOtherElements(elements);
        parent.setSomeElement("some value");

        marshaller.marshal(parent, writer);
        assertEquals(writer.toString(), "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<root>" +
                "<otherelements><key1>value1</key1><key2>value2</key2></otherelements>" +
                "<someelement>some value</someelement>" +
                "</root>");
    }
}
