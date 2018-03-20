package util;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import components.*;


public class XMLFileReader {
private File file;
private ArrayList<Movie> movieList = new ArrayList<>();

public XMLFileReader(File file)
{
	this.file=file;
	read();
}

public ArrayList<Movie> getMovieList()
{
	return movieList;
}

public void setMovieList(ArrayList<Movie> movieList)
{
	this.movieList = movieList;
}

public void read()
{
	try {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		File newFile = new File("/Users/pravarai/Documents/untitled.xml");
		if (newFile.exists())
		{
			System.out.println("File found and loaded");
		}
		Document doc = dBuilder.parse(newFile);
		doc.getDocumentElement().normalize();
		NodeList nodeList = doc.getElementsByTagName("programme");
		for(int c=0; c<nodeList.getLength(); c++) {
			Node node = nodeList.item(c);
			Movie m = new Movie();
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
				Element e = (Element) node;
				m.setId(e.getAttribute("id"));
				m.setName(e.getElementsByTagName("name").item(0).getTextContent());
				m.setLevel(e.getElementsByTagName("level").item(0).getTextContent());
				m.setMood(e.getElementsByTagName("mood").item(0).getTextContent());
				m.setPath(e.getElementsByTagName("imagePath").item(0).getTextContent());	
			}
			movieList.add(m);
		}
	} 
	catch (Exception e)
	{
		e.printStackTrace();
	}
}

}
