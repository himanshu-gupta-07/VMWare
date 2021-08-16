import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.css.Rect;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SecondProblem {
    public static void main(String str[]) throws IOException, ParseException {

        JSONParser parser= new JSONParser();
        FileReader reader= new FileReader(".\\jsonFiles\\input.json");
        Object ob= parser.parse(reader);
        JSONObject job= (JSONObject)ob;

        Circle circle= new Circle();
        Rectangle rectangle= new Rectangle();
        Square square = new Square();


        JSONObject jsonCircle= (JSONObject) job.get("1");
        circle.r= new Double(jsonCircle.get("radius").toString());

        JSONObject jsonRectangle= (JSONObject) job.get("2");
        rectangle.l= new Double(jsonRectangle.get("l").toString()) ;
        rectangle.b= new Double(jsonRectangle.get("b").toString());

        JSONObject jsonSquare= (JSONObject) job.get("3");
        square.side= new Double(jsonSquare.get("side").toString()) ;

        double circleArea= circle.area();
        double rectangleArea= rectangle.area();
        double squareArea= square.area();

        System.out.println("Working Fine");

        JSONObject outCircle= new JSONObject();
        outCircle.put("type","Circle");
        outCircle.put("area",circleArea);

        JSONObject outRectangle= new JSONObject();
        outRectangle.put("type","Rectangle");
        outRectangle.put("area",rectangleArea);

        JSONObject outSquare= new JSONObject();
        outSquare.put("type","square");
        outSquare.put("area",squareArea);

        JSONObject output= new JSONObject();
        output.put("1",outCircle);
        output.put("2",outRectangle);
        output.put("3",outSquare);

        FileWriter fileWriter= new FileWriter(".\\jsonFiles\\output.json");

        fileWriter.write(output.toString());
        fileWriter.flush();
        fileWriter.close();


    }
}
