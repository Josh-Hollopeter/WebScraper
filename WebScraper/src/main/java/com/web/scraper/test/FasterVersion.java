package com.web.scraper.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FasterVersion {
	public static void main(String[] args) {
		List<String> subjects = new ArrayList<>();
//		List<String> courses = new ArrayList<>();
		List <Elements> subLinks = new ArrayList<>();
		HashMap <String,Elements> courseMap = new HashMap<>();
		Elements filteredLinks = null;
		try {
			// Here we create a document object and use JSoup to fetch the website
			Document doc = Jsoup.connect("https://www.coursebuffet.com/areas").get();

			// With the document fetched, we use JSoup's title() method to fetch the title
//			System.out.printf("Title: %s\n", doc.title());

			// Get the list of repositories
			Elements links = doc.select("a[href*=/sub/]");
//			Elements unfilteredLinks = doc.getElementsByTag("a");
			
			

			/**
			 * For each repository, extract the following information: 1. Title 2. Number of
			 * issues 3. Description 4. Full name on github
			 */
			for(Element link : links) {
				Document subDoc = Jsoup.connect(link.absUrl("href")).get();
				subLinks.add(subDoc.select("a[href*=/course/]"));
				subjects.add(subDoc.title());
				courseMap.put(subDoc.title(),subDoc.select("a[href*=/course/]"));
			}

//				System.out.println(link.text());
//				if (link.attributes().toString().contains("sub")) {
//					filteredLinks.add(link);
////					Document subDoc = Jsoup.connect(link.absUrl("href")).get();
////					System.out.println("********** " + subDoc.title());
//				if(subDoc.body().child(2).getElementsByTag("a").toString().contains("course")){
//					subLinks.add(subDoc.body().child(2).getElementsByTag("a"));
//					
//				}
////					System.out.println(subDoc.body().child(2).text() + "******************");
//					subjects.add(link.text());
//				}

//	        // Extract the title
//	        String repositoryTitle = repository.getElementsByClass("repo-item-title").text();
//
//	        // Extract the number of issues on the repository
//	        String repositoryIssues = repository.getElementsByClass("repo-item-issues").text();
//
//	        // Extract the description of the repository
//	        String repositoryDescription = repository.getElementsByClass("repo-item-description").text();
//
//	        // Get the full name of the repository
//	        String repositoryGithubName = repository.getElementsByClass("repo-item-full-name").text();
//
//	        // The reposiory full name contains brackets that we remove first before generating the valid Github link.
//	        String repositoryGithubLink = "https://github.com/" + repositoryGithubName.replaceAll("[()]", "");
//
//	        // Format and print the information to the console
//	        System.out.println(repositoryTitle + " - " + repositoryIssues);
//	        System.out.println("\t" + repositoryDescription);
//	        System.out.println("\t" + repositoryGithubLink);
//	        System.out.println("\n");

			// In case of any IO errors, we want the messages written to the console
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("here");
		List<String> courses = new ArrayList<>();
		for( int i = 0; i < subLinks.size() ; i++) {
		
			courses.add(Arrays.asList(subLinks.get(i).select("a[href]").text().split("View Course")).toString());
			
			
		}
		System.out.println(courses.get(30));
		System.out.println(Arrays.asList(subjects.get(30).split(" ")).get(0));
	}
}
