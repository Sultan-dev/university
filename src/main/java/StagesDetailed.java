import java.util.Date;

public class StagesDetailed {
	private String Object_Value;
	private double Document_Number;
	private Date Date;
	private String Time;
	private String Language_Key;

	public StagesDetailed() {
	}

	public StagesDetailed(String object_Value, double document_Number, Date date, String time, String language_Key) {
		Object_Value = object_Value;
		Document_Number = document_Number;
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

	@Override
	public String toString() {
		return "Stages_Detailed [Object_Value=" + Object_Value + ", Document_Number=" + Document_Number + ", Date="
				+ Date + ", Time=" + Time + ", Language_Key=" + Language_Key + "]";
	}

}
