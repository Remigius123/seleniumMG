package iosdemo;

import java.util.ArrayList;
import java.util.List;

public class TestResult {

	String name;
	String startTime;
	String endTime;
	String executionTime;
	List<String> authors =new ArrayList<>();
	List<String> categories=new ArrayList<>();
	List<String> browsers=new ArrayList<>();
	List<TestCases> testcases=new ArrayList<>();

	public void AddTestcases() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(String executionTime) {
		this.executionTime = executionTime;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<String> getBrowsers() {
		return browsers;
	}

	public void setBrowsers(List<String> browsers) {
		this.browsers = browsers;
	}

	public List<TestCases> getTestcases() {
		return testcases;
	}

	public void setTestcases(List<TestCases> testcases) {
		this.testcases = testcases;
	}


}
