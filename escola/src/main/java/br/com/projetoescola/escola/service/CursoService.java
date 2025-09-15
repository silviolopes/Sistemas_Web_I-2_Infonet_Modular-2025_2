package br.com.projetoescola.escola.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetoescola.escola.entity.Aluno;
import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.repository.CursoRepository;

@Service
public class CursoService {

    // Injeção de dependência do repositório de alunos
    @Autowired
    private CursoRepository cursoRepository;

    // Método para salvar um curso
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    // Método para listar todos os cursos
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    // Método para excluir um curso pelo ID
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }

    // Método para buscar o aluno pelo ID
    public Curso findById(Integer id) {
        return cursoRepository.findById(id).orElse(null);
    }

}
