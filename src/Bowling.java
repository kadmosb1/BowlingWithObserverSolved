import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Bowling extends Observable implements Observer {

	public final List<Lane> lanes;

	public Bowling() {
		this.lanes = new ArrayList<> ();
		this.lanes.add (new Lane (1, this));
		this.lanes.add (new Lane (2, this));
		this.lanes.add (new Lane (3, this));
		this.lanes.add (new Lane (4, this));
	}

	@Override
	public void update (Observable o, Object arg) {
		setChanged ();
		notifyObservers ();
	}
}