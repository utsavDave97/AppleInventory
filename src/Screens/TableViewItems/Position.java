package Screens.TableViewItems;

public class Position {
	private String position;

	public Position(String position) {
		super();
		this.position = position;
	}

	@Override
	public String toString() {
		return  position;
	}

	public Position() {
		super();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	

}
