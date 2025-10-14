package br.com.projetoescola.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projetoescola.escola.entity.Aluno;
import br.com.projetoescola.escola.entity.Cidade;
import br.com.projetoescola.escola.entity.Curso;
import br.com.projetoescola.escola.service.AlunoService;
import br.com.projetoescola.escola.service.CidadeService;
import br.com.projetoescola.escola.service.CursoService;


@Controller
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

   
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cidade cidade) {
        cidadeService.save(cidade);
        return "redirect:/cidades/listar";
    }
   
    @GetMapping("/listar")
    public String listar(Model model){
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "cidade/listarCidade";
    }
    
    @GetMapping("/criar")
    public String criarForm(Model model) {
        model.addAttribute("cidade", new Cidade());
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "cidade/formularioCidade";
    }

   
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        cidadeService.deleteById(id);
        return "redirect:/cidades/listar";
    }

    //Método para abrir o formulário de edição de alunos
    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable("id") Integer id, Model model) {
        Cidade cidade = cidadeService.findById(id);
        model.addAttribute("cidade", cidade);
        List<Cidade> cidades = cidadeService.findAll();
        model.addAttribute("cidades", cidades);
        return "cidades/formularioCidade";
    }
    
}
