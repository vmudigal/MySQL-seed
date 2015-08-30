package com.mudigal.support.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import com.mudigal.support.constants.MySQLSeedingConstants;
import com.mudigal.support.domain.CaseCommentsEntity;
import com.mudigal.support.domain.CaseEntity;

public class DataSeedingUtil {
	
	public static CaseEntity fillRandomData(CaseEntity caseEntity) {
		Random randomGenerator = new Random();

		// Random Game ID
		caseEntity.setGameId(randomGenerator.nextInt(251) + 1);

		// Random Status
		int pickStatus = randomGenerator.nextInt(6) + 1;
		caseEntity.setStatus(getStatus(pickStatus));

		// Random Locale
		int pickLocale = randomGenerator.nextInt(5) + 1;
		caseEntity.setLocale(getLocale(pickLocale));

		// Random Date
		int day = randomGenerator.nextInt(29) + 1;
		int year = 2011;
		int month = randomGenerator.nextInt(6) + 8;
		if (month == 13) {
			month = 9;
		} else if (month == 14) {
			month = 1;
			year = 2012;
		}

		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		Date date = calendar.getTime();

		caseEntity.setCreatedDate(date);

		// Return filled caseEntity
		return caseEntity;
	}
	
	public static CaseCommentsEntity fillRandomData(CaseCommentsEntity commentsEntity) {
		
		Random generator = new Random();
		 
		String article[] = { "the ", "a ", "one ", "some ", "any " };
		// define noun, verb, preposition in same way here
		String noun[]={"boy ","dog ","car ","bicycle "};
		String verb[]={"ran ","jumped ","sang ","moves "};
		String preposition[]={"away ","towards ","around ","near "};
		 
		StringBuilder body = null;
		 
		// randomly create sentence
		for ( int j = 0; j < 20; j++ ) {
		int article1 = generator.nextInt(article.length );
		
		// generate others here like noun1, verb1, ....
		int noun1 = generator.nextInt(noun.length );
		int verb1 = generator.nextInt(verb.length );
		int preposition1 =generator.nextInt(preposition.length);
		int article2=generator.nextInt(article.length);
		int noun2=generator.nextInt(noun.length);
		 
		body = new StringBuilder();
		 
		// concatenate words and add period
		body.append(article[article1]).append(noun[noun1]).append
		(verb[verb1]).append(preposition[preposition1]).append
		(article[article2]).append(noun[noun2]);
		 
		// capitalize first letter
		body.setCharAt(0, Character.toUpperCase( body.charAt( 0 ) ) );
		} 
		
		commentsEntity.setBody(body.toString());		
		return commentsEntity;
	}

	private static String getLocale(int pickLocale) {
		switch(pickLocale) {
			case 1: return MySQLSeedingConstants.de_DE;
			case 2: return MySQLSeedingConstants.en_US;
			case 3: return MySQLSeedingConstants.es_ES;
			case 4: return MySQLSeedingConstants.fr_FR;
			case 5: return MySQLSeedingConstants.it_IT;
			case 6: return MySQLSeedingConstants.pt_BR;
			case 7: return MySQLSeedingConstants.zh_TW;
			case 8: return MySQLSeedingConstants.jp_JP;
		}
		return MySQLSeedingConstants.en_US;
	}

	private static String getStatus(int pickStatus) {
		switch(pickStatus) {
			case 1: return MySQLSeedingConstants.New;
			case 2: return MySQLSeedingConstants.Answered;
			case 3: return MySQLSeedingConstants.Pending_Resolution;
			case 4: return MySQLSeedingConstants.Awaiting_Player_Reply;
			case 5: return MySQLSeedingConstants.Updated_by_Player;
			case 6: return MySQLSeedingConstants.No_Player_Response;
			case 7: return MySQLSeedingConstants.Escalated;
		}
		return MySQLSeedingConstants.New;
	}
}
