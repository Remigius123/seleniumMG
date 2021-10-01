package iosdemo;

public class TestCases {
	Integer status;
	String timestamp;
	String screenshort;
	String details;


	public TestCases(Integer status, String timestamp, String details,String screenshort) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.details = details;
		this.screenshort = screenshort;
	}

	public TestCases(Integer status, String timestamp, String details) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.details = details;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getScreenshort() {
		return screenshort;
	}
	public void setScreenshort(String screenshort) {
		this.screenshort = screenshort;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}


}
