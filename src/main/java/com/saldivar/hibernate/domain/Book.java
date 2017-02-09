package com.saldivar.hibernate.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "book_name")
	private String bookName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = false)
	private Author author;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "book", cascade = CascadeType.ALL)
	private Stock stock;

	@ManyToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private Set<Category> category = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id.book", cascade = CascadeType.ALL)
	private Set<PersonBook> personBook = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Set<PersonBook> getPersonBook() {
		return personBook;
	}

	public void setPersonBook(Set<PersonBook> personBook) {
		this.personBook = personBook;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
