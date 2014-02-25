import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class FollowDirections {

    private static DataInputStream in;


    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            in = new DataInputStream(new FileInputStream("/home/wyti/CodingContest/Microsoft2014/CodeContest/FollowDirections/SampleInput.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            String[] data = new String[ 2 ];
            /**
             * Directions are as follow : 1 for north 2 for east 3 for south 4 for west
             */
            int direction = 1;
            int posX = 0;
            int posY = 0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                data = line.split(" ");
                switch (data[ 0 ]) {
                    case "Move":
                        switch (direction) {
                            case 1:
                                posY += Integer.valueOf(data[ 1 ]);
                                break;
                            case 2:
                                posX += Integer.valueOf(data[ 1 ]);
                                break;
                            case 3:
                                posY -= Integer.valueOf(data[ 1 ]);
                                break;
                            case 4:
                                posX -= Integer.valueOf(data[ 1 ]);
                                break;
                        }
                        break;
                    case "Turn":
                        switch (data[ 1 ]) {
                            case "right":
                                direction++;
                                break;
                            case "left":
                                direction--;
                                break;
                        }
                        if (direction == 0) {
                            direction = 4;
                        } else if (direction == 5) {
                            direction = 1;
                        }
                }
            }
            // Close the input stream
            in.close();
            System.out.println(posX + ","+posY);
        } catch (Exception e) {// Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
}
