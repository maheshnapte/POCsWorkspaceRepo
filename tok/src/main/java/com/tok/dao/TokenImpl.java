package com.tok.dao;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tok.model.Priviledged;
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
		sessionFactory.getCurrentSession().save(tokens);
		return tokens;
	}

	@Override
	public boolean isPriviledged(Tokens tokens) {
		@SuppressWarnings("unchecked")
		TypedQuery<Priviledged> query = sessionFactory.getCurrentSession()
				.createQuery("from Priviledged p where p.name = :nameP and p.mobileNumber = :mobileNoP");

		query.setParameter("nameP", tokens.getName());
		query.setParameter("mobileNoP", tokens.getMobileNo());
		List<Priviledged> list = query.getResultList();

		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getTokenNumber(String isPriviledged, Timestamp timestamp) {
		@SuppressWarnings("unchecked")
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select max(t.token) from Tokens t where t.isPriviledged = :priviledged and t.tokenTimeStamp > :ts");
		query.setParameter("priviledged", isPriviledged);
		query.setParameter("ts", timestamp);

		int token;
		try {
			token = (int) query.uniqueResult();
		} catch (Exception e) {
			System.out.println("My Exception handler: " + e);
			return -1;
		}
		System.out.println("token: " + token);
		return token;
	}

	@Override
	public List<Tokens> getTokenAllTokens() {
		System.out.println("Reached here");
		Session session = this.sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		TypedQuery<Tokens> query = session.createQuery("from Tokens tok");
		List<Tokens> list = query.getResultList();
		System.out.println("list.size(): " + list.size());

		return list;
	}

	@Override
	public List<Tokens> getTokenAllTokens(Timestamp from, Timestamp to) {
		@SuppressWarnings("unchecked")
		TypedQuery<Tokens> query = sessionFactory.getCurrentSession()
				.createQuery("from Tokens t where t.tokenTimeStamp >= :tsf and t.tokenTimeStamp <= :tst");
		query.setParameter("tsf", from);
		query.setParameter("tst", to);

		List<Tokens> list = query.getResultList();
		System.out.println("list.size(): " + list.size());

		return list;
	}

	/*
	 * @Override public Timestamp getTokenTStamp(String isPriviledged) {
	 * 
	 * @SuppressWarnings("unchecked") Query query =
	 * sessionFactory.getCurrentSession()
	 * .createQuery("select max(t.tokentimestamp) from Tokens t where t.isPriviledged = :priviledged"
	 * ); query.setParameter("priviledged", isPriviledged);
	 * 
	 * Timestamp tokenTimeStamp; try { tokenTimeStamp = (Timestamp)
	 * query.uniqueResult(); } catch (Exception e) {
	 * System.out.println("My Exception handler: "+e); return tokenTimeStamp; }
	 * System.out.println("toktokenTimeStampen: " + tokenTimeStamp); return
	 * tokenTimeStamp; }
	 */

}
