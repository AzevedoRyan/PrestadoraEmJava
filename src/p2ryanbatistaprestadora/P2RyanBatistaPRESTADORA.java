
package p2ryanbatistaprestadora;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class P2RyanBatistaPRESTADORA {

    
     public static void main(String[] args) throws FileNotFoundException {
        Funcionario fc2[] = new Funcionario[9];
        lerDados(fc2);
        
        int opcao;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Menu\n" + "1 - Pesquisa por cliente" + "\n2 - Pesquisa por serviço\n" + "3 - Valor total recebido\n"+ "4 - Sair\n");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    String clienteEscolhido;
                    System.out.println("Digite o cliente: ");
                    clienteEscolhido = scan.next();
                    ClienteEsc(fc2, clienteEscolhido);
                    break;
                case 2:
                    CalcPorServ(fc2);
                    break;
                case 3:
                    double valorTotal = 0;
                    for (int i = 0; i < fc2.length; i++) {
                        valorTotal += fc2[i].calcServFinal();
                    }
                    System.out.println("\nValor Total recebido: "+ valorTotal);
                    break;
                case 4:
                    opcao = 4;
                    break;
            }
        }while(opcao!=4);
    }
    public static void lerDados(Funcionario fc[]) throws FileNotFoundException {

        File arq = new File("dados.txt");
        Scanner scanArq = new Scanner(arq);

        System.out.printf("%10s %10s %10s %10s\n", scanArq.next(), scanArq.next(),
                scanArq.next(),scanArq.next());
        for (int i = 0; i < 9; i++) {
            fc[i] = new Funcionario(scanArq.nextInt(), scanArq.next(),
                    scanArq.next(), scanArq.nextInt());
            System.out.printf("%10d %10s %10s %10d\n", fc[i].codServico,
                    fc[i].cliente, fc[i].descricao,fc[i].qtdHoras);
        }
    }
    
    public static void ClienteEsc(Funcionario fc[], String clienteEscolhido){
        boolean achou = false;
        for (int i = 0; i<fc.length; i++) {
            if (clienteEscolhido.equals(fc[i].cliente)){
                achou = true;
                System.out.println(fc[i].descricao);
                System.out.println(fc[i].calcServFinal());
            } 
          
            
        }
        if(!achou ){
        System.out.println("cliente inexistente");
        
        }
    }
    public static void CalcPorServ(Funcionario fc[])
    {
        int qtdTotalHP = 0;
            int qtdTotalHF = 0;
            int qtdTotalHJ = 0;
            double valorPintura = 0;
            double valorFaxina = 0;
            double valorJardim = 0;
        for (int i = 0; i < fc.length; i++) {
            
            if(fc[i].descricao.equals("pintura")){
                qtdTotalHP = qtdTotalHP + fc[i].qtdHoras;
                valorPintura += fc[i].calcServFinal();
                
            }
            if(fc[i].descricao.equals("faxina")){
                qtdTotalHF = qtdTotalHF + fc[i].qtdHoras;
                valorFaxina += fc[i].calcServFinal();
                
            }
            if(fc[i].descricao.equals("jardinagem")){
                qtdTotalHJ = qtdTotalHJ + fc[i].qtdHoras;
                valorJardim += fc[i].calcServFinal();
                
            }
        }
        System.out.println("pintura: "+"quantidade horas "+qtdTotalHP+"  valor total: "+valorPintura);
        System.out.println("faxina: "+"quantidade horas "+qtdTotalHF+"  valor total: "+valorFaxina);
        System.out.println("jardinagem: "+"quantidade horas "+qtdTotalHJ+"  valor total: "+valorJardim);
    }
    
    
}
