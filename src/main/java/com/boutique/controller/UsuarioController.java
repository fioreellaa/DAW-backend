package com.boutique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boutique.model.Usuario;
import com.boutique.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/autenticar")
    public Usuario autenticarUsuario(@RequestParam String correoUsuario, @RequestParam String contrasenaUsuario) {
        return usuarioService.autenticarUsuario(correoUsuario, contrasenaUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable int id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarioService.obtenerUsuarioPorId(id);
        if (usuarioExistente != null) {
            usuario.setIdUsuario(id);
            return usuarioService.actualizarUsuario(usuario);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }
    
    /** 
    
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
	    **/
}