package myUtils;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by WangSai on 2021/3/27
 */
public class XMLUtil {
    private static final String CONFIG_PATH = "src/main/resources/factory.xml";

    public static Object getBean(String className) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(CONFIG_PATH);
            NodeList elements = document.getElementsByTagName(className);
            String cName = elements.item(0).getFirstChild().getNodeValue();

            // 反射
            return  Class.forName(cName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
