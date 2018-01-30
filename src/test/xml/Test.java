package test.xml;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read(new File("/Users/LaussTsuai/Desktop/caesar.xml"));
			try {
				PrintWriter writer = new PrintWriter("/Users/LaussTsuai/Desktop/output", "UTF-8");
				Element rootElement = doc.getRootElement();
				dfs(rootElement, 0, writer);
				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private static void dfs(Element root, int level, PrintWriter writer) {
		for (int i = 0; i < level; i ++) {
			writer.print("\t");
		}
		writer.println(root.getName());
		for (int i = 0; i < level; i ++) {
			writer.print("\t");
		}
		writer.println(root.getTextTrim());
		for (int i = 0; i < level; i ++) {
			writer.print("\t");
		}
		writer.println("-------------");
		for (Element e : root.elements()) {
			dfs(e, level + 1, writer);
		}
		return;
	}

}
