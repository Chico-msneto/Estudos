package application;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		LocalDateTime time;
		time = LocalDateTime.parse("2018-06-21T13:05:44");
		Comment c1 = new Comment("Have a nice trip!");	
		Comment c2 = new Comment("Wow that's awesome!");
		
		Post p1 = new Post(time, "Travelling to New Zealand", "I'm going to visit this wonderful country!", 12);
		p1.addComment(c1);
		p1.addComment(c2);
		
		LocalDateTime time2;
		time2 = LocalDateTime.parse("2018-07-28T23:14:19");
		Comment c3 = new Comment("Good night");	
		Comment c4 = new Comment("May the force be with you");
		
		Post p2 = new Post(time2, "Good night guys", "See you tomorrow", 5);
		p2.addComment(c3);
		p2.addComment(c4);
		
		System.out.println(p1);
		System.out.println(p2);
		
		sc.close();
	}

}
