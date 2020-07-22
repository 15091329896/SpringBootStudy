package com.common.bean;

public class WeekDate {
	private Integer weekNO;
	private String startDate;
	private String endDate;

	public WeekDate() {
	}

	public Integer getWeekNO() {
		return weekNO;
	}

	public void setWeekNO(Integer weekNO) {
		this.weekNO = weekNO;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "WeekDate{" +
				"weekNO=" + weekNO +
				", startDate='" + startDate + '\'' +
				", endDate='" + endDate + '\'' +
				'}';
	}
}