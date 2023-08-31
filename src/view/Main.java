package view;

import javax.swing.JOptionPane;

import controller.KillController;

//- Destruidor de tasks do Windows e do Linux
//- Número de vezes que meu notepad já morreu: 16

public class Main {

	public static void main(String[] args) {
		KillController Killer = new KillController();
		
		String vitima = "";
		
		//blah blah blah algoritimo de escolha blah blah
		
		String[] escolhas = {"Marcar alvo", "Verificar tasks ativas","Matar via PID","Matar via nome"};
		int escolhaPane = JOptionPane.showOptionDialog(null, "Selecione: ", "TASK KILLER 3000"
				, JOptionPane.INFORMATION_MESSAGE, JOptionPane.CANCEL_OPTION, 
				null, escolhas, escolhas[0]) + 1;
		
		while(escolhaPane != 0) {
			
			switch(escolhaPane) {
			case 1:
				vitima = JOptionPane.showInputDialog(null, "Insira o nome/pid do processo que desejas matar");
				break;
			case 2:
				Killer.listaProcessos();
				break;
			case 3:
				Killer.mataPID(vitima);
				break;
			case 4:
				Killer.mataNome(vitima);
			}
			
			escolhaPane = JOptionPane.showOptionDialog(null, "Selecione:", "TASK KILLER 3000"
					, JOptionPane.INFORMATION_MESSAGE, JOptionPane.CANCEL_OPTION, 
					null, escolhas, escolhas[0]) + 1;
		}
		
		
		
		
	}

}
