package org.ag.ants.env;

import java.awt.Dimension;

import org.ag.common.env.Direction;
import org.ag.common.env.Node;

/**
 * Factory that produces elements will be used as environments or placed in existent environments, not to be confused
 * with EnvironmentElement objects.
 *
 * <p>This class will hardly be used directly in the simulations, most of the time it will be used as a tool by other
 * objects that will be part of the simulations.</p>
 *
 * @author Luiz Abrahao <luiz@luizabrahao.com>
 */
public class EnvironmentFactory {
    private EnvironmentFactory() {}

    /**
     * Generates a bi-dimensional array formed by <i>NestNode</i> objects with the given dimension and name.
     *
     * @param nestName nest's unique identifier
     * @param dimension nest's dimension.
     * @return bi-dimensional array formed by NesNode objects.
     */
    public static NestNode[][] createNestGrid(final String nestName, Dimension dimension) {
        NestNode[][] nodes = new NestNode[dimension.height][dimension.width];

        for (int l = 0; l < dimension.height; l++) {
            for (int c = 0; c < dimension.width; c++) {
                nodes[l][c] = new NestNode(nestName + "-" + l + "," + c);

                if (c != 0) {
                    nodes[l][c].setNeighbours(Direction.WEST, nodes[l][c - 1]);
                }

                if (l != 0) {
                    nodes[l][c].setNeighbours(Direction.NORTH, nodes[l - 1][c]);
                }

                if ((l != 0) && (c != 0)) {
                    nodes[l][c].setNeighbours(Direction.NORTH_WEST, nodes[l - 1][c - 1]);
                }

                if ((l != 0) && (c != dimension.width - 1)) {
                    nodes[l][c].setNeighbours(Direction.NORTH_EAST, nodes[l - 1][c + 1]);
                }
            }
        }

        return nodes;
    }

    /**
     * Generates a bi-dimensional array formed by <i>PheromoneGrid</i> objects, to be used as the base of environments
     * used in simulations with ants.
     *
     * @param dimension array's dimensions
     * @return bi-dimensional array of PheromoneGrid objects.
     */
    public static Node[][] createPheromoneGrid(final Dimension dimension) {
        Node[][] nodes = new Node[dimension.height][dimension.width];

        for (int l = 0; l < dimension.height; l++) {
            for (int c = 0; c < dimension.width; c++) {
                nodes[l][c] = new PheromoneNode("n-" + l + "," + c);

                if (c != 0) {
                    nodes[l][c].setNeighbours(Direction.WEST, nodes[l][c - 1]);
                }

                if (l != 0) {
                    nodes[l][c].setNeighbours(Direction.NORTH, nodes[l - 1][c]);
                }

                if ((l != 0) && (c != 0)) {
                    nodes[l][c].setNeighbours(Direction.NORTH_WEST,
                            nodes[l - 1][c - 1]);
                }

                if ((l != 0) && (c != dimension.width - 1)) {
                    nodes[l][c].setNeighbours(Direction.NORTH_EAST,
                            nodes[l - 1][c + 1]);
                }
            }
        }

        return nodes;
    }

    /**
     * Generate a bi-dimensional array formed by <i>FoodSourceNode</i> objects, to be used as food sources in ant
     * simulations.
     *
     * @param name food source's unique identifier.
     * @param dimension food source's dimensions
     * @param totalAmountOfFood total amount of food available in the source.
     * @return bi-dimensional array formed by FoodSourceNode nodes.
     */
    public static FoodSourceNode[][] createFoodSourceGrid(final String name, final Dimension dimension,
                                                          final double totalAmountOfFood) {

        final FoodSourceNode[][] nodes = new FoodSourceNode[dimension.height][dimension.width];
        final double amountInEachNode = totalAmountOfFood / (dimension.height * dimension.width);

        for (int l = 0; l < dimension.height; l++) {
            for (int c = 0; c < dimension.width; c++) {
                nodes[l][c] = new FoodSourceNode(name + "-" + l + "," + c, amountInEachNode);

                if (c != 0) {
                    nodes[l][c].setNeighbours(Direction.WEST, nodes[l][c - 1]);
                }

                if (l != 0) {
                    nodes[l][c].setNeighbours(Direction.NORTH, nodes[l - 1][c]);
                }

                if ((l != 0) && (c != 0)) {
                    nodes[l][c].setNeighbours(Direction.NORTH_WEST, nodes[l - 1][c - 1]);
                }

                if ((l != 0) && (c != dimension.width - 1)) {
                    nodes[l][c].setNeighbours(Direction.NORTH_EAST, nodes[l - 1][c + 1]);
                }
            }
        }

        return nodes;
    }
}
