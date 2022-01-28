package ai_algorithm.problems;

import java.util.List;

import ecs.GameObject;
/**
 * Die das Problem R�presentiert
 * 
 * @author Severin
 *
 *
 */
public abstract class Problem extends GameObject {

	/**
	 * Gibt startzustand zur�ck
	 * 
	 * @return Startzustand
	 */
	public abstract State getInitialState();

	/**
	 * Gibt zielzustand sofern dieser bekannt ist ansonsten null
	 * 
	 * @return zielzustand oder null
	 */
	public State getGoalState() {
		return null;
	}

	/**
	 * �berpr�fe ob zustand zielzustand ist
	 * 
	 * @param state
	 * @return wahr wenn state zielzustand ist, sonst false
	 */
	public abstract boolean isGoalState(State state);

	/**
	 * Gibt alle aktionen die in einem zustand m�glich sind an
	 * 
	 * @param state
	 * @return liste der aktionen
	 */
	public abstract List<String> getActions(State state);

	/**
	 * gibt f�r einen Zustand und seine Aktion den Folgezustand an
	 * 
	 * @param state
	 * @param action
	 * @return folgezustand
	 */
	public abstract State getSuccessor(State state, String action);

	/**
	 * gibt f�r einen Zustand und eine Aktion und den Folgezustand an wie hoch die
	 * kosten sind
	 * 
	 * @param state
	 * @param action
	 * @param succ
	 * @return kosten der aktion aus zustand
	 */
	public abstract double getCost(State state, String action, State succ);

}
