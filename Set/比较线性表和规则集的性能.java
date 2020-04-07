package demo;

import java.util.*;

public class �Ƚ����Ա�͹��򼯵����� {
	static final int N=5000;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//���Ա�
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<N;i++)
			list.add(i);
		Collections.shuffle(list);//�������Ա�
		
		//ɢ�м�
		Collection<Integer> hashSet=new HashSet<>(list);
		System.out.println("����ĳ���ڸ�ɢ�м����Ƿ������Ҫ "+gettestTime(hashSet)+" ��!");
		System.out.println("�����Ƴ�ɢ�м���Ҫ "+getremoveTime(hashSet)+" ��!");
		
		//��ʽɢ�м�
		Collection<Integer> linkedHashSet=new LinkedHashSet(list);
		System.out.println("����ĳ���ڸ���ʽɢ�м����Ƿ������Ҫ "+gettestTime(linkedHashSet)+" ��!");
		System.out.println("�����Ƴ���ʽɢ�м���Ҫ "+getremoveTime(linkedHashSet)+" ��!");
		
		//���μ�
		Collection<Integer> treeSet=new TreeSet(list);
		System.out.println("����ĳ���ڸ����μ����Ƿ������Ҫ "+gettestTime(treeSet)+" ��!");
		System.out.println("�����Ƴ����μ���Ҫ "+getremoveTime(treeSet)+" ��!");
		
		//�������Ա�
		Collection<Integer> arraylist=new ArrayList<>(list);
		System.out.println("����ĳ���ڸ����������Ա����Ƿ������Ҫ "+gettestTime(arraylist)+" ��!");
		System.out.println("�����Ƴ��������Ա���Ҫ "+getremoveTime(arraylist)+" ��!");
		
		//����
		Collection<Integer> linkedlist=new LinkedList<>(list);
		System.out.println("����ĳ���ڸ���������Ƿ������Ҫ "+gettestTime(linkedlist)+" ��!");
		System.out.println("�����Ƴ�������Ҫ "+getremoveTime(linkedlist)+" ��!");
	}
	private static long getremoveTime(Collection<Integer> c) {
		// TODO �Զ����ɵķ������
		long starttime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			c.remove(i);
		return System.currentTimeMillis()-starttime;
	}
	private static long gettestTime(Collection<Integer> c) {
		// TODO �Զ����ɵķ������
		long starttime=System.currentTimeMillis();
		for(int i=0;i<N;i++)
			c.contains((int)(Math.random()*2*N));
		return System.currentTimeMillis()-starttime;
	}

}
