import org.w3c.dom.Document;

import java.io.IOException;
import java.io.File;
public class App {
    public static void main(String[] args) throws Exception {
        Document doc = MDLFile.readFile("C:\\Users\\xtreme\\Downloads\\Example.mdl");
        Block [] blocks= MDLFile.assembleBlocks(doc);
        Line[] lines = MDLFile.assembleLines(doc);

for(int i=0 ;i<blocks.length;i++){blocks[i].print();
    System.out.println("This block is done");}
for(int i=0 ;i<lines.length;i++){lines[i].print();
    System.out.println("This line is done");}


    }
}
