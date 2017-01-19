package querydsl.domains;

import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Phone {

	@Column(name = "phone_number", nullable = false)
	private String phoneNumber;

	protected Phone() {
		// to frameworks
	}

	private Phone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Phone of (String phoneNumber) {
		return new Phone(phoneNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()){
			return false;
		}
		Phone phone1 = (Phone) o;
		return Objects.equal(phoneNumber, phone1.phoneNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(phoneNumber);
	}
}
