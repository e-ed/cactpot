package cactpot;

public class Cell {
	private boolean clicked = false;
	private final int value;
	int iPosition;
	int jPosition;
	
	public int getValue() {
		return this.value;
	}
	
	public boolean getClicked() {
		return this.clicked;
	}
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	
	public void printNumber() {
		if (this.clicked == false) {
			System.out.printf("x ");
		} else {
			System.out.printf("%d ", this.value);
		}
	}
	
	public Cell(int value, int iPosition, int jPosition) {
		this.value = value;
		this.iPosition = iPosition;
		this.jPosition = jPosition;
	}
}
