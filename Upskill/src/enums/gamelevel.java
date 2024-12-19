package enums;

 enum game {
	EASY(15,3.0),
	MEDIUM(10,4.0),
	HARD(5,5.0);
	private final int lives;
	private final double rating;
	game(int lives,double rating){
		this.lives=lives;
		this.rating=rating;
	}
	public int getLives() {
		return lives;
	}
	public double getRating() {
		return rating;
	}
	public void adjust() {
		System.out.println("Game level :"+game.this);
		System.out.println("Game lives"+getLives());
		System.out.println("Game ratings :"+ getRating());
		
	}
	
	

}
public class gamelevel{
 public static void main(String[] args) {
	for(game gam:game.values()) {
		gam.adjust();
		System.out.println("---------");
	}
}
}
