public class Block {
    public String type;
    public String name;
    public String SID;

    String [][] properties = new String [10][2];
    public void print()
    {
                System.out.println(type);
                System.out.println(name);
                System.out.println(SID);

                for (int i = 0; i < properties.length; i++) { //this equals to the row in our matrix.
                    for (int j = 0; j < properties[i].length; j++) { //this equals to the column in each row.
                       System.out.print(properties[i][j] + " ");
                    }
                    System.out.println(); //change line on console as row comes to end in the matrix.
                 }
    }
}
