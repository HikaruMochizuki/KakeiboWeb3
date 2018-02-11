package kakeibo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class InputWindowForm {

	//購入日
	@NotEmpty
	@Pattern(regexp="(^\\d{4})/(0[0-9]|1[0-2])/(0[0-9]|[12][0-9]|3[01])$")
	private String purchaceDate;

	//購入金額
	@NotNull
	private Integer purchaceSum;

	public InputWindowForm() {
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
