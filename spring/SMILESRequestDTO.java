package com.dz_fs_dev.chemistry.spring;

/**
 * SMILES Request DTO.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.1
 */
public class SMILESRequestDTO {
	private long id;
	private String smilesString;
		
	/**
	 * 
	 */
	public SMILESRequestDTO() {
	}

	/**
	 * @param smilesString
	 */
	public SMILESRequestDTO(String smilesString) {
		this.setSmilesString(smilesString);
	}

	/**
	 * @param id
	 * @param smilesString
	 */
	public SMILESRequestDTO(long id, String smilesString) {
		this.id = id;
		this.smilesString = smilesString;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * Sets the smilesString.
	 * 
	 * @param smiString the smilesString to set
	 */
	public void setSmilesString(String smilesString) {
		this.smilesString = smilesString;
	}

	@Override
	public String toString() {
		return "SMILESRequestDTO [id=" + id + ", smilesString=" + smilesString + "]";
	}
}
