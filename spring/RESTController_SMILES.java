package com.dz_fs_dev.chemistry.spring;

import org.openscience.cdk.exception.CDKException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dz_fs_dev.common.Graphics2DTools;

import java.io.IOException;
import java.util.Optional;

/**
 * UPC REST Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.2
 */
@RestController
@RequestMapping("/SMILES")
public class RESTController_SMILES {
	@Autowired
	SMILESservice smiSvc;
	
	/**
	 * Returns a generated PNG byte array representation of the requested SMILES.
	 * 
	 * @param barcode
	 * @param caption
	 * @throws IOException
	 * @throws WriterException
	 * @return The generated PNG byte array representation of the requested EAN13 barcode.
	 * @throws CDKException 
	 * @since 0.0.2
	 */
	@GetMapping(value = "/{smiles}", produces = MediaType.IMAGE_PNG_VALUE)
	public byte[] getEAN13Barcode(@PathVariable("smiles") String smiles, Optional<String> caption) throws CDKException, IOException {
		return smiSvc.getSMILEStoPNGbytes(smiles, caption);
	}
}
