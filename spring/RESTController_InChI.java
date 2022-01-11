/*  Original Licensing Copyright
 * 
 *  InChI REST Service Controller.
 *  Copyright (C) 2022  DZ-FSDev
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

/**
 * InChI REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.3
 */
@RestController
@RequestMapping("/api/v1/InChI")
public class RESTController_InChI {
	@Autowired
	InChIservice inchiSvc;

	/**
	 * Returns a generated PNG byte array representation of the requested InChI.
	 * 
	 * @param inchi
	 * @param caption
	 * @return The generated PNG byte array representation of the requested InChI.
	 * @throws CDKException
	 * @throws IOException
	 * @since 0.0.1
	 */
	@GetMapping(value = "/{InChI}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getInChIAsPNG(@PathVariable("InChI") String inchi, Optional<String> caption)
			throws CDKException, IOException {
		return inchiSvc.getInChItoPNGbytes(inchi, caption);
	}
}
