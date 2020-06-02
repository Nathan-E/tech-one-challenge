package com.decagonhq.version1.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.decagonhq.version1.model.AuthorList;





@RestController
public class UserResource {
	
	// by autowired (@Autowired annotation is a consumer while @Bean is producer), 
	// i am telling spring that there is bean of type webclient.builder somewhere(main class),
	//would you be kind enough to inject(consume) the same type here.
	//Spring is smart enough to do it gracefully.
  
	@Autowired
	private WebClient.Builder webClientBuilder;

	
	
	
	@RequestMapping("users/active-authors-submission-count/{page}/{threshold}")
	/**
	 * @param threshold (minimum value)
	 * @return This function would retrieve the names of the most active 
	 * authors(using submission_count as the criteria) according to a set threshold.
	 */
	public List<String> getUsernames(@PathVariable int page, @PathVariable int threshold ) {
		
		//threshold means the minimum/benchmark as per submission count.
		
		// create array string that will hold the list of authors.
		List<String> mostActiveAuthors = new ArrayList<String>();
		
		
		//call the web service using webclient builder.(async)
	   AuthorList authorList =  getApiCall(page);
	   
	   authorList.getData().forEach(author-> {
		   // add only the  author with submission count greater threshold specified
		   if( author.getSubmission_count() > threshold ) {
			   mostActiveAuthors.add(author.getUsername());
		   } 
	   });
	   
	   return mostActiveAuthors;
	   	   
	}
	
	@RequestMapping("/users/highest-comment-count/{page}")
	public String getUsernameWithHighestCommentCount(@PathVariable int page) {
		
		// call api
		AuthorList authorList = getApiCall(page);
		
		// hash map to hold author and comment count
		HashMap<String, Integer> authorComment = new HashMap<>();
		
		authorList.getData().forEach(author->{
			authorComment.put(author.getUsername(), author.getComment_count());
		});
		
		return Collections.max(authorComment.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey().toString();
	}
	
	
	@RequestMapping("/users/username-sorted-by-recorddate/{page}/{threshold}")
	public List<String> getUsernamesSortedByRecordDate(@PathVariable int page, @PathVariable String threshold) throws ParseException {
		
		// here the threshold is created date.  
		   
		//call api
		AuthorList authorList = getApiCall(page);
		
		//list to hold the sorted authors
		List<String> usernames = new ArrayList<>();
		
		//TreeMap to hold author and record date
		//TreeMap is naturally sorted.
		TreeMap<String, Date> authorRecordSorted = new TreeMap<>();
		
		//format date
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		
		// threshold date
		Date thresholdDate = sdformat.parse(threshold);
		
		authorList.getData().forEach(author->{
			try {
				String formatedData = sdformat.format(author.getCreated_at());
				Date recordedDate = sdformat.parse(formatedData);
				//only add the author that has record date higher than the threshold date
				if(recordedDate.compareTo(thresholdDate) > 0) {
					
					
					authorRecordSorted.put(author.getUsername(), sdformat.parse(sdformat.format(author.getCreated_at())));
				}		
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		});
		
		//since we are interested in the names, iterate the sorted treemap author with record dates
		//and add the author(key) to the list
		authorRecordSorted.forEach((k, v)-> {
			usernames.add(k);
		});
		
		
		return usernames;
		
		
	}
	
	
	
	private AuthorList getApiCall(int page) {
		//call the web service using webclient builder.(async)
		   AuthorList authorList =  webClientBuilder.build()
				 				.get()
				 				.uri("/search?page="+page) //specify any page here...
				 				.retrieve()
				 				.bodyToMono(AuthorList.class)
				 				.block();
		 return authorList;
	}

}
