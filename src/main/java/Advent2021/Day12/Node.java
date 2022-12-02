package Advent2021.Day12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class Node {

    String name;
    List<Node> connectedNodes;


}
