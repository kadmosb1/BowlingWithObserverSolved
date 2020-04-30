import java.util.ArrayList;
import java.util.List;

public class Bowling
{
	public final List<Lane> lanes;

	public Bowling()
	{
		this.lanes = new ArrayList<>();
		this.lanes.add(new Lane(1));
		this.lanes.add(new Lane(2));
		this.lanes.add(new Lane(3));
		this.lanes.add(new Lane(4));
	}
}