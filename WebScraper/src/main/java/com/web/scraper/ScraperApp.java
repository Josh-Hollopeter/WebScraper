package com.web.scraper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScraperApp {
	public static void main(String[] args) {
		List<String> subjects = new ArrayList<>();
		List<Elements> elemSubjects = new ArrayList<>();
		List <Elements> subLinks = new ArrayList<>();
		HashMap <String,Elements> courseMap = new HashMap<>();
		Elements filteredLinks = null;
		try {
			Document doc = Jsoup.connect("https://www.coursebuffet.com/areas").get();


			Elements links = doc.select("a[href*=/sub/]");
			
			

			
			for(Element link : links) {
				Document subDoc = Jsoup.connect(link.absUrl("href")).get();
				subLinks.add(subDoc.select("a[href*=/course/]"));
				subjects.add(subDoc.select("span.resultlist-unit-coursedesc").text());
				elemSubjects.add(subDoc.select("span.resultlist-unit-coursedesc"));
				courseMap.put(subDoc.title(),subDoc.select("a[href*=/course/]"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("here");
		List<String> courseTitles = new ArrayList<>();
		List<List<String>> courses = new ArrayList<>();
		List<List <String>> courseDescription = new ArrayList<>();
		List<String> courseDescriptions = new ArrayList<>();
		HashMap<String, String> courseJson  = new HashMap<>();
		for( int i = 0; i < subLinks.size() ; i++) {
			courses.add(Arrays.asList(subLinks.get(i).select("a[href]").text().split("View Course")));
			courseDescription.add(Arrays.asList(subjects.get(i).split("\\.\\.\\.")));
			
			
		}
		for(int i=0; i < courses.size(); i++) {
			for(int j = 0; j < courses.get(i).size(); j++) {
				courseJson.put(courses.get(i).get(j), elemSubjects.get(i).get(j).text());
				courseTitles.add(courses.get(i).get(j));
				courseDescriptions.add(elemSubjects.get(i).get(j).text());
				
			}
			
		}
		
//		courseTitles.listIterator().forEachRemaining(s -> System.out.println(s));
//		courseDescriptions.listIterator().forEachRemaining(s -> System.out.println(s));
		JSONObject result = new JSONObject(courseJson);
		try {
			String path = System.getProperty("user.home") + File.separator + "Desktop";
			File file = new File(path,"courses.json");
			FileWriter fw = new FileWriter(file);
			fw.write(result.toString(1));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(courseJson.size());
		System.out.println(result.toString(2));

	}
}
