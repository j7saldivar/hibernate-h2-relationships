package com.saldivar.hibernate.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "person_book")
public class PersonBook {

	@EmbeddedId
	private PersonBookId id = new PersonBookId();
	
	@Column(name = "valid_date")
	private Date validDate;
	private Integer quantity;

	public PersonBookId getId() {
		return id;
	}

	public void setId(PersonBookId id) {
		this.id = id;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Person getPerson() {
		return getId().getPerson();
	}

	public void setPerson(Person person) {
		getId().setPerson(person);
	}

	public Book getBook() {
		return getId().getBook();
	}

	public void setBook(Book book) {
		getId().setBook(book);
	}

}
