// package riveree.Model;

// import javafx.collections.FXCollections;
// import javafx.collections.ObservableList;

// import javax.xml.parsers.DocumentBuilder;
// import javax.xml.parsers.DocumentBuilderFactory;
// import org.w3c.dom.Document;
// import org.w3c.dom.Element;
// import org.w3c.dom.Node;
// import org.w3c.dom.NodeList;

// import java.io.File;

// public class UserParser {
//     public static ObservableList<User> parseUsersFromFile(String filePath) {
//         ObservableList<User> userList = FXCollections.observableArrayList();

//         try {
//             File file = new File(filePath);
//             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//             DocumentBuilder builder = factory.newDocumentBuilder();
//             Document document = builder.parse(file);

//             NodeList userNodes = document.getElementsByTagName("user");
//             for (int i = 0; i < userNodes.getLength(); i++) {
//                 Node userNode = userNodes.item(i);
//                 if (userNode.getNodeType() == Node.ELEMENT_NODE) {
//                     Element userElement = (Element) userNode;
//                     String name = getTextContent(userElement, "name");
//                     String address = getTextContent(userElement, "address");
//                     String phoneNumber = getTextContent(userElement, "phoneNumber");
//                     String email = getTextContent(userElement, "email");
//                     String password = getTextContent(userElement, "password");

//                     User user = new User(name, address, phoneNumber, email, password);
//                     userList.add(user);
//                 }
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         return userList;
//     }

//     private static String getTextContent(Element element, String tagName) {
//         NodeList nodeList = element.getElementsByTagName(tagName);
//         if (nodeList != null && nodeList.getLength() > 0) {
//             Node node = nodeList.item(0);
//             if (node.getNodeType() == Node.ELEMENT_NODE) {
//                 Element tagElement = (Element) node;
//                 return tagElement.getTextContent();
//             }
//         }
//         return "";
//     }
// }









package riveree.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;

public class UserParser {
    public static ObservableList<User> parseUsersFromFile(String filePath) {
        ObservableList<User> userList = FXCollections.observableArrayList();

        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList userNodes = document.getElementsByTagName("user");
            for (int i = 0; i < userNodes.getLength(); i++) {
                Node userNode = userNodes.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;
                    String name = getTextContent(userElement, "name");
                    String address = getTextContent(userElement, "address");
                    String phoneNumber = getTextContent(userElement, "phoneNumber");
                    String email = getTextContent(userElement, "email");
                    String password = getTextContent(userElement, "password");

                    User user = new User(name, address, phoneNumber, email, password);
                    userList.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userList;
    }

    public static User parseUserByEmail(String filePath, String email) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList userNodes = document.getElementsByTagName("user");
            for (int i = 0; i < userNodes.getLength(); i++) {
                Node userNode = userNodes.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;
                    String storedEmail = getTextContent(userElement, "email");

                    if (email.equals(storedEmail)) {
                        String name = getTextContent(userElement, "name");
                        String address = getTextContent(userElement, "address");
                        String phoneNumber = getTextContent(userElement, "phoneNumber");
                        String password = getTextContent(userElement, "password");

                        return new User(name, address, phoneNumber, email, password);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void updateUser(String filePath, User updatedUser) {
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            NodeList userNodes = document.getElementsByTagName("user");
            for (int i = 0; i < userNodes.getLength(); i++) {
                Node userNode = userNodes.item(i);
                if (userNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element userElement = (Element) userNode;
                    String storedEmail = getTextContent(userElement, "email");

                    if (updatedUser.getEmail().equals(storedEmail)) {
                        setTextContent(userElement, "phoneNumber", updatedUser.getPhoneNumber());
                        setTextContent(userElement, "password", updatedUser.getPassword());
                    }
                }
            }

            // Write the updated XML document back to the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element tagElement = (Element) node;
                return tagElement.getTextContent();
            }
        }
        return "";
    }

    private static void setTextContent(Element element, String tagName, String text) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element tagElement = (Element) node;
                tagElement.setTextContent(text);
            }
        }
    }
}
