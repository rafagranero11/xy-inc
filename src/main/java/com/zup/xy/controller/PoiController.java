package com.zup.xy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zup.xy.model.Poi;
import com.zup.xy.repository.PoiRepository;

@RestController
@RequestMapping("/poi")
public class PoiController {
	
	@Autowired
	private PoiRepository poiRepository;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(){
		return "ok - esta respondendo a chamada - Rafael";
	}
	
	@RequestMapping(value = "/listPoi", method = RequestMethod.GET)
	public ResponseEntity<List<Poi>> listAll(){
		List<Poi> list = new ArrayList<Poi>();
		try{
			
			list = poiRepository.findAll();
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Poi>>(new ArrayList<Poi>(list), HttpStatus.OK);
	  
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestParam(value = "nomePoi", required = true) String nomePoi,
			@RequestParam(value = "coordenadaX") Integer coordenadaX,
			@RequestParam(value = "coordenadaY") Integer coordenadaY){
		
		try{
			Poi p = new Poi();
			
			if(nomePoi.equals("") || nomePoi.isEmpty() || nomePoi == null){
				return new ResponseEntity<String>("NOME POI NULO OU VAZIO", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(coordenadaX == null){
				return new ResponseEntity<String>("COORDENADA X NULO OU VAZIO", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(coordenadaY == null){
				return new ResponseEntity<String>("COORDENADA Y NULO OU VAZIO", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(coordenadaX < 0){
				return new ResponseEntity<String>("COORDENADA X MENOR QUE 0", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(coordenadaY < 0){
				return new ResponseEntity<String>("COORDENADA Y MENOR QUE 0", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			p.setNomePoi(nomePoi);
			p.setCoordenadaX(coordenadaX);
			p.setCoordenadaY(coordenadaY);
			poiRepository.save(p);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("FALHA AO GRAVAR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<String>("REGISTRO SALVO COM SUCESSO", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByCoordinates", method = RequestMethod.GET)
	public ResponseEntity<List<Poi>> findByCoordinates(@RequestParam(value = "coordenadaX") Integer coordenadaX,
			@RequestParam(value = "coordenadaY") Integer coordenadaY,
			@RequestParam(value = "metros") Double metros){
		
		List<Poi> list = new ArrayList<Poi>();
		try{
			
			
			if(coordenadaX == null){
				return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(coordenadaY == null){
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(metros == null){
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(coordenadaX < 0){
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			if(coordenadaY < 0){
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			list = poiRepository.localizarPorCorrdenadas(coordenadaX, coordenadaY, metros);
			
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<List<Poi>>(new ArrayList<Poi>(list), HttpStatus.OK);
	  
	}

}