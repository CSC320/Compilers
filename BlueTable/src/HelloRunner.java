import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.*;
    import org.antlr.v4.runtime.tree.*;
    public class HelloRunner 
    {
        public static void main( String[] args) throws Exception 
        {

            ANTLRFileStream input = new ANTLRFileStream("oj_2.txt");
            System.out.print(input);
            GrammarCSVLexer lexer = new GrammarCSVLexer(input);

            CommonTokenStream tokens = new CommonTokenStream(lexer);

            GrammarCSVParser parser = new GrammarCSVParser(tokens);
            ParseTree tree = parser.r(); // begin parsing at rule 'r'
            System.out.println(tree.toStringTree(parser)); // print LISP-style tree
            int error = parser.getNumberOfSyntaxErrors();
            if(error > 0){
            	System.out.println("Error Occurred");
            }else{
            	System.out.println("Nice!");
            	System.out.println(input.toString());
				Antler_Command_Parser commandParser = new Antler_Command_Parser(input.toString()); 
            	//show AST in GUI
                JFrame frame = new JFrame("Antlr AST");
                JPanel panel = new JPanel();
                TreeViewer viewr = new TreeViewer(Arrays.asList(
                        parser.getRuleNames()),tree);
                viewr.setScale(1.5);//scale a little
                panel.add(viewr);
                frame.add(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(200,200);
                frame.setVisible(true);
            }
                  
        }
}