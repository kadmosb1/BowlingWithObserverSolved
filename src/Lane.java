public class Lane
{
	private int number;
	private boolean occupied;

	public Lane(int number)
	{
		this.number = number;
		this.occupied = false;
	}

	public int getNumber()
	{
		return this.number;
	}

	public boolean isOccupied()
	{
		return this.occupied;
	}

	public void setOccupied(boolean occupied)
	{
		this.occupied = occupied;
	}
}