package com.survey.form;

public class CardCount {

	
	static int cardCount=1;
	
	private CardCount() {
		
	}

	public synchronized static int nextCount() {
		if(cardCount>10)
			return cardCount = 10;
		return cardCount++;
	}

	public synchronized static int previousCount() {
		if(cardCount < 0)
			return cardCount = 0;
		return cardCount--;
	}
	
	public synchronized static int getCurrentCount(){
		return cardCount;
	}
	
	
}
