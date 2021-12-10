package ecs.components.graphics;

import java.util.ArrayList;

import ecs.Component;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public abstract class Graphics extends Component {
	// TODO: Refactor! sollte sich grafische objekte selbstst�ndig holen (Lines,
	// Sprites, Tilemaps ...)
	
	
	public ArrayList<Shape> shapes = null;
	Pane graphicsContext = null;

	public Graphics(Pane graphicsContext) { // abstrakt
		this.graphicsContext = graphicsContext;
		this.shapes = new ArrayList<Shape>();
	}

	public void addShape(Shape shape) { // abstrakt
		shapes.add(shape);
		graphicsContext.getChildren().add(shape);

	}

	public <T extends Shape> T getShape(Class<T> shapeClass) {
		for (var shape : shapes) {
			if (shape.getClass().isAssignableFrom(shapeClass)) {
				return shapeClass.cast(shape);
			}
		}
		return null;
	}

	abstract public void clicked();

	@Override
	abstract public void update(float deltaT);

	public void show() {
		this.hide();// necessery because in javafx you cant insert duplications of nodes
		graphicsContext.getChildren().addAll(shapes);
	}

	public void hide() {
		graphicsContext.getChildren().removeAll(shapes);
	}

	public void clearPane() {
		graphicsContext.getChildren().clear();
	}
}
