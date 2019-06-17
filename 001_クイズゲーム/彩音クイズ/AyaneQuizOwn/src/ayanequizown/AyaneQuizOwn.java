/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayanequizown;

/**
 *
 * @author 猪狩 攻
 */
public class AyaneQuizOwn {

    //パラメータ設定
    //------------------------------------------------------------
    //定数
    //------------------------------------------------------------
    private static final int EXEC_MODE_QUIZ = 1; //問題モード
    private static final int EXEC_MODE_ANSWER = 2; //解答モード
    //private static final int EXEC_MODE_CHECK = 3; //チェックモード
    private static final int QUIZ_MAX = 6; //最大出題数
    //private static final int IMPUT_MAX = 3; //入力番号関数
     
    //------------------------------------------------------------
    //変数
    //------------------------------------------------------------
    private static int execMode = EXEC_MODE_QUIZ; //モード
    private static int nowQuizNum = 0; //出題数
    private static boolean loopFlg = true; //ループフラグ
    private static int inputNum = 0; //入力番号
    private static int correctTotal = 0; //正解数
    //private static int tmpInputNum = 0; //入力番号関数  
    private static int kaitouMemory1 = 0; //回答記憶1
    private static int kaitouMemory2 = 0; //回答記憶2
    private static int kaitouMemory3 = 0; //回答記憶3
    private static int kaitouMemory4 = 0; //回答記憶4
    private static int kaitouMemory5 = 0; //回答記憶5
    private static int kaitouMemory6 = 0; //回答記憶6
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //------------------------------------------------------------
        //メイン処理 ループ1 
        //------------------------------------------------------------        
        while(loopFlg){
        
        //------------------------------------------------------------
        //問題関数コール モード1
        //------------------------------------------------------------
            if(execMode == EXEC_MODE_QUIZ){ //クイズモードなら
                quizFun(nowQuizNum); //コール
                execMode = EXEC_MODE_ANSWER; //アンサーモードへ
                inputNum = scanInputDataFun(); //コールして入力番号受け取り
        
        //------------------------------------------------------------
        //解答関数コール モード2
        //------------------------------------------------------------
            }if(execMode == EXEC_MODE_ANSWER){ //アンサーモードなら
                 correctTotal = answerFun(nowQuizNum,inputNum,correctTotal); //コールと戻り値を正解合計へ。
                 execMode = EXEC_MODE_QUIZ; //クイズモードへ
            }       
        
        //------------------------------------------------------------
        //出題数チェックと増減 ループ1orループ抜け
        //------------------------------------------------------------
        nowQuizNum += 1; //出題数インクリメント
        if(nowQuizNum >= QUIZ_MAX){ //出題数が最大数以上なら 6問目終了時に6になる手筈。
            loopFlg = false; //ループ消す
        }
        } //ループ閉じ

    //------------------------------------------------------------
    //結果処理関数コール
    //------------------------------------------------------------
    resultProcessingFun();    //今回は未使用。中身空。
    //------------------------------------------------------------
    //結果表示関数コール
    //------------------------------------------------------------         
    resultPrintFun(correctTotal);
        
    } //メイン関数閉じ    
        
//【子 開始】    
    //問題関数
    private static void quizFun(int nowQuizNumSub){
        
    System.out.println(" " + (nowQuizNumSub+1) + " 問目");
    
    switch(nowQuizNumSub){    
            case 0: //1問目
                System.out.println("彩音の出身高校は？");
                System.out.println("1:加納高校  2:大垣桜高校  3:岐阜高校");
            break;
            case 1: //2問目
                System.out.println("彩音と俺の年の差は？");
                System.out.println("1:同じ  2:1つ上  3:2つ上");
            break;
            case 2: //3問目
                System.out.println("今学習している言語は？");
                System.out.println("1:swift  2:visual basic  3:java");
            break;
            case 3: //4問目
                System.out.println("彩音の名字は？");
                System.out.println("1:中根  2:中村  3:中野");
            break;
            case 4: //5問目
                System.out.println("彩音は俺をどう思っている？");
                System.out.println("1:好き  2:全て  3:嫌い");
            break;
            case 5: //6問目
                System.out.println("彩音のことをどう思っている？");
                System.out.println("1:好き  2:全て  3:嫌い");
            break;        
    } //問題選択処理終わり
    
    System.out.print("答え＞");
    
    } //問題関数終わり
    
    //キー入力関数
    private static int scanInputDataFun(){
        
    /////////////////////////////////////////////////
    //キー入力処理　ここから
        int tmpInputNum = 0;
        try{
        //初期化処理
        final int IMPUT_MAX = 3; //最大入力値
        //キー入力読込処理 (int型)
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int inputInt = sc.nextInt();
        //入力値チェックと入力番号への代入
        if(inputInt > 0 && inputInt <= IMPUT_MAX){
        tmpInputNum = inputInt;  
        }else{
            System.out.println("※  コマンドは1～3で入力して下さい  ※  ");
            System.out.println("※  入力値0として処理します。不正解とし次の問題へ移ります。  ※  ");
        }        
    }catch (Exception e){
        System.out.println("※  半角数字以外は入力しないで下さい  ※  ");
        System.out.println("※  入力値0として処理します。不正解とし次の問題へ移ります。  ※  ");
    }
    //キー入力処理 ここまで    
    /////////////////////////////////////////////////    
        
    //入力番号を返す
    return tmpInputNum;
    } //キー入力処理関数閉じ

    //解答関数
    private static int answerFun(int nowQuizNumSub,int inputNumSub,int correctTotalSub){
        switch(nowQuizNumSub){
            case 0: //1問目
                System.out.println("あなたの回答は "+inputNumSub+" です。結果は後ほど。");
                if(inputNumSub == 1){ //正解なら。正解は1。
                    correctTotalSub +=1; //正解合計をインクリメント。
                        kaitouMemory1 = 1;
                }else if(inputNumSub == 2){
                        kaitouMemory1 = 2;
                }else if(inputNumSub == 3){
                        kaitouMemory1 = 3;
                }
                return correctTotalSub; //正解合計を戻り値で返してエスケープ。コール元で加算。
            case 1: //2問目
                System.out.println("あなたの回答は "+inputNumSub+" です。結果は後ほど。");
                if(inputNumSub == 2){ //正解なら。正解は2。
                    correctTotalSub +=1; //正解合計をインクリメント。
                        kaitouMemory2 = 2;
                }else if(inputNumSub == 1){
                        kaitouMemory2 = 1;
                }else if(inputNumSub == 3){
                        kaitouMemory2 = 3;
                }
                return correctTotalSub; //正解合計を戻り値で返してエスケープ。コール元で加算。
            case 2: //3問目
                System.out.println("あなたの回答は "+inputNumSub+" です。結果は後ほど。");
                if(inputNumSub == 3){ //正解なら。正解は3。
                    correctTotalSub +=1; //正解合計をインクリメント。
                        kaitouMemory3 = 3;
                }else if(inputNumSub == 1){
                        kaitouMemory3 = 1;
                }else if(inputNumSub == 2){
                        kaitouMemory3 = 2;
                }
                return correctTotalSub; //正解合計を戻り値で返してエスケープ。コール元で加算。    
            case 3: //4問目
                System.out.println("あなたの回答は "+inputNumSub+" です。結果は後ほど。");
                if(inputNumSub == 2){ //正解なら。正解は2。
                    correctTotalSub +=1; //正解合計をインクリメント。
                        kaitouMemory4 = 2;
                }else if(inputNumSub == 1){
                        kaitouMemory4 = 1;
                }else if(inputNumSub == 3){
                        kaitouMemory4 = 3;
                }
                return correctTotalSub; //正解合計を戻り値で返してエスケープ。コール元で加算。
            case 4: //5問目
                System.out.println("あなたの回答は "+inputNumSub+" です。結果は後ほど。");
                if(inputNumSub == 2){ //正解なら。正解は2。
                    correctTotalSub +=1; //正解合計をインクリメント。
                        kaitouMemory5 = 2;
                }else if(inputNumSub == 1){
                        kaitouMemory5 = 1;
                }else if(inputNumSub == 3){
                        kaitouMemory5 = 3;
                }
                return correctTotalSub; //正解合計を戻り値で返してエスケープ。コール元で加算。
            case 5: //6問目
                System.out.println("あなたの回答は "+inputNumSub+" です。結果は後ほど。");
                if(inputNumSub == 2){ //正解なら。正解は2。
                    correctTotalSub +=1; //正解合計をインクリメント。
                        kaitouMemory6 = 2;
                }else if(inputNumSub == 1){
                        kaitouMemory6 = 1;
                }else if(inputNumSub == 3){
                        kaitouMemory6 = 3;
                }
                return correctTotalSub; //正解合計を戻り値で返してエスケープ。コール元で加算。    
        
        } //選択処理終わり
        return correctTotalSub; //調整用エスケープ。使うことはないステップ。 
    } //解答関数閉じ
    
    //結果処理関数　　今回は未使用。中身空。
    private static void resultProcessingFun(){       
    }
    
    //結果表示関数
    private static void resultPrintFun(int correctTotalSub){
    System.out.println("");
    System.out.println("--------------------------------------------------");
    System.out.println(" ～結果発表～ ");
    System.out.println("");
    System.out.println("あなたの選んだ回答と○か×かが表示されます！");
    System.out.println("");
    
    System.out.println(" 1 問目");
    System.out.print("あなたの選んだ回答 : " +kaitouMemory1);
    if(kaitouMemory1 == 1){
        System.out.println("   ○");
    }else{
        System.out.println("   ×");    
    }
    
    System.out.println(" 2 問目");
    System.out.print("あなたの選んだ回答 : " +kaitouMemory2);
    if(kaitouMemory2 == 2){
        System.out.println("   ○");
    }else{
        System.out.println("   ×");    
    }
    
    System.out.println(" 3 問目");
    System.out.print("あなたの選んだ回答 : " +kaitouMemory3);
    if(kaitouMemory3 == 3){
        System.out.println("   ○");
    }else{
        System.out.println("   ×");    
    }
    
    System.out.println(" 4 問目");
    System.out.print("あなたの選んだ回答 : " +kaitouMemory4);
    if(kaitouMemory4 == 2){
        System.out.println("   ○");
    }else{
        System.out.println("   ×");    
    }
    
    System.out.println(" 5 問目");
    System.out.print("あなたの選んだ回答 : " +kaitouMemory5);
    if(kaitouMemory5 == 2){
        System.out.println("   ○");
    }else{
        System.out.println("   ×");    
    }
    
    System.out.println(" 6 問目");
    System.out.print("あなたの選んだ回答 : " +kaitouMemory6);
    if(kaitouMemory6 == 2){
        System.out.println("   ○");
    }else{
        System.out.println("   ×");    
    }
    
    System.out.println("");
    System.out.println("あなたの正解数は" + correctTotalSub + "でした。");
    
    double seikairitsuD = 0; //正解率変数をダブルで宣言と初期化。
        seikairitsuD = ((double)correctTotalSub/QUIZ_MAX*100); //正解数を出題数で割って×100 で%を求める。
    System.out.println("あなたの正解率は" + Math.round(seikairitsuD) + "%でした。"); //四捨五入で表示。
    
    System.out.println("");
    System.out.println("おつかれさまでした！");
    System.out.println("");
    
    } //結果表示関数閉じ    
//【子 終了】
    
} //クラス閉じ
