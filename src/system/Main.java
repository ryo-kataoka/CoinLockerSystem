package system;

public class Main {

	public static void main(String[] args) {
		int day;              //経過日数
		int hour;             //時刻(時間)
		int min;              //時刻(分)

		//平均到着率(1時間区切り)
		double [] rambda = {0.0152,
				             0,
				             0,
				             0,
				             0,
				             0,
				             0.00506,
				             0.0456,
				             0.167,
				             0.101,
				             0.0557,
				             0.043,
				             0.043,
				             0.0506,
				             0.0456,
				             0.0405,
				             0.038,
				             0.043,
				             0.0861,
				             0.0759,
				             0.0532,
				             0.0405,
				             0.0304,
				             0.0203};


		CLSystem s = new CLSystem();              //コインロッカーのマネージャーを生成

		for(day=0;day<30;day++) {
			for(hour=0;hour<24;hour++) {
				for(min=0;min<60;min++) {
					double t = Math.random();           //乱数生成(0から1)
					if(t < rambda[hour]) {
						Customer c = new Customer(s);
						//System.out.print("A customer appeared. day:"+(day+1)+",time:("+hour+":"+min+")\n");
						c.act();
					}
					s.Time();                 //コインロッカーのマネージャーに時間の経過(1分)を伝える
				}
			}
		}
		System.out.print("A社の総売り上げ:"+s.amountA+"円\n");
		//System.out.print("B社の総売り上げ:"+s.amountB+"円\n");
	}
}
