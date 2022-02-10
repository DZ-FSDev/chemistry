/*  Original Licensing Copyright
 * 
 *  SMILES REST Service Controller.
 *  Copyright (C) 2021  DZ-FSDev
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.dz_fs_dev.chemistry.spring.smiles;

import org.openscience.cdk.exception.CDKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

/**
 * SMILES REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.8
 */
@RestController
@RequestMapping("api/v1/SMILES")
public class RESTController_SMILES {
	@Autowired
	SMILESservice smiSvc;

	/**
	 * Returns a generated PNG byte array representation of the requested SMILES.
	 * 
	 * @param smiles The requested SMILES for depiction.
	 * @param caption A user-defined caption to be affixed to the depiction.
	 * @param numbered Whether the atoms should be numbered.
	 * @return The generated PNG byte array representation of the requested SMILES.
	 * @throws CDKException Thrown if the depiction failed.
	 * @throws IOException Thrown if the byte array was unable to be written.
	 * @since 0.0.6
	 */
	@GetMapping(value = "/generate/{smiles}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getSMILESAsPNG(@PathVariable("smiles") String smiles, Optional<String> caption, Optional<Boolean> numbered) throws CDKException, IOException {
		return smiSvc.getSMILEStoPNGbytes(smiles, caption, numbered);
	}

	/**
	 * Returns a generated animated GIF byte array representation of the requested SMILES.
	 * 
	 * @param smiles
	 * @param caption
	 * @return The generated PNG byte array representation of the requested SMILES.
	 * @throws CDKException
	 * @throws IOException
	 * @since 0.0.5
	 */
	@GetMapping(value = "/generate/ani/{smiles}", produces = MediaType.IMAGE_GIF_VALUE)
	public byte[] getSMILESAsGIF(@PathVariable("smiles")String smiles, Optional<String> caption) throws CDKException, IOException {
		return smiSvc.getSMILEStoGIFbytes(smiles, caption);
	}
	
	/**
	 * Returns an InChI string given a SMILES string; or null if unable to do so. 
	 * 
	 * @param smiles The specified SMILES string to be converted.
	 * @return An InChI string given a SMILES string; or null if unable to do so.
	 * @since 0.0.8
	 */
	@GetMapping("/toInChI/{smiles}")
	public String getInChI(@PathVariable("smiles")String smiles) {
		return smiSvc.getInChIfromSMILES(smiles);
	}
}
