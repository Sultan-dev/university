import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ProjectsPrint {

	private ArrayList<Projects> projectsArrayList = new ArrayList<Projects>();

	public ProjectsPrint() {

		try {
			String excelFilePath = ".\\DataFiles\\Projects.xls";
			FileInputStream input = new FileInputStream(excelFilePath);
			Workbook workbook = WorkbookFactory.create(input);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();

			for (int r = 1; r <= rows; r++) {

				Row row = sheet.getRow(r);
				Projects ProjectsObject = new Projects();

				for (int c = 0; c < cols; c++) {

					Cell cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					String stringCellValue = "";
					Date DateCellValue = new Date();
					double doubleCellValue = 0;

					switch (cell.getCellType()) {
					case STRING:
						stringCellValue = cell.getRichStringCellValue().getString();
						break;
					case NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							DateCellValue = cell.getDateCellValue();
						} else {
							doubleCellValue = cell.getNumericCellValue();
						}
						break;
					}

					if (!isCellEmpty(cell)) {
						switch (c) {
						case 0:
							ProjectsObject.setNodeID(stringCellValue);
							break;
						case 1:
							ProjectsObject.setCustomer_Project_ID(stringCellValue);
							break;
						case 2:
							ProjectsObject.setStage(doubleCellValue);
							break;
						case 3:
							ProjectsObject.setStart_Date(DateCellValue);
							break;
						case 4:
							ProjectsObject.setEnd_Date(DateCellValue);
							break;
						case 5:
							ProjectsObject.setCustomer(doubleCellValue);
							break;
						case 6:
							ProjectsObject.setCurrency(stringCellValue);
							break;
						case 7:
							ProjectsObject.setCreated_On(stringCellValue);
							break;
						case 8:
							ProjectsObject.setChanged_On(stringCellValue);
							break;
						}
					}
				}
				ProjectsObject.setObjectNumber(r);
				projectsArrayList.add(ProjectsObject);

			}
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean isCellEmpty(final Cell cell) {
		if (cell == null) {
			return true;
		}

		if (cell.getCellType() == CellType.BLANK) {
			return true;
		}

		if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().trim().isEmpty()) {
			return true;
		}

		return false;
	}

	public ArrayList<Projects> getProjectsArrayList() {
		return projectsArrayList;
	}

	public void setProjectsArrayList(ArrayList<Projects> projectsArrayList) {
		this.projectsArrayList = projectsArrayList;
	}

}
