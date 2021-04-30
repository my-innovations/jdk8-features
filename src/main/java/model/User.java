package model;

public class User {
	
	int score;

	public User(int score) {
		super();
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "User [score=" + score + "]";
	}

}