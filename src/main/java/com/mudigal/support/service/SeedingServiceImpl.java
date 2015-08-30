package com.mudigal.support.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mudigal.support.domain.CaseCommentsEntity;
import com.mudigal.support.domain.CaseEntity;
import com.mudigal.support.util.DataSeedingUtil;

/**
 * Service for processing Players
 * 
 */
@Service("seedingService")
@Transactional
public class SeedingServiceImpl implements SeedingService {

	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	private SessionFactory sessionFactory;

	public int addData() {
		Session session = sessionFactory.getCurrentSession();
		int count;
		for (count = 0; count < 5000; count++) {
			CaseEntity caseEntity = new CaseEntity();
			caseEntity = DataSeedingUtil.fillRandomData(caseEntity);
			CaseCommentsEntity commentsEntity1 = new CaseCommentsEntity();
			commentsEntity1 = DataSeedingUtil.fillRandomData(commentsEntity1);
			CaseCommentsEntity commentsEntity2 = new CaseCommentsEntity();
			commentsEntity2 = DataSeedingUtil.fillRandomData(commentsEntity2);
			Collection<CaseCommentsEntity> commentsList = new ArrayList<CaseCommentsEntity>();
			commentsList.add(commentsEntity1);
			commentsList.add(commentsEntity2);
			caseEntity.setComments(commentsList);
			session.save(caseEntity);
		}
		return count;
	}
}