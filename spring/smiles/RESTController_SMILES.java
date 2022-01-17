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
package com.dz_fs_dev.chemistry.spring;

import org.openscience.cdk.exception.CDKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

/**
 * SMILES REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.6
 */
@RestController
@RequestMapping("/v1/SMILES")
public class RESTController_SMILES {
	@Autowired
	SMILESservice smiSvc;

	/**
	 * Returns a generated PNG byte array representation of the requested SMILES.
	 * 
	 * @param smiles
	 * @param caption
	 * @param numbered
	 * @return The generated PNG byte array representation of the requested SMILES.
	 * @throws CDKException
	 * @throws IOException
	 * @since 0.0.6
	 */
	@GetMapping(value = "/generate/{smiles}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getSMILESAsPNG(String smiles, Optional<String> caption, Optional<Boolean> numbered) throws CDKException, IOException {
		return smiSvc.getSMILEStoPNGbytes(smiles, caption, numbered);
	}
}