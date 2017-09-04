package graph;

public class Message {
	
	public String getMessage(int i){
		String message=null;
		switch (i) {
		case 0:
			message="根节点";
			break;
		case 1:		
			message="是否非跨账单";
			break;
		case 2:		
			message="是否有定向流量包";
			break;
		case 3:		
			message="是否在定向流量包生效后使用";
			break;
		case 4:		
			message="是否使用定向流量";
			break;
		case 5:		
			message="是否在定向流量包限额内";
			break;
		case 6:		
			message="是否由空闲流量包";
			break;
		case 7:		
			message="是否在规定时间内使用";
			break;
		case 8:		
			message="是否在空闲流量包限额内";
			break;
		case 9:		
			message="是否有校园流量包";
			break;
		case 10:		
			message="是否在校园内使用";
			break;
		case 11:		
			message="是否在校园流量包限额内";
			break;
		case 12:		
			message="是否有单模流量";
			break;
		case 13:		
			message="是否在单模流量包生效后使用";
			break;
		case 14:		
			message="是否使用4G网";
			break;
			
		case 15:		
			message="是否在省内使用单模流量包";
			break;
		case 16:		
			message="是否在单模流量限额内";
			break;
		case 17:		
			message="是否有省内流量包";
			break;
		case 18:		
			message="是否在省内流量包生效后使用";
			break;
		case 19:		
			message="是否在省内使用省内流量包";
			break;
		case 20:		
			message="是否在省内流量包限额内";
			break;
		case 21:		
			message="是否有国内流量包";
			break;
		case 22:		
			message="是否在国内流量包生效后使用";
			break;
		case 23:		
			message="是否在国内流量包限额内";
			break;		
		default:
			break;
		}
		return message;
	}
}
