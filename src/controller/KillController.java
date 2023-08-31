package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class KillController {

	//Descobre o sistema operacional.
	private String os() {
		String osName = System.getProperty("os.name");
		return osName;
	}
	
	//Lista todos os processos que estão sendo executados, de acordo com o SO.
	public String listaProcessos(){
		String commandList = "";

		if(os().contains("Windows")) {
			commandList = "TASKLIST /FO TABLE";
		} else if (os().contains("Linux")) {
			commandList = " ps -ef";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(commandList);
			InputStream pInput = p.getInputStream();
			InputStreamReader pReader = new InputStreamReader(pInput);
			BufferedReader pBuffer = new BufferedReader(pReader);
			
			String pLinha = pBuffer.readLine();

			while (pLinha != null) {
				System.out.println(pLinha);
				pLinha = pBuffer.readLine();
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
		
	}
	
	//Task Destroyer: PID edition
	//Usa o valor fornecido para executar o comando, e verifica no processo se é realmente um PID
	public void mataPID (String vitima) {
		String killPID = "";
		
		if(os().contains("Windows")) {
			killPID = "TASKKILL /PID "; 
		} else if (os().contains("Linux")) {
			killPID = "pkill -f ";
		}
		
		//Só para verificar se é realmente um PID
		int pidInt;
		
		try {
			pidInt = Integer.parseInt(vitima);
			Runtime.getRuntime().exec(killPID+pidInt);
		} catch (Exception e) {
			System.err.println(e);
			JOptionPane.showMessageDialog(null, "Verifique o PID e tente novamente");
		}
		
	}
	
	//Task Destroyer: Name edition
	public void mataNome(String vitima) {
		String killNome = "";
		if(os().contains("Windows")) {
			killNome = "TASKKILL /IM "; //+ nome do processo
		} else if (os().contains("Linux")) {
			killNome = "kill -9 "; //+ nome do processo
		}
		
		try {
			Runtime.getRuntime().exec(killNome+vitima);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
}
