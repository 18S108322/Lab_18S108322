public class PlayingChess{	
   private boolean ifContain(int [] array){
      for(int i=0;i<legalMoveSet.size();i++){
         int [] temp=(int [])legalMoveSet.get(i);
         if(temp[0]==array[0]&&temp[1]==array[1])
            return true;
      }
      return false;
   }
   private void printMove(){
      column=column+'a';
      char a=(char)column;
      System.out.print(a);
      row=8-row;
      System.out.print(row);
      dColumn=dColumn+'a';
      char b=(char)dColumn;
      System.out.print(b);
      dRow=8-dRow;
      System.out.print(dRow);
      System.out.println();    
   }
   private boolean getInput(){
      String input="";    
      try{
       input="";
         char c;
         while((c= (char)System.in.read())!='\n'){
            input+=c;
         }
      }  catch (Exception e){
         e.printStackTrace();
         System.exit(1);
        }  
      if(input.length()!=5)
          return false;
      else     
         return  switchInput(input);
     }
    private boolean switchInput(String input){
       column=(int)input.charAt(0)-'a';
       row=8-((int)input.charAt(1)-48);
       dColumn=(int)input.charAt(2)-'a';
       dRow=8-((int)input.charAt(3)-48);     
       if (row>7||row<0||column>7||column<0||dRow>7||dRow<0||dColumn<0||dColumn>7)
            return false;
       else
         return true;
   } 
   private boolean checkInput(){ 
         if(chessBoard.board[row][column]==null)
            return false;
         if (row==dRow&&column==dColumn)
            return false;
         if(chessBoard.board[row][column]==null)
            return false;
         if (row>7||row<0||column>7||column<0||dRow>7||dRow<0||dColumn<0||dColumn>7)
            return false;
 if((count%2==0&&chessBoard.board[row][column].color=='b')||(count%2==1&&chessBoard.board[row][column].color=='w'))
            return false;    
      }
   public boolean status(){
      int temp=0;
       for(int row=0;row<8;row++){
         for(int column=0;column<8;column++){
            if (chessBoard.board[row][column]==null)
               continue;
            if (chessBoard.board[row][column].symbol()=='k'||chessBoard.board[row][column].symbol()=='K')
               temp++;
         }
      }    
      if (temp>1)
         return true;  
      else
         return false;
   }
   private void finish(){
      for(int row=0;row<8;row++){
         for(int column=0;column<8;column++){
            if (chessBoard.board[row][column]==null)
               continue;
            if (chessBoard.board[row][column].symbol()=='k')
               System.out.println("Black wins!");
            if (chessBoard.board[row][column].symbol()=='K') 
               System.out.println("White wins!");
         }
      }    
   }
     public static void main(String[] arg0){
     ChessGame game = new ChessGame();
     game.setUpGame(arg0);
     game.startPlaying();
     }
}
