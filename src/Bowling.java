import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

class EventHandlerNewStatus implements EventHandler<ActionEvent>
{
	private Bowling bowling;

	public EventHandlerNewStatus(Bowling bowling)
	{
		this.bowling = bowling;
	}

	@Override
	public void handle(ActionEvent actionEvent)
	{
		new Status(this.bowling);
	}
}

public class Bowling extends Application
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

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Pane rootPane = new Pane();
		rootPane.setMinSize(400, 200);
		Scene startScene = new Scene(rootPane);

		Button button = new Button("Open new status window");
		button.setOnAction(new EventHandlerNewStatus(this));
		rootPane.getChildren().add(button);

		primaryStage.setScene(startScene);
		primaryStage.setTitle("Bowling lanes");
		primaryStage.show();
	}
}