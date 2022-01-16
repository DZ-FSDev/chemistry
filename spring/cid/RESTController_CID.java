/*  Original Licensing Copyright
 * 
 *  CID REST Service Controller.
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
package com.dz_fs_dev.chemistry.spring.cid;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * CID REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
@RestController("api/v1/CID")
public class RESTController_CID {
	@Autowired
	CIDService cidsvc;
	
	/**
	 * Returns the SMILES equivalent of the requested chemical identifier.
	 * 
	 * @param cid The requested chemical identifier to be converted.
	 * @return The SMILES equivalent of the chemical identifier.
	 * @throws NumberFormatException Thrown if an invalid chemical identifier has been provided.
	 * @throws MalformedURLException Thrown if PubChem was unable to be accessed.
	 * @throws IOException Thrown if PubChem was unable to be accessed.
	 * @throws Exception Thrown for any other failures. //TODO
	 * @since 0.0.1
	 */
	@GetMapping("/toSMILES")
	public String getSMILES(@PathVariable String cid) throws NumberFormatException, MalformedURLException, IOException, Exception {
		return cidsvc.toSMILES(Long.parseLong(cid));
	}

	/**
	 * Returns the InChI equivalent of the requested chemical identifier.
	 * 
	 * @param cid The requested chemical identifier to be converted.
	 * @return The InChI equivalent of the chemical identifier.
	 * @throws NumberFormatException Thrown if an invalid chemical identifier has been provided.
	 * @throws MalformedURLException Thrown if PubChem was unable to be accessed.
	 * @throws IOException Thrown if PubChem was unable to be accessed.
	 * @throws Exception Thrown for any other failures. //TODO
	 * @since 0.0.2
	 */
	@GetMapping("/toInChI")
	public String getInChI(@PathVariable String cid) throws NumberFormatException, MalformedURLException, IOException, Exception {
		return cidsvc.toInChI(Long.parseLong(cid));
	}
}
