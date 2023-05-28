package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.GameDTO;
import com.example.demo.dto.GameMinDTO;
import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		 GameDTO dto = new GameDTO(result);
		 return dto;
	}
	@Transactional(readOnly = true)
	public List<GameMinDTO> finAll(){
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto= result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}

}
