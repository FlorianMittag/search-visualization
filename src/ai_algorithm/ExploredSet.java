package ai_algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import ai_algorithm.problems.State;
import ecs.GameObject;
import ecs.GameObjectRegistry;

/**
 * Datenstruktur zum "Markieren" der bereits besuchten Zust�nde
 * 
 * @author Severin
 *
 */
public class ExploredSet extends GameObject {

	/**
	 * verwaltung in hash-Map
	 */
	HashMap<State, SearchNode> explored;

	/**
	 * Erzeugt neues Explored-Set
	 */
	public ExploredSet() {
		super();
		explored = new HashMap<State, SearchNode>();

	}

	/**
	 * F�ge einen knoten zum Explored-Set hinzu der zustand wird automatisch
	 * herausgeholt
	 * 
	 * @param node
	 */
	public void add(SearchNode node) {
		State state = node.getState();
		this.explored.put(state, node);
		node.metadata.isInExploredSet = true;
		node.metadata.isInMemory = true;
		// visualisierung �ber �nderung informieren
		GameObjectRegistry.registerForStateChange(node);
		GameObjectRegistry.registerForStateChange(state);
		GameObjectRegistry.registerForStateChange(this);
	}

	/**
	 * F�ge mehrere knoten zum Explored-Set hinzu der zustand wird automatisch
	 * herausgeholt
	 * 
	 * @param node
	 */
	public void addAll(List<SearchNode> nodes) {
		for (SearchNode node : nodes) {
			explored.put(node.getState(), node);
			node.metadata.isInExploredSet = true;
			node.metadata.isInMemory = true;
			// visualisierung �ber �nderung informieren
			GameObjectRegistry.registerForStateChange(node.getState());
			GameObjectRegistry.registerForStateChange(node);
		}
		// visualisierung �ber �nderung informieren
		GameObjectRegistry.registerForStateChange(this);
	}

	/**
	 * Pr�fe ob werte vorhanden
	 * 
	 * @return war oder falsch
	 */
	public boolean isEmpty() {
		return explored.isEmpty();
	}

	/**
	 * gibt an ob ein zustand im Explored-Set enthalten ist
	 * 
	 * @param state
	 * @return ture, false
	 */
	public boolean contains(State state) {
		if (explored.containsKey(state)) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt den zuletzt eingef�gten knoten mit dem entsprechenden zustand zur�ck
	 * 
	 * @param state
	 * @return Knoten der �ber state identifiziert wird
	 */
	public SearchNode get(State state) {
		return explored.get(state);
	}

	/**
	 * l�scht den gesammten inhalt des Explored-Set
	 */
	public void clear() {
		explored.clear();
	}

}
