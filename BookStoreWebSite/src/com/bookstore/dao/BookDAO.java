package com.bookstore.dao;

import java.util.Date;
import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;

import org.hibernate.hql.internal.ast.tree.QueryNode;

import com.bookstore.entity.Book;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setLastUpdateTime(new Date());
		return super.update(book);
	}

	@Override
	public Book get(Object bookId) {
		return super.find(Book.class,bookId);
	
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
	}

	@Override
	public List<Book> listAll() {
		return super.findWithNamedQuery("Book.finaAll");
	}
	
	public Book findByTitle(String title) {
		List<Book> result = super.findWithNamedQuery("Book.findByTitle", "title", title);
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public long count() {
		
		return super.countWithNamedQuery("Book.countAll");
	}
	public long countByCategory(int categoryId){
		return super.countWithNamedQuery("Book.countByCategory","catId", categoryId);
	}
	
	public List<Book> listByCategory(int categoryId){
		return super.findWithNamedQuery("Book.findByCategory", "catId",categoryId);
	}
	
	public List<Book> listNewBooks(){
		return super.findWithNamedQuery("Book.listNew", 0,4);
	}
	
	public List<Book> search(String Keyword){
		return super.findWithNamedQuery("Book.search","Keyword",Keyword);

	}
	

}
