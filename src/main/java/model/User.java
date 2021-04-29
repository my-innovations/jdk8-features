package model;

public class User {
	
	double score;

	public User(double score) {
		super();
		this.score = score;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "User [score=" + score + "]";
	}

}