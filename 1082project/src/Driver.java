public class Driver {
	public static void main(String[]args) {
		Human human = new Human();
		Computer computer = new Computer();
		Game game = new Game(human, computer);

//		game.startMatch();
	}
}
