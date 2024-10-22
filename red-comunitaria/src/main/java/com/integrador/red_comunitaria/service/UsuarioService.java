package com.integrador.red_comunitaria.service;

import com.integrador.red_comunitaria.model.Usuario;
import com.integrador.red_comunitaria.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuario.setDocumentNumber(usuarioDetalles.getDocumentNumber());
        usuario.setName(usuarioDetalles.getName());
        usuario.setLastName(usuarioDetalles.getLastName());
        usuario.setCellPhone(usuarioDetalles.getCellPhone());
        usuario.setEmail(usuarioDetalles.getEmail());
        usuario.setRol(usuarioDetalles.getRol());
        return usuarioRepository.save(usuario);
    }
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
