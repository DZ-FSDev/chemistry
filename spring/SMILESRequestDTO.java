package com.dz_fs_dev.chemistry.spring;

/**
 * SMILES Request DTO. May also contain SMARTS or SMIRKS.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
public class SMILESRequestDTO {
	private String smilesString;

	public SMILESRequestDTO() {}
	
	/**
	 * Constructs a SMILES/SMARTS/SMIRKS DTO.
	 * 
	 * @param smilesString The wrapped SMILES/SMARTS/SMIRKS.
	 */
	public SMILESRequestDTO(String smilesString) {
		this.setSmilesString(smilesString);
	}

	/**
	 * Returns the smilesString.
	 * 
	 * @return The smilesString
	 */
	public String getSmilesString() {
		return smilesString;
	}

	/**
	 * Sets the SMILES/SMARTS/SMIRKS.
	 * 
	 * @param smiString The SMILES/SMARTS/SMIRKS to set.
	 */
	public void setSmilesString(String smilesString) {
		this.smilesString = smilesString;
	}

	/**
	 * Returns the JSON representation of the SMILESRequestDTO.
	 * 
	 * @return The JSON representation of the SMILESRequestDTO.
	 */
	@Override
	public String toString() {
		return "SMILESRequestDTO {\"smilesString\"=\"" + smilesString + "\"]";
	}
}
