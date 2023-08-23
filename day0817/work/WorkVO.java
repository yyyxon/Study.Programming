package day0817.work;

public class WorkVO {
	
	private String columnName;
	private String dataType;
	private int dataSize;
	private String isNull;
	private String isDefault;
	
	public WorkVO(String columnName, String dataType, int dataSize, String isNull, String isDefault) {
		super();
		this.columnName = columnName;
		this.dataType = dataType;
		this.dataSize = dataSize;
		this.isNull = isNull;
		this.isDefault = isDefault;
	}
	
	public WorkVO() {
		super();
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public String getDataType() {
		return dataType;
	}
	
	public int getDataSize() {
		return dataSize;
	}
	
	public String getIsNull() {
		return isNull;
	}
	
	public String getIsDefault() {
		return isDefault;
	}

	@Override
	public String toString() {
		return "WorkVO [columnName=" + columnName + ", dataType=" + dataType + ", dataSize=" + dataSize + ", isNull="
				+ isNull + ", isDefault=" + isDefault + "]";
	}
}
