package com.dz_fs_dev.chemistry.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * SMILES Web Service Controller.
 * 
 * @author DZ_FSDev
 * @since 17.0.1
 * @version 0.0.4
 */
@Controller
public class WebController {
	final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
	
	/**
	 * Renders the simple SMILES Request page view.
	 * 
	 * @param model
	 * @return
	 * @since 0.0.1
	 */
	@GetMapping("/smiReq")
	public String greetingForm(Model model) {
		model.addAttribute("smiReq", new SMILESRequestDTO());
		return "SMILES/SMILESRequestForm";
	}
	
	/**
	 * Renders the simple SMILES Results page view.
	 * 
	 * @param smiReq
	 * @param model
	 * @return
	 * @since 0.0.4
	 */
	@PostMapping("/smiReq")
	public String greetingSubmit(@ModelAttribute SMILESRequestDTO smiReq, Model model) {
		model.addAttribute("serverTime", dateFormatter.format(new Date(System.currentTimeMillis())));
		model.addAttribute("smilessrc", "/v1/SMILES/generate/" + smiReq.getSmilesString());
		model.addAttribute("smiles", smiReq.getSmilesString());
		return "SMILES/SMILESResults";
	}
}
