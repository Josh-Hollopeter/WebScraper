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
		 List <String> classes = new ArrayList<>();
	    try {
	      // Here we create a document object and use JSoup to fetch the website
	      Document doc = Jsoup.connect("https://www.coursebuffet.com/areas").get();

	      // With the document fetched, we use JSoup's title() method to fetch the title
	      System.out.printf("Title: %s\n", doc.title());

	      // Get the list of repositories
	      Elements links = doc.getElementsByTag("a");

	      /**
	       * For each repository, extract the following information:
	       * 1. Title
	       * 2. Number of issues
	       * 3. Description
	       * 4. Full name on github
	       */
	     
	     
	      for (Element link : links) {
	    	  if(link.attributes().toString().contains("sub")) {
	    		  Document subDoc = Jsoup.connect(link.absUrl("href")).get();
	    		  System.out.println(subDoc.body().child(2).text() + "******************");
	    		  classes.add(link.text());
	    	  }
	    	 
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
	      }

	    // In case of any IO errors, we want the messages written to the console
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	   for (String string : classes) {
		System.out.println(string);
	}
	}

}
