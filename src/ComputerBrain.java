import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class ComputerBrain {

  String[][] oppBoard;
  private final boolean HUNT = true;
  private final boolean TARGET = false;

  boolean currentMode = HUNT;


  public ComputerBrain() {
    oppBoard = new String[10][10];
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        oppBoard[i][j] = "-";

      }
    }

  }

  public void importGuess(String type, int row, int col) {
    oppBoard[row][col] = type;

  }

  public int[] makeGuess(Player user, Player computer) {
    int[][] probabilityMap = generateProbabilityMap();
    int max = probabilityMap[0][0];
    int xCor = 0;
    int yCor = 0;
    for(int i = 0; i<probabilityMap.length; i++) {
      for(int j = 0; j<probabilityMap[i].length; j++) {
        if(probabilityMap[i][j] > max) {
          max = probabilityMap[i][j];
          yCor = i;
          xCor = j;
        }
      }
    }
    int[] stuff = {xCor, yCor};
    return stuff;
    
  }

  public int[][] generateProbabilityMap() {
    int[][] probabilityMap = new int[10][10];
    int[][] carrierProbabilityMap = generateCarrierPositions();
    int[][] battleshipProbabilityMap = generateBattleshipPositions();
    int[][] cruiserProbabilityMap = generateCruiserPositions();
    int[][] submarineProbabilityMap = generateSubmarinePositions();
    int[][] destroyerProbabilityMap = generateDestroyerPositions();
    
    for(int i = 0; i<probabilityMap.length; i++) {
      for(int j = 0; j<probabilityMap[i].length; j++) {
        probabilityMap[i][j] += carrierProbabilityMap[i][j];
        probabilityMap[i][j] += battleshipProbabilityMap[i][j];
        probabilityMap[i][j] += cruiserProbabilityMap[i][j];
        probabilityMap[i][j] += submarineProbabilityMap[i][j];
        probabilityMap[i][j] += destroyerProbabilityMap[i][j];
      }
    }
    


    return probabilityMap;

  }

  public int[][] generateCarrierPositions() {
    final int CARRIER_OFFSET = 4;
    int[][] cMap = new int[10][10];

    // vertical positions
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= CARRIER_OFFSET) {
          Point p = new Point(i + count, j);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }
      }
    }

    // horizontal ship
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= CARRIER_OFFSET) {
          Point p = new Point(i, j + count);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }

      }
    }

    return cMap;

  }
  
  public int[][] generateBattleshipPositions() {
    final int BATTLESHIP_OFFSET = 3;
    int[][] cMap = new int[10][10];

    // vertical positions
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= BATTLESHIP_OFFSET) {
          Point p = new Point(i + count, j);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }
      }
    }

    // horizontal ship
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= BATTLESHIP_OFFSET) {
          Point p = new Point(i, j + count);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }

      }
    }

    return cMap;

  }

  public int[][] generateCruiserPositions() {
    final int CRUISER_OFFSET = 2;
    int[][] cMap = new int[10][10];

    // vertical positions
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= CRUISER_OFFSET) {
          Point p = new Point(i + count, j);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }
      }
    }

    // horizontal ship
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= CRUISER_OFFSET) {
          Point p = new Point(i, j + count);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }

      }
    }

    return cMap;

  }
  
  public int[][] generateSubmarinePositions() {
    final int SUBMARINE_OFFSET = 2;
    int[][] cMap = new int[10][10];

    // vertical positions
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= SUBMARINE_OFFSET) {
          Point p = new Point(i + count, j);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }
      }
    }

    // horizontal ship
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= SUBMARINE_OFFSET) {
          Point p = new Point(i, j + count);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }

      }
    }

    return cMap;

  }

  public int[][] generateDestroyerPositions() {
    final int DESTROYER_OFFSET = 1;
    int[][] cMap = new int[10][10];

    // vertical positions
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= DESTROYER_OFFSET) {
          Point p = new Point(i + count, j);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }
      }
    }

    // horizontal ship
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        boolean valid = true;
        ArrayList<Point> possibleLocations = new ArrayList<Point>();
        int count = 0;
        while (count <= DESTROYER_OFFSET) {
          Point p = new Point(i, j + count);
          possibleLocations.add(p);
          count++;
        }

        for (Point p : possibleLocations) {
          if ((int) p.getX() >= 10) {
            valid = false;
          } else if ((int) p.getY() >= 10) {
            valid = false;
          } else if (!oppBoard[(int) p.getX()][(int) p.getY()].equals("-")) {
            valid = false;
          }
        }

        if (valid) {
          for (Point p : possibleLocations) {
            cMap[(int) p.getX()][(int) p.getY()] += 1;
          }
        }

      }
    }

    return cMap;

  }


  // private static String[][] formatGrid(Grid toFormat){
  // String[][] board = new String[toFormat.NUM_ROWS][toFormat.NUM_COLS];
  // for(int i = 0; i< board.length; i++) {
  // for(int j = 0; j < board[i].length; j++) {
  // if(toFormat.get(j, i).checkHit()) {
  // if(toFormat.get(j, i).getLengthOfShip())
  //
  // }
  //
  // }
  // }


}
