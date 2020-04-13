package com.web.scraper.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Testing {

	public static void main(String[] args) {
		List<String> subjects = new ArrayList<>();
		List<String> courses = new ArrayList<>();
		List <Elements> subLinks = new ArrayList<>();
		try {
			Document doc = Jsoup.connect("https://www.coursebuffet.com/areas").get();


			Elements links = doc.getElementsByTag("a");

		

			for (Element link : links) {
				if (link.attributes().toString().contains("sub")) {
					Document subDoc = Jsoup.connect(link.absUrl("href")).get();
				if(subDoc.body().child(2).getElementsByTag("a").toString().contains("course")){
					subLinks.add(subDoc.body().child(2).getElementsByTag("a"));
					
				}
					subjects.add(link.text());
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Here");
		int count = 0;
		for (Elements coursess : subLinks) {
			for (Element course : coursess) {
				if(course.attributes().toString().contains("course")) {
					try {
						Document subDoc = Jsoup.connect(course.absUrl("href")).get();
						System.out.println(subDoc.title());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
					count++;
				}
			
			}

		}
		System.out.println(count++);
	}

}
