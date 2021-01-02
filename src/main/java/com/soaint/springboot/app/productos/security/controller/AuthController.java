package com.soaint.springboot.app.productos.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soaint.springboot.app.productos.bean.ResponseBean;
import com.soaint.springboot.app.productos.security.dto.JwtDto;
import com.soaint.springboot.app.productos.security.dto.LoginUsuario;
import com.soaint.springboot.app.productos.security.jwt.JwtProvider;
import com.soaint.springboot.app.productos.security.service.RolService;
import com.soaint.springboot.app.productos.security.service.UsuarioService;
import com.soaint.springboot.app.productos.util.Constantes;
import com.soaint.springboot.app.productos.util.Utilitario;

@RestController
@RequestMapping(Constantes.AUTH)
@CrossOrigin
public class AuthController {
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	RolService rolService;
	
	@Autowired
	JwtProvider jwtProvider;
	
	@PostMapping(Constantes.LOGIN)
	public ResponseEntity<ResponseBean> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		ResponseBean responseBean = new ResponseBean();
		if (bindingResult.hasErrors()) {
			responseBean.setHttpStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			responseBean.setMessage(Constantes.CAMPOS_MAL_PUESTOS);
			responseBean.setCode(Constantes.LOGIN_ERROR_CODE);
			responseBean.setResponse(null);
			responseBean.setBackendMessage(null);
			return new ResponseEntity(responseBean, HttpStatus.BAD_REQUEST);
		} else if(!Utilitario.verificarBodyCredentials(loginUsuario)) {
			throw new BadCredentialsException(Constantes.CAMPOS_MAL_PUESTOS);
		}
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		responseBean.setHttpStatus(String.valueOf(HttpStatus.OK.value()));
		responseBean.setMessage(Constantes.LOGIN_SUCCESS_MESSAGE);
		responseBean.setCode(Constantes.SUCCESS_CODE);
		responseBean.setResponse(jwtDto);
		LOG.debug(Utilitario.getJsonPrint(responseBean));
		return new ResponseEntity(responseBean, HttpStatus.OK);
	}
}
