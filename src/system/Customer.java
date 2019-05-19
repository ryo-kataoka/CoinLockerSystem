package system;

public class Customer {
	int Utime;                        //利用時間
	int N;                          //必要個数
	int M;                          //最大支払可能額

	CLSystem S;

	Customer(CLSystem s){
		//顧客の属性値をそれぞれ生成
		Utime = (int)(Math.random() * 24) + 1;               //1～24までの整数をランダムで生成
		N = (int)(Math.random() * 3) + 1;                    //1～3までの整数をランダムで生成
		switch((int)(Math.random() * 3)) {                  //0～2まで整数をランダム生成
		case 0:
			M = 1000;
			break;
		case 1:
			M = 1500;
			break;
		case 2:
			M = 2000;
			break;
		}

		S = s;
	}

	//顧客の行動関数
	void act(){
		//A社のコインロッカーの方が安い場合
		if(S.funcA(Utime) < S.funcB(Utime)) {
			if(S.searchA(N,Utime)) return;
			else if(S.funcB(Utime) < M && S.searchB(N,Utime)) return;
			return;
		//B社のコインロッカーの方が安い場合
		}else if(S.funcA(Utime) > S.funcB(Utime)) {
			if(S.searchB(N,Utime)) return;
			else if(S.funcA(Utime) < M && S.searchA(N,Utime)) return;
			return;
		//A社,B社が同じ価格だった場合
		}else {
			 switch((int)(Math.random() * 2)) {              //乱数生成(0 or 1)
			 case 0:
				 if(S.searchA(N,Utime)) return;
					else if(S.funcB(Utime) < M && S.searchB(N,Utime)) return;
					return;
			 case 1:
				 if(S.searchB(N,Utime)) return;
					else if(S.funcA(Utime) < M && S.searchA(N,Utime)) return;
					return;
			 }
		}
	}
}
