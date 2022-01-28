package ai_algorithm.search;

import ai_algorithm.SearchNode;
import ai_algorithm.problems.Problem;

/**
 * Schablone f�r suchalgorithmus
 * 
 * @author Severin
 *
 */
public abstract class SearchAlgorithm {
	/**
	 * Problem f�r Sichalgorithmus wird Injekziert
	 */
	Problem problem;

	/**
	 * Default
	 */
	public SearchAlgorithm() {

	}

	/**
	 * Suchalgorithmus mit Problem erzeugen
	 * 
	 * @param problem
	 */
	public SearchAlgorithm(Problem problem) {
		this.problem = problem;
	}

	/**
	 * Problem des Algorithmus setzen
	 * 
	 * @param problem
	 */
	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	/**
	 * Startet die suche
	 * @return ergebnis der suche
	 */
	public abstract SearchNode search();

}
