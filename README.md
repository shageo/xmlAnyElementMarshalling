# xmlAnyElementMarshalling
Marshalling and unmarshalling XML to/from Map&lt;String, String>

This is an example for xml tag to string map marshalling. Key concepts are:
1. Create List<Element> field in a class annotated with @XmlAnyElement to collect all tags to the list
2. Create Map<String, String> field annotated with @XmlJavaTypeAdapter that will contain tranformation result
3. Write an adapter to tranform List<Element> to Map<String, String> and back
