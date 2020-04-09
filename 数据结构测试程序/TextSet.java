package ���ݽṹ;

import java.util.*;

public class TextSet {

	public static void main(String[] args) {
		
		//����ɢ����HashSet����(���ڴ洢�޹�˳���Ԫ��)
		System.out.println("TextHashSet:��");
		Set<String> hashset = new HashSet<>();//����һ��ɢ����HashSet����
		
		//Ϊɢ�м��������
		hashset.add("Beijing");
		hashset.add("Shanghai");
		hashset.add("Shenzhen");
		hashset.add("Xiamen");
		
		System.out.println(hashset);
		
		//ʹ��for eachѭ�������������е�Ԫ��
		for (String s : hashset) {
			System.out.print(s.toUpperCase() + " ");
		}
		
		//ʹ��foreachѭ�������������е�Ԫ��
		System.out.println();
		hashset.forEach(e -> System.out.print(e.toLowerCase() + " "));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//������ʽɢ�м�LinkedHashSet�����ڴ洢�й�˳���Ԫ�أ�
		System.out.println("TextLinkedHashSet: ");
		Set<String> linkedhashset=new LinkedHashSet<>();//����һ����ʽɢ�м�
		
		//Ϊ��ʽɢ�м��������
		linkedhashset.add("Beijing");
		linkedhashset.add("Shanghai");
		linkedhashset.add("Shenzhen");
		linkedhashset.add("Xiamen");
		
		System.out.println(linkedhashset);
		
		for (String l : linkedhashset) {
			System.out.print(l.toUpperCase() + " ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		//�������μ�TreeSet��ʹ�洢��Ԫ���ܹ��Ƚϣ�
		System.out.println("TextTreeSet: ");
		TreeSet<String> treeset=new TreeSet<>(hashset);//����һ�����μ�,���������������
		
		System.out.println(treeset);
		
		for (String t : treeset) {
			System.out.print(t.toUpperCase() + " ");
		}
		
		System.out.println();
		//ʹ�����μ���������������
		System.out.println("first(): " + treeset.first());//���ص�һ��Ԫ��
		System.out.println("last(): " + treeset.last());//�������һ��Ԫ��
		System.out.println("headSet(\"Shenzhen\"): " + treeset.headSet("Shenzhen"));//����֮ǰ��Ԫ��
		System.out.println("tailSet(\"Shenzhen\"): " + treeset.tailSet("Shenzhen"));//����֮���Ԫ�أ���������
		System.out.println("lower(\"X\"): " + treeset.lower("X"));//����С��X�����Ԫ��
		System.out.println("higher(\"X\"): " + treeset.higher("X"));//���ش���X����СԪ��
		System.out.println("floor(\"X\"): " + treeset.floor("X"));//����С�ڻ����X�����Ԫ��
		System.out.println("ceiling(\"X\"): " + treeset.ceiling("X"));//���ش��ڻ����X����СԪ��
		System.out.println("pollFirst(): " + treeset.pollFirst());//ɾ����һ��Ԫ�ز�����
		System.out.println("polllast(): " + treeset.pollLast());//ɾ�����һ��Ԫ�ز�����
		System.out.println("New treeset: " + treeset);//
	}

}
