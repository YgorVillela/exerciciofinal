package br.com.fiap.exerciciofinal.controller;

import br.com.fiap.exerciciofinal.model.Prioridade;
import br.com.fiap.exerciciofinal.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("prioridade")
public class PrioridadeController {

    @Autowired
    private PrioridadeRepository rep;

    @GetMapping("cadastrar")
    public String cadastrar(Prioridade prioridade){

        return "prioridade/form";
    }
    //------------------Cadastrando--------------------------------
    @PostMapping("cadastrar")
    public String cadastrar(@Valid Prioridade prioridade, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "prioridade/form";
        }
        redirectAttributes.addFlashAttribute("msg", "Cadastrado!");
        rep.save(prioridade);
        return"redirect:/prioridade/cadastrar";
        //Aqui preciso mandar para o getmapping "cadastrar" e lá processarei o form...
        //sem isso a página form dará erro quando eu for cadastrar
    }
    //------------Buscando---------------------
    @GetMapping("buscar")
    public String buscar(Model model, int buscaPorNivel){
        model.addAttribute("prioridades", rep.findByNivel(buscaPorNivel));
        return "prioridade/lista";
    }
    //-----------listando-----------------
    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("prioridades", rep.findAll());
        return "prioridade/lista";
    }
    //---------------editando----------------
    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prioridade",rep.findById(codigo));
        return "prioridade/form";
    }

    //-----------Excluir--------------
    @PostMapping("excluir")
    public String excluir(RedirectAttributes redirectAttributes, int codigo){
        rep.deleteById(codigo);
        redirectAttributes.addFlashAttribute("msg", "Excluído!");
        return "redirect:/prioridade/listar";
    }

}
