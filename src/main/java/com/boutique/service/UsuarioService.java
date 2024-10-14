package com.boutique.service;

import java.util.List;
import java.util.Optional;

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
		usuario.setEstadoUsuario(true);
		Usuario usuarioGuardado = urepository.save(usuario);
		return usuarioGuardado;
	}

	public Usuario autenticarUsuario(String correoUsuario, String contrasenaUsuario) {
		Usuario usuario = urepository.findByCorreoUsuario(correoUsuario);
		if (usuario == null || !usuario.getContrasenaUsuario().equals(contrasenaUsuario)) {
			Usuario nulo = new Usuario();
			nulo.setIdUsuario(-1);
			return nulo;
		}
		return usuario;
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

	public Usuario actualizarUsuario(String action, int id, Usuario usuario) {
		Usuario encontrado = obtenerUsuarioPorId(id);
		if (encontrado == null) {
			Usuario nulo = new Usuario();
			nulo.setIdUsuario(-1);
			return nulo;
		}

		if (action.equals("info")) {
			encontrado.setNombreUsuario(usuario.getNombreUsuario());
			encontrado.setApellidoUsuario(usuario.getApellidoUsuario());
			encontrado.setDireccionUsuario(usuario.getDireccionUsuario());
			encontrado.setTelefonoUsuario(usuario.getTelefonoUsuario());
			return urepository.save(encontrado);
		}
		else if (action.equals("security")) {
			encontrado.setContrasenaUsuario(usuario.getContrasenaUsuario());
			return urepository.save(encontrado);
		}
		else {
			Usuario nulo = new Usuario();
			nulo.setIdUsuario(-1);
			return nulo;
		}
	}

	public Usuario actualizarEstado(int id) {
		Usuario usuario = null;
		Optional<Usuario> encontrado = urepository.findById(id);
		if (!encontrado.isPresent()) {
			Usuario nulo = new Usuario();
			nulo.setIdUsuario(-1);
			return nulo;
		}
		usuario = encontrado.get();
		usuario.setEstadoUsuario(!usuario.isEstadoUsuario());
		return urepository.save(usuario);
	}
}
