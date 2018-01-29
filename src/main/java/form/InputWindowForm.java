package form;

import java.sql.Date;

public class InputWindowForm {

	private Date purchaceDate;

	private int purchaceSum;

	public InputWindowForm() {
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
