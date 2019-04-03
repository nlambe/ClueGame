//Authors: Nathan Lambert, Elliott McCabe

package clueGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Player {
	private String playerName;
	private int row;
	private int column;
	private Color color;
	private Set<Card> playerCards;
	
	public Player(String playerName, int row, int column, Color color) {
		this.playerName = playerName;
		this.row = row;
		this.column = column;
		this.color = color;
		playerCards = new HashSet<>();
	}
	
	public Card disproveSuggestion(Solution suggestion) {
		ArrayList<Card> disprove = new ArrayList<Card>();
		/*
		 * adds the players cards that are able to disprove the suggestion to a new arraylist to later randomly select a card
		 */
		for(Card c : playerCards) {
			if(c.getCardName() == suggestion.getPersonName()) {
				disprove.add(c);
			}
			else if(c.getCardName() == suggestion.getRoomName()) {
				disprove.add(c);
			}
			else if(c.getCardName() == suggestion.getWeaponName()) {
				disprove.add(c);
			}
		}
		Random rand = new Random();
		//if no cards that can disprove suggestion, return null
		if(disprove.isEmpty()) {
			return null;
		}
		return disprove.get(rand.nextInt(disprove.size()));
	}
	
	/*
	 * getters, only for testing
	 */
	public String getPlayerName() {
		return playerName;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public Color getColor() {
		return color;
	}
	
	public void addCard(Card c) {
		playerCards.add(c);
	}
	
	public Set<Card> getPlayerCards(){
		return playerCards;
	}
	
	public void setLocation(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
}
