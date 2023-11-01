import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StagesPrint {

	private ArrayList<Stages> stagessArrayList = new ArrayList<Stages>();

	public StagesPrint() {

		try {
			String excelFilePath = ".\\DataFiles\\Stages.xls";
			FileInputStream input = new FileInputStream(excelFilePath);
			Workbook workbook = WorkbookFactory.create(input);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();

			for (int r = 1; r <= rows; r++) {

				Row row = sheet.getRow(r);
				Stages StagesObject = new Stages();

				for (int c = 0; c <= cols; c++) {

					Cell cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
					String stringCellValue = "";
					double doubleCellValue = 0;

					switch (cell.getCellType()) {
					case STRING:
						stringCellValue = cell.getRichStringCellValue().getString();
						break;
					case NUMERIC:
						doubleCellValue = cell.getNumericCellValue();
						break;
					}

					if (!isCellEmpty(cell)) {
						switch (c) {
						case 0:
							StagesObject.setObject_Value(stringCellValue);
							break;
						case 1:
							StagesObject.setDocument_Number(doubleCellValue);
							break;
						case 2:
							StagesObject.setField_Name(stringCellValue);
							break;
						case 3:
							StagesObject.setChange_Indicator(stringCellValue);
							break;
						case 4:
							StagesObject.setText_flag(doubleCellValue);
							break;
						case 5:
							StagesObject.setNew_value(doubleCellValue);
							break;
						case 6:
							StagesObject.setOld_value(doubleCellValue);
							break;
						}
					}

				}
				stagessArrayList.add(StagesObject);
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

	public ArrayList<Stages> getStagessArrayList() {
		return stagessArrayList;
	}

	public void setStagessArrayList(ArrayList<Stages> stagessArrayList) {
		this.stagessArrayList = stagessArrayList;
	}

}
