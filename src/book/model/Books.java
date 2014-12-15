package book.model;

/**
 * @author nguyenphuc
 */
public class Books {

	private int id;
	private String name;
	private String category;
	private String publisher;
	private String price;
	private String summary;

	// for validation error messages

	private String userNameError;
	private String dateOfBirthError;
	private String emailError;
	private String phoneNoError;
	private boolean isValid;

	// this is for action means edit or submit or delete or update
	private String action;

	// construtor.it is invoked when we run jsp page.
	// so first time no values will display in jsp page
	public Books() {
		setId(0);
		setName("");
		setCategory("");
		setPublisher("");
		setPrice("");
		setSummary("");

		userNameError = "";
		dateOfBirthError = "";
		emailError = "";
		phoneNoError = "";

		action = "submit";
	}

	// public String getDateOfBirth() {
	// return dateOfBirth;
	// }
	//
	// public void setDateOfBirth(String dateOfBirth) {
	// this.dateOfBirth = dateOfBirth;
	// }
	//
	// public String getEmail() {
	// return email;
	// }
	//
	// public void setEmail(String email) {
	// this.email = email;
	// }
	//
	// public String getPhoneNo() {
	// return phoneNo;
	// }
	//
	// public void setPhoneNo(String phoneNo) {
	// this.phoneNo = phoneNo;
	// }
	//
	// public String getUserName() {
	// return userName;
	// }
	//
	// public void setUserName(String userName) {
	// this.userName = userName;
	// }

	// setter and getter methods for errors

	public String getUserNameError() {
		return userNameError;
	}

	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}

	public String getDateOfBirthError() {
		return dateOfBirthError;
	}

	public void setDateOfBirthError(String dateOfBirthError) {
		this.dateOfBirthError = dateOfBirthError;
	}

	public String getEmailError() {
		return emailError;
	}

	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}

	public String getPhoneNoError() {
		return phoneNoError;
	}

	public void setPhoneNoError(String phoneNoError) {
		this.phoneNoError = phoneNoError;
	}

	public boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime
				* result
				+ ((dateOfBirthError == null) ? 0 : dateOfBirthError.hashCode());
		result = prime * result
				+ ((emailError == null) ? 0 : emailError.hashCode());
		result = prime * result + id;
		result = prime * result + (isValid ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((phoneNoError == null) ? 0 : phoneNoError.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((summary == null) ? 0 : summary.hashCode());
		result = prime * result
				+ ((userNameError == null) ? 0 : userNameError.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateOfBirthError == null) {
			if (other.dateOfBirthError != null)
				return false;
		} else if (!dateOfBirthError.equals(other.dateOfBirthError))
			return false;
		if (emailError == null) {
			if (other.emailError != null)
				return false;
		} else if (!emailError.equals(other.emailError))
			return false;
		if (id != other.id)
			return false;
		if (isValid != other.isValid)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNoError == null) {
			if (other.phoneNoError != null)
				return false;
		} else if (!phoneNoError.equals(other.phoneNoError))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (summary == null) {
			if (other.summary != null)
				return false;
		} else if (!summary.equals(other.summary))
			return false;
		if (userNameError == null) {
			if (other.userNameError != null)
				return false;
		} else if (!userNameError.equals(other.userNameError))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", category=" + category
				+ ", publisher=" + publisher + ", price=" + price
				+ ", summary=" + summary + ", userNameError=" + userNameError
				+ ", dateOfBirthError=" + dateOfBirthError + ", emailError="
				+ emailError + ", phoneNoError=" + phoneNoError + ", isValid="
				+ isValid + ", action=" + action + "]";
	}

}
