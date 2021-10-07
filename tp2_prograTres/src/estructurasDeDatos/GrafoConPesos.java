package estructurasDeDatos;

import java.util.Collections;
import java.util.HashSet;


public class GrafoConPesos extends Grafo {

	private HashSet<AristaConPeso> aristas;
	public GrafoConPesos(int i) {
		super(i);
		aristas = new HashSet<AristaConPeso>();
	}
	
	public void agregarAristaConPeso(int a , int b , double peso) {
		AristaConPeso arista = new AristaConPeso(a, b, peso);
		if(!aristas.contains(arista)) {
			agregarArista(a, b);
			aristas.add(arista);
		}
		else {
			throw new RuntimeException("La arista ya existe");
		}
	}
	
	public double getPeso(int a , int b) {
		if(!aristas.contains(new AristaConPeso(a, b, 0))) {
			throw new RuntimeException("La arista no existe en el grafo");
		}

		for (AristaConPeso arista : aristas) {
				if(arista.getA() == a && arista.getB() == b) {
						return arista.getPeso();
				}
		}
		return 0;
	}
	
	
	public HashSet<AristaConPeso> getAristas(){
		return (HashSet<AristaConPeso>) aristas.clone();
	}

	public AristaConPeso getMaxima() {
		return Collections.max(aristas);
	}
	
}