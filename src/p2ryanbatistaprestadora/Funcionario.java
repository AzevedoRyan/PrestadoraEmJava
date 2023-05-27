/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2ryanbatistaprestadora;

/**
 *
 * @author aluno
 */
public class Funcionario {
    
   int codServico;
   String cliente;
   String descricao;
   int qtdHoras;
   
   public Funcionario(int codServico, String cliente, String descricao, int qtdHoras){
       this.codServico = codServico;
       this.cliente = cliente;
       this.descricao = descricao;
       this.qtdHoras = qtdHoras;
   }
    public double calcServFinal(){
        double servFinal;
        if (descricao.equals("pintura")){
        servFinal = qtdHoras*30;
        
    }else if(descricao.equals("jardinagem")){
        servFinal = qtdHoras*10;
            
            }else{
        servFinal = qtdHoras*20;
    }
        return servFinal;
    }
}
