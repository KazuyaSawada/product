/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayanetxtadvencher;

/**
 *
 * @author 猪狩 攻
 */
public class ATAMain {
    
        //パラメータ設定
    //------------------------------------------------------------
    //定数
    //------------------------------------------------------------
   
    //------------------------------------------------------------
    //変数
    //------------------------------------------------------------
    private static int sceneNunmber = 0; //部屋番号(1:入口 2:廊下 3:寝室)
    private static int actNumber = 0; //行動リスト(1:移動 2:見る 3:使う)
    private static int targetGroup = 0; //対象グループ関数の管理番号(1～9)
    private static int targetNumber1 = 0; //対象リスト(1～5 表示用)
    private static int targetNumber2 = 0; //対象リスト(1～5 処理用)
    private static boolean passwordNumberFlg1 = false; //暗証番号フラグ1
    private static boolean passwordNumberFlg2 = false; //暗証番号フラグ2
    private static boolean passwordNumberFlg3 = false; //暗証番号フラグ3
    private static boolean keyFlg1 = false; //鍵フラグ1
    private static boolean keyFlg2 = false; //鍵フラグ2
    private static boolean keyFlg3 = false; //鍵フラグ3
    private static boolean keyFlg4 = false; //鍵フラグ4
    private static boolean bomberFlg1 = false; //爆弾フラグ1
    private static boolean tableFlg1 = false; //テーブルフラグ1
    private static boolean tableFlg2 = false; //テーブルフラグ2
    private static boolean edFlg = false; //エンディングフラグ ≒ ループフラグ
    private static boolean missFlg = false; //誤入力フラグ
    private static boolean useFlg = false; //アイテムゲット済みフラグ
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //オープニング代用
        System.out.println("～オープニング～");
        System.out.println("閉じ込められた！脱出しよう！");
        System.out.println("");
        System.out.println("**************************************************");
        System.out.println("※注意1※  コマンドは半角1～5で入力して下さい  ");
        System.out.println("※注意2※  必ず選択肢の中から選んで下さい  ");
        System.out.println("**************************************************");
        System.out.println("");
        sceneNunmber = 1; //部屋番号1：入口でスタート
        
        //ループ頭
        while(!edFlg){
        
        //部屋番号チェックして現在の部屋を表示
        if(sceneNunmber == 1){
            System.out.println("現在入口の部屋にいます");
            System.out.println("どうしますか？");
        }else if(sceneNunmber == 2){
            System.out.println("現在廊下にいます");
            System.out.println("どうしますか？");
        }else if(sceneNunmber == 3){
            System.out.println("現在寝室にいます");
            System.out.println("どうしますか？");
        }else{
            sceneNunmber = 3;
            System.out.println("寝室のベッドで目覚めた"); //夢落ち逃げ基本未使用。
        }
        
        //行動リストを表示
        System.out.println("");
        System.out.println("1:移動");
        System.out.println("2:見る");
        System.out.println("3:使う");
        System.out.print("選んでください＞");
        
        //前回処理の残り分を初期化。actNumber。
        actNumber = 0;
        
        //キー入力関数コールしてactNumberへ代入。        
        actNumber = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("**************************************************");
            System.out.println("言うことを聞きなさい");
            System.out.println("**************************************************");
            System.out.println("");
            System.out.println("1:移動");
            System.out.println("2:見る");
            System.out.println("3:使う");
            System.out.print("選んでください＞");
            actNumber = scanInputDataFun(); //再度コールして入力番号受け取り
        }    
        //missFlg = false; //入力関数の頭でフラグを毎回消す。
        
        //前回処理の残り分を初期化。targetGroup。
        targetGroup = 0;
        
        //sceneNunmberとactNumberからtargetGroupを割り出し。
        switch(sceneNunmber){
            case 1: //部屋が入口
                if(actNumber == 1){ //行動が移動
                    targetGroup = 1; //グループ1へ割り振り
                }else if(actNumber == 2){ //行動が見る
                    targetGroup = 2; //グループ2へ割り振り
                }else if(actNumber == 3){ //行動が使う
                    targetGroup = 3; //グループ3へ割り振り
                }
            break;
            case 2: //部屋が廊下
                if(actNumber == 1){ //行動が移動
                    targetGroup = 4; //グループ4へ割り振り
                }else if(actNumber == 2){ //行動が見る
                    targetGroup = 5; //グループ5へ割り振り
                }else if(actNumber == 3){ //行動が使う
                    targetGroup = 6; //グループ6へ割り振り
                }
            break;
            case 3: //部屋が寝室
                if(actNumber == 1){ //行動が移動
                    targetGroup = 7; //グループ7へ割り振り
                }else if(actNumber == 2){ //行動が見る
                    targetGroup = 8; //グループ8へ割り振り
                }else if(actNumber == 3){ //行動が使う
                    targetGroup = 9; //グループ9へ割り振り
                }
            break;
        } //switch(sceneNunmber) 閉じ
        
        System.out.println(""); //行動コマンドと対象コマンドの間の行間
                                        
        //targetGroup参照して対象グループ関数をコール。
        switch(targetGroup){
            case 1: //入口・移動
                targetGroupFun1();
            break;
            case 2: //入口・見る
                targetGroupFun2();
            break;
            case 3: //入口・使う
                targetGroupFun3();
            break;
            case 4: //廊下・移動
                targetGroupFun4();
            break;
            case 5: //廊下・見る
                targetGroupFun5();
            break;
            case 6: //廊下・使う
                targetGroupFun6();
            break;
            case 7: //寝室・移動
                targetGroupFun7();
            break;
            case 8: //寝室・見る
                targetGroupFun8();
            break;
            case 9: //寝室・使う
                targetGroupFun9();
            break;
         } //switch(targetGroup) 閉じ
                
        } //ループ閉じ
        
        //エンディング代用
        System.out.println("");
        System.out.println("～エンディング～");
        System.out.println("無事脱出できました！終わり！");
        
    } //メイン閉じ
    
    //【子開始】
    
    //キー入力処理関数
     private static int scanInputDataFun(){
        
    /////////////////////////////////////////////////
    //キー入力処理　ここから
        int tmpInputNum = 0;
        missFlg = false;
        try{
        //初期化処理
        final int IMPUT_MAX = 5; //最大入力値
        //キー入力読込処理 (int型)
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int inputInt = sc.nextInt();
        //入力値チェックと入力番号への代入
        if(inputInt > 0 && inputInt <= IMPUT_MAX){
        tmpInputNum = inputInt;  
        }else{
            System.out.println("※  コマンドは1～5で入力して下さい  ※  ");
            System.out.println("※  入力値0として処理します。さあどうなるでしょうか？？  ※  ");
            missFlg = true;
        }        
    }catch (Exception e){
        System.out.println("※  半角数字以外は入力しないで下さい  ※  ");
        System.out.println("※  入力値0として処理します。さあどうなるでしょうか？？  ※  ");
        missFlg = true;
    }
    //キー入力処理 ここまで    
    /////////////////////////////////////////////////    
        
    //入力番号を返す
    return tmpInputNum;
    } //キー入力処理関数閉じ
     
    //対象グループ関数1
     private static void targetGroupFun1(){
        System.out.println("1:入口");
        System.out.println("2:廊下");
        System.out.println("3:寝室");
        System.out.print("選んでください＞");
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            System.out.println("1:入口");
            System.out.println("2:廊下");
            System.out.println("3:寝室");
            System.out.print("選んでください＞");
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }    
        switch(targetNumber2){
            case 1:
                System.out.println("--------------------------------------------------");
                System.out.println("今いる場所です。");
                System.out.println("--------------------------------------------------");
            break;
            case 2:
                System.out.println("--------------------------------------------------");
                System.out.println("廊下に移動します。");
                System.out.println("--------------------------------------------------");
                sceneNunmber = 2;
            break;
            case 3:
                System.out.println("--------------------------------------------------");
                System.out.println("寝室に移動します。");
                System.out.println("--------------------------------------------------");
                sceneNunmber = 3;
            break;
            case 4:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 5:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
        } //switch(targetNumber2)閉じ
    
     } //関数1閉じ
     
    //対象グループ関数2
     private static void targetGroupFun2(){
        System.out.println("1:ドア");
        System.out.print("選んでください＞");
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            System.out.println("1:ドア");
            System.out.print("選んでください＞");
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }    
        switch(targetNumber2){
            case 1:
                System.out.println("--------------------------------------------------");
                System.out.println("普通のドアです。開かない。");
                System.out.println("--------------------------------------------------");
            break;
            case 2:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 3:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 4:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 5:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
        } //switch(targetNumber2)閉じ
    
     } //関数2閉じ 
     
    //対象グループ関数3
     private static void targetGroupFun3(){
        if(useFlg){
            if(passwordNumberFlg2 & !keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.print("選んでください＞");
            }else if(!passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("4:鍵");
                System.out.print("選んでください＞");
            }else if(passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.print("選んでください＞");               
            }else if(passwordNumberFlg2 & keyFlg1 & bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.println("5:爆弾");
                System.out.print("選んでください＞");                    
            } //if(useFlg)last else 閉じ
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            if(passwordNumberFlg2 & !keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.print("選んでください＞");
            }else if(!passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("4:鍵");
                System.out.print("選んでください＞");
            }else if(passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.print("選んでください＞");               
            }else if(passwordNumberFlg2 & keyFlg1 & bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.println("5:爆弾");
                System.out.print("選んでください＞");                    
            } //if(useFlg)last else 閉じ
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }   //while(missFlg){ //誤入力した場合の処理終わり
        
        switch(targetNumber2){
            case 1:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("使えません。");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 2:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("使えません。");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 3:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("使えません。");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 4:
                if(keyFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("ドアの鍵穴には入らない。別の鍵のようだ。");
                    System.out.println("--------------------------------------------------");
                    keyFlg2 = true;
                }else if(!keyFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 5:
                if(bomberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("爆弾でドアを吹き飛ばした。無事脱出できました。");
                    System.out.println("--------------------------------------------------");
                    edFlg = true;
                }else if(!bomberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            
        } //switch(targetNumber2)閉じ
        
        }else { //if(useFlg)閉じ
            System.out.println("--------------------------------------------------");
            System.out.println("使うものを持っていない");
            System.out.println("--------------------------------------------------");
        } //if(useFlg)else閉じ
        
     } //関数3閉じ  
     
    //対象グループ関数4
     private static void targetGroupFun4(){
        System.out.println("1:入口");
        System.out.println("2:廊下");
        System.out.println("3:寝室");
        System.out.print("選んでください＞");
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            System.out.println("1:入口");
            System.out.println("2:廊下");
            System.out.println("3:寝室");
            System.out.print("選んでください＞");
            
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }    
        switch(targetNumber2){
            case 1:
                System.out.println("--------------------------------------------------");
                System.out.println("入口に移動します。");
                System.out.println("--------------------------------------------------");
                sceneNunmber = 1;
            break;
            case 2:
                System.out.println("--------------------------------------------------");
                System.out.println("今いる場所です。");
                System.out.println("--------------------------------------------------");
            break;
            case 3:
                System.out.println("--------------------------------------------------");
                System.out.println("寝室に移動します。");
                System.out.println("--------------------------------------------------");
                sceneNunmber = 3;
            break;
            case 4:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 5:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
        } //switch(targetNumber2)閉じ
    
     } //関数4閉じ 
     
    //対象グループ関数5
     private static void targetGroupFun5(){
        System.out.println("1:窓");
        System.out.println("2:絵画");
        System.out.print("選んでください＞");
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            System.out.println("1:窓");
            System.out.println("2:絵画");
            System.out.print("選んでください＞");
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }    
        switch(targetNumber2){
            case 1:
                System.out.println("--------------------------------------------------");
                System.out.println("何かあればここから脱出できそうだ。");
                System.out.println("--------------------------------------------------");
            break;
            case 2:
                System.out.println("--------------------------------------------------");
                System.out.println("隅っこに謎の番号が書かれている。『3156』。");
                System.out.println("--------------------------------------------------");
                passwordNumberFlg1 = true;
            break;
            case 3:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 4:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 5:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
        } //switch(targetNumber2)閉じ
    
     } //関数5閉じ  
     
    //対象グループ関数6
     private static void targetGroupFun6(){
        if(useFlg){
            if(passwordNumberFlg2 & !keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.print("選んでください＞");
            }else if(!passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("4:鍵");
                System.out.print("選んでください＞");
            }else if(passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.print("選んでください＞");               
            }else if(passwordNumberFlg2 & keyFlg1 & bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.println("5:爆弾");
                System.out.print("選んでください＞");                    
            } //if(useFlg)last else 閉じ
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            if(passwordNumberFlg2 & !keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.print("選んでください＞");
            }else if(!passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("4:鍵");
                System.out.print("選んでください＞");
            }else if(passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.print("選んでください＞");               
            }else if(passwordNumberFlg2 & keyFlg1 & bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.println("5:爆弾");
                System.out.print("選んでください＞");                    
            } //if(useFlg)last else 閉じ
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }   //while(missFlg){ //誤入力した場合の処理終わり
        
        switch(targetNumber2){
            case 1:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("使えません。");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 2:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("使えません。");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 3:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("使えません。");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 4:
                if(keyFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("ここには鍵を使うものがない。");
                    System.out.println("--------------------------------------------------");
                }else if(!keyFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 5:
                if(bomberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("爆弾を使ってみた。何か変化はあるかな？");
                    System.out.println("--------------------------------------------------");
                }else if(!bomberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            
        } //switch(targetNumber2)閉じ
        
        }else { //if(useFlg)閉じ
            System.out.println("--------------------------------------------------");
            System.out.println("使うものを持っていない");
            System.out.println("--------------------------------------------------");
        } //if(useFlg)else閉じ
        
     } //関数6閉じ 
     
    //対象グループ関数7
     private static void targetGroupFun7(){
        System.out.println("1:入口");
        System.out.println("2:廊下");
        System.out.println("3:寝室");
        System.out.print("選んでください＞");
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            System.out.println("1:入口");
            System.out.println("2:廊下");
            System.out.println("3:寝室");
            System.out.print("選んでください＞");
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }    
        switch(targetNumber2){
            case 1:
                System.out.println("--------------------------------------------------");
                System.out.println("入口に移動します。");
                System.out.println("--------------------------------------------------");
                sceneNunmber = 1;
            break;
            case 2:
                System.out.println("--------------------------------------------------");
                System.out.println("廊下に移動します。");
                System.out.println("--------------------------------------------------");
                sceneNunmber = 2;
            break;
            case 3:
                System.out.println("--------------------------------------------------");
                System.out.println("今いる場所です。");
                System.out.println("--------------------------------------------------");
            break;
            case 4:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 5:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
        } //switch(targetNumber2)閉じ
    
     } //関数7閉じ 
     
    //対象グループ関数8
     private static void targetGroupFun8(){
        System.out.println("1:ベッド");
        System.out.println("2:テーブル");
        System.out.println("3:金庫");
        System.out.print("選んでください＞");
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            System.out.println("1:ベッド");
            System.out.println("2:テーブル");
            System.out.println("3:金庫");
            System.out.print("選んでください＞");
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }    
        switch(targetNumber2){
            case 1:
                System.out.println("--------------------------------------------------");
                System.out.println("大きなベッドです。(昔お父さんが金庫の中に何かしまってた気がする…)");
                System.out.println("--------------------------------------------------");
            break;
            case 2:
                if(!tableFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("何もないテーブルです。");
                    System.out.println("--------------------------------------------------");
                    tableFlg1 = true;
                }else if(tableFlg1 & !tableFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("あ、そう言えば…。");
                    System.out.println("--------------------------------------------------");
                    tableFlg2 = true;
                }else if(tableFlg1 & tableFlg2 & !keyFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("鍵を見つけた。");
                    System.out.println("--------------------------------------------------");
                    keyFlg1 = true;
                    useFlg = true;
                }else if(tableFlg1 & tableFlg2 & keyFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("さっきの鍵以外には何もない。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 3:
                if(!passwordNumberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("暗証番号が必要だ。");
                    System.out.println("--------------------------------------------------");
                }else if(passwordNumberFlg1 & !passwordNumberFlg3){
                    System.out.println("--------------------------------------------------");
                    System.out.println("そうだ、さっきの番号…。");
                    System.out.println("--------------------------------------------------");
                    passwordNumberFlg2 = true;
                    useFlg = true;
                }else if(passwordNumberFlg3 & !keyFlg2){ 
                    System.out.println("--------------------------------------------------");
                    System.out.println("大きい金庫の中にもう1つ小さい金庫があるが開かない。");      
                    System.out.println("--------------------------------------------------");
                }else if(passwordNumberFlg3 & keyFlg2 & !keyFlg4){ 
                    System.out.println("--------------------------------------------------");
                    System.out.println("大きい金庫の裏側に鍵穴があるのを発見。");
                    System.out.println("--------------------------------------------------");
                    keyFlg3 = true;
                }else if(keyFlg4 & !bomberFlg1){ //5:(kF4がon&bF1がoffなら)bomberFlg1取得。
                    System.out.println("--------------------------------------------------");
                    System.out.println("爆弾を見つけた。何回でも使用できそうだ。");
                    System.out.println("--------------------------------------------------");
                    bomberFlg1 = true;
                }else if(keyFlg4 & bomberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("さっきの爆弾以外には何もない。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 4:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
            case 5:
                System.out.println("--------------------------------------------------");
                System.out.println("しまった！ぼ～っとしていた。。。");
                System.out.println("--------------------------------------------------");
            break;
        } //switch(targetNumber2)閉じ
    
     } //関数8閉じ 
     
    //対象グループ関数9
     private static void targetGroupFun9(){
        if(useFlg){
            if(passwordNumberFlg2 & !keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.print("選んでください＞");
            }else if(!passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("4:鍵");
                System.out.print("選んでください＞");
            }else if(passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.print("選んでください＞");               
            }else if(passwordNumberFlg2 & keyFlg1 & bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.println("5:爆弾");
                System.out.print("選んでください＞");                    
            } //if(useFlg)last else 閉じ
        
    //キー入力関数コールしてtargetNumber2へ代入。        
        targetNumber2 = scanInputDataFun(); //コールして入力番号受け取り
        while(missFlg){ //誤入力した場合の処理
            System.out.println("--------------------------------------------------");
            System.out.println("言うことを聞きなさい");
            System.out.println("--------------------------------------------------");
            if(passwordNumberFlg2 & !keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.print("選んでください＞");
            }else if(!passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("4:鍵");
                System.out.print("選んでください＞");
            }else if(passwordNumberFlg2 & keyFlg1 & !bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.print("選んでください＞");               
            }else if(passwordNumberFlg2 & keyFlg1 & bomberFlg1){
                System.out.println("1:暗証番号1(5963)");
                System.out.println("2:暗証番号2(3156)");
                System.out.println("3:暗証番号3(3150)");
                System.out.println("4:鍵");
                System.out.println("5:爆弾");
                System.out.print("選んでください＞");                    
            } //if(useFlg)last else 閉じ
            targetNumber2 = scanInputDataFun(); //再度コールして入力番号受け取り
        }   //while(!missFlg){ //誤入力した場合の処理終わり
        
        switch(targetNumber2){
            case 1:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("番号が違うのかな？");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 2:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("金庫が開いた。確認してみよう。");
                    System.out.println("--------------------------------------------------");
                    passwordNumberFlg3 = true;                   
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 3:
                if(passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("番号が違うのかな？");
                    System.out.println("--------------------------------------------------");
                }else if(!passwordNumberFlg2){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 4:
                if(keyFlg1 & !keyFlg3){
                    System.out.println("--------------------------------------------------");
                    System.out.println("ここには鍵を使うものがない。");
                    System.out.println("--------------------------------------------------");
                }else if(keyFlg1 & keyFlg3){
                    System.out.println("--------------------------------------------------");
                    System.out.println("小さい金庫が開いた。連動して動く仕組みのようだ。確認してみよう。");
                    System.out.println("--------------------------------------------------");
                    keyFlg4 = true;
                }else if(!keyFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            case 5:
                if(bomberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("爆弾を使ってみた。何か変化はあるかな？");
                    System.out.println("--------------------------------------------------");
                }else if(!bomberFlg1){
                    System.out.println("--------------------------------------------------");
                    System.out.println("しまった！ぼ～っとしていた。。。");
                    System.out.println("--------------------------------------------------");
                }
            break;
            
        } //switch(targetNumber2)閉じ
        
        }else { //if(useFlg)閉じ
            System.out.println("--------------------------------------------------");
            System.out.println("使うものを持っていない");
            System.out.println("--------------------------------------------------");
        } //if(useFlg)else閉じ
        
     } //関数9閉じ       
     
    //【子終了】
     
} //12ステップ クラス閉じ
