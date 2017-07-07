package com.jiangjian.study.java.datastruction.array;

public class Scoreboard {
	private int numEntries = 0;
	private GameEntry[] board;
	
	public Scoreboard(int capacity) {
		board = new GameEntry[capacity];
	}
	
	public void add(GameEntry newEntry) {
		int score = newEntry.getScore();
		if(numEntries < board.length || score > board[numEntries - 1].getScore()) {
			if(numEntries < board.length) numEntries++;
			int j = numEntries - 1;
			while(j > 0 && (board[j - 1].getScore() < score)) {
				board[j] = board[j -1];
				j--;
			}
			board[j] = newEntry;
		}
	}
	
	
	public GameEntry remove(int i) {
		if(i < 0 || i >= numEntries) throw new IndexOutOfBoundsException();
		GameEntry retVal = board[i];
		while(i < numEntries - 1) {
			board[i] = board[i + 1];
			i++;
		}
		board[numEntries - 1] = null;
		numEntries--;
		return retVal;
	}
	
	public int size() {
		return numEntries;
	}
	
	public void display() {
		for(int i = 0; i < numEntries; i++) {
			System.out.println(board[i]);
		}
	}
	
	public static void main(String[] args) {
		Scoreboard board = new Scoreboard(3);
		board.add(new GameEntry("A", 100));
		board.add(new GameEntry("A", 100));
		board.add(new GameEntry("A", 100));
		board.add(new GameEntry("B", 120));
		board.display();
		System.out.println("size=" + board.size());
		board.remove(2);
		board.display();
	}
}
