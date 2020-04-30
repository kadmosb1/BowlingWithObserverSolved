import java.util.Observable;
import java.util.Observer;

public class Lane extends Observable
{
	private int number;
	private boolean occupied;

	public Lane (int number, Observer observer)
	{
		this.number = number;
		this.occupied = false;
		addObserver (observer);
	}

	public int getNumber () {
		return this.number;
	}

	public boolean isOccupied () {
		return this.occupied;
	}

	public void setOccupied (boolean occupied) {
		this.occupied = occupied;
		setChanged ();
		notifyObservers ();
	}
}