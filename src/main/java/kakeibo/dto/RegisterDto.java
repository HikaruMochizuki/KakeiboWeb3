package kakeibo.dto;

import java.util.Date;

public class RegisterDto {

	private Date purchaceDate;

	private int purchaceSum;

	public RegisterDto() {
	}

	public Date getPurchaceDate() {
		return purchaceDate;
	}


	public void setPurchaceDate(Date purchaceDate) {
		this.purchaceDate = purchaceDate;
	}


	public int getPurchaceSum() {
		return purchaceSum;
	}


	public void setPurchaceSum(int purchaceSum) {
		this.purchaceSum = purchaceSum;
	}


}
