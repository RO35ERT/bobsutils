package com.tumbwe.bobsutils;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import static org.junit.jupiter.api.Assertions.*;

class XmlUtilsTest {

    @Test
    void testParse() {
        String xml = "<root><item>Hello</item></root>";
        Document doc = XmlUtils.parse(xml);
        assertNotNull(doc);
        assertEquals("root", doc.getDocumentElement().getNodeName());
        
        assertNull(XmlUtils.parse(null));
        assertNull(XmlUtils.parse("invalid xml"));
    }

    @Test
    void testGetElementValue() {
        String xml = "<user><name>Bob</name><email>bob@example.com</email></user>";
        assertEquals("Bob", XmlUtils.getElementValue(xml, "name"));
        assertEquals("bob@example.com", XmlUtils.getElementValue(xml, "email"));
        assertNull(XmlUtils.getElementValue(xml, "nonexistent"));
    }
}
