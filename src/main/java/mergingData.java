import java.util.ArrayList;

public class mergingData {

	private ArrayList<Projects> mergedProjectsArrayList = new ArrayList<Projects>();

	public mergingData() {

		ProjectsPrint projects = new ProjectsPrint();
		StagesPrint stages = new StagesPrint();
		StagesDetailedPrint StagesDetailed = new StagesDetailedPrint();
		ArrayList<MergedStagesData> mergedStagesDataArrayList = new ArrayList<MergedStagesData>();

		for (int i = 0; i < stages.getStagessArrayList().size(); i++) {
			MergedStagesData mergedStagesData = new MergedStagesData();
			mergedStagesData.setObject_Value(stages.getStagessArrayList().get(i).getObject_Value());
			mergedStagesData.setDocument_Number(stages.getStagessArrayList().get(i).getDocument_Number());
			mergedStagesData.setField_Name(stages.getStagessArrayList().get(i).getField_Name());
			mergedStagesData.setChange_Indicator(stages.getStagessArrayList().get(i).getChange_Indicator());
			mergedStagesData.setText_flag(stages.getStagessArrayList().get(i).getText_flag());
			mergedStagesData.setNew_value(stages.getStagessArrayList().get(i).getNew_value());
			mergedStagesData.setOld_value(stages.getStagessArrayList().get(i).getOld_value());

			mergedStagesData.setDate(StagesDetailed.getStagesDetailedArrayList().get(i).getDate());
			mergedStagesData.setTime(StagesDetailed.getStagesDetailedArrayList().get(i).getTime());
			mergedStagesData.setLanguage_Key(StagesDetailed.getStagesDetailedArrayList().get(i).getLanguage_Key());

			mergedStagesDataArrayList.add(mergedStagesData);
		}

		for (int i = 0; i < projects.getProjectsArrayList().size(); i++) {
			Projects mergedProjects = new Projects();
			mergedProjects.setObjectNumber(projects.getProjectsArrayList().get(i).getObjectNumber());
			mergedProjects.setNodeID(projects.getProjectsArrayList().get(i).getNodeID());
			mergedProjects.setCustomer_Project_ID(projects.getProjectsArrayList().get(i).getCustomer_Project_ID());
			mergedProjects.setStage(projects.getProjectsArrayList().get(i).getStage());
			mergedProjects.setStart_Date(projects.getProjectsArrayList().get(i).getStart_Date());
			mergedProjects.setEnd_Date(projects.getProjectsArrayList().get(i).getEnd_Date());
			mergedProjects.setCustomer(projects.getProjectsArrayList().get(i).getCustomer());
			mergedProjects.setCurrency(projects.getProjectsArrayList().get(i).getCurrency());
			mergedProjects.setCreated_On(projects.getProjectsArrayList().get(i).getCreated_On());
			mergedProjects.setChanged_On(projects.getProjectsArrayList().get(i).getChanged_On());

			mergedProjectsArrayList.add(mergedProjects);
		}

		for (int i = 0; i < mergedProjectsArrayList.size(); i++) {

			ArrayList<MergedStagesData> subMergedStagesDataArrayList = new ArrayList<MergedStagesData>();

			for (int j = 0; j < mergedStagesDataArrayList.size(); j++) {
				if (mergedProjectsArrayList.get(i).getNodeID()
						.equals(mergedStagesDataArrayList.get(j).getObject_Value())) {
					subMergedStagesDataArrayList.add(mergedStagesDataArrayList.get(j));
				}
			}

			mergedProjectsArrayList.get(i).setMergedStagesData(subMergedStagesDataArrayList);
		}

	}

	public ArrayList<Projects> getMergedProjectsArrayList() {
		return mergedProjectsArrayList;
	}

	public void setMergedProjectsArrayList(ArrayList<Projects> mergedProjectsArrayList) {
		this.mergedProjectsArrayList = mergedProjectsArrayList;
	}

}
