import java.util.Random;

/**
 * Created by Zach on 7/18/17.
 */
public class Main {

    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        GamePiece gamePiece = new GamePiece();

        soutInfo(gamePiece);
        gamePiece.move(randomNum(), randomNum());
        soutInfo(gamePiece);
        gamePiece.freeze();
        gamePiece.move(randomNum(), randomNum());
        soutInfo(gamePiece);
        gamePiece.unFreeze();
        gamePiece.move(randomNum(), randomNum());
        soutInfo(gamePiece);

    }

    private static void soutInfo(GamePiece gamePiece) {
        System.out.println("Frozen: " + gamePiece.frozen);
        System.out.println("X: " + gamePiece.getPositionX());
        System.out.println("Y: " + gamePiece.getPositionY());
    }

    public static int randomNum() {
        return random.nextInt(100) + 1;

    }
}
