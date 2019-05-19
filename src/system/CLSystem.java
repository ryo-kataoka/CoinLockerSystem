package system;

public class CLSystem {
    CoinLocker[] A = new CoinLocker[40];     //A社のコインロッカー
    CoinLocker[] B = new CoinLocker[80];     //B社のコインロッカー

    int amountA;                //A社の売上
    int amountB;                //B社の売上

	CLSystem(){
	    //コインロッカーの初期化
	    for(int i=0;i<40;i++) A[i] = new CoinLocker();
	    for(int i=0;i<80;i++) B[i] = new CoinLocker();

	    //売り上げの初期化
	    amountA = 0;
	    amountB = 0;
	}

	//A社の料金システム(方針Cの場合)
	int funcA(int T){
		if(T<4) return 250;
		else return 250+100*(T-3);
	}
	//B社の料金システム
	int funcB(int T) {
		if(T<13) return 300;
		else return 600;
	}

	//A社のコインロッカーの空きを探す
	boolean searchA(int n,int u) {
		int c = 0;
		int[] x= new int[3];
		for(int i=0;i<40;i++) {
			if(!A[i].isUsed) {
				x[c]=i;
				c++;
				n--;
			}
			if(n==0) break;
		}
		if(n!=0) {
			return false;
		}else {
			for(int i=0;i<c;i++) {
				int t = x[i];
				A[t].isUsed = true;
				A[t].Utime = u * 60;
				amountA += funcA(u);
				//System.out.print("A's CoinLocker is used. Fee:"+funcA(u)+" yen, Utilization time:"+u+"[h]\n");
			}
			return true;
		}

	}

	//B社のコインロッカーの空きを探す
	boolean searchB(int n,int u) {
		int c = 0;
		int[] x= new int[3];
		for(int i=0;i<80;i++) {
			if(!B[i].isUsed) {
				x[c]=i;
				c++;
				n--;
			}
			if(n==0) break;
		}
		if(n!=0) {
			return false;
		}else {
			for(int i=0;i<c;i++) {
				int t = x[i];
				B[t].isUsed = true;
				B[t].Utime = u * 60;
				amountB += funcB(u);
				//System.out.print("B's CoinLocker is used. Fee:"+funcB(u)+" yen, Utilization time:"+u+"[h]\n");
			}
			return true;
		}

	}

	//物が入っているコインロッカーに時間の経過を伝える
	void Time() {
		for(int i=0;i<40;i++) {
			if(A[i].isUsed) {
				A[i].moveTime();
			}
		}
		for(int i=0;i<80;i++) {
			if(B[i].isUsed) {
				B[i].moveTime();
			}
		}
	}
}