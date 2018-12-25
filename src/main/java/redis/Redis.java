package redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class Redis {
 
	public static void main(String[] args) {
		//连接本地的Redis服务
		Jedis jedis = new Jedis("localhost",6379);
		jedis.auth("123456");
		//查看服务是否运行
		System.out.println("服务正在运行:"+jedis.ping());
		System.out.println("连接成功");
		
		
		
		//设置redis字符串数据
		jedis.set("A11", "a12");//key不存在添加
		jedis.set("A11", "a13");//修改 覆盖
		jedis.del("A1");//删除
		//查询存储的数据并输出
		System.out.println("A11="+jedis.get("A11"));
		
		
		 
		//存储数据到列表    添加集合列表
		jedis.lpush("B11", "b12");
		jedis.lpush("B11", "b13");
		jedis.lpush("B11", "b14");
		//获取存储的数据并输出
		List<String> list =jedis.lrange("B11", 0, 2);
		for(int i = 0 ; i< list.size();i++) {
			System.out.println("列表项为"+ list.get(i));
		}
		
		
		//获取数据并输出
		Set<String> keys =jedis.keys("*");
		for (String k : keys) {
			System.out.println(k);
			
		}
		
	}
}
