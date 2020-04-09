package 数据结构;

import java.util.*;

public class SetListPerFormanceTest{
	static final int N=5000;
	public static void main(String[] args) {
		//线性表
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(i);
		Collections.shuffle(list);//打乱线性表
		
		//散列集
		Collection<Integer> hashSet=new HashSet<>(list);
		System.out.println("测试某数在该散列集中是否存在需要 "+gettestTime(hashSet)+" 秒!");
		System.out.println("测试移除散列集需要 "+getremoveTime(hashSet)+" 秒!");
		System.out.println();
		
		//链式散列集
		Collection<Integer> linkedHashSet=new LinkedHashSet(list);
		System.out.println("测试某数在该链式散列集中是否存在需要 "+gettestTime(linkedHashSet)+" 秒!");
		System.out.println("测试移除链式散列集需要 "+getremoveTime(linkedHashSet)+" 秒!");
		System.out.println();
		
		//树形集
		Collection<Integer> treeSet=new TreeSet(list);
		System.out.println("测试某数在该树形集中是否存在需要 "+gettestTime(treeSet)+" 秒!");
		System.out.println("测试移除树形集需要 "+getremoveTime(treeSet)+" 秒!");
		System.out.println();
		
		//数组线性表
		Collection<Integer> arraylist=new ArrayList<>(list);
		System.out.println("测试某数在该数组象线性表中是否存在需要 "+gettestTime(arraylist)+" 秒!");
		System.out.println("测试移除数组线性表需要 "+getremoveTime(arraylist)+" 秒!");
		System.out.println();
		
		//链表
		Collection<Integer> linkedlist=new LinkedList<>(list);
		System.out.println("测试某数在该链表表中是否存在需要 "+gettestTime(linkedlist)+" 秒!");
		System.out.println("测试移除链表需要 "+getremoveTime(linkedlist)+" 秒!");
	}
	private static long getremoveTime(Collection<Integer> c) {
		// TODO 自动生成的方法存根
		long starttime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			c.remove(i);
		return System.currentTimeMillis()-starttime;
	}
	private static long gettestTime(Collection<Integer> c) {
		// TODO 自动生成的方法存根
		long starttime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			c.contains((int)(Math.random()*2*N));
		return System.currentTimeMillis()-starttime;
	}

}
