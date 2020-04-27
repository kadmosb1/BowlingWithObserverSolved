import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

class EventHandlerToggle implements EventHandler<ActionEvent>
{
	private Lane lane;
	private Status status;

	public EventHandlerToggle(Lane lane, Status status)
	{
		this.lane = lane;
		this.status = status;
	}

	@Override
	public void handle(ActionEvent actionEvent)
	{
		this.lane.setOccupied(!this.lane.isOccupied());
		this.status.draw();
	}
}

class EventHandlerClose implements EventHandler<WindowEvent>
{
	private Bowling bowling;
	private Status status;

	public EventHandlerClose(Bowling bowling, Status status)
	{
		this.bowling = bowling;
		this.status = status;
	}

	@Override
	public void handle(WindowEvent windowEvent)
	{
	}
}

public class Status extends Stage
{
	private Bowling bowling;
	private Pane rootPane;

	public Status(Bowling bowling)
	{
		this.bowling = bowling;
		this.rootPane = new Pane();
		setTitle("Status");
		this.rootPane.setMinSize(200, 200);
		draw();
		Scene scene = new Scene(rootPane);
		setScene(scene);
		setOnCloseRequest(new EventHandlerClose(bowling, this));
		show();
	}

	public void draw()
	{
		this.rootPane.getChildren().clear();
		VBox vBox = new VBox();
		this.rootPane.getChildren().add(vBox);
		for (Lane lane : bowling.lanes)
		{
			HBox hBox = new HBox();
			vBox.getChildren().add(hBox);
			hBox.getChildren().add(new Label("Lane " + lane.getNumber() + "\t"));
			hBox.getChildren().add(new Label(lane.isOccupied() ? "occupied\t" : "free\t"));
			Button button = new Button("Toggle");
			button.setOnAction(new EventHandlerToggle(lane, this));
			hBox.getChildren().add(button);
		}
	}
}