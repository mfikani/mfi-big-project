package mfi.old_packages.tutorials.hacketrank.tutorials._30_days_of_code.day13_AbstractClasses;

abstract class Book {
	String title;
	String author;
	Book(String t, String a){
		title = t;
		author = a;
	}
	abstract void display();
}

class MyBook extends Book{
	int price;
	MyBook(String title, String author, int price) {
		super(title, author);
		this.price = price;
		// TODO Auto-generated constructor stub
	}
	 void display(){
		System.out.println("Title: "+title);
		System.out.println("Author: "+author);
		System.out.println("Price: "+price);
	}
}