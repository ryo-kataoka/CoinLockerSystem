package system;

public class CoinLocker {
	boolean isUsed;                        //使用済みならtrue,そうでないならfalse
	int Utime;                    //利用時間(分)
	int Etime;                   //経過時間(分)

	CoinLocker(){
		isUsed = false;
		Utime = 0;
		Etime = 0;
	}
	//時間を進める
	void moveTime() {
		Etime++;
		//利用時間が経過した場合
		if(Utime==Etime) {
			isUsed = false;
			Utime = 0;
			Etime = 0;
		}
	}
}
