package kakeibo.entity;

public class ReceiptEntity {

	private String purchaceDate;

	private Integer purchaceSum;

	public ReceiptEntity() {
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
