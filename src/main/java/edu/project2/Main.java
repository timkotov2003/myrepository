package edu.project2;

import edu.project2.generator.Generator;
import edu.project2.generator.impl.PrimGenerator;
import edu.project2.model.Coordinate;
import edu.project2.model.Maze;
import edu.project2.renderer.impl.ConsoleRenderer;
import edu.project2.solver.Solver;
import edu.project2.solver.impl.BFSSolver;

@SuppressWarnings({"HideUtilityClassConstructor", "MagicNumber", "RegexpSinglelineJava"})
public final class Main {

    public static void main(String[] args) {
        Generator generator = new PrimGenerator();
        Maze maze = generator.generate(17, 17);
        System.out.println(new ConsoleRenderer().render(maze));
        Solver solver = new BFSSolver();
        var path = solver.solve(maze, Coordinate.of(1, 1), Coordinate.of(15, 15));
        System.out.println(new ConsoleRenderer().render(maze, path));
    }

}
