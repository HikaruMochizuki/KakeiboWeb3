package kakeibo.dto;

public class ReceiptDto {

	private String purchaceDate;

	private Integer purchaceSum;

	public ReceiptDto() {
	}

	public String getPurchaceDate() {
		return purchaceDate;
	}

	public void setPurchaceDate(String purchaceDate) {
		this.purchaceDate = purchaceDate;
	}

	public Integer getPurchaceSum() {
		return purchaceSum;
	}

	public void setPurchaceSum(Integer purchaceSum) {
		this.purchaceSum = purchaceSum;
	}


}
