import java.util.ArrayList;
import java.util.Date;

import java.util.stream.Collectors;

public class Projects {
	private int ObjectNumber;
	private String NodeID;
	private String Customer_Project_ID;
	private double Stage;
	private Date Start_Date;
	private Date End_Date;
	private double Customer;
	private String Currency;
	private String Created_On;
	private String Changed_On;

	private ArrayList<MergedStagesData> mergedStagesData = new ArrayList<MergedStagesData>();
	private ArrayList<Date> datesList = new ArrayList<Date>();

	public Projects() {
	}

	public Projects(String nodeID, String customer_Project_ID, double stage, Date start_Date, Date end_Date,
			double customer, String currency, String created_On, String changed_On) {
		NodeID = nodeID;
		Customer_Project_ID = customer_Project_ID;
		Stage = stage;
		Start_Date = start_Date;
		End_Date = end_Date;
		Customer = customer;
		Currency = currency;
		Created_On = created_On;
		Changed_On = changed_On;
	}

	public String getNodeID() {
		return NodeID;
	}

	public void setNodeID(String nodeID) {
		NodeID = nodeID;
	}

	public String getCustomer_Project_ID() {
		return Customer_Project_ID;
	}

	public void setCustomer_Project_ID(String customer_Project_ID) {
		Customer_Project_ID = customer_Project_ID;
	}

	public double getStage() {
		return Stage;
	}

	public void setStage(double stage) {
		Stage = stage;
	}

	public Date getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}

	public Date getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}

	public double getCustomer() {
		return Customer;
	}

	public void setCustomer(double customer) {
		Customer = customer;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getCreated_On() {
		return Created_On;
	}

	public void setCreated_On(String created_On) {
		Created_On = created_On;
	}

	public String getChanged_On() {
		return Changed_On;
	}

	public void setChanged_On(String changed_On) {
		Changed_On = changed_On;
	}

	@Override
	public String toString() {
		return "Projects [NodeID=" + NodeID + ", Customer_Project_ID=" + Customer_Project_ID + ", Stage=" + Stage
				+ ", Start_Date=" + Start_Date + ", End_Date=" + End_Date + ", Customer=" + Customer + ", Currency="
				+ Currency + ", Created_On=" + Created_On + ", Changed_On=" + Changed_On + "]";
	}

	public int getObjectNumber() {
		return ObjectNumber;
	}

	public void setObjectNumber(int objectNumber) {
		ObjectNumber = objectNumber;
	}

	public ArrayList<MergedStagesData> getMergedStagesData() {
		return mergedStagesData;
	}

	public void setMergedStagesData(ArrayList<MergedStagesData> mergedStagesData) {
		this.mergedStagesData = mergedStagesData;
	}

	public void setDatesList(ArrayList<Date> datesList) {
		this.datesList = datesList;
	}

	public ArrayList<Date> getDatesList() {

		ArrayList<MergedStagesData> stageArrayList = getMergedStagesData();
		for (int i = 0; i < stageArrayList.size(); i++) {
			Date date = stageArrayList.get(i).getDate();

			datesList.add(date);

		}
		datesList.sort((o1, o2) -> o1.compareTo(o2));
		return (ArrayList<Date>) datesList.stream().distinct().collect(Collectors.toList());

	}

}
