package br.com.projetoescola.escola.dto;

import br.com.projetoescola.escola.entity.Aluno;
import br.com.projetoescola.escola.entity.Curso;

public class AlunoCurso {

    private String nomeAluno;
    private String nomeCurso;

    public AlunoCurso() {
    }

    public AlunoCurso(String nomeAluno, String nomeCurso) {
        this.nomeAluno = nomeAluno;
        this.nomeCurso = nomeCurso;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

   

}
