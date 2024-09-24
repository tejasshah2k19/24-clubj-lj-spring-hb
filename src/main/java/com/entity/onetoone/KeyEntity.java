package com.entity.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "keyz")
public class KeyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer keysId;
	private String digitCode;
	

	public Integer getKeysId() {
		return keysId;
	}

	public void setKeysId(Integer keysId) {
		this.keysId = keysId;
	}

	public String getDigitCode() {
		return digitCode;
	}

	public void setDigitCode(String digitCode) {
		this.digitCode = digitCode;
	}

}
