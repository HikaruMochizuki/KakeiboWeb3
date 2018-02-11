package kakeibo.dto;

import java.util.Date;

public class RegisterDto {

	private Date purchaceDate;

	private Integer purchaceSum;

	public RegisterDto() {
	}

	public Date getPurchaceDate() {
		return purchaceDate;
	}


	public void setPurchaceDate(Date purchaceDate) {
		this.purchaceDate = purchaceDate;
	}


	public Integer getPurchaceSum() {
		return purchaceSum;
	}


	public void setPurchaceSum(Integer purchaceSum) {
		this.purchaceSum = purchaceSum;
	}


}
