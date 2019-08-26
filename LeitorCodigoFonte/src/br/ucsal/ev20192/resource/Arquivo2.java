package br.ucsal.ev20192.resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Arquivo2 {

	public static void main(String[] args) {
		List<Arquivo1> circuitos = new ArrayList<Arquivo1>();
		File arquivo = new File("circuits.csv");
	
		try {
			FileInputStream fileIntuptStream = new FileInputStream(arquivo);
			InputStreamReader inputStreamReader = new InputStreamReader(fileIntuptStream);
			BufferedReader bufferReader = new BufferedReader(inputStreamReader);
			String line = "";
			bufferReader.readLine();
			while ((line = bufferReader.readLine()) != null) {
				String[] array = line.split(",");
				Arquivo1 circuito = new Arquivo1(Integer.parseInt(array[0]), array[1], array[2], array[3], array[4],
						array[5], array[6], array[7], array[8]);
				circuitos.add(circuito);
			}
		
			bufferReader.close();
		
		} catch (Exception e) {
		}
		
		System.out.println(circuitos.size());
		for (Arquivo1 circuito : circuitos) {
			System.out.println(circuito);
		}
		System.out.println();
		
		Collections.sort(circuitos, Collections.reverseOrder());
		for (Arquivo1 circuito : circuitos) {
			System.out.println(circuito);
		}
		System.out.println();
		
		Compare c = new Compare();

		Collections.sort(circuitos, c);
		for (Arquivo1 circuito : circuitos) {
			System.out.println(circuito);
		}
	}
}

class Compare implements Comparator<Arquivo1> {
	@Override
	public int compare(Arquivo1 o1, Arquivo1 o2) {
		return o1.getRefCircuito().compareTo(o2.getRefCircuito()) * -1;
	}
}