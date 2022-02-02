package com.java8.casestudy.case1;

import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;


import static java.util.stream.Collectors.*;


public class Main {

	public static void main(String[] args) {

		List<Book> allBooks = loadAllBooks();

		// 1. Find books with more then 400 pages
		System.out.println("*****books with more then 400 pages*****");
		List<Book> booksheavy=allBooks.stream()
				.filter(book->book.getPages()>400)
				.collect(Collectors.toList());
		booksheavy.forEach(System.out::println);
		// 2. Find all books that are java books and more then 400 pages
		System.out.println("*****books that are java books and more then 400 pages*****");
		Predicate <Book> pages=book->book.getPages()>=400;
		Predicate <Book> java=book->book.getSubject()==Subject.JAVA;
		
		List<Book> javaBook=allBooks.
				stream().
				filter(pages.and(java))
				.collect(Collectors.toList());
		javaBook.forEach(System.out::println);
		// 3. We need the top three longest books
		System.out.println("*****top three longest books*****");
		List<Book>longestBook=
				allBooks.
				stream()
				.sorted((book1,book2)->Integer.compare(book2.getPages(),book1.getPages()))
				.limit(3)
				.collect(toList());
		longestBook.forEach(System.out::println);
		

		// 4. We need from the fourth to the last longest books
		System.out.println("*****from the fourth to the last longest books*****");
		List<Book>longestBookAfter3=
				allBooks.
				stream()
				.sorted((book1,book2)->Integer.compare(book2.getPages(),book1.getPages()))
				.skip(3)
				.collect(toList());
		longestBookAfter3.forEach(System.out::println);
		// 5. We need to get all the publishing years
		System.out.println("*****all the publishing years*****");
		List<Integer>publishingYear=
				allBooks.
				stream()
				.map(book->book.getYear())
				.distinct()
				.sorted((int1,int2)->int2-int1)
				.collect(toList());
		publishingYear.forEach(System.out::println);

		// 6. We need all the authors names who have written a book	
		System.out.println("*****all the authors names who have written a book*****");
		List<String>authors=allBooks.stream().
				flatMap(book->book.getAuthors().stream())
				.map(author->author.getName())
				.distinct()
				.collect(toList());
		
		authors.forEach(System.out::println);

			
		// We want to know if all the books are written by more than one author? boolean
		System.out.println("*****all the books are written by more than one author*****");
		Boolean moreThenOneAuthor=
				allBooks
				.stream()
				.allMatch(book->book.getAuthors().size()>1);
		System.out.println(moreThenOneAuthor);
			
			
		//is all the elements of array are odd?
			
			
		// We want one of the books written by more than one author.? (findAny)
		System.out.println("*****one of the books written by more than one author*****");
		Optional<Book> moreBook=
				allBooks
				.stream()
				.filter(book->book.getAuthors().size()>1)
				.findAny();
		Book b=moreBook.get();
		System.out.println(b);
		// We want to know how many pages the longest book has.
		System.out.println("*****how many pages the longest book has*****");
		int longestBookPage=allBooks
				.stream()
				.max(Comparator.comparing(Book::getPages))
				.map(book->book.getPages())
				.orElse(-1);
		
		System.out.println(longestBookPage);
		
	
		// We want the average number of pages of the books
		System.out.println("*****average number of pages of the books*****");
			double averagePages=allBooks
					.stream()
					.collect(Collectors.averagingInt(book->book.getPages()));
			System.out.println(averagePages);
		// We want all the titles of the books
		System.out.println("*****all the titles of the books in list*****");
		List<String> allBookTitles=allBooks
				.stream()
				.map(book->book.getTitle())
				.collect(toList());
		allBookTitles.forEach(System.out::println);

		//all tiles print : java , adv c#, 
		System.out.println("*****all the titles of the books in String*****");
		String allBook=allBooks
				.stream()
				.map(book->book.getTitle())
				.collect(Collectors.joining("\n"));
		System.out.println(allBook);
	
		// We want the book with the higher number of authors?
		Optional<Book> bookWithHighestNoOfAuthor=
				allBooks
				.stream()
				.collect(Collectors.maxBy(Comparator.comparing(book->book.getAuthors().size())));
			System.out.println(bookWithHighestNoOfAuthor.get());
		
		// We want a Map of book per year.
		Map<Integer,List<Book>> bookPerYear=
				allBooks
				.stream()
				.collect(Collectors.groupingBy(Book::getYear));
		System.out.println(bookPerYear);
		// We want a Map of book per year and then by subject
		Map<Integer,Map<Subject,List<Book>>> mapBookPerYear=
				allBooks
				.stream()
				.collect(Collectors.groupingBy(Book::getYear,groupingBy(Book::getSubject)));
		
		
		
		// We want to count how many books are published per year.
		Map<Integer,Long>bookCountPerYear=allBooks
				.stream()
				.collect(Collectors.groupingBy(book->book.getYear(),counting()));
		System.out.println(bookCountPerYear);
	

	}

	private static List<Book> loadAllBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Author> authors1 = Arrays.asList(
				new Author("raj", "gupta", "in"),
				new Author("ekta", "gupta", "in")
				);

		List<Author> authors2 = Arrays.asList(new Author("raj", "gupta", "in"));

		List<Author> authors3 = Arrays.asList(new Author("gunika", "gupta", "us"),
				new Author("keshav", "gupta", "us"));

		books.add(new Book("java", authors1, 300, Subject.JAVA, 2021, "1213"));
		books.add(new Book("adv java", authors1, 400, Subject.JAVA, 2021, "1213"));
		
		books.add(new Book("adv C#", authors2, 700, Subject.DOT_NET, 2022, "1218"));
		books.add(new Book("C# basics", authors3, 600, Subject.DOT_NET, 2019, "1293"));

		return books;
	}

}
