package com.tumbwe.bobsutils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

/**
 * Basic utilities for parsing and querying XML strings.
 */
public class XmlUtils {

    /**
     * Parses an XML string into a W3C Document.
     */
    public static Document parse(String xml) {
        if (StringUtils.isBlank(xml)) return null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Quickly gets the text content of the first element matching the tag name.
     */
    public static String getElementValue(String xml, String tagName) {
        Document doc = parse(xml);
        if (doc == null) return null;
        NodeList list = doc.getElementsByTagName(tagName);
        if (list.getLength() > 0) {
            return list.item(0).getTextContent();
        }
        return null;
    }
}
