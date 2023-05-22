import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Pane p = new BlockPane();
        Pane L = new ConnectorPane();
        Pane main = new Pane(p,L);
        Scene sc = new Scene(main,500,500);
        primaryStage.setTitle("View Shapes");               
        primaryStage.setScene(sc);
        primaryStage.show();    }
        public static void main(String[] args)
        {
            System.out.println("Launching App");
            launch(args);
        }
}
class ConnectorPane extends Pane{
    public ConnectorPane(){
        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(new Double[]{
            0.0, 0.0,
            0.0, 204.0,
            775.0, 204.0 } );
        polyline.setStroke(Color.BLACK);
        Polyline branch = new Polyline();
        branch.getPoints().addAll(new Double[]{
            750.0, 204.0,
            750.0, 214.0,
            775.0, 214.0 } );
        polyline.setStroke(Color.BLACK);
       CreateArrowHead(775,204 );
        CreateArrowHead(775,214);
            DropShadow shadow = new DropShadow();
        shadow.setColor(Color.BLUE);
        shadow.setRadius(10); // Set the shadow radius to 10 pixels
        polyline.setEffect(shadow);
        branch.setEffect(shadow);

        // Add the Line and arrowhead to the root Pane
        this.getChildren().addAll(branch,polyline);
    }
    
    public void CreateArrowHead(int endx, int endy)
    {
        double arrowLength = 8;
        double arrowWidth = 8;
        // Add arrowheads to the line

        double angle = Math.atan2(0, endx) - Math.PI / 2.0;

        // Create the arrowhead polygon
        Polygon arrowhead = new Polygon();
        arrowhead.getPoints().addAll(
            0.0, 0.0,
            -arrowWidth / 2.0, arrowLength,
            arrowWidth / 2.0, arrowLength
        );

        arrowhead.setFill(Color.BLACK);

        // Translate and rotate the arrowhead to the end of the line
        arrowhead.setTranslateX(endx);
        arrowhead.setTranslateY(endy-arrowWidth/2);
    
        arrowhead.setRotate(3*angle * 180 / Math.PI);
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.BLUE);
        shadow.setRadius(10); // Set the shadow radius to 10 pixels
        arrowhead.setEffect(shadow);
        this.getChildren().add(arrowhead);
    }
}

class BlockPane extends Pane
{

    // public BlockPane(){

    // }
    public BlockPane()
    {
        
        Rectangle r = new Rectangle(780, 200, 30, 30);
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.BLUE);
        shadow.setRadius(10); // Set the shadow radius to 10 pixels
        r.setEffect(shadow);
        this.getChildren().add(r);

        Text plus = new Text(780 + 2,208 ,"+");
        plus.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        plus.setFill(Color.BLACK);
        this.getChildren().add(plus);
        Text plus2 = new Text(780 + 2,218 ,"+");
        plus2.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        plus2.setFill(Color.BLACK);
        this.getChildren().add(plus2);
        Text plus3 = new Text(780 + 2,228 ,"+");
        plus3.setFont(Font.font("Arial", FontWeight.BOLD, 10));
        plus3.setFill(Color.BLACK);
        this.getChildren().add(plus3);


        Text r_txt = new Text(780, 240, "Block \nname");
        r_txt.setFill(Color.BLACK);
        r_txt.setFont(Font.font("Arial", FontWeight.THIN, 10));
        this.getChildren().add(r_txt);
    }
    
}
