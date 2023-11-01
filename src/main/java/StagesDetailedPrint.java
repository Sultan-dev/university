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

public class StagesDetailedPrint {

	private ArrayList<StagesDetailed> stagesDetailedArrayList = new ArrayList<StagesDetailed>();

	public StagesDetailedPrint() {

		try {
			String excelFilePath = ".\\DataFiles\\Stages_Detailed.xls";
			FileInputStream input = new FileInputStream(excelFilePath);
			Workbook workbook = WorkbookFactory.create(input);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();

			for (int r = 1; r <= rows; r++) {

				Row row = sheet.getRow(r);
				StagesDetailed StagesDetailedObject = new StagesDetailed();

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
							StagesDetailedObject.setObject_Value(stringCellValue);
							break;
						case 1:
							StagesDetailedObject.setDocument_Number(doubleCellValue);
							break;
						case 2:
							StagesDetailedObject.setDate(DateCellValue);
							break;
						case 3:
							StagesDetailedObject.setTime(stringCellValue);
							break;
						case 4:
							StagesDetailedObject.setLanguage_Key(stringCellValue);
							break;
						}
					}
				}
				stagesDetailedArrayList.add(StagesDetailedObject);
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

	public ArrayList<StagesDetailed> getStagesDetailedArrayList() {
		return stagesDetailedArrayList;
	}

	public void setStagesDetailedArrayList(ArrayList<StagesDetailed> stagesDetailedArrayList) {
		this.stagesDetailedArrayList = stagesDetailedArrayList;
	}

}
