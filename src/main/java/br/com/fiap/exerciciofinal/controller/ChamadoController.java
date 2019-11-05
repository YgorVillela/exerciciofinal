package br.com.fiap.exerciciofinal.controller;

import br.com.fiap.exerciciofinal.model.Chamado;
import br.com.fiap.exerciciofinal.repository.ChamadoRepository;
import br.com.fiap.exerciciofinal.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("chamado")
public class ChamadoController {

    @Autowired
    private ChamadoRepository rep;

    @Autowired
    private PrioridadeRepository prioridadeRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Chamado chamado, Model model){
        model.addAttribute("prioridades", prioridadeRepository.findAll());
        return "chamado/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid Chamado chamado, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "chamado/form";
        }
        redirectAttributes.addFlashAttribute("msg", "Cadastrado!");
        rep.save(chamado);
        return "redirect:/chamado/listar";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("chamados", rep.findAll());
        model.addAttribute("prioridades", prioridadeRepository.findAll());
        return "chamado/lista";
    }

    @GetMapping("buscar")
    public String buscar(Model model, int buscaPorPrioridade){
        model.addAttribute("prioridades",prioridadeRepository.findAll());
        model.addAttribute("chamados", rep.findByPrioridade_Codigo(buscaPorPrioridade));
        return "chamado/lista";
    }
    //-----------Excluir--------------
    @PostMapping("excluir")
    public String excluir(RedirectAttributes redirectAttributes, int codigo){
        rep.deleteById(codigo);
        redirectAttributes.addFlashAttribute("msg", "Excluído!");
        return "redirect:/chamado/listar";
    }
}
