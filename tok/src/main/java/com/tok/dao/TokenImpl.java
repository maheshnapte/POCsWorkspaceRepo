package com.tok.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tok.model.Token;
import com.tok.model.Tokens;

@Repository
public class TokenImpl implements TokenDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Token getToken() {
		// TODO Auto-generated method stub
		System.out.println("Reached here");

		Session session = this.sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		TypedQuery<Token> query = session.createQuery("from Token tok");
		List<Token> list = query.getResultList();
		System.out.println("list.size(): " + list.size());
		System.out.println("list: " + list);
		System.out.println("Reached after query execution");
		return list.get(0);
	}

	@Override
	public void add(Token token) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(token);	
	}

	@Override
	public Tokens getTokenP(Tokens tokens) {
		// TODO Auto-generated method stub
		Serializable i = sessionFactory.getCurrentSession().save(tokens);
		System.out.println("i: "+i);
		return tokens;
	}

}
