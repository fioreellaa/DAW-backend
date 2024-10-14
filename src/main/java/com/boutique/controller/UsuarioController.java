package com.boutique.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.boutique.model.Usuario;
import com.boutique.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/autenticar")
    public Usuario autenticarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.autenticarUsuario(usuario.getCorreoUsuario(), usuario.getContrasenaUsuario());
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable int id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PutMapping("/{action}/{id}")
    public Usuario actualizarInfoUsuario(@PathVariable String action, @PathVariable int id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(action, id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }

	@PutMapping("/estado/{id}")
	public Usuario actualizarEstado(@PathVariable int id) { return usuarioService.actualizarEstado(id); }
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