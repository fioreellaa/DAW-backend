package com.boutique.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boutique.model.Usuario;
import com.boutique.repository.IUsuario;

@Service
public class UsuarioService {
	
	 private final IUsuario urepository;

	    @Autowired
	    public UsuarioService(IUsuario usuarioRepository) {
	        this.urepository = usuarioRepository;
	    }

	    public Usuario registrarUsuario(Usuario usuario) { 	
	    	usuario.setTipoUsuario("USER");
	        Usuario usuarioGuardado = urepository.save(usuario);
	        return usuarioGuardado;
	        
	    }

	    public Usuario autenticarUsuario(String correoUsuario, String contrasenaUsuario) {
	        Usuario usuario = urepository.findByCorreoUsuario(correoUsuario);

	        if (usuario != null && usuario.getContrasenaUsuario().equals(contrasenaUsuario)) {
	            return usuario;
	        }
	        
	        return null;
	    }
	    
	    
	    /*******************************************/
	    
	    public List<Usuario> listarUsuarios() {
	        return urepository.findAll();
	    }

	    public void eliminarUsuario(int idUsuario) {
	    	urepository.deleteById(idUsuario);
	    }

	    public Usuario obtenerUsuarioPorId(int idUsuario) {
	        return urepository.findById(idUsuario).orElse(null);
	    }

	    public Usuario actualizarUsuario(Usuario usuario) {
	        return urepository.save(usuario);
	    }
	    
}
