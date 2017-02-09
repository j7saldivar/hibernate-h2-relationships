package com.saldivar.hibernate.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonBookId implements Serializable  {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Person person;

	@ManyToOne
	private Book book;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
