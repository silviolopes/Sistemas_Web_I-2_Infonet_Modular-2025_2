package br.com.projetoescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoescola.escola.entity.Aluno;
import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.service.AlunoService;
import br.com.projetoescola.escola.service.CidadeService;
import br.com.projetoescola.escola.service.CursoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/alunos")
public class AlunoController {

    //Injeção de dependência da service de alunos e de cursos
    @Autowired
    private AlunoService alunoService;

    @Autowired 
    private CursoService cursoService;

    @Autowired 
    private CidadeService cidadeService;


    //Método para salvar um aluno
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        alunoService.save(aluno);
        return "redirect:/alunos/listar";
    }
    //Método para listar todos os alunos
    @GetMapping("/listar")
    public String listar(Model model){
        List<Aluno> alunos = alunoService.findAll();
        model.addAttribute("alunos", alunos);
        return "aluno/listarAluno";
    }
    //Método para abrir o formulário de aluno
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("aluno", new Aluno());
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "aluno/formularioAluno";
    }

    //Método para excluir um aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        alunoService.deleteById(id);
        return "redirect:/alunos/listar";
    }

    //Método para abrir o formulário de edição de alunos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model) {
        Aluno aluno = alunoService.findById(id);
        model.addAttribute("aluno", aluno);
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);

        
        return "aluno/formularioAluno";
    }
    
    
    
}
