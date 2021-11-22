package stage;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Player {

	private int x;
    private int y;
    private int floor; // 이미지의 최소 y좌표
    private boolean jumping; // 점프하면 트루
    private int moveLength; // 이동 거리
    private int jumpHeight;
    private Image[] imageRight = new Image[5]; // 이미지 사이즈 다 같음
    private Image[] imageLeft = new Image[5];
    private int i, j;
    private boolean gameOver;
    private int counter;

    public Player() {
        super();
        for (int k = 0; k < 5; k++) {
            imageRight[k] = new Image(("/playerImage/playerRight_" + k + ".png"));
            imageLeft[k] = new Image(("/playerImage/playerLeft" + k + ".png"));
        }
        this.x = 100;
        this.floor = (int) (800 - 140 - imageRight[0].getHeight()); // 140은 최소 땅 높이
        this.y = floor;
        this.i = 0;
        this.j = 0;
        this.moveLength = 5;
        this.jumping = false;
        this.jumpHeight = 5;
        this.gameOver = false;
        this.counter = 0;
    }

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getMoveLength() {
        return moveLength;
    }

    Image getImage() {
        if (i < 10)
            return imageRight[0];
        else if (i < 20)
            return imageRight[1];
        else if (i < 30)
            return imageRight[2];
        else if (i < 40)
            return imageRight[3];
        else if (i < 50)
            return imageRight[4];
        else if (j < 10)
            return imageLeft[0];
        else if (j < 20)
            return imageLeft[1];
        else if (j < 30)
            return imageLeft[2];
        else if (j < 40)
            return imageLeft[3];
        else
            return imageLeft[4];
    }

    boolean getGameOver() {
        return gameOver;
    }

    void setFloor(int floor) {
        this.floor = floor;
    }

    void move(ArrayList<String> input) {
        if (input.contains("LEFT") && x > 0) {
            x -= moveLength;
            i = 50;
            j++;
            if (j >= 50)
                j = 10;
        }
        if (input.contains("RIGHT") && x < 800 - imageRight[0].getWidth()) {
            x += moveLength;
            j = 50;
            i++;
            if (i >= 50)
                i = 10;
        }
        if (input.isEmpty()) {
            if (j == 50) // 마지막 걸음이 오른쪽일때
                i = 0;
            else // 마지막 걸음이 왼쪽일때
                j = 0;
        }
        if (input.contains("DOWN")) {
            counter = 0;
            floor = (int) (800 - 140 - imageRight[0].getHeight());
            y = floor;
        }
    }

    void checkJumping() {
        for (int i = 0; i < 2; i++) {
            if (jumping) {
                y -= jumpHeight;
                counter++;
                if (counter >= 62) {
                    jumping = false;
                }
            }
        }
    }
}
