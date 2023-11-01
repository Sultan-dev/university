import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Controller implements Initializable {

	static mergingData mergingDataObject = new mergingData();

	@FXML
	private TableView<Projects> MyTableView;
	@FXML
	private TableColumn<Projects, String> ProjectID;
	@FXML
	private TableColumn<Projects, Double> stage;
	@FXML
	private TableColumn<Projects, Integer> Number;
	@FXML
	private Label MyLabel;
	@FXML
	private Canvas canvas;

	private String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		Number.setCellValueFactory(new PropertyValueFactory<>("ObjectNumber"));

		ProjectID.setCellValueFactory(new PropertyValueFactory<>("Customer_Project_ID"));

		stage.setCellValueFactory(new PropertyValueFactory<>("Stage"));

		MyTableView.setItems(getProjects());

		MyTableView.getSelectionModel().selectedItemProperty().addListener((var, oldValue, newValue) -> {

			Projects project = (Projects) newValue;
			MyLabel.setText(project.getCustomer_Project_ID());
			GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
			TimeLine(graphicsContext, project);

		});

	}

	public ObservableList<Projects> getProjects() {
		ObservableList<Projects> ProjectsObservableList = FXCollections.observableArrayList();

		for (int i = 0; i < mergingDataObject.getMergedProjectsArrayList().size(); i++) {
			ProjectsObservableList.add(mergingDataObject.getMergedProjectsArrayList().get(i));
		}
		return ProjectsObservableList;
	}

	private ArrayList<String> getMonthsList(ArrayList<Date> list) {
		ArrayList<String> temp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {

			Calendar calendar = new GregorianCalendar();
			calendar.setTime(list.get(i));
			String month = months[calendar.get(Calendar.MONTH)];
			int year = calendar.get(Calendar.YEAR);
			if (!temp.contains(month + " " + year)) {
				temp.add(month + " " + year);
			}
		}
		return temp;
	}

	private void TimeLine(GraphicsContext gc, Projects project) {
		int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
		gc.setFill(Color.WHITE);
		gc.fillRect(0, 0, 500, 300);
		gc.setFill(Color.GREEN);
		ArrayList<Date> dateArrayList = project.getDatesList();
		ArrayList<String> monthsList = getMonthsList(dateArrayList);
		ArrayList<MergedStagesData> stageArrayList = project.getMergedStagesData();

		int totalMonths = monthsList.size();
		int diff = 480 / totalMonths;
		gc.fillRect(10, 250, 480, 1);
		gc.fillRect(10, 245, 1, 10);
		gc.fillRect(490, 245, 1, 10);

		int x = 10;
		for (int i = 0; i < 100; i++) {
			if (x <= 490)
				gc.fillRect(x, 247, 1, 6);
			x += 5;
		}

		x = 10;
		for (int i = 0; i < totalMonths; i++) {
			gc.setStroke(Color.GREEN);
			gc.setFont(new Font("arial", 15));
			gc.strokeText(monthsList.get(i), x, 265);
			if (i != 0) {
				gc.setFill(Color.RED);
				gc.fillRect(x, 235, 1, 20);
			}
			for (int j = 0; j < stageArrayList.size(); j++) {
				MergedStagesData stage = stageArrayList.get(j);
				Date date = stage.getDate();
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				String mont1 = months[calendar.get(Calendar.MONTH)];
				int yer = calendar.get(Calendar.YEAR);
				int temp = 0;
				if (monthsList.get(i).equals(mont1 + " " + yer)) {
					temp = (diff / 30) * calendar.get(Calendar.DAY_OF_MONTH);
				}
				if (temp > 0) {
					gc.setStroke(Color.ORANGE);
					gc.setFont(new Font("arial", 5));
					gc.strokeText(calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + 1 + "/"
							+ calendar.get(Calendar.YEAR), x + temp, 260);
					gc.setFill(Color.ORANGE);
					gc.fillRect(x + temp, 250 - ((stage.getNew_value() * 9)), 1, (stage.getNew_value() * 9));

					gc.setStroke(Color.ORANGE);
					gc.setFont(new Font("arial", 5));
					gc.strokeText(calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + 1 + "/"
							+ calendar.get(Calendar.YEAR), x + temp, 260);
					gc.strokeText(stage.getNew_value() + "", x + temp + 4, 250 - ((stage.getNew_value() * 9)));

					Color color = Color.RED;
					gc.setFill(color);
					gc.fillRect(x + temp, 250 - ((stage.getNew_value() * 9)) - 3, 3, 3);

					if (minX == Integer.MAX_VALUE) {
						minX = x + temp;
					}
					if (maxX < x + temp)
						maxX = x + temp;
				}
			}
			x += diff;
		}
		gc.fillRect(minX, 100, maxX - minX, 2);
		Date startDate = null;
		Date endDate = null;
		if (dateArrayList.size() > 0) {
			startDate = dateArrayList.get(0);
			endDate = dateArrayList.get(dateArrayList.size() - 1);
		}
		long dur = endDate.getTime() - startDate.getTime();
		gc.setStroke(Color.GREEN);
		gc.setFont(new Font("arial", 14));
		gc.strokeText("Duration Days: " + dur / 1000 / 60 / 60 / 24, minX + ((maxX - minX) / 2) - 50, 90);

	}

}
