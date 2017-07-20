/**
 * Created by Zach on 7/18/17.
 */
public class GamePiece {

    int positionX;
    int positionY;
    boolean frozen;
    String name;
    String color;
    String size;

    public GamePiece() {
        this.positionX = 0;
        this.positionY = 0;
        this.frozen = false;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void move(int x, int y){
        if (!frozen){
        positionX = x;
        positionY = y;
        }
    }

    public void freeze(){
        frozen = true;
    }

    public void unFreeze(){
        frozen = false;
    }
}
