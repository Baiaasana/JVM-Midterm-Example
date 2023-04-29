import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IOException, SAXException {

        // 1-2
        int[] intArray = new int[]{1, 2, 3, 402, 500, 6, 8, 9, 10};
        System.out.println(ArrayUtils.avg_ar(intArray));
        System.out.println(ArrayUtils.avg_geo(intArray));

        // 3
        Department department1 = new Department("IT", "IT@department.com", 120);
        Department department2 = new Department("IT", "IT@department.com", 121);
        Department department3 = new Department("HR", "HR@department.com", 120);

        System.out.println(department1);
        System.out.println(department1.equals(department2));
        System.out.println(department1.equals(department3));

        // 4
        XmlUtils.createXML();
        XmlUtils.parseXML();
    }
}