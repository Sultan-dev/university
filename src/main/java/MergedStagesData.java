import java.util.Date;

public class MergedStagesData {

	private String Object_Value;
	private double Document_Number;
	private String Field_Name;
	private String Change_Indicator;
	private double Text_flag;
	private double New_value;
	private double Old_value;

	private Date Date;
	private String Time;
	private String Language_Key;

	public MergedStagesData() {
	}

	public MergedStagesData(String object_Value, double document_Number, String field_Name, String change_Indicator,
			double text_flag, double new_value, double old_value, java.util.Date date, String time,
			String language_Key) {
		Object_Value = object_Value;
		Document_Number = document_Number;
		Field_Name = field_Name;
		Change_Indicator = change_Indicator;
		Text_flag = text_flag;
		New_value = new_value;
		Old_value = old_value;
		Date = date;
		Time = time;
		Language_Key = language_Key;
	}

	public String getObject_Value() {
		return Object_Value;
	}

	public void setObject_Value(String object_Value) {
		Object_Value = object_Value;
	}

	public double getDocument_Number() {
		return Document_Number;
	}

	public void setDocument_Number(double document_Number) {
		Document_Number = document_Number;
	}

	public String getField_Name() {
		return Field_Name;
	}

	public void setField_Name(String field_Name) {
		Field_Name = field_Name;
	}

	public String getChange_Indicator() {
		return Change_Indicator;
	}

	public void setChange_Indicator(String change_Indicator) {
		Change_Indicator = change_Indicator;
	}

	public double getText_flag() {
		return Text_flag;
	}

	public void setText_flag(double text_flag) {
		Text_flag = text_flag;
	}

	public double getNew_value() {
		return New_value;
	}

	public void setNew_value(double new_value) {
		New_value = new_value;
	}

	public double getOld_value() {
		return Old_value;
	}

	public void setOld_value(double old_value) {
		Old_value = old_value;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
	}

	public String getLanguage_Key() {
		return Language_Key;
	}

	public void setLanguage_Key(String language_Key) {
		Language_Key = language_Key;
	}

}