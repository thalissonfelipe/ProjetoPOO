package br.ufc.deti.poo.model; 

import java.io.IOException;
import java.text.ParseException;

import br.ufc.deti.poo.exceptions.CodigoExistenteException;
import br.ufc.deti.poo.exceptions.CpfExistenteException;
import br.ufc.deti.poo.exceptions.ListaIsEmptyException;
import br.ufc.deti.poo.exceptions.ValorNegativoException;
import br.ufc.deti.poo.view.TelaPrincipal;

public class Main {

	public static void main(String[] args) throws ListaIsEmptyException, CpfExistenteException, CodigoExistenteException, ValorNegativoException, ParseException, IOException {
		
		Administrador adm = new Administrador();
		TelaPrincipal tela = new TelaPrincipal(adm);
		tela.setVisible(true);
		tela.setResizable(false);
		tela.setLocationRelativeTo(null);
		
	}

}
